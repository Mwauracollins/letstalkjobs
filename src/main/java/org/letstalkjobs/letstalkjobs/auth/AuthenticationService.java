package org.letstalkjobs.letstalkjobs.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.letstalkjobs.letstalkjobs.Utils.TokenType;
import org.letstalkjobs.letstalkjobs.Utils.UserRole;
import org.letstalkjobs.letstalkjobs.config.JwtService;
import org.letstalkjobs.letstalkjobs.entities.ContactInformation;
import org.letstalkjobs.letstalkjobs.entities.Token;
import org.letstalkjobs.letstalkjobs.entities.userentities.Applicant;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;
import org.letstalkjobs.letstalkjobs.entities.userentities.Mentor;
import org.letstalkjobs.letstalkjobs.repositories.TokenRepository;
import org.letstalkjobs.letstalkjobs.repositories.UserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;

    public RegisterResponse register(@NotNull RegisterRequest request) {
        var user = BaseUser.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .userRole(request.getUserRole())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        ContactInformation contactInformation = new ContactInformation();
        contactInformation.setEmail(user.getEmail());
        contactInformation.setPhoneNumber(request.getPhoneNumber());
        contactInformation.setUser(user);

        user.setContactInformation(contactInformation);

        if (user.getUserRole() == UserRole.APPLICANT){
            Applicant applicant = new Applicant();
            applicant.setUser(user);
            user.setApplicant(applicant);
        } else if (user.getUserRole() == UserRole.MENTOR) {
            Mentor mentor = new Mentor();
            mentor.setUser(user);
            user.setMentor(mentor);
        }

        var savedUser = userRepository.save(user);

        //Generate JWT token
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        //Generate refresh token
        saveUserToken(savedUser, jwtToken);

        //Build  and return AuthenticationResponse
        return RegisterResponse.builder()
                .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                .build();
    }

    private void saveUserToken(BaseUser user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    public AuthenticationResponse authenticate(@NotNull AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    private void revokeAllUserTokens(@NotNull BaseUser user) {
        var validUserTokens = tokenRepository.findAllValidTokensByUser(user.getUserId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.userRepository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}

package org.simplifyinternships.simplifyinternships.auth;

import lombok.RequiredArgsConstructor;
import org.simplifyinternships.simplifyinternships.config.JwtService;
import org.simplifyinternships.simplifyinternships.entities.ContactInformation;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;
import org.simplifyinternships.simplifyinternships.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = new BaseUser.BaseUserBuilder(request.getEmail(), passwordEncoder.encode(request.getPassword()))
                .setFirstName(request.getFirstName())
                .setLastName(request.getLastName())
                .setUsername(request.getUsername())
                .setUserRole(request.getUserRole())
                .build();

        ContactInformation contactInformation = new ContactInformation();
        contactInformation.setEmail(user.getEmail());
        contactInformation.setUser(user);

        user.setContactInformation(contactInformation);

        userRepository.save(user);

        //Generate JWT token
        var jwtToken = jwtService.generateToken(user);

        //Build  and return AuthenticationResponse
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

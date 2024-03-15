package org.simplifyinternships.simplifyinternships.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/*
This class is a JWT authentication filter for Spring Security.
It intercepts incoming requests and checks for a JWT token in the Authorization header.
If a valid token is found, it extracts the user info from it and sets the user as authenticated in the security context.
This allows Spring Security to access user info during authorization decisions
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain
    ) throws ServletException, IOException {
        // Check for authorization header and extract jwt(if present)
        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response); // Continue processing if no valid Authorization header
            return;
        }
        // Extract user email from the JWT token
        final String jwt;
        jwt = authHeader.substring(7);
        // If valid user email and not already authenticated, perform authentication
        final String userEmail;
        userEmail = jwtService.extractUsername(jwt);
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);

            // Validate the JWT token using user details
            if (jwtService.isTokenValid(jwt, userDetails)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, // Principal (authenticated user)
                        null, //Credentials (not used here as JWT is the credential
                        userDetails.getAuthorities() // User's authorities (roles/permissions)
                );
                // Set additional authentication details (e.g., IP address)
                authenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                // Set the user as authenticated in the security context
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        // Continue processing the request through the filter chain
        filterChain.doFilter(request, response);
    }
}

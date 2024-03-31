package org.letstalkjobs.letstalkjobs.config;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.letstalkjobs.letstalkjobs.auditing.ApplicationAuditAware;
import org.letstalkjobs.letstalkjobs.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/*
This class is a Spring configuration class for user authentication.

It defines the following beans:

* UserDetailsService: Loads user details (including username and password) based on username.
* PasswordEncoder: Used for hashing and verifying user passwords securely.
* AuthenticationProvider: Handles user authentication using the UserDetailsService and PasswordEncoder.
* AuthenticationManager: Manages the authentication process within Spring Security.
*/

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final UserRepository userRepository;

    // Bean to define a UserDetailsService implementation
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    // defines a DaoAuthenticationProvider
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        // Configures the provider with UserDetailsService and PasswordEncoder
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordDecoder());
        return authenticationProvider;
    }

    // Defines a BCryptPasswordEncoder for secure password hashing
    @Bean
    public PasswordEncoder passwordDecoder() {
        return new BCryptPasswordEncoder();
    }

    // expose the AuthenticationManager from the AuthenticationConfiguration
    @Bean
    public AuthenticationManager authenticationManager(@NotNull AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    @Bean
    public AuditorAware<Integer> auditorAware(){
        return new ApplicationAuditAware();
    }
}

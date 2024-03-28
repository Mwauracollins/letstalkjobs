package org.letstalkjobs.letstalkjobs.config;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.letstalkjobs.letstalkjobs.auth.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static org.letstalkjobs.letstalkjobs.Utils.Permission.*;
import static org.letstalkjobs.letstalkjobs.Utils.UserRole.*;
import static org.springframework.http.HttpMethod.*;

/*
This class is responsible for configuring Spring Security.
Defines how the application handles authentication, authorization and logout functions
 */

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;
    private final LoginSuccessHandler loginSuccessHandler;

    // Whitelist of URLS that are allowed without authentication
    private static final String[] WHITE_LIST_URL = {
            "/**",
            "/contact/**",
            "/about/**",
            "/auth/**",
//            "/user/**"
    };
    @Bean
    public SecurityFilterChain securityFilterChain(@NotNull HttpSecurity httpSecurity) throws Exception {
        //Configure security rules using HttpSecurity
        httpSecurity
                .csrf(
                        //Disable built-in CSRF protection
                        AbstractHttpConfigurer::disable
                )
                .authorizeHttpRequests(
                        authRequest -> authRequest
                                .requestMatchers(WHITE_LIST_URL)
                                .permitAll()//Allow access to whitelisted urls without authentication

                                // Require admin roles to access the requested url and request methods
                                .requestMatchers("/management/**").hasAnyRole(ADMIN.name(), MANAGER.name())
                                .requestMatchers(GET, "/management/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
                                .requestMatchers(POST,"/management/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
                                .requestMatchers(PUT, "/management/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
                                .requestMatchers(DELETE, "/management/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())
//                        .anyRequest()
//                        .authenticated()
                )
                .sessionManagement(
                        session -> session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(
                        logout -> logout
                                .logoutUrl("/auth/logout")
                                .logoutSuccessUrl("auth/login")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler(((request, response, authentication) -> SecurityContextHolder.clearContext()))
                )
//                .formLogin(
//                        login -> login
////                                .loginPage("/auth/login")
//                                .usernameParameter("email")
//                                .passwordParameter("password")
//                                .successHandler(loginSuccessHandler)
//                                .failureUrl("/auth/login?error=true")
//                                .permitAll()
//                )
                ;
        return httpSecurity.build();
    }

}
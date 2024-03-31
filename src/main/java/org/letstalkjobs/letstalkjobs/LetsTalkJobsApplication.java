package org.letstalkjobs.letstalkjobs;

import org.letstalkjobs.letstalkjobs.Utils.UserRole;
import org.letstalkjobs.letstalkjobs.auth.AuthenticationService;
import org.letstalkjobs.letstalkjobs.auth.RegisterRequest;
import org.letstalkjobs.letstalkjobs.config.JwtService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class LetsTalkJobsApplication {
    public static void main(String[] args) {
        SpringApplication.run(LetsTalkJobsApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthenticationService service, JwtService jwtService){
        return args -> {
            var admin = RegisterRequest.builder()
                    .firstName("Admin")
                    .lastName("Admin")
                    .email("admin@yahoo.com")
                    .password("qwerty")
                    .userRole(UserRole.ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegisterRequest.builder()
                    .firstName("Mana")
                    .lastName("Ger")
                    .email("manager@gmail.com")
                    .password("1234qw")
                    .userRole(UserRole.MANAGER)
                    .build();
            var username = jwtService.extractUsername(service.register(manager).getAccessToken());
            System.out.println("Manager username: " + username);
        };
    }
}

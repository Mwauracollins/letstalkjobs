package org.simplifyinternships.simplifyinternships;

import org.simplifyinternships.simplifyinternships.Utils.UserRole;
import org.simplifyinternships.simplifyinternships.auth.AuthenticationService;
import org.simplifyinternships.simplifyinternships.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SimplifyInternshipsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimplifyInternshipsApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthenticationService service){
        return args -> {
            var admin = RegisterRequest.builder()
                    .username("AdminDawg")
                    .firstName("Admin")
                    .lastName("Admin")
                    .email("admin@yahoo.com")
                    .password("qwerty")
                    .userRole(UserRole.ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegisterRequest.builder()
                    .username("ManagerG")
                    .firstName("Mana")
                    .lastName("Ger")
                    .email("manager@gmail.com")
                    .password("1234qw")
                    .userRole(UserRole.MANAGER)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());
        };
    }
}

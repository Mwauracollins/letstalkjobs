package org.simplifyinternships.simplifyinternships;

import org.junit.jupiter.api.Test;
import org.simplifyinternships.simplifyinternships.Utils.UserRole;
import org.simplifyinternships.simplifyinternships.entities.userentities.Applicant;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;
import org.simplifyinternships.simplifyinternships.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser.BaseUserBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser(){
        String email = "collo@gmail.com";
        String password = "qwerty";
        BaseUserBuilder baseUserBuilder = new BaseUserBuilder(email, password)
                .setFirstName("Collo")
                .setLastName("Mwaura")
                .setUsername("collo1")
                .setUserRole(UserRole.APPLICANT);
        BaseUser user = new BaseUser(baseUserBuilder);
        user.setPassword(password);

        if (user.getUserRole() == UserRole.APPLICANT){
            Applicant applicant = new Applicant();
            applicant.setUser(user);
            user.setApplicant(applicant);

            BaseUser savedUser = userRepository.save(user);

            BaseUser existingUser = entityManager.find(BaseUser.class, savedUser.getUserId());
            assertThat(user.getEmail()).isEqualTo(existingUser.getEmail());
            assertEquals(user.getEmail(), savedUser.getEmail());
        }
    }
}

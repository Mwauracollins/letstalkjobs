package org.simplifyinternships.simplifyinternships.services;

import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;
import org.simplifyinternships.simplifyinternships.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser.BaseUserBuilder;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<BaseUser> getAllUsers(){
        return userRepository.findAll();
    }
    public BaseUser getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
//    public BaseUser createApplicant(String username, String firstName, String lastName, String email, String password) {
//        ApplicantBuilder applicantBuilder = (ApplicantBuilder) new ApplicantBuilder(email, password)
//                .setUsername(username)
//                .setFirstName(firstName)
//                .setLastName(lastName);
//        // Create an Applicant instance
//        Applicant applicant = new Applicant(applicantBuilder);
//
//        // Set the user for bidirectional relationship
//        applicant.getUser().setApplicant(applicant);
//        // Save the user to the database
//        return userRepository.save(applicant.getUser());
//    }
    public BaseUser createUser(String username, String firstName, String lastName, String email, String password){
        BaseUserBuilder baseUserBuilder = new BaseUserBuilder(email, password)
                .setUsername(username)
                .setFirstName(firstName)
                .setLastName(lastName);

        BaseUser user = new BaseUser(baseUserBuilder);
        return userRepository.save(user);
    }
}
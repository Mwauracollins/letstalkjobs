package org.simplifyinternships.simplifyinternships.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import org.simplifyinternships.simplifyinternships.entities.ContactInformation;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private ContactInformation contactInformation;
    private List<ExperienceResponse> currentExperience = new ArrayList<>();

    public UserResponse(UserResponseBuilder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contactInformation = builder.contactInformation;
        this.currentExperience = builder.currentExperience;
    }

    public static class UserResponseBuilder{
        private Integer id;
        private String username;
        private String firstName;
        private String lastName;
        private ContactInformation contactInformation;
        private List<ExperienceResponse> currentExperience;

        public UserResponseBuilder(Integer id){
            this.id = id;
        }
        public  UserResponseBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public  UserResponseBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public  UserResponseBuilder username(String username){
            this.username = username;
            return this;
        }
        public  UserResponseBuilder contactInformation(ContactInformation contactInformation){
            this.contactInformation = contactInformation;
            return this;
        }
        public  UserResponseBuilder currentExperience(List<ExperienceResponse> currentExperience){
            this.currentExperience = currentExperience;
            return this;
        }
        public  UserResponse build(){
            return new UserResponse(this);
        }
    }
}

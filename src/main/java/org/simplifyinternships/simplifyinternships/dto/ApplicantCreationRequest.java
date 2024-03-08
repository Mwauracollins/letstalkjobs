package org.simplifyinternships.simplifyinternships.dto;

import lombok.Getter;
import lombok.Setter;

public class ApplicantCreationRequest {
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;

}

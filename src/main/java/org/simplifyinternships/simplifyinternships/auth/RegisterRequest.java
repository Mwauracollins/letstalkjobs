package org.simplifyinternships.simplifyinternships.auth;

import lombok.Data;
import org.simplifyinternships.simplifyinternships.Utils.UserRole;

@Data
public class RegisterRequest {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserRole userRole;
}

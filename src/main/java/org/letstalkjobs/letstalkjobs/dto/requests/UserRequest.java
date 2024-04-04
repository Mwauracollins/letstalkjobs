package org.letstalkjobs.letstalkjobs.dto.requests;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.letstalkjobs.letstalkjobs.Utils.UserRole;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequest {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private UserRole userRole;
    private String password;
}

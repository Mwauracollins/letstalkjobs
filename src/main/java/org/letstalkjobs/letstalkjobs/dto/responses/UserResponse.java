package org.letstalkjobs.letstalkjobs.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.letstalkjobs.letstalkjobs.Utils.UserRole;
import org.letstalkjobs.letstalkjobs.entities.ContactInformation;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private UserRole userRole;
    private ContactInformation contactInformation;
    private List<ExperienceResponse> currentExperience = new ArrayList<>();

}

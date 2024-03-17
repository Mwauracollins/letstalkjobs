package org.simplifyinternships.simplifyinternships.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceResponse {
    private String companyName;
    private String position;
    private Date startDate;
    private Date endDate;
    private Boolean isCurrentRole;
}

package org.letstalkjobs.letstalkjobs.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceRequest {
    private String companyName;
    private String position;
    private Date startDate;
    private Date endDate;
    private Boolean isCurrentRole;
}

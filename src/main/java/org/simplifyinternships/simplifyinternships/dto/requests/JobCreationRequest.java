package org.simplifyinternships.simplifyinternships.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simplifyinternships.simplifyinternships.entities.Company;
import org.simplifyinternships.simplifyinternships.entities.jobentities.JobCategory;
import org.simplifyinternships.simplifyinternships.entities.jobentities.JobType;
import org.simplifyinternships.simplifyinternships.entities.jobentities.Position;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobCreationRequest {
    private String name;
    private Date startDate;
    private Date endDate;
    private Company company;
    private Position position;
    private JobCategory category;
    private JobType jobType;
}

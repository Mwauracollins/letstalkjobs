package org.letstalkjobs.letstalkjobs.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.letstalkjobs.letstalkjobs.Utils.JobType;
import org.letstalkjobs.letstalkjobs.entities.Company;
import org.letstalkjobs.letstalkjobs.entities.jobentities.JobCategory;
import org.letstalkjobs.letstalkjobs.entities.jobentities.JobSkill;
import org.letstalkjobs.letstalkjobs.entities.jobentities.Position;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobOpportunityRequest {
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Company company;
    private Position position;
    private JobCategory category;
    private JobType jobType;
    private List<JobSkill> jobSkills;
}

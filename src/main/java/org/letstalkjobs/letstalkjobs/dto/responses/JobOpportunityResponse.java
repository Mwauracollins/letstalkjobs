package org.letstalkjobs.letstalkjobs.dto.responses;

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
public class JobOpportunityResponse {
    private Integer id;
    private String name;
    private String description;
    private Company company;
    private Date startDate;
    private Date endDate;
    private Position position;
    private JobCategory category;
    private JobType jobType;
    private Date datePosted;
    private String expectedPay;
    private List<JobSkill> jobSkills;
}

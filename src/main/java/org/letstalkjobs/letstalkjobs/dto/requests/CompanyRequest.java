package org.letstalkjobs.letstalkjobs.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.letstalkjobs.letstalkjobs.entities.ContactInformation;
import org.letstalkjobs.letstalkjobs.entities.jobentities.JobOpportunity;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequest {
    private String companyName;
    private String companyDescription;
    private ContactInformation contactInformation;
    private List<JobOpportunity> jobOpportunities;
}

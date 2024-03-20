package org.simplifyinternships.simplifyinternships.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simplifyinternships.simplifyinternships.entities.ContactInformation;
import org.simplifyinternships.simplifyinternships.entities.jobentities.JobOpportunity;

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

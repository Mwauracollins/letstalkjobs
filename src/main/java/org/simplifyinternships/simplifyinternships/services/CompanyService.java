package org.simplifyinternships.simplifyinternships.services;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.simplifyinternships.simplifyinternships.dto.requests.CompanyRequest;
import org.simplifyinternships.simplifyinternships.dto.requests.JobOpportunityRequest;
import org.simplifyinternships.simplifyinternships.dto.responses.CompanyResponse;
import org.simplifyinternships.simplifyinternships.dto.responses.JobOpportunityResponse;
import org.simplifyinternships.simplifyinternships.entities.Company;
import org.simplifyinternships.simplifyinternships.entities.jobentities.JobOpportunity;
import org.simplifyinternships.simplifyinternships.repositories.CompanyRepository;
import org.simplifyinternships.simplifyinternships.repositories.JobOpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final JobOpportunityRepository jobOpportunityRepository;

    public List<CompanyResponse> getAllCompanies(){
        return companyRepository.findAll()
                .stream()
                .map(company -> CompanyResponse.builder()
                        .build()
                )
                .collect(Collectors.toList());
    }
    public CompanyResponse addCompany(@NotNull CompanyRequest request){
        var company = Company.builder()
                .companyName(request.getCompanyName())
                .companyDescription(request.getCompanyDescription())
                .build();

        companyRepository.save(company);
        return CompanyResponse.builder().build();
    }
    public List<JobOpportunityResponse> getCompanyJobs(@NotNull CompanyRequest companyRequest) {
        Company company = companyRepository.findByCompanyName(companyRequest.getCompanyName());

        if (company == null) {
            return Collections.emptyList();
        }
        return jobOpportunityRepository.findByCompany(company)
                .stream()
                .map(jobOpportunity -> JobOpportunityResponse.builder()
                        .build()
                )
                .collect(Collectors.toList());
    }
}

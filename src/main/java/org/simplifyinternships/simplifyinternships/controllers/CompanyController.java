package org.simplifyinternships.simplifyinternships.controllers;

import lombok.RequiredArgsConstructor;
import org.simplifyinternships.simplifyinternships.dto.requests.CompanyRequest;
import org.simplifyinternships.simplifyinternships.dto.requests.JobOpportunityRequest;
import org.simplifyinternships.simplifyinternships.dto.responses.CompanyResponse;
import org.simplifyinternships.simplifyinternships.dto.responses.JobOpportunityResponse;
import org.simplifyinternships.simplifyinternships.entities.Company;
import org.simplifyinternships.simplifyinternships.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public ResponseEntity<List<CompanyResponse>> getAllCompanies(){
        List<CompanyResponse> companyResponses = companyService.getAllCompanies();
        return ResponseEntity.ok(companyResponses);
    }
    @PostMapping("/add-company")
    public ResponseEntity<CompanyResponse> addCompany(
            @RequestBody CompanyRequest request
    ){
        return ResponseEntity.ok(companyService.addCompany(request));
    }
    @GetMapping("/jobs")
    public ResponseEntity<List<JobOpportunityResponse>> getAllCompanyJobs(
            @RequestParam("companyName") String companyName
    ){
        CompanyRequest companyRequest = new CompanyRequest();
        companyRequest.setCompanyName(companyName);

        List<JobOpportunityResponse> opportunityResponses = companyService.getCompanyJobs(companyRequest);
        return ResponseEntity.ok(opportunityResponses);
    }
}

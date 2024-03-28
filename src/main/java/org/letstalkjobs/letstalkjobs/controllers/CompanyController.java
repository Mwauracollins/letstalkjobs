package org.letstalkjobs.letstalkjobs.controllers;

import lombok.RequiredArgsConstructor;
import org.letstalkjobs.letstalkjobs.dto.requests.CompanyRequest;
import org.letstalkjobs.letstalkjobs.dto.responses.CompanyResponse;
import org.letstalkjobs.letstalkjobs.dto.responses.JobOpportunityResponse;
import org.letstalkjobs.letstalkjobs.services.CompanyService;
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
    @RequestMapping(value = "/add-company", method = RequestMethod.POST)
    public ResponseEntity<CompanyResponse> addCompany(
            @RequestBody CompanyRequest request
    ){
        return ResponseEntity.ok(companyService.addCompany(request));
    }
    @RequestMapping(value = "/jobs", method = RequestMethod.GET)
    public ResponseEntity<List<JobOpportunityResponse>> getAllCompanyJobs(
            @RequestParam("companyName") String companyName
    ){
        CompanyRequest companyRequest = new CompanyRequest();
        companyRequest.setCompanyName(companyName);

        List<JobOpportunityResponse> opportunityResponses = companyService.getCompanyJobs(companyRequest);
        return ResponseEntity.ok(opportunityResponses);
    }
}

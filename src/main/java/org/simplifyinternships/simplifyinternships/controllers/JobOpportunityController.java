package org.simplifyinternships.simplifyinternships.controllers;

import org.simplifyinternships.simplifyinternships.entities.jobentities.JobOpportunity;
import org.simplifyinternships.simplifyinternships.services.JobOpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobOpportunityController {
    private final JobOpportunityService jobOpportunityService;

    @Autowired
    public JobOpportunityController(JobOpportunityService jobOpportunityService) {
        this.jobOpportunityService = jobOpportunityService;
    }
    @GetMapping
    public List<JobOpportunity> getAllJobs(){
        return jobOpportunityService.getAllJobs();
    }
    @PostMapping
    public JobOpportunity addJob(@RequestBody JobOpportunity jobOpportunity){
        return jobOpportunityService.addJobOpportunity(jobOpportunity);
    }
}

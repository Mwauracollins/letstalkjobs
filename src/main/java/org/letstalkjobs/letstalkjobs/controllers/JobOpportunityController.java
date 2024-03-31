package org.letstalkjobs.letstalkjobs.controllers;

import org.letstalkjobs.letstalkjobs.entities.jobentities.JobOpportunity;
import org.letstalkjobs.letstalkjobs.services.JobOpportunityService;
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
    @RequestMapping(method = RequestMethod.GET)
    public List<JobOpportunity> getAllJobs(){
        return jobOpportunityService.getAllJobs();
    }
    @RequestMapping(value = "/post-a-job", method = RequestMethod.POST)
    public JobOpportunity addJob(@RequestBody JobOpportunity jobOpportunity){
        return jobOpportunityService.addJobOpportunity(jobOpportunity);
    }
}

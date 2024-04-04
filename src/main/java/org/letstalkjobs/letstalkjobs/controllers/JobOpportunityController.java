package org.letstalkjobs.letstalkjobs.controllers;

import lombok.RequiredArgsConstructor;
import org.letstalkjobs.letstalkjobs.Utils.JobType;
import org.letstalkjobs.letstalkjobs.dto.requests.ApplicationRequest;
import org.letstalkjobs.letstalkjobs.dto.requests.JobCategoryRequest;
import org.letstalkjobs.letstalkjobs.dto.requests.JobOpportunityRequest;
import org.letstalkjobs.letstalkjobs.dto.requests.PositionRequest;
import org.letstalkjobs.letstalkjobs.dto.responses.ApplicationResponse;
import org.letstalkjobs.letstalkjobs.dto.responses.JobOpportunityResponse;
import org.letstalkjobs.letstalkjobs.entities.jobentities.JobOpportunity;
import org.letstalkjobs.letstalkjobs.services.JobOpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobOpportunityController {
    private final JobOpportunityService jobOpportunityService;
    @GetMapping
    public String jobsPage(
            Model model
    ) {
        List<JobOpportunityResponse> jobs = jobOpportunityService.getAllJobs();
        model.addAttribute("jobs", jobs);

        return "job_listing";
    }
    @GetMapping(value = "/job-details/{jobId}")
    public String jobDetailsPage(
            @PathVariable("jobId") Integer jobId,
            Model model
    ){
        JobOpportunityResponse job = jobOpportunityService.getJobDetails(jobId);
        model.addAttribute("job", job);
        return "job_details";
    }

    @RequestMapping(value = "/post-a-job", method = RequestMethod.POST)
    public JobOpportunityResponse addJob(@RequestBody JobOpportunityRequest request){
        return jobOpportunityService.addJobOpportunity(request);
    }
    @RequestMapping(value = "filter-with-category")
    public List<JobOpportunityResponse> filterWithCategory(
            @RequestBody JobCategoryRequest request
    ){
        return jobOpportunityService.getJobsByCategory(request);
    }
    @RequestMapping(value = "filter-with-position")
    public List<JobOpportunityResponse> filterWithPosition(
            PositionRequest request){
        return jobOpportunityService.getJobsByPosition(request);
    }
    @RequestMapping(value = "filter-with-job-type")
    public List<JobOpportunityResponse> filterWithJobType(
            @RequestBody JobType jobType
    ){
        return jobOpportunityService.getJobsByJobType(jobType);
    }
    @PostMapping("/job-details/{jobId}/apply")
    public ApplicationResponse applyJob(
            @PathVariable("jobId") Integer jobId,
            @RequestBody ApplicationRequest request,
            Principal connectedUser
    ){
        return jobOpportunityService.applyToJob(connectedUser,jobId, request);
    }
}

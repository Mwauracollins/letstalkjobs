package org.letstalkjobs.letstalkjobs.services;

import org.letstalkjobs.letstalkjobs.entities.jobentities.JobOpportunity;
import org.letstalkjobs.letstalkjobs.repositories.JobOpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobOpportunityService {
    private final JobOpportunityRepository jobOpportunityRepository;

    @Autowired
    public JobOpportunityService(JobOpportunityRepository jobOpportunityRepository) {
        this.jobOpportunityRepository = jobOpportunityRepository;
    }
    public List<JobOpportunity> getAllJobs(){
        return jobOpportunityRepository.findAll();
    }

    public JobOpportunity addJobOpportunity(JobOpportunity jobOpportunity){
        //TODO: Add the business logic for creating different types of job types
        return jobOpportunityRepository.save(jobOpportunity);
    }
}

package org.simplifyinternships.simplifyinternships.services;

import org.simplifyinternships.simplifyinternships.entities.jobentities.JobOpportunity;
import org.simplifyinternships.simplifyinternships.entities.jobentities.JobType;
import org.simplifyinternships.simplifyinternships.repositories.JobOpportunityRepository;
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

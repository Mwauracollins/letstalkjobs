package org.simplifyinternships.simplifyinternships.services;

import org.simplifyinternships.simplifyinternships.entities.jobentities.JobCategory;
import org.simplifyinternships.simplifyinternships.repositories.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobCategoryService {
    private final JobCategoryRepository jobCategoryRepository;

    @Autowired
    public JobCategoryService(JobCategoryRepository jobCategoryRepository) {
        this.jobCategoryRepository = jobCategoryRepository;
    }
    public List<JobCategory> getAllCategories(){
        return jobCategoryRepository.findAll();
    }
    public JobCategory addJobCategory(JobCategory jobCategory){
        //TODO: Logic to ensure the instance is unique
        return jobCategoryRepository.save(jobCategory);
    }
}

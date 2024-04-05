package org.letstalkjobs.letstalkjobs.services;

import org.letstalkjobs.letstalkjobs.entities.jobentities.JobCategory;
import org.letstalkjobs.letstalkjobs.repositories.JobCategoryRepository;
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
        return jobCategoryRepository.save(jobCategory);
    }
}

package org.simplifyinternships.simplifyinternships.controllers;

import org.simplifyinternships.simplifyinternships.entities.jobentities.JobCategory;
import org.simplifyinternships.simplifyinternships.services.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job_category")
public class JobCategoryController {
    private final JobCategoryService jobCategoryService;

    @Autowired
    public JobCategoryController(JobCategoryService jobCategoryService) {
        this.jobCategoryService = jobCategoryService;
    }
    @GetMapping
    public List<JobCategory> getAllJobCategories(){
        return jobCategoryService.getAllCategories();
    }
    @PostMapping
    public JobCategory addJobCategory(@RequestBody JobCategory jobCategory){
        return jobCategoryService.addJobCategory(jobCategory);
    }
}

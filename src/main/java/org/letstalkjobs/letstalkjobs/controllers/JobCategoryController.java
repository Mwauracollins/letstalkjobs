package org.letstalkjobs.letstalkjobs.controllers;

import org.letstalkjobs.letstalkjobs.entities.jobentities.JobCategory;
import org.letstalkjobs.letstalkjobs.services.JobCategoryService;
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
    @GetMapping("/")
    public String category(){
        return "Category";
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

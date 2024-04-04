package org.letstalkjobs.letstalkjobs.controllers;

import lombok.RequiredArgsConstructor;
import org.letstalkjobs.letstalkjobs.dto.responses.JobOpportunityResponse;
import org.letstalkjobs.letstalkjobs.services.JobOpportunityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class AppController {
    private final JobOpportunityService jobOpportunityService;
    @GetMapping
    public String index(
            Model model
    ){
        List<JobOpportunityResponse> jobs = jobOpportunityService.getAllJobs();
        model.addAttribute("jobs", jobs);
        return "index";
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homepage(
            Model model
    ){
        List<JobOpportunityResponse> jobs = jobOpportunityService.getAllJobs();
        model.addAttribute("jobs", jobs);
        return "index";
    }
    @GetMapping(value = "/about", name = "about")
    public String about(
            Model model
    ){
        return "about";
    }
    @GetMapping(value = "/contact", name = "contact")
    public String contact(
            Model model
    ){

        return "contact_page";
    }

}

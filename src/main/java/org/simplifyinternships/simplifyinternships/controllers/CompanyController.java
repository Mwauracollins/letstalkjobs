package org.simplifyinternships.simplifyinternships.controllers;

import org.simplifyinternships.simplifyinternships.entities.Company;
import org.simplifyinternships.simplifyinternships.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }
    @PostMapping
    public Company addCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }
}

package org.simplifyinternships.simplifyinternships.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppController {
    @GetMapping(name = "/home")
    public String homepage(){
        return "homepage";
    }
    @GetMapping(value = "/about", name = "about")
    public String about(){
        return "about";
    }
    @GetMapping(value = "/contact", name = "contact")
    public String contact(){
        return "contact";
    }

}

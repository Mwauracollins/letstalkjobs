package org.letstalkjobs.letstalkjobs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AppController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
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

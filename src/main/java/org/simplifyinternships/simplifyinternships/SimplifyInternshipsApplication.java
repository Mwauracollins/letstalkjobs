package org.simplifyinternships.simplifyinternships;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class SimplifyInternshipsApplication {
    @RequestMapping("/")
    public String contact() {
        return "contact";
    }
    @RequestMapping(value = "homepage", name = "homepage")
    public String homepage(){
        return "homepage";
    }

    public static void main(String[] args) {
        SpringApplication.run(SimplifyInternshipsApplication.class, args);
    }

}

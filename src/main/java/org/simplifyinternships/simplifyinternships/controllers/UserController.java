package org.simplifyinternships.simplifyinternships.controllers;

import org.simplifyinternships.simplifyinternships.dto.ApplicantCreationRequest;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;
import org.simplifyinternships.simplifyinternships.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/")
    public String helloUser(){
        return "Hello user";
    }
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/createApplicant")
    public BaseUser createUser(@RequestBody ApplicantCreationRequest request){
        return userService.createUser(
                request.getUsername(),
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword()
        );
    }
}

package org.simplifyinternships.simplifyinternships.controllers;

import org.simplifyinternships.simplifyinternships.auth.ChangePasswordRequest;
import org.simplifyinternships.simplifyinternships.dto.ApplicantCreationRequest;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;
import org.simplifyinternships.simplifyinternships.services.BaseUserService;
import org.simplifyinternships.simplifyinternships.services.UserService;
import org.simplifyinternships.simplifyinternships.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @PatchMapping
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
            ){
        userService.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }
}

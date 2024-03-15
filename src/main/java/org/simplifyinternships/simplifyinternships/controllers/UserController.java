package org.simplifyinternships.simplifyinternships.controllers;

import org.simplifyinternships.simplifyinternships.auth.ChangePasswordRequest;
import org.simplifyinternships.simplifyinternships.services.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

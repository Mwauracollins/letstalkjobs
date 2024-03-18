package org.simplifyinternships.simplifyinternships.controllers.auth;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.simplifyinternships.simplifyinternships.auth.AuthenticationRequest;
import org.simplifyinternships.simplifyinternships.auth.AuthenticationResponse;
import org.simplifyinternships.simplifyinternships.auth.AuthenticationService;
import org.simplifyinternships.simplifyinternships.auth.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
/*
TODO:Add logout
 */
@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @GetMapping("/register")
    public String register(@NotNull Model model){
        model.addAttribute("message", "Welcome to the register page");
        return "registerstudent";
    }
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){

        return  ResponseEntity.ok(authenticationService.register(request));
    }
    @GetMapping("/login")
    public String authenticate(@NotNull Model model){
        model.addAttribute("message", "Welcome to the register page");
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}

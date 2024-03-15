package org.simplifyinternships.simplifyinternships.controllers.auth;

import lombok.RequiredArgsConstructor;
import org.simplifyinternships.simplifyinternships.auth.AuthenticationRequest;
import org.simplifyinternships.simplifyinternships.auth.AuthenticationResponse;
import org.simplifyinternships.simplifyinternships.auth.AuthenticationService;
import org.simplifyinternships.simplifyinternships.auth.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @GetMapping("/register")
    public String register(){
        return "Hello";
    }
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return  ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}

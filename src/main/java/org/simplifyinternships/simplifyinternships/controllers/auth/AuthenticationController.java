package org.simplifyinternships.simplifyinternships.controllers.auth;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.simplifyinternships.simplifyinternships.auth.AuthenticationRequest;
import org.simplifyinternships.simplifyinternships.auth.AuthenticationResponse;
import org.simplifyinternships.simplifyinternships.auth.AuthenticationService;
import org.simplifyinternships.simplifyinternships.auth.RegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        authenticationService.register(request);

        return  ResponseEntity.status(HttpStatus.CREATED).build();
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
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(request);

        return ResponseEntity.ok(authenticationResponse);
    }
    //Method to redirect to homepage
    @GetMapping("/redirecthome")
    @ResponseStatus(HttpStatus.FOUND) //HTTP 302 FOUND STATUS CODE
    public String redirectHome(RedirectAttributes attributes) {
        attributes.addFlashAttribute("message","Redirected to homepage");
        return "redirect:/";
    }

}

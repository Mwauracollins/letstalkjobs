package org.letstalkjobs.letstalkjobs.controllers.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.letstalkjobs.letstalkjobs.auth.*;
import org.letstalkjobs.letstalkjobs.config.LogoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

/*
TODO:Add logout
 */
@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final LogoutService logoutService;

    @GetMapping(value = "/register")
    public String showRegisterPage(@NotNull Model model){
        model.addAttribute("message", "Welcome to the register page");
        return "register";
    }

    @PostMapping(value = "/register")
    public ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest request,
            Model model,
            BindingResult bindingResult
    ){
        RegisterResponse registerResponse = authenticationService.register(request);

        return  ResponseEntity.ok(registerResponse);
    }
    @GetMapping(value = "/login")
    public String showLoginPage(
            @NotNull Model model
    ){
        model.addAttribute("message", "Welcome to the register page");
        return "login";
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request,
            HttpServletResponse response
    ){
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(request);
        response.addCookie(createCookie("access_token", authenticationResponse.getAccessToken()));
        response.addCookie(createCookie("refresh_token", authenticationResponse.getRefreshToken()));

        return ResponseEntity.ok(authenticationResponse);
    }
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication,
            RedirectAttributes redirectAttributes
    ) {
        try{
            logoutService.logout(request, response, authentication);
            return "redirect:/auth/login";
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("error", "Error occurred during logout");
            return "redirect:/auth/login";
        }
    }
    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated();

    }

    @PostMapping(value = "/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        authenticationService.refreshToken(request, response);
    }
    private @NotNull Cookie createCookie(String name, String value){
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);
        return cookie;
    }
}

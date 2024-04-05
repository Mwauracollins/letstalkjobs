package org.letstalkjobs.letstalkjobs.controllers.auth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.letstalkjobs.letstalkjobs.auth.*;
import org.letstalkjobs.letstalkjobs.config.JwtService;
import org.letstalkjobs.letstalkjobs.config.LogoutService;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;
import org.letstalkjobs.letstalkjobs.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final LogoutService logoutService;
    private final JwtService jwtService;
    private UserService userService;

    @GetMapping(value = "/register")
    public String showRegisterPage(
            @NotNull Model model,
            HttpServletRequest request,
            Principal connectedUser){
        model.addAttribute("message", "Welcome to the register page");
        if (isAuthenticated(request, connectedUser)){

            return "redirect:/home";
        }
        return "register";
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest request,
            Model model,
            BindingResult bindingResult
    ){
        try{
            RegisterResponse registerResponse = authenticationService.register(request);
            return  ResponseEntity.ok(registerResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to register");
        }

    }
    @GetMapping(value = "/login")
    public String showLoginPage(
            @NotNull Model model,
            HttpServletRequest request,
            Principal connectedUser
    ){
        model.addAttribute("message", "Welcome to the login page");
        if (isAuthenticated(request, connectedUser)){

            return "redirect:/home";
        }
        return "login";
    }


    public ResponseEntity<?> authenticate(
            @RequestBody AuthenticationRequest request,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Principal connectedUser
    ){
        try {
            if (!isAuthenticated(httpServletRequest, connectedUser)) {
                return ResponseEntity.ok("redirect:/home");
            }
            AuthenticationResponse authenticationResponse = authenticationService.authenticate(request);
            httpServletResponse.addCookie(createCookie("access_token", authenticationResponse.getAccessToken()));
            httpServletResponse.addCookie(createCookie("refresh_token", authenticationResponse.getRefreshToken()));

            var email = jwtService.extractUsername(authenticationResponse.getAccessToken());

            return ResponseEntity.ok(authenticationResponse);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to login");
        }
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
    private boolean isAuthenticated(HttpServletRequest request, Principal connectedUser) {
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        if (((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal() == null){
            return false;
        }

        Cookie[] cookies = request.getCookies();
        String accessToken = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("access_token".equals(cookie.getName())) {
                    accessToken = cookie.getValue();
                    break;
                }
            }
        }else {
            return false;
        }
        if (accessToken == null) {
            return false;
        }
        if (!jwtService.isTokenValid(accessToken, user)) {
            return false;
        }
        return true;
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

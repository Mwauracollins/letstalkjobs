package org.simplifyinternships.simplifyinternships.controllers;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.simplifyinternships.simplifyinternships.auth.ChangePasswordRequest;
import org.simplifyinternships.simplifyinternships.dto.requests.ContactInformationRequest;
import org.simplifyinternships.simplifyinternships.dto.requests.EducationRequest;
import org.simplifyinternships.simplifyinternships.dto.requests.ExperienceRequest;
import org.simplifyinternships.simplifyinternships.dto.requests.UserSkillRequest;
import org.simplifyinternships.simplifyinternships.dto.responses.ContactInformationResponse;
import org.simplifyinternships.simplifyinternships.dto.responses.EducationResponse;
import org.simplifyinternships.simplifyinternships.dto.responses.ExperienceResponse;
import org.simplifyinternships.simplifyinternships.dto.responses.UserSkillResponse;
import org.simplifyinternships.simplifyinternships.entities.Experience;
import org.simplifyinternships.simplifyinternships.services.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping("/")
    public String userPage(@NotNull Model model){
        model.addAttribute("message", "Welcome you");
        return "student";
    }

    @PatchMapping
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
            ){
        userService.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/experience")
    public ResponseEntity<List<ExperienceResponse>> getUserExperiences(
            @RequestBody ExperienceRequest request,
            Principal connectedUser
    ){
        List<ExperienceResponse> experienceResponses = userService.getCurrentExperienceList(request, connectedUser);
        return ResponseEntity.ok(experienceResponses);
    }

    private @NotNull ExperienceResponse mapExperienceToResponse(@NotNull Experience experience) {
        ExperienceResponse experienceResponse = new ExperienceResponse();
        experienceResponse.setCompanyName(experience.getCompanyName());
        experienceResponse.setPosition(experience.getPosition());
        experienceResponse.setStartDate(experience.getStartDate());
        experienceResponse.setEndDate(experience.getEndDate());
        experienceResponse.setIsCurrentRole(experience.getIsCurrentRole());

        return experienceResponse;
    }

    @PostMapping("/add-experience")
    public ResponseEntity<ExperienceResponse> addExperience(
            @RequestBody @NotNull ExperienceRequest request,
            Principal connectedUser
            ){
        return ResponseEntity.ok(userService.addUserExperience(request, connectedUser));
    }
    @PatchMapping("/update-experience")
    public ResponseEntity<ExperienceResponse> updateUserExperience(
            @RequestBody ExperienceRequest request,
            Principal connectedUser
    ){
        return ResponseEntity.ok(userService.updateUserExperience(request, connectedUser));
    }
    @GetMapping("/education")
    public ResponseEntity<List<EducationResponse>> getUserEducationBackground(
            @RequestBody EducationRequest request,
            Principal connectedUser
            ){
        List<EducationResponse> educationResponses = userService.getEducationList(request, connectedUser);
        return ResponseEntity.ok(educationResponses);
    }
    @PostMapping("/add-education")
    public ResponseEntity<EducationResponse> addEducationBackground(
            @RequestBody EducationRequest request,
            Principal connectedUser
    ){
        return ResponseEntity.ok(userService.addEducationBackground(request, connectedUser));
    }
    @GetMapping("skills")
    public ResponseEntity<List<UserSkillResponse>> getUserSkills(
            @RequestBody UserSkillRequest request,
            Principal connectedUser
            ){
        List<UserSkillResponse> userSkillResponses = userService.getUserSkillsList(request, connectedUser);
        return ResponseEntity.ok(userSkillResponses);
    }
    @PostMapping("/add-skill")
    public ResponseEntity<UserSkillResponse> addUserSkill(
            @RequestBody UserSkillRequest request,
            Principal connectedUser
    ){
        return ResponseEntity.ok(userService.addUserSkill(request, connectedUser));
    }
    @GetMapping("/contact-information")
    public ResponseEntity<ContactInformationResponse> getUserContactInformation(
            @RequestBody ContactInformationRequest request,
            Principal connectedUser
            ){
        return ResponseEntity.ok(userService.getUserContactInformation(request, connectedUser));
    }
    @PatchMapping("/change-contact-information")
    public ResponseEntity<ContactInformationResponse> updateContactInformation(
            @RequestBody ContactInformationRequest request,
            Principal connectedUser
    ){
        return ResponseEntity.ok(userService.updateContactInformation(request, connectedUser));
    }

}

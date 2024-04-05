package org.letstalkjobs.letstalkjobs.controllers;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.letstalkjobs.letstalkjobs.Utils.UserRole;
import org.letstalkjobs.letstalkjobs.auth.ChangePasswordRequest;
import org.letstalkjobs.letstalkjobs.dto.requests.*;
import org.letstalkjobs.letstalkjobs.dto.responses.*;
import org.letstalkjobs.letstalkjobs.entities.Experience;
import org.letstalkjobs.letstalkjobs.entities.Resume;
import org.letstalkjobs.letstalkjobs.entities.userentities.Applicant;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;
import org.letstalkjobs.letstalkjobs.services.ResumeService;
import org.letstalkjobs.letstalkjobs.services.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    private final ResumeService resumeService;

    @GetMapping("")
    public String userPage(@NotNull Model model){
        model.addAttribute("message", "Welcome you");
        return "student";
    }

    @PatchMapping("/change-password")
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
            ){
        userService.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/experience")
    public ResponseEntity<?> getUserExperiences(
            @RequestBody ExperienceRequest request,
            Principal connectedUser
    ){
        try {
            List<ExperienceResponse> experienceResponses = userService.getCurrentExperienceList(request, connectedUser);
            return ResponseEntity.ok(experienceResponses);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unabla to get user experiences");
        }
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
    @GetMapping("/skills")
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

    @GetMapping("/applications")
    public ResponseEntity<List<ApplicationResponse>> getUserApplications(
            @RequestBody ApplicationRequest request,
            Principal connectedUser
    ){
        if (userService.getUserRole((Authentication) connectedUser).equals(UserRole.APPLICANT)){
            List<ApplicationResponse> applicationResponses = userService.getUserApplication(request, connectedUser);
            return ResponseEntity.ok(applicationResponses);
        }
        return null;
    }
    @GetMapping("/{firstName}")
    public ResponseEntity<?> getUserDetails(
            @PathVariable("firstName") String firstName,
            Principal connectedUser
    ) {
        try {
            var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

            firstName = user.getFirstName();

            var userDetails = userService.getUserDetails(connectedUser);

            return  ResponseEntity.ok(userDetails);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No user details acquired");
        }
    }

    @PostMapping("/{userId}/upload-resume")
    public ResponseEntity<?> uploadResume(
            @PathVariable("userId") Integer userId,
            @RequestParam("file")MultipartFile file,
            Principal connectedUser
            ) {
        try {
            var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
            Applicant applicant = user.getApplicant();

            if (user != null){
                resumeService.uploadResume(applicant, file);
                return ResponseEntity.ok("Resume Uploaded Successfully");
            }else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Upload Resume");
        }
    }
    @GetMapping("/{userId}/resume")
    public ResponseEntity<?> getUserResume(
            @PathVariable("userId") Integer userId,
            Principal connectedUser
    ){
        try {
            var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
            if (user != null){
                Resume resume = userService.getUserResume(connectedUser);

                return ResponseEntity.ok(resume);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get User resume");
        }
    }


}

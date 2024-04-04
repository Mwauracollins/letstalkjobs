package org.letstalkjobs.letstalkjobs.services.impl;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.letstalkjobs.letstalkjobs.Utils.UserRole;
import org.letstalkjobs.letstalkjobs.auth.ChangePasswordRequest;
import org.letstalkjobs.letstalkjobs.dto.requests.*;
import org.letstalkjobs.letstalkjobs.dto.responses.*;
import org.letstalkjobs.letstalkjobs.entities.Education;
import org.letstalkjobs.letstalkjobs.entities.Experience;
import org.letstalkjobs.letstalkjobs.entities.Resume;
import org.letstalkjobs.letstalkjobs.entities.UserSkill;
import org.letstalkjobs.letstalkjobs.entities.userentities.Applicant;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;
import org.letstalkjobs.letstalkjobs.repositories.*;
import org.letstalkjobs.letstalkjobs.services.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ExperienceRepository experienceRepository;
    private final EducationRepository educationRepository;
    private final UserSkillRepository userSkillRepository;
    private final ContactInformationRepository contactInformationRepository;
    private final ApplicationRepository applicationRepository;
    private final  ResumeRepository resumeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<BaseUser> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public List<UserRequest> findAllUsers() {
        List<BaseUser> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private @NotNull UserRequest mapToUserDto(@NotNull BaseUser user) {
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername(user.getUsername());
        userRequest.setEmail(user.getEmail());
        userRequest.setFirstName(user.getFirstName());
        userRequest.setLastName(user.getLastName());
        return userRequest;
    }
    public void changePassword(
            @NotNull ChangePasswordRequest request,
            Principal connectedUser
    ){
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        //check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())){
            throw new IllegalStateException("Wrong Password");
        }
        //check if the new password matches the confirm password
        if (!passwordEncoder.matches(request.getNewPassword(), request.getConfirmNewPassword())){
            throw new IllegalStateException("Passwordds do not match");
        }
        //update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        userRepository.save(user);
    }

    //TODO: Add parameter to check if it is adminRequest
    public List<ExperienceResponse> getCurrentExperienceList(
            @NotNull ExperienceRequest request,
            Principal connectedUser
    ){

        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        return experienceRepository.findByUser(user)
                .stream()
                .map(experience -> ExperienceResponse.builder()
                        .companyName(experience.getCompanyName())
                        .position(experience.getPosition())
                        .startDate(experience.getStartDate())
                        .endDate(experience.getEndDate())
                        .isCurrentRole(experience.getIsCurrentRole())
                        .build()
                )
                .collect(Collectors.toList());
    }
    public ExperienceResponse addUserExperience(
            @NotNull ExperienceRequest request,
            Principal connectedUser
    ){
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        var experience = Experience.builder()
                .companyName(request.getCompanyName())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .position(request.getPosition())
                .isCurrentRole(request.getIsCurrentRole())
                .user(user)
                .build();

        experienceRepository.save(experience);

        return ExperienceResponse.builder()
                .companyName(experience.getCompanyName())
                .startDate(experience.getStartDate())
                .endDate(experience.getEndDate())
                .position(experience.getPosition())
                .isCurrentRole(experience.getIsCurrentRole())
                .build();
    }
    public ExperienceResponse updateUserExperience(
            @NotNull ExperienceRequest request,
            Principal connectedUser
    ){
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        var experience = experienceRepository.findByUserAndCompanyName(user, request.getCompanyName());
        experience.setCompanyName(request.getCompanyName());
        experience.setPosition(request.getPosition());
        experience.setStartDate(request.getStartDate());
        experience.setEndDate(request.getEndDate());
        experience.setIsCurrentRole(request.getIsCurrentRole());
        //TODO: Check if the logic is correct for finding one experience for user
        return ExperienceResponse.builder()
                .companyName(experience.getCompanyName())
                .position(experience.getPosition())
                .build();

    }
    public List<EducationResponse> getEducationList(
            EducationRequest request,
            Principal connectedUser
            ){
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        return educationRepository.findByUser(user)
                .stream()
                .map(education -> EducationResponse.builder()
                        //TODO: Add mappings to response from request
                        .build()
                )
                .collect(Collectors.toList());
    }
    public EducationResponse addEducationBackground(
            @NotNull EducationRequest request,
            Principal connectedUser
    ){
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        var education = Education.builder()
                .major(request.getMajor())
                .university(request.getUniversity())
                .startYear(request.getStartYear())
                .endYear(request.getEndYear())
                .user(user)
                .build();

        educationRepository.save(education);
        return EducationResponse.builder()
                .major(education.getMajor())
                .build();
    }
    public List<UserSkillResponse> getUserSkillsList(
            UserSkillRequest request,
            Principal connectedUser
    ){
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        return userSkillRepository.findByUser(user)
                .stream()
                .map(userSkill -> UserSkillResponse.builder()
                        .skillName(request.getSkillName())
                        //TODO: Add mappings from request to response
                        .build()
                )
                .collect(Collectors.toList());
    }
    public UserSkillResponse addUserSkill(
            @NotNull UserSkillRequest request,
            Principal connectedUser
    ){
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        var userSkill = new UserSkill();
        userSkill.setSkillName(request.getSkillName());
        userSkill.setUser(user);
        userSkillRepository.save(userSkill);

        return UserSkillResponse.builder()
                .skillName(userSkill.getSkillName())
                .build();
    }
    //TODO: Check the logic
    public ContactInformationResponse getUserContactInformation(
            ContactInformationRequest request,
            Principal connectedUser
    ){
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        contactInformationRepository.findByUser(user);

        return ContactInformationResponse.builder()
                .build();
    }
    public ContactInformationResponse updateContactInformation(
            @NotNull ContactInformationRequest request,
            Principal connectedUser
    ){
        //TODO: Check to verify which details are updatable -- Email is not changeable
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        var userContact = contactInformationRepository.findByUser(user);
        userContact.setEmail(request.getEmail());

        contactInformationRepository.save(userContact);
        return ContactInformationResponse.builder()
                .email(userContact.getEmail())
                .build();

    }

    public List<ApplicationResponse> getUserApplication(
            ApplicationRequest request,
            Principal connectedUser
    ) {
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        return applicationRepository.findByApplicant(user.getApplicant())
                .stream()
                .map(application -> ApplicationResponse.builder()
                        .applicationDate(application.getApplicationDate())
                        .build()
                )
                .collect(Collectors.toList());


    }
    public UserRole getUserRole(@NotNull Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities){
            if (authority.getAuthority().equals(UserRole.APPLICANT.name())){
                return UserRole.APPLICANT;
            } else if (authority.getAuthority().equals(UserRole.MENTOR.name())) {
                return UserRole.MENTOR;
            }
        }
        return null;
    }
    public UserResponse getUserDetails(
            Principal connectedUser
    ) {
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        return (UserResponse) userRepository.findByEmail(user.getEmail())
                .stream()
                .map(logged_user -> UserResponse.builder()
                        .userRole(logged_user.getUserRole())
                        .build());
    }
    public Resume getUserResume(
            Principal connectedUser
    ) {
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        Applicant applicant = user.getApplicant();

        if (applicant != null){
            return resumeRepository.findByApplicant(applicant);
        }else {
            return null;
        }
    }
}

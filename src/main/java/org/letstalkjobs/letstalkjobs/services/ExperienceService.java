package org.letstalkjobs.letstalkjobs.services;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.letstalkjobs.letstalkjobs.dto.requests.ExperienceRequest;
import org.letstalkjobs.letstalkjobs.dto.responses.ExperienceResponse;
import org.letstalkjobs.letstalkjobs.entities.Experience;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;
import org.letstalkjobs.letstalkjobs.repositories.ExperienceRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceService {
    private final ExperienceRepository experienceRepository;

    public List<Experience> getUserExperienceForUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()){
            BaseUser currentUser = (BaseUser) authentication.getPrincipal();
            return experienceRepository.findByUser(currentUser)
                    .stream()
                    .toList();
        }
        return Collections.emptyList();
    }

    public ExperienceResponse addExperience(@NotNull ExperienceRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        BaseUser user = (BaseUser) authentication.getPrincipal();
        var experience = Experience.builder()
                .companyName(request.getCompanyName())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .position(request.getPosition())
                .isCurrentRole(request.getIsCurrentRole())
                .user(user)
                .build();
        var savedExperience = experienceRepository.save(experience);
        return ExperienceResponse.builder()
                .companyName(experience.getCompanyName())
                .startDate(experience.getStartDate())
                .endDate(experience.getEndDate())
                .position(experience.getPosition())
                .isCurrentRole(experience.getIsCurrentRole())
                .build();
    }
}

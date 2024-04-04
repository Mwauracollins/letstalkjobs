package org.letstalkjobs.letstalkjobs.services;

import lombok.RequiredArgsConstructor;
import org.letstalkjobs.letstalkjobs.Utils.JobType;
import org.letstalkjobs.letstalkjobs.dto.requests.ApplicationRequest;
import org.letstalkjobs.letstalkjobs.dto.requests.JobCategoryRequest;
import org.letstalkjobs.letstalkjobs.dto.requests.JobOpportunityRequest;
import org.letstalkjobs.letstalkjobs.dto.requests.PositionRequest;
import org.letstalkjobs.letstalkjobs.dto.responses.ApplicationResponse;
import org.letstalkjobs.letstalkjobs.dto.responses.JobOpportunityResponse;
import org.letstalkjobs.letstalkjobs.entities.jobentities.*;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;
import org.letstalkjobs.letstalkjobs.repositories.JobOpportunityRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
//TODO: Add more fields to the builder map
@Service
@RequiredArgsConstructor
public class JobOpportunityService {
    private final JobOpportunityRepository jobOpportunityRepository;

    public List<JobOpportunityResponse> getAllJobs(){
        return jobOpportunityRepository.findAll()
                .stream()
                .map(jobOpportunity -> JobOpportunityResponse.builder()
                        .id(jobOpportunity.getJobId())
                        .description(jobOpportunity.getDescription())
                        .name(jobOpportunity.getName())
                        .company(jobOpportunity.getCompany())
                        .startDate(jobOpportunity.getStartDate())
                        .endDate(jobOpportunity.getEndDate())
                        .jobType(jobOpportunity.getJobType())
                        .category(jobOpportunity.getCategory())
                        .position(jobOpportunity.getPosition())
                        .datePosted(jobOpportunity.getDatePosted())
                        .expectedPay(jobOpportunity.getExpectedPay())
                        .build()
                )
                .collect(Collectors.toList());
    }
    public JobOpportunityResponse addJobOpportunity(JobOpportunityRequest request){
        JobOpportunity jobOpportunity = JobOpportunity.builder()
                .name(request.getName())
                .position(request.getPosition())
                .jobType(request.getJobType())
                .company(request.getCompany())
                .category(request.getCategory())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .datePosted(new Date())
                .build();
        if (jobOpportunity.getJobType() == JobType.ATTACHMENT){
            Attachment attachment = Attachment.builder()
                    .jobOpportunity(jobOpportunity)
                    .build();
            jobOpportunity.setAttachment(attachment);
        } else if (jobOpportunity.getJobType() == JobType.INTERNSHIP) {
            Internship internship = Internship.builder()
                    .jobOpportunity(jobOpportunity)
                    .build();
            jobOpportunity.setInternship(internship);
        }//TODO: Add entity saving for full time jobs

        jobOpportunityRepository.save(jobOpportunity);

        return JobOpportunityResponse.builder()
                .id(jobOpportunity.getJobId())
                .description(jobOpportunity.getDescription())
                .name(jobOpportunity.getName())
                .company(jobOpportunity.getCompany())
                .startDate(jobOpportunity.getStartDate())
                .endDate(jobOpportunity.getEndDate())
                .jobType(jobOpportunity.getJobType())
                .category(jobOpportunity.getCategory())
                .position(jobOpportunity.getPosition())
                .datePosted(jobOpportunity.getDatePosted())
                .expectedPay(jobOpportunity.getExpectedPay())
                .build();

    }

    public List<JobOpportunityResponse> searchJobByName(String name){
        return jobOpportunityRepository.findByName(name)
                .stream()
                .map(jobOpportunity -> JobOpportunityResponse.builder()
                        .id(jobOpportunity.getJobId())
                        .description(jobOpportunity.getDescription())
                        .name(jobOpportunity.getName())
                        .company(jobOpportunity.getCompany())
                        .startDate(jobOpportunity.getStartDate())
                        .endDate(jobOpportunity.getEndDate())
                        .jobType(jobOpportunity.getJobType())
                        .category(jobOpportunity.getCategory())
                        .position(jobOpportunity.getPosition())
                        .datePosted(jobOpportunity.getDatePosted())
                        .expectedPay(jobOpportunity.getExpectedPay())
                        .build()
                )
                .collect(Collectors.toList());
    }

    public List<JobOpportunityResponse> getJobsByCategory(
            JobCategoryRequest request
    ){
        JobCategory jobCategory = JobCategory.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();

        return jobOpportunityRepository.findByCategory(jobCategory)
                .stream()
                .map(jobOpportunity -> JobOpportunityResponse.builder()
                        .id(jobOpportunity.getJobId())
                        .description(jobOpportunity.getDescription())
                        .name(jobOpportunity.getName())
                        .company(jobOpportunity.getCompany())
                        .startDate(jobOpportunity.getStartDate())
                        .endDate(jobOpportunity.getEndDate())
                        .jobType(jobOpportunity.getJobType())
                        .category(jobOpportunity.getCategory())
                        .position(jobOpportunity.getPosition())
                        .datePosted(jobOpportunity.getDatePosted())
                        .expectedPay(jobOpportunity.getExpectedPay())
                        .build()
                )
                .collect(Collectors.toList());
    }
    public List<JobOpportunityResponse> getJobsByJobType(
            JobType jobType
    ){
        return jobOpportunityRepository.findByJobType(jobType)
                .stream()
                .map(jobOpportunity -> JobOpportunityResponse.builder()
                        .id(jobOpportunity.getJobId())
                        .description(jobOpportunity.getDescription())
                        .name(jobOpportunity.getName())
                        .company(jobOpportunity.getCompany())
                        .startDate(jobOpportunity.getStartDate())
                        .endDate(jobOpportunity.getEndDate())
                        .jobType(jobOpportunity.getJobType())
                        .category(jobOpportunity.getCategory())
                        .position(jobOpportunity.getPosition())
                        .datePosted(jobOpportunity.getDatePosted())
                        .expectedPay(jobOpportunity.getExpectedPay())
                        .build()
                )
                .collect(Collectors.toList());
    }
    public List<JobOpportunityResponse> getJobsByPosition(
            PositionRequest request
    ) {
        if (request == null){
            return getAllJobs();
        }
        Position position = Position.builder()
                .positionName(request.getName())
                .description(request.getDescription())
                .build();
        return jobOpportunityRepository.findByPosition(position)
                .stream()
                .map(jobOpportunity -> JobOpportunityResponse.builder()
                        .id(jobOpportunity.getJobId())
                        .description(jobOpportunity.getDescription())
                        .name(jobOpportunity.getName())
                        .company(jobOpportunity.getCompany())
                        .startDate(jobOpportunity.getStartDate())
                        .endDate(jobOpportunity.getEndDate())
                        .jobType(jobOpportunity.getJobType())
                        .category(jobOpportunity.getCategory())
                        .position(jobOpportunity.getPosition())
                        .datePosted(jobOpportunity.getDatePosted())
                        .expectedPay(jobOpportunity.getExpectedPay())
                        .build()
                )
                .collect(Collectors.toList());
    }
    public List<JobOpportunityResponse> getJobsByDatePosted(Date datePosted){

        return jobOpportunityRepository.findByDatePosted(datePosted)
                .stream()
                .map(jobOpportunity -> JobOpportunityResponse.builder()
                        .id(jobOpportunity.getJobId())
                        .description(jobOpportunity.getDescription())
                        .name(jobOpportunity.getName())
                        .company(jobOpportunity.getCompany())
                        .startDate(jobOpportunity.getStartDate())
                        .endDate(jobOpportunity.getEndDate())
                        .jobType(jobOpportunity.getJobType())
                        .category(jobOpportunity.getCategory())
                        .position(jobOpportunity.getPosition())
                        .datePosted(jobOpportunity.getDatePosted())
                        .expectedPay(jobOpportunity.getExpectedPay())
                        .build()
                )
                .collect(Collectors.toList());
    }

    public JobOpportunityResponse getJobDetails(Integer jobId) {
        return jobOpportunityRepository.findById(jobId)
                .map(jobOpportunity -> JobOpportunityResponse.builder()
                        .id(jobOpportunity.getJobId())
                        .description(jobOpportunity.getDescription())
                        .name(jobOpportunity.getName())
                        .company(jobOpportunity.getCompany())
                        .startDate(jobOpportunity.getStartDate())
                        .endDate(jobOpportunity.getEndDate())
                        .jobType(jobOpportunity.getJobType())
                        .category(jobOpportunity.getCategory())
                        .position(jobOpportunity.getPosition())
                        .datePosted(jobOpportunity.getDatePosted())
                        .expectedPay(jobOpportunity.getExpectedPay())
                        .build()
                )
                .orElse(null);

    }

    public ApplicationResponse applyToJob(
            Principal connectedUser,
            Integer jobId,
            ApplicationRequest request
    ) {
        var user = (BaseUser) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        JobOpportunity jobOpportunity = jobOpportunityRepository.findById(jobId)
                .orElse(null);
        Application application = Application.builder()
                .jobOpportunity(jobOpportunity)
                .applicant(user.getApplicant())
                .applicationDate(request.getApplicationDate())
                .build();

        return ApplicationResponse.builder()
                .applicationDate(application.getApplicationDate())
                .applicant(application.getApplicant())
                .applicationStatus(application.getApplicationStatus())
                .build();

    }
}

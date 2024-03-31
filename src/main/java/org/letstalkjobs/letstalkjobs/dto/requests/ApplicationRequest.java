package org.letstalkjobs.letstalkjobs.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.letstalkjobs.letstalkjobs.Utils.ApplicationStatus;
import org.letstalkjobs.letstalkjobs.entities.jobentities.Application;
import org.letstalkjobs.letstalkjobs.entities.jobentities.JobOpportunity;
import org.letstalkjobs.letstalkjobs.entities.userentities.Applicant;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequest {
    private ApplicationStatus applicationStatus;
    private Date applicationDate;
    private JobOpportunity jobOpportunity;
    private Applicant applicant;
}

package org.letstalkjobs.letstalkjobs.entities.jobentities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.letstalkjobs.letstalkjobs.Utils.ApplicationStatus;
import org.letstalkjobs.letstalkjobs.entities.userentities.Applicant;

import java.util.Date;
/*
This entity records the applied jobs ie attachment or internships
TODO:// Make sure that if an instance of this is made it is either
    attachment or internship.
 */
@Builder
@Data
@Entity
@Table(name = "application")
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer applicationId;
    @Column(name = "application_status")
    private ApplicationStatus applicationStatus;
    @Column(name = "application_date")
    private Date applicationDate;
    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobOpportunity jobOpportunity;

}

package org.simplifyinternships.simplifyinternships.entities.jobentities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.simplifyinternships.simplifyinternships.entities.userentities.Applicant;

import java.util.Date;
/*
This entity records the applied jobs ie attachment or internships
TODO:// Make sure that if an instance of this is made it is either
    attachment or internship.
 */

@Data
@Entity
@Table(name = "application")
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
    private JobOpportunity jobOpportunity;

    public Application() {
    }
}

package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    @Getter
    @Setter
    private Integer applicationId;
    @Getter
    @Setter
    @Column(name = "application_status")
    private String applicationStatus;
    @Getter
    @Setter
    @Column(name = "application_date")
    private Date applicationDate;
    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    public Application() {
    }
}

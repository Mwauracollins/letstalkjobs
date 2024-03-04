package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Applicant applicant;

}

package org.simplifyinternships.simplifyinternships.entities.jobentities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.simplifyinternships.simplifyinternships.entities.Company;

import java.util.Date;

@Entity
@Table(name = "internship")
public class Internship {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "internship_id")
    private Integer internshipId;
    @Getter
    @Setter
    @Column(name = "description")
    private String internshipDescription;
    @Getter
    @Setter
    @Column(name = "end_date")
    private Date endDate;
    @Getter
    @Setter
    @Column(name = "is_available")
    private Boolean isAvailable;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "job_id")
    private JobOpportunity jobOpportunity;

    public Internship(){

    }
}

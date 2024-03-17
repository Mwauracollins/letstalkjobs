package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.simplifyinternships.simplifyinternships.entities.jobentities.Attachment;
import org.simplifyinternships.simplifyinternships.entities.jobentities.Internship;
import org.simplifyinternships.simplifyinternships.entities.jobentities.JobOpportunity;

import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Integer companyId;
    @Getter
    @Setter
    @Column(name = "name", unique = true)
    private String companyName;
    @Getter
    @Setter
    @Column(name = "description")
    private String companyDescription;
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "company")
    private ContactInformation contactInformation;
    @Getter
    @Setter
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<JobOpportunity> jobOpportunity;

    public Company(){

    }


}

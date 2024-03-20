package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.*;
import org.simplifyinternships.simplifyinternships.entities.jobentities.JobOpportunity;

import java.util.List;

@Builder
@Entity
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
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

}

package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.AllArgsConstructor;
import org.simplifyinternships.simplifyinternships.entities.jobentities.JobOpportunity;

import java.util.List;

@Data
@Builder
@Entity
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Integer companyId;
    @Column(name = "name", unique = true)
    private String companyName;
    @Column(name = "description")
    private String companyDescription;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "company")
    private ContactInformation contactInformation;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<JobOpportunity> jobOpportunity;

}

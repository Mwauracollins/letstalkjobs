package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.simplifyinternships.simplifyinternships.entities.jobentities.Attachment;
import org.simplifyinternships.simplifyinternships.entities.jobentities.Internship;

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
    @Column(name = "description")
    private String companyDescription;
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "company")
    @JoinColumn(name = "company_id")
    private ContactInformation contactInformation;
    @Getter
    @Setter
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Internship> internships;
    @Getter
    @Setter
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Attachment> attachment;

    public Company(){

    }


}

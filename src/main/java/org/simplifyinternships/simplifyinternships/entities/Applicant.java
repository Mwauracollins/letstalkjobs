package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.simplifyinternships.simplifyinternships.Utils.UserRole;
import org.simplifyinternships.simplifyinternships.entities.BaseUser.ApplicantBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "applicant")
public class Applicant{
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_id")
    private Integer applicantId;
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private BaseUser user;
    @Getter
    @Setter
    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL)
    @Column(name = "applications")
    private List<Application> applications = new ArrayList<>();

    public Applicant() {
    }
    public Applicant(ApplicantBuilder applicantBuilder) {
        applicantBuilder.setUserRole(UserRole.APPLICANT);
    }

}

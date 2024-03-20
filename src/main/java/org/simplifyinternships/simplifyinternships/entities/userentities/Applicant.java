package org.simplifyinternships.simplifyinternships.entities.userentities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import lombok.Getter;
import lombok.Setter;
import org.simplifyinternships.simplifyinternships.entities.jobentities.Application;

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
    private Integer userId;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private BaseUser user;
    @Getter
    @Setter
    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL)
    private List<Application> applications = new ArrayList<>();

    public Applicant() {
    }
}

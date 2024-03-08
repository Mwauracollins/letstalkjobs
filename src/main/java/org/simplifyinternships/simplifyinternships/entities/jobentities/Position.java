package org.simplifyinternships.simplifyinternships.entities.jobentities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/*
This entity records the actual job title like 'Senior Engineer'
'IT Manager' e.t.c. Since there can be multiple jobs with the same positions
TODO: Constructors and its params
    A position can have many jobs under it. Like an IT manager
    can be posted in many jobs ie in attachment or internship
 */
@Entity
@Table(name = "job_position")
public class Position {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer positionId;
    @Getter
    @Setter
    @Column(name = "name")
    private String positionName;
    @Getter
    @Setter
    @Column(name = "description")
    private String description;
    @Getter
    @Setter
    @OneToMany(mappedBy = "position")
    private List<JobOpportunity> jobOpportunities;
}

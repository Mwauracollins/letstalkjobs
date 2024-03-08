package org.simplifyinternships.simplifyinternships.entities.jobentities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
/*
This entity record the job category ie field. Like IT, Management or Sales
 */

@Entity
@Table(name = "job_category")
public class JobCategory {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;
    @Getter
    @Setter
    @Column(name = "name")
    private String name;
    @Getter
    @Setter
    @Column(name = "description")
    private String description;
    @Getter
    @Setter
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<JobOpportunity> jobOpportunities;

    public JobCategory(){

    }
}

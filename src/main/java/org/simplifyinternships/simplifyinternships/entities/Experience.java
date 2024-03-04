package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    private Integer experienceId;
    @Getter
    @Setter
    @Column(name = "company_name")
    private String companyName;
    @Getter
    @Setter
    @Column(name = "position")
    private String position;
    @Getter
    @Setter
    @Column(name = "start_date")
    @Temporal(value = TemporalType.DATE)
    private Date startDate;
    @Getter
    @Setter
    @Column(name = "end_date")
    @Temporal(value = TemporalType.DATE)
    private Date endDate;
    @Getter
    @Setter
    @ManyToOne()//TODO: Add cascade and fetch type
    @JoinColumn(name = "user_id")
    private BaseUser user;

    public Experience() {
    }


}

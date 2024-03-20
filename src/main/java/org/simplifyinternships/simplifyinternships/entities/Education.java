package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.*;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;

import java.util.Date;
/*

TODO: Later use the userEducation with primary key user_id,
education_id fk from Educations
This table records the user and their corresponding education details.
Plus separate the education to schools like
EducationDetails:
▸ education_id (Primary Key)
▸ school_id (Foreign Key to the Schools table)
▸ degree
▸ field_of_study
▸ start_date
▸ end_date
▸ grade
▸ description

Schools:
▸ school_id (Primary Key)
▸ school_name
▸ location
▸ website
 */

@Entity
@Table(name = "education")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private Integer educationId;
    @Getter
    @Setter
    @Column(name = "major")
    private String major;
    @Getter
    @Setter
    @Column(name = "university")
    private String university;
    @Getter
    @Setter
    @Column(name = "start_year")
    private Date startYear;
    @Getter
    @Setter
    @Column(name = "end_year")
    private Date endYear;
    @Getter
    @Setter
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private BaseUser user;

}

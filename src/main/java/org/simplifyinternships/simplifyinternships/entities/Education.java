package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
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

@Data
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
    @Column(name = "major")
    private String major;
    @Column(name = "university")
    private String university;
    @Column(name = "start_year")
    private Date startYear;
    @Column(name = "end_year")
    private Date endYear;
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private BaseUser user;

}

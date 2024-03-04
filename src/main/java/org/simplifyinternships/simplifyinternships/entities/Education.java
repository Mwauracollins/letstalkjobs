package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "education")
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
    private String startYear;
    @Getter
    @Setter
    @Column(name = "end_year")
    private String endYear;
    @Getter
    @Setter
    @JoinColumn(name = "user_id")
    @ManyToOne
    private BaseUser user;

    public Education() {
    }

    public Education(String major, String university, String startYear, String endYear) {
        this.major = major;
        this.university = university;
        this.startYear = startYear;
        this.endYear = endYear;
    }


}

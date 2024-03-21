package org.simplifyinternships.simplifyinternships.entities.jobentities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "internship")
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "internship_id")
    private Integer internshipId;
    @Column(name = "description")
    private String internshipDescription;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "is_available")
    private Boolean isAvailable;
    @OneToOne
    @JoinColumn(name = "job_id")
    private JobOpportunity jobOpportunity;
}

package org.simplifyinternships.simplifyinternships.entities.jobentities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.simplifyinternships.simplifyinternships.entities.Company;

import java.util.Date;

/*
This entity defines the job. It incorporates all jobs like
attachments and internships.
 */
@Entity
@Table(name = "job_opportunity")
public class JobOpportunity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Integer jobId;
    @Getter
    @Setter
    @Column(name = "name")
    private String name;
    @Getter
    @Setter
    @Column(name = "date_posted")
    private Date datePosted;
    @Getter
    @Setter
    @Column(name = "start_date")
    private Date startDate;
    @Getter
    @Setter
    @Column(name = "end_date")
    private Date endDate;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @Getter
    @Setter
    @JoinColumn(name = "position_id")
    @ManyToOne
    private Position position;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "category_id")
    private JobCategory category;
    @Getter
    @Setter
    @Column(name = "job_type")
    private JobType jobType;
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "jobOpportunity")
    private Internship internship;
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "jobOpportunity")
    private Attachment attachment;



    public JobOpportunity(){

    }

}

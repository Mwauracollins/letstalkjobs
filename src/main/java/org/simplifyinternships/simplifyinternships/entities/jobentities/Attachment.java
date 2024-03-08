package org.simplifyinternships.simplifyinternships.entities.jobentities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.simplifyinternships.simplifyinternships.entities.Company;

import java.util.Date;
/*
Commented the relationship with job opportunity until
it is figured out on how to create a job type in different tables
 */

@Entity
@Table(name = "attachment")
public class Attachment {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attachment_id")
    private Integer attachmentId;
    @Getter
    @Setter
    @Column(name = "description")
    private String attachmentDescription;
    @Getter
    @Setter
    @Column(name = "is_available")
    private Boolean isAvailable;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "job_id")
    private JobOpportunity jobOpportunity;
    public Attachment(){

    }
}

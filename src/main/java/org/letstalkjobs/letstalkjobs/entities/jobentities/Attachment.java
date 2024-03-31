package org.letstalkjobs.letstalkjobs.entities.jobentities;

import jakarta.persistence.*;
import lombok.*;
/*
Commented the relationship with job opportunity until
it is figured out on how to create a job type in different tables
 */

@Setter
@Getter
@Builder
@Entity
@Table(name = "attachment")
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attachment_id")
    private Integer attachmentId;
    @Column(name = "description")
    private String attachmentDescription;
    @Column(name = "is_available")
    private Boolean isAvailable;
    @OneToOne
    @JoinColumn(name = "job_id")
    private JobOpportunity jobOpportunity;
}

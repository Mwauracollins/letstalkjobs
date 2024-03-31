package org.letstalkjobs.letstalkjobs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;

import java.util.Date;

@Data
@Entity
@Table(name = "experience")
@Builder
@AllArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    private Integer experienceId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "position")
    private String position;
    @Column(name = "start_date")
    @Temporal(value = TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(value = TemporalType.DATE)
    private Date endDate;
    @Column(name = "is_current_role")
    private Boolean isCurrentRole;

    @ManyToOne()//TODO: Add cascade and fetch type
    @JoinColumn(name = "user_id")
    private BaseUser user;

    public Experience() {
    }


}

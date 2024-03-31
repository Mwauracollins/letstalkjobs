package org.letstalkjobs.letstalkjobs.entities.jobentities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.letstalkjobs.letstalkjobs.entities.Company;
import org.letstalkjobs.letstalkjobs.entities.Skill;

import java.util.List;

@Entity
@Table(name = "job_skill")
public class JobSkill extends Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_skill_id")
    private Integer jobSkillId;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobOpportunity jobOpportunity;
}

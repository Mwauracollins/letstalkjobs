package org.letstalkjobs.letstalkjobs.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "skills")
//@MappedSuperclass
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Integer skillId;
    @Column(name = "skill_name")
    private String skillName;

    public Skill() {
    }
    public Skill(String skillName) {
        this.skillName = skillName;
    }
}

package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skills")
//@MappedSuperclass
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    @Getter
    @Setter
    private Integer skillId;
    @Column(name = "skill_name")
    @Getter
    @Setter
    private String skillName;

    public Skill() {
    }
    public Skill(String skillName) {
        this.skillName = skillName;
    }
}

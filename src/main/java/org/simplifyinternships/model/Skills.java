package org.simplifyinternships.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Table(name = "skills")
public class Skills {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private String skillId;
    @Column(name = "skill_name")
    private String skillName;

    public Skills() {
    }

    public String getSkillId() {
        return this.skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return this.skillName;
    }

//    @Required
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
    @Override
    public String toString(){
        return "Skills{" +
                "skillId='" + skillId + '\'' +
                ", skillName='" + skillName + '\'' +
                '}';
    }
}

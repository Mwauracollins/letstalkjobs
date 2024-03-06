package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;

@Entity
@Table(name = "user_skill")
public class UserSkill extends Skill{
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private BaseUser user;

    public UserSkill() {
    }
    public UserSkill(String skillName, BaseUser user) {
        super(skillName);
        this.user = user;
    }
}

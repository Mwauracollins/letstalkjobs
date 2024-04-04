package org.letstalkjobs.letstalkjobs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Inheritance;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;

@Entity
@Table(name = "user_skill")
@Inheritance
public class UserSkill extends Skill{
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private BaseUser user;

    public UserSkill() {
    }
    public UserSkill(String skillName, BaseUser user) {

        this.user = user;
    }
}

package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.simplifyinternships.simplifyinternships.Utils.UserRole;

@Entity(name = "mentor")
public class Mentor extends BaseUser{
    private String mentorId;
    private Boolean isVerified;
    public Mentor() {
    }
    public Mentor(MentorBuilder mentorBuilder) {
        super(mentorBuilder);
        this.isVerified = mentorBuilder.isVerified;
        setUserRole(UserRole.MENTOR);
    }
}

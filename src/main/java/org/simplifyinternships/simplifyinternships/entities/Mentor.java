package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.simplifyinternships.simplifyinternships.Utils.UserRole;
import org.simplifyinternships.simplifyinternships.entities.BaseUser.MentorBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mentor")
public class Mentor{
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentor-id")
    private Integer mentorId;
    @Getter
    @Setter
    @Column(name = "is_verified")
    private Boolean isVerified;
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private BaseUser user;
    public Mentor() {
    }
    public Mentor(MentorBuilder mentorBuilder) {
        mentorBuilder.setUserRole(UserRole.MENTOR);
    }
}

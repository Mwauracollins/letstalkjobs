package org.simplifyinternships.simplifyinternships.entities.userentities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.simplifyinternships.simplifyinternships.Utils.UserRole;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser.MentorBuilder;

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
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private BaseUser user;
    public Mentor() {
    }
    public Mentor(MentorBuilder mentorBuilder) {
        mentorBuilder.setUserRole(UserRole.MENTOR);
    }
}

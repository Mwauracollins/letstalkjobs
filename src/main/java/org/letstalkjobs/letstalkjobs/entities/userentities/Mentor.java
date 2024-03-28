package org.letstalkjobs.letstalkjobs.entities.userentities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    public Mentor(BaseUser user, Boolean isVerified){
        this.user = user;
        this.isVerified = isVerified;
    }
}

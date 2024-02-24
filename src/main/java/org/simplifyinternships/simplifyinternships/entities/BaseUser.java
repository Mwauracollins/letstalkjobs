package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.simplifyinternships.simplifyinternships.Utils.UserRole;

import java.util.List;
@Entity(name = "users")
public class BaseUser {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer userId;
    @Getter
    @Setter
    @Column(name = "username")
    private String username;
    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastName;
    @Getter
    @Setter
    @Column(name = "password")
    private String password;
    @Getter
    @Setter
    @Column(name = "userRole")
    private UserRole userRole;
    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "skills",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skills> skills;
    public BaseUser() {

    }

    public BaseUser(BaseUserBuilder baseUserBuilder) {
        this.username = baseUserBuilder.username;
        this.firstName = baseUserBuilder.firstName;
        this.lastName = baseUserBuilder.lastName;
        this.email = baseUserBuilder.email;
    }

    public static class BaseUserBuilder {
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String password;

        public BaseUserBuilder(String email, String password) {
            this.email = email;
            this.password = password;
        }
        public BaseUserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }
        public BaseUserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public BaseUserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public BaseUser build() {
            return new BaseUser(this);
        }
    }
    public static class MentorBuilder extends BaseUserBuilder{
        Boolean isVerified;

        public MentorBuilder(String email, String password) {
            super(email, password);
        }
        public MentorBuilder setIsVerified(Boolean isVerified) {
            this.isVerified = isVerified;
            return this;
        }
    }
    public static class ApplicantBuilder extends BaseUserBuilder{

        public ApplicantBuilder(String email, String password) {
            super(email, password);
        }
    }
}

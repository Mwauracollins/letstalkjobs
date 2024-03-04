package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.simplifyinternships.simplifyinternships.Utils.UserRole;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "users")
public class BaseUser {
    @Getter
    @Setter
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
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserSkill> skills;
    @Getter
    @Setter
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Experience> experience = new ArrayList<>();

//    @Getter
//    @Setter
//    @OneToOne(cascade = CascadeType.ALL)
//    private Mentor mentor;
//    @Getter
//    @Setter
//    @OneToOne(cascade = CascadeType.ALL)
//    private Applicant applicant;
    public BaseUser() {

    }
    public BaseUser(List<UserSkill> skills, List<Experience> experience) {
        this.skills = skills;
        this.experience = experience;
    }

    public BaseUser(BaseUserBuilder baseUserBuilder) {
        this.username = baseUserBuilder.username;
        this.firstName = baseUserBuilder.firstName;
        this.lastName = baseUserBuilder.lastName;
        this.email = baseUserBuilder.email;
        this.userRole = baseUserBuilder.userRole;
    }

    public static class BaseUserBuilder {
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private UserRole userRole;

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
        public BaseUserBuilder setUserRole(UserRole userRole) {
            this.userRole = userRole;
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

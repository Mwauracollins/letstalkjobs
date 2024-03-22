package org.simplifyinternships.simplifyinternships.entities.userentities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.simplifyinternships.simplifyinternships.Utils.UserRole;
import org.simplifyinternships.simplifyinternships.entities.*;
import org.simplifyinternships.simplifyinternships.entities.postentities.Post;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Data
@Entity
@Table(name = "users")
public class BaseUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer userId;
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "userRole")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserSkill> skills;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Experience> experience = new ArrayList<>();
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Mentor mentor;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Applicant applicant;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private ContactInformation contactInformation;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> post;
    @OneToMany(mappedBy = "sender")
    private List<Chat> outgoingChats;
    @OneToMany(mappedBy = "receiver")
    private List<Chat> incomingChats;
    @OneToMany(mappedBy = "user1")
    private List<Connection> connectedTo;
    @OneToMany(mappedBy = "user2")
    private List<Connection> connections;
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    public BaseUser() {

    }
    public BaseUser(List<UserSkill> skills, List<Experience> experience) {
        this.skills = skills;
        this.experience = experience;
    }

    public BaseUser(@NotNull BaseUserBuilder baseUserBuilder) {
        this.username = baseUserBuilder.username;
        this.firstName = baseUserBuilder.firstName;
        this.lastName = baseUserBuilder.lastName;
        this.email = baseUserBuilder.email;
        this.userRole = baseUserBuilder.userRole;
        this.password = baseUserBuilder.password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRole.getAuthorities();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
}

package org.letstalkjobs.letstalkjobs.entities.userentities;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.letstalkjobs.letstalkjobs.Utils.UserRole;
import org.letstalkjobs.letstalkjobs.entities.*;
import org.letstalkjobs.letstalkjobs.entities.postentities.Post;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Data
@Builder
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class BaseUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRole.getAuthorities();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
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

}

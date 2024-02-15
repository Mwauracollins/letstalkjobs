package org.simplifyinternships.model.usersmodel;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.simplifyinternships.model.Application;
import org.simplifyinternships.model.Skills;

import java.util.ArrayList;
import java.util.List;
@Table(name = "user")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private String userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "user_role")
    private UserRole userRole;
    @Column(name = "contact_no")
    private String contactNo;
    @Column(name = "skills")
    private List<Skills> userSkills;
    @Column(name = "applications")
    private List<Application> applications;

    public User() {
        this.userSkills = new ArrayList<>();
        this.applications = new ArrayList<>();

    }
    public User(UserBuilder userBuilder){
        this.email = userBuilder.email;
        this.password = userBuilder.password;
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.userRole = userBuilder.userRole;
    }
    public static class UserBuilder{
        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private String profilePicture;
        private UserRole userRole;

        public UserBuilder(String email, String password){
            this.email = email;
            this.password = password;
        }
        public UserBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public UserBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public UserBuilder profilePicture(String profilePicture){
            this.profilePicture = profilePicture;
            return this;
        }
        public UserBuilder userRole(UserRole userRole){
            this.userRole = userRole;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }
    public String getUserId(){
        return this.userId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public UserRole getUserRole(){
        return this.userRole;
    }
    public void setUserRole(UserRole userRole){
        this.userRole = userRole;
    }
    public String getContactNo(){
        return this.contactNo;
    }
    public void setContactNo(String contactNo){
        this.contactNo = contactNo;
    }
    public List<Skills> getUserSkills(){
        return this.userSkills;
    }

    public void setUserSkills(List<Skills> userSkills) {
        this.userSkills = userSkills;
    }

    public List<Application> getApplications(){
        return this.applications;
    }
    public void setApplications(List<Application> applications){
        this.applications = applications;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userRole='" + userRole + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", applications=" + applications +
                '}';
    }
}

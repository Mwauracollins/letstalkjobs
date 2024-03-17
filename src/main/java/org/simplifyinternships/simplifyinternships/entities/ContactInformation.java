package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.simplifyinternships.simplifyinternships.entities.userentities.BaseUser;

/*
THis records all the contact information about eh user and the companies. The
visibility specifies if the details are visible to the public or hidden.
 */

@Entity
@Table(name = "contact_information")
public class ContactInformation {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_information_id")
    private Integer contactInformationId;
    @Getter
    @Setter
    @Column(name = "email", unique = true)
    private String email;
    @Getter
    @Setter
    @Column(name = "email_visibility")
    private Boolean emailVisibility;
    @Getter
    @Setter
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    @Getter
    @Setter
    @Column(name = "phone_number_visibility")
    private Boolean phoneNumberVisibility;
    @Getter
    @Setter
    @Column(name = "website", unique = true)
    private String website;
    @Getter
    @Setter
    @Column(name = "website_visibility")
    private Boolean websiteVisibility;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "user_id")
    private BaseUser user;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public ContactInformation(){

    }

}

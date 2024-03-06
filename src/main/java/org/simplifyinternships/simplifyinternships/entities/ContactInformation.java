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
    @Column(name = "email")
    private String email;
    @Getter
    @Setter
    @Column(name = "email_visibility")
    private Boolean email_visibility;
    @Getter
    @Setter
    @Column(name = "phone_number")
    private String phone_number;
    @Getter
    @Setter
    @Column(name = "phone_number_visibility")
    private Boolean phone_number_visibility;
    @Getter
    @Setter
    @Column(name = "website")
    private String website;
    @Getter
    @Setter
    @Column(name = "website_visibility")
    private Boolean website_visibility;

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

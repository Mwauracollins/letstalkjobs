package org.letstalkjobs.letstalkjobs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;

/*
THis records all the contact information about eh user and the companies. The
visibility specifies if the details are visible to the public or hidden.
 */

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contact_information")
public class ContactInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_information_id")
    private Integer contactInformationId;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "email_visibility")
    private Boolean emailVisibility;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    @Column(name = "phone_number_visibility")
    private Boolean phoneNumberVisibility;
    @Column(name = "website", unique = true)
    private String website;
    @Column(name = "website_visibility")
    private Boolean websiteVisibility;

    @OneToOne
    @JoinColumn(name = "user_id")
    private BaseUser user;
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;


}

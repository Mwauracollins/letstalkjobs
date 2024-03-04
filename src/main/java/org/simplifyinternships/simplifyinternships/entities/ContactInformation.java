package org.simplifyinternships.simplifyinternships.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contact_information")
public class ContactInformation {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_information_id")
    private Integer id;
    private String email;
    private Boolean email_visibility;
    private String phone_number;
    private Boolean phone_number_visibility;
    private String website;
    private Boolean website_visibility;

}

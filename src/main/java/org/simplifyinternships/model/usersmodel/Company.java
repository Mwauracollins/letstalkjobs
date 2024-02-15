package org.simplifyinternships.model.usersmodel;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.simplifyinternships.model.Attachment;
import org.simplifyinternships.model.Internship;

import java.util.List;

public class Company {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private String companyId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_email")
    private String companyEmail;
    @Column(name = "company_password")
    private String companyPassword;
    @Column(name = "company_contact")
    private String companyContact;
    @Column(name = "list_of_internships")
    private List<Internship> internships;
    @Column(name = "list_of_attachments")
    private List<Attachment> attachments;

    public Company() {
    }

    public String getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

}

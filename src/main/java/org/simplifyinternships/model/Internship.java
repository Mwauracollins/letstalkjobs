package org.simplifyinternships.model;

public class Internship {
    private String internshipId;
    private String internshipTitle;
    private String internshipDescription;
    private String internshipLocation;
    private String internshipStartDate;
    private String internshipEndDate;
    private String datePosted;

    public Internship() {
    }
    public String getInternshipId() {
        return this.internshipId;
    }
    public void setInternshipId(String internshipId) {
        this.internshipId = internshipId;
    }
    public String getInternshipTitle() {
        return this.internshipTitle;
    }
    public void setInternshipTitle(String internshipTitle) {
        this.internshipTitle = internshipTitle;
    }
    public String getInternshipDescription() {
        return this.internshipDescription;
    }
    public void setInternshipDescription(String internshipDescription) {
        this.internshipDescription = internshipDescription;
    }
    public String getInternshipLocation() {
        return this.internshipLocation;
    }
    public void setInternshipLocation(String internshipLocation) {
        this.internshipLocation = internshipLocation;
    }
    public String getInternshipStartDate() {
        return this.internshipStartDate;
    }
    public void setInternshipStartDate(String internshipStartDate) {
        this.internshipStartDate = internshipStartDate;
    }
    public String getInternshipEndDate() {
        return this.internshipEndDate;
    }
    public void setInternshipEndDate(String internshipEndDate) {
        this.internshipEndDate = internshipEndDate;
    }
    public String getDatePosted() {
        return this.datePosted;
    }
    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }


}
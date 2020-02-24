package com.ucr.proyecto.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "issueClient")
public class Issue {
    @Id
    @Column(name = "IssueId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Description")
    @NotNull
    private String description;
    @Column(name = "Timestamp")
    @NotNull
    private String registerTimestamp;
    @Column(name = "Adress")
    private String address;
    @Column(name = "Phone")
    private String contactPhone;
    @Column(name = "Email")
    @Email
    private String contactEmail;
    @Column(name = "Status")
    private String status;
    @Column(name="Comments")
    private String comments;
    @Column(name = "SupportUser")
    private String supportUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegisterTimestamp() {
        return registerTimestamp;
    }

    public void setRegisterTimestamp(String registerTimestamp) {
        this.registerTimestamp = registerTimestamp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSupportUser() {
        return supportUser;
    }

    public void setSupportUser(String supportUserAssigned) {
        this.supportUser = supportUserAssigned;
    }
    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", registerTimestamp=" + registerTimestamp +
                ", address='" + address + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", supportUserAssigned=" + supportUser +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return Objects.equals(id, issue.id) &&
                Objects.equals(description, issue.description) &&
                Objects.equals(registerTimestamp, issue.registerTimestamp) &&
                Objects.equals(address, issue.address) &&
                Objects.equals(contactPhone, issue.contactPhone) &&
                Objects.equals(contactEmail, issue.contactEmail) &&
                Objects.equals(status, issue.status) &&
                Objects.equals(comments, issue.comments) &&
                Objects.equals(supportUser, issue.supportUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, registerTimestamp,address, contactPhone, contactEmail, status, comments, supportUser);
    }

}

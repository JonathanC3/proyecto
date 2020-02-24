package com.ucr.proyecto.dto;

import java.util.Date;

public class IssueDTO {
    public static class Request {
        private String description;
        private String registerTimestamp;
        private String address;
        private String contactPhone;
        private String contactEmail;
        private String status;
        private String comments;
        private String supportUserAssigned;

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

        public String getSupportUserAssigned() {
            return supportUserAssigned;
        }

        public void setSupportUserAssigned(String supportUserAssigned) {
            this.supportUserAssigned = supportUserAssigned;
        }

    }
    public static class Response {

        private int id;
        private String description;
        private String registerTimestamp;
        private String address;
        private String contactPhone;
        private String contactEmail;
        private String status;
        private String comments;
        private String supportUserAssigned;
        public int getId() {
            return id;
        }

        public void setId(int id) {
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

        public String getSupportUserAssigned() {
            return supportUserAssigned;
        }

        public void setSupportUserAssigned(String supportUserAssigned) {
            this.supportUserAssigned = supportUserAssigned;
        }

    }
}

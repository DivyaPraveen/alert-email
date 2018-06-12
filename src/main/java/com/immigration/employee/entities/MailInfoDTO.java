package com.immigration.employee.entities;

import java.util.Date;

public class MailInfoDTO {

    private Date expiryDate;
    private String empNbr;
    private String emailId;
    private String visaForCountry;

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getEmpNbr() {
        return empNbr;
    }

    public void setEmpNbr(String empNbr) {
        this.empNbr = empNbr;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getVisaForCountry() {
        return visaForCountry;
    }

    public void setVisaForCountry(String visaForCountry) {
        this.visaForCountry = visaForCountry;
    }

    @Override
    public String toString() {
        return "MailInfoDTO{" +
                "expiryDate=" + expiryDate +
                ", empNbr='" + empNbr + '\'' +
                ", emailId='" + emailId + '\'' +
                ", visaForCountry='" + visaForCountry + '\'' +
                '}';
    }
}

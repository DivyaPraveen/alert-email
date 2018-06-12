package com.immigration.employee.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visa_info")
public class VisaInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "country", unique = true)
    private String country;

    @Column(name = "validfrom", unique = true)
    private Date validFrom;

    @Column(name = "validto", unique = true)
    private Date validTo;

    @Column(name = "type", unique = true)
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VisaInformation{" +
                "id=" + id +
                ", user=" + user +
                ", country=" + country +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", type='" + type + '\'' +
                '}';
    }
}

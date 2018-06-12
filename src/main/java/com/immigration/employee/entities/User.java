/*
 * Copyright (C) 2018, Liberty Information Technology
 *
 * Created on 04/16/2018
 *
 */

package com.immigration.employee.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name = "n_number", unique = true)
    private String n_number;

    @Column(name = "email_id", unique = true)
    private String emailId;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "passport_nbr")
    private String passport_nbr;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private ImmigrationCardInfo immigrationCardInfo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<VisaInformation> visas;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getN_number() {
        return n_number;
    }

    public void setN_number(String n_number) {
        this.n_number = n_number;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassport_nbr() {
        return passport_nbr;
    }

    public void setPassport_nbr(String passport_nbr) {
        this.passport_nbr = passport_nbr;
    }

    public ImmigrationCardInfo getImmigrationCardInfo() {
        return immigrationCardInfo;
    }

    public void setImmigrationCardInfo(ImmigrationCardInfo immigrationCardInfo) {
        this.immigrationCardInfo = immigrationCardInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", n_number='" + n_number + '\'' +
                ", emailId='" + emailId + '\'' +
                ", nationality='" + nationality + '\'' +
                ", passport_nbr='" + passport_nbr + '\'' +
                ", immigrationCardInfo=" + immigrationCardInfo +
                ", visas=" + visas +
                '}';
    }

    public List<VisaInformation> getVisas() {
        return visas;
    }

    public void setVisas(List<VisaInformation> visas) {
        this.visas = visas;
    }
}

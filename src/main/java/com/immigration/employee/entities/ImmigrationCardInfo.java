package com.immigration.employee.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gnib_info")
public class ImmigrationCardInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "gnib_nbr", unique = true)
    private Long gnibNbr;

    @Column(name = "stamp", unique = true)
    private String stamp;

    @Column(name = "validfrom", unique = true)
    private Date validFrom;

    @Column(name = "validto", unique = true)
    private Date validTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public Long getGnibNbr() {
        return gnibNbr;
    }

    public void setGnibNbr(Long gnibNbr) {
        this.gnibNbr = gnibNbr;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
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

    @Override
    public String toString() {
        return "ImmigrationCardInfo{" +
                "id=" + id +
                ", gnibNbr=" + gnibNbr +
                ", stamp='" + stamp + '\'' +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                '}';
    }
}

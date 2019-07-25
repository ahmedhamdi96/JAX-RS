package com.sumerge.program.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "ADDRESS", schema = "PROGRAMDB")
public class Address implements Serializable {

    @Id
    @Column(name="ADDRESSID")
    private Integer addressID;
    @JoinColumn(name = "EMPID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
    @Column(name="ADDLINE1")
    private String addLine1;
    @Column(name="ADDLINE2")
    private String addLine2;
    @Column(name="CITY")
    private String city;
    @Column(name="REGION")
    private String region;
    @Column(name="COUNTRY")
    private String country;
    @Column(name="POSTCODE")
    private String postcode;
    @Transient
    private String postcodeFormatted;

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getAddLine1() {
        return addLine1;
    }

    public void setAddLine1(String addLine1) {
        this.addLine1 = addLine1;
    }

    public String getAddLine2() {
        return addLine2;
    }

    public void setAddLine2(String addLine2) {
        this.addLine2 = addLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostcodeFormatted() {
        return "FORMATTED POSTCODE: " + this.postcode;
    }

    public void setPostcodeFormatted(String postcodeFormatted) {
        this.postcodeFormatted = postcodeFormatted;
    }
}

package com.sumerge.program.entities;

import javax.persistence.*;

@Entity
@Table(name="PHONENUMBER", schema = "PROGRAMDB")
public class PhoneNumber {

    @Id
    @Column(name="PHONEID")
    private Integer phoneId;
    @JoinColumn(name = "EMPID")
    @ManyToOne
    private Employee employee;
    @Column(name="LOCALNUM")
    private String localNum;
    @Column(name="INTLPREFIX")
    private String intlPrefix;
    @Column(name="PHONETYPE")
    private String phoneType;

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getLocalNum() {
        return localNum;
    }

    public void setLocalNum(String localNum) {
        this.localNum = localNum;
    }

    public String getIntlPrefix() {
        return intlPrefix;
    }

    public void setIntlPrefix(String intlPrefix) {
        this.intlPrefix = intlPrefix;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }
}

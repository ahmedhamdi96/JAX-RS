package com.sumerge.program.entities;

import javax.persistence.*;

@Entity
@Table(name="EMAIL", schema = "PROGRAMDB")
public class Email {

    @Id()
    @Column(name="EMAILID")
    private Integer emailId;
    @JoinColumn(name = "EMPID")
    @ManyToOne
    private Employee employee;
    @Column(name="EMAILADDRESS")
    private String emailAddress;
    @Column(name="EMAILTYPE")
    private String emailType;

    public Integer getEmailId() {
        return emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }
}

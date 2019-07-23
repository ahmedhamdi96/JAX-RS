package com.sumerge.program.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="PROJECT", schema = "PROGRAMDB")
public class Project {

    @Id()
    @Column(name="PROJID")
    private String projID;
    @Column(name="PROJNAME")
    private String projName;
    @Column(name="STARTDATE")
    private String startDate;
    @Column(name="TARGETDATE")
    private String targetDate;
    @Column(name="STATUS")
    private String status;
    @Column(name="DESCRIPTION")
    private String description;
    @JoinTable(name = "PROJECTMEMBER", schema = "PROGRAMDB",
            joinColumns = {@JoinColumn(name = "EMPID")},
            inverseJoinColumns = {@JoinColumn(name = "PROJID")})
    @ManyToMany
    private Collection<Employee> employees;

    public String getProjID() {
        return projID;
    }

    public void setProjID(String projID) {
        this.projID = projID;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
}

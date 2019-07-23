package com.sumerge.program.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="EMPLOYEE", schema = "PROGRAMDB")
public class Employee {

    @Id
    @Column(name="EMPID")
    private String empId;
    @JoinColumn(name = "DEPTCODE")
    @OneToOne
    private Department department;
    @Column(name="JOBTITLE")
    private String jobTitle;
    @Column(name="GIVENNAME")
    private String givenName;
    @Column(name="FAMILYNAME")
    private String familyName;
    @Column(name="COMMONNAME")
    private String commonName;
    @Column(name="NAMETITLE")
    private String nameTitle;
    @JoinTable(name = "PROJECTMEMBER", schema = "PROGRAMDB",
            joinColumns = {@JoinColumn(name = "PROJID")},
            inverseJoinColumns = {@JoinColumn(name = "EMPID")})
    @ManyToMany
    private Collection<Project> projects;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }
}

package com.sumerge.program.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENT", schema = "PROGRAMDB")
public class Department {

    @Id()
    @Column(name="DEPTCODE")
    private String deptCode;
    @Column(name="DEPTNAME")
    private String deptName;
    @Column(name="MANAGER")
    private String manager;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}

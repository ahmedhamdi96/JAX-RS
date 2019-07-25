package com.sumerge.program.listeners;

import com.sumerge.program.entities.Employee;

import javax.persistence.PrePersist;

public class EmployeeListener{
    @PrePersist
    private void beforePersist(Employee employee) {
        System.out.println(employee);
        System.out.println("beforePersist works correctly.");
    }
}

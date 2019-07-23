package com.sumerge.program.managers;

import com.sumerge.program.entities.Employee;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Collection;

@Stateless
public class EmployeeManager {

    @PersistenceContext(unitName = "programdb-pu")
    private EntityManager entityManager;

    public Employee createEmployee(Employee employee){
        return entityManager.merge(employee);
    }

    public Collection<Employee> readAllEmployees() {
        return entityManager.createQuery("SELECT x FROM Employee x", Employee.class).
                getResultList();
    }

    public Employee readEmployee(Integer empId){
        Employee employee = entityManager.find( Employee.class, empId);
        return employee;
    }

    public Employee updateEmployee(Employee employeeNew){
        Employee employeeDB = entityManager.find( Employee.class, employeeNew.getEmpId());
        employeeDB.setDepartment(employeeNew.getDepartment());
        employeeDB.setJobTitle(employeeNew.getJobTitle());
        employeeDB.setGivenName(employeeNew.getGivenName());
        employeeDB.setFamilyName(employeeNew.getFamilyName());
        employeeDB.setCommonName(employeeNew.getCommonName());
        employeeDB.setNameTitle(employeeNew.getNameTitle());
        employeeDB.setProjects(employeeNew.getProjects());
        return entityManager.merge(employeeDB);
    }

    public String deleteEmployee(Integer empId){
        Employee employee = entityManager.find( Employee.class, empId);
        entityManager.remove(employee);

        return "Employee Deleted Successfully.";
    }

}

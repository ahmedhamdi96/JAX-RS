package com.sumerge.program.managers;

import com.sumerge.program.entities.Department;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Collection;

@Stateless
public class DepartmentManager {

    @PersistenceContext(unitName = "programdb-pu")
    private EntityManager entityManager;

    public Department createDepartment(Department department){
        return entityManager.merge(department);
    }

    public Collection<Department> readAllDepartments() {
        return entityManager.createQuery("SELECT x FROM Department x", Department.class).
                getResultList();
    }

    public Department readDepartment(String deptCode){
        Department department = entityManager.find( Department.class, deptCode);
        return department;
    }

    public Department updateDepartment(Department departmentNew){
        Department departmentDB = entityManager.find( Department.class, departmentNew.getDeptCode());
        departmentDB.setDeptName(departmentNew.getDeptName());
        departmentDB.setManager(departmentNew.getManager());
        return entityManager.merge(departmentDB);
    }

    public String deleteDepartment(String deptCode){
        Department department = entityManager.find( Department.class, deptCode);
        entityManager.remove(department);

        return "Department Deleted Successfully.";
    }

}

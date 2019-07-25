package com.sumerge.program.managers;

import com.sumerge.program.entities.Project;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Collection;

@Stateless
public class ProjectManager {

    @PersistenceContext(unitName = "programdb-pu")
    private EntityManager entityManager;

    public Project createProject(Project project){
        return entityManager.merge(project);
    }

    public Collection<Project> readAllProjects() {
        return entityManager.createQuery("SELECT x FROM Project x", Project.class).
                getResultList();
    }

    public Project readProject(String projID){
        Project project = entityManager.find( Project.class, projID);
        return project;
    }

    public Project updateProject(Project projectNew){
        Project projectDB = entityManager.find( Project.class, projectNew.getProjID());
        projectDB.setProjName(projectNew.getProjName());
        projectDB.setStartDate(projectNew.getStartDate());
        projectDB.setTargetDate(projectNew.getTargetDate());
        projectDB.setStatus(projectNew.getStatus());
        projectDB.setDescription(projectNew.getDescription());
        projectDB.setEmployees(projectNew.getEmployees());
        return entityManager.merge(projectDB);
    }

    public String deleteProject(String projID){
        Project project = entityManager.find( Project.class, projID);
        entityManager.remove(project);

        return "Project Deleted Successfully.";
    }

}

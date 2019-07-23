package com.sumerge.program.rest;

import com.sumerge.program.entities.Project;
import com.sumerge.program.managers.ProjectManager;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@RequestScoped
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Path("project")
public class ProjectResources {

    private static final Logger LOGGER = Logger.getLogger(UserResources.class.getName());
    @EJB
    private ProjectManager projectManager;

    @POST
    public Response postProject(Project project) {
        try {
            return Response.ok().
                    entity(projectManager.createProject(project)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @GET
    public Response getAllProjects() {
        try {
            return Response.ok().
                    entity(projectManager.readAllProjects()).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }


    @GET
    @Path("{id}")
    public Response getProject(@PathParam("id") int id) {
        try {
            return Response.ok().
                    entity(projectManager.readProject(id)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @PUT
    public Response putProject(Project project) {
        try {
            projectManager.updateProject(project);
            return Response.ok().
                    entity(projectManager.updateProject(project)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteProject(@PathParam("id") int id) {
        try {
            return Response.ok().
                    entity(projectManager.deleteProject(id)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }
}

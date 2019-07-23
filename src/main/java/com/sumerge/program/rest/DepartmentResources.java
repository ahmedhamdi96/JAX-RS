package com.sumerge.program.rest;

import com.sumerge.program.entities.Department;
import com.sumerge.program.managers.DepartmentManager;

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
@Path("department")
public class DepartmentResources {

    private static final Logger LOGGER = Logger.getLogger(UserResources.class.getName());
    @EJB
    private DepartmentManager departmentManager;

    @POST
    public Response postDepartment(Department department) {
        try {
            return Response.ok().
                    entity(departmentManager.createDepartment(department)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @GET
    public Response getAllDepartments() {
        try {
            return Response.ok().
                    entity(departmentManager.readAllDepartments()).
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
    public Response getDepartment(@PathParam("id") int id) {
        try {
            return Response.ok().
                    entity(departmentManager.readDepartment(id)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @PUT
    public Response putDepartment(Department department) {
        try {
            departmentManager.updateDepartment(department);
            return Response.ok().
                    entity(departmentManager.updateDepartment(department)).
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
    public Response deleteDepartment(@PathParam("id") int id) {
        try {
            return Response.ok().
                    entity(departmentManager.deleteDepartment(id)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }
}

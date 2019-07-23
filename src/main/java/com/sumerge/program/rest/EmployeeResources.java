package com.sumerge.program.rest;

import com.sumerge.program.entities.Employee;
import com.sumerge.program.managers.EmployeeManager;

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
@Path("employee")
public class EmployeeResources {

    private static final Logger LOGGER = Logger.getLogger(UserResources.class.getName());
    @EJB
    private EmployeeManager employeeManager;

    @POST
    public Response postEmployee(Employee employee) {
        try {
            return Response.ok().
                    entity(employeeManager.createEmployee(employee)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @GET
    public Response getAllEmployees() {
        try {
            return Response.ok().
                    entity(employeeManager.readAllEmployees()).
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
    public Response getEmployee(@PathParam("id") int id) {
        try {
            return Response.ok().
                    entity(employeeManager.readEmployee(id)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @PUT
    public Response putEmployee(Employee employee) {
        try {
            employeeManager.updateEmployee(employee);
            return Response.ok().
                    entity(employeeManager.updateEmployee(employee)).
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
    public Response deleteEmployee(@PathParam("id") int id) {
        try {
            return Response.ok().
                    entity(employeeManager.deleteEmployee(id)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }
}

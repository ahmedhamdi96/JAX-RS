package com.sumerge.program.rest;

import com.sumerge.program.entities.PhoneNumber;
import com.sumerge.program.managers.PhoneNumberManager;

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
@Path("phoneNumber")
public class PhoneNumberResources {

    private static final Logger LOGGER = Logger.getLogger(UserResources.class.getName());
    @EJB
    private PhoneNumberManager phoneNumberManager;

    @POST
    public Response postPhoneNumber(PhoneNumber phoneNumber) {
        try {
            return Response.ok().
                    entity(phoneNumberManager.createPhoneNumber(phoneNumber)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @GET
    public Response getAllPhoneNumbers() {
        try {
            return Response.ok().
                    entity(phoneNumberManager.readAllPhoneNumbers()).
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
    public Response getPhoneNumber(@PathParam("id") int id) {
        try {
            return Response.ok().
                    entity(phoneNumberManager.readPhoneNumber(id)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @PUT
    public Response putPhoneNumber(PhoneNumber phoneNumber) {
        try {
            phoneNumberManager.updatePhoneNumber(phoneNumber);
            return Response.ok().
                    entity(phoneNumberManager.updatePhoneNumber(phoneNumber)).
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
    public Response deletePhoneNumber(@PathParam("id") int id) {
        try {
            return Response.ok().
                    entity(phoneNumberManager.deletePhoneNumber(id)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }
}

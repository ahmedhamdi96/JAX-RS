package com.sumerge.program.rest;

import com.sumerge.program.entities.Address;
import com.sumerge.program.managers.AddressManager;

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
@Path("address")
public class AddressResources {

    private static final Logger LOGGER = Logger.getLogger(UserResources.class.getName());
    private AddressManager addressManager = new AddressManager();

    @POST
    public Response postAddress(Address address) {
        try {
            return Response.ok().
                    entity(addressManager.createAddress(address)).
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
    public Response getAddress(@PathParam("id") int id) {
        try {
            return Response.ok().
                    entity(addressManager.readAddress(id)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @PUT
    public Response putAddress(Address address) {
        try {
            addressManager.updateAddress(address);
            return Response.ok().
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
    public Response deleteAddress(@PathParam("id") int id) {
        try {
            addressManager.deleteAddress(id);
            return Response.ok().
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }
}

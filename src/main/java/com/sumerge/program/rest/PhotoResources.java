package com.sumerge.program.rest;

import com.sumerge.program.entities.Photo;
import com.sumerge.program.managers.PhotoManager;

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
@Path("photo")
public class PhotoResources {

    private static final Logger LOGGER = Logger.getLogger(UserResources.class.getName());
    @EJB
    private PhotoManager photoManager;

    @POST
    public Response postPhoto(Photo photo) {
        try {
            return Response.ok().
                    entity(photoManager.createPhoto(photo)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @GET
    public Response getAllPhotos() {
        try {
            return Response.ok().
                    entity(photoManager.readAllPhotos()).
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
    public Response getPhoto(@PathParam("id") int id) {
        try {
            return Response.ok().
                    entity(photoManager.readPhoto(id)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @PUT
    public Response putPhoto(Photo photo) {
        try {
            photoManager.updatePhoto(photo);
            return Response.ok().
                    entity(photoManager.updatePhoto(photo)).
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
    public Response deletePhoto(@PathParam("id") int id) {
        try {
            return Response.ok().
                    entity(photoManager.deletePhoto(id)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }
}

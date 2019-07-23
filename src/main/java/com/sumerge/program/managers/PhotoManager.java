package com.sumerge.program.managers;

import com.sumerge.program.entities.Photo;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Collection;

@Stateless
public class PhotoManager {

    @PersistenceContext(unitName = "programdb-pu")
    private EntityManager entityManager;

    public Photo createPhoto(Photo photo){
        return entityManager.merge(photo);
    }

    public Collection<Photo> readAllPhotos() {
        return entityManager.createQuery("SELECT x FROM Photo x", Photo.class).
                getResultList();
    }

    public Photo readPhoto(Integer photoId){
        Photo photo = entityManager.find( Photo.class, photoId);
        return photo;
    }

    public Photo updatePhoto(Photo photoNew){
        Photo photoDB = entityManager.find( Photo.class, photoNew.getPhotoId());
        photoDB.setEmployee(photoNew.getEmployee());
        photoDB.setImageName(photoNew.getImageName());
        photoDB.setPhotoImage(photoNew.getPhotoImage());
        return entityManager.merge(photoDB);
    }

    public String deletePhoto(Integer photoId){
        Photo photo = entityManager.find( Photo.class, photoId);
        entityManager.remove(photo);

        return "Photo Deleted Successfully.";
    }

}

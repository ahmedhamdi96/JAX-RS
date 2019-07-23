package com.sumerge.program.entities;

import javax.persistence.*;

@Entity
@Table(name="PHOTO", schema = "PROGRAMDB")
public class Photo {

    @Id()
    @Column(name="PHOTOID")
    private Integer photoId;
    @JoinColumn(name = "EMPID")
    @OneToOne
    private Employee employee;
    @Column(name="IMAGENAME")
    private String imageName;
    @Column(name="PHOTOIMAGE")
    private String photoImage;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getPhotoImage() {
        return photoImage;
    }

    public void setPhotoImage(String photoImage) {
        this.photoImage = photoImage;
    }
}

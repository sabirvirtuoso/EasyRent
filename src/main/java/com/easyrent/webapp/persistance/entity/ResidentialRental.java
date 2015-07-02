package com.easyrent.webapp.persistance.entity;


import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by sabir.salman on 4/20/15.
 */
@Entity
@Table(name = "RESIDENTIAL")
public class ResidentialRental extends Rental {

    @NotNull
    @Column(nullable = false, name = "BEDROOMS")
    @Range(min = 1, max = 100)
    private Integer bedrooms;

    @NotNull
    @Column(nullable = false, name = "BATHROOMS")
    @Range(min = 1, max = 100)
    private Integer bathrooms;

    @NotNull
    @Column(nullable = false, name = "FACING")
    private String facing;

    @Column(name = "PET_ALLOWED", columnDefinition = "boolean default false", nullable = false)
    private boolean petAllowed = false;

    @Column(name = "FURNISHED", columnDefinition = "boolean default false", nullable = false)
    private boolean furnished = false;

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }

    public boolean isPetAllowed() {
        return petAllowed;
    }

    public void setPetAllowed(boolean petAllowed) {
        this.petAllowed = petAllowed;
    }

    public boolean isFurnished() {
        return furnished;
    }

    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }

    public void updateResidential(Rental rental) {
        this.update(rental);
        ResidentialRental residentialRental = (ResidentialRental) rental;
        this.setBedrooms(residentialRental.getBedrooms());
        this.setBathrooms(residentialRental.getBathrooms());
        this.setFacing(residentialRental.getFacing());
        this.setFurnished(residentialRental.isFurnished());
        this.setPetAllowed(residentialRental.isPetAllowed());
    }
}

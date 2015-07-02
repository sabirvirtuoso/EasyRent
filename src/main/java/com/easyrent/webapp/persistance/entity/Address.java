package com.easyrent.webapp.persistance.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * Created by sabir.salman on 4/15/15.
 */
@Embeddable
public class Address {

    @NotNull
    private String addressLine;

    @NotNull
    private String area;

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

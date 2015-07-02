package com.easyrent.webapp.persistance.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

/**
 * Created by sabir.salman on 2/8/15.
 */
@Entity
@Table(name = "USER")
public class User extends Persistent {

    @NotEmpty
    @Email(message = "Invalid email address")
    @Size(min = 6, max = 100)
    @Column(nullable = false, length = 100, name = "EMAIL")
    private String email;

    @NotEmpty
    @Size(min = 6, max = 50,
            message = "The password must be between 6 to 50 characters long.")
    @Column(nullable = false, length = 50, name = "PASSWORD")
    private String password;

    @Transient
    @NotEmpty
    private String confirmPassword;

    @NotEmpty
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long.")
    @Column(nullable = false, length = 20, name = "FIRST_NAME")
    private String firstName;

    @NotEmpty
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long.")
    @Column(nullable = false, length = 20, name = "LAST_NAME")
    private String lastName;

    @Transient
    private String fullName;

    @NotNull
    @Column(nullable = false, name = "DOB")
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @NotEmpty
    @Column(nullable = false, name = "OCCUPATION")
    private String occupation;

    @Lob
    @Column(name = "IMAGE", nullable = false)
    private byte[] image;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Rental> rentals;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Review> reviews;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Set<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Set<Rental> rentals) {
        this.rentals = rentals;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}

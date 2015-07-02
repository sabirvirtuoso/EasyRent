package com.easyrent.webapp.persistance.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by sabir.salman on 2/8/15.
 */
@Entity
@Table(name = "REVIEW")
public class Review extends Persistent {

    @NotEmpty
    @Column(nullable = false, name = "COMMENT")
    private String comment;

    @NotNull
    @Column(nullable = false, name = "RATING")
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "RENTAL_ID")
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

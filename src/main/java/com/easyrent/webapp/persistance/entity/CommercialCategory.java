package com.easyrent.webapp.persistance.entity;

import javax.persistence.*;

/**
 * Created by sabir.salman on 4/30/15.
 */
@Entity
public class CommercialCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

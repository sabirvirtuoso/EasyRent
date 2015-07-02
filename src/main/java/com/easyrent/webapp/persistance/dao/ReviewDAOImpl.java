package com.easyrent.webapp.persistance.dao;

import com.easyrent.webapp.persistance.entity.CommercialRental;
import com.easyrent.webapp.persistance.entity.Rental;
import com.easyrent.webapp.persistance.entity.Review;
import com.easyrent.webapp.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sabir.salman on 4/27/2015.
 */
@Repository
@Transactional
public class ReviewDAOImpl implements ReviewDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RentalDAO rentalDAO;

    @Override
    public void insertReviewDAO(Review review) {
        entityManager.persist(review);
    }
}

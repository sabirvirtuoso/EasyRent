package com.easyrent.webapp.service;

import com.easyrent.webapp.persistance.dao.CommercialRentalDAO;
import com.easyrent.webapp.persistance.dao.RentalDAO;
import com.easyrent.webapp.persistance.dao.ReviewDAO;
import com.easyrent.webapp.persistance.entity.CommercialRental;
import com.easyrent.webapp.persistance.entity.Rental;
import com.easyrent.webapp.persistance.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sabir.salman on 4/27/2015.
 */
@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDAO reviewDAO;

    @Autowired
    private RentalDAO rentalDAO;

    @Override
    public void insertReview(Review review) {
        reviewDAO.insertReviewDAO(review);

        Rental rental = rentalDAO.getSpecificRentalWithReviewsDAO(review.getRental().getId());
        rental.updateAverageRating(review);
    }
}

package com.easyrent.webapp.service;

import com.easyrent.webapp.persistance.dao.RentalDAO;
import com.easyrent.webapp.persistance.dao.UserDAO;
import com.easyrent.webapp.persistance.entity.Rental;
import com.easyrent.webapp.persistance.entity.Review;
import com.easyrent.webapp.persistance.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabir.salman on 4/26/15.
 */
@Service
@Transactional
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalDAO rentalDAO;

    @Override
    public Rental getSpecificRental(int rentalId) {

        return rentalDAO.getSpecificRentalDAO(rentalId);
    }

    @Override
    public Rental getSpecificRentalWithReviews(int rentalId) {

        return rentalDAO.getSpecificRentalWithReviewsDAO(rentalId);
    }

    @Override
    public void deleteRental(Integer rentalId) {

        rentalDAO.deleteRentalDAO(rentalId);
    }

    @Override
    public List<String> getAreas() {

        return rentalDAO.getAreasDAO();
    }
}

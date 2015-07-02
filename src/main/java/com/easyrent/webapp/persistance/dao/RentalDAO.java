package com.easyrent.webapp.persistance.dao;

import com.easyrent.webapp.persistance.entity.Rental;
import com.easyrent.webapp.persistance.entity.Review;

import java.util.List;

/**
 * Created by sabir.salman on 4/26/15.
 */
public interface RentalDAO {
    Rental getSpecificRentalDAO(int rentalId);

    Rental getSpecificRentalWithReviewsDAO(int rentalId);

    void deleteRentalDAO(Integer rentalId);

    List<String> getAreasDAO();
}

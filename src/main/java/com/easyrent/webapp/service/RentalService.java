package com.easyrent.webapp.service;

import com.easyrent.webapp.persistance.entity.Rental;
import com.easyrent.webapp.persistance.entity.Review;

import java.util.List;

/**
 * Created by sabir.salman on 4/26/15.
 */
public interface RentalService {
    Rental getSpecificRental(int rentalId);

    Rental getSpecificRentalWithReviews(int rentalId);

    void deleteRental(Integer rentalId);

    List<String> getAreas();
}

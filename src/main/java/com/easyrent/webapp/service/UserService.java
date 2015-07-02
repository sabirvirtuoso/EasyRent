package com.easyrent.webapp.service;

import com.easyrent.webapp.persistance.entity.CommercialRental;
import com.easyrent.webapp.persistance.entity.ResidentialRental;
import com.easyrent.webapp.persistance.entity.User;

import java.util.List;

/**
 * Created by sabir.salman on 4/26/15.
 */
public interface UserService {
    User loginUser(String email, String password);

    boolean validateEmail(User user);

    void insertUser(User user);

    User getSpecificUser(int userId);

    List<CommercialRental> getCommercialRentals(int userId);

    List<ResidentialRental> getResidentialRentals(int userId);
}

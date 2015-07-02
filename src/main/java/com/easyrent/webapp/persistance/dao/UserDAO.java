package com.easyrent.webapp.persistance.dao;

import com.easyrent.webapp.persistance.entity.CommercialRental;
import com.easyrent.webapp.persistance.entity.ResidentialRental;
import com.easyrent.webapp.persistance.entity.User;

import java.util.List;

/**
 * Created by sabir.salman on 4/26/15.
 */
public interface UserDAO {
    User loginUserDAO(String email, String password);

    User getSpecificUserDAO(int userId);

    boolean validateEmailDAO(User user);

    void insertUserDAO(User user);

    List<CommercialRental> getCommercialRentalsDAO(int userId);

    List<ResidentialRental> getResidentialRentalsDAO(int userId);
}

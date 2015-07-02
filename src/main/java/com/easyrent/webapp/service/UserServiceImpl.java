package com.easyrent.webapp.service;

import com.easyrent.webapp.persistance.dao.UserDAO;
import com.easyrent.webapp.persistance.entity.CommercialRental;
import com.easyrent.webapp.persistance.entity.ResidentialRental;
import com.easyrent.webapp.persistance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sabir.salman on 4/26/15.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User loginUser(String email, String password) {

        return userDAO.loginUserDAO(email, password);
    }

    @Override
    public void insertUser(User user) {
        userDAO.insertUserDAO(user);
    }

    @Override
    public User getSpecificUser(int userId) {

        return userDAO.getSpecificUserDAO(userId);
    }

    @Override
    public List<CommercialRental> getCommercialRentals(int userId){

        return userDAO.getCommercialRentalsDAO(userId);
    }

    @Override
    public List<ResidentialRental> getResidentialRentals(int userId){

        return userDAO.getResidentialRentalsDAO(userId);
    }

    @Override
    public boolean validateEmail(User user){

        return userDAO.validateEmailDAO(user);
    }
}


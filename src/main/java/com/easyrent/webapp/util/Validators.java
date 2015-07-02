package com.easyrent.webapp.util;

import com.easyrent.webapp.persistance.entity.CommercialCategory;
import com.easyrent.webapp.persistance.entity.ResidentialCategory;
import com.easyrent.webapp.persistance.entity.User;
import com.easyrent.webapp.service.RentalService;
import com.easyrent.webapp.service.UserService;

import java.util.Map;

/**
 * Created by sabir.salman on 4/28/2015.
 */
public class Validators {

    public static boolean isValidCommercialCategory(Integer categoryId, Map<Integer, String> commercialCategory) {
        return commercialCategory.containsKey(categoryId);
    }

    public static boolean isValidResidentialCategory(Integer categoryId, Map<Integer, String> residentialCategory) {
        return residentialCategory.containsKey(categoryId);
    }

    public static boolean isValidRental(RentalService rentalService, int rentalId) {
        return rentalService.getSpecificRental(rentalId) != null;

    }

    public static boolean isValidUser(UserService userService, int userId) {
        return userService.getSpecificUser(userId) != null;

    }

    public static boolean isValidInfo(UserService userService, User user) {
        return userService.validateEmail(user) && isPasswordMatched(user);
    }

    private static boolean isPasswordMatched(User userSignUp) {
        return userSignUp.getPassword().equals(userSignUp.getConfirmPassword());
    }
}

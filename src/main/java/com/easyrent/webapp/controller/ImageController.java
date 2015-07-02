package com.easyrent.webapp.controller;

import com.easyrent.webapp.persistance.entity.Rental;
import com.easyrent.webapp.persistance.entity.User;
import com.easyrent.webapp.service.RentalService;
import com.easyrent.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sabir.salman on 4/25/2015.
 */
@Controller
public class ImageController {

    @Autowired
    private UserService userService;

    @Autowired
    private RentalService rentalService;

    @RequestMapping(value = "/rentalImageDisplay", method = RequestMethod.GET)
    public void showRentalImage(@RequestParam("id") Integer id, @RequestParam("image") String image,
                                HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {

        Rental rental = rentalService.getSpecificRental(id);

        if (rental != null) {
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(getImage(rental, image));
            response.getOutputStream().close();
        }
    }

    @RequestMapping(value = "/userImageDisplay", method = RequestMethod.GET)
    public void showUserImage(@RequestParam("id") Integer id, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {

        User user = userService.getSpecificUser(id);

        if (user != null) {
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(user.getImage());
            response.getOutputStream().close();
        }
    }

    private byte[] getImage(Rental rental, String image) {
        if (image.equals("imageOne")) {
            return rental.getImageOne();
        }

        if (image.equals("imageTwo")) {
            return rental.getImageTwo();
        }

        return rental.getImageThree();
    }
}
package com.easyrent.webapp.controller;

import com.easyrent.webapp.interceptor.HttpSessionAuthenticationInterceptor;
import com.easyrent.webapp.service.UserService;
import com.easyrent.webapp.util.Validators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by sabir.salman on 4/26/15.
 */
@Controller
public class ProfileController {

    private static final Logger log = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = {"/profile/{id}"}, method = RequestMethod.GET)
    public String getMyProfile(@PathVariable Integer id, ModelMap model) {
        log.debug("viewing my profile now");

        if (!Validators.isValidUser(userService, id) ||
                !HttpSessionAuthenticationInterceptor.isAuthenticatedUser(session)) {

            return "invalidRequest";
        }

        model.addAttribute("commercialRentals", userService.getCommercialRentals(id));
        model.addAttribute("residentialRentals", userService.getResidentialRentals(id));
        model.addAttribute("welcome", "Welcome to your profile . Here are the list of rentals you have posted !!!");

        return "myRentals";
    }

    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public String getAboutMe(ModelMap model) {
        log.debug("viewing my profile now");

        return "aboutUs";
    }
}


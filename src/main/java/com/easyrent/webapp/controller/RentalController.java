package com.easyrent.webapp.controller;

import com.easyrent.webapp.persistance.entity.*;
import com.easyrent.webapp.service.CommercialRentalService;
import com.easyrent.webapp.service.RentalService;
import com.easyrent.webapp.service.ResidentialRentalService;
import com.easyrent.webapp.util.Utils;
import com.easyrent.webapp.util.Validators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by Syed Musawi on 4/26/2015.
 */
@Controller
@RequestMapping(value = {"/rental"})
public class RentalController {

    private static final Logger log = LoggerFactory.getLogger(RentalController.class);

    @Autowired
    private RentalService rentalService;

    @Autowired
    private CommercialRentalService commercialRentalService;

    @Autowired
    private ResidentialRentalService residentialRentalService;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = {"/view/{id}"}, method = RequestMethod.GET)
    public String viewRental(@PathVariable(value = "id") Integer rentalId, ModelMap model) {
        log.debug("viewing a rental now");

        if (!Validators.isValidRental(rentalService, rentalId)) {

            return "invalidRequest";
        }

        Rental rental = rentalService.getSpecificRentalWithReviews(rentalId);

        model.addAttribute("rental", rental);
        model.addAttribute("review", new Review());

        if (Utils.getView(rental).equals("commercialRentalView")) {
            model.addAttribute("categories", commercialRentalService.getCommercialRentalCategories());
        } else {
            model.addAttribute("categories", residentialRentalService.getResidentialRentalCategories());
        }

        return Utils.getView(rental);
    }

    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.POST)
    public String deleteRental(@PathVariable(value = "id") Integer rentalId, ModelMap model) {
        log.debug("deleting a rental now");

        if (!Validators.isValidRental(rentalService, rentalId)) {

            return "invalidRequest";
        }

        rentalService.deleteRental(rentalId);

        return "redirect:/profile/" + ((User) session.getAttribute("user")).getId();
    }
}

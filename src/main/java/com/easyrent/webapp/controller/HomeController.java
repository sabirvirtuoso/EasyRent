package com.easyrent.webapp.controller;

import com.easyrent.webapp.service.CommercialRentalService;
import com.easyrent.webapp.service.ResidentialRentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sabir.salman on 4/27/2015.
 */
@Controller
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private CommercialRentalService commercialRentalService;

    @Autowired
    private ResidentialRentalService residentialRentalService;

    @ModelAttribute
    public void init(Model model) {
        model.addAttribute("commercialCategories", commercialRentalService.getCommercialRentalCategories());
        model.addAttribute("residentialCategories", residentialRentalService.getResidentialRentalCategories());
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String getHomePage(ModelMap model) {
        log.debug("at home page");

        model.addAttribute("commercialRentals", commercialRentalService.getTopCommercialRentals());
        model.addAttribute("residentialRentals", residentialRentalService.getTopResidentialRentals());

        return "home";
    }
}

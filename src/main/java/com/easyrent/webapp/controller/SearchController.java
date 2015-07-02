package com.easyrent.webapp.controller;

import com.easyrent.webapp.bean.SearchCriteria;
import com.easyrent.webapp.service.CommercialRentalService;
import com.easyrent.webapp.service.RentalService;
import com.easyrent.webapp.service.ResidentialRentalService;
import com.easyrent.webapp.util.Utils;
import com.easyrent.webapp.util.Validators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by sabir.salman on 4/27/2015.
 */
@Controller
public class SearchController {

    private static final Logger log = LoggerFactory.getLogger(SearchController.class);
    private static final int MAX_RESULTS_PER_PAGE = 1;

    @Autowired
    private RentalService rentalService;

    @Autowired
    private ResidentialRentalService residentialRentalService;

    @Autowired
    private CommercialRentalService commercialRentalService;

    @ModelAttribute
    public void init(Model model) {
        model.addAttribute("areas", rentalService.getAreas());
        model.addAttribute("commercialCategories", commercialRentalService.getCommercialRentalCategories());
        model.addAttribute("residentialCategories", residentialRentalService.getResidentialRentalCategories());
    }

    @RequestMapping(value = {"/search/commercial/{categoryId}"}, method = RequestMethod.GET)
    public String searchCommercialRentalsByCategory(@PathVariable Integer categoryId,
                                                    @RequestParam(value = "page") Integer pageNumber,
                                                    ModelMap model) {
        log.debug("showing commercial rentals per category");

        Map<Integer, String> commercialCategories = commercialRentalService.getCommercialRentalCategories();

        if (!Validators.isValidCommercialCategory(categoryId, commercialCategories)) {

            return "invalidRequest";
        }

        model.addAttribute("pages", commercialRentalService.getCommercialRentalsByCategoryPageNumber(categoryId, MAX_RESULTS_PER_PAGE));
        model.addAttribute("commercialRental", commercialRentalService.getCommercialRentalsByCategory(categoryId, pageNumber, MAX_RESULTS_PER_PAGE));
        model.addAttribute("categoryId", categoryId);

        return "commercialRentalsPerCategory";
    }

    @RequestMapping(value = {"/search/residential/{categoryId}"}, method = RequestMethod.GET)
    public String searchResidentialRentalsByCategory(@PathVariable Integer categoryId,
                                                     @RequestParam(value = "page") Integer pageNumber,
                                                     ModelMap model) {
        log.debug("showing residential rentals per category");

        Map<Integer, String> residentialCategories = residentialRentalService.getResidentialRentalCategories();

        if (!Validators.isValidResidentialCategory(categoryId, residentialCategories)) {

            return "invalidRequest";
        }

        model.addAttribute("pages", residentialRentalService.getResidentialRentalsByCategoryPageNumber(categoryId, MAX_RESULTS_PER_PAGE));
        model.addAttribute("residentialRental", residentialRentalService.getResidentialRentalsByCategory(categoryId, pageNumber, MAX_RESULTS_PER_PAGE));
        model.addAttribute("categoryId", categoryId);

        return "residentialRentalsPerCategory";
    }

    @RequestMapping(value = {"/filter/commercial/{categoryId}"}, method = RequestMethod.POST)
    public String filterCommercialRentals(@PathVariable(value = "categoryId") Integer categoryId,
                                          @RequestParam(value = "minSize") String minSize,
                                          @RequestParam(value = "maxBudget") String maxBudget,
                                          @RequestParam(value = "area", required = false) String area,
                                          ModelMap model) {
        return filterRentals(Utils.getCommercialSearchCriteria(minSize, maxBudget, new SearchCriteria()),
                "commercialRentalsPerCategory", model, categoryId, area, "commercial");
    }

    @RequestMapping(value = {"/filter/residential/{categoryId}"}, method = RequestMethod.POST)
    public String filterResidentialRentals(@PathVariable(value = "categoryId") Integer categoryId,
                                          @RequestParam(value = "bedrooms") String bedrooms,
                                          @RequestParam(value = "minSize") String minSize,
                                          @RequestParam(value = "maxBudget") String maxBudget,
                                          @RequestParam(value = "area", required = false) String area,
                                          ModelMap model) {
        return filterRentals(Utils.getResidentialSearchCriteria(bedrooms, minSize, maxBudget, new SearchCriteria()),
                "residentialRentalsPerCategory", model, categoryId, area, "residential");
    }

    private String filterRentals(SearchCriteria searchCriteria, String view, ModelMap model, int categoryId, String area, String type) {
        log.debug("filtering a commercial rental now");

        if (area == null) {
            model.addAttribute("failure", "At least the area must be specified as search criteria");

            return view;
        }

        searchCriteria.setArea(area);

        model.addAttribute("categoryId", categoryId);

        if(type.equals("commercial")){
            model.addAttribute("commercialRental",
                    commercialRentalService.getCommercialRentalsBySearchCriteria(categoryId, searchCriteria));
        }else{
            model.addAttribute("residentialRental",
                    residentialRentalService.getResidentialRentalsBySearchCriteria(categoryId, searchCriteria));
        }

        model.addAttribute("success", "Search found the following commercial rentals");

        return view;
    }
}

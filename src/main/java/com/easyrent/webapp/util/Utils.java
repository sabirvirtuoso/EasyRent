package com.easyrent.webapp.util;

import com.easyrent.webapp.bean.SearchCriteria;
import com.easyrent.webapp.persistance.entity.CommercialRental;
import com.easyrent.webapp.persistance.entity.Rental;

/**
 * Created by sabir.salman on 3/11/2015.
 */
public class Utils {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String VALID_SEARCH_CRITERIA_PATTERN = "\\d+";

    private static final int DEFAULT_MIN_SPACE_SIZE = 0;
    private static final int DEFAULT_MAX_BUDGET = 1000000000;
    private static final int DEFAULT_MAX_BEDROOMS = 100;

    private static final java.text.SimpleDateFormat SIMPLE_DATE_FORMAT = new java.text.SimpleDateFormat(DATE_FORMAT);

    public static String getCurrentDate() {
        java.util.Date dt = new java.util.Date();

        return SIMPLE_DATE_FORMAT.format(dt);
    }

    public static String getView(Rental rental) {
        return (rental instanceof CommercialRental) ? "commercialRentalView" : "residentialRentalView";
    }

    public static SearchCriteria getCommercialSearchCriteria(String minSize, String maxBudget,
                                                             SearchCriteria searchCriteria) {
        if (minSize.isEmpty() || !minSize.matches(VALID_SEARCH_CRITERIA_PATTERN)) {
            searchCriteria.setMinSize(DEFAULT_MIN_SPACE_SIZE);
        } else {
            searchCriteria.setMinSize(Integer.parseInt(minSize));
        }

        if (maxBudget.isEmpty() || maxBudget.matches(VALID_SEARCH_CRITERIA_PATTERN)) {
            searchCriteria.setMaxBudget(DEFAULT_MAX_BUDGET);
        } else {
            searchCriteria.setMaxBudget(Integer.parseInt(maxBudget));
        }

        return searchCriteria;
    }

    public static SearchCriteria getResidentialSearchCriteria(String bedrooms, String minSize,
                                                              String maxBudget,
                                                              SearchCriteria searchCriteria) {
        SearchCriteria criteria = getCommercialSearchCriteria(minSize, maxBudget,
                searchCriteria);

        if (bedrooms.isEmpty() || bedrooms.matches(VALID_SEARCH_CRITERIA_PATTERN)) {
            criteria.setBedrooms(DEFAULT_MAX_BEDROOMS);
        } else {
            criteria.setBedrooms(Integer.parseInt(bedrooms));
        }

        return criteria;
    }
}

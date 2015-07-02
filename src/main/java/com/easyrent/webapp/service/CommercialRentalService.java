package com.easyrent.webapp.service;

import com.easyrent.webapp.bean.SearchCriteria;
import com.easyrent.webapp.persistance.entity.CommercialRental;
import com.easyrent.webapp.persistance.entity.Rental;

import java.util.List;
import java.util.Map;

/**
 * Created by sabir.salman on 4/26/15.
 */
public interface CommercialRentalService {
    int insertCommercialRental(CommercialRental commercialRental);

    void editRental(CommercialRental rental);

    List<Rental> getTopCommercialRentals();

    List<Rental> getCommercialRentalsByCategory(Integer categoryId, Integer pageNumber, Integer resultsPerPage);

    int getCommercialRentalsByCategoryPageNumber(Integer categoryId, Integer resultsPerPage);

    List<Rental> getCommercialRentalsBySearchCriteria(Integer categoryId, SearchCriteria searchCriteria);

    Map<Integer, String> getCommercialRentalCategories();
}

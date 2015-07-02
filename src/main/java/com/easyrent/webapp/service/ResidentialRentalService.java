package com.easyrent.webapp.service;

import com.easyrent.webapp.bean.SearchCriteria;
import com.easyrent.webapp.persistance.entity.Rental;
import com.easyrent.webapp.persistance.entity.ResidentialRental;

import java.util.List;

/**
 * Created by sabir.salman on 4/26/2015.
 */
public interface ResidentialRentalService {
    int insertResidentialRental(ResidentialRental residentialRental);

    void editRental(ResidentialRental rental);

    List<Rental> getTopResidentialRentals();

    List<Rental> getResidentialRentalsByCategory(Integer categoryId, Integer pageNumber, Integer resultsPerPage);

    int getResidentialRentalsByCategoryPageNumber(Integer categoryId, Integer resultsPerPage);

    List<Rental> getResidentialRentalsBySearchCriteria(Integer categoryId, SearchCriteria searchCriteria);

    java.util.Map<Integer, String> getResidentialRentalCategories();
}

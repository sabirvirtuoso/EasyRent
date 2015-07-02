package com.easyrent.webapp.persistance.dao;

import com.easyrent.webapp.bean.SearchCriteria;
import com.easyrent.webapp.persistance.entity.CommercialCategory;
import com.easyrent.webapp.persistance.entity.CommercialRental;
import com.easyrent.webapp.persistance.entity.Rental;

import java.util.List;

/**
 * Created by sabir.salman on 4/26/15.
 */
public interface CommercialRentalDAO {
    int insertCommercialRentalDAO(CommercialRental commercialRental);

    void editCommercialRentalDAO(CommercialRental rental);

    List<Rental> getTopCommercialRentalsDAO();

    List<Rental> getCommercialRentalsByCategoryDAO(Integer categoryId, Integer pageNumber, Integer resultsPerPage);

    List<Rental> getCommercialRentalsBySearchCriteria(Integer categoryId, SearchCriteria searchCriteria);

    List<CommercialCategory> getCommercialRentalCategoriesDAO();

    int getCommercialRentalsByCategoryPageNumberDAO(Integer categoryId, Integer resultsPerPage);
}

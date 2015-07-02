package com.easyrent.webapp.persistance.dao;

import com.easyrent.webapp.bean.SearchCriteria;
import com.easyrent.webapp.persistance.entity.Rental;
import com.easyrent.webapp.persistance.entity.ResidentialCategory;
import com.easyrent.webapp.persistance.entity.ResidentialRental;

import java.util.List;

/**
 * Created by sabir.salman on 4/26/15.
 */
public interface ResidentialRentalDAO {
    int insertResidentialRentalDAO(ResidentialRental residentialRental);

    void editResidentialRentalDAO(ResidentialRental rental);

    List<Rental> getTopResidentialRentalsDAO();

    List<Rental> getResidentialRentalsByCategoryDAO(Integer categoryId, Integer pageNumber, Integer resultsPerPage);

    List<Rental> getResidentialRentalsBySearchCriteria(Integer categoryId, SearchCriteria searchCriteria);

    List<ResidentialCategory> getResidentialRentalCategoriesDAO();

    int getResidentialRentalsByCategoryPageNumberDAO(Integer categoryId, Integer resultsPerPage);
}

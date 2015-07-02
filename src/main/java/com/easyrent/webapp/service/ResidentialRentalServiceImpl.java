package com.easyrent.webapp.service;

import com.easyrent.webapp.bean.SearchCriteria;
import com.easyrent.webapp.persistance.dao.ResidentialRentalDAO;
import com.easyrent.webapp.persistance.entity.Rental;
import com.easyrent.webapp.persistance.entity.ResidentialCategory;
import com.easyrent.webapp.persistance.entity.ResidentialRental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sabir.salman on 4/26/15.
 */
@Service
@Transactional
public class ResidentialRentalServiceImpl implements ResidentialRentalService {

    private Map<Integer, String> residentialCategories = new HashMap<Integer, String>();

    @Autowired
    private ResidentialRentalDAO residentialRentalDAO;

    @Override
    public int insertResidentialRental(ResidentialRental residentialRental) {
        return residentialRentalDAO.insertResidentialRentalDAO(residentialRental);
    }

    @Override
    public void editRental(ResidentialRental rental) {
        residentialRentalDAO.editResidentialRentalDAO(rental);
    }

    @Override
    public List<Rental> getTopResidentialRentals() {

        return residentialRentalDAO.getTopResidentialRentalsDAO();
    }

    @Override
    public List<Rental> getResidentialRentalsByCategory(Integer categoryId, Integer pageNumber, Integer resultsPerPage) {

        return residentialRentalDAO.getResidentialRentalsByCategoryDAO(categoryId, pageNumber, resultsPerPage);
    }

    @Override
    public int getResidentialRentalsByCategoryPageNumber(Integer categoryId, Integer resultsPerPage) {

        return residentialRentalDAO.getResidentialRentalsByCategoryPageNumberDAO(categoryId, resultsPerPage);
    }

    @Override
    public List<Rental> getResidentialRentalsBySearchCriteria(Integer categoryId, SearchCriteria searchCriteria) {

        return residentialRentalDAO.getResidentialRentalsBySearchCriteria(categoryId, searchCriteria);
    }

    @Override
    public Map<Integer, String> getResidentialRentalCategories() {

        List<ResidentialCategory> categories = residentialRentalDAO.getResidentialRentalCategoriesDAO();

        for (ResidentialCategory category : categories) {
            residentialCategories.put(category.getId(), category.getCategory());
        }

        return residentialCategories;
    }
}

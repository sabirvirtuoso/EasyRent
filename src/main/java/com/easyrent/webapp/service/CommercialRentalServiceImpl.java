package com.easyrent.webapp.service;

import com.easyrent.webapp.bean.SearchCriteria;
import com.easyrent.webapp.persistance.dao.CommercialRentalDAO;
import com.easyrent.webapp.persistance.entity.CommercialCategory;
import com.easyrent.webapp.persistance.entity.CommercialRental;
import com.easyrent.webapp.persistance.entity.Rental;
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
public class CommercialRentalServiceImpl implements CommercialRentalService {

    private Map<Integer, String> commercialCategories = new HashMap<Integer, String>();

    @Autowired
    private CommercialRentalDAO commercialRentalDAO;

    @Override
    public int insertCommercialRental(CommercialRental commercialRental) {
        return commercialRentalDAO.insertCommercialRentalDAO(commercialRental);
    }

    @Override
    public void editRental(CommercialRental rental) {
        commercialRentalDAO.editCommercialRentalDAO(rental);
    }

    @Override
    public List<Rental> getTopCommercialRentals() {

        return commercialRentalDAO.getTopCommercialRentalsDAO();
    }

    @Override
    public List<Rental> getCommercialRentalsByCategory(Integer categoryId, Integer pageNumber, Integer resultsPerPage) {
        return commercialRentalDAO.getCommercialRentalsByCategoryDAO(categoryId, pageNumber, resultsPerPage);
    }

    @Override
    public int getCommercialRentalsByCategoryPageNumber(Integer categoryId, Integer resultsPerPage) {
        return commercialRentalDAO.getCommercialRentalsByCategoryPageNumberDAO(categoryId, resultsPerPage);
    }

    @Override
    public List<Rental> getCommercialRentalsBySearchCriteria(Integer categoryId, SearchCriteria searchCriteria) {

        return commercialRentalDAO.getCommercialRentalsBySearchCriteria(categoryId, searchCriteria);
    }

    @Override
    public Map<Integer, String> getCommercialRentalCategories() {

        List<CommercialCategory> categories = commercialRentalDAO.getCommercialRentalCategoriesDAO();

        for (CommercialCategory category : categories) {
            commercialCategories.put(category.getId(), category.getCategory());
        }

        return commercialCategories;
    }
}


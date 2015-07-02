package com.easyrent.webapp.persistance.dao;

import com.easyrent.webapp.bean.SearchCriteria;
import com.easyrent.webapp.persistance.entity.CommercialCategory;
import com.easyrent.webapp.persistance.entity.CommercialRental;
import com.easyrent.webapp.persistance.entity.Rental;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sabir.salman on 4/26/15.
 */
@Repository
@Transactional
public class CommercialRentalDAOImpl implements CommercialRentalDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int insertCommercialRentalDAO(CommercialRental commercialRental) {
        entityManager.persist(commercialRental);
        entityManager.flush();

        return commercialRental.getId();
    }

    @Override
    public void editCommercialRentalDAO(CommercialRental rental) {
        entityManager.find(CommercialRental.class, rental.getId()).update(rental);
    }

    @Override
    public List<Rental> getTopCommercialRentalsDAO() {
        TypedQuery<Rental> query = entityManager.createQuery("SELECT c FROM CommercialRental AS c ORDER BY c.averageRating DESC", Rental.class);
        query.setMaxResults(4);

        return query.getResultList();
    }

    @Override
    public List<Rental> getCommercialRentalsByCategoryDAO(Integer categoryId, Integer pageNumber, Integer resultsPerPage) {
        TypedQuery<Rental> query = entityManager.createQuery("SELECT c FROM CommercialRental AS c WHERE c.category=:categoryId", Rental.class);
        query.setParameter("categoryId", categoryId);

        query.setFirstResult((pageNumber - 1) * resultsPerPage);
        query.setMaxResults(resultsPerPage);

        return query.getResultList();
    }

    public int getCommercialRentalsByCategoryPageNumberDAO(Integer categoryId, Integer resultsPerPage){
        Query query = entityManager.createQuery("SELECT COUNT (c) AS val FROM CommercialRental AS c WHERE c.category=:categoryId");
        query.setParameter("categoryId", categoryId);

        return (int) Math.ceil((Long) query.getSingleResult() / (double) resultsPerPage);
    }

    @Override
    public List<Rental> getCommercialRentalsBySearchCriteria(Integer categoryId, SearchCriteria searchCriteria) {

        TypedQuery<Rental> query = entityManager.createQuery("SELECT r FROM CommercialRental AS r WHERE r.category=:categoryId" +
                " AND r.address.area=:area AND r.size >= :minSize AND r.rent <= :maxBudget ORDER BY r.averageRating DESC", Rental.class);

        query.setParameter("categoryId", categoryId);
        query.setParameter("area", searchCriteria.getArea());
        query.setParameter("minSize", searchCriteria.getMinSize());
        query.setParameter("maxBudget", searchCriteria.getMaxBudget());

        return query.getResultList();
    }

    @Override
    public List<CommercialCategory> getCommercialRentalCategoriesDAO() {
        TypedQuery<CommercialCategory> query = entityManager.createQuery("SELECT c FROM CommercialCategory AS c", CommercialCategory.class);

        return query.getResultList();
    }
}

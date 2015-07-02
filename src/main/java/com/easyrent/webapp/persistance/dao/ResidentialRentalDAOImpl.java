package com.easyrent.webapp.persistance.dao;

import com.easyrent.webapp.bean.SearchCriteria;
import com.easyrent.webapp.persistance.entity.Rental;
import com.easyrent.webapp.persistance.entity.ResidentialCategory;
import com.easyrent.webapp.persistance.entity.ResidentialRental;
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
public class ResidentialRentalDAOImpl implements ResidentialRentalDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int insertResidentialRentalDAO(ResidentialRental residentialRental) {
        entityManager.persist(residentialRental);
        entityManager.flush();

        return residentialRental.getId();
    }

    @Override
    public void editResidentialRentalDAO(ResidentialRental rental) {
        entityManager.find(ResidentialRental.class, rental.getId()).updateResidential(rental);
    }

    @Override
    public List<Rental> getTopResidentialRentalsDAO() {
        TypedQuery<Rental> query = entityManager.createQuery("SELECT r FROM ResidentialRental AS r ORDER BY r.averageRating DESC", Rental.class);
        query.setMaxResults(4);

        return query.getResultList();
    }

    @Override
    public List<Rental> getResidentialRentalsByCategoryDAO(Integer categoryId, Integer pageNumber, Integer resultsPerPage) {
        TypedQuery<Rental> query = entityManager.createQuery("SELECT r FROM ResidentialRental AS r WHERE r.category=:categoryId", Rental.class);
        query.setParameter("categoryId", categoryId);

        query.setFirstResult((pageNumber - 1) * resultsPerPage);
        query.setMaxResults(resultsPerPage);

        return query.getResultList();
    }

    @Override
    public int getResidentialRentalsByCategoryPageNumberDAO(Integer categoryId, Integer resultsPerPage){
        Query query = entityManager.createQuery("SELECT COUNT (r) FROM ResidentialRental AS r WHERE r.category=:categoryId");
        query.setParameter("categoryId", categoryId);

        return (int) Math.ceil((Long) query.getSingleResult() / (double) resultsPerPage);
    }

    @Override
    public List<Rental> getResidentialRentalsBySearchCriteria(Integer categoryId, SearchCriteria searchCriteria) {
        TypedQuery<Rental> query = entityManager.createQuery("SELECT r FROM ResidentialRental AS r WHERE r.category=:categoryId" +
                " AND r.address.area=:area AND r.size >= :minSize AND r.rent <= :maxBudget AND r.bedrooms <= :bedrooms ORDER BY r.averageRating DESC", Rental.class);

        query.setParameter("categoryId", categoryId);
        query.setParameter("area", searchCriteria.getArea());
        query.setParameter("minSize", searchCriteria.getMinSize());
        query.setParameter("maxBudget", searchCriteria.getMaxBudget());
        query.setParameter("bedrooms", searchCriteria.getBedrooms());

        return query.getResultList();
    }

    @Override
    public List<ResidentialCategory> getResidentialRentalCategoriesDAO() {
        TypedQuery<ResidentialCategory> query = entityManager.createQuery("SELECT r FROM ResidentialCategory AS r", ResidentialCategory.class);

        return query.getResultList();
    }
}

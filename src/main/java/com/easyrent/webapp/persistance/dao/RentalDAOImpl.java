package com.easyrent.webapp.persistance.dao;

import com.easyrent.webapp.persistance.entity.*;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sabir.salman on 4/26/15.
 */
@Repository
@Transactional
public class RentalDAOImpl implements RentalDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Rental getSpecificRentalDAO(int rentalId) {
        TypedQuery<Rental> query = entityManager.createQuery("SELECT r FROM Rental AS r WHERE r.id=:id", Rental.class);
        query.setParameter("id", rentalId);

        return getSingleResultOrNull(query);
    }

    @Override
    public Rental getSpecificRentalWithReviewsDAO(int rentalId) {
        Rental rental = getSpecificRentalDAO(rentalId);

        Hibernate.initialize(rental.getReviews());

        return rental;
    }

    @Override
    public void deleteRentalDAO(Integer rentalId) {
        Rental rental = entityManager.getReference(Rental.class, rentalId);
        entityManager.remove(rental);
    }

    @Override
    public List<String> getAreasDAO() {
        List<String> areas = entityManager.createNativeQuery("SELECT area FROM area").getResultList();

        return areas;
    }

    private Rental getSingleResultOrNull(TypedQuery<Rental> query) {
        query.setMaxResults(1);
        List<Rental> list = query.getResultList();
        if (list.isEmpty()) {

            return null;
        }

        return list.get(0);
    }
}

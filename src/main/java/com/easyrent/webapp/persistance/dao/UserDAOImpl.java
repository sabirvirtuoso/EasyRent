package com.easyrent.webapp.persistance.dao;

import com.easyrent.webapp.persistance.entity.CommercialRental;
import com.easyrent.webapp.persistance.entity.ResidentialRental;
import com.easyrent.webapp.persistance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sabir.salman on 4/8/2015.
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User loginUserDAO(String email, String password) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User AS u WHERE u.email=:email " +
                "AND u.password=:password", User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        return getSingleResultOrNull(query);
    }

    @Override
    public User getSpecificUserDAO(int userId) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User AS u WHERE u.id=:id", User.class);
        query.setParameter("id", userId);

        return getSingleResultOrNull(query);
    }

    @Override
    public void insertUserDAO(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<CommercialRental> getCommercialRentalsDAO(int userId) {
        TypedQuery<CommercialRental> query = entityManager.createQuery("SELECT c FROM CommercialRental c WHERE c.user.id=:id",
                CommercialRental.class);
        query.setParameter("id", userId);

        return query.getResultList();
    }

    @Override
    public List<ResidentialRental> getResidentialRentalsDAO(int userId) {
        TypedQuery<ResidentialRental> query = entityManager.createQuery("SELECT c FROM ResidentialRental c WHERE c.user.id=:id",
                ResidentialRental.class);
        query.setParameter("id", userId);

        return query.getResultList();
    }

    @Override
    public boolean validateEmailDAO(User userSignUp) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);

        for (User user : query.getResultList()) {
            if (user.getEmail().equals(userSignUp.getEmail())) {

                return false;
            }
        }

        return true;
    }

    private User getSingleResultOrNull(TypedQuery<User> query) {
        query.setMaxResults(1);
        List<User> list = query.getResultList();
        if (list.isEmpty()) {

            return null;
        }

        return list.get(0);
    }
}

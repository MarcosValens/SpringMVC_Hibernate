package com.valensmarcos.dao;

import com.valensmarcos.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImpDataBase implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public List<User> findAll() {

        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        javax.persistence.Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public User isValidUser(String userName, String password) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM User WHERE userName=:userName " + "AND password=:password";
        Query query = session.createQuery(hql);
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        try {
            return (User) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println(ex);
            return null;
        }
    }
}


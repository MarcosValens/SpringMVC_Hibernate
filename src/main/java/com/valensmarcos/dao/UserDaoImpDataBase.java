package com.valensmarcos.dao;

import com.valensmarcos.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
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
        return null;
    }

    @Override
    public void insert(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void delete(int id) {

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

    @Override
    public User findByUserNameAndId(String userName, String id) {
        return null;
    }
}


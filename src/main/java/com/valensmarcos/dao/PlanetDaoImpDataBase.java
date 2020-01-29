package com.valensmarcos.dao;

import com.valensmarcos.model.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PlanetDaoImpDataBase implements PlanetDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Planet findById(int id) {
        return null;
    }

    @Override
    public List<Planet> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Planet> cq = cb.createQuery(Planet.class); //indica que tipo de datos devolvera la query
        Root<Planet> root = cq.from(Planet.class); //indica sobre que tabla hara la query
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void insert(Planet planet) {

    }

    @Override
    public void edit(Planet planet) {

    }

    @Override
    public void delete(int id) {

    }
}

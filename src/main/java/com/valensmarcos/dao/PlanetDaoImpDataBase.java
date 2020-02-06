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
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Planet.class, id);
    }

    @Override
    public List<Planet> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Planet> cq = cb.createQuery(Planet.class);
        Root<Planet> root = cq.from(Planet.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void insertOrUpdate(Planet planet) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(planet);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Planet planet = session.byId(Planet.class).load(id);
        session.delete(planet);
    }
}

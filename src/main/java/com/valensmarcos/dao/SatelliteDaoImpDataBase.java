package com.valensmarcos.dao;

import com.valensmarcos.model.Satellite;
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
public class SatelliteDaoImpDataBase implements SatelliteDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Satellite> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Satellite> cq = cb.createQuery(Satellite.class);
        Root<Satellite> root = cq.from(Satellite.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void edit(Satellite satellite) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(satellite);
    }

    @Override
    public Satellite byId(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Satellite.class, id);
    }
}

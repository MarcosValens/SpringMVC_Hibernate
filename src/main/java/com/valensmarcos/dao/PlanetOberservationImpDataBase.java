package com.valensmarcos.dao;

import com.valensmarcos.model.Planet;
import com.valensmarcos.model.PlanetObservation;
import com.valensmarcos.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class PlanetOberservationImpDataBase implements PlanetObservationDao{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<PlanetObservation> observationList(int id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM PlanetObservation WHERE user.id=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);

        try {
            List<PlanetObservation> planetObservations = query.getResultList();
            return query.getResultList();
        } catch (NoResultException ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public void saveOrUpdate(Planet planet, User user, PlanetObservation observation) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        session.saveOrUpdate(planet);
        session.saveOrUpdate(observation);
    }
}

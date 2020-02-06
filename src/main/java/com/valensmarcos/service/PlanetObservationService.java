package com.valensmarcos.service;

import com.valensmarcos.dao.PlanetObservationDao;
import com.valensmarcos.model.Planet;
import com.valensmarcos.model.PlanetObservation;
import com.valensmarcos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetObservationService implements PlanetObservationQueryService {

    @Autowired
    PlanetObservationDao planetObservationDao;

    @Override
    public List<PlanetObservation> findAllFromUserId(int id) {

        return planetObservationDao.observationListByUserId(id);
    }

    @Override
    public void saveOrUpdate(PlanetObservation planetObservation) {

        planetObservationDao.saveOrUpdate(planetObservation);
    }

    @Override
    public PlanetObservation getByUserIdAndPlanetId(User user, Planet planet) {
        return planetObservationDao.getByUserIdAndPlanetId(user, planet);
    }
}

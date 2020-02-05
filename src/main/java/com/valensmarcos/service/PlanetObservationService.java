package com.valensmarcos.service;

import com.valensmarcos.dao.PlanetObservationDao;
import com.valensmarcos.model.PlanetObservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanetObservationService implements PlanetObservationQueryService {

    @Autowired
    PlanetObservationDao planetObservationDao;

    @Override
    public List<PlanetObservation> findAll(int id) {
        return planetObservationDao.observationList(id);
    }
}

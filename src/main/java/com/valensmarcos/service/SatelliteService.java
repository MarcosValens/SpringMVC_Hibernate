package com.valensmarcos.service;

import com.valensmarcos.dao.SatelliteDao;
import com.valensmarcos.model.Planet;
import com.valensmarcos.model.Satellite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SatelliteService implements SatelliteQueryService {

    @Autowired
    SatelliteDao satelliteDao;


    @Override
    public List<Satellite> exec() {
        return null;
    }

    @Override
    public void init() {

    }

    @Override
    public PlanetQueryService anyName(String... name) {
        return null;
    }

    @Override
    public PlanetQueryService byMass(int mass) {
        return null;
    }

    @Override
    public PlanetQueryService beTweenSpeed(int speed1, int speed2) {
        return null;
    }

    @Override
    public PlanetQueryService bePlanet(Planet planet) {
        return null;
    }

    @Override
    public List<Satellite> findAll() {
        return satelliteDao.findAll();
    }

    @Override
    public Satellite byId(long id) {
        return satelliteDao.byId(id);
    }

    @Override
    public void save(Satellite satellite) {
        satelliteDao.edit(satellite);
    }
}

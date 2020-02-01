package com.valensmarcos.service;

import javax.annotation.PostConstruct;

import com.valensmarcos.dao.PlanetDao;
import com.valensmarcos.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Service
public class PlanetService implements PlanetQueryService {

    @Autowired
    PlanetDao planetDao;
    private Predicate<Planet> predicate;

    @Override
    public List<Planet> exec() {
        return null;
    }

    @Override
    @PostConstruct
    public void init() {
        predicate = null;
    }

    @Override
    public PlanetQueryService anyName(String... name) {
        return null;
    }

    @Override
    public List<Planet> findAll() {
        return planetDao.findAll();
    }

    /*@Override
    public PlanetQueryService allPlanets(String... name) {
        Predicate<Planet> pAllPlanets = (planet -> Arrays.stream(name).allMatch(planet.getName()::contains));
        predicate = (predicate == null) ? pAllPlanets : predicate.and(pAllPlanets);
        return this;
    }*/

    @Override
    public PlanetQueryService byMass(int mass) {
        return null;
    }

    @Override
    public PlanetQueryService habitablePlanets(byte habitable) {
        return null;
    }

    @Override
    public void save(Planet planet){
        planetDao.insert(planet);
    }
}

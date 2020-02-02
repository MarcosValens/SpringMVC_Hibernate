package com.valensmarcos.service;

import com.valensmarcos.model.Planet;

import java.util.List;

public interface PlanetQueryService {

    List<Planet> exec();

    void init();

    PlanetQueryService anyName(String... name);

    PlanetQueryService byMass(int mass);

    PlanetQueryService habitablePlanets(byte habitable);

    List<Planet> findAll();

    Planet getById(int id);

    void save(Planet planet);

    void delete(int id);
}

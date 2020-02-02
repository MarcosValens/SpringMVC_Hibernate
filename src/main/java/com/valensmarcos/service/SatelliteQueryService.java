package com.valensmarcos.service;

import com.valensmarcos.model.Planet;
import com.valensmarcos.model.Satellite;

import java.util.List;

public interface SatelliteQueryService {

    List<Satellite> exec();

    void init();

    PlanetQueryService anyName(String... name);

    PlanetQueryService byMass(int mass);

    PlanetQueryService beTweenSpeed(int speed1, int speed2);

    PlanetQueryService bePlanet(Planet planet);

    List<Satellite> findAll();

    Satellite byId(long id);

    void save(Satellite satellite);
}

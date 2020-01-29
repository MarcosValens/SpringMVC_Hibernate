package com.valensmarcos.service;

import com.valensmarcos.model.Planet;

import java.util.List;

public interface PlanetQueryService {

    List<Planet> exec();

    void init();

    PlanetQueryService anyName(String... name);

    PlanetQueryService allPlanets(String... name);

    PlanetQueryService byMass(int mass);

    PlanetQueryService habitablePlanets(byte habitable);
}

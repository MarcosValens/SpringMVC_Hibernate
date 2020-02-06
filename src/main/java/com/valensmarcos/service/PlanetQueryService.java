package com.valensmarcos.service;

import com.valensmarcos.model.Planet;

import java.util.List;

public interface PlanetQueryService {

    List<Planet> findAll();

    Planet getById(int id);

    void saveOrUpdate(Planet planet);

    void delete(int id);
}

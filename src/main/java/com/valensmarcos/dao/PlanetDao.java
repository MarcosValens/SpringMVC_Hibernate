package com.valensmarcos.dao;

import com.valensmarcos.model.Planet;

import java.util.List;

public interface PlanetDao {
    Planet findById(int id);

    List<Planet> findAll();

    void insert(Planet planet);

    void edit(Planet planet);

    void delete(int id);
}

package com.valensmarcos.dao;

import com.valensmarcos.model.Satellite;

import java.util.List;

public interface SatelliteDao {

    List<Satellite> findAll();
    void edit(Satellite satellite);
    Satellite byId(long id);
}

package com.valensmarcos.service;

import com.valensmarcos.model.Satellite;

import java.util.List;

public interface SatelliteQueryService {

    List<Satellite> findAll();

    Satellite byId(long id);

    void saveOrUpdate(Satellite satellite);
}

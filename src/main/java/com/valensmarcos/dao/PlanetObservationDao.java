package com.valensmarcos.dao;

import com.valensmarcos.model.PlanetObservation;

import java.util.List;

public interface PlanetObservationDao {

    List<PlanetObservation> observationListByUserId(int id);

    void saveOrUpdate(PlanetObservation observation);
}

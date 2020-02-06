package com.valensmarcos.service;

import com.valensmarcos.model.PlanetObservation;

import java.util.List;

public interface PlanetObservationQueryService {
    List<PlanetObservation> findAllFromUserId(int id);

    void saveOrUpdate(PlanetObservation planetObservation);
}

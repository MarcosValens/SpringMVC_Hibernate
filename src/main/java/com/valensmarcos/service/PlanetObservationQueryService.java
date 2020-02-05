package com.valensmarcos.service;

import com.valensmarcos.model.PlanetObservation;

import java.util.List;

public interface PlanetObservationQueryService {
    List<PlanetObservation> findAll(int id);
}

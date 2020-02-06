package com.valensmarcos.service;

import com.valensmarcos.model.Planet;
import com.valensmarcos.model.PlanetObservation;
import com.valensmarcos.model.User;

import java.util.List;

public interface PlanetObservationQueryService {
    List<PlanetObservation> findAllFromUserId(int id);

    void saveOrUpdate(PlanetObservation planetObservation);

    PlanetObservation getByUserIdAndPlanetId(User user, Planet planet);
}

package com.valensmarcos.dao;

import com.valensmarcos.model.Planet;
import com.valensmarcos.model.PlanetObservation;
import com.valensmarcos.model.User;

import java.util.List;

public interface PlanetObservationDao {

    List<PlanetObservation> observationListByUserId(int id);

    PlanetObservation getByUserIdAndPlanetId(User user, Planet planet);

    void saveOrUpdate(PlanetObservation observation);
}

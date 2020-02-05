package com.valensmarcos.dao;

import com.valensmarcos.model.Planet;
import com.valensmarcos.model.PlanetObservation;
import com.valensmarcos.model.User;

import java.util.List;

public interface PlanetObservationDao {

    List<PlanetObservation> observationList(int id);

    void saveOrUpdate(Planet planet, User user, PlanetObservation observation);
}

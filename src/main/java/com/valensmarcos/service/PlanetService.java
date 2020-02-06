package com.valensmarcos.service;

import com.valensmarcos.dao.PlanetDao;
import com.valensmarcos.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService implements PlanetQueryService {

    @Autowired
    PlanetDao planetDao;

    @Override
    public List<Planet> findAll() {
        return planetDao.findAll();
    }

    @Override
    public Planet getById(int id){
        return planetDao.findById(id);
    }

    @Override
    public void saveOrUpdate(Planet planet){
        planetDao.insertOrUpdate(planet);
    }

    @Override
    public void delete(int id) {
        planetDao.delete(id);
    }
}

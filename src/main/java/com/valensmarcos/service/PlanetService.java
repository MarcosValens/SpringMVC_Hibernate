package com.valensmarcos.service;

import com.valensmarcos.dao.PlanetDao;
import com.valensmarcos.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanetService {

    @Autowired
    PlanetDao planetDao;

    @Autowired
    PlanetQueryService planetQueryService;

    public void restart() {
        this.planetQueryService.init();
    }

    @Transactional
    public List<Planet> findAll() {
        return planetDao.findAll();
    }

}

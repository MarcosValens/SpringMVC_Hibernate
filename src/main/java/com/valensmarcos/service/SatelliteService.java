package com.valensmarcos.service;

import com.valensmarcos.dao.SatelliteDao;
import com.valensmarcos.model.Satellite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SatelliteService implements SatelliteQueryService {

    @Autowired
    SatelliteDao satelliteDao;

    @Override
    public List<Satellite> findAll() {
        return satelliteDao.findAll();
    }

    @Override
    public Satellite byId(long id) {
        return satelliteDao.byId(id);
    }

    @Override
    public void saveOrUpdate(Satellite satellite) {
        satelliteDao.edit(satellite);
    }
}

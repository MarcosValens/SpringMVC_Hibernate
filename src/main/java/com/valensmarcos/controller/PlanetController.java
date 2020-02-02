package com.valensmarcos.controller;

import com.valensmarcos.model.Planet;
import com.valensmarcos.model.Satellite;
import com.valensmarcos.service.PlanetService;
import com.valensmarcos.service.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Transactional
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @Autowired
    SatelliteService satelliteService;

    @GetMapping("/planets")
    public String getPlanets(Model model) {
        List<Planet> planets = planetService.findAll();
        List<Satellite> satellites = satelliteService.findAll();
        model.addAttribute("planets", planets);
        model.addAttribute("satellites", satellites);
        return "planets";
    }
}

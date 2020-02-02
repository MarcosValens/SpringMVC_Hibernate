package com.valensmarcos.controller;

import com.valensmarcos.model.Planet;
import com.valensmarcos.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Transactional
public class PlanetDeleteController {

    @Autowired
    private PlanetService planetService;

    @PostMapping("/deletePlanet")
    public String toPlanetForm(Model model, @RequestParam("idPlanet") String id) {
        planetService.delete(Integer.parseInt(id));
        List<Planet> planets = planetService.findAll();
        model.addAttribute("planets", planets);
        return "planets";
    }
}

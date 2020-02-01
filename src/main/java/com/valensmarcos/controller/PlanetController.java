package com.valensmarcos.controller;

import com.valensmarcos.model.Planet;
import com.valensmarcos.service.PlanetService;
import com.valensmarcos.service.PlanetServiceImp;
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
    private PlanetServiceImp planetServiceImp;

    @GetMapping("/planets")
    public String getPlanets(Model model) {
        List<Planet> planets = planetServiceImp.findAll();
        System.out.println(planets);
        model.addAttribute("planets", planets);
        return "planets";
    }
}

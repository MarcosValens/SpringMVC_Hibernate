package com.valensmarcos.controller;

import com.valensmarcos.model.Planet;
import com.valensmarcos.model.PlanetObservation;
import com.valensmarcos.model.Satellite;
import com.valensmarcos.model.User;
import com.valensmarcos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Transactional
public class PlanetController {

    @Autowired
    private PlanetQueryService planetService;

    @Autowired
    private SatelliteQueryService satelliteService;

    @Autowired
    private UserQueryService userService;

    @Autowired
    private PlanetObservationQueryService planetObservationQueryService;

    @GetMapping("/planets")
    public String getPlanets(Model model, HttpServletRequest request) {
        List<Planet> planets = planetService.findAll();
        List<Satellite> satellites = satelliteService.findAll();
        int userId = 0;
        if (request.getSession().getAttribute("userId") != null) {
            userId = (int) request.getSession().getAttribute("userId");
        }
        if (userId != 0) {
            User user = userService.findById(userId);
            List<PlanetObservation> planetObservations = planetObservationQueryService.findAllFromUserId(userId);
            model.addAttribute("user", user);
            model.addAttribute("observation", planetObservations);
        }
        model.addAttribute("planets", planets);
        model.addAttribute("satellites", satellites);
        return "planets";
    }
}


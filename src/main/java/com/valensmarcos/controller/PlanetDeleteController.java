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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Transactional
public class PlanetDeleteController {

    @Autowired
    private PlanetQueryService planetService;

    @Autowired
    private SatelliteQueryService satelliteService;

    @Autowired
    private UserQueryService userService;

    @Autowired
    private PlanetObservationQueryService planetObservationQueryService;

    @PostMapping("/deletePlanet")
    public String toPlanetForm(@RequestParam("idPlanet") String id, Model model, HttpServletRequest request) {

        planetService.delete(Integer.parseInt(id));
        HttpSession session = request.getSession();
        User user = userService.findById((int) session.getAttribute("userId"));
        List<Planet> planets = planetService.findAll();
        List<Satellite> satellites = satelliteService.findAll();
        List<PlanetObservation> planetObservations = planetObservationQueryService.findAllFromUserId(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("planets", planets);
        model.addAttribute("satellites", satellites);
        model.addAttribute("observation", planetObservations);
        return "planets";
    }
}

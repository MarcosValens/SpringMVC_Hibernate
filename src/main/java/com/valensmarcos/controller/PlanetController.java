package com.valensmarcos.controller;

import com.valensmarcos.model.Planet;
import com.valensmarcos.model.PlanetObservation;
import com.valensmarcos.model.Satellite;
import com.valensmarcos.model.User;
import com.valensmarcos.service.PlanetObservationQueryService;
import com.valensmarcos.service.PlanetService;
import com.valensmarcos.service.SatelliteService;
import com.valensmarcos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @Autowired
    SatelliteService satelliteService;

    @Autowired
    UserService userService;

    @Autowired
    PlanetObservationQueryService planetObservationQueryService;

    @GetMapping("/planets")
    public String getPlanets(Model model, HttpServletRequest request) {
        List<Planet> planets = planetService.findAll();
        List<Satellite> satellites = satelliteService.findAll();
        int userId = (int)request.getSession().getAttribute("userId");
        if (userId != 0){
            User user = userService.findById(userId);
            List<PlanetObservation> planetObservations = planetObservationQueryService.findAll(userId);
            model.addAttribute("user",user);
            model.addAttribute("observation",planetObservations);
        }
        model.addAttribute("planets", planets);
        model.addAttribute("satellites", satellites);
        return "planets";
    }
}

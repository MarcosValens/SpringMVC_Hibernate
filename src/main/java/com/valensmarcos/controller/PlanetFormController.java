package com.valensmarcos.controller;

import com.valensmarcos.model.Planet;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Transactional
public class PlanetFormController {

    @Autowired
    private PlanetService planetService;

    @Autowired
    private SatelliteService satelliteService;

    @Autowired
    private UserService userService;

    @Autowired
    private PlanetObservationQueryService planetObservationQueryService;

    @GetMapping("/planetForm")
    public String savePlanet(Model model) {
        List<Satellite> satellites = satelliteService.findAll();
        model.addAttribute("satellites", satellites);
        return "addPlanet";
    }

    @GetMapping("/planetForm/{idPlanet}")
    public String updatePlanet(Model model, @PathVariable(value = "idPlanet", required = false) String idPlanet) {
        if (idPlanet != null) {
            Planet planet = planetService.getById(Integer.parseInt(idPlanet));
            model.addAttribute("planet", planet);
        }
        List<Satellite> satellites = satelliteService.findAll();
        model.addAttribute("satellites", satellites);
        return "addPlanet";
    }

    @PostMapping("/planetForm/savePlanet")
    public RedirectView save(HttpServletRequest request,
                             @RequestParam("idPlanet") String idPlanet,
                             @RequestParam("namePlanet") String namePlanet,
                             @RequestParam("massPlanet") String massPlanet,
                             @RequestParam(value = "habitablePlanet", required = false) String habitablePlanet,
                             @RequestParam(value = "satellitesPlanet", required = false) String satellitesPlanet,
                             @RequestParam(value = "observation", required = false) String observation) {
        Planet planet = new Planet();
        planet.setName(namePlanet);
        planet.setMass(Long.parseLong(massPlanet));
        if (habitablePlanet != null) {
            if (habitablePlanet.equals("YES")) {
                planet.setHabitable((byte) 1);
            } else {
                planet.setHabitable((byte) 0);
            }
        }
        if (!idPlanet.equals("")) {
            planet.setId(Integer.parseInt(idPlanet));
        }
        planetService.save(planet);
        if (satellitesPlanet != null) {
            String[] satellitesForUpdate = satellitesPlanet.split(",");
            for (String satelliteId : satellitesForUpdate) {
                Satellite updatedSatellite = satelliteService.byId(Long.parseLong(satelliteId));
                updatedSatellite.setPlanet(planet);
                satelliteService.save(updatedSatellite);
            }
        }
        return new RedirectView("../planets");
    }
}

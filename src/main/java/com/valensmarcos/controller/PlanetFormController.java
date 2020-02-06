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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Transactional
public class PlanetFormController {

    @Autowired
    private PlanetQueryService planetService;

    @Autowired
    private SatelliteQueryService satelliteService;

    @Autowired
    private UserQueryService userService;

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

        Planet planet = planetService.getById(Integer.parseInt(idPlanet));
        model.addAttribute("planet", planet);
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

        HttpSession session = request.getSession();
        User user = userService.findById((int) session.getAttribute("userId"));
        PlanetObservation planetObservation = new PlanetObservation();
        Planet planet;
        if (!idPlanet.equals("")) {
            planet = planetService.getById(Integer.parseInt(idPlanet));
            planetObservation = planetObservationQueryService.getByUserIdAndPlanetId(user,planet);
        } else {
            planet = new Planet();
        }
        planet.setName(namePlanet);
        planet.setMass(Long.parseLong(massPlanet));
        if (habitablePlanet != null) {
            if (habitablePlanet.equals("YES")) {
                planet.setHabitable((byte) 1);
            } else {
                planet.setHabitable((byte) 0);
            }
        }
        planetObservation.setPlanet(planet);
        planetObservation.setUser(user);
        if (!observation.equals("")) {
            planetObservation.setObservations(observation);
        } else planetObservation.setObservations(null);
        planetService.saveOrUpdate(planet);
        planetObservationQueryService.saveOrUpdate(planetObservation);
        if (satellitesPlanet != null) {
            String[] satellitesForUpdate = satellitesPlanet.split(",");
            for (String satelliteId : satellitesForUpdate) {
                Satellite updatedSatellite = satelliteService.byId(Long.parseLong(satelliteId));
                updatedSatellite.setPlanet(planet);
                satelliteService.saveOrUpdate(updatedSatellite);
            }
        }
        return new RedirectView("../planets");
    }
}

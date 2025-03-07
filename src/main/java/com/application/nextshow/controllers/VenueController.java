package com.application.nextshow.controllers;

import com.application.nextshow.dtos.ScreenLayoutDTO;
import com.application.nextshow.dtos.VenueDTO;
import com.application.nextshow.entities.ScreenLayouts;
import com.application.nextshow.repositories.ScreenLayoutRepository;
import com.application.nextshow.services.VenueService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/venues")
public class VenueController {
    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }
    @GetMapping
    public List<VenueDTO> getFilteredVenues(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String format) {
        return venueService.getFilteredVenues(city, format);
    }

//    @PostMapping("/layout")
//    public String getJson(@RequestBody ScreenLayouts screenLayout){
//        screenLayoutRepository.save(screenLayout);
//        return screenLayout.getLayout();
//    }

    @GetMapping("/{id}")
    public Optional<VenueDTO> findVenueById(@PathVariable(name = "id") UUID id){
        return venueService.findVenueById(id);
    }

    @PostMapping("/bulk")
    public List<VenueDTO> saveAllVenues(@RequestBody List<VenueDTO> venueDTOList){
        return venueService.saveAllVenues(venueDTOList);
    }

    @PostMapping
    public VenueDTO saveVenue(@RequestBody VenueDTO venueDTO) {
        return venueService.saveVenue(venueDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteVenue(@PathVariable(name = "id") UUID id){
        venueService.deleteVenueById(id);
    }
}

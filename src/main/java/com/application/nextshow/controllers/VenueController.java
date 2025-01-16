package com.application.nextshow.controllers;

import com.application.nextshow.dtos.VenueDTO;
import com.application.nextshow.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
            @RequestParam(required = false) String[] formats) {
        return venueService.getFilteredVenues(city, formats);
    }

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

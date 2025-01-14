package com.application.nextshow.controllers;

import com.application.nextshow.dtos.VenueDTO;
import com.application.nextshow.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class VenueController {
    private final VenueService venueService;

    @Autowired
    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }
    @GetMapping(value = "/api/v1/venues")
    public List<VenueDTO> getFilteredVenues(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String[] formats)
    {
        return venueService.getFilteredVenues(city, formats);
    }



    @GetMapping(value = "/api/v1/venues/{id}")
    public Optional<VenueDTO> findVenueById(@PathVariable(name = "id") UUID id){
        return venueService.findVenueById(id);
    }

    @PostMapping(value = "/api/v1/save-all-venues")
    public List<VenueDTO> saveAllVenues(@RequestBody List<VenueDTO> venueDTOList){
        return venueService.saveAllVenues(venueDTOList);
    }

    @PostMapping(value = "/api/v1/save-venue")
    public VenueDTO saveVenue(@RequestBody VenueDTO venueDTO) {
        return venueService.saveVenue(venueDTO);
    }
    @DeleteMapping(value = "/api/v1/delete-venue/{id}")
    public void deleteVenue(@PathVariable(name = "id") UUID id){
        venueService.deleteVenueById(id);
    }
}

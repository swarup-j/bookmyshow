package com.application.nextshow.services;

import com.application.nextshow.dtos.VenueDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VenueService {
     List<VenueDTO> getFilteredVenues(String city, String[] formats);
    Optional<VenueDTO> findVenueById(UUID id);
    List<VenueDTO> saveAllVenues(List<VenueDTO> venueDTOS);
    VenueDTO saveVenue(VenueDTO venueDTO);
    void deleteVenueById(UUID id);



}

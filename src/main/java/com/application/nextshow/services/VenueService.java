package com.application.nextshow.services;

import com.application.nextshow.dtos.VenueDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VenueService {
    List<VenueDTO> getFilteredVenues(String city, String format);
    Optional<VenueDTO> findVenueById(UUID id);
    List<VenueDTO> saveAllVenues(List<VenueDTO> venueDTOS);
    VenueDTO saveVenue(VenueDTO venueDTO);
    void deleteVenueById(UUID id);
    Optional<VenueDTO> updateVenue(UUID id, VenueDTO venueDTO);



}

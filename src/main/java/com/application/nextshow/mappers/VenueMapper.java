package com.application.nextshow.mappers;

import com.application.nextshow.dtos.VenueDTO;
import com.application.nextshow.entities.Venue;
import org.springframework.stereotype.Component;

@Component

public class VenueMapper {
    public VenueDTO toDTO(Venue venue){
        return VenueDTO.builder()
                .id(venue.getId())
                .city(venue.getCity())
                .name(venue.getName())
                .address(venue.getAddress())
                .screens(venue.getScreens())
                .venueType(venue.getVenueType())
                .coordinates(venue.getCoordinates())
                .description(venue.getDescription())
                .facilities(venue.getFacilities())
                .thumbnail(venue.getThumbnail())
                .availableFormats(venue.getAvailableFormats())
                .build();
    }


    public Venue fromDTO(VenueDTO venueDTO){
        return Venue.builder()
                .id(venueDTO.getId())
                .city(venueDTO.getCity())
                .name(venueDTO.getName())
                .address(venueDTO.getAddress())
                .screens(venueDTO.getScreens())
                .venueType(venueDTO.getVenueType())
                .coordinates(venueDTO.getCoordinates())
                .description(venueDTO.getDescription())
                .facilities(venueDTO.getFacilities())
                .thumbnail(venueDTO.getThumbnail())
                .availableFormats(venueDTO.getAvailableFormats())
                .build();
    }

}

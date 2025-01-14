package com.application.nextshow.dtos;

import com.application.nextshow.entities.enums.VenueType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VenueDTO {

    private UUID id;
    private String name;
    private String description;
    //Column(nullable = false)
    private VenueType venueType;
    //@Column(nullable = false)
    private String address;
    private String city;
    private String[] facilities;
    private String[] availableFormats;
    private Integer screens;
    private  Double[] coordinates;
    private String thumbnail;
}

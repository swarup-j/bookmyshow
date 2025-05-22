package com.application.nextshow.dtos;

import com.application.nextshow.entities.Venue;
import com.application.nextshow.entities.enums.ActivityType;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ActivityDTO {

    private UUID id;
    private String title;
    private ActivityType category;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
    private UUID venueId;
    private Venue venue;
    private String[] formats;
    private String[] genres;
    private String description;
    private String[] movieCast;
    private String[] crew;
    private Integer duration;
    private String[] artists;
    private String[] languages;
    private String trailer;
    private Double rating;
}

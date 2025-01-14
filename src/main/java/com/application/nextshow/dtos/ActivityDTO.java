package com.application.nextshow.dtos;

import com.application.nextshow.entities.enums.ActivityType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    //  @ManyToOne

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

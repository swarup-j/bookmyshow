package com.application.nextshow.entities;


import com.application.nextshow.entities.enums.ActivityType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private ActivityType category;

//    @Column(nullable = false)
@JsonFormat(pattern = "yyyy-MM-dd")
private LocalDate date;

  //  @ManyToOne
//    @Column(nullable = false)
    private UUID venueId;
    private String[] formats;
    private String[] genres;
    private String description;
    private String[] movieCast;
    //save as a json
    private String[] crew;
    private Integer duration;
    private String[] artists;
    private String[] languages;
    private String trailer;
    private Double rating;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;


}

package com.application.nextshow.entities;

import com.application.nextshow.entities.enums.VenueType;
import com.application.nextshow.entities.utils.Coordinates;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;
    private String name;
    private String description;
    //@Column(nullable = false)
    private VenueType venueType;
    // @Column(nullable = false)
    private String address;
    private String city;
    private String[] facilities;

    private String[] formats;


    private Integer screens;
    private  Double[] coordinates;
    private String thumbnail;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.created = now;
        this.updated = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.updated = LocalDateTime.now();
    }

}

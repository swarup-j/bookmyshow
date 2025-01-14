package com.application.nextshow.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueScreens {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    //@ManyToOne
    private UUID VenueId;
    private String name;
    //@OneToOne
    private UUID layoutId;



}

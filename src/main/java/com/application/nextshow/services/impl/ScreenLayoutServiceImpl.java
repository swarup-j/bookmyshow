package com.application.nextshow.services.impl;

import com.application.nextshow.dtos.ScreenLayoutDTO;
import com.application.nextshow.entities.ScreenLayout;
import com.application.nextshow.repositories.ScreenLayoutRepository;
import com.application.nextshow.services.ScreenLayoutService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScreenLayoutServiceImpl implements ScreenLayoutService {

    private final ScreenLayoutRepository screenLayoutRepository;
    private final ObjectMapper objectMapper; // Add ObjectMapper to handle JSON parsing

    @Autowired
    public ScreenLayoutServiceImpl(ScreenLayoutRepository screenLayoutRepository, ObjectMapper objectMapper) {
        this.screenLayoutRepository = screenLayoutRepository;
        this.objectMapper = objectMapper;
    }

    // Method to save a new screen layout
    public ScreenLayout saveScreenLayout(ScreenLayoutDTO screenLayoutRequest) throws IOException {
        // Create a new ScreenLayout entity
        ScreenLayout screenLayout = new ScreenLayout();

        // Set the name
        screenLayout.setName(screenLayoutRequest.getName());

        // Use ObjectMapper to deserialize the JSON layout into a JsonNode
        JsonNode layoutJsonNode = objectMapper.readTree(screenLayoutRequest.getLayout().traverse()); // Deserialize JSON layout
        screenLayout.setLayout(layoutJsonNode); // Set the layout in the entity

        return screenLayoutRepository.save(screenLayout); // Save the ScreenLayout entity to the database
    }

    // Method to get a screen layout by ID
    public Optional<ScreenLayout> getScreenLayout(UUID id) {
        return screenLayoutRepository.findById(id); // Retrieve ScreenLayout by ID from the database
    }

    // Method to delete a screen layout by ID
    public void deleteScreenLayout(UUID id) {
        screenLayoutRepository.deleteById(id); // Delete the ScreenLayout by ID
    }

    // Method to update an existing screen layout by ID
    public ScreenLayout updateScreenLayout(UUID id, ScreenLayoutDTO screenLayoutRequest) throws IOException {
        return screenLayoutRepository.findById(id)
                .map(existingLayout -> {
                    // Update fields
                    existingLayout.setName(screenLayoutRequest.getName());

                    // Deserialize the new layout JSON
                    try {
                        JsonNode newLayoutJsonNode = objectMapper.readTree(screenLayoutRequest.getLayout().traverse()); // Deserialize layout
                        existingLayout.setLayout(newLayoutJsonNode); // Set the updated layout
                    } catch (IOException e) {
                        throw new RuntimeException("Error parsing layout JSON", e);
                    }

                    // Save the updated ScreenLayout
                    return screenLayoutRepository.save(existingLayout);
                })
                .orElseThrow(() -> new RuntimeException("Screen layout not found"));
    }
}

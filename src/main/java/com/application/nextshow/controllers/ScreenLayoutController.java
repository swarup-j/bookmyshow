package com.application.nextshow.controllers;

import com.application.nextshow.dtos.ScreenLayoutDTO;
import com.application.nextshow.entities.ScreenLayout;
import com.application.nextshow.services.ScreenLayoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/screen") // Base URL for screen layout endpoints
public class ScreenLayoutController {

    private final ScreenLayoutService screenLayoutService;

    public ScreenLayoutController(ScreenLayoutService screenLayoutService) {
        this.screenLayoutService = screenLayoutService;
    }

    // POST request to create a new screen layout
    @PostMapping
    public ResponseEntity<String> createScreenLayout(@RequestBody ScreenLayoutDTO screenLayoutRequest) {
        try {
            // Save the screen layout
            screenLayoutService.saveScreenLayout(screenLayoutRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Screen layout created successfully"); // Return success response
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create screen layout"); // Handle errors
        }
    }

    // GET request to retrieve a screen layout by ID
    @GetMapping("/{id}")
    public ResponseEntity<ScreenLayout> getScreenLayout(@PathVariable UUID id) {
        return screenLayoutService.getScreenLayout(id)
                .map(ResponseEntity::ok) // Return the screen layout if found
                .orElse(ResponseEntity.notFound().build()); // Return 404 if not found
    }

    // PUT request to update an existing screen layout by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateScreenLayout(@PathVariable UUID id, @RequestBody ScreenLayoutDTO screenLayoutRequest) {
        try {
            screenLayoutService.updateScreenLayout(id, screenLayoutRequest); // Update the screen layout
            return ResponseEntity.status(HttpStatus.OK).body("Screen layout updated successfully"); // Return success response
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update screen layout"); // Handle errors
        }
    }

    // DELETE request to delete a screen layout by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteScreenLayout(@PathVariable UUID id) {
        try {
            screenLayoutService.deleteScreenLayout(id); // Delete the screen layout
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Screen layout deleted successfully"); // Return success response
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete screen layout"); // Handle errors
        }
    }
}


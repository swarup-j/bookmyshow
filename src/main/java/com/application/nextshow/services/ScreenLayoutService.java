package com.application.nextshow.services;

import com.application.nextshow.dtos.ScreenLayoutDTO;
import com.application.nextshow.entities.ScreenLayout;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ScreenLayoutService {
    ScreenLayout saveScreenLayout(ScreenLayoutDTO screenLayoutRequest)  throws IOException;

    Optional<ScreenLayout> getScreenLayout(UUID id);

    void deleteScreenLayout(UUID id);

    ScreenLayout updateScreenLayout(UUID id, ScreenLayoutDTO screenLayoutRequest)  throws IOException;
}
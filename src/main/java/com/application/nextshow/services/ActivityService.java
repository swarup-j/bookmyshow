package com.application.nextshow.services;

import com.application.nextshow.dtos.ActivityDTO;
import com.application.nextshow.entities.Activity;
import com.application.nextshow.entities.enums.ActivityType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ActivityService {
    List<ActivityDTO> fetchAllActivities();;
  ActivityDTO findById(UUID id);
   Optional<ActivityDTO> findByTitle(String title);
   ActivityDTO saveActivity(ActivityDTO activityDTO);
   void deleteActivity(UUID id);
    public List<ActivityDTO> getActivitiesByFilters(ActivityType category, String[] formats, String[] genres,
                                                 String[] languages, LocalDate releaseDateBefore,
                                                 LocalDate releaseDateAfter, String venue,
                                                 Double rating);
    List<ActivityDTO> saveAllActivities(List<ActivityDTO> activityDTOList);
}

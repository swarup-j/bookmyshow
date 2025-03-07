package com.application.nextshow.services.impl;

import com.application.nextshow.dtos.ActivityDTO;
import com.application.nextshow.entities.Activity;

import com.application.nextshow.entities.Venue;
import com.application.nextshow.entities.enums.ActivityType;
import com.application.nextshow.mappers.ActivityMapper;
import com.application.nextshow.repositories.ActivityRepository;
import com.application.nextshow.repositories.VenueRepository;
import com.application.nextshow.services.ActivityService;
import com.application.nextshow.specifications.ActivitySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;
    private final  VenueRepository venueRepository;
    private final ActivityMapper activitymapper;


    public ActivityServiceImpl(ActivityRepository activityRepository, VenueRepository venueRepository, ActivityMapper activitymapper) {
        this.activityRepository = activityRepository;
        this.venueRepository = venueRepository;
        this.activitymapper = activitymapper;
    }


@Override
public List<ActivityDTO> getActivitiesByFilters(ActivityType category, String[] formats, String[] genres,
                                             String[] languages, LocalDate releaseDateBefore,
                                             LocalDate releaseDateAfter, String venue,
                                             Double rating) {
    // Create the specification for filtering by category, formats, genres, etc.
    Specification<Activity> spec = ActivitySpecification.withFilters(category, formats, genres, languages,
            releaseDateBefore, releaseDateAfter, venue, rating);

    // Find all activities matching the specification
    List<Activity> activityList = activityRepository.findAll(spec);
    return activityList.stream().
            map(activitymapper::toDTO)
            .collect(Collectors.toList());
}
    @Override
    public List<ActivityDTO> saveAllActivities(List<ActivityDTO> activityDTOList) {

        List<Activity> activities = activityDTOList.stream().map(activitymapper::fromDTO).collect(Collectors.toList());
        activityRepository.saveAll(activities);
        return activityDTOList;
    }

    @Override
    public List<ActivityDTO> fetchAllActivities() {
        List<Activity> activities =activityRepository.findAll(); // Retrieve all entities from DB
        return activities.stream()
                .map(activitymapper::toDTO)  // Convert each Entity to Dto
                .collect(Collectors.toList());
    }


    @Override
    public ActivityDTO findById(UUID id) {
          Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return activitymapper.toDTO(activity);
    }

    @Override
    public Optional<ActivityDTO> findByTitle(String title) {
      Activity activity = activityRepository.findByTitle(title);

        return Optional.of(activitymapper.toDTO(activity));
    }

    @Override
    public ActivityDTO saveActivity(ActivityDTO activityDTO) {


        Venue venue = venueRepository.findById(activityDTO.getVenueId())
                .orElseThrow(()-> new RuntimeException("venue not found with id"+ activityDTO.getVenueId()));

        Activity activity = activitymapper.fromDTO(activityDTO);

         activityRepository.save(activity );
         return activitymapper.toDTO(activity);

    }

    @Override
    public void deleteActivity(UUID id) {
             activityRepository.deleteById(id);
    }


}

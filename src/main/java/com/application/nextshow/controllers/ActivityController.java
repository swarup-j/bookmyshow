package com.application.nextshow.controllers;

import com.application.nextshow.dtos.ActivityDTO;
import com.application.nextshow.dtos.ShowDTO;
import com.application.nextshow.entities.Activity;
import com.application.nextshow.entities.enums.ActivityType;
import com.application.nextshow.services.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/activities")
public class ActivityController {
    @Autowired
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<ActivityDTO> getAllActivities(){
        return activityService.fetchAllActivities();
    }

    @GetMapping(value = "/filter")
    public List<ActivityDTO> getActivitiesByFilters(
            @RequestParam(required = false) ActivityType category,
            @RequestParam(required = false) String[] formats,
            @RequestParam(required = false) String[] genres,
            @RequestParam(required = false) String[] languages,
            @RequestParam(required = false) LocalDate releaseDateBefore,
            @RequestParam(required = false) LocalDate releaseDateAfter,
            @RequestParam(required = false) String venue,
            @RequestParam(required = false) Double rating) {
        return activityService.getActivitiesByFilters(category, formats, genres, languages, releaseDateBefore, releaseDateAfter, venue, rating);
    }


    @GetMapping("/{id}")
    public ActivityDTO findById(@PathVariable(name = "id") UUID id){
        log.info(String.valueOf(id));
        return activityService.findById(id);
    }

    @GetMapping("/title/{title}")
    public Optional<ActivityDTO> findByTitle(@PathVariable(name = "title")  String title){
        return activityService.findByTitle(title);
    }

    @PostMapping
    public ActivityDTO saveActivity(@RequestBody ActivityDTO activityDTO ){
        return activityService.saveActivity(activityDTO);

    }
    @PostMapping(   "/bulk")
    public List<ActivityDTO> saveAllActivities(@RequestBody List<ActivityDTO> activityDTOList){
        return activityService.saveAllActivities(activityDTOList);
    }
    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable(name = "id") UUID id){
         activityService.deleteActivity(id);
    }


}

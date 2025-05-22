package com.application.nextshow.mappers;

import com.application.nextshow.dtos.ActivityDTO;
import com.application.nextshow.entities.Activity;
import com.application.nextshow.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivityMapper {




    private final VenueRepository venueRepository;

    public ActivityMapper(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }


    public  ActivityDTO toDTO(Activity activity){
        return ActivityDTO.builder()
                .id(activity.getId())
                .title(activity.getTitle())
                .category(activity.getCategory())
                .date(activity.getDate())
                .formats(activity.getFormats())
                .genres(activity.getGenres())
                .description(activity.getDescription())
                .movieCast(activity.getMovieCast())
                .crew(activity.getCrew())
                .venue(activity.getVenue())
                .rating(activity.getRating())
                .duration(activity.getDuration())
                .artists(activity.getArtists())
                .trailer(activity.getTrailer())
                .languages(activity.getLanguages())
                .build();
    }
    public  Activity fromDTO(ActivityDTO activityDTO){
        return Activity.builder()
                .id(activityDTO.getId())
                .venue(venueRepository.findById(activityDTO.getVenueId())
                        .orElseThrow(()->new RuntimeException("venue not found"))

                )
                .title(activityDTO.getTitle())
                .category(activityDTO.getCategory())
                .date(activityDTO.getDate())
                .formats(activityDTO.getFormats())
                .genres(activityDTO.getGenres())
                .description(activityDTO.getDescription())
                .movieCast(activityDTO.getMovieCast())
                .crew(activityDTO.getCrew())
                .rating(activityDTO.getRating())
                .duration(activityDTO.getDuration())
                .artists(activityDTO.getArtists())
                .trailer(activityDTO.getTrailer())
                .languages(activityDTO.getLanguages())
                .build();

    }




}

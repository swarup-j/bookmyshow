package com.application.nextshow.mappers;

import com.application.nextshow.dtos.ShowDTO;
import com.application.nextshow.entities.Show;
import org.springframework.stereotype.Component;

@Component

public class ShowMapper {
    public ShowDTO toDTO(Show show) {
        return ShowDTO.builder()
                .venueID(show.getVenueID())
                .activityID(show.getActivityID())
                .isCancellable(show.getIsCancellable())
                .screenId(show.getScreenId())
                .price(show.getPrice())
                .startTime(show.getStartTime())
                .seatAvailability(show.getSeatAvailability())
                .build();

    }

    public Show fromDTO(ShowDTO showDTO){
        return Show.builder()
                .venueID(showDTO.getVenueID())
                .activityID(showDTO.getActivityID())
                .isCancellable(showDTO.getIsCancellable())
                .screenId(showDTO.getScreenId())
                .price(showDTO.getPrice())
                .startTime(showDTO.getStartTime())
                .seatAvailability(showDTO.getSeatAvailability())
                .build();
    }
}

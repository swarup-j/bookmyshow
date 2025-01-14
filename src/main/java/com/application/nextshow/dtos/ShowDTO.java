package com.application.nextshow.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowDTO {


    //@ManyToMany
    private UUID venueID;
    // @OneToMany
    private UUID activityID;
    private Boolean isCancellable;
    //@OneTOMany
    private UUID screenId;
    private Double price;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    //in the json format, used string for now
    private String seatAvailability;


}

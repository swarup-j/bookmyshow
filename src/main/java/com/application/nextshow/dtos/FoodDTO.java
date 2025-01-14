package com.application.nextshow.dtos;

import com.application.nextshow.entities.enums.FoodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class FoodDTO {
    private String title;
    private  double price;
    private String description;
    private FoodType category;

}

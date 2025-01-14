package com.application.nextshow.mappers;

import com.application.nextshow.dtos.FoodDTO;
import com.application.nextshow.entities.Food;
import org.springframework.stereotype.Component;

@Component
public class FoodMapper {


    public FoodDTO toDTO(Food food){
        return FoodDTO.builder()

                .title(food.getTitle())
                .price(food.getPrice())
                .description(food.getDescription())
                .category(food.getCategory())
                .build();
    }
    public Food fromDTO(FoodDTO foodDTO){
        return Food.builder()
                .title(foodDTO.getTitle())
                .price(foodDTO.getPrice())
                .description(foodDTO.getDescription())
                .category(foodDTO.getCategory())
                .build();
    }



}

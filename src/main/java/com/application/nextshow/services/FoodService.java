package com.application.nextshow.services;

import com.application.nextshow.dtos.FoodDTO;
import com.application.nextshow.dtos.VenueDTO;
import com.application.nextshow.entities.enums.FoodType;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface FoodService {
    List<FoodDTO> findAllFood();
    Optional<FoodDTO> findFoodById(UUID id);
    List<FoodDTO> saveAllFood(List<FoodDTO> foodDTOList);
    FoodDTO saveFood(FoodDTO foodDTO);
    void deleteFoodById(UUID id);
    List<FoodDTO> getFoodsByFilters(FoodType category,  Double priceGte, Double priceLte);
}

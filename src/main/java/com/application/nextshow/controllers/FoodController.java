package com.application.nextshow.controllers;

import com.application.nextshow.dtos.FoodDTO;

import com.application.nextshow.entities.enums.FoodType;
import com.application.nextshow.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class FoodController {
    @Autowired
    private final FoodService foodService;


    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/api/v1/food")
    public List<FoodDTO> getFoodsByCategoryAndPrice(
            @RequestParam(required = false) FoodType category,
    @RequestParam(required = false) Double priceGte,
            @RequestParam(required = false) Double priceLte) {
        return foodService.getFoodsByFilters(category, priceGte, priceLte);
    }

    @GetMapping(value = "/api/v1/food/{id}")
    public Optional<FoodDTO> findFoodById(@PathVariable(name = "id") UUID id){
        return foodService.findFoodById(id);
    }
    @PostMapping(value = "/api/v1/save-all-food")
    public List<FoodDTO> saveAllFood(@RequestBody List<FoodDTO> foodDTOList){
        return foodService.saveAllFood(foodDTOList);
    }

    @PostMapping(value = "/api/v1/save-user")
    public FoodDTO saveFOod(@RequestBody FoodDTO foodDTO) {
        return foodService.saveFood(foodDTO);
    }
    @DeleteMapping(value = "/api/v1/delete-food/{id}")
    public void deleteFoodById(@PathVariable(name = "id") UUID id){
        foodService.deleteFoodById(id);
    }
}

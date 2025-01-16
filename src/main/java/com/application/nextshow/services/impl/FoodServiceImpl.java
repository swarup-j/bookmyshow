package com.application.nextshow.services.impl;

import com.application.nextshow.dtos.FoodDTO;
import com.application.nextshow.entities.Food;
import com.application.nextshow.entities.enums.FoodType;
import com.application.nextshow.mappers.FoodMapper;
import com.application.nextshow.repositories.FoodRepository;
import com.application.nextshow.services.FoodService;
import com.application.nextshow.specifications.FoodSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;


    private final FoodMapper foodMapper;

    public FoodServiceImpl(FoodRepository foodRepository, FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }

    @Override
    public List<FoodDTO> findAllFood() {
        List<Food> foodList = foodRepository.findAll();
        return foodList.stream().
                map(foodMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FoodDTO> findFoodById(UUID id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found with id: " + id));
        FoodDTO foodDTO = foodMapper.toDTO(food);
        return Optional.of(foodDTO);
    }


    @Override
    public List<FoodDTO> saveAllFood(List<FoodDTO> foodDTOList) {
        List<Food> foodList = foodDTOList.stream().map(foodMapper::fromDTO).collect(Collectors.toList());
        foodRepository.saveAll(foodList);
        return foodDTOList;
    }

    @Override
    public FoodDTO saveFood(FoodDTO foodDTO) {
        Food food = foodMapper.fromDTO(foodDTO);
        foodRepository.save(food);
        return foodMapper.toDTO(food);
    }

    @Override
    public void deleteFoodById(UUID id) {
        foodRepository.deleteById(id);

    }


    @Override
    public List<FoodDTO> getFoodsByFilters(FoodType category, Double priceGte, Double priceLte) {
        // Create the specification for filtering by category and price range
        Specification<Food> spec = FoodSpecification.withFilters(category, priceGte, priceLte);

        // Find all foods matching the specification



        List<Food> foodList = foodRepository.findAll(spec);
        return foodList.stream().
                map(foodMapper::toDTO)
                .collect(Collectors.toList());
    }
}

package com.application.nextshow.specifications;


import com.application.nextshow.entities.Food;
import com.application.nextshow.entities.enums.FoodType;
import org.springframework.data.jpa.domain.Specification;

public class FoodSpecification {

    public static Specification<Food> hasCategory(FoodType category) {
        return (root, query, criteriaBuilder) -> {
            if (category != null) {
                return criteriaBuilder.equal(root.get("category"), category);
            }
            return criteriaBuilder.conjunction(); // No category filter if null
        };
    }


    public static Specification<Food> hasPriceGreaterThanEqual(Double price) {
        return (root, query, criteriaBuilder) -> {
            if (price != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), price);
            }
            return criteriaBuilder.conjunction(); // No price filter if null
        };
    }


    public static Specification<Food> hasPriceLessThanEqual(Double price) {
        return (root, query, criteriaBuilder) -> {
            if (price != null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), price);
            }
            return criteriaBuilder.conjunction(); // No price filter if null
        };
    }

    // Combine category, price greater than or equal, and price less than or equal filters
    public static Specification<Food> withFilters(FoodType category, Double priceGte, Double priceLte) {
        Specification<Food> spec = Specification.where(null); // Start with an empty specification

        if (category != null) {
            spec = spec.and(hasCategory(category));  // Add category filter
        }
        if (priceGte != null) {
            spec = spec.and(hasPriceGreaterThanEqual(priceGte));  // Add price greater than or equal filter
        }
        if (priceLte != null) {
            spec = spec.and(hasPriceLessThanEqual(priceLte));  // Add price less than or equal filter
        }

        return spec;
    }
}
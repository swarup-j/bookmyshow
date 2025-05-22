package com.application.nextshow.specifications;

import com.application.nextshow.entities.Venue;
import org.springframework.data.jpa.domain.Specification;


public class VenueSpecification {
    public static Specification<Venue> hasCity(String city) {
        return (root, query, criteriaBuilder) -> {
            if (city != null) {
                return criteriaBuilder.equal(root.get("city"), city);
            }
            return criteriaBuilder.conjunction();
        };
    }

    public static Specification<Venue> hasFormat(String format) {
        return (root, query, criteriaBuilder) -> {

            if (format != null) {
                return criteriaBuilder.like(root.get("formats"), "%" + format + "%"); // Searches within the CSV
            }
            return criteriaBuilder.conjunction();
        };
    }

    public static Specification<Venue> withFilters(String city, String format) {
        Specification<Venue> spec = Specification.where(null); // Start with an empty specification

        if (city != null) {
            spec = spec.and(hasCity(city));
        }

        if (format != null) {
            spec = spec.and(hasFormat(format));
        }

        return spec;
    }
}
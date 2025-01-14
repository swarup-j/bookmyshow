package com.application.nextshow.specifications;

import com.application.nextshow.entities.Venue;
import org.springframework.data.jpa.domain.Specification;

public class VenueSpecification {
    public static Specification<Venue> hasCity(String city){
        return (root, query, criteriaBuilder) -> {
            if (city!=null){
                return criteriaBuilder.equal(root.get("city"), city);
            }
            return criteriaBuilder.conjunction();
        };
    }
    public  static Specification<Venue> hasFormats(String[] formats){
        return (root, query, criteriaBuilder) -> {
            if (formats != null && formats.length > 0) {
                return root.get("formats").in((Object[]) formats);
            }
            return criteriaBuilder.conjunction();
        };
    }
    public static Specification<Venue> withFilters(String city, String[] formats) {
        Specification<Venue> spec = Specification.where(null); // Start with an empty specification

        if (city != null) {
            spec = spec.and(hasCity(city));
        }


        if (formats != null) {
            spec = spec.and(hasFormats(formats));
        }

        return spec;
    }

}


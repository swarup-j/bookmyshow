package com.application.nextshow.specifications;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import com.application.nextshow.entities.Activity;
import com.application.nextshow.entities.enums.ActivityType;

import java.time.LocalDate;

public class ActivitySpecification {

    public static Specification<Activity> hasCategory(ActivityType category) {
        return (root, query, criteriaBuilder) -> {
            if (category != null) {
                return criteriaBuilder.equal(root.get("category"), category);
            }
            return criteriaBuilder.conjunction(); // No category filter if null
        };
    }

    public static Specification<Activity> hasFormats(String[] formats) {
        return (root, query, criteriaBuilder) -> {
            if (formats != null && formats.length > 0) {
                return root.get("formats").in((Object[]) formats);
            }
            return criteriaBuilder.conjunction(); // No formats filter if null or empty
        };
    }

    public static Specification<Activity> hasGenres(String[] genres) {
        return (root, query, criteriaBuilder) -> {
            if (genres != null && genres.length > 0) {
                return root.get("genres").in((Object[]) genres);
            }
            return criteriaBuilder.conjunction(); // No genres filter if null or empty
        };
    }

    public static Specification<Activity> hasLanguages(String[] languages) {
        return (root, query, criteriaBuilder) -> {
            if (languages != null && languages.length > 0) {
                return root.get("languages").in((Object[]) languages);
            }
            return criteriaBuilder.conjunction(); // No languages filter if null or empty
        };
    }

    public static Specification<Activity> hasReleaseDateBefore(LocalDate releaseDateBefore) {
        return (root, query, criteriaBuilder) -> {
            if (releaseDateBefore != null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("date"), releaseDateBefore);
            }
            return criteriaBuilder.conjunction(); // No filter if null
        };
    }

    public static Specification<Activity> hasReleaseDateAfter(LocalDate releaseDateAfter) {
        return (root, query, criteriaBuilder) -> {
            if (releaseDateAfter != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("date"), releaseDateAfter);
            }
            return criteriaBuilder.conjunction(); // No filter if null
        };
    }

    public static Specification<Activity> hasVenue(String venue) {
        return (root, query, criteriaBuilder) -> {
            if (venue != null && !venue.isEmpty()) {
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("venue")), "%" + venue.toLowerCase() + "%");
            }
            return criteriaBuilder.conjunction(); // No venue filter if null or empty
        };
    }

    public static Specification<Activity> hasRating(Double rating) {
        return (root, query, criteriaBuilder) -> {
            if (rating != null) {
                return criteriaBuilder.equal(root.get("rating"), rating);
            }
            return criteriaBuilder.conjunction(); // No rating filter if null
        };
    }

    // Combine all filters for category, formats, genres, languages, date, venue, and rating
    public static Specification<Activity> withFilters(ActivityType category, String[] formats, String[] genres,
                                                      String[] languages, LocalDate releaseDateBefore,
                                                      LocalDate releaseDateAfter, String venue,
                                                      Double rating) {
        Specification<Activity> spec = Specification.where(null); // Start with an empty specification

        if (category != null) {
            spec = spec.and(hasCategory(category));  // Add category filter
        }
        if (formats != null) {
            spec = spec.and(hasFormats(formats)); // Add formats filter
        }
        if (genres != null) {
            spec = spec.and(hasGenres(genres)); // Add genres filter
        }
        if (languages != null) {
            spec = spec.and(hasLanguages(languages)); // Add languages filter
        }
        if (releaseDateBefore != null) {
            spec = spec.and(hasReleaseDateBefore(releaseDateBefore)); // Add releaseDateBefore filter
        }
        if (releaseDateAfter != null) {
            spec = spec.and(hasReleaseDateAfter(releaseDateAfter)); // Add releaseDateAfter filter
        }
        if (venue != null && !venue.isEmpty()) {
            spec = spec.and(hasVenue(venue)); // Add venue filter
        }
        if (rating != null) {
            spec = spec.and(hasRating(rating)); // Add rating filter
        }

        return spec;
    }
}

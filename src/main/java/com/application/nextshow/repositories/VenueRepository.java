package com.application.nextshow.repositories;

import com.application.nextshow.entities.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface VenueRepository extends JpaRepository<Venue, UUID>, JpaSpecificationExecutor<Venue> {

}

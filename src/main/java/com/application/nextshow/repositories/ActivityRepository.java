package com.application.nextshow.repositories;

import com.application.nextshow.dtos.ActivityDTO;
import com.application.nextshow.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, UUID> ,JpaSpecificationExecutor<Activity> {
    //@Query(value = "SELECT p.title FROM activity p WHere  p.title = ?1")
   Activity findByTitle(String title);



}

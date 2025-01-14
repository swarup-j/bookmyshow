package com.application.nextshow.repositories;

import com.application.nextshow.entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ShowRepository extends JpaRepository<Show, UUID> {


}

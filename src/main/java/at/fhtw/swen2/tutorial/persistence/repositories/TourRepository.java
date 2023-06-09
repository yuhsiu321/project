package at.fhtw.swen2.tutorial.persistence.repositories;


import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TourRepository extends JpaRepository<TourEntity, Long> {

    TourEntity findByName(String name);
}

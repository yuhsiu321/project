package at.fhtw.swen2.tutorial.service;

import at.fhtw.swen2.tutorial.service.dto.Tour;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TourService {

    List<Tour> getTourList();

    Tour addNew(Tour tour);

    // erweitern mit parameter create new service

}

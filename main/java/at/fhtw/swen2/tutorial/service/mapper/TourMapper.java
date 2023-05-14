package at.fhtw.swen2.tutorial.service.mapper;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import org.springframework.stereotype.Component;

@Component
public class TourMapper extends AbstractMapper<TourEntity, Tour> {

    @Override
    public Tour fromEntity(TourEntity entity) {
        return Tour.builder()
                .id(entity.getId())
                .name(entity.getName())
                .tourDescription(entity.getTourDescription())
                .from(entity.getFrom())
                .to(entity.getTo())
                .transportType(entity.getTransportType())
                .distance(entity.getTourDistance())
                .time(entity.getEstimatedTime())
                .sessionId(entity.getSessionId())
                .build();
    }

    @Override
    public TourEntity toEntity(Tour tour) {
        return TourEntity.builder()
                .id(tour.getId())
                .name(tour.getName())
                .tourDescription(tour.getTourDescription())
                .from(tour.getFrom())
                .to(tour.getTo())
                .transportType(tour.getTransportType())
                .tourDistance(tour.getDistance())
                .estimatedTime(tour.getTime())
                .sessionId(tour.getSessionId())
                .build();
    }

}

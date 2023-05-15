package at.fhtw.swen2.tutorial.service.dto;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;

@Data
@Builder
public class TourLog {
    private Long id;
    private Double time;
    private String comment;
    private String difficulty;
    private Double totalTime;
    private String rating;
    private TourEntity tourEntity;
}

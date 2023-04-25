package at.fhtw.swen2.tutorial.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TourLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Time time;
    private String comment;
    private String difficulty;
    private Double totalTime;
    private String rating;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private TourEntity tourEntity;
}

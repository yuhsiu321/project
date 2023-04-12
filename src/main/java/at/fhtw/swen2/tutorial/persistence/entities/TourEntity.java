package at.fhtw.swen2.tutorial.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TourEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "TOUR_DESCRIPTION")
    private String tourDescription;
    @Column(name = "FROM_WHERE")
    private String from;
    @Column(name = "TO_WHERE")
    private String to;
    private String transportType;
    private Integer tourDistance;
    private Integer estimatedTime;
    private String routeInformation;
}

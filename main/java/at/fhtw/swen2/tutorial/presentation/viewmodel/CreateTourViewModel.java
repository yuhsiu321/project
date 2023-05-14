package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

@Component
public class CreateTourViewModel{

    @Autowired
    private TourService tourService;
    @Autowired
    private TourListViewModel tourListViewModel;
    private SimpleLongProperty id = new SimpleLongProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty tourDescription = new SimpleStringProperty();
    private SimpleStringProperty from = new SimpleStringProperty();
    private SimpleStringProperty to = new SimpleStringProperty();

    private ObjectProperty<String> transportType = new SimpleObjectProperty<>();

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    private Double distance;
    private Integer time;
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    private String apiKey = "vpYWl32FtXtF2BrrnpC5V94yYIqFkodG";

    private String baseUrl = "https://www.mapquestapi.com/directions/v2/route?key=" + apiKey;

    public String getTransportType() {
        return transportType.get();
    }

    public ObjectProperty<String> transportTypeProperty() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType.set(transportType);
    }

    public String getFrom() {
        return from.get();
    }

    public SimpleStringProperty fromProperty() {
        return from;
    }

    public void setFrom(String from) {
        this.from.set(from);
    }

    public String getTo() {
        return to.get();
    }

    public SimpleStringProperty toProperty() {
        return to;
    }

    public void setTo(String to) {
        this.to.set(to);
    }


    public String getTourDescription() {
        return tourDescription.get();
    }

    public SimpleStringProperty tourDescriptionProperty() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription.set(tourDescription);
    }

    private Tour tour;


    public CreateTourViewModel() {

    }

    public CreateTourViewModel(Tour tour) {
        this.tour = tour;
        this.id = new SimpleLongProperty(tour.getId());
        this.name = new SimpleStringProperty(tour.getName());
        this.tourDescription = new SimpleStringProperty(tour.getTourDescription());
        this.from = new SimpleStringProperty(tour.getFrom());
        this.to = new SimpleStringProperty(tour.getTo());
        this.transportType = new SimpleObjectProperty<>(tour.getTransportType());
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setDistanceAndTime() throws IOException {
        String urlString = baseUrl + "&from=" + getFrom() + "&to=" + getTo() + "&outFormat=json&routeType=pedestrian";
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        //System.out.println(urlString);
        // Parse JSON response
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(conn.getInputStream());

        double totalDistance = 0.0;
        int totalTime = 0;

        // Extract desired data
        String sessionId = jsonNode.get("route").get("sessionId").asText();

        this.sessionId = sessionId;
        JsonNode legsNode = jsonNode.get("route").get("legs");
        for (int i = 0; i < legsNode.size(); i++) {
            totalDistance += legsNode.get(i).get("distance").asDouble();
            totalTime += legsNode.get(i).get("time").asInt();
        }
        //System.out.println(totalDistance);
        //System.out.println(totalTime);


        this.distance = totalDistance;
        this.time = totalTime;

    }

    public void addNewTour() throws IOException {
        setDistanceAndTime();
        Tour tour = Tour.builder().name(getName()).tourDescription(getTourDescription()).from(getFrom()).to(getTo()).transportType(getTransportType()).distance(getDistance()).time(getTime()).sessionId(getSessionId()).build();
        System.out.println(tour);
        tour = tourService.addNew(tour);
        tourListViewModel.addItem(tour);
        System.out.println(tour);
    }


}

package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import javafx.beans.property.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


    public void addNewTour() {
        Tour tour = Tour.builder().name(getName()).tourDescription(getTourDescription()).from(getFrom()).to(getTo()).transportType(getTransportType()).build();
        tour = tourService.addNew(tour);
        tourListViewModel.addItem(tour);
        System.out.println(tour);
    }


}

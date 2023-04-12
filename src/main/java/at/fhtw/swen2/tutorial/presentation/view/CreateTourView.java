package at.fhtw.swen2.tutorial.presentation.view;
import at.fhtw.swen2.tutorial.presentation.viewmodel.CreateTourViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.TourListViewModel;
import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CreateTourView {

    private final CreateTourViewModel createTourViewModel = new CreateTourViewModel();

    @Autowired
    private TourService tourService;
    @Autowired
    private TourListViewModel tourListViewModel = new TourListViewModel();

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField desTextField;
    @FXML
    private Button submitButton;


    /*@FXML
    private void initialize() {
        nameTextField.textProperty().bindBidirectional(createTourViewModel.nameProperty());
        desTextField.textProperty().bindBidirectional(createTourViewModel.tourDescriptionProperty());
    }*/
    public void submitButtonAction(ActionEvent event) {
        //this.tourService = tourService;
        Tour tour = Tour.builder().name(nameTextField.getText()).tourDescription(desTextField.getText()).from("here").to("there").build();
        tour = this.tourService.addNew(tour);
        tourListViewModel.addItem(tour);
    }
}

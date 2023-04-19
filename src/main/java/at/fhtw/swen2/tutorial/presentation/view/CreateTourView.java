package at.fhtw.swen2.tutorial.presentation.view;
import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.persistence.repositories.TourRepository;
import at.fhtw.swen2.tutorial.presentation.viewmodel.CreateTourViewModel;
import at.fhtw.swen2.tutorial.presentation.viewmodel.TourListViewModel;
import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@Scope("prototype")
@Slf4j
public class CreateTourView extends Dialog<Void> implements Initializable{

    @Autowired
    private CreateTourViewModel createTourViewModel;

    @Autowired
    private TourService tourService;
    @Autowired
    private TourListViewModel tourListViewModel;

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField desTextField;
    @FXML
    private Button submitButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTextField.textProperty().bindBidirectional(createTourViewModel.nameProperty());
        desTextField.textProperty().bindBidirectional(createTourViewModel.tourDescriptionProperty());
    }

    public void submitButtonAction(ActionEvent event) {
        //nameTextField.textProperty().bindBidirectional(createTourViewModel.nameProperty());
        //desTextField.textProperty().bindBidirectional(createTourViewModel.tourDescriptionProperty());
        //this.tourService = tourService;
        /*Tour tour = Tour.builder().name(nameTextField.getText()).tourDescription(desTextField.getText()).from("here").to("there").build();
        tour = this.tourService.addNew(tour);
        tourListViewModel.addItem(tour);
        */
        //nameTextField.textProperty().bindBidirectional(createTourViewModel.nameProperty());
        //desTextField.textProperty().bindBidirectional(createTourViewModel.tourDescriptionProperty());

        createTourViewModel.addNewTour();
    }

}

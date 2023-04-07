package at.fhtw.swen2.tutorial.presentation.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

@Component
@Scope("prototype")
@Slf4j
public class ControlView implements Initializable {
    @FXML
    public Button deleteButton;
    @FXML
    public Button moreButton;
    @FXML
    Button createButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createButton.setOnAction(event -> {
            try {
                handleNewTour();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void handleNewTour() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NewTour.fxml"));

        Stage stage = new Stage();
        stage.setTitle("create");
        stage.show();
    }
}

package org.example.mazeproject_csc311;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MazeController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
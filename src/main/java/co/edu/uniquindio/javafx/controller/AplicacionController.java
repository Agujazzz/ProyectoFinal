package co.edu.uniquindio.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AplicacionController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
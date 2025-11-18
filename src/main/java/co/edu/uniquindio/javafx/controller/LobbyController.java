package co.edu.uniquindio.javafx.controller;

import co.edu.uniquindio.javafx.model.Persona;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class LobbyController {

    private GimnasioController gimController = AplicacionController.getGimController();

    private Persona usuario = gimController.getUsuarioLog();

    @FXML
    private Label displayName;

    @FXML
    private Button displayUsuario;

    @FXML
    private StackPane displayUsuarioContainer;

    private boolean panelDesplazado = false;

    @FXML
    private void initialize() {

        displayName.setText(usuario.getNombre());

    }

    @FXML
    private void toggleStackPane() {
        if (panelDesplazado) {
            // Volver a posición original (izquierda)
            regresarPanel();
        } else {
            // Mover a la derecha
            desplazarPanelDerecha();
        }
        panelDesplazado = !panelDesplazado;
    }


    @FXML
    private void desplazarPanelDerecha() {
        // Calcular cuánto mover hacia la derecha
        double desplazamiento = 349; // Pixeles a mover hacia la derecha

        TranslateTransition movimiento = new TranslateTransition(Duration.seconds(0.5), displayUsuarioContainer);
        movimiento.setToX(desplazamiento);
        movimiento.setInterpolator(Interpolator.EASE_OUT);
        movimiento.play();
    }

    @FXML
    private void regresarPanel() {
        TranslateTransition movimiento = new TranslateTransition(Duration.seconds(0.5), displayUsuarioContainer);
        movimiento.setToX(0); // Volver a posición original
        movimiento.setInterpolator(Interpolator.EASE_OUT);
        movimiento.play();
    }

}

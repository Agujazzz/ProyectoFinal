package co.edu.uniquindio.javafx.controller;

import co.edu.uniquindio.javafx.model.Administrador;
import co.edu.uniquindio.javafx.model.Aplicacion;
import co.edu.uniquindio.javafx.model.Persona;
import co.edu.uniquindio.javafx.model.Recepcionista;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LogInController {

    private GimnasioController gimController = AplicacionController.getGimController();


    @FXML
    private Button button;

    @FXML
    private Line linea1, linea2, linea3;

    @FXML
    private List<Node> lineasColision;

    @FXML
    private Button buttonLector;

    @FXML
    private StackPane tarjetaContainer;

    @FXML
    private Label wrongLogIn;

    @FXML
    private TextField nickname;

    @FXML
    private PasswordField contrasena;

    @FXML
    private TextField identificacion;

    @FXML
    private ImageView tarjeta, lectorTarjeta, lectorRojo, lectorVerde;

    private boolean sensor = false;
    private AnimationTimer timer;

    private Clip audio;

    private double dragOffsetX, dragOffsetY;
    private boolean isDragging = false;

    @FXML
    public void initialize() {

        lineasColision = new ArrayList<>();
        lineasColision.add(linea1);
        lineasColision.add(linea2);
        lineasColision.add(linea3);

        iniciarMonitorSensor();
        cargarSonido();
        lectorRojo.setVisible(false);
        lectorVerde.setVisible(false);
        tarjeta.setVisible(false);
        tarjeta.setDisable(false);
        identificacion.setVisible(false);
        configurarArrastre();
    }

    private void cargarSonido() {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(
                    getClass().getResource("/sounds/buttonSound.wav"));
            audio = AudioSystem.getClip();
            audio.open(ais);
        } catch (Exception e) {
            System.err.println("Error cargando sonido: " + e.getMessage());
        }
    }

    private void reproducirSonido() {
        if (audio != null) {
            if (audio.isRunning()) {
                audio.stop();
            }
            audio.setFramePosition(0);
            audio.start();
        }
    }

    @FXML
    public void mostrarTarjeta () {
            reproducirSonido();
            tarjeta.setVisible(true);
            identificacion.setVisible(true);
            aplicarEfectoCaida();
    }

    private void configurarArrastre() {
        tarjetaContainer.setPickOnBounds(true);

        tarjetaContainer.setOnMousePressed(e -> {
            dragOffsetX = e.getSceneX() - tarjetaContainer.getLayoutX();
            dragOffsetY = e.getSceneY() - tarjetaContainer.getLayoutY();
            e.consume();
        });

        tarjetaContainer.setOnMouseDragged(e -> {
            double newX = e.getSceneX() - dragOffsetX;
            double newY = e.getSceneY() - dragOffsetY;

            double currentX = tarjetaContainer.getLayoutX();
            double currentY = tarjetaContainer.getLayoutY();

            double[] posicionPermitida = prevenirCruceLineas(currentX, currentY, newX, newY);

            tarjetaContainer.setLayoutX(posicionPermitida[0]);
            tarjetaContainer.setLayoutY(posicionPermitida[1]);

            e.consume();
        });

        tarjetaContainer.setOnMouseReleased(e -> {
            aplicarEfectoCaida();
            e.consume();
        });
    }

    private double[] prevenirCruceLineas(double currentX, double currentY, double newX, double newY) {
        double allowedX = newX;
        double allowedY = newY;

        double deltaX = newX - currentX;
        double deltaY = newY - currentY;

        int pasos = 10;
        double stepX = deltaX / pasos;
        double stepY = deltaY / pasos;

        double testX = currentX;
        double testY = currentY;

        for (int i = 1; i <= pasos; i++) {
            testX += stepX;
            testY += stepY;


            if (verificarColisionEnPosicion(testX, testY)) {

                allowedX = testX - stepX;
                allowedY = testY - stepY;
                break;
            }
        }

        return new double[]{allowedX, allowedY};
    }

    private boolean verificarColisionEnPosicion(double x, double y) {

        double originalX = tarjetaContainer.getLayoutX();
        double originalY = tarjetaContainer.getLayoutY();

        tarjetaContainer.setLayoutX(x);
        tarjetaContainer.setLayoutY(y);

        Bounds tarjetaBounds = tarjetaContainer.getBoundsInParent();
        boolean colision = false;

        for (Node linea : lineasColision) {
            if (linea.getBoundsInParent().intersects(tarjetaBounds)) {
                colision = true;
                break;
            }
        }

        tarjetaContainer.setLayoutX(originalX);
        tarjetaContainer.setLayoutY(originalY);

        return colision;
    }

    private boolean hayColisionConLineas(double newX, double newY) {
        double oldX = tarjetaContainer.getLayoutX();
        double oldY = tarjetaContainer.getLayoutY();

        tarjetaContainer.setLayoutX(newX);
        tarjetaContainer.setLayoutY(newY);

        boolean colision = false;
        for (Node linea : lineasColision) {
            if (tarjetaContainer.getBoundsInParent().intersects(linea.getBoundsInParent())) {
                colision = true;
                break;
            }
        }

        if (colision) {
            tarjetaContainer.setLayoutX(oldX);
            tarjetaContainer.setLayoutY(oldY);
        }

        return colision;
    }

    private void aplicarEfectoCaida() {
        tarjetaContainer.setTranslateY(0);

        double currentY = tarjetaContainer.getLayoutY();
        double tarjetaHeight = tarjetaContainer.getHeight();
        double posicionObjetivo = calcularPosicionObjetivoSegura(currentY, tarjetaHeight);

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(4.0),
                        new KeyValue(tarjetaContainer.translateYProperty(), posicionObjetivo - currentY))
        );

        timeline.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
            if (hayColisionConLineas(tarjetaContainer.getLayoutX(),
                    tarjetaContainer.getLayoutY() + tarjetaContainer.getTranslateY())) {
                timeline.stop();
            }
        });

        timeline.play();
    }


    private double calcularPosicionObjetivoSegura(double currentY, double tarjetaHeight) {
        Pane parent = (Pane) tarjetaContainer.getParent();
        double containerHeight = parent.getHeight();

        double posicionObjetivo = containerHeight - tarjetaHeight;


        for (Node linea : lineasColision) {
            if (linea instanceof Line) {
                Line line = (Line) linea;
                double lineaY = line.getStartY();

                if (lineaY > currentY + tarjetaHeight && lineaY < posicionObjetivo + tarjetaHeight) {
                    posicionObjetivo = lineaY - tarjetaHeight - 1;
                }
            }
        }

        return posicionObjetivo;
    }

    private void iniciarMonitorSensor() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    verificarColisionConSensor();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        timer.start();
    }

    private void verificarColisionConSensor() throws IOException {
        Bounds boundsTarjeta = tarjetaContainer.getBoundsInParent();
        Bounds boundsSensor = lectorTarjeta.getBoundsInParent();

        if (boundsTarjeta.intersects(boundsSensor)) {
            if (!sensor) {
                sensor = true;
                activarSensor();
            }
        }
    }

    private void activarSensor() throws IOException {
        checkID();
        sensor = false;
    }

    public void userLogIn(javafx.event.ActionEvent actionEvent) throws IOException {
        checkLogin();
    }

    private void checkID() throws IOException {
        String idUsuario = identificacion.getText();

        Persona usuario = gimController.buscarUsuario(idUsuario);

        if (usuario != null) {
            gimController.setUsuarioLog(usuario);
            lectorRojo.setVisible(false);
            lectorVerde.setVisible(true);
                try {
                    destruirTarjeta();
                    Aplicacion.getInstance().changeScene("/co/edu/uniquindio/viewController/lobbyUsuario.fxml");
                } catch (IOException ex) {
                    System.err.println("Error cambiando de escena: " + ex.getMessage());
                    ex.printStackTrace();
                }
            } else {
            lectorVerde.setVisible(false);
            lectorRojo.setVisible(true);
        }
    }

    private void checkLogin() throws IOException {

        String nickIngresado = nickname.getText();
        String contrasenaIngresada = contrasena.getText();

        if (nickIngresado.isEmpty() || contrasenaIngresada.isEmpty()) {
            wrongLogIn.setText("Por favor, ingresa tu Nickname y Contraseña");
            return;
        }

        Persona usuario = gimController.validarUsuario(nickIngresado, contrasenaIngresada);

        if (usuario != null) {
            wrongLogIn.setText("Inicio de sesión exitoso");

            if (usuario instanceof Administrador) {
                gimController.setAdministradorLog((Administrador) usuario);
                //app.changeScene("/co/edu/uniquindio/javafxt/controller/lobbyAdministrador.fxml");
            } else if (usuario instanceof Recepcionista) {
                gimController.setRecepcionistaLog((Recepcionista) usuario);
                //app.changeScene("/co/edu/uniquindio/javafx/controller/lobbyRecepcionista.fxml");
            }
        } else {
            wrongLogIn.setText("Nickname o Contraseña incorrectos");
        }
    }

    private void destruirTarjeta() {
        if (tarjetaContainer != null) {
            tarjetaContainer.setLayoutX(-1000);
            tarjetaContainer.setLayoutY(-1000);
            tarjetaContainer.setVisible(false);
        }
    }
}

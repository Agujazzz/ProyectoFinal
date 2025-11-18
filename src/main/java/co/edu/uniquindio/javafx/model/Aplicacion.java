package co.edu.uniquindio.javafx.model;

import javafx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Aplicacion extends Application {
    private static Aplicacion instance;
    private static Stage stage;

    public static Aplicacion getInstance() {
        if (instance == null) {
            instance = new Aplicacion();
        }
        return instance;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Aplicacion.getInstance().setStage(stage);
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("/co/edu/uniquindio/viewController/hello-view.fxml"));
        primaryStage.setTitle("Gym LogIn");
        primaryStage.setScene(new Scene(root, 1080, 720));
        primaryStage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = stage.getScene();

        Parent oldRoot = scene.getRoot();
        scene.setRoot(newRoot);

        newRoot.setTranslateY(20);
        newRoot.setOpacity(0);
        newRoot.setScaleX(0.95);
        newRoot.setScaleY(0.95);

        TranslateTransition translate = new TranslateTransition(Duration.seconds(0.5), newRoot);
        translate.setFromY(20);
        translate.setToY(0);

        FadeTransition fade = new FadeTransition(Duration.seconds(0.5), newRoot);
        fade.setFromValue(0);
        fade.setToValue(1);

        ScaleTransition scale = new ScaleTransition(Duration.seconds(0.5), newRoot);
        scale.setFromX(0.95); scale.setFromY(0.95);
        scale.setToX(1); scale.setToY(1);

        ParallelTransition parallel = new ParallelTransition(translate, fade, scale);
        parallel.setInterpolator(Interpolator.EASE_OUT);
        parallel.play();
    }

    public static void main(String[] args) {
        launch();
    }
}
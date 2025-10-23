module co.edu.uniquindio.aplicaciongimnasio {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.aplicaciongimnasio to javafx.fxml;
    exports co.edu.uniquindio.aplicaciongimnasio;
    exports co.edu.uniquindio.aplicaciongimnasio.model;
    opens co.edu.uniquindio.aplicaciongimnasio.model to javafx.fxml;
    exports co.edu.uniquindio.aplicaciongimnasio.controller;
    opens co.edu.uniquindio.aplicaciongimnasio.controller to javafx.fxml;
}
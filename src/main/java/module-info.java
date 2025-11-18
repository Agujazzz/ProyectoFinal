module co.edu.uniquindio.javafx {

    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jshell;
    requires java.desktop;
    requires jdk.compiler;

    exports co.edu.uniquindio.javafx.model;
    opens co.edu.uniquindio.javafx.model to javafx.fxml;
    exports co.edu.uniquindio.javafx.controller;
    opens co.edu.uniquindio.javafx.controller to javafx.fxml;
}
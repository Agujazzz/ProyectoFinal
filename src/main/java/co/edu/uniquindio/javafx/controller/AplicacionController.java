package co.edu.uniquindio.javafx.controller;

import co.edu.uniquindio.javafx.model.Administrador;
import co.edu.uniquindio.javafx.model.Persona;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AplicacionController {

    private static final GimnasioController gimController = new GimnasioController();

    private Persona usuarioLogueado;

    public static GimnasioController getGimController() {
        return gimController;
    }

    public void setUsuarioLogueado(Persona usuario) {
        this.usuarioLogueado = usuario;
    }

    public Persona getUsuarioLogueado() {
        return usuarioLogueado;

    }

}
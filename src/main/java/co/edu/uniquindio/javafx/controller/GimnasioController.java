package co.edu.uniquindio.javafx.controller;

import co.edu.uniquindio.javafx.model.*;

public class GimnasioController {
    private Administrador administradorLog;
    private Recepcionista recepcionistaLog;
    private Persona usuarioLog;
    private final Gimnasio gimnasio;

    public GimnasioController(){
        gimnasio = new Gimnasio("Gimnasio UQ", "1112");

    }

    public Persona getUsuarioLog() {
        return usuarioLog;
    }

    public void setUsuarioLog(Persona usuarioLog) {
        this.usuarioLog = usuarioLog;
    }

    public Administrador getAdministradorLog() {
        return administradorLog;
    }

    public void setAdministradorLog(Administrador administradorLog) {
        this.administradorLog = administradorLog;
    }

    public Recepcionista getRecepcionistaLog() {
        return recepcionistaLog;
    }

    public void setRecepcionistaLog(Recepcionista recepcionistaLog) {
        this.recepcionistaLog = recepcionistaLog;
    }

    public Gimnasio getGimnasio() {
        return gimnasio;
    }

    public Persona buscarUsuario(String identificacion) {
        return gimnasio.buscarUsuario(identificacion);
    }

    public Persona validarUsuario(String nickname, String contrasena) {
        return gimnasio.validarUsuario(nickname, contrasena);
    }

}

package co.edu.uniquindio.javafx.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class Reporte {

    private LocalDate fecha;
    private List<Usuario> usuarios;
    private List<Clase> clases;

    public Reporte(LocalDate fecha) {

        this.fecha = fecha;
        this.usuarios = new ArrayList<>();
        this.clases = new ArrayList<>();

    }

    public LocalDate getFecha() {
        return fecha;

    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void  agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    public void  agregarClase(Clase clase) {
        clases.add(clase);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "fecha=" + fecha +
                ", usuarios=" + usuarios +
                ", clases=" + clases +
                '}';
    }
}
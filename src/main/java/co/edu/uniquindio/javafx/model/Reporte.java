package co.edu.uniquindio.javafx.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class Reporte {

    private LocalDate fecha;

    public Reporte(LocalDate fecha) {

        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;

    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "fecha=" + fecha +
                '}';
    }
}
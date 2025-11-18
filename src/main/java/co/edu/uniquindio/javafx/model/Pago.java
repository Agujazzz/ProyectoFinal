package co.edu.uniquindio.javafx.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Pago {
    private LocalDate fecha;
    private LocalTime hora;
    private int costofinal;
    private List<Persona> Personas;

    public Pago(LocalDate fecha, LocalTime hora, int costofinal) {
        this.fecha = fecha;
        this.hora = hora;
        this.costofinal = costofinal;


    }
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCostofinal() {
        return costofinal;
    }

    public void setCostofinal(int costofinal) {
        this.costofinal = costofinal;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public List<Persona> getPersonas() {
        return Personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.Personas = personas;
    }
}


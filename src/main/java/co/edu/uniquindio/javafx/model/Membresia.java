package co.edu.uniquindio.javafx.model;

import java.time.LocalDate;

abstract class Membresia {
    private TipoMembresia tipo;
    private EstadoMembresia estado;
    private double costo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Membresia(TipoMembresia tipo){
        this.tipo = tipo;
    }

    public TipoMembresia getTipo() {
        return tipo;
    }

    public void setTipo(TipoMembresia tipo) {
        this.tipo = tipo;
    }

    public EstadoMembresia getEstado() {
        return estado;
    }

    public void setEstado(EstadoMembresia estado) {
        this.estado = estado;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "tipo=" + tipo +
                ", estado=" + estado +
                ", costo=" + costo +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}

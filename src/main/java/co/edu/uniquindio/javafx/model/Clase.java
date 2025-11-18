package co.edu.uniquindio.javafx.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Clase {
    private String nombre;
    private TipoClase tipo;
    private LocalDate fecha;
    private LocalTime hora;
    private int cupoMaximo;
    private Entrenador entrenador;

    private List<Persona> participantes;

    public Clase(String nombre, TipoClase tipo, LocalDate fecha, LocalTime hora, int cupoMaximo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.cupoMaximo = cupoMaximo;

        this.participantes = new ArrayList<>();
    }


    public void agregarParticipante(Persona personas) {  ///  Este metodo Añade a un participante a la lista de la clase ///
        participantes.add(personas);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoClase getTipo() {
        return tipo;
    }

    public void setTipo(TipoClase tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public List<Persona> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Persona> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", cupoMaximo=" + cupoMaximo +
                ", entrenador=" + entrenador +
                ", participantes=" + participantes +
                '}';
    }
}

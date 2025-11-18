package co.edu.uniquindio.javafx.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Persona {
    private String nombre, telefono, identificacion;
    private int edad;
    private Membresia tipoMembresia;
    private List<Pago> listPagos;
    private List<Asistencia> asistencias;


    public Persona(String nombre, String telefono, String identificacion, int edad){
        this.nombre = nombre;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.edad = edad;
        this.listPagos = new ArrayList<>();
        this.asistencias = new ArrayList<>();
    }

    public void agregarPagos(Pago pago){
        this.listPagos.add(pago);
    }

    public Membresia getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(Membresia tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    abstract String toCSV();


    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", edad=" + edad +
                ", tipoMembresia=" + tipoMembresia +
                '}';
    }

    public static Persona fromCSV(String line) {

        String[] p = line.split(",");

        String tipo = p[0];
        String nombre = p[1];
        String telefono = p[2];
        String id = p[3];
        int edad = Integer.parseInt(p[4]);

        Persona persona;

        switch (tipo) {
            case "Estudiante":
                persona = new Estudiante(nombre, telefono, id, edad);
                break;

            case "Entrenador":
                persona = new Entrenador(nombre, telefono, id, edad);
                break;

            case "TrabajadorUQ":
                persona = new TrabajadorUQ(nombre, telefono, id, edad);
                break;

            default:
                throw new RuntimeException("Tipo desconocido: " + tipo);
        }

        // Lectura de membresía
        if (!p[5].equals("NULL")) {
            persona.setTipoMembresia(Membresia.fromCSV(p[5]));
        }

        return persona;
    }

}


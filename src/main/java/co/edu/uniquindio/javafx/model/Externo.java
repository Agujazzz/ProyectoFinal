package co.edu.uniquindio.javafx.model;

public class Externo extends Persona {

    public Externo(String nombre, String telefono, String identificacion, int edad) {
        super(nombre, telefono, identificacion, edad);
    }

    @Override
    public String toCSV() {
        return null;
    }
}

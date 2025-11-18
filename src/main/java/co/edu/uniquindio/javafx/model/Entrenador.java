package co.edu.uniquindio.javafx.model;

public class Entrenador extends Persona{


    public Entrenador(String nombre, String telefono, String identificacion, int edad) {
        super(nombre, telefono, identificacion, edad);
    }

    @Override
    public String toCSV() {
        return null;
    }

}

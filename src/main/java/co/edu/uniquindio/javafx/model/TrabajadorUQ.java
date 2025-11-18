package co.edu.uniquindio.javafx.model;

public class TrabajadorUQ extends Persona {


    public TrabajadorUQ(String nombre, String telefono, String identificacion, int edad) {
        super(nombre, telefono, identificacion, edad);
    }

    @Override
    public String toCSV() {
        return null;
    }

//    public static TrabajadorUQ fromCSV(String line) {
//        String[] datos = line.split(",");
//
//        String nombre = datos[1];
//        String telefono = datos[2];
//        String identificacion = datos[3];
//        int edad = Integer.parseInt(datos[4]);
//
//        return new TrabajadorUQ(nombre, telefono, identificacion, edad);
//    }
}


package co.edu.uniquindio.javafx.model;

import java.time.LocalDate;

public class Estudiante extends Persona {

    public Estudiante(String nombre, String telefono, String identificacion, int edad) {
        super(nombre, telefono, identificacion, edad);
    }

    @Override
    public String toCSV() {
        return "Estudiante," +
                getNombre() + "," +
                getTelefono() + "," +
                getIdentificacion() + "," +
                getEdad() + "," +
                (getTipoMembresia() == null ? "NULL" : getTipoMembresia().toCSV());
    }

//    public static Estudiante fromCSV(String line) {
//
//        String[] datos = line.split(",");
//
//        String nombre = datos[1];
//        String telefono = datos[2];
//        String identificacion = datos[3];
//        int edad = Integer.parseInt(datos[4]);
//
//        // Crear estudiante sin membresía
//        Estudiante e = new Estudiante(nombre, telefono, identificacion, edad);
//
//        //------------------------------------
//        //  Reconstruir membresía
//        //------------------------------------
//        String tipoMembresia = datos[5];
//        String descripcion = datos[6];
//        EstadoMembresia estado = EstadoMembresia.valueOf(datos[7]);
//        LocalDate fechaInicio = LocalDate.parse(datos[8]);
//        LocalDate fechaFin = LocalDate.parse(datos[9]);
//        double coste = Double.parseDouble(datos[10]);
//
//        Membresia m;
//
//        switch (tipoMembresia) {
//            case "MembresiaBasica" -> m = new MembresiaBasica(descripcion, TipoMembresia.MENSUAL);
//            case "MembresiaPremium" -> m = new MembresiaPremium(descripcion, TipoMembresia.MENSUAL);
//            case "MembresiaVIP" -> m = new MembresiaVIP(descripcion, TipoMembresia.MENSUAL);
//            default -> throw new IllegalArgumentException("Tipo de membresía desconocido: " + tipoMembresia);
//        }
//
//        m.setEstado(estado);
//        m.setFechaInicio(fechaInicio);
//        m.setFechaFin(fechaFin);
//        m.setCoste(coste);
//
//        //------------------------------------
//        // Asignar la membresía al estudiante
//        //------------------------------------
//        e.setTipoMembresia(m);
//
//        return e;
//    }
}
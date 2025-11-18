package co.edu.uniquindio.javafx.model;

public class Recepcionista extends Persona {
    private  String  nickname;
    private  String contrasena;

    public Recepcionista(String nombre, String telefono, String identificacion, int edad) {
        super(nombre, telefono, identificacion, edad);
    }

    public static Recepcionista fromCSV(String line) {
        String[] datos = line.split(",");

        String nombre = datos[1];
        String telefono = datos[2];
        String identificacion = datos[3];
        int edad = Integer.parseInt(datos[4]);

        String nickname = datos.length > 5 ? datos[5] : null;

        return new Recepcionista(nombre, telefono, identificacion, edad);
    }

    @Override
    public String toCSV() {
        return null;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}

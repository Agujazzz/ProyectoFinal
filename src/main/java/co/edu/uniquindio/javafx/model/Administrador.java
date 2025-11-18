package co.edu.uniquindio.javafx.model;

public class Administrador extends Persona {
    private  String  nickname;
    private  String contrasena;

    public Administrador(String nombre, String telefono, String identificacion, int edad, String contrasena) {
        super(nombre, telefono, identificacion, edad);
        this.nickname = "UQ"+identificacion;
        this.contrasena = contrasena;
    }

    public static Administrador fromCSV(String line) {
        String[] datos = line.split(",");

        String nombre = datos[1];
        String telefono = datos[2];
        String identificacion = datos[3];
        int edad = Integer.parseInt(datos[4]);
        String nickname = datos[5];
        String contrasena = datos[6];

        return new Administrador(nombre, telefono, identificacion, edad, contrasena);
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

    @Override
    public String toString() {
        return super.toString() + " " +
         "LogIn{" +
                "contrasena='" + contrasena + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

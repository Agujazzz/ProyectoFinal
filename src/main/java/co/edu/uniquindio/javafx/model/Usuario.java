package co.edu.uniquindio.javafx.model;

abstract class Usuario {
    private String nombre, telefono, identificacion;
    private int edad;
    private Membresia tipoMembresia;

    public Usuario(String nombre, String telefono, String identificacion, int edad){
        this.nombre = nombre;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.edad = edad;
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
}

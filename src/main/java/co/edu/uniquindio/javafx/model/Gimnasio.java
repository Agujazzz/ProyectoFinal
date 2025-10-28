package co.edu.uniquindio.javafx.model;

import java.util.LinkedList;
import java.util.List;

public class Gimnasio {
    private String nombre, id;

    private List<Usuario> usuarios;

    public Gimnasio(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.usuarios = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    @Override
    public String toString() {
        return "Gimnasio{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }
}

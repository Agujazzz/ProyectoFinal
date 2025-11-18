package co.edu.uniquindio.javafx.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Gimnasio {
    private String nombre, nit;

    private final BaseDatos baseDatos;

    private List<Persona> personas;/// Composicion con persona////
    private List<Membresia> membresias;///// --------- con membresia /////
    private List<Clase>  clases;//////// con clase//////

    public Gimnasio(String nombre, String id) {
        this.nombre = nombre;
        this.nit = nit;
        this.baseDatos = new BaseDatos();
        this.personas = baseDatos.cargarPersonas();//// Composicion con persona////
        this.membresias = new ArrayList<>();///// --------- con membresia /////
        this.clases = new ArrayList<>();//////// con clase//////
    }

    public void guardar() {
        baseDatos.guardarPersonas(personas);
    }

    public List<Clase> getClases() {return clases;}

    public void setClases(List<Clase> clases) {this.clases = clases;}

    public List<Membresia> getMembresias() {return membresias;}

    public void setMembresias(List<Membresia> membresias) {this.membresias = membresias;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getnit() {
        return nit;
    }

    public void setnit(String id) {
        this.nit = nit;
    }

    public List<Persona> getUsuarios() {
        return personas;
    }

    public void setUsuarios(List<Persona> personas) {
        this.personas = personas;
    }

    public void asignarMembresia(Persona persona, Membresia membresia) {

    }

    public void agregarUsuario(Persona persona) {
        personas.add(persona);
    }

    public void agregarMembresia(Membresia membresia) {
        membresias.add(membresia);
    }

    public void agregarClase(Clase clase) { clases.add(clase);}

    @Override
    public String toString() {
        return "Gimnasio{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", usuarios=" + personas +
                '}';
    }

    public Administrador crearAdministrador(String nombre, String telefono, String identificacion, int edad, String contrasena) { /// Este metodo Crea un usuario en el sistema y verifica si ya se encuentra///
        if(buscarUsuario(identificacion) != null){
            System.out.println("Error: Ya existe un usuario con el numero de identificación:  " + identificacion);
            return null;
        }
        Administrador newadmin = new Administrador(nombre, telefono, identificacion, edad, contrasena);
        agregarUsuario(newadmin);
        return newadmin;
    }

    public Recepcionista crearRecepcionista(String nombre, String telefono,
                                            String identificacion, int edad ) { /// Este metodo Crea un usuario en el sistema y verifica si ya se encuentra///
        if(buscarUsuario(identificacion) != null){
            System.out.println("Error: Ya existe un usuario con el numero de identificación:  "
                    + identificacion);
            return null;
        }
        Recepcionista newrecep = new Recepcionista(nombre, telefono, identificacion,edad);
       newrecep.setNickname("UQ"+identificacion);
        agregarUsuario(newrecep);
        return newrecep;
    }

    public Estudiante crearEstudiante(String nombre, String telefono, String identificacion, int edad ) { /// Este metodo Crea un usuario en el sistema y verifica si ya se encuentra///
        if(buscarUsuario(identificacion) != null){
            System.out.println("Error: Ya existe un usuario con el numero de identificación " + identificacion);
            return null;
        }
        Estudiante newestudiante = new Estudiante(nombre, telefono, identificacion, edad);
        agregarUsuario(newestudiante);
        return newestudiante;
    }

    public TrabajadorUQ crearTrabajador(String nombre, String telefono, String identificacion, int edad ) { /// Este metodo Crea un usuario en el sistema y verifica si ya se encuentra///
        if(buscarUsuario(identificacion) != null){
            System.out.println("Error: Ya existe un usuario con el numero de identificación:  " + identificacion);
            return null;
        }
        TrabajadorUQ newtrabajador = new TrabajadorUQ(nombre, telefono, identificacion, edad);
        agregarUsuario(newtrabajador);
        return newtrabajador;
    }

    public Externo crearExterno(String nombre, String telefono, String identificacion, int edad ) { /// Este metodo Crea un usuario en el sistema y verifica si ya se encuentra///
        if(buscarUsuario(identificacion) != null){
            System.out.println("Error: Ya existe un usuario con el numero de identificación:  " + identificacion);
            return null;
        }
        Externo newexterno = new Externo(nombre, telefono, identificacion, edad);
        agregarUsuario(newexterno);
        return newexterno;
    }

    public Entrenador crearEntrenador(String nombre, String telefono, String identificacion, int edad) { /// Este metodo Crea un usuario en el sistema y verifica si ya se encuentra///
        if(buscarUsuario(identificacion) != null){
            System.out.println("Error: Ya existe un usuario con el numero de identificación:  " + identificacion);
            return null;
        }
        Entrenador newentrenador = new Entrenador(nombre, telefono, identificacion, edad);
        agregarUsuario(newentrenador);
        return newentrenador;
    }

    public MembresiaBasica crearMembresiaBasica(String  descripcion, TipoMembresia tipo){

        for (Persona p : personas){
            if (p.getIdentificacion().equals(descripcion)){
                MembresiaBasica m = new MembresiaBasica(descripcion, tipo);
                if(p instanceof Estudiante){
                    m.descuentoCoste();
                } else if (p instanceof TrabajadorUQ) {
                    m.planBeneficio();
                } else {}
                p.setTipoMembresia(m);
                agregarMembresia(m);
                guardar();

                return m;
            }
        }
        return null;
    }

    public MembresiaPremium crearMembresiaPremium(String  descripcion, TipoMembresia tipo){
        for (Persona p : personas){
            if (p.getIdentificacion().equals(descripcion)){
                MembresiaPremium m = new MembresiaPremium(descripcion, tipo);
                if(p instanceof Estudiante){
                    m.descuentoCoste();
                } else {}
                p.setTipoMembresia(m);
                agregarMembresia(m);

                return m;
            }
        }
        return null;
    }

    public MembresiaVIP crearMembresiaVip(String  descripcion, TipoMembresia tipo){
        for (Persona p : personas){
            if (p.getIdentificacion().equals(descripcion)){
                MembresiaVIP m = new MembresiaVIP(descripcion, tipo);
                if(p instanceof Estudiante){
                    m.descuentoCoste();
                } else {}
                p.setTipoMembresia(m);
                agregarMembresia(m);

                return m;
            }
        }
        guardar();
        return null;
    }

    public Clase crearClase(String nombre, TipoClase tipo, LocalDate fecha,
                            LocalTime hora, int cupoMaximo, Entrenador entrenador){
        if(buscarClase(nombre)!= null){
            System.out.println("Error: Ya existe una claseo con el mismo nombre:  " + nombre);
            return null;
        }
        Clase newclase = new Clase(nombre, tipo, fecha, hora, cupoMaximo);
        agregarClase(newclase);
        return newclase;
    }

    public boolean eliminarUsuario(String identificacion){
        boolean flag = false;
        for(Persona u : personas){
            if(u.getIdentificacion().equals(identificacion)){
                personas.remove(u);
                flag = true;
            }
        }
        return flag;
    }

    public boolean eliminarClase(String nombre){
        boolean flag = false;
        for(Clase c : clases){
            if(c.getNombre().equals(nombre)){
                clases.remove(c);
                flag = true;
            }
        }
        return flag;
    }

    public Clase buscarClase(String nombre){
        Clase clase = null;

        for(Clase u : clases){
            if(u.getNombre().equals(nombre)){
                clase = u;
            }
        }
        return clase;
    }

    public Persona buscarUsuario(String identificacion){

        for(Persona u : personas){
            if(u.getIdentificacion().equals(identificacion)){
                return u;
            }
        }
        return null;
    }

    public Persona validarUsuario(String nickname, String contrasena){

        Persona persona = null;

        for(Persona u : personas){
            if(u instanceof Administrador) {
                Administrador admin = (Administrador) u;
                if (admin.getNickname().equals(nickname) && admin.getContrasena().equals(contrasena)) {
                    persona = admin;
                }
            }

            else if(u instanceof Recepcionista) {
                Recepcionista recepcionista = (Recepcionista)u;
                if (recepcionista.getNickname().equals(nickname) && recepcionista.getContrasena().equals(contrasena)) {
                    persona = recepcionista;
                }
            }
        }

        return persona;
    }
}

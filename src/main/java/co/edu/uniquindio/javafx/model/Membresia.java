package co.edu.uniquindio.javafx.model;

import java.time.LocalDate;

abstract class Membresia implements PlanDescuento {
    private TipoMembresia tipo;
    private String descripcion;
    private EstadoMembresia estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double coste;

    public Membresia(String  descripcion, TipoMembresia tipo) {
        this.descripcion = descripcion;
        this.estado = EstadoMembresia.ACTIVA;
        this.tipo = tipo;
        this.fechaInicio = LocalDate.now();
        this.fechaFin = calcularFechaFin();
        this.coste = calcularCoste();
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public Membresia(TipoMembresia tipo){
        this.tipo = tipo;
    }

    public TipoMembresia getTipo() {
        return tipo;
    }

    public void setTipo(TipoMembresia tipo) {
        this.tipo = tipo;
    }

    public EstadoMembresia getEstado() {
        return estado;
    }

    public void setEstado(EstadoMembresia estado) {
        this.estado = estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    abstract double calcularCoste();

    public LocalDate calcularFechaFin(){

        LocalDate fechaFinal = null;

        if(tipo.equals(TipoMembresia.MENSUAL)){
            fechaFinal = LocalDate.now().plusDays(30);
        }
        else if(tipo.equals(TipoMembresia.TRIMESTRAL)){
            fechaFinal = LocalDate.now().plusDays(90);
        } else if (tipo.equals(TipoMembresia.ANUAL)) {
            fechaFinal = LocalDate.now().plusDays(365);
        }
        return fechaFinal;
    }

    abstract String toCSV();

    @Override
    public String toString() {
        return  getClass().getSimpleName() + "{" +
                "tipo=" + tipo +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", coste=" + coste;
    }

    public static Membresia fromCSV(String data) {
        String[] p = data.split(";");

        String membresia = p[0];
        TipoMembresia tipo = TipoMembresia.valueOf(p[1]);
        String desc = p[2];
        EstadoMembresia estado = EstadoMembresia.valueOf(p[3]);
        LocalDate inicio = LocalDate.parse(p[4]);
        LocalDate fin = LocalDate.parse(p[5]);
        double costo = Double.parseDouble(p[6]);

        MembresiaBasica m = new MembresiaBasica(desc, tipo);
        m.setEstado(estado);
        m.setFechaInicio(inicio);
        m.setFechaFin(fin);
        m.setCoste(costo);

        return m;
    }


}


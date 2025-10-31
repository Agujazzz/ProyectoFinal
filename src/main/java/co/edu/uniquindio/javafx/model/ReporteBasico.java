package co.edu.uniquindio.javafx.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class  ReporteBasico  extends Reporte{

    private List<Membresia> membresias;

    public ReporteBasico(LocalDate fecha ){

        super(fecha);
        this.membresias = new ArrayList<>();
    }


    public List<Membresia> getMembresias() {
        return membresias;
    }

    public void setMembresias(List<Membresia> membresias) {
        this.membresias = membresias;
    }

    public void  agregarMembresia(Membresia membresia){
        membresias.add(membresia);
    }

}


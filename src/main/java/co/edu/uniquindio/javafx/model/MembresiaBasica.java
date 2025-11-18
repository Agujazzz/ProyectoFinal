package co.edu.uniquindio.javafx.model;

public class MembresiaBasica extends Membresia{

    public MembresiaBasica(String  descripcion, TipoMembresia tipo) {
        super(descripcion, tipo);
    }

    @Override
    public String toCSV() {
        return  "|MembresiaBasica" + ";" + getTipo() + ";" + getDescripcion() + ";" + getEstado() + ";" +
                getFechaInicio() + ";" + getFechaFin() + ";" + getCoste();
    }


    @Override
    public double calcularCoste() {

        double coste = 15000;

        if(getTipo().equals(TipoMembresia.TRIMESTRAL)){
            coste*=3;
        }
        else if(getTipo().equals(TipoMembresia.ANUAL)){
            coste*=12;
        }

        return coste;
    }

    @Override
    public void descuentoCoste(){

        double coste = getCoste();

        coste *= 0.85;

        setCoste(coste);
    }

    public void planBeneficio(){
        setCoste(0);
    }
}

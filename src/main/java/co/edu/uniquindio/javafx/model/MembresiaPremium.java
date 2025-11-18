package co.edu.uniquindio.javafx.model;

public class MembresiaPremium extends Membresia {

    public MembresiaPremium(String  descripcion, TipoMembresia tipo) {
        super(descripcion,tipo);
    }

    @Override
    public double calcularCoste() {

        double coste = 25000;

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

        coste *= 0.80;

        setCoste(coste);
    }

    @Override
    public String toCSV() {
        return null;
    }

}

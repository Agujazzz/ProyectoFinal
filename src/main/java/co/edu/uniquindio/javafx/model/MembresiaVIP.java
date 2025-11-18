package co.edu.uniquindio.javafx.model;

public class MembresiaVIP extends Membresia {

    private Entrenador entrenadorP;

    public MembresiaVIP(String  descripcion, TipoMembresia tipo) {
        super(descripcion, tipo);
    }

    public Entrenador getEntrenadorP() {
        return entrenadorP;
    }

    public void setEntrenadorP(Entrenador entrenadorP) {
        this.entrenadorP = entrenadorP;
    }

    @Override
    public String toString() {
        return "VIP{" +
                "entrenadorP=" + entrenadorP +
                '}';
    }

    @Override
    public double calcularCoste() {

        double coste = 35000;

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

        coste *= 0.75;

        setCoste(coste);
    }

    @Override
    public String toCSV() {
        return null;
    }
}

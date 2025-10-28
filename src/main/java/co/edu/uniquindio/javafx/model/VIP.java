package co.edu.uniquindio.javafx.model;

public class VIP extends Membresia {

    private Entrenador entrenadorP;

    public VIP(Entrenador entrenadorP, TipoMembresia tipo) {
        super(tipo);
        this.entrenadorP = entrenadorP;
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
}

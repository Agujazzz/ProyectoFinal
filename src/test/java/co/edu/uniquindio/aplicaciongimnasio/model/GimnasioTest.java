package co.edu.uniquindio.aplicaciongimnasio.model;

import co.edu.uniquindio.javafx.model.Administrador;
import co.edu.uniquindio.javafx.model.Estudiante;
import co.edu.uniquindio.javafx.model.Gimnasio;
import org.junit.jupiter.api.Test;

class GimnasioTest {

    Gimnasio gim = new Gimnasio("asdas", "11231");
    Administrador ad = new Administrador("asdsa", "12321",
            "11", 11);
    Estudiante es = new Estudiante("juan", "12321",
            "111", 12);


    @Test
    public void verificarAdd() {
        gim.agregarUsuario(es);
        gim.agregarUsuario(ad);

        System.out.println(gim);
    }


}
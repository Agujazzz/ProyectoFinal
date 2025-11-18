package co.edu.uniquindio.aplicaciongimnasio.model;

import co.edu.uniquindio.javafx.model.*;
import org.junit.jupiter.api.Test;

class GimnasioTest {

    Gimnasio gim = new Gimnasio("asdas", "11231");
    //Administrador ad = gim.crearAdministrador("kcoas", "1212312",
         //   "111", 11,"mipapaesmessi");
    //Recepcionista r = gim.crearRecepcionista("aña", "1111", "33", 11);


    @Test
    public void verificarAdd() {

        Estudiante es = gim.crearEstudiante("pepe", "123121", "3", 12);
        MembresiaBasica m = gim.crearMembresiaBasica("3", TipoMembresia.ANUAL);


    }


}
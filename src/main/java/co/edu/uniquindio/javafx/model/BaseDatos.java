package co.edu.uniquindio.javafx.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDatos {
    private final File archivo;

    public BaseDatos() {
        this.archivo = new File(System.getProperty("user.dir") + "/src/main/resources/data/personas.txt");
    }

    public List<Persona> cargarPersonas() {
        List<Persona> lista = new ArrayList<>();

        if (!archivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lista.add(Persona.fromCSV(line));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void guardarPersonas(List<Persona> personas) {
        try (FileWriter fw = new FileWriter(archivo, false)) {
            for (Persona p : personas) {
                fw.write(p.toCSV() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

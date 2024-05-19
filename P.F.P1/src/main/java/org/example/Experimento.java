package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Experimento implements Serializable {
    private static final long serialVersionUID = 1L; // Añadir un serialVersionUID para la serialización
    private List<PoblacionBacterias> poblaciones;

    public Experimento() {
        this.poblaciones = new ArrayList<>();
    }

    // Método para agregar una población
    public void agregarPoblacion(PoblacionBacterias poblacion) {
        this.poblaciones.add(poblacion);
    }

    // Método para eliminar una población
    public void eliminarPoblacion(PoblacionBacterias poblacion) {
        this.poblaciones.remove(poblacion);
    }

    // Método para obtener todas las poblaciones
    public List<PoblacionBacterias> obtenerPoblaciones() {
        return this.poblaciones;
    }

    // Método estático para abrir un archivo y devolver un objeto Experimento
    public static Experimento abrir(String rutaArchivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return (Experimento) ois.readObject();
        }
    }

    // Método para guardar el experimento en un archivo
    public void guardarComo(String rutaArchivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(this);
        }
    }
}

package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Experimento {
    private List<PoblacionBacterias> poblaciones;
public  Experimento() {
    poblaciones = new ArrayList<>();
}

// Métodos para agregar, eliminar y obtener poblaciones de bacterias
public void agregarPoblacion(PoblacionBacterias poblacion) {
    poblaciones.add(poblacion);
}

public void eliminarPoblacion(int indice) {
    if (indice >= 0 && indice < poblaciones.size()) {
        poblaciones.remove(indice);
    } else {
        System.out.println("Índice inválido");
    }
}

public PoblacionBacterias obtenerPoblacion(int indice) {
    if (indice >= 0 && indice < poblaciones.size()) {
        return poblaciones.get(indice);
    } else {
        System.out.println("Índice inválido");
        return null;
    }
}
// Otros métodos necesarios para la gestión del experimento
public int cantidadPoblaciones() {
    return poblaciones.size();
}
// Método para cargar datos desde un archivo
public void cargarDesdeArchivo(String nombreArchivo) {
    try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
        poblaciones = (ArrayList<PoblacionBacterias>) entrada.readObject();
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error al cargar desde el archivo: " + e.getMessage());
    }
}

// Método para guardar datos en un archivo
public void guardarEnArchivo(String nombreArchivo) {
    try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
        salida.writeObject(poblaciones);
    } catch (IOException e) {
        System.out.println("Error al guardar en el archivo: " + e.getMessage());
    }
 }
}
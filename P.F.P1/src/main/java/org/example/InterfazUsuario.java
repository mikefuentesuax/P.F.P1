package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazUsuario {
    private JFrame frame;
    private Experimento experimento;

    public InterfazUsuario() {
        experimento = new Experimento();
        frame = new JFrame("Gestión de Experimentos de Bacterias");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel para los botones en orden vertical
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));

        // Crear los botones con sus respectivos ActionListener
        JButton btnAbrirArchivo = new JButton("1. Abrir archivo que contenga un experimento");
        btnAbrirArchivo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para abrir un archivo de experimento
            }
        });
        panelBotones.add(btnAbrirArchivo);

        JButton btnNuevoExperimento = new JButton("2. Crear un nuevo experimento");
        btnNuevoExperimento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para crear un nuevo experimento
            }
        });
        panelBotones.add(btnNuevoExperimento);

        JButton btnCrearPoblacion = new JButton("3. Crear una población de bacterias y añadirla al experimento actual");
        btnCrearPoblacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para crear una población de bacterias
            }
        });
        panelBotones.add(btnCrearPoblacion);

        JButton btnVisualizarNombres = new JButton("4. Visualizar los nombres de todas las poblaciones de bacterias del experimento actual");
        btnVisualizarNombres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para visualizar los nombres de las poblaciones de bacterias
            }
        });
        panelBotones.add(btnVisualizarNombres);

        JButton btnBorrarPoblacion = new JButton("5. Borrar una población de bacterias del experimento actual");
        btnBorrarPoblacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para borrar una población de bacterias
            }
        });
        panelBotones.add(btnBorrarPoblacion);

        JButton btnVerInformacion = new JButton("6. Ver información detallada de una población de bacterias del experimento actual");
        btnVerInformacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para ver información detallada de una población de bacterias
            }
        });
        panelBotones.add(btnVerInformacion);

        JButton btnGuardar = new JButton("7. Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para guardar el experimento actual
            }
        });
        panelBotones.add(btnGuardar);

        JButton btnGuardarComo = new JButton("8. Guardar como");
        btnGuardarComo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para guardar el experimento actual como un nuevo archivo
            }
        });
        panelBotones.add(btnGuardarComo);

        // Agregar el panel de botones al frame
        frame.add(panelBotones, BorderLayout.WEST);

        frame.setVisible(true);
    }

    public void iniciar() {
        SwingUtilities.invokeLater(() -> new InterfazUsuario());
    }

    public static void main(String[] args) {
        new InterfazUsuario().iniciar();
    }
}

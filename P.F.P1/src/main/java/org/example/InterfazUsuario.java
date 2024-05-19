package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
        btnAbrirArchivo.setHorizontalAlignment(SwingConstants.LEFT);  // Alinear texto a la izquierda
        btnAbrirArchivo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        experimento = Experimento.abrir(fileChooser.getSelectedFile().getPath());
                    } catch (IOException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(frame, "Error al abrir el archivo: " + ex.getMessage());
                    }
                }
            }
        });
        panelBotones.add(btnAbrirArchivo);

        JButton btnNuevoExperimento = new JButton("2. Crear un nuevo experimento");
        btnNuevoExperimento.setHorizontalAlignment(SwingConstants.LEFT);  // Alinear texto a la izquierda
        btnNuevoExperimento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                experimento = new Experimento();
                JOptionPane.showMessageDialog(frame, "Nuevo experimento creado.");
            }
        });
        panelBotones.add(btnNuevoExperimento);

        JButton btnCrearPoblacion = new JButton("3. Crear una población de bacterias y añadirla al experimento actual");
        btnCrearPoblacion.setHorizontalAlignment(SwingConstants.LEFT);  // Alinear texto a la izquierda
        btnCrearPoblacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CrearPoblacionDialog dialog = new CrearPoblacionDialog(frame);
                dialog.setVisible(true);

                if (dialog.isConfirmed()) {
                    PoblacionBacterias nuevaPoblacion = dialog.getPoblacionBacterias();
                    if (nuevaPoblacion != null) {
                        experimento.agregarPoblacion(nuevaPoblacion);
                        JOptionPane.showMessageDialog(frame, "Nueva población de bacterias añadida.");
                    }
                }
            }
        });

        panelBotones.add(btnCrearPoblacion);

        JButton btnVisualizarNombres = new JButton("4. Visualizar los nombres de todas las poblaciones de bacterias del experimento actual");
        btnVisualizarNombres.setHorizontalAlignment(SwingConstants.LEFT);  // Alinear texto a la izquierda
        btnVisualizarNombres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder nombres = new StringBuilder("Poblaciones de bacterias:\n");
                for (PoblacionBacterias poblacion : experimento.obtenerPoblaciones()) {
                    nombres.append(poblacion.getNombre()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, nombres.toString());
            }
        });
        panelBotones.add(btnVisualizarNombres);

        JButton btnBorrarPoblacion = new JButton("5. Borrar una población de bacterias del experimento actual");
        btnBorrarPoblacion.setHorizontalAlignment(SwingConstants.LEFT);  // Alinear texto a la izquierda
        btnBorrarPoblacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para borrar una población de bacterias
                // Mostrar un cuadro de diálogo para seleccionar la población a borrar
            }
        });
        panelBotones.add(btnBorrarPoblacion);

        JButton btnVerInformacion = new JButton("6. Ver información detallada de una población de bacterias del experimento actual");
        btnVerInformacion.setHorizontalAlignment(SwingConstants.LEFT);  // Alinear texto a la izquierda
        btnVerInformacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para ver información detallada de una población de bacterias
                // Mostrar un cuadro de diálogo con la información detallada
            }
        });
        panelBotones.add(btnVerInformacion);

        JButton btnGuardar = new JButton("7. Guardar");
        btnGuardar.setHorizontalAlignment(SwingConstants.LEFT);  // Alinear texto a la izquierda
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        experimento.guardarComo(fileChooser.getSelectedFile().getPath());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error al guardar el archivo: " + ex.getMessage());
                    }
                }
            }
        });
        panelBotones.add(btnGuardar);

        JButton btnGuardarComo = new JButton("8. Guardar como");
        btnGuardarComo.setHorizontalAlignment(SwingConstants.LEFT);  // Alinear texto a la izquierda
        btnGuardarComo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        experimento.guardarComo(fileChooser.getSelectedFile().getPath());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error al guardar el archivo: " + ex.getMessage());
                    }
                }
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

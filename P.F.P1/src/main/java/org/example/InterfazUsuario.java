package org.example;

import javax.swing.*;
import java.awt.*;

public class InterfazUsuario {
    private JFrame frame;
    private Experimento experimento;

    public InterfazUsuario() {
        experimento = new Experimento();
        frame = new JFrame("Gestión de Experimentos de Bacterias");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Aquí puedes agregar los componentes de la interfaz, como botones, campos de texto, etc.

        frame.setVisible(true);
    }

    // Método para iniciar la interfaz de usuario
    public void iniciar() {
        SwingUtilities.invokeLater(() -> new InterfazUsuario());
    }

    // Otros métodos para gestionar la interfaz, como agregar componentes, manejar eventos, etc.
}

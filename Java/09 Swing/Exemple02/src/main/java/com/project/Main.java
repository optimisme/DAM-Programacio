package com.project;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        // Inici del fil d'execució de SWING
        SwingUtilities.invokeLater(() -> {

            // Mostrar la finestra quan es carrega el programa
            new MainWindow().setVisible(true);
        });
    }
}
package com.project;

import javax.swing.*;
import java.awt.Component;

public class MainWindow extends JFrame {
    
    private int comptador = 0; // Atribut per emmagatzemar el valor que es mostrarà en l'etiqueta
    private JLabel etiquetaComptador; // Etiqueta per mostrar el valor
    
    public MainWindow() {
        // Títol i mida de la finestra
        super("SWING Exemple 00");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Definir els elements del menú
        setMenu();
    
        // Definir els elements del panel
        initComponents();   
    }

    private void modificaComptador(int valor) {
        comptador = comptador + valor; // Incrementa el valor del comptador
        etiquetaComptador.setText(String.valueOf(comptador)); // Actualitza el text de l'etiqueta amb el nou valor
    }

    private void closeApp() {
        // Tanca l'aplicació correctament
        System.exit(0);
    }

    private void setMenu () {
        JMenuBar barraMenu = new JMenuBar();

        // Menú Arxiu
        JMenu menuArxiu = new JMenu("Arxiu");
            JMenuItem menuItemSortir = new JMenuItem("Sortir");
            menuItemSortir.addActionListener(e -> closeApp());
            menuArxiu.add(menuItemSortir);
        barraMenu.add(menuArxiu);

        // Menú per fer Càlculs
        JMenu menuCalculs = new JMenu("Càlculs");
            JMenuItem menuItemSumar = new JMenuItem("Sumar");
            menuItemSumar.addActionListener(e -> modificaComptador(1));
            menuCalculs.add(menuItemSumar);

            JMenuItem menuItemRestar = new JMenuItem("Restar");
            menuItemRestar.addActionListener(e -> modificaComptador(-1));
            menuCalculs.add(menuItemRestar);
        barraMenu.add(menuCalculs);

        this.setJMenuBar(barraMenu);
    }

    private void initComponents () {
        // Crea un panell com a contenidor amb BoxLayout alineat al eix Y
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(panel);
    
        // Espaiador vertical
        panel.add(Box.createVerticalStrut(50));
    
        // Crear i afegir l'etiqueta al panell, centrant-la horitzontalment
        etiquetaComptador = new JLabel("0");
        etiquetaComptador.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(etiquetaComptador);
    
        // Crear botó, centrant-lo horitzontalment, i afegir al panell
        JButton boto = new JButton("Clica'm");
        boto.setAlignmentX(Component.CENTER_ALIGNMENT);
        boto.addActionListener(e -> modificaComptador(1));
        panel.add(boto);
    }
}

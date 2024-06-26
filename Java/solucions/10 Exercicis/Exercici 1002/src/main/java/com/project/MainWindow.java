package com.project;

import javax.swing.*;

public class MainWindow extends JFrame {
    
    public View view;
    public Controller controller;

    public MainWindow() {
        // Títol i mida de la finestra
        super("Calculadora");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Definir els elements del menú
        setMenu();
    
        // Definir els elements del panel
        initComponents();   

        // Iniciar el controlador
        controller = new Controller(view);
        controller.start();
    }

    private void closeApp() {
        // Tanca l'aplicació correctament
        System.exit(0);
    }

    private void setMenu () {
        JMenuBar menuBar = new JMenuBar();

        // Menú Arxiu
        JMenu menuFile = new JMenu("Arxiu");
            JMenuItem menuQuit = new JMenuItem("Sortir");
            menuQuit.addActionListener(e -> closeApp());
            menuFile.add(menuQuit);
            menuBar.add(menuFile);

        // Menú per fer Càlculs
        JMenu menuOp = new JMenu("Operacions");
            JMenuItem menuC = new JMenuItem("Netejar");
            menuC.addActionListener(e -> controller.runCommand("C"));
            menuOp.add(menuC);

            JMenuItem menuI = new JMenuItem("Igual");
            menuI.addActionListener(e -> controller.runCommand("="));
            menuOp.add(menuI);

        menuBar.add(menuOp);

        this.setJMenuBar(menuBar);
    }

    private void initComponents() {
        view = new View();
        add(view);
    }
}

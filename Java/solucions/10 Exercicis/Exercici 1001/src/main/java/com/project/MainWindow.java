package com.project;

import javax.swing.*;

public class MainWindow extends JFrame {
    
    public View view;
    public Controller controller;

    public MainWindow() {
        // Títol i mida de la finestra
        super("SWING Tasks");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        // Definir els elements del panel
        initComponents();   

        // Iniciar el controlador
        controller = new Controller(view);
        controller.start();
    }

    private void initComponents() {
        view = new View();
        add(view);
    }
}

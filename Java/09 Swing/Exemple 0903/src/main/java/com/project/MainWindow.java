package com.project;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {

    // CardLayout no és un component visible
    // només gestiona la visibilitat d'un component al mateix temps
    JTabbedPane tabbedPane = new JTabbedPane();

    // Model, vistes i controlador
    private CategoriaController categoriaController;
    private CategoriaView categoriaView;

    private ProducteController producteController;
    private ProducteView producteView;

    public MainWindow() {

        // Títol i mida de la finestra
        super("Exemple 03 MVC-DDBB");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();

        // Inicialitza els controladors amb els models i vistes carregats
        categoriaController = new CategoriaController(categoriaView, tabbedPane);
        categoriaController.start();
        producteController = new ProducteController(producteView, tabbedPane);
        producteController.start();
    }

    private void initComponents() {
        // Crea un panell amb BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
        // Espai superior fins als botons
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
    
        // Inicialitza les vistes
        categoriaView = new CategoriaView();
        producteView = new ProducteView();
    
        // Afegeix les vistes als espais del 'tabbedPane'
        tabbedPane.addTab("Categories", categoriaView);
        tabbedPane.addTab("Productes", producteView);
    
        // Afegeix el tabbedPane al panell
        panel.add(tabbedPane);
    
        // Afegeix el panell al JFrame principal
        getContentPane().add(panel);
    }
    
}

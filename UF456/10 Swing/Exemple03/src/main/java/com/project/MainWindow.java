package com.project;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {

    // CardLayout no és un component visible
    // només gestiona la visibilitat d'un component al mateix temps
    private CardLayout cardLayout = new CardLayout();
    private JPanel cards = new JPanel(cardLayout);

    // Model, vistes i controlador
    private CategoriaController categoriaController;
    private CategoriaModel categoriaModel;
    private CategoriaView categoriaView;

    private ProducteController producteController;
    private ProducteModel producteModel;
    private ProducteView producteView;

    public MainWindow() {

        // Títol i mida de la finestra
        super("Exemple 03 MVC-DDBB");
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();

        // Inicialitza els controladors amb els models i vistes carregats
        categoriaController = new CategoriaController(categoriaModel, categoriaView, cardLayout, cards);
        categoriaController.start();
        producteController = new ProducteController(producteModel, producteView, cardLayout, cards);
        producteController.start();
    }

    private void initComponents() {
        
        // Inicialitza les vistes (això pot requerir passar dades a les vistes)
        categoriaView = new CategoriaView();
        producteView = new ProducteView();
       
        // Afegeix les vistes al CardLayout
        cards.add(categoriaView, "CATEGORIES");
        cards.add(producteView, "PRODUCTES");
        
        // Canvia a la vista inicial que vols mostrar, p. ex., categories
        cardLayout.show(cards, "CATEGORIES");

        // Afegeix el panell de cards a la finestra
        add(cards);
    }
}

package com.project;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {
    
    // CardLayout no és un component visible
    // només gestiona la visibilitat d'un component al mateix temps
    private CardLayout cardLayout = new CardLayout();
    private JPanel cards = new JPanel(cardLayout);

    private ViewList vList;
    private ViewItem vItem;

    private Controller controller;

    public MainWindow() {
        // Títol i mida de la finestra
        super("Receptes");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        // Definir els elements del panel
        initComponents();   

        // Iniciar el controlador
        controller = new Controller(vList, vItem, cardLayout, cards);
        controller.start();
    }

    private void initComponents() {

        // Afegeix les vistes al CardLayout
        vList = new ViewList();
        cards.add(vList, "LIST");

        vItem = new ViewItem();
        cards.add(vItem, "ITEM");
        
        // Definir quina vista es mostra per defecte (FORM)
        cardLayout.show(cards, "LIST");

        // Afegir les vistes al panell de la finestra
        add(cards);
    }
}

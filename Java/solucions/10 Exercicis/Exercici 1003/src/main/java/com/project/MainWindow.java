package com.project;

import java.awt.*;
import javax.swing.*;


public class MainWindow extends JFrame {
    
    // CardLayout no és un component visible
    // només gestiona la visibilitat d'un component al mateix temps
    public CardLayout cardLayout = new CardLayout();
    public JPanel cards = new JPanel(cardLayout);

    public ViewForm vForm;
    public ViewLoading vLoading;
    public ViewInfo vInfo;

    public Controller controller;

    public MainWindow() {
        // Títol i mida de la finestra
        super("Real Time events");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        // Definir els elements del panel
        initComponents();   

        // Iniciar el controlador
        controller = new Controller(vForm, vLoading, vInfo, cardLayout, cards);
        controller.start();
    }

    private void initComponents() {

        // Afegeix les vistes al CardLayout
        vForm = new ViewForm();
        cards.add(vForm, "FORM");

        vLoading = new ViewLoading();
        cards.add(vLoading, "LOADING");

        vInfo = new ViewInfo();
        cards.add(vInfo, "INFO");
        
        // Definir quina vista es mostra per defecte (FORM)
        cardLayout.show(cards, "FORM");

        // Afegir les vistes al panell de la finestra
        add(cards);
    }
}

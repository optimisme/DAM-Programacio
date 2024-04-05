package com.project;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    // CardLayout no és un component visible
    // només gestiona la visibilitat d'un component al mateix temps
    private CardLayout cardLayout = new CardLayout();
    private JPanel cards = new JPanel(cardLayout);

    // Model, vistes i controlador
    private Model model = new Model();
    private ViewForm vForm;
    private ViewInfo vInfo;
    private Controller controller;

    public MainWindow() {

        // Títol i mida de la finestra
        super("Exemple 02 MVC");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Afegeix les vistes al CardLayout
            vForm = new ViewForm();
            cards.add(vForm, "FORM");

            vInfo = new ViewInfo();
            cards.add(vInfo, "INFO");
            
            // Definir quina vista es mostra per defecte (FORM)
            cardLayout.show(cards, "FORM");

        // Afegir les vistes al panell de la finestra
        add(cards);

        // Configurar i iniciar el controlador
        controller = new Controller(model, vForm, vInfo, cardLayout, cards);
        controller.start();
    }
}

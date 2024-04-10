package com.project;

import javax.swing.*;
import java.awt.*;

public class ViewLoading extends JPanel {

    public JProgressBar progressBar = new JProgressBar(0, 100);
    private JLabel loadingLabel = new JLabel("Loading... 0%");

    public ViewLoading() {
        setLayout(new BorderLayout());
        progressBar.setValue(0);
        progressBar.setStringPainted(false); // Que el % no es dibuixi a la barra

        // Configura l'etiqueta de càrrega
        loadingLabel.setHorizontalAlignment(JLabel.CENTER);

        // Panell que actua com a contenidor de la barra de progrés i de l'etiqueta
        // amb 75 píxels de marge horitzontal i 10 vertical
        JPanel progressBarContainer = new JPanel();
        progressBarContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 75, 10)); 
        progressBarContainer.add(loadingLabel);
        progressBarContainer.add(progressBar);

        // Mida preferida per a la barra de progrés
        progressBar.setPreferredSize(new Dimension(300, progressBar.getPreferredSize().height));

        add(progressBarContainer, BorderLayout.CENTER);
    }

    // Mètode per actualitzar el percentatge de la barra i el text de l'etiqueta
    public void updateProgress(int value) {
        progressBar.setValue(value);
        loadingLabel.setText("Loading... " + value + "%");
    }
}



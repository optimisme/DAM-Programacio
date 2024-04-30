package com.project;

import javax.swing.*;
import java.awt.*;

public class ViewList extends JPanel {

    public JList<ReceptaModel> modelList;
    public JLabel loadingLabel;
    public JScrollPane scrollPane;

    public ViewList() {
        setLayout(new BorderLayout());

        modelList = new JList<>(new DefaultListModel<ReceptaModel>()); 

        // Configuració de la etiqueta de carregament
        loadingLabel = new JLabel("Carregant...", SwingConstants.CENTER);
        add(loadingLabel, BorderLayout.NORTH);

        // Panel per a la llista amb scroll 
        // (quan hi hagi dades contindrà la llista de receptes)
        scrollPane = new JScrollPane(modelList);
        add(scrollPane, BorderLayout.CENTER);
    }
}

package com.project;

import java.awt.*;
import javax.swing.*;

public class ViewItem extends JPanel {

    public JEditorPane editorPane;
    public JScrollPane scrollPane;
    public JButton listButton;

    public ViewItem() {
        setLayout(new BorderLayout());

        // Panel per als botons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        listButton = new JButton("Llista de receptes");
        buttonPanel.add(listButton);
        buttonPanel.add(Box.createHorizontalGlue());
        add(buttonPanel, BorderLayout.NORTH);

        // Crear un JEditorPane per renderitzar codi HTML
        editorPane = new JEditorPane();
        editorPane.setContentType("text/html"); // Establir el tipus de contingut com a HTML
        editorPane.setEditable(false); // Evitar que l'usuari pugui editar el contingut

        // Afegim el JEditorPane a un JScrollPane per afegir funcionalitat d'scroll
        scrollPane = new JScrollPane(editorPane);
        add(scrollPane, BorderLayout.CENTER);
    }
}
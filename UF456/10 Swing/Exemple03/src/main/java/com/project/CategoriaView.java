package com.project;

import java.awt.*;
import javax.swing.*;

public class CategoriaView extends JPanel {

    public JButton reloadButton = new JButton("Refresca");
    public JCheckBox newItemCheckBox = new JCheckBox("Nova categoria");
    public JComboBox<String> itemComboBox = new JComboBox<>();
    public JLabel loadingLabel = new JLabel("Carregant ...");
    public JTextField itemNameField = new JTextField();
    public JButton addButton = new JButton("Afegir");
    public JButton modifyButton = new JButton("Modificar");
    public JButton deleteButton = new JButton("Esborrar");

    public CategoriaView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents();
    }

    private void initComponents() {

        // Espai superior fins als botons
        add(Box.createRigidArea(new Dimension(0, 10)));

        // Afegir botons (refresca i productes) en un panell horitzontal
        JPanel horizPanel0 = new JPanel();
        Dimension sizeHorizPanel0 = new Dimension(Integer.MAX_VALUE, reloadButton.getMinimumSize().height);
        horizPanel0.setPreferredSize(sizeHorizPanel0);
        horizPanel0.setLayout(new BoxLayout(horizPanel0, BoxLayout.X_AXIS));
        horizPanel0.add(reloadButton);
        horizPanel0.add(Box.createHorizontalGlue()); // Estira l'espai entre els botons
        horizPanel0.add(loadingLabel);
        loadingLabel.setVisible(false);
        loadingLabel.setForeground(Color.RED);
        add(horizPanel0);

        // Linia separadora 0
        JSeparator separator0 = new JSeparator(JSeparator.HORIZONTAL);
        separator0.setMinimumSize(new Dimension(Integer.MAX_VALUE, 20));
        separator0.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
        add(separator0);

        // Etiqueta de nova categoria
        newItemCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(newItemCheckBox);

        // Desplegable de categories
        itemComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemComboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, itemComboBox.getMinimumSize().height));
        add(itemComboBox);
        
        // Camps del formulari
        add(createLabeledField("Nom:", itemNameField));

        // Afegir espai vertical fins als bontons
        add(Box.createRigidArea(new Dimension(0, 20)));

        // Alinear botons (afegir, modificar i esborrar) en un panell horitzontal
        JPanel horizPanel1 = new JPanel();
        horizPanel1.setLayout(new BoxLayout(horizPanel1, BoxLayout.X_AXIS));
        horizPanel1.add(addButton);
        horizPanel1.add(Box.createRigidArea(new Dimension(10, 0)));
        horizPanel1.add(modifyButton);
        horizPanel1.add(Box.createRigidArea(new Dimension(10, 0)));
        horizPanel1.add(deleteButton);
        add(horizPanel1);

        // Expandir verticalment (per pujar els elements la resta d'elements)
        add(Box.createVerticalGlue());
    }

    // Crea una fila amb una etiqueta i un component interactiu SWING
    private JPanel createLabeledField(String labelText, JComponent component) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(100, label.getPreferredSize().height));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        
        component.setMaximumSize(new Dimension(Integer.MAX_VALUE, component.getPreferredSize().height));
        
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(5, 0)));
        panel.add(component);
        
        return panel;
    }
}

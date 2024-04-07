package com.project;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.*;

import java.util.ArrayList;

public class CategoriaView extends JPanel {
    
    public JButton reloadButton = new JButton("Refresca");
    public JButton switchToProductViewButton = new JButton("Vista de Productes");
    public JCheckBox newCategoryCheckBox = new JCheckBox("Nova categoria");
    public JComboBox<String> categoryComboBox = new JComboBox<>();
    public JLabel loadingLabel = new JLabel("Carregant ...");
    public JTextField categoryNameField = new JTextField();
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
        horizPanel0.add(switchToProductViewButton);
        add(horizPanel0);

        // Linia separadora 0
        JSeparator separator0 = new JSeparator(JSeparator.HORIZONTAL);
        separator0.setMinimumSize(new Dimension(Integer.MAX_VALUE, 20));
        separator0.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
        add(separator0);

        // Etiqueta de càrrega
        // (es posa en un panell horitzontal junt amb una area 0x20, 
        //  per ocupar sempre la mateixa mida encara que l'etiqueta no sigui visible)
        JPanel horizPanel1 = new JPanel();
        Dimension sizeHorizPanel1 = new Dimension(Integer.MAX_VALUE, loadingLabel.getMinimumSize().height);
        horizPanel1.setPreferredSize(sizeHorizPanel1);
        horizPanel1.setLayout(new BoxLayout(horizPanel1, BoxLayout.X_AXIS));
        horizPanel1.add(loadingLabel);
        horizPanel1.add(Box.createRigidArea(new Dimension(0, 20)));
        loadingLabel.setVisible(false);
        loadingLabel.setForeground(Color.RED);
        add(horizPanel1);

        // Linia separadora 1
        JSeparator separator1 = new JSeparator(JSeparator.HORIZONTAL);
        separator1.setMinimumSize(new Dimension(Integer.MAX_VALUE, 20));
        separator1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
        add(separator1);

        // Etiqueta de nova categoria
        newCategoryCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(newCategoryCheckBox);

        // Desplegable de categories
        categoryComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        categoryComboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, categoryComboBox.getMinimumSize().height));
        add(categoryComboBox);
        
        // Camps del formulari
        add(createLabeledField("Nom:", categoryNameField));

        // Afegir espai vertical fins als bontons
        add(Box.createRigidArea(new Dimension(0, 20)));

        // Alinear botons (afegir, modificar i esborrar) en un panell horitzontal
        JPanel horizPanel2 = new JPanel();
        horizPanel2.setLayout(new BoxLayout(horizPanel2, BoxLayout.X_AXIS));
        horizPanel2.add(addButton);
        horizPanel2.add(Box.createRigidArea(new Dimension(10, 0)));
        horizPanel2.add(modifyButton);
        horizPanel2.add(Box.createRigidArea(new Dimension(10, 0)));
        horizPanel2.add(deleteButton);
        add(horizPanel2);

        // Expandir verticalment (per pujar els elements la resta d'elements)
        add(Box.createVerticalGlue());
    }

    private JPanel createLabeledField(String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(100, label.getPreferredSize().height));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height));
        
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(5, 0)));
        panel.add(textField);
        
        return panel;
    }
    
    // Emplena el 'combo box' amb les categories, 
    // i el model amb les dades sel·leccionades al 'combo box'
    public void displayModelDetails(ArrayList<String> categories, CategoriaModel model) {

        // Elimina tots els elements existents al JComboBox
        categoryComboBox.removeAllItems();
    
        // Afegeix les categories rebudes al JComboBox
        for (String category : categories) {
            categoryComboBox.addItem(category);
        }
    
        // Actualitza el camp de text amb el nom de la categoria del model, si el model no és null
        if (model != null) {
            categoryNameField.setText(model.getNom());
        } else { 
            // Si el model és null, potser voldràs assegurar-te que el camp està buit o té un valor per defecte
            categoryNameField.setText("");
        }
    }
    
    // Obté el valor del desplegable (o "" si no encara no hi ha res)
    public String getCategoryComboBoxValue () {
        try {
            return categoryComboBox.getSelectedItem().toString();
        } catch (Exception e) {
            return "";
        }
    }
}

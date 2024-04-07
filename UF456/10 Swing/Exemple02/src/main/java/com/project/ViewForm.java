package com.project;

import javax.swing.*;
import java.awt.*;

public class ViewForm extends JPanel {

    public JTextField nameField = new JTextField(20);
    public JTextField ageField = new JTextField(20);
    public JLabel ageErrorLabel;
    public JButton infoButton = new JButton("Mostra Info");

    public ViewForm() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Espai vertical inicial
        add(Box.createRigidArea(new Dimension(0, 10))); 

        // Ajusta BoxLayout per al namePanel
        JPanel namePanel = createLabeledField("Name:", nameField);

        // Ajusta BoxLayout per a l'agePanel
        JPanel agePanel = createLabeledField("Age:", ageField);
        
        // Afegeix els panells al panel principal
        add(namePanel);
        add(agePanel);

        // Missatge d'edat errònia (només visible si l'edat no és vàlida)
        ageErrorLabel = new JLabel("Error, edat no vàlida");
        ageErrorLabel.setForeground(Color.RED);
        ageErrorLabel.setVisible(false);
        add(ageErrorLabel);
        
        // Afegeix espai vertical abans del botó i afegeix el botó
        add(Box.createVerticalStrut(10));
        add(infoButton);
    }

    private JPanel createLabeledField(String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(100, label.getPreferredSize().height));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        
        // Ajusta les dimensions màximes del camp de text per evitar l'expansió vertical
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height));
        
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(5, 0))); // Espai entre el label i el camp de text
        panel.add(textField);
        
        return panel;
    }
}

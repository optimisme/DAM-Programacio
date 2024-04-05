package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewForm extends JPanel {

    private JTextField nameField = new JTextField(20);
    private JTextField ageField = new JTextField(20);
    private JLabel ageErrorLabel;
    private JButton infoButton = new JButton("Mostra Info");

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

    // Defineix el valor del camp de text 'nameField' amb el valor 'name'
    public void setFormName(String name) {
        nameField.setText(name);
    }
    
    // Defineix el valor del camp de text 'ageField' amb el valor 'age'
    public void setFormAge(int age) {
        ageField.setText(String.valueOf(age));
    }

    // Obté el valor del camp de text 'nameField'
    public String getFormName() {
        return nameField.getText();
    }

    // Obté el valor del camp de text 'ageField'
    public String getFormAge() {
        return ageField.getText();
    }

    // Mostrar o amagar el missatge d'edat errònia
    public void setAgeErrorLabelVisible(Boolean value) {
        ageErrorLabel.setVisible(value);
    }

    // Funció per definir quina acció fa el botó de del controller
    public void setInfoButtonAction(ActionListener action) {
        infoButton.addActionListener(action);
    }
}

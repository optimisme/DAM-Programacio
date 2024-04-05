package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewInfo extends JPanel {

    private JLabel nameLabel = new JLabel("Name: ");
    private JLabel nameValueLabel = new JLabel(); // Aquest label mostrarà el valor de nom

    private JLabel ageLabel = new JLabel("Age: ");
    private JLabel ageValueLabel = new JLabel(); // Aquest label mostrarà el valor d'edat

    private JButton backButton = new JButton("Torna");
    private JButton randomInfoButton = new JButton("Informació Aleatòria");

    public ViewInfo() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Espai vertical inicial
        add(Box.createRigidArea(new Dimension(0, 10))); 

        // Configura els labels d'informació
        nameLabel.setForeground(Color.GRAY);
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        nameLabel.setPreferredSize(new Dimension(100, nameLabel.getPreferredSize().height));
        ageLabel.setForeground(Color.GRAY);
        ageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        ageLabel.setPreferredSize(new Dimension(100, ageLabel.getPreferredSize().height));

        // Panel per a la informació de nom
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(nameLabel);
        namePanel.add(nameValueLabel);
        add(namePanel);

        // Panel per a la informació d'edat
        JPanel agePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        agePanel.add(ageLabel);
        agePanel.add(ageValueLabel);
        add(agePanel);

        // Afegeix un espai
        add(Box.createRigidArea(new Dimension(0, 10)));

        // Panel per als botons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(backButton);
        buttonPanel.add(randomInfoButton);
        add(buttonPanel);
    }

    // Mètode per mostrar la informació de l'usuari
    public void displayUserInfo(String name, int age) {
        nameValueLabel.setText(name);
        ageValueLabel.setText(String.valueOf(age));
    }

    // Funció per definir quina acció fa el botó 'backButton' de del controller
    public void setBackButtonAction(ActionListener action) {
        backButton.addActionListener(action);
    }

    // Funció per definir quina acció fa el botó 'randomInfoButton' de del controller
    public void setRandomButtonAction(ActionListener action) {
        randomInfoButton.addActionListener(action);
    }
}

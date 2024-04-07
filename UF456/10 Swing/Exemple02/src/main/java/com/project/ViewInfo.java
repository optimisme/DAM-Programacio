package com.project;

import javax.swing.*;
import java.awt.*;

public class ViewInfo extends JPanel {

    public JLabel nameLabel = new JLabel("Name: ");
    public JLabel nameValueLabel = new JLabel(); // Aquest label mostrarà el valor de nom

    public JLabel ageLabel = new JLabel("Age: ");
    public JLabel ageValueLabel = new JLabel(); // Aquest label mostrarà el valor d'edat

    public JButton backButton = new JButton("Torna");
    public JButton randomInfoButton = new JButton("Informació Aleatòria");

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
}

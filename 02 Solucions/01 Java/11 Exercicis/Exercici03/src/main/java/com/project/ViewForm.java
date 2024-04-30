package com.project;

import javax.swing.*;
import java.awt.*;

public class ViewForm extends JPanel {

    public JTextField nameField = new JTextField(20);
    public JTextField phoneNumberField = new JTextField(20);
    public JTextField ageField = new JTextField(20);
    public JTextField emailField = new JTextField(20);
    public JButton sendButton = new JButton("Send");

    public ViewForm() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridwidth = GridBagConstraints.REMAINDER; // Cada component ocupa la fila sencera
        gbc.fill = GridBagConstraints.HORIZONTAL; // Omple l'espai horitzontal
        gbc.insets = new Insets(4, 4, 4, 4); // Marges per a cada component

        // Defineix una mida preferida per als camps de text
        Dimension preferredSize = new Dimension(200, 25);
        nameField.setPreferredSize(preferredSize);
        phoneNumberField.setPreferredSize(preferredSize);
        ageField.setPreferredSize(preferredSize);
        emailField.setPreferredSize(preferredSize);
        sendButton.setPreferredSize(preferredSize);

        // Afegeix els components al panell amb les restriccions (constraints)
        add(new JLabel("Name:"), gbc);
        add(nameField, gbc);
        add(new JLabel("Phone Number:"), gbc);
        add(phoneNumberField, gbc);
        add(new JLabel("Age:"), gbc);
        add(ageField, gbc);
        add(new JLabel("Email:"), gbc);
        add(emailField, gbc);

        // Centra el botó horitzontalment
        gbc.fill = GridBagConstraints.NONE; // No omple l'espai restant
        gbc.anchor = GridBagConstraints.CENTER; // Centra el component
        add(sendButton, gbc);
    }
}
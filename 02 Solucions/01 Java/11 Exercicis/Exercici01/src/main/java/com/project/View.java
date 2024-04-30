package com.project;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class View extends JPanel {

    JTextField taskInput = new JTextField();
    JButton addButton = new JButton("Afegeix");
    JButton deleteButton = new JButton("Elimina");
    JList<String> taskList = new JList<>(); // Caldrà establir el model de JList
    JScrollPane scrollPane = new JScrollPane(taskList);

    public View() {

        setLayout(new BorderLayout());

        // Configurar el panell de contingut
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Afegir components al panell
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(deleteButton, BorderLayout.SOUTH);
    }
}

package com.project;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Random;

public class MainWindow extends JFrame {
    
    private JLabel sliderValueLabel;
    private JButton randomNumberButton;
    private JSlider slider;
    private JCheckBox checkBox;

    public MainWindow() {
        // Títol i mida de la finestra
        super("SWING Exemple 01");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        // Definir els elements del panel
        initComponents();
        
        // Inicia els elements
        updateLabelFromSlider();
    }

    private void initComponents () {
        // Crea un panell com a contenidor amb BoxLayout alineat al eix Y
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(panel);
    
        // Espaiador vertical
        panel.add(Box.createVerticalStrut(10));
    
        // Crea i configura el slider
        slider = new JSlider(0, 100, 25);
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this::updateSliderLabel);
        panel.add(slider);

        // Etiqueta per mostrar el valor del slider
        sliderValueLabel = new JLabel("");
        panel.add(sliderValueLabel);

        // Espaiador vertical
        panel.add(Box.createVerticalStrut(10));

        // Checkbox per activar/desactivar el botó
        checkBox = new JCheckBox("Activa botó");
        checkBox.addActionListener(this::updateCheckBox);
        panel.add(checkBox);

        // Botó per mostrar un nom aleatori
        randomNumberButton = new JButton("Número aleatori");
        randomNumberButton.setEnabled(false); // Desactivat per defecte
        randomNumberButton.addActionListener(this::updateRandomly);
        panel.add(randomNumberButton);
    }

    // Funció que es crida junt amb l'event al modificar el valor del slider
    private void updateSliderLabel (ChangeEvent e) {
        updateLabelFromSlider();
    }

    // Funció que es crida junt amb l'event de modificar el checkBox
    private void updateCheckBox (ActionEvent e) {
        randomNumberButton.setEnabled(checkBox.isSelected());
    }

    // Actualitzar el valor del label a partir de la posició de l'slider
    private void updateLabelFromSlider () {
        sliderValueLabel.setText("Valor del slider: " + slider.getValue());
    }

    // Genera un número aleatori i actualitza l'slider i el label
    public void updateRandomly (ActionEvent e) {
        Random random = new Random();
        int value = random.nextInt(99);

        slider.setValue(value);
        updateLabelFromSlider();
    }
}

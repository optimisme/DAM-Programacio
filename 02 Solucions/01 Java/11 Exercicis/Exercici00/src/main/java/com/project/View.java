package com.project;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class View extends JPanel {
    
    public JRadioButton option1, option2, option3;
    public JSlider volumeSlider;
    public JTextField textField; 
    public JLabel configDisplay;
    public JButton resetButton;

    public View() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createVerticalStrut(10));

        // Configuració dels botons de selecció
        ButtonGroup group = new ButtonGroup();
        option1 = new JRadioButton("Opció 1", true);
        option2 = new JRadioButton("Opció 2", false);
        option3 = new JRadioButton("Opció 3", false);
        group.add(option1); // Atenció això ho afegeix al grup d'opcions excloents però no a la vista
        group.add(option2);
        group.add(option3);

        // Marc dels botons 'radio'
        JPanel radioPanel = new JPanel();
        radioPanel.setBorder(BorderFactory.createTitledBorder("Selecciona una opció"));
        radioPanel.add(option1); // Atenció això ho afegeix a la vista
        radioPanel.add(option2);
        radioPanel.add(option3);
        add(radioPanel);
        
        // Configuració del Slider
        volumeSlider = new JSlider(0, 100, 50);
        volumeSlider.setMajorTickSpacing(20);
        volumeSlider.setMinorTickSpacing(5);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);

        // Marc de l'Slider
        JPanel sliderPanel = new JPanel();
        sliderPanel.setBorder(BorderFactory.createTitledBorder("Ajusta el volum"));
        sliderPanel.add(volumeSlider);
        add(sliderPanel);

        // Configuració del TextField
        textField = new JTextField(10);

        // Marc del camp de text 'textField'
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setBorder(BorderFactory.createTitledBorder("Text"));
        textFieldPanel.add(textField);
        add(textFieldPanel);

        // Configuració del Botó Reset
        resetButton = new JButton("Reset");
        // Crear un panell amb FlowLayout per al botó, que centrarà el botó horitzontalment
        JPanel resetButtonPanel = new JPanel();
        resetButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Això centrarà el botó dins el panell
        resetButtonPanel.add(resetButton);
        add(resetButtonPanel);

        
        // Configuració de la Display Label
        configDisplay = new JLabel("Configuracions apareixeran aquí.");
        JPanel displayPanel = new JPanel();
        displayPanel.add(configDisplay);
        add(displayPanel);
    }
}

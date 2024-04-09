package com.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Controller {

    private View view;
    private ActionListener radioListener;

    public Controller(View vBasic) {
        this.view = vBasic;
    }

    // Accions per iniciar el controlador
    public void start() {
        setupActionListeners();
    }

    private void setupActionListeners() {

        // Botons 'radio'
        radioListener = this::controllerRadioListener;
        view.option1.addActionListener(radioListener);
        view.option2.addActionListener(radioListener);
        view.option3.addActionListener(radioListener);

        // Slider
        view.volumeSlider.addChangeListener(this::controllerVolumeSliderListener);

        // Camp de text
        view.textField.getDocument().addDocumentListener(controllerTextFieldListener());

        // Botó de 'reset'
        view.resetButton.addActionListener(this::controllerResetButtonAction);
    }

    private DocumentListener controllerTextFieldListener () {
        return new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { updateConfigDisplay(); }
            public void removeUpdate(DocumentEvent e) { updateConfigDisplay(); }
            public void insertUpdate(DocumentEvent e) { updateConfigDisplay(); }
        };
    }

    private void controllerRadioListener(ActionEvent e) {
        updateConfigDisplay();
    }

    private void controllerVolumeSliderListener(ChangeEvent e) {
        updateConfigDisplay();
    }

    private void controllerResetButtonAction(ActionEvent e) {
        view.option1.setSelected(true);
        view.volumeSlider.setValue(50);
        view.textField.setText("");
        updateConfigDisplay();
    }

    private void updateConfigDisplay() {
        String selectedOption = view.option1.isSelected() ? "Opció 1" : view.option2.isSelected() ? "Opció 2" : "Opció 3";
        int volumeLevel = view.volumeSlider.getValue();
        String text = view.textField.getText();
        view.configDisplay.setText("Opció: " + selectedOption + ", Volum: " + volumeLevel + ", Text: " + text);
    }
}

package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private CardLayout cardLayout;
    private JPanel cards;

    private ViewForm vForm;
    private ViewLoading vLoading;
    private ViewInfo vInfo;

    public Controller(ViewForm vForm, ViewLoading vLoading, ViewInfo vInfo, CardLayout cardLayout, JPanel cards) {
        this.vForm = vForm;
        this.vLoading = vLoading;
        this.vInfo = vInfo;
        this.cardLayout = cardLayout;
        this.cards = cards;
    }

    // Accions per iniciar el controlador
    public void start() {
        setupActionListeners();
    }

    private void setupActionListeners() {
        vForm.sendButton.addActionListener(this::controllerSendButtonAction);
    }

    private void controllerSendButtonAction(ActionEvent e) {
        cardLayout.show(cards, "LOADING");
        final int delay = 150; // Interval de mil·lisegons entre actualitzacions
        final int totalTime = 2500; // Temps total en mil·lisegons
        final int numberOfSteps = totalTime / delay;
        final int[] step = {0};
    
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (step[0] < numberOfSteps) {
                    int progressValue = (int)(((double)step[0] / numberOfSteps) * 100);
                    vLoading.updateProgress(progressValue);
                    step[0]++;
                } else {
                    ((Timer)evt.getSource()).stop();
                    showDataView();
                }
            }
        };
        new Timer(delay, listener).start();
    }

    private void showDataView() {

        String name = vForm.nameField.getText();
        String phoneNumber = vForm.phoneNumberField.getText();
        String age = vForm.ageField.getText();
        String email = vForm.emailField.getText();

        vInfo.setData(name, phoneNumber, age, email);
        cardLayout.show(cards, "INFO");
    }
}

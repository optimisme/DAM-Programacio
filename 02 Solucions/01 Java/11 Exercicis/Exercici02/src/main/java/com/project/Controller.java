package com.project;

import java.awt.event.ActionEvent;

public class Controller {

    private String result = "";
    private Double value0 = 0.0;
    private char currentOperation= ' ';

    private View view;

    public Controller(View vBasic) {
        this.view = vBasic;
    }

    // Accions per iniciar el controlador
    public void start() {
        setupActionListeners();
    }

    private void setupActionListeners() {
        // Definir les funcions que es criden al fer 'click' als botons
        view.bC.addActionListener(this::controllerButtonAction);
        view.bAdd.addActionListener(this::controllerButtonAction);
        view.bSub.addActionListener(this::controllerButtonAction);
        view.bMul.addActionListener(this::controllerButtonAction);
        view.bDiv.addActionListener(this::controllerButtonAction);
        view.bEqual.addActionListener(this::controllerButtonAction);
        view.b0.addActionListener(this::controllerButtonAction);
        view.b1.addActionListener(this::controllerButtonAction);
        view.b2.addActionListener(this::controllerButtonAction);
        view.b3.addActionListener(this::controllerButtonAction);
        view.b4.addActionListener(this::controllerButtonAction);
        view.b5.addActionListener(this::controllerButtonAction);
        view.b6.addActionListener(this::controllerButtonAction);
        view.b7.addActionListener(this::controllerButtonAction);
        view.b8.addActionListener(this::controllerButtonAction);
        view.b9.addActionListener(this::controllerButtonAction);
    }

    public void controllerButtonAction(ActionEvent e) {
        String command = e.getActionCommand();
        runCommand(command);
    }

    public void runCommand(String command) {
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            result += command;
        } else if (command.equals("+") || command.equals("-") || command.equals("x") || command.equals("/")) {
            if (!(currentOperation == ' ') && !result.isEmpty()) {
                // Si ja hi ha una operació pendent, primer calcula aquesta operació
                // abans de posar la nova operació.
                Double value1 = Double.parseDouble(result);
                Double interimResult = calculate(value0, value1, currentOperation);
                value0 = interimResult; // Usa el resultat intermedi com a nou valor inicial
                result = String.valueOf(interimResult); // Mostra el resultat intermedi
            } else if (!result.isEmpty()) {
                // Si no hi ha una operació pendent, simplement prepara per a la nova operació
                value0 = Double.parseDouble(result);
            }
            currentOperation = command.charAt(0);
            result = ""; // Prepara per introduir el segon operand
        } else if (command.equals("=")) {
            if (!(currentOperation == ' ') && !result.isEmpty()) {
                Double value1 = Double.parseDouble(result);
                Double finalResult = calculate(value0, value1, currentOperation);
                result = String.valueOf(finalResult);
                value0 = finalResult; // Permet continuar operant amb el resultat
                currentOperation = ' '; // Reseteja l'operació
            }
        } else if (command.equals("C")) {
            result = "";
            value0 = 0.0;
            currentOperation = ' ';
        }
    
        updateView();
    }
    

    // Realitza la operació
    private Double calculate(Double value0, Double value1, char operation) {
        switch (operation) {
            case '+':
                return value0 + value1;
            case '-':
                return value0 - value1;
            case 'x':
                return value0 * value1;
            case '/':
                if (value1 != 0) return value0 / value1;
                return 0.0;
            default:
                return 0.0;
        }
    }

    // Actualitza les vistes amb les dades del model
    private void updateView() {
        view.result.setText(result);
    }
}

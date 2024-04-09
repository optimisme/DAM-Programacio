package com.project;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;

public class Controller {

    private DefaultListModel<String> model;
    private View view;

    public Controller(View vBasic) {
        this.view = vBasic;
        this.model = new DefaultListModel<>();
        this.view.setListModel(model); // Passa el model a la vista
    }

    // Accions per iniciar el controlador
    public void start() {
        setupActionListeners();
    }

    private void setupActionListeners() {
        view.taskInput.addKeyListener(controllerTaskInputKeyAdapter());
        view.addButton.addActionListener(this::controllerAddButtonAction);
        view.deleteButton.addActionListener(this::controllerDeleteButtonAction);
    }

    private KeyAdapter controllerTaskInputKeyAdapter() {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Comprova si la tecla premuda és Enter
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addTask();
                }
            }
        };
    }

    private void controllerAddButtonAction(ActionEvent e) {
        addTask();
    }

    private void controllerDeleteButtonAction(ActionEvent e) {
        if (!view.taskList.isSelectionEmpty()) {
            model.remove(view.taskList.getSelectedIndex());
        }
    }

    private void addTask() {
        if (!view.taskInput.getText().isEmpty()) {
            model.addElement(view.taskInput.getText());
            view.taskInput.setText("");
        }
    }
}

package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CategoriaController {

    final private int STATUS_LOADING = 0;
    final private int STATUS_ADD = 1;
    final private int STATUS_MODIFY = 2;
    final private int status = STATUS_LOADING;

    private CategoriaModel model;
    private CategoriaView view;

    private ArrayList<String> categories; // Llista tipus 'id-nom'

    CategoriaController(CategoriaModel model, CategoriaView view, CardLayout cardLayout, JPanel cards) {
        this.model = model;
        this.view = view;
        this.categories = new ArrayList<>();
    }

    // Accions per iniciar el controlador
    public void start() {
        setupActionListeners();
        loadData();
        setStatus(STATUS_ADD);
    }

    private void setupActionListeners() {
        view.reloadButton.addActionListener(this::controllerReloadButtonAction);
        view.newCategoryCheckBox.addItemListener(this::controllerNewCategoryCheckBoxAction);
        view.categoryComboBox.addItemListener(this::controllerCategoryComboBoxAction);
    }

    public void loadData() {

        int oldStatus = status;

        // Desactiva tots els elements i mostra el 'Carregant ...'
        setStatus(STATUS_LOADING); 
    
        // Codi que s'executa en un fil paral·lel,
        // per no bloquejar l'aplicació mentre es carreguen les dades
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {

                // Actualitzem la llista de categories a mostrar.
                categories = CategoriaDAO.getAllStrings();
                
                // Si no hi ha cap categoria seleccionada, prenem la primera de la llista.
                String selectedEntry = view.getCategoryComboBoxValue();
                if (selectedEntry.isEmpty() && !categories.isEmpty()) {
                    selectedEntry = categories.get(0);
                }
                
                if (!selectedEntry.isEmpty()) {
                    int id = Integer.parseInt(selectedEntry.split("-")[0]);
                    model = CategoriaDAO.getItem(id);
                }
                
                // Simula espera (per mostrar el "Carregant ...")
                Thread.sleep(1500); 
                
                // El retorn és 'Void' tornem 'null'
                return null; 
            }
            
            @Override
            protected void done() {
                try {
                    // Recollim el 'null' rebut del codi anterior
                    get(); 
                    
                    // Ara que estem de nou al fil d'EDT, és segur actualitzar la UI.
                    if (model != null) {
                        view.displayModelDetails(categories, model);
                    }
                } catch (Exception e) {
                    e.printStackTrace(); 
                }

                // Activa els elements i amaga 'Carregant ...'
                setStatus(oldStatus);
            }
        };
        worker.execute();
    }

    // Mostra o amaga els elements segons l'estat
    private void setStatus(int status) {
        Boolean isLoading = false;

        if (status == STATUS_LOADING) {
            isLoading = true;
        }

        view.loadingLabel.setVisible(isLoading);
        view.newCategoryCheckBox.setEnabled(!isLoading);
        view.categoryComboBox.setEnabled(!isLoading);
        view.addButton.setEnabled(!isLoading && view.newCategoryCheckBox.isSelected());
        view.modifyButton.setEnabled(!isLoading && !view.newCategoryCheckBox.isSelected());
        view.deleteButton.setEnabled(!isLoading && !view.newCategoryCheckBox.isSelected());
        view.categoryNameField.setEnabled(!isLoading);
        view.reloadButton.setEnabled(!isLoading);
        view.switchToProductViewButton.setEnabled(!isLoading);
    }

    // Estableix l'acció del botó 'reload'
    private void controllerReloadButtonAction(ActionEvent e) {
        loadData();
    }

    // Quan s'apreta el 'checkBox' es posa en mode 'afegir' o 'modificar/esborrar'
    private void controllerNewCategoryCheckBoxAction (ItemEvent evt) {
        boolean isSelected = (evt.getStateChange() == ItemEvent.SELECTED);
        if (isSelected) {
            setStatus(STATUS_ADD);
            view.categoryNameField.setText("");
        } else {
            setStatus(STATUS_MODIFY);
            try {
                String categoryText = view.getCategoryComboBoxValue();
                view.categoryNameField.setText(categoryText.split("-")[1]);
            } catch (Exception ex) {
                view.categoryNameField.setText("");
            }
        }
    }

    // Quan es canvia el valor del 'comboBox', es mostra el text sel·leccional al camp 'Nom'
    private void controllerCategoryComboBoxAction (ItemEvent e) {
        String categoryText = view.getCategoryComboBoxValue();
        view.categoryNameField.setText(categoryText.split("-")[1]);
    }
}
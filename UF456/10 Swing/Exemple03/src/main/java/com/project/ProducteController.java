package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ProducteController {
    
    private ProducteModel model;
    private ProducteView view;

    private ArrayList<String> productes; // Llista tipus 'id-nom'

    ProducteController(ProducteModel model, ProducteView view, CardLayout cardLayout, JPanel cards) {
        this.model = model;
        this.view = view;
        this.productes = new ArrayList<>();
    }

    // Accions per iniciar el controlador
    public void start() {
        productes = ProducteDAO.getAllStrings();
        if (!productes.isEmpty()) {
            // Obtenir l'ID del primer producte de la llista
            String firstEntry = productes.get(0);
            int id = Integer.parseInt(firstEntry.split("-")[0]);
    
            // Cridar al DAO per obtenir l'objecte ProducteModel amb aquest ID
            ProducteModel firstModel = ProducteDAO.getItem(id);
            
            if (firstModel != null) {
                model = firstModel;
                view.displayModelDetails(productes, model);
            }
        }
        setupActionListeners();
    }

    private void setupActionListeners() {
    }
}
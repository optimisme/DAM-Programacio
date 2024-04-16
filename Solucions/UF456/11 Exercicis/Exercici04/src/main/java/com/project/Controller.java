package com.project;

import javax.swing.*;

import java.awt.CardLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.List;

public class Controller {

    private DefaultListModel<ReceptaModel> model;
    private int selectedRecepta = -1; // -1 Si no hi ha cap recepta escollida
    private ViewList vList;
    private ViewItem vItem;

    private CardLayout cardLayout;
    private JPanel cards; // Contenidor de CardLayout

    public Controller(ViewList vList, ViewItem vItem, CardLayout cardLayout, JPanel cards) {
        this.vList = vList;
        this.vItem = vItem;

        this.cardLayout = cardLayout;
        this.cards = cards;

        this.model = new DefaultListModel<>();
        this.vList.modelList.setModel(model);
    }

    // Accions per iniciar el controlador
    public void start() {
        loadReceptes();
        setupActionListeners();
    }

    private void setupActionListeners() {
        vList.modelList.addMouseListener(controllerListItemAction());
        vItem.listButton.addActionListener(this::controllerItemEditListButtonAction);
        
    }
    
    private MouseAdapter controllerListItemAction() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // O 2 per doble clic
                    int index = vList.modelList.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        selectedRecepta = index;
                        updateViewItem();
                        cardLayout.show(cards, "ITEM");
                    }
                }
            }
        };
    }

    private void controllerItemEditListButtonAction(ActionEvent e) {
        cardLayout.show(cards, "LIST");
        selectedRecepta = -1;
    }

    private void loadReceptes() {
        UtilsSwingThread.run(
            () -> {
                // Mostra el cartell de càrrega i desactiva els elements interactius
                vList.loadingLabel.setVisible(true);
                vList.modelList.setEnabled(false);
                
                // Simula espera
                Thread.sleep(1500);

                List<ReceptaModel> receptes = ReceptaDAO.getAll();
                model.clear();
                for (ReceptaModel recepta : receptes) {
                    model.addElement(recepta);
                }

                // Amaga el cartell de càrrega i activa els elements interactius
                vList.loadingLabel.setVisible(false);
                vList.modelList.setEnabled(true);
            }
        );
    }

    private void updateViewItem() {
        String htmlContent = "";
        ReceptaModel recepta = model.getElementAt(selectedRecepta);
        List<IngredientModel> ingredients = recepta.getIngredients();
        String htmlIngredients = "";

        for (IngredientModel ingredient:ingredients) {
            htmlIngredients = htmlIngredients + ingredient.getNom() + " (" + ingredient.getQuantitat() + ")" + "<br/>";
        }

        htmlContent = htmlContent + "<html>";
        htmlContent = htmlContent + "<style>";
        htmlContent = htmlContent + "body { font-family: Arial; }";
        htmlContent = htmlContent + ".subtitol { font-size: 10px; color: #558888; }";
        htmlContent = htmlContent + ".nom { font-size: 20px; font-weight: bold; }";
        htmlContent = htmlContent + "</style>";
        htmlContent = htmlContent + "<body>";
        if (recepta.getEsFavorita()) {
            htmlContent = htmlContent + "<div class='subtitol'>" + recepta.getId() + " ♥</div>";
        } else {
            htmlContent = htmlContent + "<div class='subtitol'>" + recepta.getId() + "</div>";
        }
        htmlContent = htmlContent + "<br/>";
        htmlContent = htmlContent + "<div class='nom'>" + recepta.getNom() + "</div>";
        htmlContent = htmlContent + "<br/>";
        htmlContent = htmlContent + "<div class='subtitol'>Temps:</div><div>" + recepta.getTemps() + "</div>";
        htmlContent = htmlContent + "<br/>";
        htmlContent = htmlContent + "<div class='subtitol'>Procediment:</div><div>" + recepta.getProcediment() + "</div>";
        htmlContent = htmlContent + "<br/>";
        htmlContent = htmlContent + "<div class='subtitol'>Ingredients:</div><div>" + htmlIngredients + "</div>";
        htmlContent = htmlContent + "<br/><br/><br/><br/>";
        htmlContent = htmlContent + "</body>";
        htmlContent = htmlContent + "</html>";

        vItem.editorPane.setText(htmlContent);

        // Posar l'scroll a l'inici
        SwingUtilities.invokeLater(() -> {
            vItem.scrollPane.getViewport().setViewPosition(new Point(0, 0));
        });       
    }
}

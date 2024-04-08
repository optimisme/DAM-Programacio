package com.project;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.JTabbedPane;

public class ProducteController {

    final private int STATUS_LOADING = 0;
    final private int STATUS_ADD = 1;
    final private int STATUS_MODIFY = 2;
    private int status = STATUS_ADD;

    private ProducteView view;
    private ArrayList<CategoriaModel> listCategories;
    private ArrayList<ProducteModel> listProducts;
    private JTabbedPane tabbedPane;

    ProducteController(ProducteView view, JTabbedPane tabbedPane) {
        this.view = view;
        this.listProducts = new ArrayList<>();
        this.tabbedPane = tabbedPane;
    }

    // Accions per iniciar el controlador
    public void start() {
        setupActionListeners();
        loadData();
        // No poseu més instruccions aquí,
        // perquè hem obert un fil en paral·lel a 'loadData'
    }

    private void setupActionListeners() {
        view.reloadButton.addActionListener(this::controllerReloadButtonAction);
        view.newItemCheckBox.addItemListener(this::controllerNewItemCheckBoxAction);
        view.itemComboBox.addItemListener(this::controllerItemComboBoxAction);
        view.addButton.addActionListener(this::controllerAddButtonAction);
        view.modifyButton.addActionListener(this::controllerModifyButtonAction);
        view.deleteButton.addActionListener(this::controllerDeleteButtonAction);
    }

    public void loadData() {

        int oldStatus = status;

        // Desactiva tots els elements i mostra el 'Carregant ...'
        setStatus(STATUS_LOADING);

        // Gestionar dades del DAO en una tasca paral·lela
        UtilsSwingThread.run(
            () -> {
                // Actualitzem les llistes
                listCategories = CategoriaDAO.getAll();
                listProducts = ProducteDAO.getAll();

                // Simula espera
                Thread.sleep(1500);

                // Definir el model escollit
                if (!listProducts.isEmpty()) {

                    // Mirar si hi ha alguna producte escollida al 'comboBox'
                    int oldSelected = view.itemComboBox.getSelectedIndex();
                    int newSelected = 0;

                    // Si hi havia un model escollit, cal mirar quina posició té ara a la llista
                    if (oldSelected != -1) {
                        String selectedName = view.itemComboBox.getItemAt(oldSelected);
                        ProducteModel tmp = getListModelFromName(selectedName);
                        if (tmp != null) {
                            newSelected = listProducts.indexOf(tmp);
                        }
                    }
                    
                    // Elimina tots els elements existents al JComboBox
                    view.itemComboBox.removeAllItems();

                    // Afegeix les noves productes rebudes al 'comboBox'
                    for (ProducteModel itemModel : listProducts) {
                        view.itemComboBox.addItem(itemModel.getNom());
                    }

                    // Selecciona el model escollit al 'comboBox'
                    view.itemComboBox.setSelectedIndex(newSelected);
                }

                // Activa els elements i amaga 'Carregant ...'
                setStatus(oldStatus);
                fillFormData();
            }
        );
        // No posar més instruccions després del UtilsSwingThread.run
    }

    // Mostra o amaga els elements segons l'estat
    private void setStatus(int newStatus) {
        Boolean isLoading = false;

        status = newStatus;
        if (status == STATUS_LOADING) {
            isLoading = true;
        } else if (status == STATUS_ADD) {
            view.newItemCheckBox.setSelected(true);
        } else if (status == STATUS_MODIFY) {
            view.newItemCheckBox.setSelected(false);
        }

        tabbedPane.setEnabled(!isLoading);
        view.reloadButton.setEnabled(!isLoading);
        view.loadingLabel.setVisible(isLoading);
        view.newItemCheckBox.setEnabled(!isLoading);
        view.itemComboBox.setEnabled(!isLoading && status == STATUS_MODIFY);
        view.itemNameField.setEnabled(!isLoading);
        view.itemDescriptionField.setEnabled(!isLoading);
        view.itemPriceField.setEnabled(!isLoading);
        view.addButton.setEnabled(!isLoading && status == STATUS_ADD);
        view.modifyButton.setEnabled(!isLoading && status == STATUS_MODIFY);
        view.deleteButton.setEnabled(!isLoading && status == STATUS_MODIFY);
    }

    // Estableix l'acció del botó 'reload'
    private void controllerReloadButtonAction(ActionEvent e) {
        loadData();
        // 'loadData' crida a 'UtilsSwingThread.run'
        // No posar més instruccions després del UtilsSwingThread.run
    }

    // Quan s'apreta el 'checkBox' es posa en mode 'afegir' o 'modificar/esborrar'
    private void controllerNewItemCheckBoxAction (ItemEvent evt) {
        boolean isSelected = (evt.getStateChange() == ItemEvent.SELECTED);
        if (isSelected) {
            setStatus(STATUS_ADD);
            view.itemComboBox.setEnabled(false);
        } else {
            setStatus(STATUS_MODIFY);
            view.itemComboBox.setEnabled(true);
        }
        fillFormData();
    }

    // Quan es canvia el valor del 'comboBox', es mostra el text sel·leccional al camp 'Nom'
    private void controllerItemComboBoxAction (ItemEvent e) {
        fillFormData();
    }

    // Estableix l'acció del botó 'afegir'
    private void controllerAddButtonAction(ActionEvent e) {
        String nom = view.itemNameField.getText();
        String descripcio = view.itemDescriptionField.getText();
        double preu = Double.parseDouble(view.itemPriceField.getText());
        String selectedCategoryName = (String) view.categoryComboBox.getSelectedItem();
        int categoryId = getCategoryIDFromName(selectedCategoryName);
        ProducteModel newModel = new ProducteModel(nom, descripcio, preu, categoryId);

        setStatus(STATUS_MODIFY);

        // Gestionar dades del DAO en una tasca paral·lela
        UtilsSwingThread.run(
            () -> {
                ProducteDAO.addItem(newModel);

                // Actualitzar també el comboBox amb el nou nom 
                // (perquè al carregar les dades quedi seleccionat)
                int index = view.itemComboBox.getItemCount() - 1;
                view.itemComboBox.insertItemAt(nom, index);
                view.itemComboBox.setSelectedIndex(index);
                view.itemNameField.setText(nom);
        
                // Actualitzar les dades normalment
                loadData();
            }
        );
        // No posar més instruccions després del UtilsSwingThread.run
    }

    // Estableix l'acció del botó 'modificar'
    private void controllerModifyButtonAction(ActionEvent e) {
        String nom = view.itemNameField.getText();
        String descripcio = view.itemDescriptionField.getText();
        double preu = Double.parseDouble(view.itemPriceField.getText());
        String selectedCategoryName = (String) view.categoryComboBox.getSelectedItem();
        int categoryId = getCategoryIDFromName(selectedCategoryName);
        int index = view.itemComboBox.getSelectedIndex();

        // Crear un producte amb les dades modificades
        ProducteModel modifiedModel = getModelFromComboBoxIndex(index);
        modifiedModel.setNom(nom);
        modifiedModel.setDescripcio(descripcio);
        modifiedModel.setPreu(preu);
        modifiedModel.setCategoriaId(categoryId);

        // Gestionar dades del DAO en una tasca paral·lela
        UtilsSwingThread.run(
            () -> {
                ProducteDAO.updateItem(modifiedModel);

                // Actualitzar també el comboBox amb el nou nom 
                // (perquè al carregar les dades quedi seleccionat)
                view.itemComboBox.removeItemAt(index);
                view.itemComboBox.insertItemAt(nom, index);
                view.itemComboBox.setSelectedIndex(index);
        
                // Actualitzar les dades normalment
                loadData();
            }
        );
        // No posar més instruccions després del UtilsSwingThread.run
    }

    // Estableix l'acció del botó 'borrar'
    private void controllerDeleteButtonAction(ActionEvent e) {
        int index = view.itemComboBox.getSelectedIndex();
        ProducteModel modifiedModel = getModelFromComboBoxIndex(index);

        // Gestionar dades del DAO en una tasca paral·lela
        UtilsSwingThread.run(
            () -> {
                ProducteDAO.deleteItem(modifiedModel.getId());

                // Actualitzar les dades normalment
                loadData();
            }
        );
        // No posar més instruccions després del UtilsSwingThread.run
    }

    private ProducteModel getModelFromComboBoxIndex(int index) {
        String comboBoxText = view.itemComboBox.getItemAt(index);
        return getListModelFromName(comboBoxText);
    }

    private ProducteModel getListModelFromName(String searchName) {
        ProducteModel rst = null;
        for (int i=0; i<listProducts.size(); i++) {
            String listName = listProducts.get(i).getNom();
            if (searchName.compareTo(listName) == 0) {
                rst = listProducts.get(i);
                break;
            }
        }
        return rst;
    }

    // Emplena els camps del formulari segons la sel·lecció de la comboBox
    private void fillFormData () {
        // Mostrar les categories a la 'comboBox' de categories
        view.categoryComboBox.removeAllItems();
        for (CategoriaModel itemModel : listCategories) {
            view.categoryComboBox.addItem(itemModel.getNom());
        }

        int selectedEntry = view.itemComboBox.getSelectedIndex();
        if (selectedEntry != -1 && status == STATUS_MODIFY) {
            ProducteModel selectedItem = listProducts.get(selectedEntry);
            view.itemNameField.setText(selectedItem.getNom());
            view.itemDescriptionField.setText(selectedItem.getDescripcio());
            view.itemPriceField.setValue(selectedItem.getPreu());

            // Buscar l'index d'aquest producte al 'comboBox' 
            // de categories a partir del nom de producte
            int categoryId = selectedItem.getCategoriaId();
            int categoryIndex = -1;
            for (int i = 0; i < listCategories.size(); i++) {
                if (listCategories.get(i).getId() == categoryId) {
                    categoryIndex = i;
                    break;
                }
            }
                        
            // Seleccionar l'index de categoria d'aquest producte
            view.categoryComboBox.setSelectedIndex(categoryIndex);
        } else {
            view.itemNameField.setText("");
            view.itemDescriptionField.setText("");
            view.itemPriceField.setValue(0);
        }
    }

    // Obté un identificador de producte a partir del nom
    private int getCategoryIDFromName(String categoryName) {
        for (CategoriaModel category : listCategories) {
            if (category.getNom().equals(categoryName)) {
                return category.getId();
            }
        }
        return 0; // Retorna un valor per defecte si no es troba la categoria
    }
}
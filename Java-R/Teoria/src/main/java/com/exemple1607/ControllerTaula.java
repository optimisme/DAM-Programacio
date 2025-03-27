package com.exemple1607;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

public class ControllerTaula implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TableView<HashMap<String, Object>> table;

    @FXML
    private Label label;

    // Called when the FXML file is loaded
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Acció que s'executa quan el 'coiceBox' canvia de valor
        choiceBox.setOnAction((event) -> {
            String selectedTable = choiceBox.getSelectionModel().getSelectedItem();
            // La selecció pot ser 'null' quan es reconstrueix el 'choiceBox'
            if (selectedTable != null) {
                setTable(selectedTable);
            }
        });
    }

    public void loadTables(String selectedTable, int selectedRow) {
        // Obtenir el nom de les taules de la base de dades
        AppData db = AppData.getInstance();
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name <> 'sqlite_sequence'";
        ArrayList<HashMap<String, Object>> rows = db.query(sql);
        
        // Posar els noms de les taules a 'tableNames'
        ArrayList<String> tableNames = new ArrayList<>();
        for (HashMap<String, Object> row : rows) {
            tableNames.add((String) row.get("name"));
        }

        // Posar els noms de les taules a la 'choiceBox'
        choiceBox.getItems().clear();
        choiceBox.getItems().addAll(tableNames);

        if (selectedTable.equalsIgnoreCase("") == false && tableNames.indexOf(selectedTable) != -1) {
            // Escollir la taula 'selectedTable'
            choiceBox.getSelectionModel().select(selectedTable);
            setTable(selectedTable);

            // Escollir la fila 
            if (selectedRow >= 0 && selectedRow < table.getItems().size()) {
                table.getSelectionModel().select(selectedRow);
            }
        } else {
            // Escollir la primera taula
            choiceBox.getSelectionModel().selectFirst();
            setTable(tableNames.get(0));
        }
    }
        
    @FXML
    private void setTable(String tableName) {

        // Vigilar que hi ha un 'tableName'
        if (tableName == null || tableName.trim().isEmpty()) {
            System.out.println("La taula seleccionada és null o buida.");
            return;
        }

        // Obtenir els continguts de la taula
        AppData db = AppData.getInstance();
        String sql = "SELECT * FROM " + tableName;
        ArrayList<HashMap<String, Object>> rows = db.query(sql);

        // Esborrar les columnes i files actuals de la taula
        table.getColumns().clear();
        table.getItems().clear();

        if (!rows.isEmpty()) {

            // Determinar els noms de les columnes
            HashMap<String, Object> firstRow = rows.get(0);
            for (String key : firstRow.keySet()) {
                TableColumn<HashMap<String, Object>, Object> column = new TableColumn<>(key);
                column.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().get(key)));
                table.getColumns().add(column);
            }

            // Ajustar l'amplada de cada columna de manera equitativa
            table.getColumns().forEach(column ->
                column.prefWidthProperty().bind(table.widthProperty().divide(table.getColumns().size()))
            );
        }

        // Assignar les dades a la taula
        ObservableList<HashMap<String, Object>> data = FXCollections.observableArrayList(rows);
        table.setItems(data);

        // Afegir listener per detectar la selecció d'una fila
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            setLabelInfo(newSelection);
        });
    }
    
    @FXML
    public void reload(ActionEvent event) {
        String selectedTable = choiceBox.getSelectionModel().getSelectedItem();
        int selectedRow = table.getSelectionModel().getSelectedIndex();

        loadTables(selectedTable, selectedRow);
    }

    // Funció que actualitza el label amb les dades de la fila seleccionada o mostra "Cap fila escollida"
    private void setLabelInfo(HashMap<String, Object> rowData) {
        if (rowData == null) {
            label.setText("Cap fila escollida");
        } else {
            StringBuilder info = new StringBuilder();
            rowData.forEach((key, value) -> info.append(key).append(": ").append(value).append("  "));
            label.setText(info.toString());
        }
    }
}
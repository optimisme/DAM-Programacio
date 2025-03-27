package com.exemple1607;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

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

            // Escollir la fila 'selectedRow'
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

        // Fer la taula editable
        makeTableEditable(table, row -> {
            String selectedTable = choiceBox.getSelectionModel().getSelectedItem();
            boolean modified = setModifiedRow(selectedTable, row);
            if (modified) {
                setLabelInfo(row);
            }
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

    /** Funció que actualitza la base de dades quan es modifica una fila
     *  @param tableName nom de la taula
     *  @param rowData dades de la fila a actualitzar
     *  @return true si s'ha fet el canvi
     *  */ 
    private boolean setModifiedRow(String tableName, HashMap<String, Object> rowData) {
        
        if (rowData == null || tableName == null) return false;
    
        // Definir el valor 'idValue' segons la clau primària de la taula
        String idKey = "id";
        if (tableName.equals("Llibres")) {
            idKey = "id_llibre";
        }

        Object idValue = rowData.get(idKey);
        if (!(idValue instanceof Integer)) {
            System.out.println("No es pot actualitzar: no hi ha clau primària '" + idKey + "'");
            return false;
        }
    
        StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET ");
        ArrayList<String> assignments = new ArrayList<>();
    
        for (String key : rowData.keySet()) {
            if (key.equals(idKey)) continue; 
    
            Object value = rowData.get(key);
            if (value == null) {
                assignments.add(key + " = NULL");
            } else if (value instanceof Number) {
                assignments.add(key + " = " + value);
            } else {
                assignments.add(key + " = '" + value.toString().replace("'", "''") + "'");
            }
        }
    
        sql.append(String.join(", ", assignments));
        sql.append(" WHERE ").append(idKey).append(" = ").append(idValue);
    
        AppData.getInstance().update(sql.toString());
        System.out.println("Actualitzat: " + sql);  
        
        return true;
    }
    
    // Transforma una taula en editable
    public static void makeTableEditable(TableView<HashMap<String, Object>> table, Consumer<HashMap<String, Object>> onEdit) {
        table.setEditable(true);

        if (table.getItems().isEmpty()) return;

        for (TableColumn<HashMap<String, Object>, ?> tc : table.getColumns()) {
            @SuppressWarnings("unchecked")
            TableColumn<HashMap<String, Object>, Object> col = (TableColumn<HashMap<String, Object>, Object>) tc;
            String key = col.getText();
            Object sampleValue = table.getItems().get(0).get(key);

            StringConverter<Object> converter;

            if (sampleValue instanceof Integer) {
                converter = new StringConverter<>() {
                    public String toString(Object o) { return o == null ? "" : o.toString(); }
                    public Object fromString(String s) {
                        try { return Integer.parseInt(s); } catch (Exception e) { return 0; }
                    }
                };
            } else if (sampleValue instanceof Double) {
                converter = new StringConverter<>() {
                    public String toString(Object o) { return o == null ? "" : o.toString(); }
                    public Object fromString(String s) {
                        try { return Double.parseDouble(s); } catch (Exception e) { return 0.0; }
                    }
                };
            } else {
                converter = new StringConverter<>() {
                    public String toString(Object o) { return o == null ? "" : o.toString(); }
                    public Object fromString(String s) { return s; }
                };
            }

            col.setCellFactory(TextFieldTableCell.forTableColumn(converter));
            col.setOnEditCommit(e -> {
                e.getRowValue().put(key, e.getNewValue());
                onEdit.accept(e.getRowValue());
            });
        }
    }
}
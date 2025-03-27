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

    /**
     * Llista les taules de la base de dades al 'choiceBox'
     * @param selectedTable taula que s'ha d'escollir (si existeix), o "" per la primera taula
     * @param selectedRow fila que s'ha de marcar (si existeix), o -1 si no se'n selecciona cap
     */
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
        
    /**
     * Mostra una taula a la TableView 'table'
     * @param tableName nom de la taula a mostrar
     */
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

            // Definir el nom de la clau primària, segons la taula
            String keyName = "id";
            if (tableName.equals("Llibres")) {
                keyName = "id_llibre";
            }
            boolean modified = setModifiedRow(selectedTable, keyName, row);
            if (modified) {
                setLabelInfo(row);
            }
        });
    }
    
    /**
     * Carrega de nou les dades de la base de dades
     * si hi ha una taula o fila sel·leccionades, intenta mantenir-les
     * @param event
     */
    @FXML
    public void reload(ActionEvent event) {
        String selectedTable = choiceBox.getSelectionModel().getSelectedItem();
        int selectedRow = table.getSelectionModel().getSelectedIndex();

        loadTables(selectedTable, selectedRow);
    }

    /**
     * Mostra la informació de la fila sel·lecionada al labe inferior
     * Si no hi ha cap fila escollida mostra "Cap fila escollida"
     * @param rowData
     */
    private void setLabelInfo(HashMap<String, Object> rowData) {
        if (rowData == null) {
            label.setText("Cap fila escollida");
        } else {
            StringBuilder info = new StringBuilder();
            rowData.forEach((key, value) -> info.append(key).append(": ").append(value).append("  "));
            label.setText(info.toString());
        }
    }

    /** 
     * Actualitza la base de dades quan es modifica una fila
     * @param tableName nom de la taula
     * @param rowData dades de la fila a actualitzar
     * @return true si s'ha fet el canvi
     */ 
    private boolean setModifiedRow(String tableName, String keyName, HashMap<String, Object> rowData) {

        if (rowData == null || tableName == null) return false;

        Object idValue = rowData.get(keyName);
        if (!(idValue instanceof Integer)) {
            System.out.println("No es pot actualitzar: no hi ha clau primària '" + keyName + "'");
            return false;
        }
    
        StringBuilder setClause = new StringBuilder();
        for (String key : rowData.keySet()) {
            if (key.equals(keyName)) continue;
    
            Object value = rowData.get(key);
            if (setClause.length() > 0) setClause.append(", ");
    
            // Adaptar la query a "sqlite"
            if (value == null) {
                setClause.append(String.format("%s = NULL", key));
            } else if (value instanceof Number) {
                setClause.append(String.format("%s = %s", key, value));
            } else {
                String escaped = value.toString().replace("'", "''");
                setClause.append(String.format("%s = '%s'", key, escaped));
            }
        }
    
        String sql = String.format("UPDATE %s SET %s WHERE %s = %s", tableName, setClause, keyName, idValue);
        AppData.getInstance().update(sql);
        System.out.println("Actualitzat: " + sql);
    
        return true;
    }
        
    /** 
     * Transforma una taula en editable
     * @param table, taula que ha de ser editable
     * @param onEdit, mètode a executar quan s'ha editat una fila
     */ 
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
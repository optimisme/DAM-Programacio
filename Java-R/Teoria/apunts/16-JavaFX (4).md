<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<br/>

# JavaFX (5)

Els elements d'una aplicació *JavaFX* no només es poden afegir a partir d'arxius *.fxml*, també es poden afegir programant codi *Java*

## Funció d'inici de vista

En un controlador, la funció **'initialize'** es crida quan s'inicia una vista, **no** és obligatòri sobre escriure-la, però és útil si necessitem executar codi quan es carrega l'arxiu *.fxml*.

Aquesta funció es pot aprofitar per definir l'estat inicial dels elements d'una vista, o per iniciar les dades d'un formulari:

```java
     @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Label choiceLabel;

    String weekdays[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };

    // Called when the FXML file is loaded
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // 
        choiceBox.getItems().addAll(weekdays);
        choiceBox.setValue(weekdays[0]);
        choiceBox.setOnAction((event) -> {
            choiceLabel.setText(choiceBox.getSelectionModel().getSelectedItem());
        });
    }
```

## Exemple 1605

En aquest exemple es pot veure com:

- La funció **'initialize'** defineix les opciós del *choiceBox* al iniciar la vista.
- Les funcions **'setWeekdays'** i **'setMonths'** canvien les opcions disponibles del *choiceBox*.

## Llistes dinàmiques

Fent servir *'Subvistes'* com a plantilles, es poden generar llistes d'elements de manera programàtica (programant al codi):

## Exemple 1606

En aquest exemple es llegeix la informació de l'arxiu **'animals.json'** al iniciar-se la vista:

```java
@Override
    
```


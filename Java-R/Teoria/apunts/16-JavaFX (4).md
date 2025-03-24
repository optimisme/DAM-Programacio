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

Alguns elements de *JavaFX* poden tenir múltiples elements fills, com per exemple *VBox*, *HBox*, ...

Aquests elements tenen funcions per esborrar o afegir fills programàticament:

```xml
<!-- Exemple d'element amb múltiples fills -->
<VBox fx:id="yPane" />
```

```java
// Esborrar tots els fills d'un element
yPane.getChildren().clear();

// Afegir un 'label' fill a un element
Label label = new Label("hola");
yPane.getChildren().add(label);
```

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

Quan tenim una informació en forma de llista, no podem saber quants elements haurem de mostrar.

Així que cal generar-los de manera dinàmica.

## Exemple 1606

En aquest exemple es llegeix la informació de l'arxiu **'/assets/exemple1606Animals.json'** al iniciar-se la vista gràcies a la funció **'initialitze'**:

```java
    // Called when the FXML file is loaded
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Obtenir la informació dels animals
            URL jsonFileURL = getClass().getResource("/assets/exemple1606Animals.json");
            Path path = Paths.get(jsonFileURL.toURI());
            String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
            jsonInfo = new JSONArray(content);

            // Actualitza la UI amb els valors inicials de les estacions
            setSeasons(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

Quan es vol mostrar la llista amb la informació de les estacions de l'any, s'agafa la informació de la variable **seasons** i es generen les etiquetes dinàmicament.

```java
    private String seasons[] = { "Summer", "Autumn", "Winter", "Spring" };

    @FXML
    private void setSeasons(ActionEvent event) {
        // Esborrar la llista anterior
        yPane.getChildren().clear();

        // Generar la nova llista
        for (String name : seasons) {
            Label label = new Label(name);
            label.setStyle("-fx-border-color: red;");
            yPane.getChildren().add(label);
        }
    }
```

Quan es vol mostrar la llista amb informació d'animals, enlloc d'una simple etiqueta es fa servir una *subVista* a partir de **'exemple1606Item.fxml'**.

Al controlador de item definim les funcions per "settejar" els valors de cada element:

```java
 public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setSubtitle(String subtitle) {
        this.subtitle.setText(subtitle);
    }

    public void setImatge(String imagePath) {
        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
            this.img.setImage(image);
        } catch (NullPointerException e) {
            System.err.println("Error loading image asset: " + imagePath);
            e.printStackTrace();
        }
    }

    public void setCircleColor(String color) {
        circle.setStyle("-fx-fill: " + color);
    }
```

Així, gràcies al controlador de item, es posen les dades de cada ítem un a un, i es generen tants items com són necessaris segons la llista:

```java
    @FXML
    private void setAnimals(ActionEvent event) throws Exception {

        // Obtenir el recurs del template .fxml
        URL resource = this.getClass().getResource("/assets/exemple1606Item.fxml");

        // Netejar el contingut existent
        yPane.getChildren().clear();

        // Iterar sobre els elements del JSONArray 'jsonInfo' (ja carregat a initialize)
        for (int i = 0; i < jsonInfo.length(); i++) {
            // Obtenir l'objecte JSON individual (season)
            JSONObject season = jsonInfo.getJSONObject(i);

            // Extreure la informació necessària del JSON
            String category = season.getString("category");
            String name = season.getString("animal");
            String color = season.getString("color");

            // Carregar el template de 'exemple1606Item.fxml'
            FXMLLoader loader = new FXMLLoader(resource);
            Parent itemTemplate = loader.load();
            ControllerItem itemController = loader.getController();

            // Assignar els valors als controls del template
            itemController.setTitle(name);
            itemController.setSubtitle(category);
            itemController.setImatge("/assets/images/" + name.toLowerCase() + ".png");
            itemController.setCircleColor(color);

            // Afegir el nou element a 'yPane'
            yPane.getChildren().add(itemTemplate);
        }
    }
```


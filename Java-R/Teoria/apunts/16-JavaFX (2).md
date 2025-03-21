<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<br/>

# JavaFX (2)

## Scene Builder

Scene Builder permet compondre aplicacions *JavaFX* de manera visual. 

## Posicionament (containers de layout)

La manera d'organitzar els elements (widgets) de la interfície depèn dels propis widgets i es fa en forma d'arbre.

Els widgets que permeten tenir altres widgets dins, tenen *"normes"* de posicionament.

- **[HBox](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/HBox.html) i [VBox](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/VBox.html)**: Posisionen els widgets fills en vertical o hortizontal. 

     **Molt útils** per espaiar i centrar elements, encara que tinguins dins un únic element.

     **A més** afegeixen la opció *Hgrow* o *Vgrow* al layout dels fills, el què permet espaiar-los.

- **[AnchorPane](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/AnchorPane.html)**: Permet posar els widgets fills a una distància dels costats propis. 

- **[ScrollPane](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ScrollPane.html)**: Permet afegir un "scroll" per mostrar els widgets fills que queden per fora de l'espai del propi widget *(fora del viewport)*.

## Controls

Els contols permeten interactuar amb l'aplicació.

- **[Button](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html)**: És un botó 

- **[Label](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html)**: Mostra un petit text o etiqueta

- **[TextField](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextField.html)**: Mostra un camp d'entrada de text

- **[ImageView](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html)**: Permet mostrar imatges a l'aplicació JavaFX

## File Chooser

El *File Chooser* permet escollir un arxiu del sistema d'arxius.

Aquest Objecte permet:

- Escollir arxius en mode **lectura**
- Escollir arxius en mode **escriptura**

## Exemple 1602

Aquest exemple mostra com escollir arxius del sistema d'arxius:

```java
    // Carrega un arxiu .json a un quadre de text tipus "TextArea"
    @FXML
    private void actionLoadJSON() {
        Stage stage = (Stage) buttonLoadJSON.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arxius JSON", "*.json"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            try {
                String content = new String(Files.readAllBytes(selectedFile.toPath()));
                txt.setText(content); // "content" és el text que s'ha llegit de l'arxiu
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Guarda la informació d'un quadre de text tipus "TextArea" en un arxiu ".json"
    @FXML
    private void actionSaveJSON() {
        Stage stage = (Stage) buttonSaveJSON.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arxius JSON", "*.json"));
        File selectedFile = fileChooser.showSaveDialog(stage);
        if (selectedFile != null) {
            try {
                String jsonData = txt.getText(); // "txt.getText()" és el text .json que es vol guardar
                if (jsonData.substring(0, 1).equalsIgnoreCase("[")) {
                    JSONArray json = new JSONArray(jsonData);
                    Files.write(selectedFile.toPath(), json.toString(4).getBytes());
                } else {
                    JSONObject json = new JSONObject(jsonData);
                    Files.write(selectedFile.toPath(), json.toString(4).getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Carrega una imatge del sistema en un element tipus "ImageView"
    @FXML
    private void actionLoadImage() {
        Stage stage = (Stage) buttonLoadImage.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imatges", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            try {
                Image image = new Image(selectedFile.toURI().toString());
                img.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
```
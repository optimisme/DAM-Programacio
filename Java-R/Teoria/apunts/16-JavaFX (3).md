<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<br/>

# JavaFX (3)

## Vistes

A **JavaFX** la gestió de Vistes amb JavaFX cal fer-la des del codi manualment. Aquesta gestió no és complicada però es pot fer pesada.

La classe **'UtilsViews.java'** permet gestionar un conjunt de vistes de manera senzilla.

## Exemple 1603

L'exemple '0101' fa servir *'UtilsViews'* per mostrar el canvi entre diferents vistes.

Al main, s'afegeixen les vistes a l'escena. Al afegir cada vista se li dóna un identificador (View0, View1, ...) per poder-les referenciar més endavant:

```java
UtilsViews.parentContainer.setStyle("-fx-font: 14 arial;");
UtilsViews.addView(getClass(), "View0", "/assets/exemple1603View0.fxml");
UtilsViews.addView(getClass(), "View1", "/assets/exemple1603View1.fxml");
UtilsViews.addView(getClass(), "View2", "/assets/exemple1603View2.fxml");

Scene scene = new Scene(UtilsViews.parentContainer);
```

Com que UtilsViews és té atributs i funcions estàtiques, es poden cridar des de qualsevol controlador. Per exemple, des de *Controller0':

```java
@FXML
private void toView2(ActionEvent event) {
    UtilsViews.setView("View2");
}

@FXML
private void animateToView0(ActionEvent event) {
    UtilsViews.setViewAnimating("View0");
}
```

En el codi anterior:

- **UtilsViews.setView("View2")** canvia a la vista 'View2' sense animació
- **UtilsViews.setViewAnimating("View0")** canvia de vista 'View0' amb animació

<center><img src="./assets/exemple1603.gif" style="max-width: 90%; max-height: 350px;" alt="">
<br/></center>
<br/>

Amb **UtilsViews*, podem obtenir el controlador d'una vista a partir del seu identificador:

```java
// Cal fer cast/transformar al tipus del controlador que s'obté (nom de l'objecte)
Controller0 ctrl0 = (Controller0) UtilsViews.getController("View0");
```

## Subvistes

A vegades ens interessa mostrar una vista dins d'una altra vista, això és útil per poder fer plantilles que mostren informació.

## Exemple 1604

Per carregar una subvista, també obtenim el seu controlador:
```java
    URL resource = this.getClass().getResource("/assets/exemple1604Item.fxml");
    FXMLLoader loader = new FXMLLoader(resource);
    Parent itemPane = loader.load();
    ControllerItem itemController = loader.getController();
```

Al controlador de la *subvista* hem de definir les funcions que *emplenen/modifiquen* els seus camps.
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

Finalment, fem servir el controlador i els setters de la subvista per mostrar-la al nostre element amb les dades que ens interessa.

```java
private void setDades(String animal) {

    try {
        // Obtenir el recurs del template .fxml
        URL resource = this.getClass().getResource("/assets/exemple1604Item.fxml");
        FXMLLoader loader = new FXMLLoader(resource);
        Parent itemPane = loader.load();
        ControllerItem itemController = loader.getController();

        // Assignar els valors al nou element (plantilla)
        switch (animal) {
            case "Cat":
                itemController.setTitle("Cat");
                itemController.setSubtitle("This is 0");
                itemController.setImatge("/assets/images/cat.png");
                itemController.setCircleColor("red");
                break;
            case "Horse":
                itemController.setTitle("Horse");
                itemController.setSubtitle("This is 1");
                itemController.setImatge("/assets/images/horse.png");
                itemController.setCircleColor("green");
                break;
            default:
                itemController.setTitle("Turtle");
                itemController.setSubtitle("This is 2");
                itemController.setImatge("/assets/images/turtle.png");
                itemController.setCircleColor("blue");
                break;
        }

        // Netejar el contingut existent
        itemBox.getChildren().clear();

        // Afegir el nou element a l'espai que l'hi hem reservat (itemBox)
        itemBox.getChildren().add(itemPane);

    } catch (IOException e) {
        e.printStackTrace();
    }
    }
```

## Exercici 1603

Fes un programa JavaFX amb dues vistes:

**Vista 0**: Ha de mostrar la fitxa amb les dades d'un personatge reconegut. Carregat a partir d'un arxiu *.json*. Ha de contenir:

- Nom
- Activitat
- Data de naixament
- Text explicatiu
- Foto

**Vista 1**: Ha de mostar un formulari per modificar els camps anteriors i guardar les noves dades a l'arxiu *.json*

Prepara almenys tres arxius *.json* que es poden llegir/escriure amb l'aplicació anterior:

- **./data/music.json** amb la informació d'un músic
- **./data/cientific.json** amb la informació d'un científic
- **./data/esportista.json** amb la informació d'un esportista

Comprova que els tres arxius *.json* es poden obrir i modificar amb l'aplicació.

Guarda les imatges a la carpeta: **"src/main/resources/assets/exercici1603/"**
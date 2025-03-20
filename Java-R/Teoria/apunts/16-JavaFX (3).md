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

## Exemple 1602

L'exemple '0101' fa servir *'UtilsViews'* per mostrar el canvi entre diferents vistes.

Al main, s'afegeixen les vistes a l'escena. Al afegir cada vista se li dóna un identificador (View0, View1, ...) per poder-les referenciar més endavant:

```java
UtilsViews.parentContainer.setStyle("-fx-font: 14 arial;");
UtilsViews.addView(getClass(), "View0", "/assets/exemple1602View0.fxml");
UtilsViews.addView(getClass(), "View1", "/assets/exemple1602View1.fxml");
UtilsViews.addView(getClass(), "View2", "/assets/exemple1602View2.fxml");

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

<center><img src="./assets/exemple1602.gif" style="max-width: 90%; max-height: 350px;" alt="">
<br/></center>
<br/>

Amb **UtilsViews*, podem obtenir el controlador d'una vista a partir del seu identificador:

```java
// Cal fer cast/transformar al tipus del controlador que s'obté (nom de l'objecte)
Controller0 ctrl0 = (Controller0) UtilsViews.getController("View0");
```

## Subvistes

A vegades ens interessa mostrar una vista dins d'una altra vista, això és útil per poder fer plantilles que mostren informació.

## Exemple 1603

Per carregar una subvista, també obtenim el seu controlador:
```java
    URL resource = this.getClass().getResource("/assets/exemple1603Item.fxml");
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
        URL resource = this.getClass().getResource("/assets/exemple1603Item.fxml");
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



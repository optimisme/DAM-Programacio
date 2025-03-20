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

- **[AnchorPane](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/AnchorPane.html)**: Permet posar els widgets fills a una distància dels costats propis. 

- **[HBox](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/HBox.html) i [VBox](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/VBox.html)**: Posisionen els widgets fills en vertical o hortizontal

- **[ScrollPane](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ScrollPane.html)**: Permet afegir un "scroll" per mostrar els widgets fills que queden per fora de l'espai del propi widget *(fora del viewport)*.

## Controls

Els contols permeten interactuar amb l'aplicació.

- **[Button](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html)**: És un botó 

- **[Label](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html)**: Mostra un petit text o etiqueta

- **[TextField](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextField.html)**: Mostra un camp d'entrada de text

- **[ImageView](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html)**: Permet mostrar imatges a l'aplicació JavaFX


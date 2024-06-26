<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 1

Fent servir SWING bàsic i el model MVC, fes una aplicació per gestionar una llista de tasques com la de la imatge.

* Quan s'apreta el boto 'Afegeix' el text escrit s'afegeix a la llista

* Quan s'apreta return al camp de text, també s'afegeix a la llista

* L'element seleccionat de la llista s'ha de poder esborrar

* Organitza la vista amb un layout tipus 'BorderLayout' on:

* S'hi hi ha una llista llarga ha d'apareixer un scroll, amb [JScrollPane](https://docs.oracle.com/javase/8/docs/api/javax/swing/JScrollPane.html)

Aleshores, pel què fa al layout:

- El formulari d'entrada i el botó 'Afegeix' estàn al 'NORTH'
- La llista de tasques està al 'CENTER'
- El botó 'Elimina' està al 'SOUTH'

Per fer la llista et caldrà fer servir els components [JList](https://docs.oracle.com/javase/8/docs/api/javax/swing/JList.html). Cal que defineixis el model com a atribut del 'Controller' i que sigui del tipus [DefaultListModel](https://docs.oracle.com/javase/8/docs/api/javax/swing/DefaultListModel.html) així: 'DefaultListModel<String> model'. *(Veuràs que fer canvis al model, actualitza automàticament el component perquè queden enllaçats.)*

Mira la documentació als enllaços anteriors.

<center><img src="./captura.gif" height="250" alt="Calculadora" style="max-height: 250px;"></center>


Per tal que passi el test, cal que:

A l'objecte 'MainWindow' la vista i el controlador han de ser públics:

```java
    public View view;
    public Controller controller;
```

Al 'View.java' hi hagi els següents elements:

```java
    JTextField taskInput;
    JButton addButton;
    JButton deleteButton;
    JList<String> taskList;
    JScrollPane scrollPane;
```
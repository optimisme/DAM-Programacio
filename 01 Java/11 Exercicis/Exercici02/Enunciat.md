<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 2

Fent servir SWING i el model MVC, fes una calculadora com la imatge.

* El menú 'Arxiu' ha de tenir la opció 'Sortir'
* El menú 'Operacions' ha de tenir les opcions 'Netejar' (equival a C) i 'Igual'

**Òbivament ha de funcionar!**

Cal fer una 'View.java' i un 'Controller.java'

* A la view, la organització dels botons s'ha de fer amb una GridLayout

* Al controlador s'obté la comanda a fer servir a partir del text de cada botó així:

```java
    public void controllerButtonAction(ActionEvent e) {
        String command = e.getActionCommand(); // Això retorna el text del botó
        runCommand(command);
    }
```

El funcionament és el següent:

- La calcula té un valor, una operació i un resultat.

- Primer s'emplena el primer valor, després s'escull la operació i finalment s'opera amb el segon valor. 

- Aleshores es pot tornar a escollir una operació o el simbol = per obtenir el resultat.

- Si s'apreta C (o el menú Netejar), es reinica el procés anterior.

<center><img src="./captura.png" height="250" alt="Calculadora" style="max-height: 250px;"></center>


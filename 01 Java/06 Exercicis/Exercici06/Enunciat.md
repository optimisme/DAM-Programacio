<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 6

Crear un sistema que ens permeti gestionar un parc d'atraccions.

El parc d'atraccions ofereix diverses atraccions, així com serveis addicionals com ara restaurants i botigues de records. 

Cada atracció i servei té les seves pròpies característiques, però formen part del parc en el seu conjunt. 

Utilitzarem la composició per modelar aquestes relacions, on el parc d'atraccions conté una llista d'atraccions i serveis.

Classe **Atraccio**:

Propietats privades: nom (text), tipus (text), alturaMinima (enter)

Constructor: que inicia nom, tipus i alturaMinima

Getters i Setters

Sobreescriptura de la funció 'toString' amb retorn: 

"Atraccio[nom=" + nom + ", tipus=" + tipus + ", alturaMinima=" + alturaMinima + "]

Classe **Restaurant**:

Propietats privades: nom (text), tipusCuina (text), capacitat (enter)

Constructor: que inicia nom, tipusCuina i capacitat

Getters i Setters

Sobreescriptura de la funció 'toString' amb retorn: 

"Restaurant[nom=" + nom + ", tipusCuina=" + tipusCuina + ", capacitat=" + capacitat + "]";

Classe **Botiga**:

Propietats privades: nom (text), tipusProducte (text)

Constructor: que inicia nom i tipusProducte

Getters i Setters

Sobreescriptura de la funció 'toString' amb retorn: 

"Botiga[nom=" + nom + ", tipusProducte=" + tipusProducte + "]";

Classe **ParcAtraccions**:

Propietats privades: llistes tipus 'ArrayList' de atraccions, restaurants i botigues

Mètodes per afegir objectes a les llistes: afegirAtraccio, afegirRestaurant i afegirBotiga

Mètodes per llistar els components: getAtraccions, getRestaurants i getBotigues

La crida d'aquesta funció 'main':

```java
public static void main(String[] args) {
    ParcAtraccions parc = new ParcAtraccions();

    parc.afegirAtraccio(new Atraccio("Montanya Russa", "Adrenalina", 120));
    parc.afegirRestaurant(new Restaurant("El Gran Chef", "Italiana", 100));
    parc.afegirBotiga(new Botiga("Records del Parc", "Souvenirs"));

    System.out.println("Atraccions al parc:");
    for (Atraccio atraccio : parc.getAtraccions()) {
        System.out.println(atraccio);
    }

    System.out.println("\nRestaurants al parc:");
    for (Restaurant restaurant : parc.getRestaurants()) {
        System.out.println(restaurant);
    }

    System.out.println("\nBotigues al parc:");
    for (Botiga botiga : parc.getBotigues()) {
        System.out.println(botiga);
    }
}
```

Ha de donar:

```text
Atraccions al parc:
Atraccio[nom=Montanya Russa, tipus=Adrenalina, alturaMinima=120]

Restaurants al parc:
Restaurant[nom=El Gran Chef, tipusCuina=Italiana, capacitat=100]

Botigues al parc:
Botiga[nom=Records del Parc, tipusProducte=Souvenirs]
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainValidation
./runTest.sh com.project.TestMain#testMainPrivateAttributes
```


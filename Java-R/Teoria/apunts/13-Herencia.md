<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

# Herència bàsica (extends)

Els llenguatges de programació orientats a objectes, com el java, modelen conceptes del món real en forma d'objectes.

L'herència en Java és un principi de la programació orientada a objectes (POO) que permet a una classe adquirir les propietats i mètodes d'una altra classe. En aquest context, tenim dos tipus principals de classes: les classes pares (també conegudes com a superclasses) i les classes filles (subclasses).

Quan una classe filla "hereta" d'una classe pare, això significa que la classe filla **pot utilitzar els camps i mètodes públics o protegits** de la classe pare com si fossin seus. Això es fa per promoure la reutilització del codi, evitar la duplicació, i fomentar una estructura de codi més neta i organitzada.

Exemple:

```java
class Superclasse {
    // Camps i mètodes de la superclasse
}

class Subclasse extends Superclasse {
    // Camps i mètodes addicionals de la subclasse
}
```

Limitacions:

- Java només suporta l'herència simple, cosa que significa que una classe només pot heretar directament d'una altra classe.

- Tot i que l'herència facilita la reutilització de codi i l'organització, també pot conduir a problemes de disseny si s'usa de manera excessiva o inadequada, com l'acoblament excessiu entre classes.

### Sobreescriptura de Mètodes, @Override

La sobreescriptura de mètodes es produeix quan una subclasse defineix un mètode amb el mateix nom, tipus de retorn, i llista de paràmetres (signatura) que ja està definit en la seva superclasse. 

La sobreescriptura permet que la subclasse proporcioni una implementació específica d'un mètode que ja existeix en la superclasse.


### Exemple 1300

```bash
# Fes anar l'exemple amb
./run.sh com.exemple1300.Main
```

Exemple d'herència amb **'extends'**, una classe pare 'Poligon' defineix les bases de classes herederes 'Cercle', 'Triangle' i 'Rectangle':

```java
public class Poligon {
    // Atributs comuns a tots els polígons podrien anar aquí

    public double calcularArea() {
        return 0; // Implementació genèrica, la idea és sobreescriure en subclasses
    }

    public double calcularPerimetre() {
        return 0; // Implementació genèrica, la idea és sobreescriure en subclasses
    }
}

public class Cercle extends Poligon {
    private double radi;

    public Cercle(double radi) {
        this.radi = radi;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radi * radi;
    }

    @Override
    public double calcularPerimetre() {
        return 2 * Math.PI * radi;
    }
}

public class Rectangle extends Poligon {
    private double amplada;
    private double altura;

    public Rectangle(double amplada, double altura) {
        this.amplada = amplada;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return amplada * altura;
    }

    @Override
    public double calcularPerimetre() {
        return 2 * (amplada + altura);
    }
}

```

### Exercici 1300

Crea un sistema simple de gestió d'empleats per a una empresa.

Classe Base (Superclasse): **Empleat**

Atributs privats: nom (String), cognom (String), i salariAnual (double).

Constructor: Que accepti nom, cognom, i salariAnual com a paràmetres.

Mètodes:

getNomComplet(): Retorna el nom complet de l'empleat (nom + cognom).

incrementarSalari(double percentatge): Incrementa el salari de l'empleat segons un percentatge donat.

```java
this.salariAnual += this.salariAnual * (percentatge / 100);
```

getSalariAnual(): Retorna el salari anual de l'empleat.

Subclasse: **Gerent**

Atributs privats: departament (String).

Constructor: Que accepti nom, cognom, salariAnual, i departament.

Sobreescriu el mètode getNomComplet() per a que també inclogui el departament del gerent al final.

Prova-ho amb aquest main:

```java
public class Main {
    public static void main(String[] args) {
        Empleat empleat = new Empleat("Maria", "Lopez", 30000);
        Gerent gerent = new Gerent("Carlos", "Garcia", 50000, "TI");
        
        System.out.println(empleat.getNomComplet() + " - Salari Anual: " + empleat.getSalariAnual());
        empleat.incrementarSalari(10);
        System.out.println("Després de l'increment: " + empleat.getSalariAnual());
        
        System.out.println(gerent.getNomComplet() + " - Salari Anual: " + gerent.getSalariAnual());
        gerent.incrementarSalari(10);
        System.out.println("Després de l'increment: " + gerent.getSalariAnual());
    }
}
```

### Súper

**super** és una paraula clau que fa referència directa a la superclasse (classe pare) immediata d'una classe. S'utilitza principalment en dos contextos: 

- Cridar a un constructor de la superclasse 

- Accedir a membres (mètodes o camps) de la superclasse que han sigut ocultats o sobrescrits en la subclasse.

```java
class Pare {
    Pare() {
        System.out.println("Constructor de Pare");
    }
}

class Fill extends Pare {
    Fill() {
        super(); // Crida al constructor de la classe Pare
        System.out.println("Constructor de Fill");
    }
}

public class ExempleSuper {
    public static void main(String[] args) {
        new Fill(); // Mostrarà: Constructor de Pare seguit de Constructor de Fill
    }
}
```

### Exemple 1301

```bash
# Fes anar l'exemple amb
./run.sh com.exemple1301.Main
```

Ús de súper al constructor i als mètodes sobreescrits

```java
class DispositiuElectronic {
    String nom;

    DispositiuElectronic(String nom) {
        this.nom = nom;
        System.out.println("Creant DispositiuElectronic: " + this.nom);
    }

    void encendre() {
        System.out.println(this.nom + " s'ha encès.");
    }
}

class Smartphone extends DispositiuElectronic {
    Smartphone(String nom) {
        super(nom); // Crida al constructor de la classe pare amb el nom del dispositiu
        System.out.println("Creant Smartphone: " + this.nom);
    }

    @Override
    void encendre() {
        super.encendre(); // Crida al mètode encendre() de la classe pare
        System.out.println(this.nom + " està llest per ser utilitzat com a smartphone.");
    }
}

public class Main {
    public static void main(String[] args) {
        Smartphone meuSmartphone = new Smartphone("iPhone");
        meuSmartphone.encendre();
    }
}
```

Sortida esperada:

```text
Creant DispositiuElectronic: iPhone
Creant Smartphone: iPhone
iPhone s'ha encès.
iPhone està llest per ser utilitzat com a smartphone.
```

## Herència d'interfícies (implements)

Una interfície és com un contracte o un acord que especifica què s'ha de fer, però no com s'ha de fer. Defineix un conjunt de mètodes (la signatura dels mètodes) que les classes han d'implementar, sense proporcionar la implementació real dels mètodes.

Característiques de les interfícies:

**Mètodes Abstractes**: Tradicionalment, les interfícies només podien contenir **mètodes abstractes, és a dir, mètodes sense cos (sense codi)**. Aquests mètodes han de ser implementats per les classes que decideixen adherir-se al contracte de la interfície.

**Mètodes Predeterminats i Estàtics**: Les interfícies a partir de Java 8 poden contenir també mètodes predeterminats amb implementació, i mètodes estàtics, permetent certa flexibilitat sense trencar el contracte amb les classes que ja implementen la interfície.

**Atributs**: Les interfícies poden contenir camps, però aquests són implícitament public, static, i final (constants).

- A diferència de l'herència de classes, l'herència d'interfícies si que permet herència múltiple.

### Herència amb implements

**Implementació d'Interfícies**: Quan una classe utilitza una interfície, aquest procés es coneix com a "implementació de la interfície", i s'utilitza la paraula clau implements. Això significa que la classe s'ha de comprometre a proporcionar cossos per tots els mètodes abstractes definits en la interfície.

```java
interface InterficieA {
    void metodeA();
}

class ClasseA implements InterficieA {
    public void metodeA() {
        // Implementació del metodeA
    }
}
```

**Herència d'Interfícies**: Quan una interfície hereta d'una altra interfície (o interfícies), no es fa servir implements, sinó extends. Això és perquè una interfície no està proporcionant la implementació dels mètodes, sinó més aviat està estenent la declaració o el contracte dels mètodes. Una interfície pot extendir múltiples altres interfícies, agafant totes les seves definicions de mètodes com a part del seu contracte.

```java
interface InterficieA {
    void metodeA();
}

interface InterficieB extends InterficieA {
    void metodeB();
}

class ClasseB implements InterficieB {
    public void metodeA() {
        // Implementació del metodeA
    }

    public void metodeB() {
        // Implementació del metodeB
    }
}
```

### Exemple 1302

```bash
# Fes anar l'exemple amb
./run.sh com.exemple1302.Main
```

Herència múltiple d'interficies, i implementació d'una interficie a una classe

```java
// Primera interfície pare
interface InterficieA {
    void metodeA();
}

// Segona interfície pare
interface InterficieB {
    void metodeB();
}

// Interfície filla que hereta de múltiples interfícies
interface InterficieCombinada extends InterficieA, InterficieB {
    void metodeCombinat();
}

// Classe que implementa la interfície combinada
class ClasseExemple implements InterficieCombinada {
    public void metodeA() {
        System.out.println("Implementació de metodeA");
    }

    public void metodeB() {
        System.out.println("Implementació de metodeB");
    }

    public void metodeCombinat() {
        System.out.println("Implementació de metodeCombinat");
    }
}

public class Main {
    public static void main(String[] args) {
        ClasseExemple exemple = new ClasseExemple();
        exemple.metodeA();
        exemple.metodeB();
        exemple.metodeCombinat();
    }
}
```

## Important!

**Herència de Classes**: Java suporta únicament l'herència simple, on una classe pot heretar d'una sola superclasse. Això simplifica el disseny i evita problemes com l'herència múltiple.

**Herència d'Interfícies**: Java permet que una interfície hereti de múltiples interfícies (herència múltiple), oferint flexibilitat en la definició de contractes sense introduir l'ambigüitat i els problemes de manteniment associats a l'herència múltiple de classes

## Classes abstractes

Una classe abstracta és una classe que no pot ser instanciada. Això significa que no pots crear objectes directament d'una classe abstracta. El seu propòsit principal és servir de base per a subclasses que hereten d'ella, proporcionant una estructura comuna.

Característiques:

**Mètodes Abstractes**: Una classe abstracta pot contenir mètodes abstractes. Aquests són mètodes declarats sense una implementació (sense cos). La responsabilitat de proporcionar la implementació d'aquests mètodes recau sobre les subclasses que hereten de la classe abstracta. Aquest requisit força a les subclasses a seguir un "contrat" definit pels mètodes abstractes.

**Mètodes No Abstractes**: També pot contenir mètodes no abstractes amb implementació completa. Això permet que les subclasses utilitzin aquests mètodes directament o els sobreescriuen segons sigui necessari.

### Exemple 1303

```bash
# Fes anar l'exemple amb
./run.sh com.exemple1303.Main
```

En un sistema per gestionar vehicles. Es defineix una classe abstracta 'Vehicle' amb mètodes abstractes com 'accelerar()' i 'frenar()'. Això permet tenir subclasses com 'Cotxe' i 'Bicicleta' que hereten de 'Vehicle' i proporcionen implementacions específiques per aquests mètodes.

```java
public abstract class Vehicle {
    // Aquest mètode abstracte ha de ser implementat per totes les subclasses
    public abstract void accelerar();
    
    // Aquest mètode abstracte també ha de ser implementat per totes les subclasses
    public abstract void frenar();

    // Un mètode no abstracte: pot ser utilitzat o sobreescriu per les subclasses
    public void encendre() {
        System.out.println("El vehicle s'ha encès.");
    }
}

public class Cotxe extends Vehicle {
    @Override
    public void accelerar() {
        System.out.println("El cotxe accelera.");
    }

    @Override
    public void frenar() {
        System.out.println("El cotxe frena.");
    }

    // Opcional: sobreescriure mètodes no abstractes
    @Override
    public void encendre() {
        System.out.println("El cotxe s'ha encès amb una clau.");
    }
}

```

## Mètodes finals i classes finals

Els mètodes declarats com a final no poden ser sobrescrits per les subclasses 

Les classes declarades com a final no poden ser esteses. Això és útil quan vols evitar que el comportament d'una classe o mètode sigui modificat.

### Exemple 1304

```bash
# Fes anar l'exemple amb
./run.sh com.exemple1304.Main
```

En aquest exemple, tant la classe CompteEstalvi com els mètodes dipositar i retirar són marcats com a final. Això significa que no pots crear una classe que hereti de CompteEstalvi, i no pots sobreescriure els mètodes dipositar i retirar en una subclasse (si n'hi hagués).

```java
class CompteEstalvi {
    private double balanc;

    CompteEstalvi(double balancInicial) {
        this.balanc = balancInicial;
    }

    final void dipositar(double quantitat) {
        if (quantitat > 0) {
            balanc += quantitat;
            System.out.println("Dipòsit realitzat: " + quantitat);
        }
    }

    final void retirar(double quantitat) {
        if (quantitat > 0 && quantitat <= balanc) {
            balanc -= quantitat;
            System.out.println("Retirada realitzada: " + quantitat);
        } else {
            System.out.println("Operació no vàlida.");
        }
    }

    void imprimirBalanc() {
        System.out.println("Balanc actual: " + balanc);
    }
}
public class Main {
    public static void main(String[] args) {
        CompteEstalvi meuCompte = new CompteEstalvi(1000);
        meuCompte.dipositar(500);
        meuCompte.retirar(200);
        meuCompte.imprimirBalanc();
    }
}
```

Resultat esperat:

```text
Dipòsit realitzat: 500.0
Retirada realitzada: 200.0
Balanc actual: 1300.0
```

**Nota**: Si marquem 'CompteEstalvi' com a classe final, ja no cal posar els mètodes 'dipositar' i 'retirar' com a finals, perquè ja no es podrà fer una classe derivada de 'CompteEstalvi'

## Polimorfisme

Anomenem **polimorfisme** al fet que en la programació orientada a objectes (POO) permet que els objectes de diferents classes siguin tractats com a objectes d'una superclasse comuna o interfície. 

Aquesta característica facilita l'escriptura de codi més flexible i reutilitzable.

Exemple:

Pensem en una classe base Animal amb un mètode ferSo(). Després, tenim diverses subclasses com Gos i Gat que implementen el seu propi ferSo(). 

Gràcies al polimorfisme, podem tractar tots els objectes de tipus Gos i Gat com a objectes Animal i cridar el mètode ferSo() sense conèixer el tipus específic d'animal.

Un altre exemple és per tenir una sola llista d'Animals, on hi ha Gossos i Gats, encara que aquests objectes tinguin atributs diferents.

```java
class Animal {
    void ferSo() {
        System.out.println("Aquest animal fa un so");
    }
}

class Gos extends Animal {
    @Override
    void ferSo() {
        System.out.println("El gos fa 'bup bup'");
    }
}

class Gat extends Animal {
    @Override
    void ferSo() {
        System.out.println("El gat fa 'miau'");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal meuAnimal = new Gos(); // Animal referenciat com a Gos
        meuAnimal.ferSo(); // Polimorfisme en acció

        meuAnimal = new Gat(); // Animal referenciat com a Gat
        meuAnimal.ferSo(); // Polimorfisme en acció
    }
}
```

***Nota**: En programació, també s'anomena **polimorfisme** quan diverses funcions tenen el mateix nom però diferents paràmetres (el què permet distingir-les)

```java
public class BasicCoffeeMachine {
    public Coffee brewCoffee(CoffeeSelection selection) throws CoffeeException {
        switch (selection) {
        case FILTER_COFFEE:
            return brewFilterCoffee();
        default:
            throw new CoffeeException(
                "CoffeeSelection ["+selection+"] not supported!");
        }   
    }
    public List brewCoffee(CoffeeSelection selection, int number) throws CoffeeException {
        List coffees = new ArrayList(number);
        for (int i=0; i<number; i++) {
            coffees.add(brewCoffee(selection));
        }
        return coffees;
    }
}
```

### Exercici 1301

Desenvolupar un sistema en Java per gestionar animals en un zoològic, utilitzant una combinació d'herència de classes i implementació d'interfícies amb mètodes sobreescrits.

Dins d'aquest sistema, diferents tipus d'animals tindran característiques i comportaments únics. 

Hi haurà una classe base **Animal** amb propietats comunes, i subclasses específiques com *Mamifer* i *Ocell*, que heretaran de Animal. 

A més, definirem interfícies per representar diferents comportaments, com *Volador* i *Nedador*, que alguns animals podran implementar.


Classe abstracta **Animal**:

Atributs protegits: nom (String), edat (int).

Constructor: inicialitza nom i edat.

Mètode toString(): retorna una cadena amb la informació de l'animal.


Subclasse **Mamifer**, hereta de *Animal*:

Atribut privat: tipusPelatge (String).

Constructor: inicialitza nom, edat, i tipusPelatge.

Sobreescriu toString() per incloure tipusPelatge.


Subclasse **Ocell**, hereta de *Animal*:

Atribut privat: colorPlomatge (String).

Constructor: inicialitza nom, edat, i colorPlomatge.

Sobreescriu toString() per incloure colorPlomatge.


Interfície **Volador**:

Mètode volar(): imprimeix un missatge que l'animal està volant.


Interfície **Nedador**:

Mètode nedar(): imprimeix un missatge que l'animal està nedant.

Alguns animals específics implementaran les interfícies Volador i/o Nedador per reflectir els seus comportaments únics. 


Classe **OcellVolador** que es deriva de *Ocell* i implementa *Volador*

Constructor: inicia nom, edat i colorPlomatge

Sobreescriu 'volar' amb el text: nom + " està volant!"


Classe **Dofi* que es deriva de *Mamifer* i implementa *Nedador*

Constructor: inicia nom, edat i tipusPelatge

Sobreescriu 'nedar' amb el text: nom + " està nedant!"


## Composició vs Herència

La composició i l'herència són dues tècniques fonamentals en la programació orientada a objectes (POO) utilitzades per reutilitzar codi i establir relacions entre classes. Tot i que ambdues permeten aconseguir una reutilització de codi eficaç, tenen diferències clau en com s'estructuren i utilitzen les relacions entre objectes i classes. Comprendre quan utilitzar una o l'altra és crucial per al disseny de software.

**Herència**

L'herència és un mecanisme que permet a una classe (anomenada subclasse) heretar camps i mètodes d'una altra classe (anomenada superclasse). La subclasse pot utilitzar directament els mètodes i camps de la superclasse, i també pot sobreescriure mètodes existents o afegir-ne de nous.

***Pros***: L'herència promou la reutilització de codi i estableix una relació clara "és-un" entre la superclasse i la subclasse.

***Contres***: L'herència pot conduir a jerarquies de classes complicades i pot ser menys flexible que la composició. Un canvi en la superclasse pot afectar totes les subclasses. A més, Java només suporta l'herència simple, limitant la reutilització de codi de múltiples classes base.

**Composició**

La composició implica construir classes utilitzant instàncies d'altres classes com a camps, en lloc d'heretar-les. Això estableix una relació "té-un" o "utilitza-un" entre els objectes.

***Pros***: La composició és més flexible que l'herència perquè facilita el canvi dels components en temps d'execució i minimitza la dependència entre classes. A més, promou un disseny més modular, ja que els objectes es poden compondre de maneres diverses.

***Contres***: Pot requerir més codi per delegar tasques als objectes components, i la relació entre els objectes pot no ser tan clara com en l'herència per a algunes persones.

### Composició vs Herència: Quan Utilitzar-les?

Utilitza l'herència quan la relació entre les dues classes naturalment segueix un model "és-un", i quan vols utilitzar o modificar el comportament existent de la superclasse. L'herència també pot ser útil quan hi ha una clara jerarquia i un comportament comú que es vol compartir a través de diverses classes.

Prefereix la composició quan la relació entre les classes sigui millor descrita com a "té-un", o quan necessitis una flexibilitat major per canviar el comportament dels teus components en temps d'execució. La composició també és preferible quan vols evitar els problemes de l'herència múltiple o quan vols minimitzar l'acoblament entre classes.

### Exemple 1305

```bash
# Fes anar l'exemple amb
./run.sh com.exemple1305.Main
```

Exemple de composició.

```java
// Definició de la classe Motor
class Motor {
    void encendre() {
        System.out.println("El motor s'ha encès.");
    }
}

// Definició de la classe Vehicle utilitzant composició
class Vehicle {
    private Motor motor;

    Vehicle() {
        motor = new Motor(); // Composició aquí
    }

    void encendreMotor() {
        motor.encendre();
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.encendreMotor(); // Encén el motor del vehicle
    }
}
```

### Exemple 1306

```bash
# Fes anar l'exemple amb
./run.sh com.exemple1306.Main
```

Exemple amb herència

```java
// Definició de la classe base Vehicle
class Vehicle {
    void moure() {
        System.out.println("El vehicle es mou.");
    }
}

// Definició de la subclasse VehicleAmbMotor utilitzant herència
class VehicleAmbMotor extends Vehicle {
    @Override
    void moure() {
        super.moure(); // Utilitza la implementació de moure de la classe Vehicle
        System.out.println("El vehicle amb motor s'ha encès i es mou.");
    }
}

public class Main {
    public static void main(String[] args) {
        VehicleAmbMotor vehicleAmbMotor = new VehicleAmbMotor();
        vehicleAmbMotor.moure(); // Mostra el comportament de moure específic del VehicleAmbMotor
    }
}

```

## Casting d'Objectes

El casting d'objectes és el procés de convertir una instància d'una classe a una instància d'una altra classe (dins de la seva jerarquia d'herència). Això inclou: 

**El casting ascendent** (cap a una superclasse) 

El casting ascendent es refereix a convertir una referència de tipus de subclasse a una referència de tipus de superclasse. Aquest tipus de casting és segur i es fa implícitament per Java, ja que la subclasse sempre és un tipus de la seva superclasse.

```java
class Animal {
    void ferSo() {
        System.out.println("Aquest animal fa un so.");
    }
}

class Gos extends Animal {
    void bupBup() {
        System.out.println("El gos fa bup bup.");
    }
}

public class Main {
    public static void main(String[] args) {
        Gos gos = new Gos();
        Animal animal = gos; // Upcasting, automàticament realitzat per Java
        animal.ferSo(); // Sortida: Aquest animal fa un so.
        // animal.bupBup(); // Error de compilació, el mètode bupBup() no està disponible en tipus Animal.
    }
}
```

**El casting descendent** (cap a una subclasse)

El casting descendent converteix una referència de tipus de superclasse a una referència de tipus de subclasse. A diferència de l'upcasting, el downcasting necessita ser explícit, ja que pot conduir a errors en temps d'execució si l'objecte no és realment una instància de la subclasse a la qual s'està convertint.

```java
Animal animal = new Gos(); // Upcasting implícit a Animal
Gos gos = (Gos) animal; // Downcasting explícit a Gos
if (animal instanceof Gos) {
    Gos gos = (Gos) animal;
    gos.bupBup(); // Sortida: El gos fa bup bup.
} else {
    System.out.println("La conversió no és segura.");
}
```

### Exercici 1302

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
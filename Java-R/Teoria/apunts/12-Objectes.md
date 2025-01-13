<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

# Objectes

Els objectes representen entitats o coses del món. Per exemple, persones, objectes visuals, ...

Els objectes JAVA permeten agrupar característiques (variables) i funcions, per definir nous tipus de dades.

Per exemple, l'objecte Persona:

```java
public class Persona {
    
    // Atributs (informació de l'objecte)
    private String nom; // Nom de la persona
    private int edat; // Edat de la persona

    // Constructor (crea un objecte de la classe "Persona")
    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }

    // Funció aniversari (suma un 1 a l'edat)
    public void aniversari() {
        edat++;
    }

    // Funció toString (override per imprimir el nom i edat de l'objecte)
    @Override
    public String toString() {
        return "Nom: " + this.nom + ", Edat: " + this.edat;
    }
}
```

Cal definir aquest objecte en el seu propi arxiu .java, i el nom ha de coincidir amb el de l'objecte. És a dir **"Persona.java"**


## Constructor

Els objectes tenen unes variables, que normalment no estàn iniciades a cap valor.

Quan creem una referència a l'objecte, ho fem a través del constructor. El constructor és aquella funció que es diu igual que l'objecte (en aquest cas 'Persona'). I normalment, al constructor li passem com a paràmetres els valors que volem que tinguin les variables de l'objecte.

Per exemple:

```java
Persona joan = new Persona("Joan", 25);
Persona eva = new Persona("Eva", 28);
```

En aquest cas, tenim dues **instàncies** de tipus 'Persona'. Cada una amb la seva configuració pròpia.

Per fer-ho possible, la funció 'constructor' que inicia l'objecte. Rep com a paràmetres els valors amb els que s'inicia aquell objecte.

```java
package com.project;

public class Persona {
    
    // Atributs (informació de l'objecte)
    private String nom; // Nom de la persona
    private int edat; // Edat de la persona

    // Constructor (crea un objecte de la classe "Persona")
    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }
}
```

**'this.nom'**, fa referència a l'atribut 'nom' de l'objecte (es fa servir **this.** per distingir-lo del paràmetre 'nom' que rebem)

**Nota**: Com que 'Persona.java' forma part del projecte 'project', cal informar-ho amb la línia "package com.project" al principi de l'arxiu.


### Múltiples constructors

Els objectes poden definir diferents tipus de constuctors amb diferents paràmetres. En cas que es volgui inicialitzar els objectes de diferent manera

```java
public class Vehicle {
    private String brand;
    private String model;
    private int year;

    // Constructor per defecte
    public Vehicle() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
    }

    // Constructor amb marca i model
    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.year = 0; // Any per defecte
    }

    // Constructor complet amb marca, model i any
    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Mètodes getters i setters
    public String getBrand() {
        return brand;
    }
}
```

## Funcions de l'objecte

Un dels avantatges de fer servir objectes, és que a part de personalitzar els camps de l'objecte, podem definir-li funcions específiques d'aquest objecte.

```java
    // Funció aniversari (suma un 1 a l'edat)
    public void aniversari() {
        edat++;
    }
```

En aquest cas, la funció 'aniversari' suma un 1 a l'edat de la persona cada vegada que es crida.

### Funcions '@override'

Alguns objectes, tenen funcions heretades del seu objecte pare (més endavant veurem l'herència). Tots els objectes JAVA hereten la funció 'toString' per mostrar les dades de l'objecte en format cadena de text.

Com que la funció 'toString' per defecte no és massa útil, la podem sobreescriure perquè dibuixi les dades al nostre gust. Per sobreescriure la funció per defecte hem de fer servir '@Override':

```java
    @Override
    public String toString() {
        return "Nom: " + this.nom + ", Edat: " + this.edat;
    }
```

Així quan volem mostrar la informació dels atributs de l'objecte, només hem de fer:

```java
Persona joan = new Persona("Joan", 25);
System.out.println(joan); // Escriu: Nom: Joan, Edat: 25
```

### Exemple 1200

Exemple de com fer servir l'objecte 'Persona':

```bash
# Fes anar l'exemple amb
./run.sh com.exemple1200.Main
```

```java
Persona joan = new Persona("Joan", 25);
Persona eva = new Persona("Eva", 28);

System.out.println(joan); // Imprimeix "Nom: Joan, Edat: 25"
System.out.println(eva); // Imprimeix "Nom: Eva, Edat: 28"

joan.aniversari(); // Suma un 1 a l'edat de "joan"
eva.aniverari(); // Suma un 1 a l'edat de "eva"

System.out.println(joan); // Imprimeix "Nom: Joan, Edat: 26"
System.out.println(eva); // Imprimeix "Nom: Eva, Edat: 29"
```

Cal fixar-se que:

* El constructor es crida amb **'new'** i els paràmetres necessaris

* Les funcions de l'objecte es criden amb **.nomFuncio**, en aquest cas: 'joan.aniversari()' o 'eva'

## Public i Private

Quan es defineixen atributs i funcions dels objectes, cal decidir quina visibilitat tenen.

* **public** són aquells atributs i funcions que es poden accedir des de la instància amb '.'. Per exemple 'joan.aniversari()' és accessible perquè la funció és 'public'

* **private** són aquells atributs i funcions que NO es poden accedir des de fora de la instància, perquè volem que siguin privats al nostre objecte. Només hi podem accedir des de les pròpies funcions de l'objecte. Normalment els atributs són privats i es modifiquen a través de cridar funcions (a l'exemple 'nom' i 'edat' són privats, no podem fer 'joan.nom' per obtenir o modificar el nom)

### Getters i Setters

Com que normalment els atributs són privats, necessitem maneres senzilles d'obtenir i modificar els seus valors.

Habitualment es fa amb **'getters'** i **'setters'**

```java
public class Persona {
    // Atributs
    private String nom; // Nom de la persona
    private int edat; // Edat de la persona

    // Getters i setters

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return this.edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }
}
```

S'entén que perquè els Getters i Setters funcionin, han de ser publics.

#### Getters

Els getters són funcions que es poden cridar per accedir al valor d'un atribut d'un objecte. Per exemple, si tenim una classe "Persona" amb un atribut "nom" que és privat, podem cridar la funció "getNom" per obtenir el valor actual d'aquest atribut:

```java
String nom = persona.getNom();
```

La funció "getNom" retorna el valor actual del nom de la persona.

#### Setters

Els setters són funcions que es poden cridar per canviar el valor d'un atribut d'un objecte. Per exemple, si tenim una classe "Persona" amb un atribut "nom" que és privat, podem cridar la funció "setNom" per canviar el valor del nom de la persona:

```java
persona.setNom("Joan");
```

### Exemple 1201

Exemple de com fer servir l'objecte 'Persona' amb Getters i Setters

```bash
# Fes anar l'exemple amb
./run.sh com.exemple1201.Main
```

```java
package com.project;

public class Main {
    public static void main(String[] args) {
        Persona joan = new Persona("Joan", 25);
        
        joan.setNom("Juanito");
        joan.setEdat(40);

        
        System.out.println(joan); // Imprimeix "Nom: Joanito, Edat: 40"
        System.out.println(joan.getNom()); // Imprimeix "Juanito"
    }
}
```

### Exercici 1200

Crea la classe 'Cotxe' que tindrà els atributs privats:

- color de tipus cadena de text
- marca de tipus cadena de text
- model de tipus cadena de text
- cilindrada de tipus enter
- any de tipus enter

El constructor ha d'iniciar els atributs segons l'ordre anterior.

Fes 'Getters' i 'Setters' per llegir i escriure els atributs anteriors.

Sobreescriu la funció 'toString' que mostri les dades dels atributs de cada instància. D'aquesta manera:

Model: CITROEN DS; Color: Gris; Cilindrada: 2175cc; Any: 1959

Aleshores, fes un programa JAVA que crei els següents dos models de cotxe i en mostri les dades:

- Verd, SEAT, 127, 1438, 1972
- Gris, CITROEN, DS, 2175, 

### Exercici 1201

Crea la classe 'Llibre' que modeli el comportament bàsic d'un llibre en una biblioteca, permetent establir i obtenir el títol, l'autor, l'any de publicació i si està en préstec o no.

**Atributs Privats:**

- String titol: El títol del llibre.

- String autor: L'autor del llibre.

- int anyPublicacio: L'any de publicació del llibre.

- boolean presetec: Indica si el llibre està en préstec o no.

**Constructor:**

Un constructor que accepti el títol, l'autor i l'any de publicació. El llibre hauria de començar no prestat per defecte.

**Mètodes Públics:**

- getTitol(): Retorna el títol del llibre.

- getAutor(): Retorna l'autor del llibre.

- getAnyPublicacio(): Retorna l'any de publicació del llibre.

- estaPrestat(): Retorna si el llibre està prestat o no.

- prestar(): Marca el llibre com a prestat.

- retornar(): Marca el llibre com a no prestat.

- *@Override* toString(): Retorna una cadena de text que representa el llibre, incloent el títol, l'autor, l'any de publicació i l'estat de préstec.

Amb el següent format:

"Titol, Autor; Any - En préstec" o bé "Titol, Autor; Any - Disponible"

## Static

Les variables i funcinons estàtiques permeten compartir dades entre diferents instàncies d'un objecte. És a dir:

* Els **atributs** estàtics tindràn el mateix valor per totes les instàncies d'un objecte.

* Les **funcions** estàtiques es criden sense necessitat de tenir una instància de l'objecte, i tenen la limitació que només poden accedir als atributs estàtics.


```java
package com.project;

public class Calculadora {

    static public int valorCompartit = 0;
    private int a;
    private int b;

    // Constructor
    public Calculadora(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // Suma els atributs de cada instància
    public int sumaValorsInstancia() {
        return a + b;
    }

    // Suma els paràmetres rebuts
    public static int sumaValors(int a, int b) {
        return a + b;
    }

    @Override
    public String toString() {
        return "Compartit:" + Calculadora.valorCompartit + "; a = " + a + "; b = " + b;
    }
}
```

En aquest exemple tenim un objecte calculadora que:

* Té un valor compartit a totes les instàncies.

* Cada instància pot tenir atributs a i b diferents, i la funció 'sumaValorsInstancia' retorna el resultat de sumar-los.

* La funció estàtica sumaValors rep dos paràmetres i retorna la suma d'aquests perquè no pot accedir als atributs 'a' i 'b' de la instància.

Per accedir als atributs i funcions **'static'**, es fa directament amb el nom de l'objecte, per exemple: **'Calculadora.sumaValors(1, 2)'**

### Exemple 1202

Exemple de com fer servir l'objecte 'Persona' amb Getters i Setters

```bash
# Fes anar l'exemple amb
./run.sh com.exemple1202.Main
```

```java
package com.project;

public class Main {
    public static void main(String[] args) {
        
        Calculadora calc0 = new Calculadora(2, 3);
        Calculadora calc1 = new Calculadora(20, 30);

        System.out.println(calc0); // Escriu: Compartit:0; a = 2; b = 3
        System.out.println(calc1); // Escriu: Compartit:0; a = 20; b = 30

        Calculadora.valorCompartit = 2;

        System.out.println(calc0); // Escriu: Compartit:2; a = 2; b = 3
        System.out.println(calc1); // Escriu: Compartit:2; a = 20; b = 30

        System.out.println("Suma calc0: " + calc0.sumaValorsInstancia()); // Escriu: Suma calc0: 5
        System.out.println("Suma calc1: " + calc1.sumaValorsInstancia()); // Escriu: Suma calc1: 50
        System.out.println("Calculadora.sumaValors(5,5): " + Calculadora.sumaValors(5,5)); 
        // Escriu: Calculadora.sumaValors(5,5): 10
    }
}
```

## Singleton

En programes molt complexes, amb molts objectes i instàncies a objectes pot ser interessant tenir un sol objecte per accedir a les dades de manera centralitzada.

El problema és que cada vegada que definim un 'new' a l'objecte de dades, obtenim una nova instància amb els seus pròpis atributs.

El singleton és una estructura que retorna sempre la mateixa instància, amb els mateixos valors als atributs. 

Ho fa, mantenint un atribut estàtic com a referència a ell mateix. I fent que el constructor sigui privat, així quan volem obtenir una instància d'un objecte 'singleton' ho hem de fer amb la funció 'getInstance' que s'encarrega de retornar sempre la mateixa instància (i no una de nova).

* El primer cop que es crida a 'getInstance' s'obté una instància nova normalment

* Les altres crides a 'getInstance' retornen la instància original enlloc de crear-ne una de nova

```java
package com.project;

public class SingletonDades {
  
    private static SingletonDades instance;
    public String value;
 
    // El constructor del Singleton és privat!!
    private SingletonDades(String value) {
        this.value = value;
    }
 
    public static SingletonDades getInstance(String value) {
        if (instance == null) {
            instance = new SingletonDades(value);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Valor: " + value;
    }
 }
```

### Exemple 1203

Exemple de singleton:

```bash
# Fes anar l'exemple amb
./run.sh com.exemple1203.Main
```

```java
package com.project;

public class Main {
    public static void main(String[] args) {
        
        SingletonDades instanciaHola = SingletonDades.getInstance("Hola");
        SingletonDades instanciaVale = SingletonDades.getInstance("Vale");
        SingletonDades instanciaAdeu = SingletonDades.getInstance("Adeu");

        System.out.println(instanciaHola); // Escriu: Valor: Hola
        System.out.println(instanciaVale); // Escriu: Valor: Hola
        System.out.println(instanciaAdeu); // Escriu: Valor: Hola
    }
}
```

### Exercici 1202

Crea la classe 'Estudiant', que és un sistema que permet registrar estudiants en un curs. 

El sistema ha de ser capaç de comptar el total d'estudiants registrats i limitar el nombre de registres segons la capacitat del curs.

**Atributs Privats d'Instància:**

- String nom: El nom de l'estudiant.

- String id: L'ID únic de l'estudiant.

**Atributs Privats Estàtics:**

- int comptadorEstudiants: Un comptador que porta la compte del total d'estudiants registrats.

- final int CAPACITAT_MAXIMA = 5: La capacitat màxima d'estudiants en el curs.

**Constructor:**

Un constructor que accepta nom i id com a paràmetres. Aquest constructor ha de verificar si encara hi ha capacitat en el curs abans de registrar a l'estudiant. Si la capacitat està plena, no ha de permetre la creació d'una nova instància i ha de mostrar un missatge d'error.

Mètodes Públics d'Instància:

**Getters i Setters**

Fes els Getters i Setters de 'nom' i 'id'

**Mètodes Públics Estàtics:**

- getComptadorEstudiants(): Retorna el nombre total d'estudiants registrats.

- hiHaCapacitat(): Retorna true si encara hi ha capacitat per a registrar més estudiants, false en cas contrari.

### Exercici 1203

Crea la classe 'ControlTemperatura' que permet gestionar la temperatura de diferents zones d'un edifici. 

Aquest sistema haurà de poder registrar la temperatura de cada zona i proporcionar la temperatura mitjana de tot l'edifici. 

També permetrà ajustar la temperatura de qualsevol zona i veure l'efecte que això té sobre la temperatura mitjana global.

**Atributs**:

* **temperaturaTotal** Estàtic, privat de tipus double
* **comptadorZones** Estàtic, privat de tipus int
* **nomZona** privat de tipus String
* **temperatura** privat de tipus double

**Constructor**:

El constructor accepta com a paràmetres 'nomZona' i 'temperatura' i actualitza els atributs de la instància.

El constructor també suma la temperatura a la 'temperaturaTotal' estàtica i suma 1 a 'comptadorZones'

**Mètodes d'Instància**:

- Getters per a 'nomZona' i 'temperatura' (no hi ha setters)

- ajustaTemperatura(double novaTemperatura): Un mètode que permeti ajustar la temperatura d'una zona específica. Aquest mètode haurà d'actualitzar la temperatura total registrada per a reflectir el canvi. És a dir:

    * Ha de restar l'antic valor de temperatura de la instància de 'temperaturaTotal'

    * Ha de posar com a valor de temperatura de la instància 'novaTemperatura'

    * Ha de sumar la 'novaTemperatura' a 'temperaturaTotal'

**Mètodes Estàtics**:

- getTemperaturaMitjana(): Un mètode que retorne la temperatura mitjana de l'edifici, calculada a partir de la temperatura total i el nombre de zones registrades.

    És a dir, si no hi ha cap zona retorna 0 i si hi ha zones retorna: temperaturaTotal / comptadorZones

### Exercici 1204

Crea dues classes 'Estudiant' i 'Curs'

*Classe Estudiant*

**Atributs** privats:

- nom (String): El nom de l'estudiant.
- edat (int): L'edat de l'estudiant.
- notaMitjana (double): La nota mitjana de l'estudiant.

**Constructor**:

Un constructor que inicialitzi el nom i l'edat de l'estudiant.

**Mètodes**:

- Setters i getters per a cada atribut.

- Una funció pública **actualitzaNotaMitjana(double novaNota)** que actualitzi la nota mitjana de l'estudiant basant-se en una nova nota aportada. 

    Aquest mètode haurà de cridar una funció privada **calculaNotaMitjana(double novaNota)** que realment realitzi el càlcul de la nova nota mitjana.

*Classe Curs*

**Atributs privats**:

- nomCurs (String): El nom del curs.
- professor (String): El nom del professor del curs.
- llistaEstudiants (ArrayList<Estudiant>): Una llista dels estudiants inscrits al curs.

**Constructor**:

Un constructor que inicialitzi el nomCurs i el professor.

**Mètodes**:

- Setters i getters per al nomCurs i professor.

- afegeixEstudiant(Estudiant estudiant): Afegeix un estudiant a la llista d'estudiants.

- eliminaEstudiant(String nom): Elimina un estudiant de la llista pel seu nom.

- mostraEstudiants(): Mostra la llista d'estudiants inscrits al curs. Aquesta funció ha d'ésser pública. El format serà "Nom - Nota Mitjana: 0.0"

### Exercici 1205

Crea tres classes 'Autor', 'Llibre' i 'Prestec'

*Classe Autor*

**Atributs** privats:

- nom (String): El nom complet de l'autor.
- nacionalitat (String): La nacionalitat de l'autor.

**Constructor**:

Un constructor que inicialitzi el nom i la nacionalitat de l'autor.

**Mètodes**:

- Setters i getters per a cada atribut.

*Classe Llibre*

**Atributs**:

- titol (String): El títol del llibre.
- autor (Autor): Una instància de Autor que representa l'autor del llibre.
- anyPublicacio (int): L'any de publicació del llibre.

**Constructor**:

Un constructor que inicialitzi el titol, l'autor, i l'anyPublicacio.

**Mètodes**:

- Setters i getters per a cada atribut.

*Classe Préstec*

**Atributs**:

- llibre (Llibre): El llibre que s'ha prestat.
- dataPrestec (String): La data en què es va realitzar el préstec.
- dataRetorn (String): La data en què s'ha de retornar el llibre.

**Constructors**:

Un constructor que inicialitzi el llibre, la dataPrestec, i la dataRetorn.

**Mètodes**:

- Setters i getters per a cada atribut.

- Un mètode estaEnTermini() que retorni un booleà indicant si el llibre s'ha retornat dins del termini establert (pots simular-ho amb una comprovació simple de la data).

### Exercici 1206

Crea tres classes 'RegistreAccionsSingleton', 'InterficieUsuari', 'ApiBackend' per desenvolupar un sistema que registri les accions realitzades pels usuaris en dues àrees diferents d'una aplicació (per exemple, una interfície d'usuari i una API backend) fent servir un objecte de registre comú accessible mitjançant un Singleton.

* Classe RegistreAccionsSingleton*

Aquesta serà la classe Singleton que gestiona el registre d'accions.

**Atributs**:

- instancia (private static): La única instància de RegistreAccionsSingleton.
- accions (List<String>): Una llista que emmagatzema les accions registrades.

**Mètodes**:

- getInstance(): Mètode estàtic que retorna la única instància de la classe.
- registrarAccio(String accio): Afegeix una acció a la llista accions.
- mostrarAccions(): Imprimeix totes les accions registrades.

*Classe InterficieUsuari*

Aquesta classe simularà accions realitzades per l'usuari a través d'una interfície.

**Mètodes**:

- realitzarAccio(String accio): Aquest mètode registrarà una acció utilitzant RegistroAccionsSingleton.

*Classe ApiBackend*

Aquesta classe simularà accions realitzades a través d'una API backend.

**Mètodes**:

- executarAccio(String accio): Similar a InterficieUsuari, aquest mètode registrarà una acció utilitzant RegistroAccionsSingleton.

**Requeriments de l'Exercici**

- Implementa el patró Singleton a la classe RegistroAccionsSingleton per a assegurar que només es pot crear una instància d'aquesta classe.

- Desenvolupa les classes InterficieUsuari i ApiBackend que utilitzen la instància de RegistroAccionsSingleton per registrar accions diferents.

- Demostra l'ús del Singleton en un programa principal (main), realitzant accions des de InterficieUsuari i ApiBackend i mostrant el registre acumulat d'accions.

### Exercici 1207

Crea tres classes 'ConfiguracioGlobal', 'Usuari' i 'Sistema' per desenvolupar un sistema que utilitzi un objecte de configuració global accessible des de diferents parts de l'aplicació, garantint que tots els components utilitzin la mateixa configuració a través d'un Singleton.

*Classe ConfiguracioGlobal*

Aquest serà el Singleton que contindrà les configuracions de l'aplicació.

**Atributs**:

- instancia (private static): La única instància de ConfiguracioGlobal.
- idioma (String): L'idioma predeterminat de l'aplicació.
- zonaHoraria (String): La zona horària predeterminada de l'aplicació.

Els valors predeterminats d'aquesta classe seràn idioma "Anglès" i zonaHoraria "UTC"

**Mètodes**:

- getInstance(): Mètode estàtic que retorna la única instància de la classe.
- getIdioma(), setIdioma(String idioma): Getter i setter per a l'atribut idioma.
- getZonaHoraria(), setZonaHoraria(String zonaHoraria): Getter i setter per a l'atribut zonaHoraria.

*Classe Usuari*

Simula una entitat que necessita accedir a la configuració global per realitzar alguna tasca.

**Mètodes**:

- mostrarPreferencies(): Mostra les preferències de configuració de l'usuari (idioma i zona horària).

El format és: "Idioma: Francès, Zona Horaria: GMT"

*Classe Sistema*

Simula el component del sistema que també necessita accedir a la configuració global, per exemple, per configurar el format de data i hora.

**Mètodes**:

- configurarSistema(): Configura el sistema basant-se en la configuració global.

El format és: "Configurant sistema amb idioma Francès i zona horària GMT"
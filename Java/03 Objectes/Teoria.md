<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
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

## Exemple00

Exemple de com fer servir l'objecte 'Persona':

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



## Exemple01

Exemple de com fer servir l'objecte 'Persona' amb Getters i Setters

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

## Exemple02

Exemple de com fer servir l'objecte 'Persona' amb Getters i Setters

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

## Exemple03

Exemple de singleton:

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


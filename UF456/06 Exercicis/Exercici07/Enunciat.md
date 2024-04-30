<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 7

Crea un programa per gestionar una biblioteca que conté una col·lecció de publicacions, poden ser llibres o revistes. 

Totes dues comparteixen algunes propietats bàsiques, però també tenen les seves característiques úniques. 

Utilitzarem una classe abstracta per definir les propietats comunes de totes les publicacions i després crearem subclasses específiques per a llibres i revistes. 

La biblioteca, com a entitat que agrupa publicacions, utilitzarà la composició per mantenir una col·lecció d'aquestes.

La biblioteca tindrà una llista de 'Publicacions' amb tots els llibres i revistes (fent ús del Polimorfisme), i també funcions per obtenir només la llista de llibres o només la llista de revistes.

Classe Abstracta **Publicacio**:

Atributs protegits: titol (String), anyPublicacio (int).

Constructor: inicialitza titol i anyPublicacio.

Mètode abstracte descripcioDetallada(): retorna una descripció detallada de la publicació (cadena de text).

Sobreescriu el mètode toString() per retornar informació bàsica de la publicació amb aquest format:

"Publicacio{titol='" + titol + "', anyPublicacio=" + anyPublicacio + "}"


Classe **Llibre**, que extén Publicacio:

Afegeix l'atribut privat autor (String). 

Sobreescriu descripcioDetallada(), i retorna la informació amb aquest format:

"Llibre{titol='" + titol + "', autor='" + autor + "', anyPublicacio=" + anyPublicacio + "}";


Clase **Revista**, que extén Publicacio: 

Afegeix l'atribut privat numeroEdicio (int). 

Sobreescriu descripcioDetallada(), i retorna la informació amb aquest format:

"Revista{titol='" + titol + "', numeroEdicio=" + numeroEdicio + ", anyPublicacio=" + anyPublicacio + "}"


Classe **Biblioteca**:

Utilitza composició per mantenir una llista de Publicacio.

Proporciona mètodes:

afegirPublicacio, per afegir una publicació a la llista
getLlibres, per obtenir una llista amb els llibres de la llista de publicacions
getRevistes, per obtenir una llista amb les revistes de la llista de publicacions

Per saber si una publicació és un *Llibre* o una *Revista* heu de fer servir '[instanceof](https://docs.oracle.com/cd/E29028_01/wlp.1034/e14255/com/bea/p13n/expression/operator/Instanceof.html)'


La crida d'aquesta funció 'main':

```java
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.afegirPublicacio(new Llibre("El Senyor dels Anells", 1954, "J.R.R. Tolkien"));
        biblioteca.afegirPublicacio(new Revista("National Geographic", 2020, 1024));
        biblioteca.afegirPublicacio(new Llibre("Dune", 1965, "Frank Herbert"));

        System.out.println("Totes les publicacions:");
        for (Publicacio publicacio : biblioteca.getPublicacions()) {
            System.out.println(publicacio);
        }

        System.out.println("\nLlibres:");
        for (Llibre llibre : biblioteca.getLlibres()) {
            System.out.println(llibre);
        }

        System.out.println("\nRevistes:");
        for (Revista revista : biblioteca.getRevistes()) {
            System.out.println(revista);
        }
    }
}
```

Ha de donar:

```text
Totes les publicacions:
Publicacio{titol='El Senyor dels Anells', anyPublicacio=1954}
Publicacio{titol='National Geographic', anyPublicacio=2020}
Publicacio{titol='Dune', anyPublicacio=1965}

Llibres:
Publicacio{titol='El Senyor dels Anells', anyPublicacio=1954}
Publicacio{titol='Dune', anyPublicacio=1965}

Revistes:
Publicacio{titol='National Geographic', anyPublicacio=2020}
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainValidation
./runTest.sh com.project.TestMain#testMainPrivateAttributes
```


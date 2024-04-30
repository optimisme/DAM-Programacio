<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 4

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

La crida d'aquesta funció 'main':

```java
public static void main(String[] args) {
    OcellVolador ocell = new OcellVolador("Piolín", 2, "groc");
    Dofi dofi = new Dofi("Flipper", 5, "suau");

    System.out.println(ocell);
    ocell.volar();

    System.out.println(dofi);
    dofi.nedar();
}
```

Ha de donar:

```text
OcellVolador{nom='Piolín', edat=2}, colorPlomatge='groc'
Piolín està volant!
Dofi{nom='Flipper', edat=5}, tipusPelatge='suau'
Flipper està nedant!
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainValidation
./runTest.sh com.project.TestMain#testMainPrivateAttributes
```


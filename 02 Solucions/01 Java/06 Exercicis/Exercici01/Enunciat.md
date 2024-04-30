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

Crear un sistema que ens permeti gestionar diversos electrodomèstics en una botiga. 

El sistema haurà de tenir una classe base anomenada **Electrodomestic**, la qual contindrà les propietats i mètodes comuns a tots els electrodomèstics. A partir d'aquesta classe base, crearem dues subclasses específiques: **Nevera** i **Rentadora**, que representaran dos tipus d'electrodomèstics amb característiques pròpies.

Classe Base **Electrodomestic**:

Atributs: marca (String), consumEnergetic (int).

Constructor: ha de permetre inicialitzar la marca i el consum energètic.

Mètode sobreescrit 'toString()': aquest mètode imprimirà la informació bàsica de l'electrodomèstic, incloent la marca i el consum energètic.

La manera d'escriure la informació s'ha d'adequar a:

*"Electrodomèstic de la marca " + marca + " amb un consum energètic de " + consumEnergetic + " watts."*

Subclasse **Nevera**:

Ha d'heretar de Electrodomestic.

Propietat adicional: capacitat (int), que indica la capacitat de la nevera en litres.

Constructor: a més de les propietats heretades iniciades amb 'super', ha d'inicialitzar la capacitat.

Fer un getter 'getCapacitat' que retorna el valor de l'atribut 'capacitat'

Mètode sobreescrit 'toString()' per afegir la informació sobre la capacitat de la nevera (a part de la informació d'electrodomèstic).

La manera d'escriure la informació s'ha d'adequar a:

*"Aquesta nevera té una capacitat de " + capacitat + " litres."*

Subclasse **Rentadora**:

Ha d'heretar de Electrodomestic.

Propietat adicional: capacitatCarrega (int), que indica la capacitat de càrrega de la rentadora en quilograms.

Constructor: a més de les propietats heretades iniciades amb 'super', ha d'inicialitzar la capacitat de càrrega.

Fer un getter 'getCapacitat' que retorna el valor de l'atribut 'capacitatCarrega'

Mètode sobreescrit 'toString()' per afegir la informació sobre la capacitat de la rentadora (a part de la informació d'electrodomèstic).

La manera d'escriure la informació s'ha d'adequar a:

*"Aquesta rentadora té una capacitat de càrrega de " + capacitatCarrega + " kg."*

La crida d'aquesta funció 'main':

```java
public static void main(String[] args) {
    Electrodomestic nevera = new Nevera("Samsung", 120, 350);
    Electrodomestic rentadora = new Rentadora("LG", 200, 8);

    System.out.println(nevera); // Mostra informació de la nevera
    System.out.println(rentadora); // Mostra informació de la rentadora
}
```

Ha de donar:

```text
Electrodomèstic de la marca Samsung amb un consum energètic de 120 watts.
Aquesta nevera té una capacitat de 350 litres.
Electrodomèstic de la marca LG amb un consum energètic de 200 watts.
Aquesta rentadora té una capacitat de càrrega de 8 kg.
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainValidation
./runTest.sh com.project.TestMain#testMainPrivateAttributes
```


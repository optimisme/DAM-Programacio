<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 3

Crea la classe 'ControlTemperatura' que permet gestionar la temperatura de diferents zones d'un edifici. Aquest sistema haurà de poder registrar la temperatura de cada zona i proporcionar la temperatura mitjana de tot l'edifici. També permetrà ajustar la temperatura de qualsevol zona i veure l'efecte que això té sobre la temperatura mitjana global.

**Atributs**:

* **temperaturaTotal** Estàtic, privat de tipus double
* **comptadorZnoes** Estàtic, privat de tipus int
* **nomZona** privat de tipus String
* **temperatura** privat de tipus double

**Constructor**:

El constructor accepta com a paràmetres 'nomZona' i 'temperatura' i actualitza els atributs de la instància.

El constructor també suma la temperatura a la 'temperaturaTotal' estàtica i suma 1 a 'comptadorZones'

**Mètodes d'Instància**:

Getters per a 'nomZona' i 'temperatura' (no hi ha setters)

ajustaTemperatura(double novaTemperatura): Un mètode que permeti ajustar la temperatura d'una zona específica. Aquest mètode haurà d'actualitzar la temperatura total registrada per a reflectir el canvi. És a dir:

- Ha de restar l'antic valor de temperatura de la instància de 'temperaturaTotal'

- Ha de posar com a valor de temperatura de la instància 'novaTemperatura'

- Ha de sumar la 'novaTemperatura' a 'temperaturaTotal'

**Mètodes Estàtics**:

getTemperaturaMitjana(): Un mètode que retorne la temperatura mitjana de l'edifici, calculada a partir de la temperatura total i el nombre de zones registrades.

És a dir, si no hi ha cap zona retorna 0 i si hi ha zones retorna: temperaturaTotal / comptadorZones

Valida que per aquest Main:

```java
package com.project;

public class Main {
    public static void main(String[] args) {
        ControlTemperatura zona1 = new ControlTemperatura("Recepció", 21.5);
        ControlTemperatura zona2 = new ControlTemperatura("Oficina", 22.0);

        System.out.println("Temperatura mitjana: " + ControlTemperatura.getTemperaturaMitjana() + "°C");

        // Ajustem la temperatura d'una zona i veiem com afecta la mitjana
        zona1.ajustaTemperatura(20.0);
        System.out.println("Nova temperatura mitjana (20): " + ControlTemperatura.getTemperaturaMitjana() + "°C");

        zona2.ajustaTemperatura(25.0);
        System.out.println("Nova temperatura mitjana (25): " + ControlTemperatura.getTemperaturaMitjana() + "°C");
    }
}
````

La sortida és:

```text
Temperatura mitjana: 21.75°C
Nova temperatura mitjana (20): 21.0°C
Nova temperatura mitjana (25): 22.5°C
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainGetters
./runTest.sh com.project.TestMain#testMainPrivateAttributes


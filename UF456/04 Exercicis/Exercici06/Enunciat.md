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

Requeriments de l'Exercici

Implementa el patró Singleton a la classe RegistroAccionsSingleton per a assegurar que només es pot crear una instància d'aquesta classe.

Desenvolupa les classes InterficieUsuari i ApiBackend que utilitzen la instància de RegistroAccionsSingleton per registrar accions diferents.

Demostra l'ús del Singleton en un programa principal (main), realitzant accions des de InterficieUsuari i ApiBackend i mostrant el registre acumulat d'accions.

Comprova que per aquest Main:

```java
package com.project;

public class Main {
    public static void main(String[] args) {
        InterficieUsuari ui = new InterficieUsuari();
        ApiBackend api = new ApiBackend();

        ui.realitzarAccio("Inici de sessió");
        api.executarAccio("Consulta de dades");
        ui.realitzarAccio("Actualització de perfil");
        api.executarAccio("Desconnexió");

        RegistreAccionsSingleton.getInstance().mostrarAccions();
    }
}
```

La sortida és:

```text
UI: Inici de sessió
API: Consulta de dades
UI: Actualització de perfil
API: Desconnexió
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainSettersGetters
./runTest.sh com.project.TestMain#testMainPrivateAttributes


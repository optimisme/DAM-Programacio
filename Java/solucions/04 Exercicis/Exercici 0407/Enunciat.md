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

Comprova que per aquest Main:

```java
package com.project;

public class Main {
    public static void main(String[] args) {
        // Configuració inicial
        ConfiguracioGlobal config = ConfiguracioGlobal.getInstance();
        config.setIdioma("Castellà");
        config.setZonaHoraria("CET");

        // Usuari i Sistema utilitzen la configuració
        Usuari usuari = new Usuari();
        usuari.mostrarPreferencies();

        Sistema sistema = new Sistema();
        sistema.configurarSistema();
    }
}
```

La sortida és:

```text
Idioma: Castellà, Zona Horaria: CET
Configurant sistema amb idioma Castellà i zona horària CET
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainSettersGetters
./runTest.sh com.project.TestMain#testMainPrivateAttributes


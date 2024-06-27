<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 39

Fes un programa per jugar a "Roca, Paper, Tisores"

El programa demanarà a cada iteració quina és la opció de l'usuari i generarà una opció automàtica per part de l'ordinador.

Es sortirà del bucle 'while' quan un dels dos participants hagi guanyat tres cops o bé quan l'usuari escrigui "sortir".

Si l'usuari escriu sortir, s'escriu "L'usuari ha sortit"

El programa ha de tenir les següents funcions públiques:
```java
    public static String processGame(String input) {
    // Gestiona la partida segons el què escriu l'usuari i retorna tota la cadena de successos
    // Si escriu 'Sortir' afegeix "L'usuari ha sortit" i acaba el programa
    // Altrament escull un valor aleatori per la tirada de l'ordinador i executa la lògia del joc
    // Al final afegeix: "Ha guanyat el jugador." o "Ha guanyat l'ordinador."
    }

    private static String getRandomOption() {
    // Retorna 'Roca', 'Paper' o 'Tisores' aleatòriament
    }

    private static String handleGameLogic(String opcioJugador, String opcioOrdinador) {
    // Retorna una cadena tipus: " - Jugador %s vs. Ordinador %s - Puntuació: Jugador %d - Ordinador %d"
    }
```

Exemple d'execució:
```text
Escriu la teva opció [Roca, Paper, Tisores, Sortir]: Roca
 - Jugador Roca vs. Ordinador Roca - Puntuació: Jugador 0 - Ordinador 0
Escriu la teva opció [Roca, Paper, Tisores, Sortir]: Roca
 - Jugador Roca vs. Ordinador Paper - Puntuació: Jugador 0 - Ordinador 1
Escriu la teva opció [Roca, Paper, Tisores, Sortir]: Roca
 - Jugador Roca vs. Ordinador Roca - Puntuació: Jugador 0 - Ordinador 1
Escriu la teva opció [Roca, Paper, Tisores, Sortir]: Roca
 - Jugador Roca vs. Ordinador Paper - Puntuació: Jugador 0 - Ordinador 2
Escriu la teva opció [Roca, Paper, Tisores, Sortir]: Roca
 - Jugador Roca vs. Ordinador Paper - Puntuació: Jugador 0 - Ordinador 3 Ha guanyat l'ordinador.
```


Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```

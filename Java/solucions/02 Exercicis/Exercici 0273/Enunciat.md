<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 73

Fes una funció (escriuTaula) que rebi els següents paràmetres:

* **dades** una taula de dades homogènies (tots els elements tenen igual longitud)
* **columnes** amb tants elements com columnes tingui la taula de dades
* **alineacions** amb la mateixa longitud que les columnes, format pels caràcters "<, ^, >"
* **amplades** amb la mateixa longitud que les columnes indicant l'amplada en caràcters de cada una

L'array ha de tornar una taula formatada correctament, el separador vertical és | i l'horitzontal -

* Si la cadena de text és més ample que la columna, l'ha de retallar
* Si alguna de les llistes no té la mateixa longitud que la resta, ha de retornar un missatge d'error.

Per exemple:
```java
    Object[][] ciutats = {
        {0, "Barcelona", 1620343, 12, true},
        {1, "Madrid", 3207247, 667, false},
        {2, "València", 791413, 15, true},
        {3, "Màlaga", 569130, 11, true},
        {4, "Sevilla", 688711, 7, false},
        {5, "Alicante", 330525, 12, true},
        {6, "Zaragoza", 664938, 220, false},
        {7, "Gijón", 275735, 3, true},
        {8, "Palma de Mallorca", 22610, 14, true},
        {9, "Bilbao", 345821, 30, false}
    };

    // Aquests arrays podrien ser utilitzats per a controlar la presentació si fos necessari.
    String[] columnes = {"id", "ciutat", "poblacio", "altitud", "costera"};
    String[] alineacions = {"left", "left", "center", "center", "right"};
    int[] amplades = {3, 10, 10, 8, 6};
```

Fes les funcions:
```java
    public static String escriuTaula(Object[][] dades, String[] columnes, String[] alineacions, int[] amplades) {
    // Formata la taula segons les configuracions entrades pels paràmetres
    }

    public static String formatCell(String text, String alineacio, int amplada) {
    // Retorna una cel·la de text alineat segons '<' (esquerra), '>' (dreta) o bé '^' (centre)
    // amb l'amplada demanada
    }
```

Exemple:
```text
-----------------------------------------------------
| id  | ciutat     |   poblacio |  altitud | coster |
-----------------------------------------------------
| 0   | Barcelona  |    1620343 |       12 |   true |
| 1   | Madrid     |    3207247 |      667 |  false |
| 2   | València   |     791413 |       15 |   true |
| 3   | Màlaga     |     569130 |       11 |   true |
| 4   | Sevilla    |     688711 |        7 |  false |
| 5   | Alicante   |     330525 |       12 |   true |
| 6   | Zaragoza   |     664938 |      220 |  false |
| 7   | Gijón      |     275735 |        3 |   true |
| 8   | Palma de M |      22610 |       14 |   true |
| 9   | Bilbao     |     345821 |       30 |  false |
-----------------------------------------------------
```


Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
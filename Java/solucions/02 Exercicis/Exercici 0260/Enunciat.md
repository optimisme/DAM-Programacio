<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 60

Fes un programa que mostri i compti els múltiples de 7 entre 1 i 1000

Nota, els múltiples de 7 dónen 0 com a residu quan es divideixen entre 7.

Per exemple:
```text
7 / 7 = 1 i residu 0, és múltiple de 7
14 / 7 = 2 i residu 0, és múltiple de 7
15 / 7 = 2 i residu 1, no és múltiple de 7
21 / 7 = 3 i residu 0, és múltiple de 7
27 / 7 = 3 i residu 6, no és múltiple de 7
```
Per exemple, per 149:
22: 0, 7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91, 98, 105, 112, 119, 126, 133, 140, 147, 

Fes la funció:
```java
    public static void mostrarMultiplesDe7() {
    // Mostra el resultat
    }
```

Exemple:
```text
Multiples de 7 entre 1 i 1000:
7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91, 98, 105, 112, 119, 126, 133, 140, 147, 154, 161, 168, 175, 182, 189, 196, 203, 210, 217, 224, 231, 238, 245, 252, 259, 266, 273, 280, 287, 294, 301, 308, 315, 322, 329, 336, 343, 350, 357, 364, 371, 378, 385, 392, 399, 406, 413, 420, 427, 434, 441, 448, 455, 462, 469, 476, 483, 490, 497, 504, 511, 518, 525, 532, 539, 546, 553, 560, 567, 574, 581, 588, 595, 602, 609, 616, 623, 630, 637, 644, 651, 658, 665, 672, 679, 686, 693, 700, 707, 714, 721, 728, 735, 742, 749, 756, 763, 770, 777, 784, 791, 798, 805, 812, 819, 826, 833, 840, 847, 854, 861, 868, 875, 882, 889, 896, 903, 910, 917, 924, 931, 938, 945, 952, 959, 966, 973, 980, 987, 994
Total: 142
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
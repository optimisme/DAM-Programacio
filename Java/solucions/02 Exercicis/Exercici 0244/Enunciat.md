<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 44

Genera un triangle de X astericos.

Demana un número entre 1 i 10 a l'usuari.

Si l'usuari escrigui un número fora del rang, escriu: "El número ha d'estar entre 1 i 10".

Si el número és correcte mostra el seu triangle d'astericos.

Fes que surti centrat amb la funció de posicionament center a 10 asteriscos d'ample.

Fes les següent funcions:
```java
    public static String generateCenteredTriangle(int num) {
    // Getorna el text de totes les linies del triangle generat
    }

    public static String generateCenteredText(String text, int width) {
    // Retorna un text centrat a 'width' espais
    }
```

Exemple:
```text
Introdueix un número entre 1 i 10 per generar un triangle d'asteriscs: 6
    *
    **
   ***
   ****
  *****
  ******
```


Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 63

Fes una funció que rebi una llista de cadenes de text que representen números, i retorni una llista de números.

Fes-ho primer amb arrays:

String[] numeros = {"4", "5", "6", "7"};

I després amb llistes:

ArrayList<String> numeros = new ArrayList<>();
numeros.add("4");
numeros.add("5");
numeros.add("6");
numeros.add("7");

Fes les funcions:
```java
    public static List<Integer> convertirArray(String[] numeros) {
    // Converteix un array de cadenes de text en una llista de números.
    }

    public static List<Integer> convertirLlista(ArrayList<String> numeros) {
    // Converteix una llista de cadenes de text en una llista de números.
    }
```

Exemple:
```text
Convertit des d'array: [4, 5, 6, 7]
Convertit des de llista: [4, 5, 6, 7]
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
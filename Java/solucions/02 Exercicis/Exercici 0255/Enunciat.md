<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exerici 55

Fes una funció 'calculaNums' que rebi un número llarg com a paràmetre, el transformi a cadena text i retorni un array amb:

* El nombre de números parells
* El nombre de números senars

El número s'ha de generar automàticament.

Posa-hi les següents funcions:
```java

    public static long generaNumeroAleatori() {
        return 0; // Genera un número llarg (long) aleatòri
    }

    public static int[] calculaNums(long numero) {
    // Retorna un array amb el nombre de números parells i senars en un número llarg.
    }
```

Exemple:
```text
El número: 2193015366064990026
El nombre de números parells: 11
El nombre de números senars: 8
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
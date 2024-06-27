<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 67

Fes un programa que rebi una frase per input de teclat i retorni les paraules ordenades de menys a més lletres, i de més a menys lletres.

**Nota**: Ignora els apòstrofs i fes que comptin com a part de la paraula.

Fes la funció:
```java
    public static List<String> ordenaParaulesPerLongitud(List<String> paraules, boolean ascendent) {
    // Retorna la llista amb les paraules ordenades per logitud segons l'ordre
    }
```

Exemple:
```text:
Introdueix una frase:
Hola fa sol al balcó de l'hotel Miramar
Paraules ordenades de menys a més lletres: [fa, al, de, sol, Hola, balcó, l'hotel, Miramar]
Paraules ordenades de més a menys lletres: [l'hotel, Miramar, balcó, Hola, sol, fa, al, de]
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```

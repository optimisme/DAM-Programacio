<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 66

Defineix una funció (separaVocals) que a partir d'una llista de paraules, retorna dos arrays:

* La primera conté totes les paraules que comencen per vocal
* La segona conté totes les paraules que comencen per consonant

Després defineix la funció (vocalsAlFinal) que a partir de una llista de paraules, retorna una llista on les paraules que començen per vocal estàn al final de la llista

L'entrada ha de ser un **input** de l'usuari.

Prova-ho amb:

* "Hola, ara mateix estem aprenent Java" > ["Hola,", "mateix", "JAVA", "ara", "estem", "aprenent"]
* "Demà és festa i anem a la platja" > ["Demà", "festa", "la", "platja", "és", "i", "anem", "a"]

Fes les següents funcions:
```java
    public static String[][] separaVocals(List<String> paraules) {
    // Separa les paraules que comencen per vocal i consonant.
    }

    public static List<String> vocalsAlFinal(List<String> paraules) {
    // Col·loca les paraules que comencen per vocal al final de la llista.
    }

    public static boolean isVowel(char c) {
    // Determina si un caràcter és una vocal.
    }
```

Exemple:
```text
Introdueix una llista de paraules separades per espais:
hola adeu gat ocell pedra oliva
Paraules que comencen per vocal: [adeu, ocell, oliva]
Paraules que comencen per consonant: [hola, gat, pedra]
Paraules amb vocals al final: [hola, adeu, pedra, oliva]
```

```text
Introdueix una llista de paraules separades per espais:
Si, tot és més gris que blanc
Paraules que comencen per vocal: [és]
Paraules que comencen per consonant: [Si, tot, més, gris, que, blanc]
Paraules amb vocals al final: [Si, que]
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```

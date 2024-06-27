<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 72

Fes dues funcions 'calculaMajuscules' i 'calculaMinuscules' que retornin el número de majúscules i minúscules d'un text introduit per teclat.

El càlcul es fa així:
```java
        numeroMajuscules = longitudDelText - longitudDelTextSenseMajuscules;
        numeroMinuscules = longitudDelText - longitudDelTextSenseMinuscules;
```

Fes les següent funcions:
```java
    public static int calculaMajuscules(String text) {
    // Calcula el número de majúscules
    }

    public static int calculaMinuscules(String text) {
    // Calcula el número de minúscules
    }
```

Exemple:
```text
Introdueix un text:
Hola Què Tal Va Tot
Número de majúscules: 5
Número de minúscules: 9
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
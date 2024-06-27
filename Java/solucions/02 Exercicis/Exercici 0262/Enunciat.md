<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 62

Fes una funció (escriu_llista), que rebi una llista i escrigui a cada línia:

L'element a la posició X de la llista és 'Y'

Prova-la amb ArrayLists:

* ArrayList<String> partsDelDia = new ArrayList<>(Arrays.asList("Matí", "Tarda", "Vespre", "Nit"));
* ArrayList<String> diesDeLaSetmana = new ArrayList<>(Arrays.asList("Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenge"));
* ArrayList<String> mesosDeLAny = new ArrayList<>(Arrays.asList("Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre"));

Fes la funció:
```java
    public static void escriuLlista(ArrayList<String> llista) {
    // Per cada element de l'ArrayList escriu: "L'element a la posició %d de la llista és '%s'\n"
    }
```

Exemple:
```text
Parts del dia:
L'element a la posició 0 de la llista és 'Matí'
L'element a la posició 1 de la llista és 'Tarda'
L'element a la posició 2 de la llista és 'Vespre'
L'element a la posició 3 de la llista és 'Nit'

Dies de la setmana:
L'element a la posició 0 de la llista és 'Dilluns'
L'element a la posició 1 de la llista és 'Dimarts'
L'element a la posició 2 de la llista és 'Dimecres'
L'element a la posició 3 de la llista és 'Dijous'
L'element a la posició 4 de la llista és 'Divendres'
L'element a la posició 5 de la llista és 'Dissabte'
L'element a la posició 6 de la llista és 'Diumenge'

Mesos de l'any:
L'element a la posició 0 de la llista és 'Gener'
L'element a la posició 1 de la llista és 'Febrer'
L'element a la posició 2 de la llista és 'Març'
L'element a la posició 3 de la llista és 'Abril'
L'element a la posició 4 de la llista és 'Maig'
L'element a la posició 5 de la llista és 'Juny'
L'element a la posició 6 de la llista és 'Juliol'
L'element a la posició 7 de la llista és 'Agost'
L'element a la posició 8 de la llista és 'Setembre'
L'element a la posició 9 de la llista és 'Octubre'
L'element a la posició 10 de la llista és 'Novembre'
L'element a la posició 11 de la llista és 'Desembre'
```


Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
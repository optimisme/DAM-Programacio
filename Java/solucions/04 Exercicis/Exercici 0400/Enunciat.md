<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 0

Crea la classe 'Cotxe' que tindrà els atributs privats:

- color de tipus cadena de text
- marca de tipus cadena de text
- model de tipus cadena de text
- cilindrada de tipus enter
- any de tipus enter

El constructor ha d'iniciar els atributs segons l'ordre anterior.

Fes 'Getters' i 'Setters' per llegir i escriure els atributs anteriors.

Sobreescriu la funció 'toString' que mostri les dades dels atributs de cada instància. D'aquesta manera:

Model: CITROEN DS; Color: Gris; Cilindrada: 2175cc; Any: 1959

Alsehores, fes un programa JAVA que crei els següents dos models de cotxe i en mostri les dades:

- Verd, SEAT, 127, 1438, 1972
- Gris, CITROEN, DS, 2175, 

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainSettersGetters
./runTest.sh com.project.TestMain#testMainPrivateAttributes
```


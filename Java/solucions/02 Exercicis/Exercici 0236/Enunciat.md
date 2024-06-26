<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 36

Fes un programa que generi un número aleatori entre 0 i 9 (inclòssos)

Després demana a l'usuari que escrigui un número i comprova:

- Si l'ha encertat escriu: "Felicitats, has encertat amb X **intents**"

- Si no l'ha encertat i el número de l'usuari és més gran que el número secret escriu: "Has escrit X, el número secret és més petit"

- Si no l'ha encertat i el número de l'usuari és més petit que el número secret escriu: "Has escrit X, el número secret és més gran"

Aquest procés es repeteix fins que l'usuari encerta el número.

Exemple:
```text
Escriu un número entre 0 i 9: 4
Has escrit 4, el número secret és més gran
Escriu un número entre 0 i 9: 6
Has escrit 6, el número secret és més gran
Escriu un número entre 0 i 9: 8
Has escrit 8, el número secret és més petit
Escriu un número entre 0 i 9: 7
Felicitats, has encertat amb 4 intents
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```

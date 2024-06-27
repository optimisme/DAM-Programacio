<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exerici 50

Fes un programa que demani a l'usuari una direcció de correu electrònic i validi que:

- Conté un símbol @
- Conté un punt
- El símbol @ no està al principi
- El símbol @ no està al final
- El punt no està al principi
- El punt no està al final
- El símbol @ i el punt no estan junts

El programa tornarà a demanar el correu electrònic, fins que se n'escrigui un de vàlid.

Exemple:
```text
Introdueix una direcció de correu electrònic: no-valid
Correu electrònic no vàlid. Torna a intentar-ho.
Introdueix una direcció de correu electrònic: hola@domini.cat
Correu electrònic vàlid: hola@domini.cat
```


Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 6

Fes un programa que converteixi un valor en Euros cap a Dollars, per fer-ho ha de demanar:

* El valor en Euros que es vol convertir
* La tasa de conversió que ha d'aplicar

Ha de mostrar la quantitat resultant com a: "El valor de X€ són Y$"

La operació és senzilla, simplement és multiplicar els euros pel valor de la tasa de conversió

On X són els euros introduits i Y el resultat de la conversió.

Exemple:
```text
Quin és el valor en Euros que vols convertir? 2,45
Quina és la taxa de conversió? 1,2
El valor de 2,45€ són 2,94$
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```

<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 17

Un palíndrom és una frase que, es llegeix igual del dret que del revés (Tota en minúscula, i si no tens en compte els espais o caràcters especials)

Per exemple:
```text
Anul·la la lluna
Atrapa'l o l'aparta
No sap pas on
Tramaran anar a Mart
Un pop nu
```
Fes una funció anomenada "es_palindrom" que accepta un text d'entrada i retorna "True" o "False" segons si la frase és un palíndrom.

Per avaluar si és un palíndrom:
* Treu tots els espais en blanc de la frase, fes-ho amb replace
* Treu també els caràcters: · i '
* Passa la frase a minúsules
* Compara si el resultat anterior és igual al seu invertit (amb [::-1])

S'ha de mostrar per pantalla: 
```text
        "És la frase 'X' un palindrom? Y"
        On X és la frase d'entrada i Y és "True" o "False"
```
Validar els anagrames d'exemple anteriors, i un parell de textos que no són anagrames


Exemple:
```text
És la frase 'Anul·la la lluna' un palindrom? true
És la frase 'Atrapa'l o l'aparta' un palindrom? true
És la frase 'No sap pas on' un palindrom? true
És la frase 'Tramaran anar a Mart' un palindrom? true
És la frase 'Un pop nu' un palindrom? true
És la frase 'Aquesta frase no és un palíndrom' un palindrom? false
És la frase 'Aquest tampoc no ho és' un palindrom? false
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida el test:
```bash
./runTest.sh com.project.TestMain
```


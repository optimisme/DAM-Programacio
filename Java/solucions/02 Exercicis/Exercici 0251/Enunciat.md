<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exerici 51

Fes un programa que doni només 3 intents a l'usuari per escriure una contrasenya correcta.

Si l'usuari escriu la contrasenya correcta, el programa escriu "Accés permès" i s'acaba.

Si l'usuari escriu una contrasenya incorrecta, el programa escriu "Contrasenya incorrecta" i torna a demanar la contrasenya.

La contrasenya correcta és "1234".

Exemple:
```text
Introdueix la contrasenya: ar56
Contrasenya incorrecta
Introdueix la contrasenya: po33
Contrasenya incorrecta
Introdueix la contrasenya: ve12
Contrasenya incorrecta
Accés denegat. Has exhaurit els intents.
```

```text
Introdueix la contrasenya: 1234
Accés permès
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
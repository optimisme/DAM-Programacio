<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 12

Crea un menú tal que la sortida sigui així:
```text
        ********Menú Principal********
        1.                Veure perfil                 
        2.         Canviar contrasenya         
        3.                      Sortir
```

Al escollir una opció la sortida ha de ser el text de la opció i entre parèntesis el número, només en el cas '3' surt del programa.

Si la opció no és vàlida, escriu:
```text
Escull una opció: Opció no vàlida
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```

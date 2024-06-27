<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 38

Fes un programa que fent ús d'un bucle 'while' mostri el següent menú:
```text
Menú:
1. Saluda
2. Parla
3. Sortir
```
Aleshores:

- Quan s'escull la opció 1 es mostra "Hola!"
- Quan s'escull la opció 2 es mostra una de les següents frases a l'atzar:

    * Tinc un gos que es diu Pelut
    * M'agrada menjar xocolata
    * Vull vitajar al Japó

- Quan s'escull la opcio 3 el programa acaba

Exemple:
```text
Menú:
1. Saluda
2. Parla
3. Sortir
Escull una opció: 2
M'agrada menjar xocolata
Menú:
1. Saluda
2. Parla
3. Sortir
Escull una opció: 1
Hola!
Menú:
1. Saluda
2. Parla
3. Sortir
Escull una opció: 3
Sortint...
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
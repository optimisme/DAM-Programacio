<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 15

Fes un programa amb dues funcions: 

* 'operacions_aritmetiques': que accepta dos paràmetres: 'a' i 'b' i retorna el resultat de les operacions: suma, resta, multiplicació i divisió

* 'mostrar_resultats': que accepta 6 paràmetres: 'a', 'b', 'suma', 'resta', 'multiplicacio' i 'divisio' i mostra els resultats amb el format:
```python
        a + b = suma, a - b = resta, a * b = multiplicacio, a / b = divisio
```
On a i b són els valors originals i suma, resta, multiplicacio, divisio són els altres paràmetres rebuts

És a dir, la funció 'mostrar_resultats' si a = 2 i b = 4, ha de fer un print de:
```python
        4 + 2 = 6, 4 - 2 = 2, 4 * 2 = 8, 4 / 2 = 2     
```
**Nota**: Tingues en compte que les operacions es fan a la funció 'operacions_aritmetiques' i que la funció 'mostrar_resultats' només mostra informació

Exemple:
```text
2 + 4 = 6, 2 - 4 = -2, 2 * 4 = 8, 2 / 4 = 1
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```

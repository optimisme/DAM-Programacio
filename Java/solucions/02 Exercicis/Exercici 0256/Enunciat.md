<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exerici 56

Fes una funció (porcio_taula) que rebi tres paràmetres:

* Número
* Valor inici
* Valor final

La funció ha d'escriure la porció de la taula de multiplicar entre 'inici' i 'final'

Exemples:

```java
porcioTaula(2, 4, 7);
4 x 2 = 8
5 x 2 = 10
6 x 2 = 12
7 x 2 = 14

porcioTaula(5, 3, 5);
3 x 5 = 15
4 x 5 = 20
5 x 5 = 25
```

Fes la funció:
```java
    public static void porcioTaula(int numero, int inici, int fi) {
    // Dibuixa la porció de la taula entre 'inici' i 'fi' per 'numero'
    }
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
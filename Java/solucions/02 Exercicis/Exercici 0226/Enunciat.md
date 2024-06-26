<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 26

Fes una funció (calcula_interessos) que calculi els interessos que es paga per una hipotèca, segons un capital inicial, un interès i un nombre de mesos.

Per exemple, si el capital inicial és de 1000€, l'interès del 5% i el nombre de mesos 10, el resultat hauria de ser 50€.

**Pista**: Els interessos es calculen com a `capital * interès * mesos / 100`.

Comprova que la funció 'calcula_interessos' funciona correctament amb els següents valors: 

* 1000, 5, 10 => 500
* 2500, 3, 12 => 900
* 7464, 4, 14 => 4179.84
* 10000, 2, 24 => 4800

Exemple:
```text
Per un capital de 1000,00€, un interès del 5,00% i 10 mesos, els interessos són 500,00€
Per un capital de 2500,00€, un interès del 3,00% i 12 mesos, els interessos són 900,00€
Per un capital de 7464,00€, un interès del 4,00% i 14 mesos, els interessos són 4179,84€
Per un capital de 10000,00€, un interès del 2,00% i 24 mesos, els interessos són 4800,00€
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
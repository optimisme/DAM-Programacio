<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exerici 52

Fes una funció (compta_vendes), que demani a l'usuari el valor en € d'unes quantes vendes. La funció ha de retornar:

- El nombre de vendes entrades
- La suma total
- La mitjana

Per deixar d'escriure vendes, l'usuari escriu 'fi'.

Al final, el programa ha de mostrar:

```
S'han apuntat X vendes, amb un total de Y € i una mitjana de Z €.
```

Exemple:
```text
Introdueix el valor de les vendes (escriu 'fi' per acabar):
34
689
43
12
fi
S'han apuntat 4 vendes, amb un total de 778.00 € i una mitjana de 194.50 €.
```

```text
Introdueix el valor de les vendes (escriu 'fi' per acabar):
43
oca
Valor no vàlid, torna a intentar-ho.
23
fi
S'han apuntat 2 vendes, amb un total de 66.00 € i una mitjana de 33.00 €.
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
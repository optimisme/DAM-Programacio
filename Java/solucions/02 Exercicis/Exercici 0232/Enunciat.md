<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 32

Escriu una funció (calcula_consum) que determini la factura d'aigua d'un client segons el nombre de litres que ha consumit durant un mes.

Els costos són:
```text
Cost fix mensual: 10€ (inclou els primers 1.000 litres)
Fins a 5.000 litres (inclòs): 0,02€ per litre addicional.
Fins a 10.000 litres (inclòs): 0,03€ per litre addicional.
Més de 10.000 litres: 0,05€ per litre addicional.
```
Per exemple:
* Si un client ha consumit 800 litres, hauria de pagar només el cost fix de 10€.
* Si un client ha consumit 6.000 litres: 
```text
    10€ : Cost fix (1.000 litres)
+   80€ : 0,02€ per 4.000 litres
    30€ : 0,03€ per 1.000 litres
-------            ------
   120€ : Total     6.000 litres
```
* Si et cal, fes altres funcions de suport per a calcula_consum. Sigues organitzat/da!

Exemples per comprovar:
```text
* 800 litres => 10€
* 6.000 litres => 120€
* 9.000 litres => 210€
* 12.000 litres => 340€
```

Exemple:
```text
Introdueix el nombre de litres consumits: 18
La factura d'aigua per 18 litres és 10,00€
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
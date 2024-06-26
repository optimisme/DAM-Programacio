<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 31

Fes una funció (calcula_tarifa) que determini el cost mensual d'una factura telefònica segons els minuts que una persona ha parlat i el número de missatges (SMS) enviats. 

Considera també el cost fix mensual que inclogui certa quantitat de minuts i SMS gratuïts.

Aquests són els detalls del pla:
```text
Cost fix mensual: 15€ (inclou 200 minuts gratuïts i 50 SMS gratuïts)
Cost per minut addicional: 0,10€
Cost per SMS addicional: 0,05€
```
Exemples:
```text
    * Parlar 150 minuts i enviar 40 SMS: Cost fix de 15€.
    * Parlar 250 minuts i enviar 30 SMS: Cost fix (15€) cost addicional de 50 minuts (5€). Total = 20€.
    * Parlar 220 minuts i enviar 80 SMS: Cost fix (15€), cost addicional de 20 minuts (2€) i 30 SMS (1,5€). Total = 18,5€.
```
Comprova que la funció calcula_tarifa funciona correctament amb els següents valors:
```text
* 148 minuts i 20 SMS => 15€
* 264 minuts i 40 SMS => 21.4€
* 420 minuts i 180 SMS => 43.5€
* 520 minuts i 240 SMS => 56.5€
```

Exemple:
```text
Introdueix el nombre de minuts parlats: 24
Introdueix el nombre de SMS enviats: 67
El cost mensual de la factura és 15,85€
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
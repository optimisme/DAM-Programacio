<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 34

Un petit hotel a la costa vol informatitzar el seu sistema de reserves. 

Necessiten una funció (calcula_reserva) que determini el preu total d'una reserva segons el nombre de nits, el tipus d'habitació i si el client vol esmorzar inclòs.

Les tarifes són:
```text
Habitació estàndard: 50€ per nit.
Habitació amb vistes al mar: 70€ per nit.
Suite amb jacuzzi: 120€ per nit.
Esmorzar: 10€ per dia i persona.
```
La funció hauria d'acceptar els següents paràmetres: 
```text
* nombre de nits
* tipus d'habitació (estàndard, amb vistes o suite)
* el nombre de persones que volen esmorzar.
```
A més, l'hotel ofereix les següents promocions:
* Si reserves més de 5 nits, t'ofereixen un descompte del 10% sobre el total de la reserva (sense comptar l'esmorzar).
* Si reserves una suite amb jacuzzi per més de 3 nits, l'esmorzar és gratuït.

Et pot anar bé definir primer les següents funcions:
* calcula_cost_habitacio(tipus_habitacio, nits)
* calcula_cost_esmorzar(nombre_persones, nombre_dies)

Per exemple:
* Reserva d'una habitació estàndard per 4 nits sense esmorzar: 50€ * 4 = 200€.
* Reserva d'una habitació amb vistes al mar per 6 nits amb esmorzar per a 2 persones: [(70€ * 6) - 10%] + (10€ * 6 * 2) = 444€.
* Si et cal, fes altres funcions de suport per a calcula_reserva. Sigues organitzat/da!

Exemples per comprovar:
* Habitació estàndard, 4 nits, 2 persones amb esmorzar: 280€
* Suite amb jacuzzi, 5 nits, 2 persones amb esmorzar (gratuït per la promoció): 640€
* Habitació amb vistes, 6 nits, 1 persona sense esmorzar: 438€

Exemple:
```text
Habitació estàndard, 4 nits, 2 persones amb esmorzar: 280,00€
Suite amb jacuzzi, 5 nits, 2 persones amb esmorzar: 600,00€
Habitació amb vistes, 6 nits, 1 persona sense esmorzar: 378,00€
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
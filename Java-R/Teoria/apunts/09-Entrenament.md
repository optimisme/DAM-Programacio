<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

# Entrenament

## Exercici 0

Un anagrama és un text, que passat a minúscules i ordenant els seus caràcters, és igual a un altre.

Per exemple:
```text
Mare i Rema
Porta i Tropa
Triangle i Integral
Sopa i Posa
```
Fes una funció anomenada "isAnagrama" que accepta dues paraules d'entrada, i retorna "True" o "False" segons si són anagrames.

Per avaluar si són anagrames:
* Treu tots els espais en blanc de les paraules
* Passa les paraules a minúscules
* Ordena les lletres de les paraules
* Compara si els dos resultats anteriors són iguals

S'ha de mostrar per pantalla: 
```text
        "Són les paraules 'X' i 'Y' anagrames? Z"
        On X i Y són les paraules d'entrada i Z és "True" o "False"
```
Validar els anagrames d'exemple anteriors, i un parell de proves amb quatre paraules que no siguin anagrames.

## Exercici 1

import random
def tira_moneda():
    resultat = random.randint(1, 2)
    if resultat == 1:
        return "cara"
    else:
        return "creu"

def tira_monedes():
    moneda0 = tira_moneda()
    moneda1 = tira_moneda()
    moneda2 = tira_moneda()
    return moneda0, moneda1, moneda2

m0, m1, m2 = tira_monedes()
cares = 0
if m0 == "cara":
    cares = cares + 1
if m1 == "cara":
    cares = cares + 1
if m2 == "cara":
    cares = cares + 1

print(f'El resultat del llançament de les tres monedes és: {m0}, {m1}, {m2}')
print(f'El nombre de cares és: {cares}')

## Exercici 2

Un cuidador de gossos cobra 30€ per dia que cuida un gos.

Si el gos es queda de nit, cobra 20€ més.

D'aquests diners, ha de pagar un 16% d'impostos al govern.

Fes la funció 'benefici_dia' que calculi el benefici que obté el cuidador per cada gos que cuida.

A partir dels paràmetres:
* dia: número de gossos que només es queden de dia
* nit: número de gossos que es queden de dia i de nit

## Exercici 3

Un petit hotel a la costa vol informatitzar el seu sistema de reserves. 

Necessiten una funció (calculaReserva) que determini el preu total d'una reserva segons el nombre de nits, el tipus d'habitació i si el client vol esmorzar inclòs.

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
```text
* Si reserves més de 5 nits, t'ofereixen un descompte del 10% sobre el total de la reserva (sense comptar l'esmorzar).
* Si reserves una suite amb jacuzzi per més de 3 nits, l'esmorzar és gratuït.
```

Et pot anar bé definir primer les següents funcions:
```text
* calculaCostHabitacio(tipusHabitacio, nits)
* calculaCostEsmorzar(nombrePersones, nombreDies)
```

Per exemple:
```text
* Reserva d'una habitació estàndard per 4 nits sense esmorzar: 50€ * 4 = 200€.
* Reserva d'una habitació amb vistes al mar per 6 nits amb esmorzar per a 2 persones: [(70€ * 6) - 10%] + (10€ * 6 * 2) = 444€.
* Si et cal, fes altres funcions de suport per a calculaReserva. Sigues organitzat/da!
```

Exemples per comprovar:
```text
* Habitació estàndard, 4 nits, 2 persones amb esmorzar: 280€
* Suite amb jacuzzi, 5 nits, 2 persones amb esmorzar (gratuït per la promoció): 640€
* Habitació amb vistes, 6 nits, 1 persona sense esmorzar: 438€
```

## Exercici 4

Fes una funció (calculaTarifa) que determini el cost mensual d'una factura telefònica segons els minuts que una persona ha parlat i el número de missatges (SMS) enviats. 

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
Comprova que la funció calculaTarifa funciona correctament amb els següents valors:
```text
* 148 minuts i 20 SMS => 15€
* 264 minuts i 40 SMS => 21.4€
* 420 minuts i 180 SMS => 43.5€
* 520 minuts i 240 SMS => 56.5€
```

## Exercici 5

Fes una funció (calculaIrpf) que calculi l'IRPF que ha de pagar una persona segons els ingressos bruts que té.

Si et cal, fes altres funcions de suport a aquesta funció principal. Sigues organitzat/da!

Aquests són els trams que ha de tenir en compte:
```text
                | Trams IRPF            |Total|
                |-----------------------|-----|
                | De 0 a 12.450€        | 19% |
                | De 12.450€ a 20.200€  | 24% |
                | De 20.200€ a 35.200€  | 30% |
                | De 35.200€ a 60.000€  | 37% |
                | De 60.000€ a 300.000€ | 45% |
                | Més de 300.000€       | 47% |
```
Per exemple:

* Si una persona cobra 10.200€, hauria de pagar el 19% = 1.938€
```text
+   0,19 *   10.200€           = 1.938,0€
                               ----------
                         Total:  1.938,0€
```
* Si una persona cobra 15.000€, hauria de pagar:
```text
    0,24 * (15.000€ - 12.450€) =   606,0€
+   0,19 *  12.450€            = 2.365,5€
                               ----------
                         Total:  2.971,5€
```
* Si una persona cobra 22.000€, hauria de pagar:
```text
    0,3  * (22.000€ - 20.200€) =   540,0€
    0,24 * (20.200€ - 12.450€) = 1.860,0€
+   0,19 *  12.450€            = 2.365,5€
                               ----------
                         Total:  4.765,5€
```
Comprova:
```text
        * 7600 => 1444.0
        * 16000 => 3217.5
        * 26000 => 5965.5
        * 32000 => 7765.5
        * 54500 => 15866.5
        * 64832 => 20075.9
        * 275387 => 114825.65
        * 765915 => 344881.55
```

## Exercici 0006

Fes un programa que simuli una partida entre en Pau i la Paz

Tiren una moneda a l'aire i guanya el primer que treu tres cops cara

A cada tirada es mostra, segons correspon:
```text
En Pau ha tret cara (2), la Paz ha tret cara (1)
```


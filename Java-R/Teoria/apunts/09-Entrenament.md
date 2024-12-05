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

## Exercici 0900

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

## Exercici 0901

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

## Exercici 0902

Un cuidador de gossos cobra 30€ per dia que cuida un gos.

Si el gos es queda de nit, cobra 20€ més.

D'aquests diners, ha de pagar un 16% d'impostos al govern.

Fes la funció 'benefici_dia' que calculi el benefici que obté el cuidador per cada gos que cuida.

A partir dels paràmetres:
* dia: número de gossos que només es queden de dia
* nit: número de gossos que es queden de dia i de nit

## Exercici 0903

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

## Exercici 0904

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

## Exercici 0905

Fes un programa que simuli una partida entre en Pau i la Paz

Tiren una moneda a l'aire i guanya el primer que treu tres cops cara

A cada tirada es mostra, segons correspon:
```text
En Pau ha tret cara (2), la Paz ha tret cara (1)
```

## Exercici 0906

Fes un programa que rebi una cadena de text i un ample (en caràcters) i:

- Torna una cadena de text de l'ample especificat
- El text està centrat a l'ample definit
- Si la posició és imparell, el text queda desplaçat un caràcter a l'esquerra
- Si el téxt és més llarg que l'ample, queda tallat (i ocupa tots els caràcters)

## Exercici 0907

Fes un programa que:

- Demana a l'usuari un número entre 5 i 10
- Si no és vàlid torna un missatge d'error (també si és un text o una lletra)

- Genera un array de mira el número escollit, amb valors entre 1000 i 9999 (inclòsos)
- Escull la meitat de valors de l'array a l'atzar i els posa en un nou array
- Ordena de major a menor els valors escollits
- Ordena de menor a major els valors descartats

- Mostra l'array original
- Mostra els valors escollits ordenats
- Mostra els valors descartats ordenats

## Exercici 0908

Fes un programa que mostri una taula amb informació com la següent, a partir d'un **ArrayList** i un **HashMap**:

```text
| Nom               | País            | Disciplina          | Nobel? | Naixement |
|-------------------|-----------------|---------------------|--------|-----------|
| Albert Einstein   | Alemanya/Suïssa | Física              | Sí     | 1879      |
| Marie Curie       | Polònia/França  | Física/Química      | Sí     | 1867      |
| Isaac Newton      | Anglaterra      | Física/Matemàtiques | No     | 1643      |
| Charles Darwin    | Anglaterra      | Biologia            | No     | 1809      |
| Alan Turing       | Anglaterra      | Matemàtiques/Infor. | No     | 1912      |
```

El programa ha de demanar a l'usuari: *Quina columna vols ordenar (o sortir)?* i:

- Si escriu *ordenar* i un nom de columna es dibuixa la taula ordenada segons la columna
- Si escriu *ordenar* i el nom de la columna seguit de **inv** igual però en ordre invers
- Si escriu sortir, se surt del programa
- Si escull una opció no vàlida o **ajuda** es mostren les opcions disponibles

Per exemple:
```text
ordenar nom
ordenar naixement inv
```
## Exercici 0909

Copia el programa anterior, i fes que a més cada personatge tingui un identificador únic de dues xifres més grans que 10.

```text
| Id | Nom               | País            | Disciplina          | Nobel? | Naixement |
|----|-------------------|-----------------|---------------------|--------|-----------|
| 24 | Albert Einstein   | Alemanya/Suïssa | Física              | Sí     | 1879      |
| 18 | Marie Curie       | Polònia/França  | Física/Química      | Sí     | 1867      |
| 99 | Isaac Newton      | Anglaterra      | Física/Matemàtiques | No     | 1643      |
| 56 | Charles Darwin    | Anglaterra      | Biologia            | No     | 1809      |
| 77 | Alan Turing       | Anglaterra      | Matemàtiques/Infor. | No     | 1912      |
```

El programa ha de demanar a l'usuari: *Escriu una comanda (o ajuda)?* i:

- Permet afegir un nou personatge amb una comanda estil:
```text
afegir Rosalind Franklin,Anglaterra,Biologia Molecular,No,1920
```

- Permet esborrar un personate a partir del seu nom amb la comanda:
```text
esborrar Charles Darwin
```

- Permet filtrar informació amb comandes i mostra només la informació demanada:
```text
filtrar disciplina "Física"
filtrar naixement 1809
```

- Permet treure el filtre i mostrar tota la taula:
```text
treure filtre
```

Et caldràn les funcions:
```java
// Retorna un id entre 10 i 99 que no existeix a "personatges"
public static int generaId(ArrayList<HashMap<String, Object>> personatges)

// Comprova si un id ja existeix a l'ArrayList
public static boolean idExisteix(ArrayList<HashMap<String, Object>> personatges, int id)
```
# Ruleta

*"Treball a petició d'en Cachinero"*

Una ruleta de casino és una roda que gira i que està dividida en diferents caselles numerades. Cada casella té un color (negre, vermell o verd per a la casella zero). Els jugadors aposten a un número, color parell/senar o columna, i la ruleta es fa girar fins que la bola es para en una casella, decidint així el resultat de l’aposta.

## Joc i vista de la ruleta

**Dibuix de la ruleta:**

Dibuixeu un cercle dividit en caselles iguals, amb números de l’1 al 36 i una casella extra per al zero.

Apliqueu els colors corresponents: vermell i negre per les caselles de l’1 al 36, i verd per al zero.

**Dibuix de la taula:**

- S'ha de dibuixar la taula de números, de 3 columnes i 12 files, amb el 0 apart.

- S'ha de dibuixar l'espai per les apostes *vermell/negre*

- S'ha de dibuixar l'espai per les apostes *parell/senar*

- Espai per apostes a una de les tres columnes.

- Un quadre que digui "Banca"

**Jugadors i fitxes:**

Hi ha tres jugadors: Taronja, Lila, Blau

El saldo original de cada jugador serà de 100 unitats.

Les fitxes de cada jugador es mostraràn en diferents tipus de fitxes: 005, 010, 020, 050, 100

Al taulell les fitxes seràn del color del jugador, i al costat de cada fitxa apareix "x?" on ? és el número de fitxes d'aquella quantitat que té el jugador.

Per exemple, inicialment:
```text
100 x 0
050 x 1
020 x 1
010 x 2
005 x 2
```

Les fitxes s'han de reorganitzar per tal que, amb el crèdit disponible, hi hagi la màxima varietat de valors de fitxe possible.

Després de la llista hi ha d'haver un número amb el crèdit disponible (suma total) del jugador.

**Apostes i premis:**

Abans de girar la ruleta s'ha de definir l'aposta de cada jugador. Les apostes poden ser:

- A un o més números. Per cada número la possibilitat de guanyar és de un 2,7%. Si s'escull aquell número obtens 35 unitats per cada unitat apostada.

- Aposta a un color *"negre"* o *"vermell"* (no *"verd"*). Per cada color la possibilitat de guanyar és del 49%. Si s'escull aquell color obtens 1 unitat per cada unitat apostada.

- Parell o senar. Per cada tipus la possibilitat de guanyar és del 49%. Si s'escull la opció obtens 1 unitat per cada unitat apostada.

- Columna. Per cada columna la possibilitat de guanyar és del 32%. Si s'escull aquella columna obtens 2 unitat per cada unitat apostada.

Per fer l'aposta s'arrossegua una o més fitxes d'un valor (si el jugador té aquella fitxa disponible), cap a un espai d'aposta de la ruleta (numero, color, parell/senar, columna)

Si es deixa la fitxa en un espai no vàlid, aquesta s'animarà cap a la seva posició original.

**Gir de la ruleta:**

Quan ja no es volen fer més apostes, hi haurà un botó "Girar" al costat de la ruleta que la farà rodar.

Simuleu la velocitat de gir <span style="text-decoration:underline">amb una animació decreixent</span> fins que la ruleta s'aturi.

No hi haurà "pilota", però si una fletxa que indica el número escollit.

<span style="text-decoration:underline">La fletxa sempre ha de quedar centrada a la casella escollida</span>, perquè no hi hagi confusió. 

Feu servir [aquest exemple](https://optimisme.github.io/roulette/) com a inspiració.

<span style="text-decoration:underline">S'han de seguir les probabilitats de guanyar indicades anteriorment.</span> S'entén que si fós una màquina recreativa, s'hauria de complir la [normativa del BOE](https://www.boe.es/buscar/pdf/1998/BOE-A-1998-23945-consolidado.pdf)

**Resultats de l’aposta:**

Després d'aturar-se, la ruleta es mostra el resultat de l'aposta.

- Si no s'obté res, les fitxes perdudes s'animen cap al quadre de "Banca"

- Les fitxes que obtenen premi apareixen al costat de les fitxes apostades i s'animen cap al seu respectiu espai de jugador.

**Final de la partida:**

Es juga fins que els tres jugadors s'arruinen, que és el final més probable i s'anomena **[house edge](https://en.wikipedia.org/wiki/Casino_game)**.

## Estadístiques i vista de tirades

Cal que guardeu la informació de cada tirada en una llista. Per cada tirada s'ha de guardar:

- El resultat
- El crèdit de cada jugador després de la tirada
- L'aposta de cada jugador

Hi ha d'haver un botó que permeti veure la llista de tirades en una taula, amb un scroll si hi han moltes tirades.

A la vista de la llista no es dibuixarà la ruleta, i hi haurà un botó per tancar la llista i tornar a la vista de la ruleta.
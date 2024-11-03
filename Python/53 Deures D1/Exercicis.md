
# Exercicis dibuix

Resol aquests exercicis, entrega la URL del projecte GitHub amb els exercicis resolts.

## Exercici 0

Fes un programa **exercici000.py** que faci el següent dibuix, amb les eines de dibuix de **pygame**.

Fes-ho amb un bucle for:
```python
for cnt in range(0, 10)
```

- Observa les posicions per veure les posicions **(x,y)**
- El radi és: **10 + cnt * 2.5**
<br/>
<center><img src="./assets/exercici000.png" style="max-height: 400px" alt="">
<br/></center>
<br/>

## Exercici 1

Fes un programa **exercici001.py** que dibuixi 20 rectangles centrats a la pantalla, simulant perspectiva.

Cal fer-ho amb un bulce:
```python
for q in range(20, 0, -1)
```

A cada pas el factor de perspectiva multiplica l'ample i alt del quadre amb **perspective = (q / 20)**

L'ample i alt de cada quadre és:
```python
q_ample = q * 25 * perspective
q_alt = q * 20 * perspective
```

S'ha de centrar els quadres a la finestra, fes una variable global per capturar les mides:
```python
def app_run():
    global window_size
    window_size["width"] = screen.get_width()
    window_size["height"] = screen.get_height()
    window_size["center"]["x"] = int(screen.get_width() / 2)
    window_size["center"]["y"] = int(screen.get_height() / 2)
```

A més, el color canvia a cada iteració amb **q * 10**.

- Els quadres parells són de color blau
- Els quadres senars de color verd
<br/>
<center><img src="./assets/exercici001.png" style="max-height: 400px" alt="">
<br/></center>
<br/>

## Exercici 2

Fes un programa **exercici002.py** on:

Defineix una nova funció **draw_text(text, font, x, y, align_x="left", align_y="top")** que dibuixa un text a la posició **x**, **y** amb l'anineació definida a **align_x** i **align_y**.

Els tipus d'alineacions són:

- **Horitzontals**: center, right, left
- **Verticals**: center, bottom, top

Fes servir les [eines de text](https://pygame-zero.readthedocs.io/en/stable/ptext.html) de **pygame**, és a dir:
```python
text_surface = font.render(text, True, (0, 0, 0))
text_rect = text_surface.get_rect()
text_rect.centerx
```

Fes servir els cercles BLUE com a punts de referència.

<br/>
<center><img src="./assets/exercici002.png" style="max-height: 400px" alt="">
<br/></center>
<br/>

## Exercici 3

Fes un programa **exercici003.py** on un quadre segueix el moviment del mouse i canvia de color segons uns límits.

Fes que la finestra sigui reescalable amb:
```python
screen = pygame.display.set_mode((640, 480), pygame.RESIZABLE)
```

- El rectangle exterior està a 100 pixels dels limits de la finestra
- El color del quadre és negre dora del rectangle exterior
- El color del quadre és:

  * Vermell al quadrant superior-esquerra
  * Verd al quadrant inferior-esquerra
  * Blau al quadrant superior-dret
  * Groc al quadrant inferior-dret

<center>
<video width="100%" controls allowfullscreen style="max-width: 90%; width: 400px; max-height: 250px">
  <source src="./assets/exercici003.mov" type="video/mp4">
</video>
</center>
<br/>

## Exercici 4

Fes un programa **exercici004.py** on al fer click amb el mouse, apareix un cercle amb radi 25 i color aleatòri i dins la següent llista de colors:
```python
GREEN = (127, 184, 68)
YELLOW = (240, 187, 64)
ORANGE = (226, 137, 50)
RED = (202, 73, 65)
PURPLE = (135, 65, 152)
BLUE  = (75, 154, 217)
colors = [GREEN, YELLOW, ORANGE, RED, PURPLE, BLUE]
```

Després, el radi del cercle es va fent més petit a un ritme de 5 pixels per segon fins a quedar d'una mida mínima de radi 5.

<center>
<video width="100%" controls allowfullscreen style="max-width: 90%; width: 400px; max-height: 250px">
  <source src="./assets/exercici004.mov" type="video/mp4">
</video>
</center>
<br/>

## Exercici 5

Fes un programa **exercici005.py** on es generen 10 cercles de diferents mides i colors aleatòriament. Aquests cercles cauràn de la part superior de la finestra fins a desaparèixer a la part inferior.

Els cercles representen globus i el jugador els ha d'explotar.

Quan el jugador passa el mouse per damunt d'un cercle, el cercle desapareix representant que el jugador ha explotat el globus.

A la part inferior esquerra de la finestra es mostra el número de globus explotats i el número de globus que caigut al final de la finestra.

Funcions recomanades:
**init_game()**
Inicia el joc amb un tauler de 10 globus

**init_baloon(balloon)**
Defineix els valors d'un globus:

- Una posició *x* aleatòria entre 10 i l'ample de la finestra -10
- La posició *y* a la part superior de la finestra
- Un color aleatòri d'una llista de colors
- El radi del cercle entre 5 i 15
- La velocitat de caiguda del globus = (radi * 2) + (numero de globus explotats)

**update_balloon(balloon, delta_time)**
Té dues finalitats:

- Actualitzar la posició de caiguda del globus segons la seva velocitat i el delta_time
- Detectar quan un globus arriba a la part inferior de la finestra i recalcular els seus valors amb "init_balloon"

<center>
<video width="100%" controls allowfullscreen style="max-width: 90%; width: 400px; max-height: 250px">
  <source src="./assets/exercici005.mov" type="video/mp4">
</video>
</center>
<br/>

## Exercici 6

Fes un programa **exercici006.py** on es dibuixa una graella que representa un tauler amb vaixells.

Cal fer servir els emojis: "🚢", "🌊", "💥" de la llibreria "assets.svgmoji.emojis". Per importar-la:
```python
from assets.svgmoji.emojis import get_emoji
```
Per carregar imatges que representen els emojis:
```python
img_ship = get_emoji(pygame, "🚢", size=CELL_SIZE)
```

El jugador podrà fer click a cel·les del tauler, si no hi ha res apareix l'icona d'aigua "🌊", si hi ha un vaixell es dibuixa una bomba a sobre d'aquest "💥" (mirar el video)

El tauler té els següents valors:

- "", una cadena de text buida si només es dibuixa el fons blau
- "S", (ship) si en aquella posició hi ha un vaixell
- "W", (water) si s'ha fet click a aquella cel·la però originalment era buida ""
- "B", (bomb) si s'ha fet click a aquella cel·la i originalment hi havia un vaixell "S"

Funcions recomanades:
**init_board(), iniciar el taulell**
Aquesta funció ha d'iniciar un taulell de 12 columnes i 8 files, on cada cel·la és de 50x50

El taulell ha de tenir:

- Un grup de 3 vaixells posats de costat horitzontalment
- Un grup de 4 vaixells posats de costat horitzontalment
- Un grup de 3 vaixells posats verticalment un al damunt de l'altre
- Els grups de vaixells no es poden tocar, hi ha d'haver almenys un espai entre ells

**draw_board(), iniciar el taulell**
Dibuixa el tauler segons:

- Si és "", és a dir no hi ha res, dibuixa un fons blau (100, 200, 255)
- Si és "S", és a dir hi ha un vaixell, dibuixa el fons blau i l'emoji (🚢)
- Si és "W", és a dir s'ha fet click a aigua, dibuixa el fons blau i l'emoji (🌊)
- Si és "B", és a dir hi havia un vaixell però ara és bomba, dibuixa el fons blau, el vaixell (🚢) i la bomba (💥)

**place_ship(x, y, length, direction), iniciar el taulell**
Afegeix al taulell, un grup de vaixells de mida *length* en direcció *direction*, a la posició *x*, *y*

**is_valid_position(x, y, length, direction)**
Diu si una posició és vàlida per afegir un grup de vaixells, comprova que al voltant dels limits les ce·les estiguin buides i retorna True o False

Finalment: **el tauler ha de quedar centrat a la finestra**

<center>
<video width="100%" controls allowfullscreen style="max-width: 90%; width: 400px; max-height: 250px">
  <source src="./assets/exercici006.mov" type="video/mp4">
</video>
</center>
<br/>

## Exercici 7

Fes un programa **exercici007.py** on dos botons sumen o resten el valor d'un comptador:

- La operació no es fa fins a l'event 'mouseup' dins del mateix botó
- Mentre hi ha el botó apretat, aquest es dibuixa amb un fons taronja (255, 165, 0)  

<center>
<video width="100%" controls allowfullscreen style="max-width: 90%; width: 400px; max-height: 250px">
  <source src="./assets/exercici007.mov" type="video/mp4">
</video>
</center>
<br/>

## Exercici 8

Fes un programa **exercici008.py** on dos botons canvien la direcció de moviment d'un cercle (amunt i avall):

- El canvi de direcció no es fa fins a l'event 'mouseup' dins del mateix botó
- Mentre hi ha el botó apretat, aquest es dibuixa amb un fons taronja (255, 165, 0)  
- El botó que marca la direcció es dibuixa amb un fons blau (100, 200, 255)

<center>
<video width="100%" controls allowfullscreen style="max-width: 90%; width: 400px; max-height: 250px">
  <source src="./assets/exercici008.mov" type="video/mp4">
</video>
</center>
<br/>

## Exercici 9

Fes un programa **exercici009.py** on quatre botons defineixen el valor d'un comptador *Hexadecimal* de 6 segments.

- El canvi de valor es fa a l'event 'mousedown' dins del mateix botó.



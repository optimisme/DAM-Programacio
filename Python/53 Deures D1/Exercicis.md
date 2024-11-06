
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

- La operació no es fa fins a l'event **'mouseup'** dins del mateix botó
- Mentre hi ha el botó apretat, aquest es dibuixa amb un fons taronja (255, 165, 0)  

<center>
<video width="100%" controls allowfullscreen style="max-width: 90%; width: 400px; max-height: 250px">
  <source src="./assets/exercici007.mov" type="video/mp4">
</video>
</center>
<br/>

## Exercici 8

Fes un programa **exercici008.py** on dos botons canvien la direcció de moviment d'un cercle (amunt i avall):

- El canvi de direcció no es fa fins a l'event **'mouseup'** dins del mateix botó
- Mentre hi ha el botó apretat, aquest es dibuixa amb un fons taronja (255, 165, 0)  
- El botó que marca la direcció es dibuixa amb un fons blau (100, 200, 255)

<center>
<video width="100%" controls allowfullscreen style="max-width: 90%; width: 400px; max-height: 250px">
  <source src="./assets/exercici008.mov" type="video/mp4">
</video>
</center>
<br/>

## Exercici 9

Fes un programa **exercici009.py** on quatre botons defineixen el valor d'un visualitzador *Hexadecimal* de [7 segments](https://ca.wikipedia.org/wiki/Visualitzador_de_set_segments) escollits a partir de 4 botons.

- El canvi de valor es fa a l'event **'mousedown'** dins del mateix botó.
- Sempre es dibuixen en gris tots els segments de color gris (215, 215, 215)
- A partir del número hexadecimal s'activen els segments per dibuixar: *0,1,2,3,4,5,6,7,8,9,a,b,c,d,e*

<br/>
<center>
<table>
  <tr>
    <td><img src="./assets/exercici009/hex_0.png" width="165"></td>
    <td><img src="./assets/exercici009/hex_1.png" width="165"></td>
    <td><img src="./assets/exercici009/hex_2.png" width="165"></td>
    <td><img src="./assets/exercici009/hex_3.png" width="165"></td>
  </tr>
  <tr>
    <td><img src="./assets/exercici009/hex_4.png" width="165"></td>
    <td><img src="./assets/exercici009/hex_5.png" width="165"></td>
    <td><img src="./assets/exercici009/hex_6.png" width="165"></td>
    <td><img src="./assets/exercici009/hex_7.png" width="165"></td>
  </tr>
  <tr>
    <td><img src="./assets/exercici009/hex_8.png" width="165"></td>
    <td><img src="./assets/exercici009/hex_9.png" width="165"></td>
    <td><img src="./assets/exercici009/hex_a.png" width="165"></td>
    <td><img src="./assets/exercici009/hex_b.png" width="165"></td>
  </tr>
  <tr>
    <td><img src="./assets/exercici009/hex_c.png" width="165"></td>
    <td><img src="./assets/exercici009/hex_d.png" width="165"></td>
    <td><img src="./assets/exercici009/hex_e.png" width="165"></td>
    <td><img src="./assets/exercici009/hex_f.png" width="165"></td>
  </tr>
</table>
</center>
<br/>

## Exercici 10

Fes un programa **exercici010.py** on hi hagi una serp, que segueix la posició del mouse i creix al *"menjar"* pomes. A mida que la serp creix, la velocitat a la que es mou és més ràpida.

<center>
<video width="100%" controls allowfullscreen style="max-width: 90%; width: 400px; max-height: 250px">
  <source src="./assets/exercici010.mov" type="video/mp4">
</video>
</center>
<br/>

Fes servir aquest objecte pr guardar la informació de la *"serp"* i la *"poma"*:
```python
snake = {
    "queue": [],
    "speed": 50,
    "radius": 7,
    "status": "follow_mouse", # "follow_mouse" or "orbit_mouse"
    "direction_angle": 0
}

piece = { # (food)
    "x": -1, 
    "y": -1, 
    "value": 0,
    "radius": 7
}  
```

Cal mostrar un resum amb:

- El nivell o pomes que ha menjat
- La llargada de la serp
- La velocitat

Aquestes són les condicions:

- La posició dels cercles que defineixen la llargada de la serp es guaden a *snake["queue"]*
- Els cercles més llunyans al cap de la serp es dibuixen d'un gris més clar
- La velocitat de la serp depèn de *delta_time* i creix *1.05* cada vegada que menja una poma, fins a un màxim de 200
- Les pomes es generen aleatòriament dins l'espai definit per la finestra amb un padding de 100 pixels horitzontals i verticals

Et caldràn les següents funcions:
```python
def init_game()
# Inicia el joc creant la primera peça si no existeix i col·locant la serp al centre de la pantalla amb una mida inicial de 5 segments.

def generate_piece()
# Genera una nova peça amb una posició i un valor aleatori dins dels límits de la finestra.

def extend_snake()
# Afegeix un segment addicional a la cua de la serp copiant l'última posició de la cua actual.

def move_snake(delta_time)
# Detecta si la serp ha xocat amb la peça, augmenta la velocitat i la longitud de la serp segons el valor de la peça, i genera una nova peça si cal. Calcula i actualitza la nova posició del cap de la serp i elimina l'últim segment per mantenir la longitud constant.

def get_next_snake_pos(delta_time)
# Resolta més avall
# Calcula la següent posició de la serp basant-se en la posició del ratolí i l'estat de la serp (seguint o orbitant el ratolí). Determina l'angle de direcció en funció de la distància i el pendent respecte al ratolí.

def draw_board()
# Mostra el nivell, la longitud de la serp, i la velocitat actual a la pantalla.

def draw_snake()
# Dibuixa la serp segment per segment, aplicant un efecte de lluminositat que varia segons la posició del segment dins la cua.

def draw_piece()
# Dibuixa la peça actual a la pantalla en color vermell, incloent-hi el seu valor al centre de la peça.
```


Fes servir aquesta funció per calcular la posició de la serp:
```python
def get_next_snake_pos(delta_time):
    global snake

    # Calcula la diferència en les coordenades entre el cap de la serp i el ratolí
    delta_x = mouse_pos['x'] - snake["queue"][0]['x']
    delta_y = mouse_pos['y'] - snake["queue"][0]['y']
   
    # Calcula la distància entre el cap de la serp i la posició del ratolí
    distancia = math.hypot(delta_x, delta_y)

    # Determina l'estat de la serp segons la distància al ratolí
    if distancia < 5:
        snake["status"] = 'orbit_mouse'  # Estat per orbitar prop del ratolí
    if distancia > 50:
        snake["status"] = 'follow_mouse'  # Estat per seguir el ratolí

    # Si la serp està en estat d'òrbita, 
    # augmenta l'angle de direcció per fer-la girar
    if snake["status"] == 'orbit_mouse':
        snake["direction_angle"] += distancia * math.pi / 1000
    else:
        # Calcula el pendent per obtenir l'angle; 
        # si delta_x és 0, s'estableix a infinit per evitar divisió per zero
        if delta_x != 0:
            pendent = delta_y / delta_x
        else:
            pendent = float('inf')

        # Calcula l'angle de direcció de la serp per seguir el ratolí
        if delta_x == 0 and mouse_pos['y'] < snake["queue"][0]['y']:
            # Angle per anar amunt (270 graus)
            snake["direction_angle"] = (3 * math.pi) / 2
        elif delta_x == 0 and mouse_pos['y'] >= snake["queue"][0]['y']:
            # Angle per anar avall (90 graus)
            snake["direction_angle"] = math.pi / 2
        elif mouse_pos['x'] > snake["queue"][0]['x']:
            # Angle per anar cap a la dreta 
            snake["direction_angle"] = math.atan(pendent)
        else:
            # Angle per anar cap a l'esquerra (180 graus)
            snake["direction_angle"] = math.atan(pendent) + math.pi

    return {
        "x": snake["queue"][0]['x'] + snake["speed"] * delta_time * math.cos(snake["direction_angle"]), 
        "y": snake["queue"][0]['y'] + snake["speed"] * delta_time * math.sin(snake["direction_angle"])
    }
```
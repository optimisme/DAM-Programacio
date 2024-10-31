
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

Fes un programa **exercici000.py** que dibuixi 20 rectangles centrats a la pantalla, simulant perspectiva.

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
    global finestra
    finestra["ample"] = screen.get_width()
    finestra["alt"] = screen.get_height()
    finestra["mig_x"] = int(screen.get_width() / 2)
    finestra["mig_y"] = int(screen.get_height() / 2)
```

A més, el color canvia a cada iteració amb **q * 10**.

- Els quadres parells són de color blau
- Els quadres senars de color verd
<br/>
<center><img src="./assets/exercici001.png" style="max-height: 400px" alt="">
<br/></center>
<br/>

## Exercici 2

Fes un programa **exercici000.py** on:

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


----


<center>
<video width="100%" controls allowfullscreen style="max-width: 90%; width: 400px; max-height: 250px">
  <source src="./assets/exercici010.mov" type="video/mp4">
</video>
</center>
<br/>

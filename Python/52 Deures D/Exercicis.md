
# Exercicis dibuix

Resol aquests exercicis, entrega la URL del projecte GitHub amb els exercicis resolts.

## Exercici 0

Fes un programa **exercici000.py** que fa el següent dibuix, a partir de dos bucles:

<br/>
<center><img src="./assets/exercici000.png" style="max-height: 400px" alt="">
<br/></center>
<br/>

- Els bucles es defineixen com **for q in range (0, len(colors))**

- Els colors del primer bucle s'obtenen de la següent llista
    colors = [(127, 184, 68), (240, 187, 64), (226, 137, 50), (202, 73, 65), (135, 65, 152), (75, 154, 217)]

- Els colors *grisos* s'obtenen dinàmicament des de (0, 0, 0) sumant 25 a cada iteració.

- La mida dels quadres és de 50 i els radis de la resta de polígons és de 25

- Necessitaràs la següent funció per dibuixar els triangles i pentàgons.

```pyton
def draw_polygon(screen, color, center, radius, num_vertices, angle_offset=(math.pi / 3)):
    points = [
        (
            center[0] + radius * math.cos(angle_offset + i * 2 * math.pi / num_vertices),
            center[1] + radius * math.sin(angle_offset + i * 2 * math.pi / num_vertices)
        )
        for i in range(num_vertices)
    ]
    pygame.draw.polygon(screen, color, points)
```

## Exercici 1

Fes un programa **exercici001.py** que fa el següent dibuix, fent servir bucles anidats:

```python
    for row in range(8):
        for column in range(8):
```

<br/>
<center><img src="./assets/exercici001.png" style="max-height: 400px" alt="">
<br/></center>
<br/>

## Exercici 2

Fes un programa **exercici002.py** que fa el següent dibuix, a partir de la següent matriu, on cada número de la matriu correspon a un color de la llista del primer exercici. 

```text
board = [
    [0, 1, 2, 3, 4, 5, 4, 3],
    [1, 2, 3, 4, 5, 4, 3, 2],
    [2, 3, 4, 5, 4, 3, 2, 1],
    [3, 4, 5, 4, 3, 2, 1, 0],
    [4, 5, 4, 3, 2, 1, 0, 1],
    [5, 4, 3, 2, 1, 0, 1, 2],
    [4, 3, 2, 1, 0, 1, 2, 3],
    [3, 2, 1, 0, 1, 2, 3, 4],
]
```

<br/>
<center><img src="./assets/exercici002.png" style="max-height: 400px" alt="">
<br/></center>
<br/>

## Exercici 3

Fes un programa **exercici003.py** que fa el següent dibuix, a partir de la següent llista de dades.

- Fes un fons blanc per la taula d'informació
- Dibuixa les linies horitzontals de cada fila en un bucle
- La tipografia és "Arial" però pel nom és 18 i els detalls 16
- El color blau es correspon a (50, 120, 200)
- Els textos estàn desplacats 5 pixels horitzontals i 2 verticals

```text
dades = [ 
  {'nom': 'Pelut', 'any': 2018, 'pes': 6.5, 'especie': 'Gos'},
  {'nom': 'Pelat', 'any': 2020, 'pes': 5.0, 'especie': 'Gos'},
  {'nom': 'Mia', 'any': 2022, 'pes': 3.0, 'especie': 'Gat'},
  {'nom': 'Nemo', 'any': 2003, 'pes': 0.1, 'especie': 'Peix'},
  {'nom': 'Mickey', 'any': 1928, 'pes': 0.5, 'especie': 'Ratolí'},
  {'nom': 'Donald', 'any': 1934, 'pes': 0.5, 'especie': 'Ànec'} ]
```

<br/>
<center><img src="./assets/exercici003.png" style="max-height: 400px" alt="">
<br/></center>
<br/>

## Exercici 4

Fes un programa **exercici004.py** que fa el següent dibuix,
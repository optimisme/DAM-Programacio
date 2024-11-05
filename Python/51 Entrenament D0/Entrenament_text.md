# Entrenament Text

Farem un quadre d'entrada de text amb **pygame**

## Exercici 0

A partir d'aquest diccionari:
```python
input_box = {
    "x": 100,
    "y": 200,
    "width": 200,
    "height": 32,
    "text": "",
    "focused": False
}
```

Dibuixa un quadre amb les mides anteriors, el text és el text que es dibuixa dins el quadre. Quan l'atribut "focused" és true el contorn es dibuixa de color blau, sinó es dibuixa de color gris fosc.

## Exercici 1

A **app_events** fes que quan s'apreta amb el mouse dins del quadre definit per "input_box", l'atribut "focused" es posi a True. En canvi, que es posi a False si s'ha fet click fora del quadre.

## Exercici 2

A **app_events** fes que si l'atribut "focused" està a True, i l'usuari escriu amb les tecles del teclat:

- S'afegeix la lletra escrita a l'atribut "text"
- Si l'usuari apreta pygame.K_BACKSPACE s'esborra la última lletra del text

Comprova que la lletra és vàlida per afegir-la al text amb:
```python
event.unicode.isprintable() and event.unicode not in "`´^¨~"
```

## Exercici 3

Implementa un cursor a partir d'aquest diccionari:
```python
cursor = {
    "visible": True,
    "timer": 0,
    "position": 0
}
```

El cursor s'ha de dibuixar a la última posició del text, per saber quina és, medeix el text així:
```python
text_width = font.size(input_box["text"])[0]
```
El dibuix del cursor és una linia vertical a la posició del requadre amb un "padding" de 5

## Exercici 4

Fes que la funció **app_run** sumi un 1 a l'atribut "timer" del cursor, quan el "timer" arriba a 30 es torna a posar a 0.

Fes que la funció **app_run** canvii el valor de l'atribut "visible" cada vegada que el timer arriba a 30.

El cursor es dibuixa (o no es dibuixa) segons el valor de l'atibut "visible" del cursor


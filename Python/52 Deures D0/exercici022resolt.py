#!/usr/bin/env python3

import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
BLUE = (50, 120, 200)
BROWN = (165, 42, 42)  
YELLOW = (255, 255, 0)  
GREEN = (0, 255, 0)  

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Definir variables globals
mouse_pos = { "x": -1, "y": -1 }
heights = [0] * 22 # 22 caselles

# Bucle de l'aplicació
def main():
    is_looping = True

    while is_looping:
        is_looping = app_events()
        app_run()
        app_draw()

        clock.tick(60) # Limitar a 60 FPS

    # Fora del bucle, tancar l'aplicació
    pygame.quit()
    sys.exit()

# Gestionar events
def app_events():
    global mouse_pos
    mouse_inside = pygame.mouse.get_focused() # El ratolí està dins de la finestra?

    for event in pygame.event.get():
        if event.type == pygame.QUIT: # Botó tancar finestra
            return False
        elif event.type == pygame.MOUSEMOTION:
            if mouse_inside:
                mouse_pos["x"] = event.pos[0]
                mouse_pos["y"] = event.pos[1]
            else:
                mouse_pos["x"] = -1
                mouse_pos["y"] = -1
    return True

# Fer càlculs
def app_run():
    global heights

    cell_width = 25  # Amplada de cada casella
    cell_height = 50  # Altura de cada casella

    # Bucle 1: Comprovar si el ratolí està dins de qualsevol casella
    inside_any_cell = False
    for cnt in range(len(heights)):
        # Posició horitzontal de la casella
        cell_x = 50 + cnt * cell_width
        cell_y_top = 250 - heights[cnt]
        cell_y_bottom = 250

        # Comprovar si el ratolí està dins dels límits d'aquesta casella
        if cell_x <= mouse_pos["x"] < (cell_x + cell_width) and cell_y_top <= mouse_pos["y"] < cell_y_bottom:
            inside_any_cell = True
            break  # Sortir del bucle si ja hem trobat una casella que conté el ratolí

    # Bucle 2: Assignar les alçades segons si el ratolí està dins o fora d'una casella
    for cnt in range(len(heights)):
        cell_x = 50 + cnt * cell_width + (cell_width / 2)  # Centre horitzontal

        if inside_any_cell:
            # Calcular la distància horitzontal
            distance = abs(cell_x - mouse_pos["x"])

            # Normalitzar la distància: propers a mida 50, llunyans a 5
            max_distance = 200  # Distància màxima per al mínim efecte
            heights[cnt] = max(5, 45 - min(distance, max_distance) * (40 / max_distance))
        else:
            # Si el ratolí no està dins de cap casella, fixar totes les alçades a 5
            heights[cnt] = 5

# Dibuixar
def app_draw():
    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Graella de fons
    utils.draw_grid(pygame, screen, 50)

    # Dibuixar cada casella amb una alçada basada en la distància
    for cnt in range(len(heights)):
        x = 50 + cnt * 25
        height = 5 + heights[cnt] # Alçada en funció de la distància
        y = 250 - height           # Ajustar perquè creixi cap amunt
        pygame.draw.rect(screen, BLACK, (x, y, 25, height))

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

if __name__ == "__main__":
    main()
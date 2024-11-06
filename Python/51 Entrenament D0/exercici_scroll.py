#!/usr/bin/env python3

import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
GRAY = (200, 200, 200)
YELLOW = (255, 255, 70)
RED = (255, 0, 0)
GREEN = (0, 255, 0)

BUTTON_SIZE = 20

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Variables globals
font = pygame.font.SysFont("Arial", 24)

mouse = { 
    "x": -1, 
    "y": -1,
    "pressed": False
}

scroll = {
    "percentage": 0,
    "dragging": False,
    "x": 400,
    "y": 100,
    "width": 5,
    "height": 200,
    "radius": 10,
    "surface_offset": 0,
    "visible_height": 200
}

# TODO: Superficie de 320x500

# Bucle de l'aplicació
def main():
    is_looping = True

    # TODO: Fer un dibuix a la surface 
    # (fons gris dues linies en forma de creucreu)

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
    global mouse
    mouse_inside = pygame.mouse.get_focused()  # El ratolí està dins de la finestra?

    for event in pygame.event.get():
        if event.type == pygame.QUIT:  # Botó tancar finestra
            return False
        elif event.type == pygame.MOUSEMOTION:
            if mouse_inside:
                mouse["x"], mouse["y"] = event.pos
        elif event.type == pygame.MOUSEBUTTONDOWN:
            mouse["pressed"] = True
        elif event.type == pygame.MOUSEBUTTONUP:
            mouse["pressed"] = False
    return True

# Fer càlculs
def app_run():
    global scroll

    # TODO: Comprovar si el mouse ha fet click dins del cercle i iniciar l'arrossegament
    # definir scroll["dragging"]
    # si s'està arrossegant, atualitzar la posició del cercle
    # aturar l'arrosegament quan s'aixeca el botó del mouse

    # TODO: Calcular la posició "y" de dibuix de la superfície
    # scroll["surface_offset"] = int((scroll["percentage"] / 100) * (surface.get_height() - scroll["visible_height"]))

# Dibuixar
def app_draw():
    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar la graella
    utils.draw_grid(pygame, screen, 50)

    # TODO: Dibuixar la subimatge desplaçada de la surface    
    # sub_surface = surface.subsurface((0, scroll["surface_offset"], surface.get_width(), scroll["visible_height"]))
    # screen.blit(sub_surface, (50, 100))

    # Dibuixar l'scroll
    draw_scroll()

    # Actualitzar el dibuix a la finestra
    pygame.display.update()


def draw_scroll():
    pass

if __name__ == "__main__":
    main()


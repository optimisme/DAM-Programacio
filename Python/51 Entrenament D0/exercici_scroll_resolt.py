#!/usr/bin/env python3

import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
GRAY = (100, 100, 100)
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

surface = pygame.Surface((320, 500))

# Bucle de l'aplicació
def main():
    is_looping = True

    # Fer un dibuix a la surface (creu)
    surface.fill((200, 200, 200))  
    pygame.draw.line(surface, RED, (0, 0), (surface.get_width(), surface.get_height()), 5) 
    pygame.draw.line(surface, GREEN, (0, surface.get_height()), (surface.get_width(), 0), 5)

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

    # Comprovar si el mouse ha fet click dins del cercle i iniciar l'arrossegament
    circle_center = {
        "x": int(scroll["x"] + scroll["width"] / 2),
        "y": int(scroll["y"] + (scroll["percentage"] / 100) * scroll["height"])
    }

    if mouse["pressed"] and not scroll["dragging"] and utils.is_point_in_circle(mouse, circle_center, scroll["radius"]):
        scroll["dragging"] = True

    # Si s'està arrossegant, actualitzar la posició del cercle
    if scroll["dragging"]:
        # Calcular el nou percentatge en funció de la posició del mouse dins de l'àrea de l'scroll
        relative_y = max(min(mouse["y"], scroll["y"] + scroll["height"]), scroll["y"])
        scroll["percentage"] = ((relative_y - scroll["y"]) / scroll["height"]) * 100

    # Aturar l'arrossegament quan s'aixeca el botó del mouse
    if not mouse["pressed"]:
        scroll["dragging"] = False

    # Calcular la posició "y" de dibuix de la superfície
    scroll["surface_offset"] = int((scroll["percentage"] / 100) * (surface.get_height() - scroll["visible_height"]))

# Dibuixar
def app_draw():
    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar la graella
    utils.draw_grid(pygame, screen, 50)

    # Dibuixar la subimatge desplaçada de la surface    
    sub_surface = surface.subsurface((0, scroll["surface_offset"], surface.get_width(), scroll["visible_height"]))
    screen.blit(sub_surface, (50, 100))

    # Dibuixar l'scroll
    draw_scroll()

    # Actualitzar el dibuix a la finestra
    pygame.display.update()


def draw_scroll():
    rect_tuple = (scroll["x"], scroll["y"], scroll["width"], scroll["height"])
    pygame.draw.rect(screen, GRAY, rect_tuple)
    circle_x = int(scroll["x"] + scroll["width"] / 2)
    circle_y = int(scroll["y"] + (scroll["percentage"] / 100) * scroll["height"])
    circle_tuple = (circle_x, circle_y)
    pygame.draw.circle(screen, BLACK, circle_tuple, scroll["radius"])

if __name__ == "__main__":
    main()
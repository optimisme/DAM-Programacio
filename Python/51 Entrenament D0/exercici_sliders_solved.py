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

sliders = [
    { "value": 128, "x": 100, "y": 200, "width": 200, "height": 5, "dragging": False, "radius": 10 },
    { "value": 128, "x": 100, "y": 250, "width": 200, "height": 5, "dragging": False, "radius": 10 },
    { "value": 128, "x": 100, "y": 300, "width": 200, "height": 5, "dragging": False, "radius": 10 }
]

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
    global sliders

    # Comprovar si algun slider està fent dragging
    any_is_dragging = False
    for slider in sliders:
        if slider["dragging"]:
            any_is_dragging = True
            break

    # Comprovar si cal començar o acabar el dragging
    for slider in sliders:
        # Obtenir la posició del cercle a partir del valor
        circle_x = slider["x"] + (slider["value"] / 255) * slider["width"]
        circle_center = { "x": circle_x, "y": slider["y"] + int(slider["height"] / 2) }

        # Detectar si el ratolí està sobre el cercle només en el moment de clickar
        if mouse["pressed"]:
            # Només iniciar el dragging si cap altre slider està arrossegant-se
            if not any_is_dragging:  
                slider["dragging"] = utils.is_point_in_circle(mouse, circle_center, slider["radius"])
        else:
            slider["dragging"] = False

        # Actualitzar el valor a partir de la posició
        if slider["dragging"]:
            relative_x = max(slider["x"], min(mouse["x"], slider["x"] + slider["width"]))
            slider["value"] = int((relative_x - slider["x"]) / slider["width"] * 255)

# Dibuixar
def app_draw():
    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar la graella
    utils.draw_grid(pygame, screen, 50)

    # Dibuixar els sliders
    for slider in sliders:
        draw_slider(slider)
        draw_value(slider)

    # Dibuixar color
    rect_tuple = (400, 200, 200, 100)
    color = (sliders[0]["value"], sliders[1]["value"], sliders[2]["value"])
    pygame.draw.rect(screen, color, rect_tuple)

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

def draw_slider(slider):
    rect_tuple = (slider["x"], slider["y"], slider["width"], slider["height"])
    pygame.draw.rect(screen, GRAY, rect_tuple)
    circle_x = int(slider["x"] + (slider["value"] / 255) * slider["width"])
    circle_y = int(slider["y"] + slider["height"] / 2)
    circle_tuple = (circle_x, circle_y)
    pygame.draw.circle(screen, BLACK, circle_tuple, slider["radius"])

def draw_value(slider):
    x = slider["x"] + slider["width"] + 15
    text = font.render(str(slider["value"]), True, BLACK)
    screen.blit(text, (x, slider["y"] - 12))

if __name__ == "__main__":
    main()
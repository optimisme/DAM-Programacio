#!/usr/bin/env python3

import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

# Definir colors
WHITE = (255, 255, 255)
GRAY = (128, 128, 128)  
BLACK = (0, 0, 0)
RED = (255, 0, 0)
GREEN = (0, 255, 0)
BLUE  = (0, 0, 255)
PURPLE = (128, 0, 128)
ORANGE = (255, 165, 0)  

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Posició del mouse
mouse_pos = { "x": -1, "y": -1 }
mouse_down = False

# Si fem click al rectangle o al cercle
square_clicked = False
circle_clicked = False

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
    global mouse_pos, mouse_down
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
        elif event.type == pygame.MOUSEBUTTONDOWN:
            mouse_down = True
        elif event.type == pygame.MOUSEBUTTONUP:
            mouse_down = False
    return True

# Fer càlculs
def app_run():
    global mouse_pos, mouse_down, square_clicked, circle_clicked

    if mouse_down:
        rectangle = { "x": 100, "y": 150, "width": 200, "height": 50 }
        if utils.is_point_in_rect(mouse_pos, rectangle):
            square_clicked = True

        center = { "x": 400, "y": 175 }
        if utils.is_point_in_circle(mouse_pos, center, 50):
            circle_clicked = True

    else:
        square_clicked = False
        circle_clicked = False

# Dibuixar
def app_draw():
    global square_clicked, circle_clicked

    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar la graella
    utils.draw_grid(pygame, screen, 50)

    # Dibuixar text d'ajuda
    font = pygame.font.SysFont("Arial", 24)
    text = font.render('Fes click als objectes', True, BLACK)
    screen.blit(text, (50, 50))

    # Quadre i cercle
    color = BLACK
    if square_clicked:
        color = BLUE
    pygame.draw.rect(screen, color, (100, 150, 200, 50))

    color = BLACK
    if circle_clicked:
        color = GREEN
    pygame.draw.circle(screen, color, (400, 175), 50)

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

if __name__ == "__main__":
    main()
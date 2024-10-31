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

# Direcció del moviment
dir_x = "none"

# Posició de l'objecte
pos_x = 100
size = 25

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
    global dir_x, dir_y

    for event in pygame.event.get():
        if event.type == pygame.QUIT: # Botó tancar finestra
            return False
        elif event.type == pygame.KEYDOWN:  # Tecla premuda
            if event.key == pygame.K_LEFT:
                dir_x = 'left'
            elif event.key == pygame.K_RIGHT:
                dir_x = 'right'
        elif event.type == pygame.KEYUP:  # Tecla alliberada
            if event.key == pygame.K_LEFT:
                if dir_x == 'left':
                    dir_x = 'none'
            elif event.key == pygame.K_RIGHT:
                if dir_x == 'right':
                    dir_x = 'none'
    return True

# Fer càlculs
def app_run():
    global dir_x, pos_x, size

    delta_time = clock.get_time() / 1000.0  # Convertir a segons
    
    speed = 100  # píxels per segon
    displacement = speed * delta_time

    limit_left = size
    limit_right = screen.get_width() - size

    if (dir_x == "right"):
        pos_x = pos_x + displacement
        if (pos_x > limit_right):
            pos_x = limit_right
    elif (dir_x == "left"):
        pos_x = pos_x - displacement
        if (pos_x < limit_left):
            pos_x = limit_left

    size = 10 + (pos_x / 8)

# Dibuixar
def app_draw():
    global pos_x, pos_y

    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar la graella
    utils.draw_grid(pygame, screen, 50)

    # Text informatiu
    font = pygame.font.SysFont("Arial", 24)
    text = font.render('Apreta les tecles (left/right)', True, BLACK)
    screen.blit(text, (50, 50))

    # Dibuixar el cercle
    center = (pos_x, 250)
    pygame.draw.circle(screen, BLACK, center, size)
    
    # Actualitzar el dibuix a la finestra
    pygame.display.update()

if __name__ == "__main__":
    main()
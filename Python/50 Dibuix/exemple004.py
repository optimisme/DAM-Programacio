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

# Definir una superfície de dibuix
surface = pygame.Surface((320, 240), pygame.SRCALPHA)  
surface.fill((200, 200, 200)) # Fons gris

# Bucle de l'aplicació
def main():
    global font, text, image

    is_looping = True

    # Dibuixar una creu a la superfície
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
    for event in pygame.event.get():
        if event.type == pygame.QUIT: # Botó tancar finestra
            return False
    return True

# Fer càlculs
def app_run():
    pass

# Dibuixar
def app_draw():
    
    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar la graella
    utils.draw_grid(pygame, screen, 50)

    # Dibuixar la superfície
    screen.blit(surface, (50, 100)) 

    # Dibuixar només una porció de la superfície
    # Rectangle de tall: (x, y, width, height)
    clip_rect = pygame.Rect(50, 50, 100, 100)
    screen.blit(surface, (400, 100), clip_rect) 

    # Actualitzar el dibuix a la finestra
    pygame.display.update()


if __name__ == "__main__":
    main()
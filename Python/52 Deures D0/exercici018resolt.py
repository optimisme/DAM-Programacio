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

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

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

    # Dibuixar les dades
    for angle in range(0, 361, 15):
        # Calcular els punts de la línia actual
        x0, y0 = utils.point_on_circle((300, 250), 25, angle)
        x1, y1 = utils.point_on_circle((300, 250), 150, angle)
        
        # Calcular els punts de la línia anterior
        prev_angle = angle - 15
        x_prev_0, y_prev_0 = utils.point_on_circle((300, 250), 25, prev_angle)
        x_prev_1, y_prev_1 = utils.point_on_circle((300, 250), 150, prev_angle)

        # Crear un color segons l'angle (opcional, per donar variació de color)
        color = utils.hsl_to_rgb(angle, 1.0, 0.5)
        
        # Dibuixar el polígon que omple l'espai entre les dues línies consecutives
        pygame.draw.polygon(screen, color, [(x0, y0), (x1, y1), (x_prev_1, y_prev_1), (x_prev_0, y_prev_0)])


    # Actualitzar el dibuix a la finestra
    pygame.display.update()

if __name__ == "__main__":
    main()
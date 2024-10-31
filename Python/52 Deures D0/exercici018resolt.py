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
    center = {"x": 300, "y": 250}
    
    for angle in range(0, 361, 15):
        # Calculate current line points
        p0 = utils.point_on_circle(center, 25, angle)
        p1 = utils.point_on_circle(center, 150, angle)
        
        # Calculate previous line points
        prev_angle = angle - 15
        prev_0 = utils.point_on_circle(center, 25, prev_angle)
        prev_1 = utils.point_on_circle(center, 150, prev_angle)

        # Create color based on angle (optional, for color variation)
        color = utils.hsl_to_rgb(angle, 1.0, 0.5)
        
        # Convert dictionary points to tuples for pygame
        points = [
            (int(p0["x"]), int(p0["y"])),
            (int(p1["x"]), int(p1["y"])),
            (int(prev_1["x"]), int(prev_1["y"])),
            (int(prev_0["x"]), int(prev_0["y"]))
        ]
        
        # Draw polygon between consecutive lines
        pygame.draw.polygon(screen, color, points)


    # Actualitzar el dibuix a la finestra
    pygame.display.update()

if __name__ == "__main__":
    main()
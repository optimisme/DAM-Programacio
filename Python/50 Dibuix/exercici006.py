import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
BLUE = (0, 0, 255)
GREEN = (0, 255, 0)

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Matriu
mat = []

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
    global mat
    pass

# Fer càlculs
def app_run():
    global mat
    pass

# Dibuixar
def app_draw():
    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar la graella
    utils.draw_grid(pygame, screen, 50)

    # Dibuixar el tauler (a partir de mat)
    pass

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

def is_point_in_circle(point, center, r):
    distancia = math.sqrt((point["x"] - center["x"]) ** 2 + (point["y"] - center["y"]) ** 2)
    return distancia <= r

if __name__ == "__main__":
    main()

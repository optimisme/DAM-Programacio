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

    # Dibuixar la graella de coordenades (llibreria utils)
    utils.draw_grid(pygame, screen, 50)

    # Dibuixar un rectangle vermell a la posició (150, 200) de mida (75, 100)
    pygame.draw.rect(screen, RED, pygame.Rect(150, 200, 75, 100))

    # Dibuixar un cercle verd a la posició (100, 150) de radi 10
    pygame.draw.circle(screen, GREEN, (100, 150), 50)

    # Dibuixar una linia des de l'origen del rectangle fins al centre del cercle
    pygame.draw.line(screen, BLUE, (150, 200), (100, 150), 5)

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

if __name__ == "__main__":
    main()
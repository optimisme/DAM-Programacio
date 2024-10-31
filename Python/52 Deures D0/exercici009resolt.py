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

# Definir les dades
dades = [ 
  {'nom': 'Pelut', 'any': 2018, 'pes': 6.5, 'especie': 'Gos'},
  {'nom': 'Pelat', 'any': 2020, 'pes': 5.0, 'especie': 'Gos'},
  {'nom': 'Mia', 'any': 2022, 'pes': 3.0, 'especie': 'Gat'},
  {'nom': 'Nemo', 'any': 2003, 'pes': 0.1, 'especie': 'Peix'},
  {'nom': 'Mickey', 'any': 1928, 'pes': 0.5, 'especie': 'Ratolí'},
  {'nom': 'Donald', 'any': 1934, 'pes': 0.5, 'especie': 'Ànec'} ]

font0 = pygame.font.SysFont("Arial", 18)
font1 = pygame.font.SysFont("Arial", 16)

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

    # Dibuixar el fons de la taula
    back = (150, 100, 200, 25 * len(dades))
    pygame.draw.rect(screen, WHITE, back)

    # Dibuixar les linies de les files
    for row_line in range(0, len(dades) + 1):
        y = 100 + row_line * 25
        pygame.draw.line(screen, BLACK, (150, y), (350, y), 2)

    # Dibuixar les dades
    for pos in range(len(dades)):
        item = dades[pos]
        y = 100 + pos * 25 + 2

        textNom = font0.render(item["nom"], True, BLACK)
        screen.blit(textNom, (155, y + 2))

        textAny = font1.render(str(item["any"]), True, BLUE)
        screen.blit(textAny, (255, y + 2))

        textEspecie = font1.render(str(item["especie"]), True, BLUE)
        screen.blit(textEspecie, (305, y + 2))

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

if __name__ == "__main__":
    main()
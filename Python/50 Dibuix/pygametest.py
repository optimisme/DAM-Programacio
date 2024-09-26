#!/usr/bin/env python3

# pip install pygame
# python3 -m pip install pygame --break-system-package


import pygame
import sys

# Inicialitzar Pygame
pygame.init()

# Configurar la pantalla
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Hello World!')

# Definir els colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
GREEN = (0, 255, 0)
BLUE = (0, 0, 255)

# Configurar la font
font = pygame.font.SysFont(None, 55)

# Crear el text
text = font.render('Hello World!', True, BLACK)

# Bucle principal
while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

    # Omplir la pantalla de blanc
    screen.fill(WHITE)

    # Dibuixar el text a la pantalla
    screen.blit(text, (200, 200))

    # Dibuixar un cercle blau
    pygame.draw.circle(screen, BLUE, (320, 240), 50)  # Centre (320, 240), radi 50

    # Dibuixar un rectangle verd
    pygame.draw.rect(screen, GREEN, (100, 100, 150, 100))  # Posició (100, 100), ample 150, alçada 100

    # Actualitzar la pantalla
    pygame.display.update()

import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
GRAY = (200, 200, 200)
PINK = (255, 105, 180)
GREEN = (0, 255, 0)
BLUE = (0, 0, 255)
RED = (255, 0, 0)

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
    screen.fill(WHITE)
    utils.draw_grid(pygame, screen, 50)
    
    # Dibuixar el quadre rosa
    pygame.draw.rect(screen, PINK, (150, 200, 50, 50), 5)
    
    # Dibuixar el triangle verd
    pygame.draw.polygon(screen, GREEN, [(275, 200), (275 - 28, 248), (275 + 28, 248)], 5)
    
    # Dibuixar la creu blava
    pygame.draw.line(screen, BLUE, (350, 200), (400, 250), 5)
    pygame.draw.line(screen, BLUE, (350, 250), (400, 200), 5)
    
    # Dibuixar la rodona vermella
    pygame.draw.circle(screen, RED, (475, 225), 25, 5)

    pygame.display.update()

if __name__ == "__main__":
    main()
import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED = (200, 0, 0)

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
    global im_shinnosuke

    screen.fill(WHITE)
    utils.draw_grid(pygame, screen, 50)
    
    # Bucle cercles
    odd = True
    for cnt in range(225, 0, -25):
        if odd:
            color = RED
        else:
            color = WHITE
        
        pygame.draw.circle(screen, color, (350, 250), cnt)
        odd = not odd

    # Bucle Relleus
    for cnt in range(25, 250, 25):
        pygame.draw.circle(screen, BLACK, (350, 250), cnt, 5)

    pygame.display.update()

if __name__ == "__main__":
    main()
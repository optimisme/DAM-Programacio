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
YELLOW = (255, 255, 0)
GREEN = (0, 255, 0)
BLUE = (50, 150, 255)
RED = (255, 0, 0)

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Variables globals
mouse_pos = { "x": -1, "y": -1 }
finestra = { "ample": 0, "alt": 0, "mig_x": 0, "mig_y": 0 }

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
    global mouse_pos
    mouse_inside = pygame.mouse.get_focused() # El ratolí està dins de la finestra?

    for event in pygame.event.get():
        if event.type == pygame.QUIT: # Botó tancar finestra
            return False
        elif event.type == pygame.MOUSEMOTION:
            if mouse_inside:
                mouse_pos["x"] = event.pos[0]
                mouse_pos["y"] = event.pos[1]
            else:
                mouse_pos["x"] = -1
                mouse_pos["y"] = -1
    return True

# Fer càlculs
def app_run():
    global finestra

    finestra["ample"] = screen.get_width()
    finestra["alt"] = screen.get_height()
    finestra["mig_x"] = int(screen.get_width() / 2)
    finestra["mig_y"] = int(screen.get_height() / 2)

# Dibuixar
def app_draw():
    screen.fill(WHITE)
    utils.draw_grid(pygame, screen, 50)
    
    # Dibuixar botons
    
    
    pygame.display.update()


if __name__ == "__main__":
    main()
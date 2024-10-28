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

# Posició del mouse
mouse_pos = (-1, -1)

# Posició de l'ull esquerra
eye_left = { "x": 200, "y": 200 }
eye_right = { "x": 400, "y": 200 }

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
                mouse_pos = event.pos
            else:
                mouse_pos = (-1, -1)
    return True

# Fer càlculs
def app_run():
    global mouse_pos, eye_left, eye_right
    pass

# Dibuixar
def app_draw():
    global mouse_pos, eye_left, eye_left

    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar la graella
    utils.draw_grid(pygame, screen, 50)

    # Draw face
    pygame.draw.ellipse(screen, ORANGE, pygame.Rect(175, 50, 300, 400))

    # Draw smile
    pygame.draw.arc(screen, RED, pygame.Rect(200, 300, 300, 100), math.radians(180), math.radians(270), 5)

    # Draw eyes
    pygame.draw.rect(screen, BLACK, pygame.Rect(eye_left["x"], eye_left["y"], 15, 15))
    pygame.draw.rect(screen, BLACK, pygame.Rect(eye_right["x"], eye_right["y"], 15, 15))

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

if __name__ == "__main__":
    main()
import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

# Definir colors
WHITE = (255, 255, 255)
GRAY = (128, 128, 128)  
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
mouse_pos = { "x": -1, "y": -1 }

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
                mouse_pos["x"] = event.pos[0]
                mouse_pos["y"] = event.pos[1]
            else:
                mouse_pos["x"] = -1
                mouse_pos["y"] = -1
    return True

# Fer càlculs
def app_run():
    global mouse_pos, eye_left, eye_right

    eye_left["x"] = mouse_pos["x"] - 10
    if (eye_left["x"] < 250):
        eye_left["x"] = 250
    elif (eye_left["x"] > 280):
        eye_left["x"] = 280

    eye_left["y"] = mouse_pos["y"] - 10
    if (eye_left["y"] < 150):
        eye_left["y"] = 150
    elif (eye_left["y"] > 205):
        eye_left["y"] = 205

    eye_right["x"] = mouse_pos["x"] - 10
    eye_right["y"] = mouse_pos["y"] - 10

# Dibuixar
def app_draw():
    global eye_left, eye_left

    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar la graella
    utils.draw_grid(pygame, screen, 50)

    # Draw face
    pygame.draw.ellipse(screen, ORANGE, (175, 50, 300, 400))

    # Draw nose
    pygame.draw.arc(screen, GRAY, (300, 275, 50, 25), math.radians(0), math.radians(180), 5)

    # Draw smile
    pygame.draw.arc(screen, RED, (250, 300, 150, 100), math.radians(180), math.radians(0), 5)

    # Draw eyes back
    pygame.draw.rect(screen, WHITE, (250, 150, 50, 75))
    pygame.draw.rect(screen, WHITE, (350, 150, 50, 75))

    # Draw eyes
    pygame.draw.rect(screen, BLACK, (eye_left["x"], eye_left["y"], 20, 20))
    pygame.draw.rect(screen, BLACK, (eye_right["x"], eye_right["y"], 20, 20))

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

if __name__ == "__main__":
    main()
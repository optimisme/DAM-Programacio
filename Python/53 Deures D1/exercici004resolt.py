import random
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
GREEN = (127, 184, 68)
YELLOW = (240, 187, 64)
ORANGE = (226, 137, 50)
RED = (202, 73, 65)
PURPLE = (135, 65, 152)
BLUE  = (75, 154, 217)
colors = [GREEN, YELLOW, ORANGE, RED, PURPLE, BLUE]

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Variables globals
mouse_pos = { "x": -1, "y": -1 }
dots = []

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
        elif event.type == pygame.MOUSEBUTTONDOWN:
            dots.append({ 
                "x": mouse_pos["x"],
                "y": mouse_pos["y"],
                "radius": 25,
                "color": random.choice(colors)
            })
    return True

# Fer càlculs
def app_run():
    global dots

    delta_time = clock.get_time() / 1000.0  # Convertir a segons

    speed = 5 

    for dot in dots:
        dot["radius"] = dot["radius"] - speed * delta_time
        if dot["radius"] < 5:
            dot["radius"] = 5

# Dibuixar
def app_draw():
    screen.fill(WHITE)
    utils.draw_grid(pygame, screen, 50)
    
    # Dibuixar punts
    for dot in dots:
        center = (dot["x"], dot["y"])
        pygame.draw.circle(screen, dot["color"], center, dot["radius"])

    pygame.display.update()

if __name__ == "__main__":
    main()
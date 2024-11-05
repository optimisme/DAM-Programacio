#!/usr/bin/env python3

import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import random
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

# Inicialitzar pygame
pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480), pygame.RESIZABLE)
pygame.display.set_caption('Window Title')

# Variables globals del joc
font = pygame.font.SysFont("Arial", 18)
window_size = { 
    "width": 0, 
    "height": 0, 
    "center": {
        "x": 0,
        "y": 0
    } 
}
mouse_pos = { "x": -1, "y": -1 }

balloons_list = []
balloons_dropped = 0
balloons_caught = 0

# Bucle principal de l'aplicació
def main():
    init_game()
    is_looping = True

    while is_looping:
        is_looping = app_events()
        app_run()
        app_draw()

        clock.tick(60) # Limitar a 60 FPS

    # Fora del bucle, tancar l'aplicació
    pygame.quit()
    sys.exit()

# Gestionar esdeveniments
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

# Actualitzar lògica del joc
def app_run():
    global mouse_pos, balloons_list, balloons_caught

    set_window_size()
    delta_time = clock.get_time() / 1000.0  # Convertir a segons

    for balloon in balloons_list:
        update_balloon(balloon, delta_time)
        collision = utils.is_point_in_circle(mouse_pos, balloon, balloon["radius"])
        if collision:
            balloons_caught += 1
            init_balloon(balloon)

# Dibuixar elements a la pantalla
def app_draw():
    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar estadístiques
    display_stats()

    # Dibuixar els globus
    for balloon in balloons_list:
        draw_balloon(balloon)

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

# Estableix les mides de la finestra
def set_window_size():
    global window_size

    window_size["width"] = screen.get_width()
    window_size["height"] = screen.get_height()
    window_size["center"]["x"] = int(screen.get_width() / 2)
    window_size["center"]["y"] = int(screen.get_height() / 2)

# Iniciar el joc
def init_game():
    global balloons_list, balloons_dropped, balloons_caught
    balloons_list = []
    balloons_dropped = 0
    balloons_caught = 0

    set_window_size()

    # Afegir 10 globus a la llista de globus
    for i in range(10):
        balloon = {'x': 0, 'y': 0, 'color': '', 'radius': 10, 'speed': 10}
        init_balloon(balloon)
        balloons_list.append(balloon)

# Iniciar/Reiniciar els valors d'un globus
def init_balloon(balloon):
    balloon['x'] = random.randint(10, window_size['width'] - 10)
    balloon['y'] = 10
    balloon['color'] = random.choice(colors)
    balloon['radius'] = random.randint(5, 15)
    balloon['speed'] = balloon['radius'] * 2 + balloons_caught

# Mostrar un cercle individual
def draw_balloon(balloon):
    center_tuple = (int(balloon['x']), int(balloon['y']))
    pygame.draw.circle(screen, balloon['color'], center_tuple, balloon['radius'], 0)

# Mostrar estadístiques
def display_stats():
    caught_text = font.render(f"Caught: {balloons_caught}", True, BLACK)
    dropped_text = font.render(f"Dropped: {balloons_dropped}", True, BLACK)
    screen.blit(caught_text, (10, window_size["height"] - 40))
    screen.blit(dropped_text, (10, window_size["height"] - 20))

# Actualitzar un globus individual
def update_balloon(balloon, delta_time):
    global balloons_dropped
    balloon['y'] = balloon['y'] + balloon['speed'] * delta_time
    if balloon['y'] > window_size["height"]:
        balloons_dropped += 1
        init_balloon(balloon)

if __name__ == "__main__":
    main()

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

# Definir variables globals
board = {
    "position": { 
        "x": 50, 
        "y": 50 
    },
    "size": { 
        "rows": 15, 
        "cols": 10 
    },
    "cell_size": 25
}
mouse_pos = { "x": -1, "y": -1 }
cell_over = { "row": -1, "column": -1 }

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
    mouse_inside = pygame.mouse.get_focused() # El ratolí està dins de la finestra?

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
    global board, mouse_pos, cell_over
    cell_over = cell_from_point(mouse_pos, board)

# Dibuixar
def app_draw():
    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar el taulell
    draw_board(board)

    # Si el ratolí està sobre una cel·la vàlida, dibuixar un rectangle ple en aquesta cel·la
    if cell_over["row"] != -1 and cell_over["column"] != -1:
        cell_position = point_from_cell(cell_over, board)
        if cell_position["x"] != -1 and cell_position["y"] != -1:
            cell_size = board["cell_size"]
            rect_tuple = (cell_position["x"], cell_position["y"], cell_size, cell_size)
            pygame.draw.rect(screen, BLUE, rect_tuple)

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

def draw_board(board):
    x_start = board["position"]["x"]
    y_start = board["position"]["y"]
    rows = board["size"]["rows"]
    cols = board["size"]["cols"]
    cell_size = board["cell_size"]

    for row in range(rows):
        for col in range(cols):
            rect_tuple = (x_start + col * cell_size, y_start + row * cell_size, cell_size, cell_size)
            pygame.draw.rect(screen, BLACK, rect_tuple, 1)  # Dibuixar només el contorn de la cel·la

def cell_from_point(point, board):
    x = point["x"]
    y = point["y"]
    x_start = board["position"]["x"]
    y_start = board["position"]["y"]
    rows = board["size"]["rows"]
    cols = board["size"]["cols"]
    cell_size = board["cell_size"]

    # Comprovar si el punt està dins dels límits del taulell
    if x_start <= x < x_start + cols * cell_size and y_start <= y < y_start + rows * cell_size:
        col = (x - x_start) // cell_size
        row = (y - y_start) // cell_size
        return { "row": row, "column": col }

    # Retornar -1 si està fora dels límits
    return { "row": -1, "column": -1 }

def point_from_cell(cell, board):
    row = cell["row"]
    col = cell["column"]
    x_start = board["position"]["x"]
    y_start = board["position"]["y"]
    rows = board["size"]["rows"]
    cols = board["size"]["cols"]
    cell_size = board["cell_size"]

    # Comprovar si la cel·la està dins dels límits del taulell
    if 0 <= row < rows and 0 <= col < cols:
        x = x_start + col * cell_size
        y = y_start + row * cell_size
        return { "x": x, "y": y }

    # Retornar -1 si la cel·la està fora dels límits
    return { "x": -1, "y": -1 }

if __name__ == "__main__":
    main()

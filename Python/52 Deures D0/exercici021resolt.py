#!/usr/bin/env python3

import random
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils


# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
YELLOW = (240, 187, 64)

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
cell_mouse_up = { "row": -1, "column": -1 }
board_values = [[random.randint(0, 9) for _ in range(15)] for _ in range(10)]

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
    global mouse_pos, board, cell_mouse_up
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
        elif event.type == pygame.MOUSEBUTTONUP:
            x = event.pos[0]
            y = event.pos[1]
            cell_mouse_up = cell_from_point({ "x": x, "y": y}, board)

    return True

# Fer càlculs
def app_run():
    global board, mouse_pos, cell_over, cell_mouse_up, board_values

    cell_over_tmp = cell_from_point(mouse_pos, board)
    cell_over_value = get_cell_value(cell_over_tmp)
    if cell_over_value != "":
        cell_over = cell_over_tmp
    else:
        cell_over = { "row": -1, "column": -1 }

    if cell_mouse_up["row"] != -1 and cell_mouse_up["column"] != -1:
        # Obtenir el valor de la cel·la sobre la qual s'ha fet mouse up
        mouse_up_value = get_cell_value(cell_mouse_up)
        
        # Recórrer totes les cel·les de board_values
        for row in range(len(board_values)):
            for col in range(len(board_values[row])):
                # Comprovar si el valor de la cel·la coincideix amb mouse_up_value
                if board_values[row][col] == mouse_up_value:
                    # Posar el valor de la cel·la a ""
                    board_values[row][col] = ""

# Dibuixar
def app_draw():
    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar el taulell
    draw_board(board)

    # Si el ratolí està sobre una cel·la vàlida
    # dibuixar un rectangle ple en totes les cel·les 
    # que tenen el mateix valor
    if cell_over["row"] != -1 and cell_over["column"] != -1:
        cell_value = get_cell_value(cell_over)
        rows = board["size"]["rows"]
        cols = board["size"]["cols"]
        for row in range(rows):
            for col in range(cols):
                cell_check = { "row": row, "column": col }
                cell_check_value = get_cell_value(cell_check)
                if cell_check_value == cell_value:
                    cell_position = point_from_cell(cell_check, board)
                    cell_size = board["cell_size"]
                    rect = pygame.Rect(cell_position["x"], cell_position["y"], cell_size, cell_size)
                    pygame.draw.rect(screen, YELLOW, rect)

    draw_board_values()

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

def get_cell_value(cell):
    global board_values
    if cell["row"] != -1 and cell["column"] != -1:
        row = cell["row"]
        col = cell["column"]
        return board_values[col][row]
    return -1

def draw_board_values():
    global board, board_values
    x_start = board["position"]["x"]
    y_start = board["position"]["y"]
    rows = board["size"]["rows"]
    cols = board["size"]["cols"]
    cell_size = board["cell_size"]

    # Configurar la font per als números de les cel·les
    font = pygame.font.SysFont(None, 24)

    for row in range(rows):
        for col in range(cols):
            # Obtenir el valor de la cel·la
            cell = { "row": row, "column": col }
            value = get_cell_value(cell)

            # Renderitzar el text i calcular la posició del text al centre de la cel·la
            text_surface = font.render(str(value), True, BLACK)
            text_rect = text_surface.get_rect(center=(x_start + col * cell_size + cell_size / 2,
                                                      y_start + row * cell_size + cell_size / 2))

            # Dibuixar el text al lloc corresponent
            screen.blit(text_surface, text_rect)

def draw_board(board):
    x_start = board["position"]["x"]
    y_start = board["position"]["y"]
    rows = board["size"]["rows"]
    cols = board["size"]["cols"]
    cell_size = board["cell_size"]

    for row in range(rows):
        for col in range(cols):
            rect = pygame.Rect(x_start + col * cell_size, y_start + row * cell_size, cell_size, cell_size)
            pygame.draw.rect(screen, BLACK, rect, 1)  # Dibuixar només el contorn de la cel·la

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
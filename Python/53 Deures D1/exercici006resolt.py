#!/usr/bin/env python3

import random
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils
from assets.svgmoji.emojis import get_emoji

# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED = (255, 0, 0)
GREEN = (0, 255, 0)
BLUE  = (100, 200, 255)
PURPLE = (128, 0, 128)
ORANGE = (255, 165, 0)  

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480), pygame.RESIZABLE)
pygame.display.set_caption('Window Title')


# Variables globals
window_size = { 
    "width": 0, 
    "height": 0, 
    "center": {
        "x": 0,
        "y": 0
    } 
}

BOARD_SIZE = (12, 8)
CELL_SIZE = 50
mouse_pos = { "x": -1, "y": -1 }

img_ship = get_emoji(pygame, "🚢", size=CELL_SIZE)
img_drop = get_emoji(pygame, "🌊", size=CELL_SIZE)
img_bomb = get_emoji(pygame, "💥", size=CELL_SIZE)

board_pos = { "x": -1, "y": -1 }
board = []

# Bucle de l'aplicació
def main():
    is_looping = True

    init_board()

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
    global mouse_pos, board
    mouse_inside = pygame.mouse.get_focused()

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            return False
        elif event.type == pygame.MOUSEMOTION:
            if mouse_inside:
                mouse_pos["x"] = event.pos[0]
                mouse_pos["y"] = event.pos[1]
            else:
                mouse_pos["x"] = -1
                mouse_pos["y"] = -1
        elif event.type == pygame.MOUSEBUTTONDOWN:
            cell_x = int((mouse_pos["x"] - board_pos["x"]) / CELL_SIZE)
            cell_y = int((mouse_pos["y"] - board_pos["y"]) / CELL_SIZE)

            if 0 <= cell_x < len(board[0]) and 0 <= cell_y < len(board):
                # Si la cel·la és buida, marca-la com a "W"
                if board[cell_y][cell_x] == "":
                    board[cell_y][cell_x] = "W"
                # Si conté una part de vaixell "S" marca com "B"
                elif board[cell_y][cell_x] == "S":
                    board[cell_y][cell_x] = "B"
    return True

# Fer càlculs
def app_run():
    global window_size
    
    window_size["width"] = screen.get_width()
    window_size["height"] = screen.get_height()
    window_size["center"]["x"] = int(screen.get_width() / 2)
    window_size["center"]["y"] = int(screen.get_height() / 2)

    board_pos["x"] = window_size["center"]["x"] - int(len(board[0]) * CELL_SIZE / 2)
    board_pos["y"] = window_size["center"]["y"] - int(len(board) * CELL_SIZE / 2)

# Dibuixar
def app_draw():
    global pos_x, pos_y

    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Draw board
    draw_board()

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

def place_ship(x, y, length, direction):
    global board
    if direction == "horizontal":
        for i in range(length):
            board[x][y + i] = "S"
    elif direction == "vertical":
        for i in range(length):
            board[x + i][y] = "S"

def is_valid_position(x, y, length, direction):
    max_rows = len(board)
    max_cols = len(board[0])

    # Comprova els límits del tauler i que totes les cel·les estiguin buides
    if direction == "horizontal" and y + length <= max_cols:
        for i in range(length):
            if board[x][y + i] != "":
                return False
            # Comprova els espais de dalt i de baix del vaixell
            if x > 0 and board[x - 1][y + i] != "":
                return False
            if x < max_rows - 1 and board[x + 1][y + i] != "":
                return False
        # Comprova els espais als extrems del vaixell
        if y > 0 and board[x][y - 1] != "":
            return False
        if y + length < max_cols and board[x][y + length] != "":
            return False
        return True

    elif direction == "vertical" and x + length <= max_rows:
        for i in range(length):
            if board[x + i][y] != "":
                return False
            # Comprova els espais a l'esquerra i a la dreta del vaixell
            if y > 0 and board[x + i][y - 1] != "":
                return False
            if y < max_cols - 1 and board[x + i][y + 1] != "":
                return False
        # Comprova els espais als extrems del vaixell
        if x > 0 and board[x - 1][y] != "":
            return False
        if x + length < max_rows and board[x + length][y] != "":
            return False
        return True

    return False

def init_board():
    global board
    board = [["" for _ in range(BOARD_SIZE[0])] for _ in range(BOARD_SIZE[1])]

    ships = [(3, "horizontal"), (4, "horizontal"), (3, "vertical")]
    for ship in ships:
        length = ship[0]
        direction = ship[1]
        placed = False
        while not placed:
            x, y = random.randint(0, len(board) - 1), random.randint(0, len(board[0]) - 1)
            if is_valid_position(x, y, length, direction):
                place_ship(x, y, length, direction)
                placed = True

def draw_board():    
    for i in range(len(board)):
        for j in range(len(board[i])):
            cell_x = board_pos["x"] + j * CELL_SIZE
            cell_y = board_pos["y"] + i * CELL_SIZE
            
            pygame.draw.rect(screen, BLUE, (cell_x, cell_y, CELL_SIZE, CELL_SIZE))

            if board[i][j] == "S":
                screen.blit(img_ship, (cell_x, cell_y))
            elif board[i][j] == "W":
                screen.blit(img_drop, (cell_x, cell_y))
            elif board[i][j] == "B":
                screen.blit(img_ship, (cell_x, cell_y))
                screen.blit(img_bomb, (cell_x, cell_y))

if __name__ == "__main__":
    main()
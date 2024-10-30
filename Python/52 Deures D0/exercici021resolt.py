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
BLUE  = (0, 0, 255)
PURPLE = (128, 0, 128)
ORANGE = (255, 165, 0)  

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Posició de l'esquiador
pos_skater = { "row": 0, "column": 0}

img_tree = get_emoji(pygame, "🌲", size=48)
img_snow = get_emoji(pygame, "❄️", size=48)
img_sman = get_emoji(pygame, "☃️", size=48)
img_skater = get_emoji(pygame, "🏂", size=48)

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

    pygame.quit()
    sys.exit()

# Comprovar si una casella està buida o té neu
def is_empty_or_snow(row, col):
    return 0 <= row < len(board) and 0 <= col < len(board[0]) and (board[row][col] == '' or board[row][col] == 'S')

# Gestionar events
def app_events():
    global pos_skater

    for event in pygame.event.get():
        if event.type == pygame.QUIT: # Botó tancar finestra
            return False
        if event.type == pygame.KEYUP:  # Tecla alliberada
            new_row, new_col = pos_skater["row"], pos_skater["column"]
            if event.key == pygame.K_LEFT:
                new_col -= 1
            elif event.key == pygame.K_RIGHT:
                new_col += 1
            elif event.key == pygame.K_UP:
                new_row -= 1
            elif event.key == pygame.K_DOWN:
                new_row += 1
            
            # Comprovar si la nova posició és vàlida abans de moure l'esquiador
            if is_empty_or_snow(new_row, new_col):
                pos_skater["row"], pos_skater["column"] = new_row, new_col
    return True

# Fer càlculs
def app_run():
    pass

# Dibuixar
def app_draw():
    screen.fill(WHITE)
    utils.draw_grid(pygame, screen, 50)

    cell_size = 50
    start_x, start_y = 50, 50
    light_blue = (173, 216, 230)

    for row in range(len(board)):
        for col in range(len(board[row])):
            x = start_x + col * cell_size
            y = start_y + row * cell_size
            pygame.draw.rect(screen, light_blue, pygame.Rect(x, y, cell_size, cell_size))

            if board[row][col] != '':
                if board[row][col] == 'T':
                    rect = pygame.Rect(x, y, cell_size, cell_size)
                    screen.blit(img_tree, rect)
                elif board[row][col] == 'M':
                    rect = pygame.Rect(x, y, cell_size, cell_size)
                    screen.blit(img_sman, rect)
                elif board[row][col] == 'S':
                    rect = pygame.Rect(x, y, cell_size, cell_size)
                    screen.blit(img_snow, rect)
    
    # Dibuixar el personatge
    x = start_x + pos_skater["column"] * cell_size
    y = start_y + pos_skater["row"] * cell_size
    rect = pygame.Rect(x, y, cell_size, cell_size)
    screen.blit(img_skater, rect)

    pygame.display.update()

def init_board():
    global board
    rows = 8
    cols = 10
    
    board = [['' for _ in range(cols)] for _ in range(rows)]
    
    place_random_letters('T', 9, rows, cols)
    place_random_letters('S', 3, rows, cols)
    place_random_letters('M', 3, rows, cols)

def place_random_letters(letter, count, rows, cols):
    placed = 0
    while placed < count:
        row = random.randint(0, rows - 1)
        col = random.randint(0, cols - 1)
        if row != 0 and col != 0 and board[row][col] == '':
            board[row][col] = letter
            placed += 1

if __name__ == "__main__":
    main()

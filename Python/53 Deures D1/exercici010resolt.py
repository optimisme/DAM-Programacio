#!/usr/bin/env python3

import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import random
import utils

# Define colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
GRAY = (220, 220, 220)
RED = (255, 0, 0)

pygame.init()
clock = pygame.time.Clock()

# Define window size
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Variables globals
font14 = pygame.font.SysFont("Arial", 14)
font12 = pygame.font.SysFont("Arial", 12)

window_size = { 
    "width": 0, 
    "height": 0, 
    "center": {
        "x": 0,
        "y": 0
    } 
}

mouse_pos = {'x': 300, 'y': 250 }

level = 1  # Level
snake = {
    "status": "follow_mouse", # "follow_mouse" or "orbit_mouse"
    "queue": [],
    "direction_angle": 0,
    "speed": 1,
    "radius": 7
}

piece = { # (food)
    "x": -1, 
    "y": -1, 
    "value": 0,
    "radius": 7
}  

# Bucle de l'aplicació
def main():
    is_looping = True

    init_game()

    while is_looping:
        is_looping = app_events()
        app_run()
        app_draw()
        clock.tick(60)  # Limit to 60 FPS

    pygame.quit()
    sys.exit()

# Gestionar events
def app_events():
    global mouse_pos

    for event in pygame.event.get():
        if event.type == pygame.QUIT:  # Close window button
            return False
        elif event.type == pygame.MOUSEMOTION:
            mouse_pos['x'], mouse_pos['y'] = event.pos
    return True

# Fer càlculs
def app_run():
    set_window_size()
    move_snake()

# Dibuixar
def app_draw():
    screen.fill(WHITE)

    draw_board()
    draw_piece()
    draw_snake()
    pygame.display.update()

# Estableix les mides de la finestra
def set_window_size():
    global window_size

    window_size["width"] = screen.get_width()
    window_size["height"] = screen.get_height()
    window_size["center"]["x"] = int(screen.get_width() / 2)
    window_size["center"]["y"] = int(screen.get_height() / 2)

# Iniciar la serp
def init_game():
    global snake

    # Genera la primera peça 
    # (necessita tenir les mides de la finestra)
    set_window_size()
    if piece['x'] == -1:
        generate_piece()

    # Inicia la serp
    # (al centre de la pantalla, i de mida 5)
    snake["points"] = []
    snake["queue"].append({'x': window_size["center"]["x"], 'y': window_size["center"]["y"]})
    for cnt in range(4):
        extend_snake()

def generate_piece():
    piece['x'] = random.randint(5, window_size["width"] - 5)
    piece['y'] = random.randint(5, window_size["height"] - 5)
    piece['value'] = random.randint(1, 4)

def extend_snake():
    # Afegir un nou punt a la cua, copiant/duplicant l'última posició
    ultim = len(snake["queue"]) - 1
    snake["queue"].append({
        "x": snake["queue"][ultim]['x'], 
        "y": snake["queue"][ultim]['y']
    })

def move_snake():
    global serp, level

    # Si la serp xoca amb la peça
    hit = utils.is_point_in_circle(snake["queue"][0], piece, piece["radius"])
    if hit:
        level += 1
        snake["speed"] += 0.05      # Augmentar velocitat
        if snake["speed"] > 3.5:    # Limitar velocitat
            snake["speed"] = 3.5
        for _ in range(piece['value']): # Ampliar la cua de la serp
            extend_snake()              # al número de la peça (menjar)
        generate_piece()

    # Calcular la següent posició
    update_snake_angle()
    next_pos = {
        "x": snake["queue"][0]['x'] + snake["speed"] * math.cos(snake["direction_angle"]), 
        "y": snake["queue"][0]['y'] + snake["speed"] * math.sin(snake["direction_angle"])
    }

    # Inserir la nova posició al principi de la cua
    snake["queue"].insert(0, next_pos)

    # Eliminar l'últim segment per mantenir
    snake["queue"].pop()

def update_snake_angle():
    global snake

    # Calcula la diferència en les coordenades entre el cap de la serp i el ratolí
    delta_x = mouse_pos['x'] - snake["queue"][0]['x']
    delta_y = mouse_pos['y'] - snake["queue"][0]['y']
   
    # Calcula la distància entre el cap de la serp i la posició del ratolí
    distancia = math.hypot(delta_x, delta_y)

    # Determina l'estat de la serp segons la distància al ratolí
    if distancia < 5:
        snake["status"] = 'orbit_mouse'  # Estat per orbitar prop del ratolí
    if distancia > 50:
        snake["status"] = 'follow_mouse'  # Estat per seguir el ratolí

    # Si la serp està en estat d'òrbita, 
    # augmenta l'angle de direcció per fer-la girar
    if snake["status"] == 'orbit_mouse':
        snake["direction_angle"] += distancia * math.pi / 1000
        return

    # Calcula el pendent per obtenir l'angle; 
    # si delta_x és 0, s'estableix a infinit per evitar divisió per zero
    if delta_x != 0:
        pendent = delta_y / delta_x
    else:
        pendent = float('inf')

    # Calcula l'angle de direcció de la serp per seguir el ratolí
    if delta_x == 0 and mouse_pos['y'] < snake["queue"][0]['y']:
        # Angle per anar amunt (270 graus)
        snake["direction_angle"] = (3 * math.pi) / 2
    elif delta_x == 0 and mouse_pos['y'] >= snake["queue"][0]['y']:
        # Angle per anar avall (90 graus)
        snake["direction_angle"] = math.pi / 2
    elif mouse_pos['x'] > snake["queue"][0]['x']:
        # Angle per anar cap a la dreta 
        snake["direction_angle"] = math.atan(pendent)
    else:
        # Angle per anar cap a l'esquerra (180 graus)
        snake["direction_angle"] = math.atan(pendent) + math.pi

def draw_board():
    level_text = font14.render(f'Level: {level}', True, BLACK)
    length_text = font14.render(f'Length: {len(snake["queue"])}', True, BLACK)
    speed_text = font14.render(f'Speed: {snake["speed"]:.2f}', True, BLACK)
    screen.blit(level_text, (15, 15))
    screen.blit(length_text, (15, 35))
    screen.blit(speed_text, (15, 55))

def draw_snake():
    for cnt in reversed(range(len(snake["queue"]))):
        cercle = snake["queue"][cnt]
        if len(snake["queue"]) > 1:
            lightness = int((cnt * 225) / (len(snake["queue"]) - 1))
        else:
            lightness = 0
        color = (lightness, lightness, lightness)
        pygame.draw.circle(screen, color, (int(cercle['x']), int(cercle['y'])), snake["radius"])

def draw_piece():
    circle_pos_tuple = (int(piece['x']), int(piece['y']))
    pygame.draw.circle(screen, RED, circle_pos_tuple, piece["radius"])

    text = font12.render(str(piece['value']), True, BLACK)
    text_rect = text.get_rect(center=circle_pos_tuple)
    screen.blit(text, text_rect)

if __name__ == "__main__":
    main()

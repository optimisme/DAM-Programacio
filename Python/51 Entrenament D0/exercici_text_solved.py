#!/usr/bin/env python3

import sys
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import utils

WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
BLUE = (0, 0, 255)
GRAY = (100, 100, 100)

pygame.init()
clock = pygame.time.Clock()
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

font = pygame.font.SysFont("Arial", 22)
mouse = { "x": -1, "y": -1, "pressed": False }

# Definir el quadre d'entrada
input_box = {
    "x": 100,
    "y": 200,
    "width": 200,
    "height": 32,
    "text": "",
    "focused": False
}

cursor = {
    "visible": True,
    "timer": 0,
    "position": 0
}

def main():
    is_looping = True

    while is_looping:
        is_looping = app_events()
        app_run()
        app_draw()
        clock.tick(60)

    pygame.quit()
    sys.exit()

def app_events():
    global cursor
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            return False
        elif event.type == pygame.MOUSEBUTTONDOWN:
            mouse["x"], mouse["y"] = event.pos
            if utils.is_point_in_rect(mouse, input_box):
                input_box["focused"] = True
            else:
                input_box["focused"] = False
        elif event.type == pygame.KEYDOWN and input_box["focused"]:
            if event.key == pygame.K_BACKSPACE:
                input_box["text"] = input_box["text"][:-1]
                cursor["position"] = max(0, cursor["position"] - 1)
            elif event.unicode.isprintable() and event.unicode not in "`´^¨~":
                input_box["text"] += event.unicode
                cursor["position"] += 1
    return True

def app_run():
    global cursor
    cursor["timer"] += 1
    if cursor["timer"] >= 30:
        cursor["visible"] = not cursor["visible"]
        cursor["timer"] = 0

def app_draw():
    screen.fill(WHITE)
    utils.draw_grid(pygame, screen, 50)

    # Dibuix del quadre de text
    color = BLUE if input_box["focused"] else GRAY
    rect_tuple = (input_box["x"], input_box["y"], input_box["width"], input_box["height"])
    pygame.draw.rect(screen, color, rect_tuple, 2)
    
    # Dibuix del text dins del quadre de text
    text_surface = font.render(input_box["text"], True, BLACK)
    text_tuple = (input_box["x"] + 5, input_box["y"] + 5)
    screen.blit(text_surface, text_tuple)
    
    # Dibuix del cursor (intermitent)
    if input_box["focused"] and cursor["visible"]:
        # Posició de l'inici del quadre d'entrada
        input_x_start = input_box["x"] + 5
        # Amplada del text fins a la posició actual del cursor
        text_width = font.size(input_box["text"])[0]
        # Coordenada 'x' del cursor
        cursor_x = input_x_start + text_width
        start_tuple = (cursor_x, input_box["y"] + 5)
        end_tuple = (cursor_x, input_box["y"] + input_box["height"] - 5)
        pygame.draw.line(screen, BLACK, start_tuple, end_tuple)

    pygame.display.update()

if __name__ == "__main__":
    main()

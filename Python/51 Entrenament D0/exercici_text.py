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
        # TODO
    return True

def app_run():
    pass

def app_draw():
    screen.fill(WHITE)
    utils.draw_grid(pygame, screen, 50)

    # TODO: Dibuix del quadre de text
    
    # TODO: Dibuix del text dins del quadre de text
    
    # TODO: Dibuix del cursor (intermitent)

    pygame.display.update()

if __name__ == "__main__":
    main()

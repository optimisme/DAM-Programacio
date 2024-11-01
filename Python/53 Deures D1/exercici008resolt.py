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
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')


# Variables globals
font14 = pygame.font.SysFont("Arial", 14)
font22 = pygame.font.SysFont("Arial", 22)

window_size = { 
    "width": 0, 
    "height": 0, 
    "center": {
        "x": 0,
        "y": 0
    } 
}
mouse_data = { "x": -1, "y": -1, "pressed": False, "released": False }

buttons = [
    { "text": "-", "value": "sub", "x": 25, "y": 25, "width": 50, "height": 25, "pressed": False },
    { "text": "+", "value": "add", "x": 75, "y": 25, "width": 50, "height": 25, "pressed": False },
]

circle = {
    "speed": 50,
    "angle": 0, 
    "pos": { "x": 0, "y": 0 },
    "radius": 200
}

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
    global mouse_data
    mouse_inside = pygame.mouse.get_focused()

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            return False
        elif event.type == pygame.MOUSEMOTION:
            if mouse_inside:
                mouse_data["x"] = event.pos[0]
                mouse_data["y"] = event.pos[1]
            else:
                mouse_data["x"] = -1
                mouse_data["y"] = -1
        elif event.type == pygame.MOUSEBUTTONDOWN:
            mouse_data["pressed"] = True
        elif event.type == pygame.MOUSEBUTTONUP:
            mouse_data["pressed"] = False
            mouse_data["released"] = True

    return True

# Fer càlculs
def app_run():
    global buttons, circle
    delta_time = clock.get_time() / 1000.0  

    window_size["width"] = screen.get_width()
    window_size["height"] = screen.get_height()
    window_size["center"]["x"] = int(screen.get_width() / 2)
    window_size["center"]["y"] = int(screen.get_height() / 2)

    for button in buttons:
        if utils.is_point_in_rect(mouse_data, button):
            if mouse_data["pressed"]:
                button["pressed"] = True
            elif mouse_data["released"]:
                button["pressed"] = False   
                if button["value"] == "add": # Aquí fem la operació
                    circle["speed"] += 10
                else:
                    circle["speed"] -= 10
        else:
            button["pressed"] = False
    mouse_data["released"] = False  

    if circle["speed"] > 100:
        circle["speed"] = 100
    elif circle["speed"] < 10:
        circle["speed"] = 10

    circle["angle"] += circle["speed"] * delta_time
    circle["pos"] = utils.point_on_circle(window_size["center"], circle["radius"], circle["angle"])

# Dibuixar
def app_draw():
    global pos_x, pos_y

    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Draw buttons
    for button in buttons:
        draw_button(button)

    # Draw 'mouse pressed' text
    if mouse_data["pressed"]:
        text = font14.render("Mouse Pressed", True, BLACK)
        screen.blit(text, (135, 30))

    # Dibuixa la velocitat
    text_surface = font22.render(str(circle["speed"]), True, BLACK)
    text_rect = text_surface.get_rect()
    text_rect.centerx = 75
    text_rect.centery = 75
    screen.blit(text_surface, text_rect)

    # Dibuixa el cercle
    window_center_tuple = (window_size["center"]["x"], window_size["center"]["y"])
    pygame.draw.circle(screen, BLACK, window_center_tuple, circle["radius"], 2)

    circle_pos_tuple = (circle["pos"]["x"], circle["pos"]["y"])
    pygame.draw.circle(screen, BLUE, circle_pos_tuple, 25)

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

def draw_button(button):

    color = WHITE
    if button["pressed"]:
        color = ORANGE

    rect_tuple = (button["x"], button["y"], button["width"], button["height"])
    pygame.draw.rect(screen, color, rect_tuple)
    pygame.draw.rect(screen, BLACK, rect_tuple, 2)

    button_center_x = button["x"] + int(button["width"] / 2)
    button_center_y = button["y"] + int(button["height"] / 2)

    text_surface = font22.render(button["text"], True, BLACK)
    text_rect = text_surface.get_rect()
    text_rect.centerx = button_center_x
    text_rect.centery = button_center_y
    screen.blit(text_surface, text_rect)

if __name__ == "__main__":
    main()
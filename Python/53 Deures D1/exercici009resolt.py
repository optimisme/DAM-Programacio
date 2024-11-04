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
GRAY = (215, 215, 215)
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
font = pygame.font.SysFont("Arial", 14)

mouse_data = { "x": -1, "y": -1, "pressed": False, "released": False }
buttons = [
    { "x":  25, "y": 25, "width": 25, "height": 25, "pressed": False, "activated": False },
    { "x":  50, "y": 25, "width": 25, "height": 25, "pressed": False, "activated": False },
    { "x":  75, "y": 25, "width": 25, "height": 25, "pressed": False, "activated": False },
    { "x": 100, "y": 25, "width": 25, "height": 25, "pressed": False, "activated": False },
]

digits = [0, 0, 0, 0]

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
    global buttons, digits

    for button in buttons:
        if utils.is_point_in_rect(mouse_data, button):
            if mouse_data["pressed"]:
                button["pressed"] = True
            elif mouse_data["released"]:
                button["pressed"] = False   
                button["activated"] = not button["activated"] # Aquí realitzem la operació
        else:
            button["pressed"] = False
    mouse_data["released"] = False  

    digits[0] = buttons[0]["pressed"] or buttons[0]["activated"]
    digits[1] = buttons[1]["pressed"] or buttons[1]["activated"]
    digits[2] = buttons[2]["pressed"] or buttons[2]["activated"]
    digits[3] = buttons[3]["pressed"] or buttons[3]["activated"]
  
# Dibuixar
def app_draw():
    global digits

    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Draw buttons
    for button in buttons:
        draw_button(button)

    # Draw LED number
    draw_LED_number()

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

def draw_button(button):
    color = WHITE
    if button["pressed"]:
        color = ORANGE
    elif button["activated"]:
        color = BLUE

    rect_tuple = (button["x"], button["y"], button["width"], button["height"])
    pygame.draw.rect(screen, color, rect_tuple)
    pygame.draw.rect(screen, BLACK, rect_tuple, 2)

def draw_LED_number():
    # Coordenades base per al dígit (part dreta de la pantalla)
    center_x = 400
    center_y = 250
    segment_length = 50
    segment_thick = 5
    left = center_x - int(segment_length / 2)
    right = center_x + int(segment_length / 2)
    top = center_y - segment_length
    bottom = center_y + segment_length

    # Definir posicions per a cada segment
    positions = {
        "htt": { "begin": { "x": left + 4,  "y": top },      "end": { "x": right - 4, "y": top } },
        "hcc": { "begin": { "x": left + 4,  "y": center_y }, "end": { "x": right - 4, "y": center_y } },
        "hbb": { "begin": { "x": left + 4,  "y": bottom },   "end": { "x": right - 4, "y": bottom } },
        "vtl": { "begin": { "x": left,  "y": top + 4 },      "end": { "x": left,  "y": center_y - 4 } },
        "vtr": { "begin": { "x": right, "y": top + 4 },      "end": { "x": right, "y": center_y - 4 } },
        "vbl": { "begin": { "x": left,  "y": center_y + 4 }, "end": { "x": left,  "y": bottom - 4 } },
        "vbr": { "begin": { "x": right, "y": center_y + 4 }, "end": { "x": right, "y": bottom - 4 } },
    }

    # Definir els segments per a cada dígit hexadecimal
    segments = [
        ["htt", "vtr", "vbr", "hbb", "vbl", "vtl"],        # 0
        ["vtr", "vbr"],                                    # 1
        ["htt", "vtr", "hcc", "vbl", "hbb"],               # 2
        ["htt", "vtr", "hcc", "vbr", "hbb"],               # 3
        ["vtl", "vtr", "hcc", "vbr"],                      # 4
        ["htt", "vtl", "hcc", "vbr", "hbb"],               # 5
        ["htt", "vtl", "hcc", "vbl", "vbr", "hbb"],        # 6
        ["htt", "vtr", "vbr"],                             # 7
        ["htt", "vtl", "vtr", "hcc", "vbl", "vbr", "hbb"], # 8
        ["htt", "vtl", "vtr", "hcc", "vbr", "hbb"],        # 9
        ["htt", "vtr", "hcc", "vbl", "vbr", "hbb"],        # a
        ["vtl", "hcc", "vbl", "vbr", "hbb"],               # b
        ["hcc", "vbl", "hbb"],                             # c
        ["vtr", "hcc", "vbr", "hbb", "vbl"],               # d
        ["htt", "vtr", "vtl", "hcc", "vbl", "hbb"],        # e
        ["htt", "vtl", "hcc", "vbl"],                      # f
    ]

    # Determinar el número a dibuixar en hexadecimal
    number = digits[0] * 8 + digits[1] * 4 + digits[2] * 2 + digits[3] * 1

    # Dibuixar totes les posicions (segments)
    for key in positions:
        start = positions[key]["begin"]
        end = positions[key]["end"]
        pygame.draw.line(screen, GRAY, (start["x"], start["y"]), (end["x"], end["y"]), segment_thick)

    # Dibuixar els segments activats del valor
    for segment in segments[number]:
        start = positions[segment]["begin"]
        end = positions[segment]["end"]
        pygame.draw.line(screen, RED, (start["x"], start["y"]), (end["x"], end["y"]), segment_thick)

if __name__ == "__main__":
    main()
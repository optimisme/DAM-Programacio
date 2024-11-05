#!/usr/bin/env python3

import math
import os
from datetime import datetime
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
BLUE = (50, 120, 200)
RED = (255, 69, 0) 

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Definir variables globals
font = pygame.font.SysFont("Arial", 16)

time = { 
    "hours": 0, 
    "minutes": 0, 
    "seconds": 0
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
    for event in pygame.event.get():
        if event.type == pygame.QUIT: # Botó tancar finestra
            return False
    return True

# Fer càlculs
def app_run():
    global time

    now = datetime.now()
    current_time_ms = now.timestamp() * 1000

    # Hores amb fracció de minuts (format 12 hores)
    time["hours"] = (current_time_ms / 3600000) % 12

    # Minuts amb fracció de segons    
    time["minutes"] = (current_time_ms / 60000) % 60

    # Segons amb fracció de mil·lisegons
    time["seconds"] = (current_time_ms / 1000) % 60

# Dibuixar
def app_draw():   
    global time

    screen.fill(BLACK)
    utils.draw_grid(pygame, screen, 50)

    # Ajust per rotar l'angle d'origen pygame
    # a l'angle 0 d'un rellotge
    offset = -90 

    center = { "x": 325, "y": 250 }
    center_tuple = (center["x"], center["y"])
    radius = 200
    
    # Càlcul de l'angle de les hores 
    degrees_per_hour = (360 / 12)
    hour_angle = (degrees_per_hour * time["hours"]) + offset
    hour = utils.point_on_circle(center, radius * 0.4, hour_angle)
    hour_tuple = (hour["x"], hour["y"])
    pygame.draw.line(screen, WHITE, center_tuple, hour_tuple, 10)

    # Càlcul de l'angle dels minuts 
    degress_per_min = (360 / 60)
    minute_angle = (degress_per_min * time["minutes"]) + offset
    minute = utils.point_on_circle(center, radius * 0.7, minute_angle)
    minute_tuple = (minute["x"], minute["y"])
    pygame.draw.line(screen, BLUE, center_tuple, minute_tuple, 6)

    # Càlcul de l'angle dels segons 
    degress_per_sec = (360 / 60)
    second_angle = (degress_per_sec * time["seconds"]) + offset
    second = utils.point_on_circle(center, radius * 0.9, second_angle)
    second_tuple = (second["x"], second["y"])
    pygame.draw.line(screen, RED, center_tuple, second_tuple, 2)

    # Dibuixar els números
    for num in range(1, 13):
        angle = (degrees_per_hour * num + offset)
        num_pos = utils.point_on_circle(center, radius, angle) 
        num_pos_tuple = (num_pos["x"], num_pos["y"])
        label = font.render(str(num), True, WHITE)
        label_rect = label.get_rect(center=num_pos_tuple)  # Centrar el text
        screen.blit(label, label_rect)

    pygame.display.update()

if __name__ == "__main__":
    main()
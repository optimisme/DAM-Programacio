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
BROWN = (165, 42, 42)
YELLOW = (255, 255, 0)
GRAY = (169, 169, 169) 
ORANGE = (255, 165, 0)
GOLD = (255, 215, 0)
RED = (255, 69, 0) 

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Definir variables globals
font = pygame.font.Font(None, 16)

sun = {
    "pos": { "x": 0, "y": 0 },
    "radius": 20
}
planets = {
    "Mercury": { "distance": 58,  "speed": 47.87, "radius": 3.80, "color": GRAY, "angle": 0, "pos": { "x": 0, "y": 0 } },
    "Venus":   { "distance": 108, "speed": 35.02, "radius": 9.50, "color": GOLD, "angle": 0, "pos": { "x": 0, "y": 0 } },
    "Earth":   { "distance": 150, "speed": 29.78, "radius": 10.0, "color": BLUE, "angle": 0, "pos": { "x": 0, "y": 0 } },
    "Mars":    { "distance": 228, "speed": 24.07, "radius": 5.30, "color": RED,  "angle": 0, "pos": { "x": 0, "y": 0 } },
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
    global sun, planets
    delta_time = clock.get_time() / 1000.0  
    
     # Posició del Sol al centre de la pantalla
    sun["pos"]["x"] = int(screen.get_width() / 2)
    sun["pos"]["y"] = int(screen.get_height() / 2)

    planet_names = list(planets.keys()) 
    for name in planet_names:
        planet = planets[name]
        planet["angle"] = planet["angle"] + planet["speed"] * delta_time
        distance_from_sun = planet["distance"]
        planet["pos"] = utils.point_on_circle(sun["pos"], distance_from_sun, planet["angle"])

# Dibuixar
def app_draw():
    global sun, planets
    
    screen.fill(BLACK)
    utils.draw_grid(pygame, screen, 50)

    # Dibuixar el Sol
    sun_pos_tuple = (sun["pos"]["x"], sun["pos"]["y"])
    pygame.draw.circle(screen, YELLOW, sun_pos_tuple, sun["radius"])

    # Dibuixar els planetes i les seves òrbites
    for name, planet in planets.items():
                         
        # Dibuixar l'òrbita com a cercle gris (traç de 1 píxel)
        pygame.draw.circle(screen, GRAY, sun_pos_tuple, planet["distance"], 1)
        
        # Dibuixar el planeta a la seva posició
        planet_pos_tuple = (planet["pos"]["x"], planet["pos"]["y"])
        pygame.draw.circle(screen, planet["color"], planet_pos_tuple, planet["radius"])

        # Dibuixar el nom del planeta
        label = font.render(name, True, GRAY)
        label_rect = label.get_rect()
        label_rect.midleft = (planet["pos"]["x"] + planet["radius"] + 5, planet["pos"]["y"]) 
        screen.blit(label, label_rect)

    pygame.display.update()

if __name__ == "__main__":
    main()
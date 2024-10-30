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
RED = (255, 69, 0) 

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Definir variables globals
font = pygame.font.Font("Arial", 16)


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
    sun["pos"] = (int(screen.get_width() / 2), int(screen.get_height() / 2)) 

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
    pygame.draw.circle(screen, YELLOW, sun["pos"], sun["radius"])

    # Dibuixar els planetes i les seves òrbites
    for name, planet in planets.items():
                         
        # Dibuixar l'òrbita com a cercle gris (traç de 1 píxel)
        pygame.draw.circle(screen, GRAY, sun["pos"], planet["distance"], 1)
        
        # Dibuixar el planeta a la seva posició
        pygame.draw.circle(screen, planet["color"], (int(planet["pos"][0]), int(planet["pos"][1])), planet["radius"])

        # Dibuixar el nom del planeta
        label = font.render(name, True, GRAY)
        label_rect = label.get_rect()
        label_rect.midleft = (planet["pos"][0] + planet["radius"] + 5, planet["pos"][1]) 
        screen.blit(label, label_rect)

    pygame.display.update()

if __name__ == "__main__":
    main()
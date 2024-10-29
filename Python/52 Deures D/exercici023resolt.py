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
GRAY = (200, 200, 200)
ORANGE = (255, 165, 0)
GOLD = (255, 215, 0)
LIGHT_GRAY = (169, 169, 169) 
RED = (255, 69, 0) 

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Definir variables globals
font = pygame.font.Font(None, 16)

earth_rotation = 150
sun = {
    "pos": (0, 0),
    "radius": earth_rotation / 10
}
planets = {
    "Mercury": { "angle": 0, "distance": 0.39, "speed": 47.87, "size": 0.38, "color": LIGHT_GRAY, "pos": (0, 0) },
    "Venus":   { "angle": 0, "distance": 0.72, "speed": 35.02, "size": 0.95, "color": GOLD, "pos": (0, 0) },
    "Earth":   { "angle": 0, "distance": 1.00, "speed": 29.78, "size": 1.00, "color": BLUE, "pos": (0, 0) },
    "Mars":    { "angle": 0, "distance": 1.52, "speed": 24.07, "size": 0.53, "color": RED, "pos": (0, 0) },
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
    sun["pos"] = (screen.get_width() // 2, screen.get_height() // 2) 

    planet_names = list(planets.keys()) 
    for name in planet_names:
        planet = planets[name]
        planet["angle"] += planet["speed"] * delta_time
        distance_from_sun = earth_rotation * planet["distance"]  # Escala la distància respecte al radi de la Terra
        planet["pos"] = posicio_perimetre_cercle(sun["pos"], distance_from_sun, planet["angle"])

# Dibuixar
def app_draw():
    global sun, planets
    
    screen.fill(BLACK)
    utils.draw_grid(pygame, screen, 50)

    # Dibuixar el Sol
    pygame.draw.circle(screen, YELLOW, sun["pos"], sun["radius"])

    # Dibuixar els planetes i les seves òrbites
    for name, planet in planets.items():
        orbit_radius = earth_rotation * planet["distance"]
        planet_draw_radius = int(planet["size"] * 10)
                          
        # Dibuixar l'òrbita com a cercle gris (traç de 1 píxel)
        pygame.draw.circle(screen, GRAY, sun["pos"], int(orbit_radius), 1)
        
        # Dibuixar el planeta a la seva posició
        pygame.draw.circle(screen, planet["color"], (int(planet["pos"][0]), int(planet["pos"][1])), planet_draw_radius)

        # Dibuixar el nom del planeta
        label = font.render(name, True, LIGHT_GRAY)
        label_rect = label.get_rect()
        label_rect.midleft = (planet["pos"][0] + planet_draw_radius + 5, planet["pos"][1]) 
        screen.blit(label, label_rect)

    pygame.display.update()

def posicio_perimetre_cercle(center, radi, angle_graus):
    angle_radians = math.radians(angle_graus)  # Convertir l'angle a radians
    x = center[0] + radi * math.cos(angle_radians)    # Coordenada X
    y = center[1] + radi * math.sin(angle_radians)    # Coordenada Y
    return x, y

if __name__ == "__main__":
    main()
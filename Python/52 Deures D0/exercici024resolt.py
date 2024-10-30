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

    # Convertir cada part de l'hora actual en mil·lisegons
    hours_in_ms = now.hour * 3600000       # Hores en mil·lisegons
    minutes_in_ms = now.minute * 60000     # Minuts en mil·lisegons
    seconds_in_ms = now.second * 1000      # Segons en mil·lisegons
    microseconds_in_ms = now.microsecond / 1000  # Microsegons en mil·lisegons

    # Sumar totes les parts per obtenir el temps actual en mil·lisegons
    current_time_ms = hours_in_ms + minutes_in_ms + seconds_in_ms + microseconds_in_ms

    # Assignar les hores, minuts i segons directament amb decimals inclosos
    time["hours"] = (current_time_ms / 3600000) % 12    # Hores amb fracció de minuts (format 12 hores)
    time["minutes"] = (current_time_ms / 60000) % 60    # Minuts amb fracció de segons
    time["seconds"] = (current_time_ms / 1000) % 60     # Segons amb fracció de mil·lisegons

# Dibuixar
def app_draw():   
    global time

    screen.fill(BLACK)
    utils.draw_grid(pygame, screen, 50)

    center = (325, 250)
    radius = 200

    # Dibuixar els números
    for num in range(1, 13):
        angle = (360 / 12 * num) - 90  # Angle de cada numero
        x, y = utils.point_on_circle(center, radius, angle) 

        label = font.render(str(num), True, WHITE)
        label_rect = label.get_rect(center=(x, y))  # Centrar el text
        screen.blit(label, label_rect)
    
    # Constants
    offset = -90 # Ajust per rotar l'angle l'origen d'un rellotge

    # Càlcul de l'angle de les hores (continu)
    degrees_per_hour = (360 / 12)
    hour_angle = degrees_per_hour * time["hours"] + offset
    hour_x, hour_y = utils.point_on_circle(center, radius * 0.4, hour_angle)
    pygame.draw.line(screen, WHITE, center, (hour_x, hour_y), 10)

    # Càlcul de l'angle dels minuts (continu)
    degress_per_min = (360 / 60)
    minute_angle = degress_per_min * time["minutes"] + offset
    minute_x, minute_y = utils.point_on_circle(center, radius * 0.7, minute_angle)
    pygame.draw.line(screen, BLUE, center, (minute_x, minute_y), 6)

    # Càlcul de l'angle dels segons (continu)
    degress_per_sec = (360 / 60)
    second_angle = degress_per_sec * time["seconds"] + offset
    second_x, second_y = utils.point_on_circle(center, radius * 0.9, second_angle)
    pygame.draw.line(screen, RED, center, (second_x, second_y), 2)


    pygame.display.update()

if __name__ == "__main__":
    main()
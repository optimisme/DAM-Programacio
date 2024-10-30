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

    current_time_ms = now.hour * 3600000 + now.minute * 60000 + now.second * 1000 + now.microsecond / 1000

    time["hours"] = (current_time_ms / 3600000) % 12
    time["minutes"] = (current_time_ms / 60000) % 60
    time["seconds"] = (current_time_ms / 1000) % 60

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
    
    # Dibuixar l'agulla de les hores
    hour_angle = (360 / 12) * ((time["hours"] % 12) + time["minutes"] / 60) - 90
    hour_x, hour_y = utils.point_on_circle(center, radius * 0.4, hour_angle)
    pygame.draw.line(screen, WHITE, center, (hour_x, hour_y), 10)

    # Dibuixar l'agulla dels minuts
    minute_angle = (360 / 60) * (time["minutes"] + time["seconds"] / 60) - 90
    minute_x, minute_y = utils.point_on_circle(center, radius * 0.7, minute_angle)
    pygame.draw.line(screen, BLUE, center, (minute_x, minute_y), 6)

    # Dibuixar l'agulla dels segons
    second_angle = (360 / 60) * time["seconds"] - 90
    second_x, second_y = utils.point_on_circle(center, radius * 0.9, second_angle)
    pygame.draw.line(screen, RED, center, (second_x, second_y), 2)

    pygame.display.update()

if __name__ == "__main__":
    main()
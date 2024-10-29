import math
import random
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED = (200, 0, 0)

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

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
    global list

# Dibuixar
def app_draw():
    screen.fill(WHITE)
    utils.draw_grid(pygame, screen, 50)
    
    # Centre de la finstra
    center_x, center_y = screen.get_width() // 2, screen.get_height() // 2
    
    # Paràmetres de l'espiral rectangular
    x, y = center_x, center_y
    step = 15  # Longitud inicial del segment
    direction = 0  # 0 = dreta, 1 = amunt, 2 = esquerra, 3 = avall
    
    # Controla el nombre de voltes de l'espiral (25)
    for _ in range(25):  
        # Calcular el punt final de la línia
        if direction == 0:  # Dreta
            end_x, end_y = x + step, y
        elif direction == 1:  # Amunt
            end_x, end_y = x, y - step
        elif direction == 2:  # Esquerra
            end_x, end_y = x - step, y
        elif direction == 3:  # Avall
            end_x, end_y = x, y + step
        
        # Dibuixar la línia
        pygame.draw.line(screen, RED, (x, y), (end_x, end_y), 4)
        
        # Actualitzar el punt inicial per a la següent línia
        x, y = end_x, end_y
        # Canviar la direcció i augmentar la longitud
        direction = (direction + 1) % 4
        step += 15  # Augmentar la longitud per expandir l'espiral

    pygame.display.update()

if __name__ == "__main__":
    main()
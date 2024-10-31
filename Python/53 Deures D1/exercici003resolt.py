import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
GRAY = (200, 200, 200)
YELLOW = (255, 255, 0)
GREEN = (0, 255, 0)
BLUE = (50, 150, 255)
RED = (255, 0, 0)

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Variables globals
mouse_pos = { "x": -1, "y": -1 }
finestra = { "ample": 0, "alt": 0, "mig_x": 0, "mig_y": 0 }

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
    global mouse_pos
    mouse_inside = pygame.mouse.get_focused() # El ratolí està dins de la finestra?

    for event in pygame.event.get():
        if event.type == pygame.QUIT: # Botó tancar finestra
            return False
        elif event.type == pygame.MOUSEMOTION:
            if mouse_inside:
                mouse_pos["x"] = event.pos[0]
                mouse_pos["y"] = event.pos[1]
            else:
                mouse_pos["x"] = -1
                mouse_pos["y"] = -1
    return True

# Fer càlculs
def app_run():
    global finestra

    finestra["ample"] = screen.get_width()
    finestra["alt"] = screen.get_height()
    finestra["mig_x"] = int(screen.get_width() / 2)
    finestra["mig_y"] = int(screen.get_height() / 2)

# Dibuixar
def app_draw():
    screen.fill(WHITE)
    utils.draw_grid(pygame, screen, 50)
    
    # Definir mida rectangle exterior
    ext_ample = finestra["ample"] - 100
    ext_alt = finestra["alt"] - 100
    ext_rect = (50, 50, ext_ample, ext_alt)

    # Dibuixar limits
    pygame.draw.rect(screen, BLACK, ext_rect, 4)
    pygame.draw.line(screen, BLACK, (finestra["mig_x"], 0), (finestra["mig_x"], finestra["alt"]), 4)
    pygame.draw.line(screen, BLACK, (0, finestra["mig_y"]), (finestra["ample"], finestra["mig_y"]), 4)

    # Dibuixar quadre
    q_x = mouse_pos["x"] - 20
    q_y = mouse_pos["y"] - 20

    color = get_color(q_x, q_y, 50, 50, ext_ample, ext_alt)

    rect = (q_x, q_y, 40, 40)
    pygame.draw.rect(screen, color, rect)
    pygame.draw.rect(screen, BLACK, rect, 2)
    
    pygame.display.update()

def get_color(x, y, ext_x, ext_y, ext_ample, ext_alt):
    color = BLACK

    if x < ext_x or x > (ext_x + ext_ample) or y < ext_y or y > (ext_y + ext_alt):
        return color
    
    if x < finestra["mig_x"]:
        if y < finestra["mig_y"]:
            return RED
        else: 
            return GREEN
    else:
        if y < finestra["mig_y"]:
            return BLUE
        else: 
            return YELLOW

if __name__ == "__main__":
    main()
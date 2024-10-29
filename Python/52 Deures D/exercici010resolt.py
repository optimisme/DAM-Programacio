import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED = (255, 0, 0)
GREEN = (0, 255, 0)
BLUE  = (0, 0, 255)
PURPLE = (128, 0, 128)
ORANGE = (255, 165, 0) 
GOLD = (255, 215, 0)
NAVY = (0, 0, 128)

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Variables globals
mouse_pos = { "x": -1, "y": -1 }
rectangles = [
    { "rect": pygame.Rect(50, 100, 250, 50), "color": RED },
    { "rect": pygame.Rect(50, 200, 100, 200), "color": GOLD },
    { "rect": pygame.Rect(200, 200, 100, 100), "color": BLUE },
    { "rect": pygame.Rect(200, 350, 400, 50), "color": PURPLE },
    { "rect": pygame.Rect(350, 100, 50, 200), "color": ORANGE },
    { "rect": pygame.Rect(450, 100, 150, 100), "color": GREEN },
    { "rect": pygame.Rect(450, 250, 150, 50), "color": NAVY }
]
collide = -1

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
    global mouse_pos, collide
    
    collide = -1
    for cnt in range(len(rectangles)):
        obj = rectangles[cnt]
        mouse_point = (mouse_pos["x"], mouse_pos["y"])
        if obj["rect"].collidepoint(mouse_point):
            collide = cnt

# Dibuixar
def app_draw():
    global collide

    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar la graella
    utils.draw_grid(pygame, screen, 50)

    # Draw rectangles
    for cnt in range(len(rectangles)):
        obj = rectangles[cnt]

        if collide == cnt:
            pygame.draw.rect(screen, obj["color"], obj["rect"])

        pygame.draw.rect(screen, BLACK, obj["rect"], 5)

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

if __name__ == "__main__":
    main()
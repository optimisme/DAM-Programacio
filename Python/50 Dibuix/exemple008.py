import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
BLUE = (0, 0, 255)
GREEN = (0, 255, 0)

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Posició inicial del rectangle i cercle
rectangle_pos = pygame.Rect(100, 150, 200, 50)
circle_center = { "x": 400, "y": 175 }
circle_radius = 50

# Variables de l'estat del ratolí
mouse_pos = { "x": -1, "y": -1 }
mouse_down = False
square_dragging = False
circle_dragging = False
drag_offset = { "x": 0, "y": 0 }

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
    global mouse_pos, mouse_down
    mouse_inside = pygame.mouse.get_focused()  # El ratolí està dins de la finestra?

    for event in pygame.event.get():
        if event.type == pygame.QUIT:  # Botó tancar finestra
            return False
        elif event.type == pygame.MOUSEMOTION:
            if mouse_inside:
                mouse_pos["x"], mouse_pos["y"] = event.pos
        elif event.type == pygame.MOUSEBUTTONDOWN:
            mouse_down = True
        elif event.type == pygame.MOUSEBUTTONUP:
            mouse_down = False
    return True

# Fer càlculs
def app_run():
    global rectangle_pos, circle_center, square_dragging, circle_dragging, drag_offset

    # Inici de l'arrossegament en fer clic dins del rectangle o cercle
    if mouse_down:
        if not square_dragging and not circle_dragging:  # Només detecta al començar l'arrossegament
            if rectangle_pos.collidepoint(mouse_pos["x"], mouse_pos["y"]):
                square_dragging = True
                drag_offset["x"] = mouse_pos["x"] - rectangle_pos.x
                drag_offset["y"] = mouse_pos["y"] - rectangle_pos.y
            elif is_point_in_circle(mouse_pos, circle_center, circle_radius):
                circle_dragging = True
                drag_offset["x"] = mouse_pos["x"] - circle_center["x"]
                drag_offset["y"] = mouse_pos["y"] - circle_center["y"]
    else:
        # Alliberar l'arrossegament quan s'aixeca el ratolí
        square_dragging = False
        circle_dragging = False

    # Actualitza la posició del rectangle si es fa "drag"
    if square_dragging:
        rectangle_pos.x = mouse_pos["x"] - drag_offset["x"]
        rectangle_pos.y = mouse_pos["y"] - drag_offset["y"]

    # Actualitza la posició del cercle si es fa "drag"
    if circle_dragging:
        circle_center["x"] = mouse_pos["x"] - drag_offset["x"]
        circle_center["y"] = mouse_pos["y"] - drag_offset["y"]

# Dibuixar
def app_draw():
    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar la graella
    utils.draw_grid(pygame, screen, 50)

    # Dibuixar el rectangle
    rectangle_color = BLUE if square_dragging else BLACK
    pygame.draw.rect(screen, rectangle_color, rectangle_pos)

    # Dibuixar el cercle
    circle_color = GREEN if circle_dragging else BLACK
    pygame.draw.circle(screen, circle_color, (circle_center["x"], circle_center["y"]), circle_radius)

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

def is_point_in_circle(point, center, r):
    distancia = math.sqrt((point["x"] - center["x"]) ** 2 + (point["y"] - center["y"]) ** 2)
    return distancia <= r

if __name__ == "__main__":
    main()

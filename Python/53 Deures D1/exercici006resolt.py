#!/usr/bin/env python3

import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import random
import utils

# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED = (255, 0, 0)
YELLOW = (255, 255, 0)
GREEN = (0, 255, 0)
BLUE  = (0, 0, 255)

# Definir dimensions de la pantalla
WIDTH = 640
HEIGHT = 480

# Inicialitzar pygame
pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption('Atrapa les boles!')

# Variables globals del joc
font = pygame.font.SysFont("Arial", 18)

balls = []
balls_dropped = 0
balls_caught = 0

# Inicialitzar el joc
def init_game():
    global balls, balls_dropped, balls_caught
    balls = []
    balls_dropped = 0
    balls_caught = 0

    for i in range(10):
        add_ball(balls)

# Bucle principal de l'aplicació
def main():
    init_game()
    is_looping = True

    while is_looping:
        is_looping = app_events()
        app_run()
        app_draw()

        clock.tick(60) # Limitar a 60 FPS

    # Fora del bucle, tancar l'aplicació
    pygame.quit()
    sys.exit()

# Gestionar esdeveniments
def app_events():
    for event in pygame.event.get():
        if event.type == pygame.QUIT: # Botó tancar finestra
            return False
    return True

# Actualitzar lògica del joc
def app_run():
    global balls_caught, balls
    mouseX, mouseY = pygame.mouse.get_pos()
    for ball in balls:
        update_ball(ball)
        mouse = { "x": mouseX, "y": mouseY }
        collision = utils.is_point_in_circle(mouse, ball, ball["size"] / 2)
        if collision:
            ball['hovered'] = True
            balls_caught += 1
            init_ball(ball)
        else:
            ball['hovered'] = False

# Dibuixar elements a la pantalla
def app_draw():
    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar estadístiques
    display_stats()

    # Dibuixar boles
    for ball in balls:
        display_ball(ball)

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

# Afegir una nou globus a la llista de boles
def add_ball(arBalls):
    ball = {'x': 0, 'y': 0, 'color': '', 'size': 10, 'hovered': False}
    init_ball(ball)
    arBalls.append(ball)

# Iniciar/Reiniciar els valors d'un globus
def init_ball(ball):
    ball['x'] = random.randint(10, WIDTH - 10)
    ball['y'] = 10
    ball['color'] = random.choice([YELLOW, GREEN, BLUE, RED])
    ball['size'] = random.randint(10, 30)
    ball['hovered'] = False

# Mostrar un cercle individual
def display_ball(ball):
    pygame.draw.circle(screen, ball['color'], (int(ball['x']), int(ball['y'])), int(ball['size'] / 2), 0)
    if ball.get('hovered', False):
        pygame.draw.circle(screen, BLACK, (int(ball['x']), int(ball['y'])), int(ball['size'] / 2) + 5, 1)


# Mostrar estadístiques
def display_stats():
    caught_text = font.render(f"Atrapats: {balls_caught}", True, BLACK)
    dropped_text = font.render(f"Perduts: {balls_dropped}", True, BLACK)
    screen.blit(caught_text, (10, HEIGHT - 40))
    screen.blit(dropped_text, (10, HEIGHT - 20))

# Actualitzar un globus individual
def update_ball(ball):
    global balls_dropped
    ball['y'] += ball['size'] / 20 + balls_caught / 100
    if ball['y'] > HEIGHT:
        balls_dropped += 1
        init_ball(ball)


if __name__ == "__main__":
    main()

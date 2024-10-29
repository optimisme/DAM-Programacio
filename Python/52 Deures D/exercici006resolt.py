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
    pass

# Dibuixar
def app_draw():
    
    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar la graella
    utils.draw_grid(pygame, screen, 50)

    # Dibuixar les dades
    for hue in range(0, 361, 15):
        for counter in range(0, 100, 5):
            value = counter / 100

            x = 50 + hue * (500 / 360)
            y = 50 + counter * 4

            color = hsl_to_rgb(hue, 1.0, value)
            pygame.draw.rect(screen, color, pygame.Rect(x, y, 21, 21))

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

def hsl_to_rgb(hue, saturation, lightness):
    hue = hue / 360
    a = saturation * min(lightness, 1 - lightness)

    k_r = (0 + hue * 12) % 12
    k_g = (8 + hue * 12) % 12
    k_b = (4 + hue * 12) % 12

    r = int(255 * (lightness - a * max(-1, min(k_r - 3, 9 - k_r, 1))))
    g = int(255 * (lightness - a * max(-1, min(k_g - 3, 9 - k_g, 1))))
    b = int(255 * (lightness - a * max(-1, min(k_b - 3, 9 - k_b, 1))))

    return r, g, b

if __name__ == "__main__":
    main()
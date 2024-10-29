import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils
from assets.svgmoji.emojis import get_emoji

# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED = (255, 0, 0)
GREEN = (0, 255, 0)
BLUE  = (0, 0, 255)
PURPLE = (128, 0, 128)
ORANGE = (255, 165, 0)  

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')


# Posició de l'esquiador
skater_position = { "row": -1, "column": -1}

allowed_emojis = "🌲❄️☃️🏂"
emojis = get_emoji(pygame, allowed_emojis)
img_tree = emojis[0]
img_snow = emojis[1]
img_sman = emojis[2]
img_skater = emojis[3]
board = [
  ['','','','','','','','','☃️',''],
  ['','🌲','❄️','','','','','🌲','',''],
  ['','🌲','🌲','','','','','','❄️',''],
  ['','🌲',  '','','','','','','',''],
  ['','','','','','','','','',''],
  ['','','☃️','','','','','','🌲',''],
  ['','','','','','','🌲','🌲','',''],
  ['','❄️','🌲','','','','❄️','☃️','',''],
  ['','🌲','🌲','','','','','','',''],
]

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
    global position

    for event in pygame.event.get():
        if event.type == pygame.QUIT: # Botó tancar finestra
            return False
        if event.type == pygame.KEYUP:  # Tecla alliberada
            if event.key == pygame.K_LEFT:
                pass
            elif event.key == pygame.K_RIGHT:
                pass
            elif event.key == pygame.K_UP:
                pass
            elif event.key == pygame.K_DOWN:
                pass
    return True

# Fer càlculs
def app_run():
    pass

# Dibuixar
def app_draw():
    global pos_x, pos_y

    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar la graella
    utils.draw_grid(pygame, screen, 50)

    # Text informatiu
    font = pygame.font.SysFont("Arial", 24)
    text = font.render('Apreta les tecles (left/right)', True, BLACK)
    screen.blit(text, (50, 50))

    # Dibuixar el cercle
    center = (pos_x, 250)
    pygame.draw.circle(screen, BLACK, center, size)
    
    emojis = get_emoji(pygame, "😊⭐")
    for cnt in range(len(emojis)):
        emoji = emojis[cnt]

        screen.blit(emoji, (cnt * 25, 50))


    # Actualitzar el dibuix a la finestra
    pygame.display.update()

if __name__ == "__main__":
    main()
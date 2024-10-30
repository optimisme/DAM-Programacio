import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

# Definir colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
GREEN = (100, 150, 100)
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
    pass

# Dibuixar
def app_draw():
    screen.fill(WHITE)
    utils.draw_grid(pygame, screen, 50)
    
    # Fons vermell
    rect = pygame.Rect(50, 50,550, 100)
    pygame.draw.rect(screen, RED, rect)

    # Texts
    fontT = pygame.font.SysFont("Arial", 60)
    text = fontT.render('HEADLINE NEWS', True, WHITE)
    screen.blit(text, (75, 70))

    fontS = pygame.font.SysFont("Courier New", 40, bold=True)
    text = fontS.render('World goes Wrong!', True, BLACK)
    screen.blit(text, (50, 160))

    text = fontS.render('YEP#', True, GREEN)
    screen.blit(text, (510, 155))

    fontB = pygame.font.SysFont("Arial", 28)
    text0 = fontB.render("Lorem ipsum dolor sit amet, consectetur", True, BLACK)
    text1 = fontB.render("adipiscing elit, sed do eiusmod tempor", True, BLACK)
    text2 = fontB.render("incididunt ut labore et dolore magna aliqua.", True, BLACK)

    screen.blit(text0, (50, 250))
    screen.blit(text1, (50, 285))
    screen.blit(text2, (50, 320))

    pygame.display.update()

if __name__ == "__main__":
    main()
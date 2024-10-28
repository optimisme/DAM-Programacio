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

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption('Window Title')

# Bucle de l'aplicació
def main():
    global font, text, image

    is_looping = True

    # Definir el text
    font = pygame.font.SysFont("Arial", 55)
    text = font.render('Hello Arial!', True, BLACK)

    # Carregar la imatge
    image = pygame.image.load('./assets/exemple003.png')
    image = scale_image(image, target_width=100)

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

    # Text
    screen.blit(text, (50, 50))

    # Imatge
    screen.blit(image, (400, 50))

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

def scale_image(image, target_width=None, target_height=None):

    original_width, original_height = image.get_size()
    aspect_ratio = original_height / original_width

    if target_width and not target_height:  # Escalar per ample mantenint la proporció
        new_width = target_width
        new_height = int(target_width * aspect_ratio)
    elif target_height and not target_width:  # Escalar per altura mantenint la proporció
        new_height = target_height
        new_width = int(target_height / aspect_ratio)
    elif target_width and target_height:  # Escalar deformant la imatge
        new_width = target_width
        new_height = target_height
    else:
        raise ValueError("Especifica almenys un dels dos paràmetres: target_width o target_height.")

    scaled_image = pygame.transform.scale(image, (new_width, new_height))
    return scaled_image

if __name__ == "__main__":
    main()
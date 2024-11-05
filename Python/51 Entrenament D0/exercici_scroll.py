import pygame
pygame.init()

# Configuració de la finestra
screen = pygame.display.set_mode((640, 480))
pygame.display.set_caption("Creu Vermella en una Surface")

# Crear una Surface
surface = pygame.Surface((320, 240))  # Mida igual a la finestra
surface.fill((255, 255, 255))  # Fons blanc

# Dibuixar una creu vermella de cantonada a cantonada
surface.fill((200, 200, 200))  
pygame.draw.line(surface, (255, 0, 0), (0, 0), (surface.get_width(), surface.get_height()), 5) 
pygame.draw.line(surface, (255, 0, 0), (0, surface.get_height()), (surface.get_width(), 0), 5)

# Bucle principal
running = True
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # Netejar la finestra i dibuixar la Surface amb la creu vermella a la posició (0, 0)
    screen.fill((255, 255, 255))  
    screen.blit(surface, (50, 100)) 

    pygame.display.flip()  # Actualitzar la pantalla

pygame.quit()

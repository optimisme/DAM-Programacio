import os

def get_emoji(pygame, text, size=24):
    png_folder = os.path.join(os.path.dirname(__file__), "png")  # Ruta absoluta a png
    
    if text:
        first_char = text[0]
        codepoint = f"{ord(first_char):X}"
        png_path = os.path.join(png_folder, f"{codepoint}.png")
        
        if os.path.exists(png_path):
            image = pygame.image.load(png_path).convert_alpha()
            scaled_image = pygame.transform.smoothscale(image, (size, size))
            return scaled_image
        else:
            print(f"Imatge no trobada per a l'emoji: {first_char} (codi: {codepoint})")
    
    return None

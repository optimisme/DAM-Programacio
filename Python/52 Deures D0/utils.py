import re
import math
import subprocess
from IPython.display import display, Markdown

def show_code(file_path, function_name=None):
    """
    Mostra el codi font d'un fitxer Python complet o d'una funció específica.
    
    Args:
        file_path (str): Ruta al fitxer Python
        function_name (str, optional): Nom de la funció a mostrar. Si és None, 
                                     es mostra tot el fitxer.
    
    Returns:
        None: Mostra el codi formatat utilitzant IPython.display
    """
    try:
        with open(file_path, 'r', encoding='utf-8') as file:
            lines = file.readlines()
            content = ''.join(lines)
        
        if function_name:
            # Troba la línia on comença la funció
            func_pattern = rf"^[ \t]*def[ \t]+{re.escape(function_name)}[ \t]*\("
            start_line = None
            base_indent = None
            func_lines = []
            
            # Primer busquem decoradors
            for i, line in enumerate(lines):
                if line.strip().startswith('@'):
                    if i + 1 < len(lines) and re.match(func_pattern, lines[i + 1], re.MULTILINE):
                        start_line = i
                        base_indent = len(line) - len(line.lstrip())
                        break
                elif re.match(func_pattern, line, re.MULTILINE):
                    start_line = i
                    base_indent = len(line) - len(line.lstrip())
                    break
            
            if start_line is not None:
                # Afegim els decoradors i la definició de la funció
                current_line = start_line
                while current_line < len(lines):
                    line = lines[current_line]
                    if not line.strip():  # Línia en blanc
                        func_lines.append(line)
                        current_line += 1
                        continue
                        
                    indent = len(line) - len(line.lstrip())
                    # Si trobem una línia amb menys indentació que la base, hem sortit de la funció
                    if line.strip() and indent <= base_indent and current_line > start_line and not line.strip().startswith('@'):
                        break
                        
                    func_lines.append(line)
                    current_line += 1
                
                if func_lines:
                    content = ''.join(func_lines)
                else:
                    content = f"# Funció '{function_name}' no trobada al fitxer {file_path}"
            else:
                content = f"# Funció '{function_name}' no trobada al fitxer {file_path}"
        
        # Elimina espais en blanc extra al principi i final
        content = content.rstrip()
        
        # Mostra el codi formatat
        display(Markdown(f'```python\n{content}\n```'))
        
    except FileNotFoundError:
        print(f"Error: No s'ha trobat el fitxer '{file_path}'")
    except Exception as e:
        print(f"Error inesperat: {str(e)}")


def run_code(file_path):
    subprocess.Popen(['python3', file_path])

def draw_grid(pygame, screen, size):

    font = pygame.font.SysFont("Arial", 16)
    width, height = screen.get_size()

    grid_color = (100, 100, 100)
    
    for x in range(0, width, size):
        pygame.draw.line(screen, grid_color, (x, 0), (x, height))
        if x % 50 == 0:
            text = font.render(str(x), True, grid_color)
            screen.blit(text, (x, 0))
    
    for y in range(0, height, size):
        pygame.draw.line(screen, grid_color, (0, y), (width, y))
        if y % 50 == 0:
            text = font.render(str(y), True, grid_color)
            screen.blit(text, (0, y))

def scale_image(pygame, image, target_width=None, target_height=None):

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

    scaled_image = pygame.transform.smoothscale(image, (new_width, new_height))
    return scaled_image

def point_on_circle(center, radius, angle_degrees):
    # Returns the x,y position at circle perimeter
    angle_radians = math.radians(angle_degrees)  # Convert angle to radians
    x = center[0] + radius * math.cos(angle_radians)  # X coordinate
    y = center[1] + radius * math.sin(angle_radians)  # Y coordinate
    return x, y

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
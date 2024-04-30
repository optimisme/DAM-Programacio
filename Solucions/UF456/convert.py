import json
import os

def ipynb_to_md(ipynb_path, md_path):
    # Obrir el fitxer IPYNB i llegir les dades
    with open(ipynb_path, 'r', encoding='utf-8') as file:
        notebook = json.load(file)

    # Obrir el fitxer de sortida Markdown
    with open(md_path, 'w', encoding='utf-8') as md_file:
        # Iterar sobre les cel·les del notebook
        for cell in notebook['cells']:
            if cell['cell_type'] == 'markdown':
                # Escriure el contingut de la cel·la Markdown al fitxer
                for line in cell['source']:
                    md_file.write(line)
                md_file.write('\n\n')  # Afegir un espai entre cel·les

def convert_all_ipynb_to_md(start_dir):
    # Recórrer tots els fitxers i directoris de manera recursiva
    for root, dirs, files in os.walk(start_dir):
        for file in files:
            if file.endswith('.ipynb'):
                # Construir la ruta completa del fitxer IPYNB
                ipynb_path = os.path.join(root, file)
                # Construir la ruta del fitxer de sortida Markdown
                md_path = ipynb_path.replace('.ipynb', '.md')
                # Convertir el fitxer
                ipynb_to_md(ipynb_path, md_path)
                print(f"Converted: {ipynb_path} to {md_path}")

# Ruta inicial des de la qual començar la conversió
start_dir = '.'  # '.' representa el directori actual
convert_all_ipynb_to_md(start_dir)

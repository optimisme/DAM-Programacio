#!/usr/bin/env python3

# pip install keyboard
# python3 -m pip install keyboard --break-system-package

import keyboard
import threading

def escoltar_teclat():
    while True:
        if keyboard.is_pressed('up'):
            print('Fletxa amunt')
        elif keyboard.is_pressed('down'):
            print('Fletxa avall')
        elif keyboard.is_pressed('left'):
            print('Fletxa esquerra')
        elif keyboard.is_pressed('right'):
            print('Fletxa dreta')
        elif keyboard.is_pressed('enter'):
            print('Enter premut')
        elif keyboard.is_pressed('space'):
            print('Espai premut')

def escriure_text():
    while True:
        entrada = input("Escriu alguna cosa: ")
        print(f"Has escrit: {entrada}")

fil_escolta = threading.Thread(target=escoltar_teclat, daemon=True)
fil_escolta.start()

escriure_text()

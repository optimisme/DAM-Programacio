#!/usr/bin/env python3

import os
from io import StringIO
import unittest
from unittest.mock import patch
import Exercicis

def clearScreen():
    if os.name == 'nt':  # Si estàs en Windows
        os.system('cls')
    else:  # Si estàs en Linux o macOS
        os.system('clear')

clearScreen()

class TestSumaInfinit(unittest.TestCase):
    @patch('builtins.input', side_effect=["1", "2", "3", "sortir"])
    @patch('sys.stdout', new_callable=StringIO) 
    def test_suma_infinit(self, mock_stdout, mock_input):
        Exercicis.suma_infinit() 
        sortida = mock_stdout.getvalue().strip() 
        self.assertIn("La suma final és: 6.0", sortida) 

    @patch('builtins.input', side_effect=["1", "dos", "3", "sortir"])
    @patch('sys.stdout', new_callable=StringIO)  
    def test_suma_amb_entrada_invalida(self, mock_stdout, mock_input):
        Exercicis.suma_infinit() 
        sortida = mock_stdout.getvalue().strip() 
        self.assertIn("La suma final és: 4.0", sortida) 

    @patch('builtins.input', side_effect=["sortir"])
    @patch('sys.stdout', new_callable=StringIO)  
    def test_suma_buida(self, mock_stdout, mock_input):
        Exercicis.suma_infinit()  
        sortida = mock_stdout.getvalue().strip() 
        self.assertIn("La suma final és: 0", sortida)

    @patch('random.randint', return_value=5)
    @patch('sys.stdout', new_callable=StringIO)
    def test_multiplica_fins_100A(self, mock_stdout, mock_randint):
        Exercicis.multiplica_fins_100()
        sortida = mock_stdout.getvalue().strip()
        
        self.assertIn("El número inicial és: 5", sortida)
        self.assertIn("Resultat actual: 10", sortida)
        self.assertIn("Resultat actual: 20", sortida)
        self.assertIn("Resultat actual: 40", sortida)
        self.assertIn("Resultat actual: 80", sortida)
        self.assertIn("Resultat actual: 160", sortida)
        self.assertIn("Han fet falta 5 iteracions per superar 100.", sortida)

    @patch('random.randint', return_value=15) 
    @patch('sys.stdout', new_callable=StringIO)  
    def test_multiplica_fins_100B(self, mock_stdout, mock_randint):
        Exercicis.multiplica_fins_100() 
        sortida = mock_stdout.getvalue().strip()
        
        self.assertIn("El número inicial és: 15", sortida)
        self.assertIn("Resultat actual: 30", sortida)
        self.assertIn("Resultat actual: 60", sortida)
        self.assertIn("Resultat actual: 120", sortida)
        self.assertIn("Han fet falta 3 iteracions per superar 100.", sortida)

    @patch('builtins.input', side_effect=["1", "0"])
    @patch('sys.stdout', new_callable=StringIO)
    def test_opcio_saludar(self, mock_stdout, mock_input):
        Exercicis.gestionar_menu()
        sortida = mock_stdout.getvalue().strip()
        self.assertIn("Hola colega", sortida)
        self.assertIn("Sortint del programa...", sortida)

    @patch('builtins.input', side_effect=["2", "0"])
    @patch('sys.stdout', new_callable=StringIO)
    def test_opcio_presentar(self, mock_stdout, mock_input):
        Exercicis.gestionar_menu()
        sortida = mock_stdout.getvalue().strip()
        self.assertIn("Sóc un programa molón", sortida)
        self.assertIn("Sortint del programa...", sortida)

    @patch('builtins.input', side_effect=["3", "0"])
    @patch('random.choice', return_value="Pfff")  
    @patch('sys.stdout', new_callable=StringIO) 
    def test_opcio_vacilar(self, mock_stdout, mock_randchoice, mock_input):
        Exercicis.gestionar_menu()
        sortida = mock_stdout.getvalue().strip()
        self.assertIn("Pfff", sortida) 
        self.assertIn("Sortint del programa...", sortida)

    @patch('builtins.input', side_effect=["0"]) 
    @patch('sys.stdout', new_callable=StringIO)
    def test_opcio_sortir(self, mock_stdout, mock_input):
        Exercicis.gestionar_menu()
        sortida = mock_stdout.getvalue().strip()
        self.assertIn("Sortint del programa...", sortida)

    @patch('builtins.input', side_effect=["4", "0"]) 
    @patch('sys.stdout', new_callable=StringIO)
    def test_opcio_invalida(self, mock_stdout, mock_input):
        Exercicis.gestionar_menu()
        sortida = mock_stdout.getvalue().strip()
        self.assertIn("Opció no vàlida, torna-ho a provar.", sortida)
        self.assertIn("Sortint del programa...", sortida)

    @patch('random.randint', side_effect=[3, 5])  # Simulem que random.randint retorna 3 i 5
    @patch('sys.stdout', new_callable=StringIO)  # Captura la sortida de la consola
    def test_guions_ordenats_3_5(self, mock_stdout, mock_randint):
        Exercicis.guions_ordenats()  # Executem la funció
        sortida = mock_stdout.getvalue().strip()  # Obtenim la sortida de la consola

        # Comprovem si s'ha imprès la quantitat esperada de guions
        expected_output = ("--- --- --- --- ---").strip()
        self.assertEqual(sortida, expected_output)

    @patch('random.randint', side_effect=[4, 2])  # Simulem que random.randint retorna 4 i 2
    @patch('sys.stdout', new_callable=StringIO)  # Captura la sortida de la consola
    def test_guions_ordenats_4_2(self, mock_stdout, mock_randint):
        Exercicis.guions_ordenats()  # Executem la funció
        sortida = mock_stdout.getvalue().strip()  # Obtenim la sortida de la consola

        # Comprovem si s'ha imprès la quantitat esperada de guions
        expected_output = ("-- -- -- --").strip()
        self.assertEqual(sortida, expected_output)

    @patch('random.randint', side_effect=[5, 5])  # Simulem que random.randint retorna 5 i 5
    @patch('sys.stdout', new_callable=StringIO)  # Captura la sortida de la consola
    def test_guions_ordenats_5_5(self, mock_stdout, mock_randint):
        Exercicis.guions_ordenats()  # Executem la funció
        sortida = mock_stdout.getvalue().strip()  # Obtenim la sortida de la consola

        # Comprovem si s'ha imprès la quantitat esperada de guions
        expected_output = ("----- ----- ----- ----- -----").strip()
        self.assertEqual(sortida, expected_output)

    @patch('random.choice', return_value='suma')
    @patch('random.randint', side_effect=[2, 3])
    @patch('sys.stdout', new_callable=StringIO)
    def test_operacio_suma(self, mock_stdout, mock_randint, mock_choice):
        Exercicis.operacio_aleatoria()
        sortida = mock_stdout.getvalue().strip()
        self.assertIn("Operació: suma, Número inicial: 2, Vegades: 3", sortida)
        self.assertIn("El resultat final és: 8", sortida)

    @patch('random.choice', return_value='resta')
    @patch('random.randint', side_effect=[5, 2])
    @patch('sys.stdout', new_callable=StringIO)
    def test_operacio_resta(self, mock_stdout, mock_randint, mock_choice):
        Exercicis.operacio_aleatoria()
        sortida = mock_stdout.getvalue().strip()
        self.assertIn("Operació: resta, Número inicial: 5, Vegades: 2", sortida)
        self.assertIn("El resultat final és: -5", sortida)

    @patch('random.choice', return_value='multiplicacio')
    @patch('random.randint', side_effect=[3, 2])
    @patch('sys.stdout', new_callable=StringIO)
    def test_operacio_multiplicacio(self, mock_stdout, mock_randint, mock_choice):
        Exercicis.operacio_aleatoria()
        sortida = mock_stdout.getvalue().strip()
        self.assertIn("Operació: multiplicacio, Número inicial: 3, Vegades: 2", sortida)
        self.assertIn("El resultat final és: 27", sortida)

    @patch('random.choice', return_value='divisio')
    @patch('random.randint', side_effect=[4, 2])
    @patch('sys.stdout', new_callable=StringIO)
    def test_operacio_divisio(self, mock_stdout, mock_randint, mock_choice):
        Exercicis.operacio_aleatoria()
        sortida = mock_stdout.getvalue().strip()
        self.assertIn("Operació: divisio, Número inicial: 4, Vegades: 2", sortida)
        self.assertIn("El resultat final és: 0.25", sortida)

    @patch('random.choice', return_value='divisio')
    @patch('random.randint', side_effect=[0, 3])
    @patch('sys.stdout', new_callable=StringIO)
    def test_operacio_divisio_zero(self, mock_stdout, mock_randint, mock_choice):
        Exercicis.operacio_aleatoria()
        sortida = mock_stdout.getvalue().strip()
        self.assertIn("No es pot dividir per 0.", sortida)

if __name__ == '__main__':
    unittest.main()

#!/usr/bin/env python3

import unittest
from unittest.mock import patch, MagicMock, call
from io import StringIO
import sys
import random
from D_DausText import afegir_jugador, escollir_jugador, mostrar_puntuacions, jugar, mainRun

class TestAfegirJugador(unittest.TestCase):
    
    def test_afegir_nou_jugador(self):
        ranking = "pepe:150;Juan:100;"
        nou_ranking = afegir_jugador(ranking, "Pablo", 50)
        jugadors = [j for j in nou_ranking.split(";") if j]
        self.assertIn("Pablo:50", nou_ranking)
        self.assertEqual(len(jugadors), 3)

    def test_actualitzar_jugador_si_mes_alt(self):
        ranking = "pepe:150;Juan:100;"
        nou_ranking = afegir_jugador(ranking, "Juan", 120)
        jugadors = [j for j in nou_ranking.split(";") if j]
        self.assertIn("Juan:120", nou_ranking)
        self.assertEqual(len(jugadors), 2)

    def test_no_actualitzar_jugador_si_mes_baix(self):
        ranking = "pepe:150;Juan:100;"
        nou_ranking = afegir_jugador(ranking, "Juan", 90)
        jugadors = [j for j in nou_ranking.split(";") if j]
        self.assertIn("Juan:100", nou_ranking)  # Puntuació original no canvia
        self.assertEqual(len(jugadors), 2)

    def test_ranking_immutable_per_jugador_inexistent(self):
        ranking = "pepe:150;Juan:100;"
        nou_ranking = afegir_jugador(ranking, "Ana", 130)
        jugadors = [j for j in nou_ranking.split(";") if j]
        self.assertIn("Ana:130", nou_ranking)
        self.assertEqual(len(jugadors), 3)

class TestEscollirJugador(unittest.TestCase):

    @patch('builtins.input', side_effect=['1'])
    @patch('sys.stdout', new_callable=StringIO)
    def test_escollir_jugador_per_numero(self, mock_stdout, mock_input):
        ranking = "pepe:150;Juan:100;"
        jugador_seleccionat = escollir_jugador(ranking)
        self.assertEqual(jugador_seleccionat, "pepe")
        output = mock_stdout.getvalue()
        self.assertIn("1) pepe", output)
        self.assertIn("2) Juan", output)

    @patch('builtins.input', side_effect=['Juan'])
    @patch('sys.stdout', new_callable=StringIO)
    def test_escollir_jugador_per_nom(self, mock_stdout, mock_input):
        ranking = "pepe:150;Juan:100;"
        jugador_seleccionat = escollir_jugador(ranking)
        self.assertEqual(jugador_seleccionat, "Juan")
        output = mock_stdout.getvalue()
        self.assertIn("1) pepe", output)
        self.assertIn("2) Juan", output)

    @patch('builtins.input', side_effect=['3', '1'])
    @patch('sys.stdout', new_callable=StringIO)
    def test_escollir_numero_invalid(self, mock_stdout, mock_input):
        ranking = "pepe:150;Juan:100;"
        jugador_seleccionat = escollir_jugador(ranking)
        self.assertEqual(jugador_seleccionat, "pepe")
        output = mock_stdout.getvalue()
        self.assertIn("Número no vàlid, torna-ho a intentar.", output)

    @patch('builtins.input', side_effect=['Carlos', 'Juan'])
    @patch('sys.stdout', new_callable=StringIO)
    def test_escollir_nom_invalid(self, mock_stdout, mock_input):
        ranking = "pepe:150;Juan:100;"
        jugador_seleccionat = escollir_jugador(ranking)
        self.assertEqual(jugador_seleccionat, "Juan")
        output = mock_stdout.getvalue()
        self.assertIn("Nom no vàlid, torna-ho a intentar.", output)

    @patch('sys.stdout', new_callable=StringIO)
    def test_escollir_jugador_amb_ranking_buit(self, mock_stdout):
        ranking = ""
        jugador_seleccionat = escollir_jugador(ranking)
        self.assertIsNone(jugador_seleccionat)
        output = mock_stdout.getvalue()
        self.assertIn("No hi ha jugadors disponibles.", output)

class TestMostrarPuntuacions(unittest.TestCase):

    @patch('sys.stdout', new_callable=StringIO)
    def test_mostrar_puntuacions_ordenades(self, mock_stdout):
        ranking = "pepe:150;Juan:100;Pablo:50;"
        mostrar_puntuacions(ranking)
        output = mock_stdout.getvalue()

        expected_output = (
            "················ Ranking ················\n"
            "NOM                                 PUNTS\n"
            "*****************************************\n"
            "pepe                                  150\n"
            "Juan                                  100\n"
            "Pablo                                  50\n"
        )
        self.assertEqual(output, expected_output)

    @patch('sys.stdout', new_callable=StringIO)
    def test_mostrar_puntuacions_buit(self, mock_stdout):
        ranking = ""
        mostrar_puntuacions(ranking)
        output = mock_stdout.getvalue()

        expected_output = (
            "················ Ranking ················\n"
            "NOM                                 PUNTS\n"
            "*****************************************\n"
        )
        self.assertEqual(output, expected_output)

    @patch('sys.stdout', new_callable=StringIO)
    def test_mostrar_puntuacions_desordenades(self, mock_stdout):
        ranking = "pepe:100;Juan:150;Pablo:75;"
        mostrar_puntuacions(ranking)
        output = mock_stdout.getvalue()

        expected_output = (
            "················ Ranking ················\n"
            "NOM                                 PUNTS\n"
            "*****************************************\n"
            "Juan                                  150\n"
            "pepe                                  100\n"
            "Pablo                                  75\n"
        )
        self.assertEqual(output, expected_output)

class TestJugar(unittest.TestCase):

    @patch('random.randint', side_effect=[6, 6, 1, 1] * 50)
    @patch('sys.stdout', new_callable=StringIO)
    def test_guanya_jugador(self, mock_stdout, mock_randint):
        jugador = "pepe"
        punts_jugador = jugar(jugador)
        output = mock_stdout.getvalue()

        self.assertIn(f'Ha guanyat el jugador "{jugador}"', output)
        self.assertGreater(punts_jugador, 0)  # Punts positius pel jugador

    @patch('random.randint', side_effect=[1, 1, 6, 6] * 50)
    @patch('sys.stdout', new_callable=StringIO)
    def test_guanya_ordinador(self, mock_stdout, mock_randint):
        jugador = "pepe"
        punts_jugador = jugar(jugador)
        output = mock_stdout.getvalue()

        self.assertIn('Ha guanyat l\'ordinador', output)
        self.assertEqual(punts_jugador, -1)  # Retorna -1 quan guanya l'ordinador

if __name__ == '__main__':
    unittest.main()

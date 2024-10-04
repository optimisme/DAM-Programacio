#!/usr/bin/env python3

import unittest
from unittest.mock import patch
from io import StringIO
from B_TresEnRatlla import genera_tauler, dibuixa_tauler, fila_columna, posicio_valida, jugada_usuari, cerca_posicio_guanyadora, busca_guanyador, mainRun

class TestGeneraTauler(unittest.TestCase):
    def test_genera_tauler(self):
        # Resultat esperat: un tauler de 3x3 amb "·" en totes les posicions
        expected_tauler = [['·', '·', '·'],
                           ['·', '·', '·'],
                           ['·', '·', '·']]

        # Crida a la funció genera_tauler
        resultat = genera_tauler()

        # Comprovació que el resultat és igual al tauler esperat
        self.assertEqual(resultat, expected_tauler)

class TestDibuixaTauler(unittest.TestCase):
    @patch('sys.stdout', new_callable=StringIO)  # Redirigim la sortida estàndard a un objecte StringIO
    def test_dibuixa_tauler(self, mock_stdout):
        # Definim el tauler que volem provar
        tauler = [['X', '·', '·'], 
                  ['O', 'X', '·'], 
                  ['·', '·', 'O']]

        # Cridem la funció a provar
        dibuixa_tauler(tauler)

        # Definim la sortida esperada (incloent salts de línia)
        expected_output = "  0 1 2\nA X · ·\nB O X ·\nC · · O\n"

        # Comprovem si la sortida capturada és igual a la sortida esperada
        self.assertEqual(mock_stdout.getvalue(), expected_output)

    @patch('sys.stdout', new_callable=StringIO)  # Redirigim la sortida estàndard a un objecte StringIO
    def test_dibuixa_tauler_cas2(self, mock_stdout):
        # Definim un altre tauler per provar
        tauler = [['·', '·', 'X'], 
                  ['O', 'O', 'X'], 
                  ['X', '·', 'O']]

        # Cridem la funció a provar
        dibuixa_tauler(tauler)

        # Definim la sortida esperada (incloent salts de línia)
        expected_output = "  0 1 2\nA · · X\nB O O X\nC X · O\n"

        # Comprovem si la sortida capturada és igual a la sortida esperada
        self.assertEqual(mock_stdout.getvalue(), expected_output)

    def test_fila_columna_valides(self):
        # Casos vàlids
        self.assertEqual(fila_columna("A0"), (0, 0))
        self.assertEqual(fila_columna("B1"), (1, 1))
        self.assertEqual(fila_columna("C2"), (2, 2))
    
    def test_fila_columna_invalides(self):
        # Casos no vàlids
        self.assertEqual(fila_columna("D2"), (-1, -1))  # Fila incorrecta
        self.assertEqual(fila_columna("A3"), (-1, -1))  # Columna incorrecta
        self.assertEqual(fila_columna("B"), (-1, -1))   # Entrada massa curta
        self.assertEqual(fila_columna("B10"), (-1, -1)) # Entrada massa llarga
        self.assertEqual(fila_columna("E1"), (-1, -1))  # Fila fora dels límits
        self.assertEqual(fila_columna("A-1"), (-1, -1)) # Columna no vàlida
        self.assertEqual(fila_columna("A "), (-1, -1))  # Columna no vàlida (espai)
        self.assertEqual(fila_columna("A#"), (-1, -1))  # Caràcter no numèric

class TestPosicioValida(unittest.TestCase):
    def setUp(self):
        # Tauler per utilitzar en els tests
        self.tauler = [['X', '·', '·'], 
                       ['O', 'X', '·'], 
                       ['·', '·', 'O']]

    def test_posicio_valida(self):
        # Casos on la posició és vàlida i la casella està lliure
        self.assertTrue(posicio_valida(self.tauler, "A1"))  # Casella lliure
        self.assertTrue(posicio_valida(self.tauler, "C1"))  # Casella lliure

    def test_posicio_no_valida(self):
        # Casos on la posició és vàlida però la casella està ocupada
        self.assertFalse(posicio_valida(self.tauler, "A0"))  # Ocupada per "X"
        self.assertFalse(posicio_valida(self.tauler, "B0"))  # Ocupada per "O"
        self.assertFalse(posicio_valida(self.tauler, "C2"))  # Ocupada per "O"

    def test_posicio_fora_limits(self):
        # Casos on la posició no és vàlida (fora dels límits o format incorrecte)
        self.assertFalse(posicio_valida(self.tauler, "D1"))  # Fila fora de rang
        self.assertFalse(posicio_valida(self.tauler, "A3"))  # Columna fora de rang
        self.assertFalse(posicio_valida(self.tauler, "B"))   # Format incorrecte
        self.assertFalse(posicio_valida(self.tauler, "B10")) # Format incorrecte

class TestJugadaUsuari(unittest.TestCase):
    
    @patch('builtins.input', side_effect=['A1'])  # Simulem l'entrada de l'usuari
    @patch('B_TresEnRatlla.dibuixa_tauler')  # Evitem dibuixar el tauler a la consola durant el test
    def test_jugada_usuari_valida(self, mock_dibuixa, mock_input):
        # Definim un tauler inicial
        tauler = [['X', '·', '·'], 
                  ['O', 'X', '·'], 
                  ['·', '·', 'O']]
        
        # Cridem la funció jugada_usuari
        result = jugada_usuari(tauler)
        
        # Comprovem que la posició "A1" ha estat marcada amb una "X"
        expected_tauler = [['X', 'X', '·'], 
                           ['O', 'X', '·'], 
                           ['·', '·', 'O']]
        
        self.assertEqual(tauler, expected_tauler)
        self.assertIsNone(result)  # Ha de retornar None en cas de jugada vàlida

    @patch('builtins.input', side_effect=['SORTIR'])  # Simulem l'entrada de "SORTIR"
    @patch('B_TresEnRatlla.dibuixa_tauler')  # Evitem dibuixar el tauler a la consola durant el test
    def test_jugada_usuari_sortir(self, mock_dibuixa, mock_input):
        # Definim un tauler inicial
        tauler = [['X', '·', '·'], 
                  ['O', 'X', '·'], 
                  ['·', '·', 'O']]
        
        # Cridem la funció jugada_usuari
        result = jugada_usuari(tauler)
        
        # Comprovem que ha retornat "sortir"
        self.assertEqual(result, "sortir")

class TestCercaPosicioGuanyadora(unittest.TestCase):
    
    def test_guanyador_per_fila(self):
        # Cas on el jugador "X" pot guanyar completant una fila
        tauler = [['X', 'X', '·'], 
                  ['O', '·', '·'], 
                  ['·', 'O', '·']]
        self.assertEqual(cerca_posicio_guanyadora(tauler, 'X'), (0, 2))  # Completa la fila 0

    def test_guanyador_per_columna(self):
        # Cas on el jugador "O" pot guanyar completant una columna
        tauler = [['O', 'X', '·'], 
                  ['O', '·', 'X'], 
                  ['·', '·', '·']]
        self.assertEqual(cerca_posicio_guanyadora(tauler, 'O'), (2, 0))  # Completa la columna 0

    def test_guanyador_per_diagonal_1(self):
        # Cas on el jugador "X" pot guanyar completant la primera diagonal
        tauler = [['X', 'O', '·'], 
                  ['·', 'X', 'O'], 
                  ['·', '·', '·']]
        self.assertEqual(cerca_posicio_guanyadora(tauler, 'X'), (2, 2))  # Completa la diagonal 1

    def test_guanyador_per_diagonal_2(self):
        # Cas on el jugador "O" pot guanyar completant la segona diagonal
        tauler = [['X', '·', 'O'], 
                  ['X', 'O', '·'], 
                  ['·', '·', '·']]
        self.assertEqual(cerca_posicio_guanyadora(tauler, 'O'), (2, 0))  # Completa la diagonal 2

    def test_sense_guanyador(self):
        # Cas on no hi ha cap oportunitat guanyadora immediata
        tauler = [['X', '·', '·'], 
                  ['O', 'X', '·'], 
                  ['·', 'O', 'X']]
        self.assertIsNone(cerca_posicio_guanyadora(tauler, 'O'))  # No hi ha oportunitat guanyadora

    def test_no_caselles_lluires(self):
        # Cas on no hi ha cap casella lliure però no hi ha guanyador
        tauler = [['X', 'X', 'X'], 
                  ['O', 'O', 'X'], 
                  ['O', 'X', 'O']]
        self.assertIsNone(cerca_posicio_guanyadora(tauler, 'O'))  # Tauler complet, però no guanyador

class TestBuscaGuanyador(unittest.TestCase):
    
    def test_guanyador_per_fila(self):
        # Cas on el jugador "X" guanya completant una fila
        tauler = [['X', 'X', 'X'], 
                  ['O', '·', '·'], 
                  ['O', '·', '·']]
        self.assertEqual(busca_guanyador(tauler), 'X')  # X guanya per fila 0

    def test_guanyador_per_columna(self):
        # Cas on el jugador "O" guanya completant una columna
        tauler = [['O', 'X', '·'], 
                  ['O', '·', 'X'], 
                  ['O', '·', '·']]
        self.assertEqual(busca_guanyador(tauler), 'O')  # O guanya per columna 0

    def test_guanyador_per_diagonal_1(self):
        # Cas on el jugador "X" guanya completant la primera diagonal
        tauler = [['X', '·', 'O'], 
                  ['·', 'X', '·'], 
                  ['O', '·', 'X']]
        self.assertEqual(busca_guanyador(tauler), 'X')  # X guanya per la diagonal

    def test_guanyador_per_diagonal_2(self):
        # Cas on el jugador "O" guanya completant la segona diagonal
        tauler = [['X', '·', 'O'], 
                  ['X', 'O', '·'], 
                  ['O', '·', 'X']]
        self.assertEqual(busca_guanyador(tauler), 'O')  # O guanya per la segona diagonal

    def test_empatat(self):
        # Cas d'empat, no hi ha guanyador
        tauler = [['X', 'O', 'X'], 
                  ['O', 'O', 'X'], 
                  ['X', 'X', 'O']]
        self.assertEqual(busca_guanyador(tauler), '·')  # Empat, cap guanyador

    def test_joc_continua(self):
        # Cas on el joc encara continua (no hi ha guanyador i no està ple)
        tauler = [['X', '·', 'O'], 
                ['O', 'X', '·'], 
                ['·', 'O', '·']]
        self.assertEqual(busca_guanyador(tauler), '·') # Encara no hi ha guanyador, joc continua

class TestMainRun(unittest.TestCase):
    
    @patch('builtins.input', side_effect=['A0', 'B1', 'SORTIR'])  # Simulem les entrades de l'usuari
    @patch('B_TresEnRatlla.jugada_ordinador')  # Simulem el moviment de l'ordinador
    @patch('sys.stdout', new_callable=StringIO)  # Capturem la sortida a la consola
    def test_sortir(self, mock_stdout, mock_jugada_ordinador, mock_input):
        mainRun()
        # Comprovem que el joc ha sortit correctament
        self.assertIn("Has sortit del joc.", mock_stdout.getvalue())
    
    @patch('builtins.input', side_effect=['A0', 'B1', 'C2'])  # Simulem moviments de l'usuari
    @patch('B_TresEnRatlla.jugada_ordinador', side_effect=lambda tauler: tauler[0][1] == 'O')  # Simulem l'ordinador
    @patch('sys.stdout', new_callable=StringIO)  # Capturem la sortida a la consola
    def test_guanya_usuari(self, mock_stdout, mock_jugada_ordinador, mock_input):
        mainRun()
        # Comprovem que el jugador X ha guanyat
        self.assertIn("El guanyador és: X", mock_stdout.getvalue())

# Executar el test
if __name__ == '__main__':
    unittest.main()

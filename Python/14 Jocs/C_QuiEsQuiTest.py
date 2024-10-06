#!/usr/bin/env python3

import unittest
from unittest.mock import patch, MagicMock, call
from io import StringIO
import sys
import random
from C_QuiEsQui import genera_noms, escull_carta, genera_tauler, genera_partida, escriu_nom, selecciona_oponent, dibuixa_tauler_secret, fila_columna, posicio_valida, jugada_usuari, jugada_oponent, esborra_del_tauler, joc_del_qui_es_qui, mainRun

class TestGeneraNoms(unittest.TestCase):
    def setUp(self):
        self.expected_names = ['Phillip', 'Susan', 'Herman', 'Anne', 'Claire', 'Richard', 'Tom', 'Max', 'Sam', 'Anita', 'Joe', 'Maria']

    def test_genera_noms_length(self):
        """Test that genera_noms returns a list of 12 names"""
        result = genera_noms()
        self.assertEqual(len(result), 12, "The returned list should contain 12 names")

    def test_genera_noms_content(self):
        """Test that genera_noms returns a list containing all expected names"""
        result = genera_noms()
        self.assertSetEqual(set(result), set(self.expected_names), "The returned list should contain all expected names")

    def test_genera_noms_shuffled(self):
        """Test that genera_noms returns a shuffled list"""
        # We'll run the function multiple times to ensure it's shuffled
        results = [genera_noms() for _ in range(10)]
        
        # Check that at least one result is different from the original order
        self.assertTrue(any(result != self.expected_names for result in results),
                        "The function should return a shuffled list at least once in 10 tries")

    @patch('random.shuffle')
    def test_genera_noms_uses_shuffle(self, mock_shuffle):
        """Test that genera_noms uses random.shuffle"""
        genera_noms()
        mock_shuffle.assert_called_once()

class TestEscullCarta(unittest.TestCase):
    def setUp(self):
        self.expected_names = ['Phillip', 'Susan', 'Herman', 'Anne', 'Claire', 'Richard', 'Tom', 'Max', 'Sam', 'Anita', 'Joe', 'Maria']

    def test_escull_carta_returns_string(self):
        """Test that escull_carta returns a string"""
        result = escull_carta()
        self.assertIsInstance(result, str, "The function should return a string")

    def test_escull_carta_returns_valid_name(self):
        """Test that escull_carta returns a name from the expected list"""
        result = escull_carta()
        self.assertIn(result, self.expected_names, "The returned name should be in the list of expected names")

    @patch('C_QuiEsQui.genera_noms')
    def test_escull_carta_returns_last_name(self, mock_genera_noms):
        """Test that escull_carta returns the last name from the generated list"""
        mock_baralla = ['Anne', 'Tom', 'Susan']
        mock_genera_noms.return_value = mock_baralla
        result = escull_carta()
        self.assertEqual(result, 'Susan', "The function should return the last name from the generated list")

    @patch('C_QuiEsQui.genera_noms')
    def test_escull_carta_calls_genera_noms(self, mock_genera_noms):
        """Test that escull_carta calls genera_noms"""
        escull_carta()
        mock_genera_noms.assert_called_once()

class TestGeneraTauler(unittest.TestCase):
    def setUp(self):
        self.expected_names = ['Phillip', 'Susan', 'Herman', 'Anne', 'Claire', 'Richard', 'Tom', 'Max', 'Sam', 'Anita', 'Joe', 'Maria']

    def test_genera_tauler_structure(self):
        """Test que genera_tauler retorna una llista de 3 llistes, cadascuna amb 4 elements"""
        tauler = genera_tauler()
        self.assertEqual(len(tauler), 3, "El tauler hauria de tenir 3 files")
        for fila in tauler:
            self.assertEqual(len(fila), 4, "Cada fila hauria de tenir 4 elements")

    def test_genera_tauler_content(self):
        """Test que genera_tauler conté tots els noms esperats"""
        tauler = genera_tauler()
        noms_tauler = [nom for fila in tauler for nom in fila]
        self.assertSetEqual(set(noms_tauler), set(self.expected_names), "El tauler hauria de contenir tots els noms esperats")

    @patch('C_QuiEsQui.genera_noms')
    def test_genera_tauler_uses_genera_noms(self, mock_genera_noms):
        """Test que genera_tauler crida genera_noms"""
        mock_genera_noms.return_value = self.expected_names
        genera_tauler()
        mock_genera_noms.assert_called_once()

    def test_genera_tauler_shuffled(self):
        """Test que genera_tauler retorna un tauler barrejat"""
        taulers = [genera_tauler() for _ in range(10)]
        
        # Comprovem que almenys un tauler és diferent dels altres
        self.assertTrue(any(tauler != taulers[0] for tauler in taulers[1:]),
                        "La funció hauria de retornar taulers barrejats")

class TestGeneraPartida(unittest.TestCase):
    def setUp(self):
        self.expected_names = ['Phillip', 'Susan', 'Herman', 'Anne', 'Claire', 'Richard', 'Tom', 'Max', 'Sam', 'Anita', 'Joe', 'Maria']

    def test_genera_partida_structure(self):
        """Test que genera_partida retorna una llista amb 4 elements"""
        partida = genera_partida()
        self.assertEqual(len(partida), 4, "genera_partida hauria de retornar 4 elements")

    def test_genera_partida_personatges(self):
        """Test que els dos primers elements són personatges vàlids"""
        partida = genera_partida()
        self.assertIn(partida[0], self.expected_names, "El personatge de l'usuari hauria de ser un nom vàlid")
        self.assertIn(partida[1], self.expected_names, "El personatge de l'ordinador hauria de ser un nom vàlid")

    def test_genera_partida_taulers(self):
        """Test que els dos últims elements són taulers vàlids"""
        partida = genera_partida()
        for tauler in partida[2:]:
            self.assertEqual(len(tauler), 3, "Cada tauler hauria de tenir 3 files")
            for fila in tauler:
                self.assertEqual(len(fila), 4, "Cada fila del tauler hauria de tenir 4 elements")

    @patch('C_QuiEsQui.escull_carta')
    @patch('C_QuiEsQui.genera_tauler')
    def test_genera_partida_calls(self, mock_genera_tauler, mock_escull_carta):
        """Test que genera_partida crida les funcions correctes"""
        mock_escull_carta.side_effect = ['Maria', 'Tom']
        mock_genera_tauler.return_value = [['Phillip', 'Susan', 'Herman', 'Anne']] * 3

        genera_partida()

        self.assertEqual(mock_escull_carta.call_count, 2, "escull_carta hauria de ser cridat dues vegades")
        self.assertEqual(mock_genera_tauler.call_count, 2, "genera_tauler hauria de ser cridat dues vegades")

    def test_genera_partida_independent_personatges(self):
        """Test que els personatges de l'usuari i l'ordinador són independents"""
        partides = [genera_partida() for _ in range(10)]
        personatges_diferents = any(partida[0] != partida[1] for partida in partides)
        self.assertTrue(personatges_diferents, "Els personatges de l'usuari i l'ordinador haurien de ser independents")

class TestEscriuNom(unittest.TestCase):
    @patch('builtins.input', side_effect=['Albert'])
    def test_escriu_nom_valid(self, mock_input):
        """Test que escriu_nom accepta un nom vàlid"""
        resultat = escriu_nom()
        self.assertEqual(resultat, 'Albert', "La funció hauria de retornar el nom vàlid introduït")

    @patch('builtins.input', side_effect=['Albert123', 'Maria'])
    @patch('sys.stdout', new_callable=StringIO)
    def test_escriu_nom_invalid_then_valid(self, mock_stdout, mock_input):
        """Test que escriu_nom rebutja un nom invàlid i després accepta un de vàlid"""
        resultat = escriu_nom()
        self.assertEqual(resultat, 'Maria', "La funció hauria de retornar el segon nom vàlid introduït")
        self.assertIn("Error: El nom no pot contenir números. Torna a provar.", mock_stdout.getvalue())

    @patch('builtins.input', side_effect=['123', '456', 'Anna'])
    @patch('sys.stdout', new_callable=StringIO)
    def test_escriu_nom_multiple_invalid(self, mock_stdout, mock_input):
        """Test que escriu_nom rebutja múltiples noms invàlids i finalment accepta un de vàlid"""
        resultat = escriu_nom()
        self.assertEqual(resultat, 'Anna', "La funció hauria de retornar el nom vàlid final")
        self.assertEqual(mock_stdout.getvalue().count("Error: El nom no pot contenir números. Torna a provar."), 2)

    @patch('builtins.input', side_effect=['', 'Joan'])
    def test_escriu_nom_empty_then_valid(self, mock_input):
        """Test que escriu_nom accepta un nom buit i després un de vàlid"""
        resultat = escriu_nom()
        self.assertEqual(resultat, '', "La funció hauria de retornar el nom buit com a vàlid")

    @patch('builtins.input', side_effect=['   ', 'Pere'])
    def test_escriu_nom_whitespace_then_valid(self, mock_input):
        """Test que escriu_nom accepta un nom amb només espais en blanc i després un de vàlid"""
        resultat = escriu_nom()
        self.assertEqual(resultat, '   ', "La funció hauria de retornar el nom amb espais en blanc com a vàlid")

class TestSeleccionaOponent(unittest.TestCase):
    def setUp(self):
        self.oponents = ['Romulus', 'Tarpeia', 'Horatius', 'Cloelia', 'Brutus', 'Lucretia']

    @patch('sys.stdout', new_callable=StringIO)
    @patch('builtins.input', side_effect=['Brutus'])
    @patch('C_QuiEsQui.clearScreen')
    def test_selecciona_oponent_valid(self, mock_clear, mock_input, mock_stdout):
        resultat = selecciona_oponent()
        self.assertEqual(resultat, 'Brutus', "La funció hauria de retornar l'oponent vàlid seleccionat")
        mock_clear.assert_called_once()
        self.assertIn(", ".join(self.oponents), mock_stdout.getvalue())

    @patch('sys.stdout', new_callable=StringIO)
    @patch('builtins.input', side_effect=['Invalid', 'Tarpeia'])
    @patch('C_QuiEsQui.clearScreen')
    def test_selecciona_oponent_invalid_then_valid(self, mock_clear, mock_input, mock_stdout):
        resultat = selecciona_oponent()
        self.assertEqual(resultat, 'Tarpeia', "La funció hauria de retornar el segon oponent vàlid seleccionat")
        self.assertEqual(mock_clear.call_count, 2, "clearScreen hauria de ser cridat dues vegades")
        self.assertIn("Error! Selecciona un oponent vàlid.", mock_stdout.getvalue())
        self.assertIn(", ".join(self.oponents), mock_stdout.getvalue())

    @patch('sys.stdout', new_callable=StringIO)
    @patch('builtins.input', side_effect=['Invalid1', 'Invalid2', 'Cloelia'])
    @patch('C_QuiEsQui.clearScreen')
    def test_selecciona_oponent_multiple_invalid(self, mock_clear, mock_input, mock_stdout):
        resultat = selecciona_oponent()
        self.assertEqual(resultat, 'Cloelia', "La funció hauria de retornar l'oponent vàlid final")
        self.assertEqual(mock_clear.call_count, 3, "clearScreen hauria de ser cridat tres vegades")
        self.assertEqual(mock_stdout.getvalue().count("Error! Selecciona un oponent vàlid."), 2)
        self.assertEqual(mock_stdout.getvalue().count(", ".join(self.oponents)), 3)

    @patch('sys.stdout', new_callable=StringIO)
    @patch('builtins.input', side_effect=['', 'Romulus'])
    @patch('C_QuiEsQui.clearScreen')
    def test_selecciona_oponent_empty_input(self, mock_clear, mock_input, mock_stdout):
        resultat = selecciona_oponent()
        self.assertEqual(resultat, 'Romulus', "La funció hauria de rebutjar l'entrada buida i acceptar 'Romulus'")
        self.assertIn("Error! Selecciona un oponent vàlid.", mock_stdout.getvalue())
        self.assertEqual(mock_input.call_count, 2, "La funció hauria de demanar input dues vegades")
        self.assertIn(", ".join(self.oponents), mock_stdout.getvalue())

    @patch('sys.stdout', new_callable=StringIO)
    @patch('builtins.input', side_effect=['ROMULUS', 'Brutus'])
    @patch('C_QuiEsQui.clearScreen')
    def test_selecciona_oponent_case_sensitive(self, mock_clear, mock_input, mock_stdout):
        resultat = selecciona_oponent()
        self.assertEqual(resultat, 'Brutus', "La funció hauria de rebutjar 'ROMULUS' i acceptar 'Brutus'")
        self.assertEqual(mock_input.call_count, 2, "La funció hauria de demanar input dues vegades")
        mock_clear.assert_called()
        self.assertIn("Error! Selecciona un oponent vàlid.", mock_stdout.getvalue())
        self.assertIn(", ".join(self.oponents), mock_stdout.getvalue())
class TestDibuixaTaulerSecret(unittest.TestCase):
    def setUp(self):
        self.tauler = [
            ['Phillip', 'Susan', 'Herman', 'Anne'],
            ['Claire', 'Richard', 'Tom', 'Max'],
            ['Sam', 'Anita', 'Joe', 'Maria']
        ]

    @patch('sys.stdout', new_callable=StringIO)
    def test_dibuixa_tauler_secret_buit(self, mock_stdout):
        """Test que dibuixa_tauler_secret dibuixa correctament un tauler sense descoberts"""
        descoberts = set()
        dibuixa_tauler_secret(self.tauler, descoberts)
        expected_output = "  0 1 2 3\nA ? ? ? ?\nB ? ? ? ?\nC ? ? ? ?\n"
        self.assertEqual(mock_stdout.getvalue(), expected_output)

    @patch('sys.stdout', new_callable=StringIO)
    def test_dibuixa_tauler_secret_amb_descoberts(self, mock_stdout):
        """Test que dibuixa_tauler_secret dibuixa correctament un tauler amb algunes caselles descobertes"""
        descoberts = {(0, 0), (1, 1)}
        dibuixa_tauler_secret(self.tauler, descoberts)
        expected_output = "  0 1 2 3\nA X ? ? ?\nB ? X ? ?\nC ? ? ? ?\n"
        self.assertEqual(mock_stdout.getvalue(), expected_output)

    @patch('sys.stdout', new_callable=StringIO)
    def test_dibuixa_tauler_secret_tot_descobert(self, mock_stdout):
        """Test que dibuixa_tauler_secret dibuixa correctament un tauler completament descobert"""
        descoberts = {(i, j) for i in range(3) for j in range(4)}
        dibuixa_tauler_secret(self.tauler, descoberts)
        expected_output = "  0 1 2 3\nA X X X X\nB X X X X\nC X X X X\n"
        self.assertEqual(mock_stdout.getvalue(), expected_output)

    @patch('sys.stdout', new_callable=StringIO)
    def test_dibuixa_tauler_secret_format(self, mock_stdout):
        """Test que dibuixa_tauler_secret utilitza el format correcte per a les files i columnes"""
        descoberts = set()
        dibuixa_tauler_secret(self.tauler, descoberts)
        output = mock_stdout.getvalue().split('\n')
        self.assertEqual(output[0], "  0 1 2 3", "La primera línia hauria de mostrar els números de columna")
        self.assertTrue(output[1].startswith("A"), "La segona línia hauria de començar amb 'A'")
        self.assertTrue(output[2].startswith("B"), "La tercera línia hauria de començar amb 'B'")
        self.assertTrue(output[3].startswith("C"), "La quarta línia hauria de començar amb 'C'")

    @patch('sys.stdout', new_callable=StringIO)
    def test_dibuixa_tauler_secret_no_return(self, mock_stdout):
        """Test que dibuixa_tauler_secret no retorna res"""
        descoberts = set()
        result = dibuixa_tauler_secret(self.tauler, descoberts)
        self.assertIsNone(result, "La funció no hauria de retornar res")
        # Verifiquem que s'ha generat alguna sortida sense mostrar-la
        self.assertTrue(len(mock_stdout.getvalue()) > 0, "La funció hauria de generar alguna sortida")

class TestFilaColumna(unittest.TestCase):
    def test_posicio_valida(self):
        """Test que fila_columna retorna les coordenades correctes per a posicions vàlides"""
        self.assertEqual(fila_columna("A0"), (0, 0), "A0 hauria de retornar (0, 0)")
        self.assertEqual(fila_columna("B2"), (1, 2), "B2 hauria de retornar (1, 2)")
        self.assertEqual(fila_columna("C3"), (2, 3), "C3 hauria de retornar (2, 3)")

    def test_posicio_invalida_fora_de_rang(self):
        """Test que fila_columna retorna -1 per a posicions fora de rang"""
        self.assertEqual(fila_columna("D0"), -1, "D0 hauria de retornar -1 (fila invàlida)")
        self.assertEqual(fila_columna("A4"), -1, "A4 hauria de retornar -1 (columna invàlida)")
        self.assertEqual(fila_columna("D4"), -1, "D4 hauria de retornar -1 (fila i columna invàlides)")

    def test_posicio_invalida_format_incorrecte(self):
        """Test que fila_columna retorna -1 per a posicions amb format incorrecte"""
        self.assertEqual(fila_columna("A"), -1, "A hauria de retornar -1 (falta la columna)")
        self.assertEqual(fila_columna("12"), -1, "12 hauria de retornar -1 (falta la lletra de fila)")
        self.assertEqual(fila_columna("ABC"), -1, "ABC hauria de retornar -1 (massa caràcters)")
        self.assertEqual(fila_columna(""), -1, "Una cadena buida hauria de retornar -1")

    def test_posicio_valida_minuscules(self):
        """Test que fila_columna funciona correctament amb lletres minúscules"""
        self.assertEqual(fila_columna("a0"), (0, 0), "a0 hauria de retornar (0, 0)")
        self.assertEqual(fila_columna("b2"), (1, 2), "b2 hauria de retornar (1, 2)")

    def test_posicio_invalida_no_numeros(self):
        """Test que fila_columna retorna -1 per a posicions amb caràcters no numèrics a la columna"""
        self.assertEqual(fila_columna("AA"), -1, "AA hauria de retornar -1 (columna no numèrica)")
        self.assertEqual(fila_columna("A-"), -1, "A- hauria de retornar -1 (columna no numèrica)")

    def test_posicio_invalida_numeros_negatius(self):
        """Test que fila_columna retorna -1 per a posicions amb números negatius"""
        self.assertEqual(fila_columna("A-1"), -1, "A-1 hauria de retornar -1 (columna negativa)")

class TestPosicioValida(unittest.TestCase):
    def setUp(self):
        self.descoberts = {(0, 0), (1, 1)}

    def test_posicio_valida_no_descoberta(self):
        """Test que posicio_valida retorna True per a una posició vàlida no descoberta"""
        self.assertTrue(posicio_valida("A1", self.descoberts))
        self.assertTrue(posicio_valida("B2", self.descoberts))
        self.assertTrue(posicio_valida("C3", self.descoberts))

    def test_posicio_valida_descoberta(self):
        """Test que posicio_valida retorna False per a una posició vàlida però ja descoberta"""
        self.assertFalse(posicio_valida("A0", self.descoberts))
        self.assertFalse(posicio_valida("B1", self.descoberts))

    def test_posicio_invalida(self):
        """Test que posicio_valida retorna False per a posicions invàlides"""
        self.assertFalse(posicio_valida("D0", self.descoberts))
        self.assertFalse(posicio_valida("A4", self.descoberts))
        self.assertFalse(posicio_valida("AA", self.descoberts))
        self.assertFalse(posicio_valida("", self.descoberts))

    @patch('C_QuiEsQui.fila_columna')
    def test_fila_columna_called(self, mock_fila_columna):
        """Test que posicio_valida crida a fila_columna"""
        mock_fila_columna.return_value = (0, 1)
        posicio_valida("A1", self.descoberts)
        mock_fila_columna.assert_called_once_with("A1")

    def test_descoberts_empty(self):
        """Test que posicio_valida funciona correctament amb un conjunt buit de descoberts"""
        descoberts_buits = set()
        self.assertTrue(posicio_valida("A0", descoberts_buits))
        self.assertTrue(posicio_valida("B1", descoberts_buits))

    def test_descoberts_full(self):
        """Test que posicio_valida retorna False quan totes les posicions estan descobertes"""
        descoberts_complets = {(i, j) for i in range(3) for j in range(4)}
        self.assertFalse(posicio_valida("A0", descoberts_complets))
        self.assertFalse(posicio_valida("C3", descoberts_complets))

class TestJugadaUsuari(unittest.TestCase):
    def setUp(self):
        self.tauler_oponent = [
            ['Phillip', 'Susan', 'Herman', 'Anne'],
            ['Claire', 'Richard', 'Tom', 'Max'],
            ['Sam', 'Anita', 'Joe', 'Maria']
        ]
        self.descoberts = {(0, 0)}
        self.held, sys.stdout = sys.stdout, StringIO()  # Captura global de stdout

    def tearDown(self):
        sys.stdout = self.held  # Restaura stdout

    @patch('builtins.input', side_effect=['A1'])
    @patch('C_QuiEsQui.dibuixa_tauler_secret')
    @patch('C_QuiEsQui.posicio_valida', return_value=True)
    @patch('C_QuiEsQui.fila_columna', return_value=(0, 1))
    def test_jugada_valida(self, mock_fila_columna, mock_posicio_valida, mock_dibuixa, mock_input):
        resultat = jugada_usuari(self.tauler_oponent, self.descoberts)
        self.assertEqual(resultat, 'Susan')
        mock_dibuixa.assert_called_once()
        mock_posicio_valida.assert_called_once_with('A1', self.descoberts)
        mock_fila_columna.assert_called_once_with('A1')
        self.assertIn((0, 1), self.descoberts)
        self.assertNotIn("Posició no vàlida. Torna a provar.", sys.stdout.getvalue())

    @patch('builtins.input', side_effect=['D0', 'A4', 'A1'])
    @patch('C_QuiEsQui.dibuixa_tauler_secret')
    @patch('C_QuiEsQui.posicio_valida', side_effect=[False, False, True])
    @patch('C_QuiEsQui.fila_columna', return_value=(0, 1))
    def test_jugades_invalides_abans_valida(self, mock_fila_columna, mock_posicio_valida, mock_dibuixa, mock_input):
        resultat = jugada_usuari(self.tauler_oponent, self.descoberts)
        self.assertEqual(resultat, 'Susan')
        self.assertEqual(mock_dibuixa.call_count, 3)
        self.assertEqual(mock_posicio_valida.call_count, 3)
        self.assertEqual(sys.stdout.getvalue().count("Posició no vàlida. Torna a provar."), 2)

    @patch('builtins.input', side_effect=['A0', 'B1'])
    @patch('C_QuiEsQui.dibuixa_tauler_secret')
    @patch('C_QuiEsQui.posicio_valida', side_effect=[False, True])
    @patch('C_QuiEsQui.fila_columna', return_value=(1, 1))
    def test_posicio_ja_descoberta(self, mock_fila_columna, mock_posicio_valida, mock_dibuixa, mock_input):
        resultat = jugada_usuari(self.tauler_oponent, self.descoberts)
        self.assertEqual(resultat, 'Richard')
        self.assertEqual(mock_dibuixa.call_count, 2)
        self.assertEqual(mock_posicio_valida.call_count, 2)
        self.assertIn((1, 1), self.descoberts)
        self.assertIn("Posició no vàlida. Torna a provar.", sys.stdout.getvalue())

    @patch('builtins.input', side_effect=['', 'A1'])
    @patch('C_QuiEsQui.dibuixa_tauler_secret')
    @patch('C_QuiEsQui.posicio_valida', side_effect=[False, True])
    @patch('C_QuiEsQui.fila_columna', return_value=(0, 1))
    def test_entrada_buida(self, mock_fila_columna, mock_posicio_valida, mock_dibuixa, mock_input):
        resultat = jugada_usuari(self.tauler_oponent, self.descoberts)
        self.assertEqual(resultat, 'Susan')
        self.assertEqual(mock_dibuixa.call_count, 2)
        mock_dibuixa.assert_has_calls([
            call(self.tauler_oponent, self.descoberts),
            call(self.tauler_oponent, self.descoberts)
        ])
        self.assertEqual(mock_posicio_valida.call_count, 2)
        mock_posicio_valida.assert_has_calls([
            call('', self.descoberts),
            call('A1', self.descoberts)
        ])
        self.assertIn("Posició no vàlida. Torna a provar.", sys.stdout.getvalue())
        self.assertIn((0, 1), self.descoberts)

class TestJugadaOponent(unittest.TestCase):
    def setUp(self):
        self.tauler_usuari = [
            ['Phillip', 'Susan', 'Herman', 'Anne'],
            ['Claire', 'Richard', 'Tom', 'Max'],
            ['Sam', 'Anita', 'Joe', 'Maria']
        ]
        self.descoberts = set()

    @patch('random.randint')
    def test_seleccio_valida(self, mock_randint):
        mock_randint.side_effect = [0, 1]  # Simula la selecció de la posició (0, 1)
        resultat = jugada_oponent(self.tauler_usuari, self.descoberts)
        self.assertEqual(resultat, 'Susan')
        self.assertIn((0, 1), self.descoberts)
        self.assertEqual(len(self.descoberts), 1)

    @patch('random.randint')
    def test_seleccio_multiple_fins_valida(self, mock_randint):
        self.descoberts = {(0, 0), (0, 1), (0, 2)}
        mock_randint.side_effect = [0, 0, 0, 1, 0, 2, 0, 3]  # Simula seleccions invàlides i després una vàlida
        resultat = jugada_oponent(self.tauler_usuari, self.descoberts)
        self.assertEqual(resultat, 'Anne')
        self.assertIn((0, 3), self.descoberts)
        self.assertEqual(len(self.descoberts), 4)

    @patch('random.randint')
    def test_actualitzacio_descoberts(self, mock_randint):
        mock_randint.side_effect = [1, 2]  # Simula la selecció de la posició (1, 2)
        jugada_oponent(self.tauler_usuari, self.descoberts)
        self.assertEqual(len(self.descoberts), 1)
        self.assertIn((1, 2), self.descoberts)

    @patch('random.randint')
    def test_multiples_jugades(self, mock_randint):
        mock_randint.side_effect = [0, 0, 1, 1, 2, 2]  # Simula tres jugades diferents
        for _ in range(3):
            jugada_oponent(self.tauler_usuari, self.descoberts)
        self.assertEqual(len(self.descoberts), 3)
        self.assertIn((0, 0), self.descoberts)
        self.assertIn((1, 1), self.descoberts)
        self.assertIn((2, 2), self.descoberts)

    @patch('random.randint')
    def test_limits_tauler(self, mock_randint):
        mock_randint.side_effect = [0, 0, 2, 3]  # Simula seleccions als límits del tauler
        jugada_oponent(self.tauler_usuari, self.descoberts)
        self.assertIn((0, 0), self.descoberts)
        jugada_oponent(self.tauler_usuari, self.descoberts)
        self.assertIn((2, 3), self.descoberts)
        self.assertEqual(len(self.descoberts), 2)

    @patch('random.randint')
    def test_evita_posicions_descobertes(self, mock_randint):
        self.descoberts = {(0, 0), (0, 1)}
        mock_randint.side_effect = [0, 0, 0, 1, 0, 2]  # Simula intents de seleccionar posicions ja descobertes
        resultat = jugada_oponent(self.tauler_usuari, self.descoberts)
        self.assertEqual(resultat, 'Herman')
        self.assertIn((0, 2), self.descoberts)
        self.assertEqual(len(self.descoberts), 3)

class TestEsborraDelTauler(unittest.TestCase):
    def setUp(self):
        self.tauler = [
            ['Phillip', 'Susan', 'Herman', 'Anne'],
            ['Claire', 'Richard', 'Tom', 'Max'],
            ['Sam', 'Anita', 'Joe', 'Maria']
        ]

    def test_esborra_personatge_existent(self):
        esborra_del_tauler(self.tauler, 'Phillip')
        self.assertEqual(self.tauler[0][0], "")
        self.assertNotIn('Phillip', [nom for fila in self.tauler for nom in fila])

    def test_esborra_personatge_no_existent(self):
        tauler_original = [fila[:] for fila in self.tauler]
        esborra_del_tauler(self.tauler, 'John')
        self.assertEqual(self.tauler, tauler_original)

    def test_esborra_personatge_multiple(self):
        tauler_amb_duplicats = [
            ['Phillip', 'Susan', 'Herman', 'Phillip'],
            ['Claire', 'Richard', 'Tom', 'Max'],
            ['Sam', 'Anita', 'Joe', 'Phillip']
        ]
        esborra_del_tauler(tauler_amb_duplicats, 'Phillip')
        self.assertNotIn('Phillip', [nom for fila in tauler_amb_duplicats for nom in fila])
        self.assertEqual(tauler_amb_duplicats[0][0], "")
        self.assertEqual(tauler_amb_duplicats[0][3], "")
        self.assertEqual(tauler_amb_duplicats[2][3], "")

    def test_esborra_personatge_mig(self):
        esborra_del_tauler(self.tauler, 'Richard')
        self.assertEqual(self.tauler[1][1], "")
        self.assertNotIn('Richard', [nom for fila in self.tauler for nom in fila])

    def test_esborra_personatge_ultima_posicio(self):
        esborra_del_tauler(self.tauler, 'Maria')
        self.assertEqual(self.tauler[2][3], "")
        self.assertNotIn('Maria', [nom for fila in self.tauler for nom in fila])

    def test_esborra_tots_els_personatges(self):
        for fila in self.tauler:
            for nom in fila:
                esborra_del_tauler(self.tauler, nom)
        self.assertTrue(all(nom == "" for fila in self.tauler for nom in fila))

    def test_esborra_amb_tauler_buit(self):
        tauler_buit = [["" for _ in range(4)] for _ in range(3)]
        esborra_del_tauler(tauler_buit, 'Phillip')
        self.assertEqual(tauler_buit, [["" for _ in range(4)] for _ in range(3)])

class TestJocDelQuiEsQui(unittest.TestCase):
    @patch('builtins.input')
    @patch('C_QuiEsQui.genera_partida')
    @patch('C_QuiEsQui.jugada_usuari')
    @patch('C_QuiEsQui.jugada_oponent')
    def test_joc_del_qui_es_qui(self, mock_jugada_oponent, mock_jugada_usuari, mock_genera_partida, mock_input):
        # Configurem els mocks
        mock_genera_partida.side_effect = [
            ('Usuari1', 'Ordinador1', 'Tauler_Usuari1', 'Tauler_Ordinador1'),
            ('Usuari2', 'Ordinador2', 'Tauler_Usuari2', 'Tauler_Ordinador2')
        ]
        
        # Simulem una partida on l'usuari guanya, després una on l'ordinador guanya, i finalment tornem al menú
        mock_jugada_usuari.side_effect = ['No encerta', 'Ordinador1', 'No encerta']
        mock_jugada_oponent.side_effect = ['No encerta', 'Usuari2']
        mock_input.side_effect = ['j', 'm']

        # Capturem la sortida
        captured_output = StringIO()
        sys.stdout = captured_output

        # Executem la funció
        joc_del_qui_es_qui()

        # Restaurem stdout
        sys.stdout = sys.__stdout__

        # Comprovem les crides i la sortida
        self.assertEqual(mock_genera_partida.call_count, 2)
        self.assertEqual(mock_jugada_usuari.call_count, 3)
        self.assertEqual(mock_jugada_oponent.call_count, 2)
        
        output = captured_output.getvalue()
        self.assertIn("Has guanyat!", output)
        self.assertIn("L'ordinador ha guanyat!", output)
        
        # Verifiquem que s'han fet les crides d'input correctes
        mock_input.assert_any_call("Vols tornar a jugar (j) o tornar al menú (m)? ")

    @patch('builtins.input')
    @patch('C_QuiEsQui.genera_partida')
    @patch('C_QuiEsQui.jugada_usuari')
    @patch('C_QuiEsQui.jugada_oponent')
    def test_joc_del_qui_es_qui_input_invalid(self, mock_jugada_oponent, mock_jugada_usuari, mock_genera_partida, mock_input):
        # Configurem els mocks
        mock_genera_partida.return_value = ('Usuari', 'Ordinador', 'Tauler_Usuari', 'Tauler_Ordinador')
        mock_jugada_usuari.return_value = 'Ordinador'
        mock_input.side_effect = ['x', 'y', 'm']  # Entrades invàlides abans de tornar al menú

        # Capturem la sortida
        captured_output = StringIO()
        sys.stdout = captured_output

        # Executem la funció
        joc_del_qui_es_qui()

        # Restaurem stdout
        sys.stdout = sys.__stdout__

        # Comprovem les crides i la sortida
        self.assertEqual(mock_genera_partida.call_count, 1)
        self.assertEqual(mock_jugada_usuari.call_count, 1)
        self.assertEqual(mock_jugada_oponent.call_count, 0)
        
        output = captured_output.getvalue()
        self.assertIn("Has guanyat!", output)
        
        # Verifiquem que s'han fet les crides d'input correctes i s'han imprès els missatges d'error
        mock_input.assert_any_call("Vols tornar a jugar (j) o tornar al menú (m)? ")
        self.assertIn("Opció no vàlida. Si us plau, escriu 'j' per jugar de nou o 'm' per tornar al menú.", output)
        self.assertEqual(output.count("Opció no vàlida."), 2)

class TestMainRun(unittest.TestCase):
    @patch('builtins.input')
    @patch('C_QuiEsQui.clearScreen')
    @patch('C_QuiEsQui.escriu_nom')
    @patch('C_QuiEsQui.selecciona_oponent')
    @patch('C_QuiEsQui.joc_del_qui_es_qui')
    def test_mainRun(self, mock_joc, mock_oponent, mock_nom, mock_clear, mock_input):
        # Configurar los mocks
        mock_input.side_effect = ['1', '2', '3', '3', '0']
        mock_nom.return_value = 'TestUser'
        mock_oponent.return_value = 'TestOponent'

        # Capturar la salida
        captured_output = StringIO()
        sys.stdout = captured_output

        # Ejecutar la función
        from C_QuiEsQui import mainRun
        mainRun()

        # Restaurar stdout
        sys.stdout = sys.__stdout__

        # Verificar las llamadas a las funciones mockeadas
        self.assertEqual(mock_clear.call_count, 5)
        mock_nom.assert_called_once()
        mock_oponent.assert_called_once()
        self.assertEqual(mock_joc.call_count, 2)  # Ahora esperamos que se llame dos veces

        # Verificar la salida
        output = captured_output.getvalue()
        self.assertIn("Qui és qui?", output)
        self.assertIn("1) Escull el teu nom", output)
        self.assertIn("2) Escull el nom de l'oponent", output)
        self.assertIn("3) Juga", output)
        self.assertIn("0) Sortir", output)
        self.assertNotIn("Error! Has d'escollir el nom i l'oponent abans de jugar.", output)

    @patch('builtins.input')
    @patch('C_QuiEsQui.clearScreen')
    def test_mainRun_error_message(self, mock_clear, mock_input):
        # Configurar los mocks para simular intentar jugar sin nombre o oponente
        mock_input.side_effect = ['3', '0']

        # Capturar la salida
        captured_output = StringIO()
        sys.stdout = captured_output

        # Ejecutar la función
        mainRun()

        # Restaurar stdout
        sys.stdout = sys.__stdout__

        # Verificar la salida
        output = captured_output.getvalue()
        self.assertIn("Error! Has d'escollir el nom i l'oponent abans de jugar.", output)

    @patch('builtins.input')
    @patch('C_QuiEsQui.clearScreen')
    def test_mainRun_invalid_option(self, mock_clear, mock_input):
        # Configurar los mocks para simular una opción inválida
        mock_input.side_effect = ['5', '0']

        # Capturar la salida
        captured_output = StringIO()
        sys.stdout = captured_output

        # Ejecutar la función
        mainRun()

        # Restaurar stdout
        sys.stdout = sys.__stdout__

        # Verificar la salida
        output = captured_output.getvalue()
        self.assertIn("Opció no vàlida.", output)

if __name__ == '__main__':
    unittest.main()


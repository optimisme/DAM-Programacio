#!/usr/bin/env python3

import unittest
from unittest.mock import patch
import io
import sys
from A_ElRellotge import genera_cartes, barreja_cartes, reparteix_cartes, jugada, mostra_estat_joc, mainRun

class TestGeneraCartes(unittest.TestCase):
    def test_genera_cartes(self):
        cartes = genera_cartes()
        self.assertEqual(len(cartes), 48)
        self.assertTrue(all(1 <= carta[0] <= 12 for carta in cartes))
        self.assertTrue(all(pal in ["oros", "copes", "espases", "bastos"] for carta in cartes for pal in carta[1:]))

    def test_genera_cartes_valors_unics(self):
        cartes = genera_cartes()
        valors_unics = set(carta[0] for carta in cartes)
        self.assertEqual(len(valors_unics), 12)

class TestBarrejaCartes(unittest.TestCase):
    def test_barreja_cartes_manté_mida(self):
        cartes = genera_cartes()
        cartes_barrejades = barreja_cartes(cartes)
        self.assertEqual(len(cartes), len(cartes_barrejades))  # Verifiquem que el nombre de cartes no canvia

    def test_barreja_cartes_mesclada(self):
        cartes = genera_cartes()
        cartes_copia = cartes.copy()  # Guardem una còpia per comparar
        cartes_barrejades = barreja_cartes(cartes)
        self.assertNotEqual(cartes_copia, cartes_barrejades)  # Verifiquem que les cartes han canviat d'ordre

    def test_barreja_cartes_conserva_contingut(self):
        cartes = genera_cartes()
        cartes_barrejades = barreja_cartes(cartes)
        self.assertCountEqual(cartes, cartes_barrejades) # Verifiquem que no hi ha duplicats ni cartes perdudes

class TestReparteixCartes(unittest.TestCase):
    def test_reparteix_cartes_numero_correcte_cartes_per_jugador(self):
        cartes = genera_cartes()
        cartes_restants, mans_jugadors = reparteix_cartes(cartes, 4, 12)
        self.assertEqual(len(mans_jugadors), 4)  # Verifiquem que hi ha 4 jugadors
        self.assertTrue(all(len(ma) == 12 for ma in mans_jugadors))  # Verifiquem que cada jugador té 12 cartes

    def test_reparteix_cartes_restants(self):
        cartes = genera_cartes()
        cartes_restants, mans_jugadors = reparteix_cartes(cartes, 4, 12)
        self.assertEqual(len(cartes_restants), 0)  # Verifiquem que no queden cartes restants amb 48 cartes / 4 jugadors

    def test_reparteix_cartes_amb_restants(self):
        cartes = genera_cartes()
        cartes_restants, mans_jugadors = reparteix_cartes(cartes, 3, 12)
        self.assertEqual(len(mans_jugadors), 3)  # Verifiquem que hi ha 3 jugadors
        self.assertTrue(all(len(ma) == 12 for ma in mans_jugadors))  # Verifiquem que cada jugador té 12 cartes
        self.assertEqual(len(cartes_restants), 12)  # Verifiquem que queden 12 cartes restants (48 - 36)

    def test_reparteix_cartes_conserva_totes_les_cartes(self):
        cartes = genera_cartes()
        cartes_restants, mans_jugadors = reparteix_cartes(cartes, 4, 12)
        cartes_repartides = [carta for ma in mans_jugadors for carta in ma]  # Totes les cartes repartides
        self.assertCountEqual(cartes, cartes_repartides + cartes_restants)  # Verifiquem que no hi ha cartes perdudes ni duplicades

class TestJugada(unittest.TestCase):
    def test_jugada_sense_agafar_cartes(self):
        cartes_jugador = [[1, "oros"], [2, "copes"], [3, "espases"]]
        cartes_taula = []
        comptador = 0  # El comptador serà 1 en aquesta tirada
        cartes_restants_jugador, cartes_taula_actualitzades, ha_agafat_cartes = jugada(comptador, 0, cartes_jugador, cartes_taula)

        self.assertEqual(len(cartes_restants_jugador), 3, f"Esperat 2 cartes restants, però s'han trobat {len(cartes_restants_jugador)}")
        self.assertEqual(len(cartes_taula_actualitzades), 0, f"Esperat 1 carta a la taula, però s'han trobat {len(cartes_taula_actualitzades)}")
        self.assertTrue(ha_agafat_cartes, f"El jugador no hauria d'haver agafat les cartes, però s'indica que sí")

    def test_jugada_numero_a_dir_correcte(self):
        cartes_jugador = [[7, "oros"], [8, "copes"], [9, "espases"]]
        cartes_taula = []
        comptador = 6  # El comptador serà 7 en aquesta tirada
        cartes_restants_jugador, cartes_taula_actualitzades, ha_agafat_cartes = jugada(comptador, 0, cartes_jugador, cartes_taula)

        # Com que el jugador ha de recollir la seva carta, ha de tenir 3 cartes (les 2 restants + la que ha jugat)
        self.assertEqual(len(cartes_restants_jugador), 3)  # El jugador hauria de tenir 3 cartes després de la jugada
        self.assertEqual(cartes_taula_actualitzades, [])  # La taula hauria d'estar buida
        self.assertTrue(ha_agafat_cartes)  # El jugador hauria d'haver agafat les cartes

class TestMostraEstatJoc(unittest.TestCase):
    @patch('sys.stdout', new_callable=io.StringIO)  # Captura la sortida a stdout
    def test_mostra_estat_joc(self, mock_stdout):
        mans_jugadors = [
            [[1, "oros"], [2, "oros"], [3, "oros"]],  # Jugador 0 amb 3 cartes
            [[1, "copes"]],  # Jugador 1 amb 1 carta
            [[1, "bastos"], [2, "bastos"]],  # Jugador 2 amb 2 cartes
            [[1, "espases"], [2, "espases"], [3, "espases"], [4, "espases"]]  # Jugador 3 amb 4 cartes
        ]

        mostra_estat_joc(mans_jugadors)  # Crida a la funció
        
        # Captura la sortida generada per la funció
        expected_output = "Jugador 0: 3 cartes, Jugador 1: 1 carta, Jugador 2: 2 cartes, Jugador 3: 4 cartes\n"
        self.assertEqual(mock_stdout.getvalue(), expected_output)

    @patch('sys.stdout', new_callable=io.StringIO)  # Captura la sortida a stdout
    def test_mostra_estat_joc_varis_jugadors(self, mock_stdout):
        mans_jugadors = [
            [[1, "oros"], [2, "oros"], [3, "oros"]],  # Jugador 0 amb 3 cartes
            [[1, "copes"]],  # Jugador 1 amb 1 carta
            [[1, "bastos"], [2, "bastos"]],  # Jugador 2 amb 2 cartes
            [[1, "espases"], [2, "espases"], [3, "espases"], [4, "espases"]]  # Jugador 3 amb 4 cartes
        ]

        mostra_estat_joc(mans_jugadors)
        
        expected_output = "Jugador 0: 3 cartes, Jugador 1: 1 carta, Jugador 2: 2 cartes, Jugador 3: 4 cartes\n"
        self.assertEqual(mock_stdout.getvalue(), expected_output)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_mostra_estat_joc_tots_jugadors_sense_cartes(self, mock_stdout):
        mans_jugadors = [[], [], [], []]  # Tots els jugadors sense cartes

        mostra_estat_joc(mans_jugadors)

        expected_output = "Jugador 0: 0 cartes, Jugador 1: 0 cartes, Jugador 2: 0 cartes, Jugador 3: 0 cartes\n"
        self.assertEqual(mock_stdout.getvalue(), expected_output)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_mostra_estat_joc_un_jugador(self, mock_stdout):
        mans_jugadors = [[[1, "oros"], [2, "oros"]]]  # Només un jugador amb 2 cartes

        mostra_estat_joc(mans_jugadors)

        expected_output = "Jugador 0: 2 cartes\n"
        self.assertEqual(mock_stdout.getvalue(), expected_output)

class TestMainRun(unittest.TestCase):

    @patch('sys.stdout', new_callable=io.StringIO)  # Captura la sortida a stdout
    @patch('A_ElRellotge.reparteix_cartes')  # Simulem el repartiment de cartes
    @patch('A_ElRellotge.genera_cartes')  # Simulem la generació de cartes
    def test_main_run_guanyador(self, mock_genera_cartes, mock_reparteix_cartes, mock_stdout):
        # Simulació de la generació de cartes
        mock_genera_cartes.return_value = [[i, 'oros'] for i in range(1, 13)] * 4

        # Simulació de repartiment de cartes (4 jugadors, 12 cartes cadascun)
        mock_reparteix_cartes.return_value = ([], [
            [[1, 'oros']],  # Jugador 0 amb 1 carta
            [[2, 'oros']],  # Jugador 1 amb 1 carta
            [[3, 'oros']],  # Jugador 2 amb 1 carta
            [[4, 'oros']]   # Jugador 3 amb 1 carta
        ])

        # Crida a la funció principal del joc
        mainRun()

        # Verificació de la sortida esperada
        output = mock_stdout.getvalue()

        # Verifiquem que hi ha un guanyador
        self.assertIn("El jugador", output)

        # Comprovem que s'imprimeixen les tirades seguides
        self.assertIn("Tirades seguides:", output)

        # Comprovem que es mostra l'estat del joc
        self.assertIn("Jugador 0:", output)
        self.assertIn("Jugador 1:", output)
        self.assertIn("Jugador 2:", output)
        self.assertIn("Jugador 3:", output)

if __name__ == '__main__':
    unittest.main()
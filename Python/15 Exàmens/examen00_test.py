#!/usr/bin/env python3

import unittest
from unittest.mock import patch
import random
import string
import os
from examen00 import generaDNI, generaId, generaUsuari, afegirUsuari, afegirUsuaris, buscaUsuari, mostraUsuari, llistaUsuaris, modificaUsuari, esborraUsuari, buscaAcces, ordenaUsuaris, mainRun

# Aquesta funció neteja la pantalla, no la modifiquis
def clearScreen():
    if os.name == 'nt':     # Si estàs a Windows
        os.system('cls')
    else:                   # Si estàs a Linux o macOS
        os.system('clear')

clearScreen()

class TestGeneraDNI(unittest.TestCase):

    @patch('random.choices')
    def test_generaDNI_valida(self, mock_choices):
        # Simula que la funció random.choices sempre retorna "12345678" com a número de 8 dígits
        mock_choices.return_value = ['1', '2', '3', '4', '5', '6', '7', '8']
        
        # Expected letter for "12345678" % 23 = 14, corresponding to "Z" in the sequence
        expected_dni = "12345678Z"
        
        # Crida la funció generaDNI i comprova que el resultat és correcte
        resultat = generaDNI()
        self.assertEqual(resultat, expected_dni)

    @patch('random.choices')
    def test_generaDNI_valida_2(self, mock_choices):
        # Simula que la funció random.choices sempre retorna "87654321" com a número de 8 dígits
        mock_choices.return_value = ['8', '7', '6', '5', '4', '3', '2', '1']
        
        # Expected letter for "87654321" % 23 = 3, corresponding to "X" in the sequence
        expected_dni = "87654321X"
        
        # Crida la funció generaDNI i comprova que el resultat és correcte
        resultat = generaDNI()
        self.assertEqual(resultat, expected_dni)

    @patch('random.choices')
    def test_generaDNI_incorrecte(self, mock_choices):
        # Simula que la funció random.choices sempre retorna "87654321" com a número de 8 dígits
        mock_choices.return_value = ['8', '7', '6', '5', '4', '3', '2', '1']
        
        # Intentem validar amb una lletra incorrecta
        incorrect_dni = "87654321A"
        resultat = generaDNI()
        
        # Només passa el test si result_correcte és explícitament True o False
        if resultat is None:
            self.fail("El test no ha retornat un valor explícitament True o False")
        else:
            self.assertTrue(resultat != incorrect_dni)

class TestGeneraId(unittest.TestCase):

    @patch('random.randint')
    @patch('random.choice')
    def test_generaId_valida(self, mock_choice, mock_randint):
        # Simula que random.randint i random.choice retornen valors específics
        mock_randint.side_effect = [4, 2, 7]  # Els números generats seran 4, 2 i 7
        mock_choice.side_effect = ['A', 'B']  # Les lletres seran A i B
        
        expected_id = "4A27B"
        
        # Crida la funció generaId i comprova que el resultat és correcte
        resultat = generaId()
        self.assertEqual(resultat, expected_id)

    @patch('random.randint')
    @patch('random.choice')
    def test_generaId_valida_2(self, mock_choice, mock_randint):
        # Simula una altra seqüència de valors aleatoris
        mock_randint.side_effect = [9, 8, 1]  # Els números generats seran 9, 8 i 1
        mock_choice.side_effect = ['C', 'D']  # Les lletres seran C i D
        
        expected_id = "9C81D"
        
        # Crida la funció generaId i comprova que el resultat és correcte
        resultat = generaId()
        self.assertEqual(resultat, expected_id)            

    @patch('random.randint')
    @patch('random.choice')
    def test_generaId_incorrecte(self, mock_choice, mock_randint):
        # Simula la mateixa seqüència de valors, però comprovem un valor incorrecte
        mock_randint.side_effect = [4, 2, 7]  # Els números generats seran 4, 2 i 7
        mock_choice.side_effect = ['A', 'B']  # Les lletres seran A i B
        
        incorrect_id = "4A27C"  # Això és incorrecte, ja que la lletra final ha de ser B
        
        # Crida la funció generaId i comprova que el resultat NO és incorrecte
        resultat = generaId()
        if resultat is None:
            self.fail("generaId resultat None")
        else:
            self.assertNotEqual(resultat, incorrect_id)

class TestGeneraUsuari(unittest.TestCase):

    @patch('random.randint')
    @patch('random.choice')
    @patch('random.sample')
    @patch('examen00.generaDNI')
    @patch('examen00.generaId')
    def test_generaUsuari(self, mock_generaId, mock_generaDNI, mock_sample, mock_choice, mock_randint):
        # Simula que generaId i generaDNI retornen valors predefinits
        mock_generaId.return_value = "4A27B"
        mock_generaDNI.return_value = "12345678Z"
        
        # Simula que random.randint retorna 45 (edat)
        mock_randint.side_effect = [45, 2]  # 45 per a l'edat, 2 per al nombre d'accessos
        
        # Simula que random.choice retorna 'Joan' com a nom
        mock_choice.return_value = 'Joan'
        
        # Simula que random.sample retorna ['mati', 'tarda'] per als torns d'accés
        mock_sample.return_value = ['mati', 'tarda']
        
        # Resultat esperat
        expected_usuari = {
            'id': '4A27B',
            'nom': 'Joan',
            'edat': 45,
            'dni': '12345678Z',
            'acces': ['mati', 'tarda']
        }

        # Crida la funció generaUsuari i comprova que el resultat és correcte
        resultat = generaUsuari()
        self.assertEqual(resultat, expected_usuari)

    @patch('random.randint')
    @patch('random.choice')
    @patch('random.sample')
    @patch('examen00.generaDNI')
    @patch('examen00.generaId')
    def test_generaUsuari_amb_dades_diferents(self, mock_generaId, mock_generaDNI, mock_sample, mock_choice, mock_randint):
        # Simula altres valors per als mètodes
        mock_generaId.return_value = "9C81D"
        mock_generaDNI.return_value = "87654321W"
        
        mock_randint.side_effect = [30, 1]  # 30 per a l'edat, 1 per al nombre d'accessos
        
        mock_choice.return_value = 'Anna'
        
        mock_sample.return_value = ['nit']
        
        # Resultat esperat
        expected_usuari = {
            'id': '9C81D',
            'nom': 'Anna',
            'edat': 30,
            'dni': '87654321W',
            'acces': ['nit']
        }

        # Crida la funció generaUsuari i comprova que el resultat és correcte
        resultat = generaUsuari()
        self.assertEqual(resultat, expected_usuari)

class TestAfegirUsuari(unittest.TestCase):

    @patch('examen00.usuaris', new=[])
    def test_afegirUsuari(self):
        # Usuari a afegir
        usuari = {
            'id': '4A27B',
            'nom': 'Joan',
            'edat': 45,
            'dni': '12345678Z',
            'acces': ['mati', 'tarda']
        }

        # Afegeix l'usuari a la llista global
        afegirUsuari(usuari)

        # Obtenim la llista usuaris des del mòdul amb la decoració @patch
        from examen00 import usuaris

        # Comprova que l'usuari ha estat afegit correctament
        self.assertIn(usuari, usuaris)

    @patch('examen00.usuaris', new=[])
    def test_afegirDiversosUsuaris(self):
        # Definim dos usuaris diferents
        usuari1 = {
            'id': '4A27B',
            'nom': 'Joan',
            'edat': 45,
            'dni': '12345678Z',
            'acces': ['mati', 'tarda']
        }

        usuari2 = {
            'id': '9C81D',
            'nom': 'Anna',
            'edat': 30,
            'dni': '87654321W',
            'acces': ['nit']
        }

        # Afegeix els dos usuaris
        afegirUsuari(usuari1)
        afegirUsuari(usuari2)

        # Obtenim la llista usuaris des del mòdul amb la decoració @patch
        from examen00 import usuaris

        # Comprova que els usuaris han estat afegits correctament
        self.assertIn(usuari1, usuaris)
        self.assertIn(usuari2, usuaris)
        self.assertEqual(len(usuaris), 2)

class TestAfegirUsuaris(unittest.TestCase):

    @patch('examen00.generaUsuari')
    @patch('examen00.usuaris', new=[])
    def test_afegirUsuaris(self, mock_generaUsuari):
        # Simula que generaUsuari retorna usuaris predefinits
        mock_generaUsuari.side_effect = [
            {'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']},
            {'id': '9C81D', 'nom': 'Anna', 'edat': 30, 'dni': '87654321W', 'acces': ['nit']}
        ]

        # Afegeix 2 usuaris
        afegirUsuaris(2)

        # Obtenim la llista usuaris des del mòdul amb la decoració @patch
        from examen00 import usuaris

        # Comprova que els dos usuaris han estat afegits correctament
        self.assertEqual(len(usuaris), 2)
        self.assertIn({'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']}, usuaris)
        self.assertIn({'id': '9C81D', 'nom': 'Anna', 'edat': 30, 'dni': '87654321W', 'acces': ['nit']}, usuaris)

class TestBuscaUsuari(unittest.TestCase):

    @patch('examen00.usuaris', new=[
        {'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']},
        {'id': '9C81D', 'nom': 'Anna', 'edat': 30, 'dni': '87654321W', 'acces': ['nit']}
    ])
    def test_buscaUsuari_trobat(self):
        # Cerca un usuari existent per id
        index = buscaUsuari('4A27B')
        
        # Comprova que l'índex retornat sigui correcte
        self.assertEqual(index, 0)

    @patch('examen00.usuaris', new=[
        {'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']},
        {'id': '9C81D', 'nom': 'Anna', 'edat': 30, 'dni': '87654321W', 'acces': ['nit']}
    ])
    @patch('builtins.print')  # Tapar la funció print
    def test_buscaUsuari_noTrobat(self, mock_print):
        # Cerca un usuari que no existeix
        index = buscaUsuari('XYZ123')
        
        # Comprova que l'índex retornat sigui -1
        self.assertEqual(index, -1)

        # Comprova que print ha estat cridat una vegada
        mock_print.assert_called_once_with("(buscaUsuari) No s'ha trobat l'usuari amb id 'XYZ123'")

class TestMostraUsuari(unittest.TestCase):

    @patch('builtins.print')
    @patch('examen00.buscaUsuari')
    @patch('examen00.usuaris', new=[
        {'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']},
        {'id': '9C81D', 'nom': 'Anna', 'edat': 30, 'dni': '87654321W', 'acces': ['nit']}
    ])
    def test_mostraUsuari_trobat(self, mock_buscaUsuari, mock_print):
        # Simulem que l'usuari és trobat a l'índex 0
        mock_buscaUsuari.return_value = 0

        # Crida la funció mostraUsuari
        mostraUsuari('4A27B')

        # Comprova que es fa un print amb les dades correctes de l'usuari trobat
        mock_print.assert_called_once_with("(mostraUsuari) L'usuari amb id '4A27B' és {'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']}")

    @patch('builtins.print')
    @patch('examen00.buscaUsuari')
    def test_mostraUsuari_noTrobat(self, mock_buscaUsuari, mock_print):
        # Simulem que l'usuari no és trobat, retornant -1
        mock_buscaUsuari.return_value = -1

        # Crida la funció mostraUsuari amb un id que no existeix
        mostraUsuari('XYZ123')

        # Comprova que es fa un print amb el missatge correcte quan l'usuari no es troba
        mock_print.assert_called_once_with("No s'ha trobat l'usuari amb id 'XYZ123'")

class TestLlistaUsuaris(unittest.TestCase):

    @patch('builtins.print')
    @patch('examen00.usuaris', new=[
        {'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']},
        {'id': '9C81D', 'nom': 'Anna', 'edat': 30, 'dni': '87654321W', 'acces': ['nit']}
    ])
    def test_llistaUsuaris(self, mock_print):
        # Crida la funció llistaUsuaris
        llistaUsuaris()

        # Comprova que la funció print ha estat cridada dues vegades, una per cada usuari
        mock_print.assert_any_call({'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']})
        mock_print.assert_any_call({'id': '9C81D', 'nom': 'Anna', 'edat': 30, 'dni': '87654321W', 'acces': ['nit']})
        self.assertEqual(mock_print.call_count, 2)

class TestModificaUsuari(unittest.TestCase):

    @patch('builtins.print')
    @patch('examen00.buscaUsuari')
    @patch('examen00.usuaris', new=[
        {'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']},
        {'id': '9C81D', 'nom': 'Anna', 'edat': 30, 'dni': '87654321W', 'acces': ['nit']}
    ])
    def test_modificaUsuari_campModificat(self, mock_buscaUsuari, mock_print):
        # Simula que l'usuari amb id '4A27B' es troba a l'índex 0
        mock_buscaUsuari.return_value = 0

        # Crida la funció per modificar el camp 'edat'
        modificaUsuari('4A27B', 'edat', 50)

        # Obtenim la llista usuaris des del mòdul amb la decoració @patch
        from examen00 import usuaris

        # Comprova que el camp 'edat' ha estat modificat correctament
        self.assertEqual(usuaris[0]['edat'], 50)

        # Comprova que el print ha estat cridat amb el missatge correcte
        mock_print.assert_called_once_with("(modificaUsuari) S'ha modificat l'usuari '4A27B', s'ha canviat el camp 'edat': '45' > '50'")

    @patch('builtins.print')
    @patch('examen00.buscaUsuari')
    def test_modificaUsuari_noTrobat(self, mock_buscaUsuari, mock_print):
        # Simula que l'usuari no es troba
        mock_buscaUsuari.return_value = -1

        # Crida la funció per modificar un usuari inexistent
        modificaUsuari('XYZ123', 'edat', 30)

        # Comprova que el print ha estat cridat amb el missatge d'error
        mock_print.assert_called_once_with("(modificaUsuari) Error, l'usuari 'XYZ123' no existeix")

class TestEsborraUsuari(unittest.TestCase):

    @patch('builtins.print')
    @patch('examen00.buscaUsuari')
    @patch('examen00.usuaris', new=[
        {'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']},
        {'id': '9C81D', 'nom': 'Anna', 'edat': 30, 'dni': '87654321W', 'acces': ['nit']}
    ])
    def test_esborraUsuari_exist(self, mock_buscaUsuari, mock_print):
        # Simula que l'usuari amb id '4A27B' es troba a l'índex 0
        mock_buscaUsuari.return_value = 0

        # Crida la funció per esborrar l'usuari
        esborraUsuari('4A27B')

        # Obtenim la llista usuaris des del mòdul amb la decoració @patch
        from examen00 import usuaris

        # Comprova que l'usuari ha estat esborrat correctament
        self.assertEqual(len(usuaris), 1)
        self.assertNotIn({'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']}, usuaris)

        # Comprova que el print ha estat cridat amb el missatge correcte
        mock_print.assert_called_once_with("(esborraUsuari) S'ha esborrat l'usuari '4A27B'")

    @patch('builtins.print')
    @patch('examen00.buscaUsuari')
    def test_esborraUsuari_noExist(self, mock_buscaUsuari, mock_print):
        # Simula que l'usuari no es troba, retornant -1
        mock_buscaUsuari.return_value = -1

        # Crida la funció per esborrar un usuari inexistent
        esborraUsuari('XYZ123')

        # Comprova que el print ha estat cridat amb el missatge d'error
        mock_print.assert_called_once_with("(esborraUsuari) Error, l'usuari 'XYZ123' no existeix")

class TestBuscaAcces(unittest.TestCase):

    @patch('builtins.print')
    @patch('examen00.usuaris', new=[
        {'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati', 'tarda']},
        {'id': '9C81D', 'nom': 'Anna', 'edat': 30, 'dni': '87654321W', 'acces': ['nit']},
        {'id': '7E54K', 'nom': 'Marta', 'edat': 28, 'dni': '11223344X', 'acces': ['mati']}
    ])
    def test_buscaAcces_trobats(self, mock_print):
        # Crida la funció buscaAcces per trobar usuaris amb accés 'mati'
        result = buscaAcces('mati')

        # Comprova que els ids dels usuaris amb accés 'mati' han estat retornats correctament
        self.assertEqual(result, ['4A27B', '7E54K'])

        # Comprova que el missatge imprès és correcte
        mock_print.assert_called_once_with("(buscaAcces) Els usuaris amb accés 'mati' són: ['4A27B', '7E54K']")

    @patch('builtins.print')
    @patch('examen00.usuaris', new=[
        {'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati', 'tarda']},
        {'id': '9C81D', 'nom': 'Anna', 'edat': 30, 'dni': '87654321W', 'acces': ['nit']},
        {'id': '7E54K', 'nom': 'Marta', 'edat': 28, 'dni': '11223344X', 'acces': ['mati']}
    ])
    def test_buscaAcces_noTrobats(self, mock_print):
        # Crida la funció buscaAcces per trobar usuaris amb accés 'tarda'
        result = buscaAcces('vespre')

        # Comprova que la llista retornada està buida
        self.assertEqual(result, [])

        # Comprova que el missatge imprès és correcte
        mock_print.assert_called_once_with("(buscaAcces) Els usuaris amb accés 'vespre' són: []")

class TestOrdenaUsuaris(unittest.TestCase):

    @patch('builtins.print')
    @patch('examen00.usuaris', new=[
        {'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']},
        {'id': '9C81D', 'nom': 'Anna', 'edat': 30, 'dni': '87654321W', 'acces': ['nit']},
        {'id': '7E54K', 'nom': 'Marta', 'edat': 28, 'dni': '11223344X', 'acces': ['mati']}
    ])
    def test_ordenaUsuaris_perNom(self, mock_print):
        # Crida la funció per ordenar els usuaris per nom
        ordenaUsuaris('nom')

        # Comprova que la funció print ha estat cridada en l'ordre correcte
        expected_order = [
            {'id': '9C81D', 'nom': 'Anna', 'edat': 30, 'dni': '87654321W', 'acces': ['nit']},
            {'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']},
            {'id': '7E54K', 'nom': 'Marta', 'edat': 28, 'dni': '11223344X', 'acces': ['mati']}
        ]
        for i, usuari in enumerate(expected_order):
            mock_print.assert_any_call(usuari)

        # Comprova que el nombre total de crides a print és correcte (3)
        self.assertEqual(mock_print.call_count, 3)

    @patch('builtins.print')
    @patch('examen00.usuaris', new=[
        {'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']},
        {'id': '9C81D', 'nom': 'Anna', 'edat': 30, 'dni': '87654321W', 'acces': ['nit']},
        {'id': '7E54K', 'nom': 'Marta', 'edat': 28, 'dni': '11223344X', 'acces': ['mati']}
    ])
    def test_ordenaUsuaris_perEdat(self, mock_print):
        # Crida la funció per ordenar els usuaris per edat
        ordenaUsuaris('edat')

        # Comprova que la funció print ha estat cridada en l'ordre correcte
        expected_order = [
            {'id': '7E54K', 'nom': 'Marta', 'edat': 28, 'dni': '11223344X', 'acces': ['mati']},
            {'id': '9C81D', 'nom': 'Anna', 'edat': 30, 'dni': '87654321W', 'acces': ['nit']},
            {'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']}
        ]
        for i, usuari in enumerate(expected_order):
            mock_print.assert_any_call(usuari)

        # Comprova que el nombre total de crides a print és correcte (3)
        self.assertEqual(mock_print.call_count, 3)

class TestMainRun(unittest.TestCase):

    @patch('builtins.print')  # Tapar la funció print
    @patch('builtins.input', side_effect=['0'])
    def test_mainRun_sortir(self, mock_input, mock_print):
        # Simula la sortida immediata del menú
        mainRun()

        # Comprova que s'ha mostrat el menú almenys una vegada
        mock_print.assert_any_call("""
        SuperGym
        1 - Afegir usuari aleatori
        2 - Buscar usuari
        3 - Mostrar usuari
        4 - Llistar usuaris
        5 - Modificar usuari
        6 - Esborrar usuari
        7 - Buscar accés
        8 - Ordenar
        0 - Sortir
        """)

    @patch('builtins.print')  # Tapar la funció print
    @patch('builtins.input', side_effect=['1', '0'])
    @patch('examen00.afegirUsuari')
    @patch('examen00.generaUsuari', return_value={'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']})
    def test_mainRun_afegirUsuari(self, mock_generaUsuari, mock_afegirUsuari, mock_input, mock_print):
        # Simula l'opció 1 d'afegir un usuari i després sortir
        mainRun()

        # Comprova que s'ha cridat la funció generaUsuari i afegirUsuari
        mock_generaUsuari.assert_called_once()
        mock_afegirUsuari.assert_called_once_with({'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati']})

    @patch('builtins.print')  # Tapar la funció print
    @patch('builtins.input', side_effect=['2', '4A27B', '0'])
    @patch('examen00.buscaUsuari')
    def test_mainRun_buscaUsuari(self, mock_buscaUsuari, mock_input, mock_print):
        # Simula l'opció 2 de buscar un usuari amb id '4A27B' i després sortir
        mainRun()

        # Comprova que s'ha cridat la funció buscaUsuari amb l'id correcte
        mock_buscaUsuari.assert_called_once_with('4A27B')

    @patch('builtins.print')  # Tapar la funció print
    @patch('builtins.input', side_effect=['3', '4A27B', '0'])
    @patch('examen00.mostraUsuari')
    def test_mainRun_mostraUsuari(self, mock_mostraUsuari, mock_input, mock_print):
        # Simula l'opció 3 de mostrar un usuari amb id '4A27B' i després sortir
        mainRun()

        # Comprova que s'ha cridat la funció mostraUsuari amb l'id correcte
        mock_mostraUsuari.assert_called_once_with('4A27B')

    @patch('builtins.print')  # Tapar la funció print
    @patch('builtins.input', side_effect=['4', '0'])
    @patch('examen00.llistaUsuaris')
    def test_mainRun_llistaUsuaris(self, mock_llistaUsuaris, mock_input, mock_print):
        # Simula l'opció 4 de llistar els usuaris i després sortir
        mainRun()

        # Comprova que s'ha cridat la funció llistaUsuaris
        mock_llistaUsuaris.assert_called_once()

    @patch('builtins.print')  # Tapar la funció print
    @patch('builtins.input', side_effect=['5', '4A27B', 'edat', '50', '0'])
    @patch('examen00.modificaUsuari')
    def test_mainRun_modificaUsuari(self, mock_modificaUsuari, mock_input, mock_print):
        # Simula l'opció 5 de modificar un usuari i després sortir
        mainRun()

        # Comprova que s'ha cridat la funció modificaUsuari amb els paràmetres correctes
        mock_modificaUsuari.assert_called_once_with('4A27B', 'edat', '50')

    @patch('builtins.print')  # Tapar la funció print
    @patch('builtins.input', side_effect=['6', '4A27B', '0'])
    @patch('examen00.esborraUsuari')
    def test_mainRun_esborraUsuari(self, mock_esborraUsuari, mock_input, mock_print):
        # Simula l'opció 6 d'esborrar un usuari i després sortir
        mainRun()

        # Comprova que s'ha cridat la funció esborraUsuari amb l'id correcte
        mock_esborraUsuari.assert_called_once_with('4A27B')

if __name__ == '__main__':
    unittest.main()

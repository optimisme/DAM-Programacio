#!/usr/bin/env python3

from io import StringIO
import unittest
from unittest.mock import patch
from Exercicis import llistaJocs, diccionariFuncions, llistaAjuda, infoJoc, comptarPerClau, llistarPerClau, llistarPerInterval, modificarJoc, ajudaAmpliada, cridaFuncio, limitaFrases, mostraFrases, mainRun

class TestInfoJoc(unittest.TestCase):
    def test_joc_existent(self):
        resultat = infoJoc("Super Mario Bros")
        esperat = ["  Super Mario Bros: 1985, Plataformes (5000 pessetes)"]
        self.assertEqual(resultat, esperat)

    def test_joc_inexistent(self):
        resultat = infoJoc("Joc Inexistent")
        esperat = ['  Error infoJoc: "Joc Inexistent" desconegut.']
        self.assertEqual(resultat, esperat)

    def test_tots_els_jocs(self):
        for joc in llistaJocs:
            resultat = infoJoc(joc["nom"])
            esperat = [f"  {joc['nom']}: {joc['any']}, {joc['tipus']} ({joc['preu']} pessetes)"]
            self.assertEqual(resultat, esperat)

class TestComptarPerClau(unittest.TestCase):
    def test_comptar_per_tipus(self):
        resultat = comptarPerClau("tipus")
        esperat = {
            "Plataformes": 2,
            "Acció-Aventura": 2,
            "RPG (Role-Playing Game)": 1,
            "Carreres": 1,
            "Estratègia": 1
        }
        self.assertEqual(resultat, esperat)

    def test_comptar_per_any(self):
        resultat = comptarPerClau("any")
        esperat = {
            1985: 1,
            1986: 2,
            1996: 2,
            2001: 1,
            1981: 1
        }
        self.assertEqual(resultat, esperat)

    def test_comptar_per_preu(self):
        resultat = comptarPerClau("preu")
        esperat = {5000: 2, 8000: 2, 10000: 1, 6000: 1, 1000: 1}
        self.assertEqual(resultat, esperat)

    def test_clau_inexistent(self):
        with self.assertRaises(KeyError):
            comptarPerClau("clau_inexistent")

    def test_llista_buida(self):
        llistaJocsOriginal = llistaJocs.copy()
        llistaJocs.clear()
        
        try:
            resultat = comptarPerClau("tipus")
            self.assertEqual(resultat, {})
        finally:
            # Restaurar la llista original
            llistaJocs.extend(llistaJocsOriginal)

class TestLlistarPerClau(unittest.TestCase):
    def test_llistar_per_tipus(self):
        resultat = llistarPerClau("tipus", "Plataformes")
        esperat = [
            "  Super Mario Bros: 1985, Plataformes (5000 pessetes)",
            "  Donkey Kong: 1981, Plataformes (1000 pessetes)"
        ]
        self.assertEqual(resultat, esperat)

    def test_llistar_per_any(self):
        resultat = llistarPerClau("any", 1986)
        esperat = [
            "  The Legend of Zelda: 1986, Acció-Aventura (5000 pessetes)",
            "  Metroid: 1986, Acció-Aventura (6000 pessetes)"
        ]
        self.assertEqual(resultat, esperat)

    def test_llistar_per_preu(self):
        resultat = llistarPerClau("preu", 5000)
        esperat = [
            "  Super Mario Bros: 1985, Plataformes (5000 pessetes)",
            "  The Legend of Zelda: 1986, Acció-Aventura (5000 pessetes)"
        ]
        self.assertEqual(resultat, esperat)

    def test_condicio_inexistent(self):
        resultat = llistarPerClau("tipus", "Simulació")
        self.assertEqual(resultat, [])

    def test_clau_inexistent(self):
        with self.assertRaises(KeyError):
            llistarPerClau("clau_inexistent", "valor")

    def test_tipus_dades_diferents(self):
        # Comprovem que la funció no fa conversió de tipus automàticament
        resultat = llistarPerClau("any", "1996")
        self.assertEqual(resultat, [])

    def test_tipus_dades_correctes(self):
        resultat = llistarPerClau("any", 1996)
        esperat = [
            "  Pokémon Red i Blue: 1996, RPG (Role-Playing Game) (8000 pessetes)",
            "  Mario Kart 64: 1996, Carreres (10000 pessetes)"
        ]
        self.assertEqual(resultat, esperat)

class TestLlistarPerInterval(unittest.TestCase):
    def test_llistar_per_any(self):
        resultat = llistarPerInterval("any", 1980, 1990)
        esperat = [
            "  Super Mario Bros: 1985, Plataformes (5000 pessetes)",
            "  The Legend of Zelda: 1986, Acció-Aventura (5000 pessetes)",
            "  Metroid: 1986, Acció-Aventura (6000 pessetes)",
            "  Donkey Kong: 1981, Plataformes (1000 pessetes)"
        ]
        self.assertEqual(resultat, esperat)

    def test_llistar_per_preu(self):
        resultat = llistarPerInterval("preu", 5000, 8000)
        esperat = [
            "  Super Mario Bros: 1985, Plataformes (5000 pessetes)",
            "  The Legend of Zelda: 1986, Acció-Aventura (5000 pessetes)",
            "  Pokémon Red i Blue: 1996, RPG (Role-Playing Game) (8000 pessetes)",
            "  Metroid: 1986, Acció-Aventura (6000 pessetes)",
            "  Pikmin: 2001, Estratègia (8000 pessetes)"
        ]
        self.assertEqual(resultat, esperat)

    def test_interval_sense_jocs(self):
        resultat = llistarPerInterval("any", 2010, 2020)
        self.assertEqual(resultat, [])

    def test_interval_amb_un_joc(self):
        resultat = llistarPerInterval("any", 2000, 2002)
        esperat = ["  Pikmin: 2001, Estratègia (8000 pessetes)"]
        self.assertEqual(resultat, esperat)

    def test_clau_inexistent(self):
        with self.assertRaises(KeyError):
            llistarPerInterval("clau_inexistent", 1980, 1990)

    def test_interval_invertit(self):
        resultat = llistarPerInterval("any", 1990, 1980)
        self.assertEqual(resultat, [])

    def test_limits_inclusius(self):
        resultat = llistarPerInterval("any", 1981, 1985)
        esperat = [
            "  Super Mario Bros: 1985, Plataformes (5000 pessetes)",
            "  Donkey Kong: 1981, Plataformes (1000 pessetes)"
        ]
        self.assertEqual(resultat, esperat)

    def test_tipus_dades_incorrectes(self):
        with self.assertRaises(TypeError):
            llistarPerInterval("any", "1980", "1990")

class TestModificarJoc(unittest.TestCase):
    def setUp(self):
        # Guardem una còpia de la llista original per restaurar-la després de cada test
        self.llistaJocsOriginal = llistaJocs.copy()

    def tearDown(self):
        # Restaurem la llista original després de cada test
        global llistaJocs
        llistaJocs = self.llistaJocsOriginal.copy()

    def test_modificar_preu(self):
        resultat = modificarJoc("Super Mario Bros", "preu", 2)
        esperat = ["  Super Mario Bros: 1985, Plataformes (2 pessetes)"]
        self.assertEqual(resultat, esperat)
        
        # Verifiquem amb infoJoc
        info_resultat = infoJoc("Super Mario Bros")
        self.assertEqual(info_resultat, esperat)

    def test_modificar_any(self):
        resultat = modificarJoc("The Legend of Zelda", "any", 1987)
        esperat = ["  The Legend of Zelda: 1987, Acció-Aventura (5000 pessetes)"]
        self.assertEqual(resultat, esperat)

        # Verifiquem amb infoJoc
        info_resultat = infoJoc("The Legend of Zelda")
        self.assertEqual(info_resultat, esperat)

    def test_modificar_tipus(self):
        resultat = modificarJoc("Pokémon Red i Blue", "tipus", "RPG")
        esperat = ["  Pokémon Red i Blue: 1996, RPG (8000 pessetes)"]
        self.assertEqual(resultat, esperat)

        # Verifiquem amb infoJoc
        info_resultat = infoJoc("Pokémon Red i Blue")
        self.assertEqual(info_resultat, esperat)

    def test_joc_inexistent(self):
        resultat = modificarJoc("Joc Inexistent", "preu", 1000)
        esperat = ['  Error modificarJoc: "Joc Inexistent" desconegut.']
        self.assertEqual(resultat, esperat)

        # Verifiquem que infoJoc també retorna un error
        info_resultat = infoJoc("Joc Inexistent")
        self.assertEqual(info_resultat, ['  Error infoJoc: "Joc Inexistent" desconegut.'])

    def test_modificar_nom(self):
        resultat = modificarJoc("Metroid", "nom", "Metroid Prime")
        esperat = ["  Metroid Prime: 1986, Acció-Aventura (6000 pessetes)"]
        self.assertEqual(resultat, esperat)
        
        # Verifiquem amb infoJoc pel nou nom
        info_resultat_nou = infoJoc("Metroid Prime")
        self.assertEqual(info_resultat_nou, esperat)

        # Verifiquem que el nom antic ja no existeix
        info_resultat_antic = infoJoc("Metroid")
        self.assertEqual(info_resultat_antic, ['  Error infoJoc: "Metroid" desconegut.'])

class TestAjudaAmpliada(unittest.TestCase):
    def test_ajuda_infojoc(self):
        resultat = ajudaAmpliada("infoJoc")
        esperat = [
            "  Ajuda:   funcio infoJoc nomJoc",
            f"  Exemple: {diccionariFuncions['infoJoc']['exemple']}"
        ]
        self.assertEqual(resultat, esperat)

    def test_ajuda_llistarperclau(self):
        resultat = ajudaAmpliada("llistarPerClau")
        claus = ', '.join(llistaJocs[0].keys())
        esperat = [
            "  Ajuda:   funcio llistarPerClau clau condicio",
            f"  Claus:   {claus}",
            f"  Exemple: {diccionariFuncions['llistarPerClau']['exemple']}"
        ]
        self.assertEqual(resultat, esperat)

    def test_ajuda_llistarperinterval(self):
        resultat = ajudaAmpliada("llistarPerInterval")
        esperat = [
            "  Ajuda:   funcio llistarPerInterval clau inici fi",
            "  Claus:   any, preu",
            f"  Exemple: {diccionariFuncions['llistarPerInterval']['exemple']}"
        ]
        self.assertEqual(resultat, esperat)

    def test_ajuda_comptarperclau(self):
        resultat = ajudaAmpliada("comptarPerClau")
        claus = ', '.join(llistaJocs[0].keys())
        esperat = [
            "  Ajuda:   funcio comptarPerClau clau",
            f"  Claus:   {claus}",
            f"  Exemple: {diccionariFuncions['comptarPerClau']['exemple']}"
        ]
        self.assertEqual(resultat, esperat)

    def test_ajuda_modificarjoc(self):
        resultat = ajudaAmpliada("modificarJoc")
        esperat = [
            "  Ajuda:   funcio modificarJoc nomJoc clau nouValor",
            "  Claus:   nom, any, tipus, preu",
            f"  Exemple: {diccionariFuncions['modificarJoc']['exemple']}"
        ]
        self.assertEqual(resultat, esperat)

    def test_funcio_desconeguda(self):
        resultat = ajudaAmpliada("funcioInexistent")
        esperat = ['  Error ajudaAmpliada: funció "funcioInexistent" desconeguda.']
        self.assertEqual(resultat, esperat)

    def test_sense_llista_jocs(self):
        llistaJocsOriginal = llistaJocs.copy()
        llistaJocs.clear()
        
        try:
            resultat = ajudaAmpliada("llistarPerClau")
            self.assertIn("  Claus:   ", resultat[1])
            self.assertEqual(resultat[1], "  Claus:   ")
        finally:
            # Restaurar la llista original
            llistaJocs.extend(llistaJocsOriginal)

class TestCridaFuncio(unittest.TestCase):
    def test_frase_buida(self):
        resultat = cridaFuncio("")
        esperat = ["  Error cridaFuncio: no hi ha paràmetres"]
        self.assertEqual(resultat, esperat)

    def test_ajuda_general(self):
        resultat = cridaFuncio("ajuda")
        self.assertEqual(resultat, llistaAjuda)

    @patch('Exercicis.ajudaAmpliada')
    def test_ajuda_especifica(self, mock_ajudaAmpliada):
        mock_ajudaAmpliada.return_value = ["Ajuda específica per infoJoc"]
        resultat = cridaFuncio("ajuda infoJoc")
        mock_ajudaAmpliada.assert_called_with("infoJoc")
        self.assertEqual(resultat, ["Ajuda específica per infoJoc"])

    def test_funcio_sense_nom(self):
        resultat = cridaFuncio("funcio")
        esperat = ["  Error cridaFuncio: falta el nom de la funció i els paràmetres si en té"]
        self.assertEqual(resultat, esperat)

    def test_funcio_desconeguda(self):
        resultat = cridaFuncio("funcio funcioInexistent")
        esperat = ['  Error cridaFuncio: funció "funcioInexistent" desconeguda']
        self.assertEqual(resultat, esperat)

    def test_funcio_parametres_incorrectes(self):
        resultat = cridaFuncio("funcio infoJoc")
        esperat = ['  Error cridaFuncio: la funció "infoJoc" necessita 1 paràmetre']
        self.assertEqual(resultat, esperat)

    @patch('Exercicis.infoJoc')
    def test_funcio_infojoc(self, mock_infoJoc):
        mock_infoJoc.return_value = ["Informació del joc"]
        resultat = cridaFuncio('funcio infoJoc "Super Mario Bros"')
        mock_infoJoc.assert_called_with("Super Mario Bros")
        self.assertEqual(resultat, ["Informació del joc"])

    @patch('Exercicis.comptarPerClau')
    def test_funcio_comptarperclau(self, mock_comptarPerClau):
        mock_comptarPerClau.return_value = {"tipus1": 2, "tipus2": 1}
        resultat = cridaFuncio("funcio comptarPerClau tipus")
        mock_comptarPerClau.assert_called_with("tipus")
        self.assertTrue(len(resultat) > 0)  # Assumim que diccionariBonic retorna almenys una línia

    @patch('Exercicis.llistarPerClau')
    def test_funcio_llistarperclau(self, mock_llistarPerClau):
        mock_llistarPerClau.return_value = ["Joc1", "Joc2"]
        resultat = cridaFuncio('funcio llistarPerClau tipus "Acció-Aventura"')
        mock_llistarPerClau.assert_called_with("tipus", "Acció-Aventura")
        self.assertEqual(resultat, ["Joc1", "Joc2"])

    def test_funcio_llistarperclau_valor_no_numeric(self):
        resultat = cridaFuncio('funcio llistarPerClau any "no-numeric"')
        esperat = ['  Error cridaFuncio: la clau "any" ha de tenir un valor numèric']
        self.assertEqual(resultat, esperat)

    @patch('Exercicis.llistarPerInterval')
    def test_funcio_llistarperinterval(self, mock_llistarPerInterval):
        mock_llistarPerInterval.return_value = ["Joc1", "Joc2"]
        resultat = cridaFuncio("funcio llistarPerInterval any 1985 1990")
        mock_llistarPerInterval.assert_called_with("any", 1985, 1990)
        self.assertEqual(resultat, ["Joc1", "Joc2"])

    def test_funcio_llistarperinterval_clau_invalida(self):
        resultat = cridaFuncio("funcio llistarPerInterval tipus 1985 1990")
        esperat = ['  Error cridaFuncio: la clau "tipus" no és vàlida, la "llistarPerInterval" necessita "any" o "preu"']
        self.assertEqual(resultat, esperat)

    def test_funcio_llistarperinterval_valors_no_numerics(self):
        resultat = cridaFuncio("funcio llistarPerInterval any abc def")
        esperat = ["  Error cridaFuncio: inici i final han de ser números"]
        self.assertEqual(resultat, esperat)

    @patch('Exercicis.modificarJoc')
    def test_funcio_modificarjoc(self, mock_modificarJoc):
        mock_modificarJoc.return_value = ["Joc modificat"]
        resultat = cridaFuncio('funcio modificarJoc "Super Mario Bros" any 1986')
        mock_modificarJoc.assert_called_with("Super Mario Bros", "any", "1986")
        self.assertEqual(resultat, ["Joc modificat"])

    def test_tipus_peticio_desconegut(self):
        resultat = cridaFuncio("peticio_desconeguda")
        esperat = ['  Error cridaFuncio: tipus de petició "peticio_desconeguda" desconeguda']
        self.assertEqual(resultat, esperat)

class TestLimitaFrases(unittest.TestCase):
    def test_llista_buida(self):
        resultat = limitaFrases([])
        self.assertEqual(resultat, [])

    def test_llista_menys_de_10(self):
        llista_original = ['a', 'b', 'c', 'd', 'e']
        resultat = limitaFrases(llista_original)
        self.assertEqual(resultat, ['a', 'b', 'c', 'd', 'e'])
        self.assertIs(resultat, llista_original)  # Comprovem que retorna la mateixa llista

    def test_llista_exactament_10(self):
        llista_original = list(range(10))
        resultat = limitaFrases(llista_original)
        self.assertEqual(resultat, list(range(10)))
        self.assertIs(resultat, llista_original)  # Comprovem que retorna la mateixa llista

    def test_llista_mes_de_10(self):
        llista_original = list(range(15))
        resultat = limitaFrases(llista_original)
        self.assertEqual(resultat, list(range(5, 15)))
        self.assertIs(resultat, llista_original)  # Comprovem que modifica la llista original

    def test_llista_molt_llarga(self):
        llista_original = list(range(100))
        resultat = limitaFrases(llista_original)
        self.assertEqual(resultat, list(range(90, 100)))
        self.assertIs(resultat, llista_original)  # Comprovem que modifica la llista original

    def test_llista_amb_elements_no_numerics(self):
        llista_original = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l']
        resultat = limitaFrases(llista_original)
        self.assertEqual(resultat, ['c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l'])
        self.assertIs(resultat, llista_original)  # Comprovem que modifica la llista original

class TestMostraFrases(unittest.TestCase):
    @patch('sys.stdout', new_callable=StringIO)
    def test_llista_buida(self, mock_stdout):
        mostraFrases([])
        resultat = mock_stdout.getvalue().strip().split('\n')
        self.assertEqual(len(resultat), 10)
        self.assertTrue(all(line.strip() == '' for line in resultat))

    @patch('sys.stdout', new_callable=StringIO)
    def test_llista_menys_de_10(self, mock_stdout):
        mostraFrases(['a', 'b', 'c'])
        resultat = mock_stdout.getvalue().strip().split('\n')
        self.assertEqual(len(resultat), 10)
        self.assertEqual(resultat[:3], ['a', 'b', 'c'])
        self.assertTrue(all(line.strip() == '' for line in resultat[3:]))

    @patch('sys.stdout', new_callable=StringIO)
    def test_llista_exactament_10(self, mock_stdout):
        llista = [str(i) for i in range(10)]
        mostraFrases(llista)
        resultat = mock_stdout.getvalue().strip().split('\n')
        self.assertEqual(len(resultat), 10)
        self.assertEqual(resultat, llista)

    @patch('sys.stdout', new_callable=StringIO)
    def test_llista_mes_de_10(self, mock_stdout):
        llista = [str(i) for i in range(15)]
        mostraFrases(llista)
        resultat = mock_stdout.getvalue().strip().split('\n')
        self.assertEqual(len(resultat), 10)
        self.assertEqual(resultat, [str(i) for i in range(10)])

    @patch('sys.stdout', new_callable=StringIO)
    def test_elements_no_string(self, mock_stdout):
        mostraFrases([1, 2.5, True, None, [1, 2], {'a': 1}])
        resultat = mock_stdout.getvalue().strip().split('\n')
        self.assertEqual(len(resultat), 10)
        self.assertEqual(resultat[:6], ['1', '2.5', 'True', 'None', '[1, 2]', "{'a': 1}"])
        self.assertTrue(all(line.strip() == '' for line in resultat[6:]))

class TestMostraFrases(unittest.TestCase):
    @patch('sys.stdout', new_callable=StringIO)
    def test_llista_buida(self, mock_stdout):
        mostraFrases([])
        resultat = mock_stdout.getvalue().splitlines()
        self.assertEqual(len(resultat), 10)
        self.assertTrue(all(line.strip() == '' for line in resultat))

    @patch('sys.stdout', new_callable=StringIO)
    def test_llista_menys_de_10(self, mock_stdout):
        mostraFrases(['a', 'b', 'c'])
        resultat = mock_stdout.getvalue().splitlines()
        self.assertEqual(len(resultat), 10)
        self.assertEqual(resultat[:3], ['a', 'b', 'c'])
        self.assertTrue(all(line.strip() == '' for line in resultat[3:]))

    @patch('sys.stdout', new_callable=StringIO)
    def test_llista_exactament_10(self, mock_stdout):
        llista = [str(i) for i in range(10)]
        mostraFrases(llista)
        resultat = mock_stdout.getvalue().splitlines()
        self.assertEqual(len(resultat), 10)
        self.assertEqual(resultat, llista)

    @patch('sys.stdout', new_callable=StringIO)
    def test_llista_mes_de_10(self, mock_stdout):
        llista = [str(i) for i in range(15)]
        mostraFrases(llista)
        resultat = mock_stdout.getvalue().splitlines()
        self.assertEqual(len(resultat), 10)
        self.assertEqual(resultat, [str(i) for i in range(10)])

    @patch('sys.stdout', new_callable=StringIO)
    def test_elements_no_string(self, mock_stdout):
        mostraFrases([1, 2.5, True, None, [1, 2], {'a': 1}])
        resultat = mock_stdout.getvalue().splitlines()
        self.assertEqual(len(resultat), 10)
        expected = ['1', '2.5', 'True', 'None', '[1, 2]', "{'a': 1}"]
        self.assertEqual(resultat[:6], expected)
        self.assertTrue(all(line.strip() == '' for line in resultat[6:]))

class TestMainRun(unittest.TestCase):
    @patch('builtins.input', side_effect=['ajuda', 'funcio infoJoc "The Legend of Zelda"', 'sortir'])
    @patch('Exercicis.clearScreen')
    @patch('Exercicis.mostraFrases')
    @patch('Exercicis.cridaFuncio')
    def test_main_run(self, mock_cridaFuncio, mock_mostraFrases, mock_clearScreen, mock_input):
        # Configurar els mocks
        mock_cridaFuncio.side_effect = [
            ['Ajuda general'],
            ['Informació del joc The Legend of Zelda']
        ]

        # Executar mainRun
        mainRun()

        # Verificar que les funcions s'han cridat correctament
        self.assertEqual(mock_clearScreen.call_count, 3)
        self.assertEqual(mock_mostraFrases.call_count, 3)
        self.assertEqual(mock_cridaFuncio.call_count, 2)

        # Verificar les crides a cridaFuncio
        mock_cridaFuncio.assert_any_call('ajuda')
        mock_cridaFuncio.assert_any_call('funcio infoJoc "The Legend of Zelda"')

        # Verificar l'última crida a mostraFrases
        últim_historial = mock_mostraFrases.call_args[0][0]
        self.assertIn('> Comanda: ajuda', últim_historial)
        self.assertIn('Ajuda general', últim_historial)
        self.assertIn('> Comanda: funcio infoJoc "The Legend of Zelda"', últim_historial)
        self.assertIn('Informació del joc The Legend of Zelda', últim_historial)

    @patch('builtins.input', side_effect=['comanda_invalida', 'sortir'])
    @patch('Exercicis.clearScreen')
    @patch('Exercicis.mostraFrases')
    @patch('Exercicis.cridaFuncio')
    def test_comanda_invalida(self, mock_cridaFuncio, mock_mostraFrases, mock_clearScreen, mock_input):
        mock_cridaFuncio.return_value = ['Error: Comanda invàlida']

        mainRun()

        mock_cridaFuncio.assert_called_once_with('comanda_invalida')
        últim_historial = mock_mostraFrases.call_args[0][0]
        self.assertIn('> Comanda: comanda_invalida', últim_historial)
        self.assertIn('Error: Comanda invàlida', últim_historial)

    @patch('builtins.input', side_effect=['Sortir'])
    @patch('Exercicis.clearScreen')
    @patch('Exercicis.mostraFrases')
    def test_sortir_immediat(self, mock_mostraFrases, mock_clearScreen, mock_input):
        mainRun()

        self.assertEqual(mock_clearScreen.call_count, 1)
        self.assertEqual(mock_mostraFrases.call_count, 1)
        mock_mostraFrases.assert_called_once_with([])

if __name__ == '__main__':
    unittest.main()
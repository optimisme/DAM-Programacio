import unittest
import importlib.util
import sys
from unittest.mock import patch

# Classe per a provar la funció auto_menu d'un mòdul extern
class TestAutoMenuFromModule(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        # Camí a l'arxiu del mòdul extern
        module_path = 'Entrenament.py'

        # Carregar dinàmicament el mòdul
        spec = importlib.util.spec_from_file_location("auto_menu_module", module_path)
        module = importlib.util.module_from_spec(spec)
        sys.modules["auto_menu_module"] = module
        spec.loader.exec_module(module)
        cls.module = module

    @patch('builtins.input', return_value='2')
    @patch('builtins.print')
    def test_auto_menu_numeric_params(self, mock_print, mock_input):
        #Prova amb paràmetres numèrics vàlids.
        self.assertEqual(self.module.auto_menu(5, 10, 15), 10)

    @patch('builtins.print')
    def test_auto_menu_non_numeric_params(self, mock_print):
        #Prova amb paràmetres no numèrics.
        with self.assertRaises(TypeError):
            self.module.auto_menu(5, 'a', 15)

    @patch('builtins.print')
    def test_auto_menu_too_many_params(self, mock_print):
        #Prova amb més de 4 paràmetres.
        with self.assertRaises(Exception):
            self.module.auto_menu(5, 10, 15, 20, 25)

    @patch('builtins.input', return_value='5')
    @patch('builtins.print')
    def test_auto_menu_invalid_option(self, mock_print, mock_input):
        #Prova amb una opció no vàlida.
        with self.assertRaises(IndexError):
            self.module.auto_menu(5, 10, 15)

# Executar les proves (només en cas de ser executat com a script principal)
if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)
import unittest
import importlib.util
import sys
from unittest.mock import patch

class TestCalculadoraBasica(unittest.TestCase):

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

    def test_error_log_type_error(self):
        with self.assertRaises(TypeError):
            self.module.error_log('a')

    def test_error_log_key_error(self):
        with self.assertRaises(KeyError):
            self.module.error_log('b')

    def test_error_process_with_type_error(self):
        try:
            self.module.error_log('a')
        except TypeError:
            pass  # El maneig de l'excepció es fa correctament

    def test_error_process_with_key_error(self):
        try:
            self.module.error_log('b')
        except KeyError:
            pass  # El maneig de l'excepció es fa correctament

# Executar les proves (només en cas de ser executat com a script principal)
if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)

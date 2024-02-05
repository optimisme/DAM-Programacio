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

    def test_with_common_elements(self):
        self.assertEqual(self.module.recursive_difference([1, 2, 3, 4], [2, 4, 6]), [1, 3])

    def test_with_no_common_elements(self):
        self.assertEqual(self.module.recursive_difference([1, 3, 5], [2, 4, 6]), [1, 3, 5])

    def test_first_list_empty(self):
        self.assertEqual(self.module.recursive_difference([], [1, 2, 3]), [])

    def test_second_list_empty(self):
        self.assertEqual(self.module.recursive_difference([1, 2, 3], []), [1, 2, 3])

    def test_both_lists_empty(self):
        self.assertEqual(self.module.recursive_difference([], []), [])

    def test_with_repeated_elements(self):
        self.assertEqual(self.module.recursive_difference([1, 1, 2, 3], [1, 4]), [2, 3])

# Executar les proves (només en cas de ser executat com a script principal)
if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)

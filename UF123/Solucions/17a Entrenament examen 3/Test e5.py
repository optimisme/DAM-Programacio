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

    def test_suma_valida(self):
        self.assertEqual(self.module.calculadora_basica(5, 3, 'suma'), 8)

    def test_resta_valida(self):
        self.assertEqual(self.module.calculadora_basica(10, 4, 'resta'), 6)

    def test_parametre_no_enter(self):
        with self.assertRaises(TypeError):
            self.module.calculadora_basica(5, 'tres', 'suma')

    def test_parametre_no_cadena(self):
        with self.assertRaises(TypeError):
            self.module.calculadora_basica(5, 3, 123)

# Executar les proves (només en cas de ser executat com a script principal)
if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)

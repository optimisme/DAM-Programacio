import unittest
import importlib.util
import sys
import os
from io import StringIO

class TestE1RecorrerTxt(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        # Camí a l'arxiu del mòdul extern
        module_path = 'Entrenament.py'

        # Carregar dinàmicament el mòdul
        spec = importlib.util.spec_from_file_location("Entrenament", module_path)
        module = importlib.util.module_from_spec(spec)
        sys.modules["Entrenament"] = module
        spec.loader.exec_module(module)
        cls.module = module

    def test_e1_recorrer_txt(self):
        # Redireccionem stdout per capturar l'output de la funció
        old_stdout = sys.stdout
        new_stdout = StringIO()
        sys.stdout = new_stdout

        # Executem la funció
        self.module.e1_recorrer_txt('E1.txt')

        # Restaurem stdout
        sys.stdout = old_stdout
        output = new_stdout.getvalue()

        # Verifiquem l'output esperat
        expected_lines = [
            "Lorem ipsum dolor sit amet,",
            "consectetur adipiscing elit,",
            "sed do eiusmod tempor incididunt",
            "t,",
            "consectetur adipiscing elit,",
            "quis nostrud exercitation ullamco",
            "laboris nisi ut aliquip",
            "ex ea commodo consequat."
        ]
        self.assertEqual(output.strip().split('\n'), expected_lines)

# Executar les proves (només en cas de ser executat com a script principal)
if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)

import unittest
import importlib.util
import sys
import os
from io import StringIO

class TestCsvFunctionsFromModule(unittest.TestCase):

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

    def test_e2_combina_arxius_in_situ(self):
        path_a = 'E2a.txt'
        path_b = 'E2b.txt'
        
        with open(path_a, 'r') as f_a, open(path_b, 'r') as f_b:
            lines_a = f_a.readlines()
            lines_b = f_b.readlines()

        # Ajustem l'ordre de les línies de B per reflectir l'ordre real de processament
        lines_b.reverse()

        # Construïm l'expected_output basant-nos en l'ordre real de la funció
        expected_output = []
        for i in range(max(len(lines_a), len(lines_b))):
            if i < len(lines_a):
                line_a = lines_a[i].strip()
                line_b = lines_b[i].strip() if i < len(lines_b) else ""
                if i % 2 == 0:
                    expected_output.append(f"{line_a}-{line_b}")
                else:
                    expected_output.append(f"{line_b}-{line_a}")
        
        # Aquesta part del codi captura l'output real de la funció
        old_stdout = sys.stdout
        new_stdout = StringIO()
        sys.stdout = new_stdout

        self.module.e2_combina_arxius(path_a, path_b)

        sys.stdout = old_stdout
        output = new_stdout.getvalue().strip().split('\n')

        # Comparació de l'output real amb l'expected
        self.assertEqual(output, expected_output)


# Executar les proves (només en cas de ser executat com a script principal)
if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)
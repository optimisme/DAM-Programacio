import unittest
import importlib.util
import sys

class TestStudentCode(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        # Camí a l'arxiu dels estudiants
        module_path = '12d Arbres.py'

        # Carregar dinàmicament el mòdul
        spec = importlib.util.spec_from_file_location("m", module_path)
        module = importlib.util.module_from_spec(spec)
        sys.modules["m"] = module
        spec.loader.exec_module(module)

        cls.module = module


if __name__ == '__main__':
    unittest.main()

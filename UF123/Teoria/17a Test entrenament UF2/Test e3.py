import unittest
import importlib.util
import sys

# Classe per a provar la funció genera_info_canco d'un mòdul extern
class TestGeneraInfoCancoFromModule(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        # Camí a l'arxiu del mòdul extern
        module_path = 'Entrenament.py'

        # Carregar dinàmicament el mòdul
        spec = importlib.util.spec_from_file_location(module_path, module_path)
        module = importlib.util.module_from_spec(spec)
        sys.modules[module_path] = module
        spec.loader.exec_module(module)
        cls.module = module

    def test_amb_elements_unics(self):
        #Prova amb elements únics en ambdues llistes.
        result = self.module.combina_unics_recursiu([1, 3, 5], [2, 4, 6])
        expected_result = [1, 3, 5, 2, 4, 6]
        self.assertEqual(sorted(result), sorted(expected_result))

    def test_amb_elements_repetits(self):
        #Prova amb alguns elements repetits en ambdues llistes.
        result = self.module.combina_unics_recursiu([1, 2, 3], [2, 3, 4])
        expected_result = [1, 4]
        self.assertEqual(sorted(result), sorted(expected_result))

    def test_llistes_buides(self):
        #Prova amb llistes buides.
        result = self.module.combina_unics_recursiu([], [])
        expected_result = []
        self.assertEqual(result, expected_result)

    def test_una_llista_buida(self):
        #Prova amb una llista buida i una amb elements.
        result = self.module.combina_unics_recursiu([], [1, 2, 3])
        expected_result = [1, 2, 3]
        self.assertEqual(result, expected_result)

    def test_tots_elements_repetits(self):
        #Prova amb totes les llistes tenint els mateixos elements.
        result = self.module.combina_unics_recursiu([1, 2, 3], [1, 2, 3])
        expected_result = []
        self.assertEqual(result, expected_result)

# Executar les proves (només en cas de ser executat com a script principal)
if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)

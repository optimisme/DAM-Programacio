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

    def test_suma_normal(self):
        #Prova amb llistes de la mateixa longitud.
        result = self.module.suma_llistes([1, 2, 3], [4, 5, 6], [7, 8, 9])
        self.assertEqual(result, [12, 15, 18])

    def test_suma_diferent_longitud(self):
        #Prova amb llistes de longituds diferents.
        result = self.module.suma_llistes([1, 2], [3, 4, 5], [6])
        self.assertEqual(result, [10, 6, 5])

    def test_error_valor_minim(self):
        #Prova amb menys de 2 llistes.
        with self.assertRaises(ValueError):
            self.module.suma_llistes([1, 2])

    def test_error_tipus_dada(self):
        #Prova amb un tipus de dada incorrecte.
        with self.assertRaises(TypeError):
            self.module.suma_llistes([1, 2], [3, 4], "no és una llista")

# Executar les proves (només en cas de ser executat com a script principal)
if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)

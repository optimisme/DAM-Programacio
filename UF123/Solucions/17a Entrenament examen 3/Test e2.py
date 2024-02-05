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

    def test_numèrics_i_no_numèrics(self):
        #Prova amb valors numèrics i no numèrics.
        result = self.module.mostra_info_params(a=1, b="text", c=3.14)
        expected_result = "a: sí - 1\nb: no - text\nc: sí - 3.14"
        self.assertEqual(result, expected_result)

    def test_únicament_numèrics(self):
        #Prova només amb valors numèrics.
        result = self.module.mostra_info_params(x=100, y=2.5, z=3+4j)
        expected_result = "x: sí - 100\ny: sí - 2.5\nz: sí - (3+4j)"
        self.assertEqual(result, expected_result)

    def test_únicament_no_numèrics(self):
        #Prova només amb valors no numèrics.
        result = self.module.mostra_info_params(text="hola", llista=[1, 2, 3], dicc={"clau": "valor"})
        expected_result = "text: no - hola\nllista: no - [1, 2, 3]\ndicc: no - {'clau': 'valor'}"
        self.assertEqual(result, expected_result)

    def test_sense_paràmetres(self):
        #Prova sense cap paràmetre.
        result = self.module.mostra_info_params()
        expected_result = ""
        self.assertEqual(result, expected_result)

# Executar les proves (només en cas de ser executat com a script principal)
if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)

import unittest
import importlib.util
import sys
import os
from unittest.mock import patch, call

class TestCsvFunctionsFromModule(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        module_path = 'Entrenament.py'
        spec = importlib.util.spec_from_file_location("Entrenament", module_path)
        module = importlib.util.module_from_spec(spec)
        sys.modules["Entrenament"] = module
        spec.loader.exec_module(module)
        cls.module = module

    @patch('builtins.print')
    def test_e0_llegir_csv(self, mock_print):
        nom_arxiu = 'E0.csv'
        self.module.e0_llegir_csv(nom_arxiu)
        expected_calls = [
            call('0: [\'nom\', \'espècie\', \'anys_vida\', \'hàbitat\']'),
            call("1: ['Elefant Africà', 'Loxodonta africana', '60', 'Savana']"),
            call("2: ['Tigre de Bengala', 'Panthera tigris tigris', '20', 'Boscos']"),
            call("3: ['Tortuga Gegant', 'Galapagos gigantea', '100', 'Islles Galápagos']"),
            call("4: ['Llop Gris', 'Canis lupus', '13', 'Boscos i planes']"),
            call("5: ['Papagai Amazònic', 'Amazona', '50', 'Selva tropical']")
        ]
        mock_print.assert_has_calls(expected_calls, any_order=False)


    def test_e0_transforma_csv(self):
        nom_arxiu = 'E0.csv'
        increment_percentatge = 10
        dades_actualitzades = self.module.e0_transforma_csv(nom_arxiu, increment_percentatge)
        # Suposant que la columna amb índex 2 sigui convertible i necessiti l'increment
        # Verificar la transformació; l'exemple següent depèn de les dades específiques del teu CSV
        valor_original = float(dades_actualitzades[1][2]) / (1 + increment_percentatge / 100)
        valor_esperat = round(valor_original * (1 + increment_percentatge / 100))
        self.assertEqual(float(dades_actualitzades[1][2]), valor_esperat)

    def test_e0_guardar_csv(self):
        dades = [['nom', 'espècie', 'anys_vida', 'hàbitat'], ['Animal Test', 'Especie Test', '22', 'Hàbitat Test']]
        nom_arxiu_sortida = 'test_output.csv'
        self.module.e0_guardar_csv(dades, nom_arxiu_sortida)
        self.assertTrue(os.path.exists(nom_arxiu_sortida))
        # Llegir el contingut de l'arxiu per verificar les dades
        with open(nom_arxiu_sortida, 'r', encoding='utf-8') as arxiu:
            contingut = arxiu.read()
        os.remove(nom_arxiu_sortida)  # Netejar l'arxiu de sortida després del test
        self.assertIn('Animal Test,Especie Test,22,Hàbitat Test', contingut)

if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)

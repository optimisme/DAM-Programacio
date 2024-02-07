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
        nom_arxiu = 'E0.csv'  # Asumim que aquest arxiu conté dades que coneixem
        increment_percentatge = 10  # Increment del 10%

        # Crear un arxiu CSV temporal amb contingut conegut
        contingut_conegut = "nom,espècie,anys_vida,hàbitat\n" \
                            "Elefant Africà,Loxodonta africana,60,Savana\n" \
                            "Tigre de Bengala,Panthera tigris tigris,20,Boscos\n" \
                            "Tortuga Gegant,Galapagos gigantea,100,Islles Galápagos\n" \
                            "Llop Gris,Canis lupus,13,Boscos i planes\n" \
                            "Papagai Amazònic,Amazona,50,Selva tropical"

        # Escriure aquest contingut a un arxiu temporal
        with open(nom_arxiu, 'w', encoding='utf-8') as tmp_arxiu:
            tmp_arxiu.write(contingut_conegut)

        # Executar la funció de transformació
        dades_actualitzades = self.module.e0_transforma_csv(nom_arxiu, increment_percentatge)

        # Comprovar els resultats
        # Aquí comprovem que l'any de vida de l'Elefant Africà ha estat incrementat correctament
        anys_vida_esperats = round(60 * (1 + increment_percentatge / 100))
        self.assertEqual(int(dades_actualitzades[1][2]), anys_vida_esperats)

        # Comprovar l'increment per al Tigre de Bengala
        anys_vida_esperats_tigre = round(20 * (1 + increment_percentatge / 100))
        self.assertEqual(int(dades_actualitzades[2][2]), anys_vida_esperats_tigre)

    def test_e0_guardar_csv(self):
        dades = [['nom', 'espècie', 'anys_vida', 'hàbitat'], ['Animal Test', 'Especie Test', '22', 'Hàbitat Test']]
        nom_arxiu_sortida = 'E0-out.csv'
        self.module.e0_guardar_csv(dades, nom_arxiu_sortida)
        self.assertTrue(os.path.exists(nom_arxiu_sortida))
        # Llegir el contingut de l'arxiu per verificar les dades
        with open(nom_arxiu_sortida, 'r', encoding='utf-8') as arxiu:
            contingut = arxiu.read()
        os.remove(nom_arxiu_sortida)  # Netejar l'arxiu de sortida després del test
        self.assertIn('Animal Test,Especie Test,22,Hàbitat Test', contingut)

if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)

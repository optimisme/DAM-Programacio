import unittest
import importlib.util
import sys
import os

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

    def test_e0_llegir_csv(self):
        """Test per verificar que e0_llegir_csv llegeix correctament el fitxer."""
        # Aquest test pot ser difícil d'implementar sense modificar la funció original
        # perquè simplement imprimeix a la consola. Podríem buscar la manera de capturar
        # aquesta sortida, o millor encara, modificar la funció perquè retorni un valor
        # que pugui ser testejat.
        pass

    def test_e0_transforma_csv(self):
        """Test per verificar que e0_transforma_csv transforma correctament les dades."""
        nom_arxiu = 'path/to/test/file.csv'  # Necessitaràs un arxiu de prova
        increment_percentatge = 10  # Definir un percentatge d'increment per al test
        dades_actualitzades = self.module.e0_transforma_csv(nom_arxiu, increment_percentatge)
        # Afegeix aquí les teves comprovacions, per exemple:
        # self.assertEqual(dades_actualitzades[1][2], 'valor esperat després de l'increment')

    def test_e0_guardar_csv(self):
        """Test per verificar que e0_guardar_csv guarda correctament el fitxer."""
        dades = [['nom', 'espècie', 'anys_vida', 'hàbitat'], ['Animal Test', 'Especie Test', '22', 'Hàbitat Test']]
        nom_arxiu_sortida = 'path/to/output/file.csv'
        self.module.e0_guardar_csv(dades, nom_arxiu_sortida)
        # Comprovar que l'arxiu s'ha creat
        self.assertTrue(os.path.exists(nom_arxiu_sortida))
        # Potser voldràs obrir l'arxiu i comprovar que les dades són correctes

# Executar les proves (només en cas de ser executat com a script principal)
if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)

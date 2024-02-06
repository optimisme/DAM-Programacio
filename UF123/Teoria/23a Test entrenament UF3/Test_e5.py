import unittest
import os
import shutil
import importlib.util
import sys

class TestE5GeneraCarpetes(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        # Preparació: Definir la cadena de carpetes de prova
        cls.cadena_carpetes = "test_carpeta1/test_carpeta2/test_carpeta3, test_carpeta4/test_carpeta5, test_carpeta6, test_carpeta1/test_carpeta8/test_carpeta9, test_carpeta6/test_carpeta7, test_carpeta1/carpetaA, test_carpeta1/carpetaB, test_carpeta1/carpetaA/carpetaC"
        cls.carpetes_esperades = [
            "test_carpeta1/test_carpeta2/test_carpeta3",
            "test_carpeta4/test_carpeta5",
            "test_carpeta6",
            "test_carpeta1/test_carpeta8/test_carpeta9",
            "test_carpeta6/test_carpeta7",
            "test_carpeta1/carpetaA", 
            "test_carpeta1/carpetaB", 
            "test_carpeta1/carpetaA/carpetaC"
        ]

        # Carregar dinàmicament el mòdul
        module_path = 'Entrenament.py'
        spec = importlib.util.spec_from_file_location("entrenament_module", module_path)
        module = importlib.util.module_from_spec(spec)
        sys.modules["entrenament_module"] = module
        spec.loader.exec_module(module)
        cls.module = module

    def test_genera_carpetes(self):
        # Executar la funció per generar les carpetes
        self.module.e5_genera_carpetes(self.cadena_carpetes)

        # Comprovar que totes les carpetes esperades han estat creades
        for carpeta in self.carpetes_esperades:
            self.assertTrue(os.path.isdir(carpeta), f"La carpeta {carpeta} no s'ha creat correctament.")

    @classmethod
    def tearDownClass(cls):
        # Netejar: Esborrar les carpetes creades durant el test
        for carpeta in cls.carpetes_esperades:
            carpeta_arrel = carpeta.split('/')[0]  # Obtenir nom de la carpeta arrel per esborrar
            if os.path.exists(carpeta_arrel):
                shutil.rmtree(carpeta_arrel)

# Executar les proves
if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)

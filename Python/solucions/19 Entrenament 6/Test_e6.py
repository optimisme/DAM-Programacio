import unittest
import os
import shutil
import importlib.util
import sys
from pprint import pprint

class TestSerialitzacio(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        # Crear conjunts de dades de prova
        cls.dades_prova = [
            {"nom": "Pepito", "edat": 25, "adreça": {"carrer": "Carrer de la Falsa", "número": 123, "població": "Falsburg"}, "aficions": ["futbol", "tennis", "cine"], "dades_extra": {"altura": 1.75, "pes": 70}},
            {"nom": "Maria", "edat": 30, "adreça": {"carrer": "Avinguda Veritat", "número": 456, "població": "Veritaburg"}, "aficions": ["lectura", "viatjar", "cocina"], "dades_extra": {"altura": 1.65, "pes": 60}},
            {"nom": "Joan", "edat": 22, "adreça": {"carrer": "Camí Inventat", "número": 789, "població": "Inventburg"}, "aficions": ["videojocs", "música", "cinema"], "dades_extra": {"altura": 1.80, "pes": 75}}
        ]

        # Carregar dinàmicament el mòdul
        module_path = 'Entrenament.py'
        spec = importlib.util.spec_from_file_location("entrenament_module", module_path)
        module = importlib.util.module_from_spec(spec)
        sys.modules["entrenament_module"] = module
        spec.loader.exec_module(module)
        cls.module = module

    def test_guarda_i_llegeix_arxiu_bin(self):
        for i, dades in enumerate(self.dades_prova):
            nom_arxiu = f'test_dades_{i}.bin'
            self.module.e6_guarda_arxiu_bin(dades, nom_arxiu)
            dades_llegides = self.module.e6_llegeix_arxiu_bin(nom_arxiu)
            self.assertEqual(pprint(dades), dades_llegides)
            os.remove(nom_arxiu) 

if __name__ == '__main__':
    unittest.main()
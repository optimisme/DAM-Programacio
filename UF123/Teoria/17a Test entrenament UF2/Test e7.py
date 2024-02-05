import unittest
import importlib.util
import sys
from unittest.mock import patch

class TestCalculadoraBasica(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        # Camí a l'arxiu del mòdul extern
        module_path = 'Entrenament.py'

        # Carregar dinàmicament el mòdul
        spec = importlib.util.spec_from_file_location("auto_menu_module", module_path)
        module = importlib.util.module_from_spec(spec)
        sys.modules["auto_menu_module"] = module
        spec.loader.exec_module(module)
        cls.module = module

    def test_suma_profunditat_arbre_original(self):
        # Crear un arbre d'exemple
        arbre_exemple_original = {
            "node": "5",
            "esquerra": {
                "node": "2",
                "esquerra": None,
                "dreta": None
            },
            "dreta": {
                "node": "4",
                "esquerra": None,
                "dreta": None
            }
        }

        # Comprovar que la funció retorna la suma correcta de les profunditats per l'arbre original
        self.assertEqual(self.module.suma_profunditat(arbre_exemple_original), 2)

    def test_suma_profunditat_arbre_diferent(self):
        # Crear un altre arbre d'exemple
        arbre_exemple_diferent = {
            "node": "1",
            "esquerra": {
                "node": "2",
                "esquerra": {
                    "node": "3",
                    "esquerra": None,
                    "dreta": None
                },
                "dreta": None
            },
            "dreta": {
                "node": "4",
                "esquerra": None,
                "dreta": {
                    "node": "5",
                    "esquerra": None,
                    "dreta": None
                }
            }
        }

        # Comprovar que la funció retorna la suma correcta de les profunditats per l'arbre diferent
        # En aquest cas, la suma esperada de les profunditats és 5 (0+1+2+1+2)
        self.assertEqual(self.module.suma_profunditat(arbre_exemple_diferent), 6)

# Executar les proves (només en cas de ser executat com a script principal)
if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)

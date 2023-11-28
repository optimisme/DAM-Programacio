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

    def test_compta_nodes(self):
        self.assertEqual(self.module.compta_nodes(self.module.animals), 12)
        self.assertEqual(self.module.compta_nodes(self.module.plats), 5)
        self.assertEqual(self.module.compta_nodes(self.module.planetes), 8)

    def test_troba_max_min(self):
        maxim, minim = self.module.troba_max_min(self.module.numeros)
        self.assertEqual(maxim, 25)
        self.assertEqual(minim, 7)

    def test_cami_a_node(self):
        self.assertEqual(self.module.cami_a_node(self.module.animals, "hamster"), ["gat", "gossos", "conill", "hamster"])
        self.assertEqual(self.module.cami_a_node(self.module.animals, "iguana"), ["gat", "gossos", "tortuga", "iguana"])
        self.assertIsNone(self.module.cami_a_node(self.module.planetes, "Saturn"))

    def test_suma_nivell(self):
        self.assertEqual(self.module.suma_nivell(self.module.numeros, 1), 30)
        self.assertEqual(self.module.suma_nivell(self.module.numeros, 2), 61)

    def test_espelma_arbre(self):
        arbre_test = {
            "node": 1,
            "esquerra": {
                "node": 2,
                "esquerra": None,
                "dreta": None
            },
            "dreta": {
                "node": 3,
                "esquerra": None,
                "dreta": None
            }
        }
        arbre_espelmat = self.module.espelma_arbre(arbre_test)
        self.assertEqual(arbre_espelmat, {
            "node": 1,
            "esquerra": {
                "node": 3,
                "esquerra": None,
                "dreta": None
            },
            "dreta": {
                "node": 2,
                "esquerra": None,
                "dreta": None
            }
        })

    def test_nivell_node(self):
        self.assertEqual(self.module.nivell_node(self.module.animals, "hamster"), 3)
        self.assertEqual(self.module.nivell_node(self.module.planetes, "Io"), 2)
        self.assertEqual(self.module.nivell_node(self.module.plats, "pizza"), 2)
        self.assertEqual(self.module.nivell_node(self.module.animals, "unicorn"), -1)

    def test_es_arbre_cerca(self):
        self.assertTrue(self.module.es_arbre_cerca(self.module.numeros))

    def test_mirall_arbre(self):
        arbre_original = {
            "node": "A",
            "esquerra": {"node": "B", "esquerra": None, "dreta": None},
            "dreta": {"node": "C", "esquerra": None, "dreta": None}
        }
        arbre_espelmat = self.module.mirall_arbre(arbre_original)
        arbre_esperat = {
            "node": "A",
            "dreta": {"node": "B", "esquerra": None, "dreta": None},
            "esquerra": {"node": "C", "esquerra": None, "dreta": None}
        }
        self.assertEqual(arbre_espelmat, arbre_esperat)


    def test_suma_cami_fulles(self):
        sumes = self.module.suma_cami_fulles(self.module.numeros)
        self.assertIn(32, sumes)  # 15 -> 10 -> 7
        self.assertIn(60, sumes)  


if __name__ == '__main__':
    unittest.main()

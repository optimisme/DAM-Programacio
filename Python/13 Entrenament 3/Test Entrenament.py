import unittest
import importlib.util
import sys

class TestStudentCode(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        # Camí a l'arxiu dels estudiants
        module_path = '11i Entrenament exàmen.py'

        # Carregar dinàmicament el mòdul
        spec = importlib.util.spec_from_file_location("m", module_path)
        module = importlib.util.module_from_spec(spec)
        sys.modules["m"] = module
        spec.loader.exec_module(module)

        cls.module = module

    def test_genera_dni(self):
        dni = self.module.genera_dni()
        self.assertTrue(len(dni) == 10 and dni[-2] == '-')

    def test_genera_id(self):
        id = self.module.genera_id()
        self.assertTrue(len(id) == 5 and id[1].isalpha() and id[4].isalpha())

    def test_genera_usuari(self):
        usuari = self.module.genera_usuari()
        self.assertIn('id', usuari)
        self.assertIn('nom', usuari)
        self.assertIn('edat', usuari)
        self.assertIn('dni', usuari)
        self.assertIn('acces', usuari)

    def test_afegir_i_mostra_usuari(self):
        self.module.usuaris.clear()
        usuari = self.module.genera_usuari()
        self.module.afegir_usuari(usuari)
        self.assertEqual(len(self.module.usuaris), 1)
        self.module.mostra_usuari(usuari['id'])

    def test_busca_i_esborra_usuari(self):
        self.module.usuaris.clear()
        usuari = self.module.genera_usuari()
        self.module.afegir_usuari(usuari)
        index = self.module.busca_usuari(usuari['id'])
        self.assertNotEqual(index, -1)
        self.module.esborra_usuari(usuari['id'])
        index = self.module.busca_usuari(usuari['id'])
        self.assertEqual(index, -1)

if __name__ == '__main__':
    unittest.main()

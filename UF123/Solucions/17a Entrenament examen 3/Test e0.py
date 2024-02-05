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

    def test_info_completa(self):
        #Prova amb tota la informació disponible.
        result = self.module.genera_info_canco(
            titols=['Cançó 1', 'Cançó 2'],
            artistes=['Artista 1', 'Artista 2'],
            duracio=[3, 4]
        )
        self.assertEqual(result, ['Artista 1 - Cançó 1 - 3 minuts', 'Artista 2 - Cançó 2 - 4 minuts'])

    def test_sense_titols(self):
        #Prova sense els titols.
        result = self.module.genera_info_canco(
            artistes=['Artista 1', 'Artista 2'],
            duracio=[3, 4]
        )
        self.assertEqual(result, ['Artista 1 - 3 minuts', 'Artista 2 - 4 minuts'])

    def test_sense_duracio(self):
        #Prova sense la duracio.
        result = self.module.genera_info_canco(
            titols=['Cançó 1', 'Cançó 2'],
            artistes=['Artista 1', 'Artista 2']
        )
        self.assertEqual(result, ['Artista 1 - Cançó 1', 'Artista 2 - Cançó 2'])

    def test_error_tipus_titols(self):
        #Prova amb un tipus incorrecte per titols.
        with self.assertRaises(TypeError):
            self.module.genera_info_canco(titols="No és una llista", artistes=['Artista 1', 'Artista 2'])

    def test_error_tipus_duracio(self):
        #Prova amb un tipus incorrecte per duracio.
        with self.assertRaises(TypeError):
            self.module.genera_info_canco(titols=['Cançó 1', 'Cançó 2'], artistes=['Artista 1', 'Artista 2'], duracio="No és una llista")

    def test_error_longitud(self):
        #Prova amb llistes de longituds diferents.
        with self.assertRaises(ValueError):
            self.module.genera_info_canco(
                titols=['Cançó 1'],
                artistes=['Artista 1', 'Artista 2'],
                duracio=[3, 4]
            )

# Executar les proves (només en cas de ser executat com a script principal)
if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)

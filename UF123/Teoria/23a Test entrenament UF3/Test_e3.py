import unittest
import os
import shutil
import importlib.util
import sys

class TestE3Esborra(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        # Crear una estructura de directoris i arxius per al test
        cls.directoris = [
            './test_dir/dir1',
            './test_dir/dir1/dir2',
            './test_dir/dir1/dir2/dir3',
            './test_dir/dir1/dir2/dir3/dir4',
            './test_dir/dir1/dir2/dir3/dir4/dir5'
            './test_dir/dir1/dir2/dir6',
            './test_dir/dir1/dir2/dir6/dir7',
        ]
        cls.nom_arxiu = 'test.txt'
        for dir in cls.directoris:
            os.makedirs(dir, exist_ok=True)
            with open(os.path.join(dir, cls.nom_arxiu), 'w') as f:
                f.write('Aquest és un fitxer de test.')

        # Camí a l'arxiu del mòdul extern
        module_path = 'Entrenament.py'

        # Carregar dinàmicament el mòdul
        spec = importlib.util.spec_from_file_location("auto_menu_module", module_path)
        module = importlib.util.module_from_spec(spec)
        sys.modules["auto_menu_module"] = module
        spec.loader.exec_module(module)
        cls.module = module

    def test_e3_esborra(self):
        # Esborrar els arxius 'test.txt' de manera recursiva
        self.module.e3_esborra('test.txt', './test_dir')

        # Comprovar que els arxius s'han esborrat
        for dir in self.directoris:
            self.assertFalse(os.path.exists(os.path.join(dir, self.nom_arxiu)))

    @classmethod
    def tearDownClass(cls):
        # Netejar la estructura de directoris després del test
        shutil.rmtree('./test_dir')

# Executar les proves
if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)

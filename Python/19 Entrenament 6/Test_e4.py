import unittest
import os
import shutil
import importlib.util
import sys

class TestE4BuscaArxius(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        # Crear una estructura de directoris i arxius per al test
        cls.base_dir = 'test_busca_dir'
        cls.directoris = [
            f'{cls.base_dir}/dir1',
            f'{cls.base_dir}/dir1/dir2',
            f'{cls.base_dir}/dir1/dir2/dir3',
            f'{cls.base_dir}/dir1/dir4',
            f'{cls.base_dir}/dir1/dir4/dir5'
        ]
        cls.arxius = [
            f'{cls.base_dir}/dir1/file1.txt',
            f'{cls.base_dir}/dir1/dir2/file2.txt',
            f'{cls.base_dir}/dir1/dir2/dir3/file3.md',
            f'{cls.base_dir}/dir1/dir4/file2.txt',
            f'{cls.base_dir}/dir1/dir4/dir5/file3.md'
        ]
        os.makedirs(cls.base_dir, exist_ok=True)
        for dir in cls.directoris:
            os.makedirs(dir, exist_ok=True)
        for arxiu in cls.arxius:
            with open(arxiu, 'w') as f:
                f.write('Contingut de prova')

        # Carregar dinàmicament el mòdul
        module_path = 'Entrenament.py'
        spec = importlib.util.spec_from_file_location("entrenament_module", module_path)
        module = importlib.util.module_from_spec(spec)
        sys.modules["entrenament_module"] = module
        spec.loader.exec_module(module)
        cls.module = module

    def test_busca_txt(self):
        arxius_txt = self.module.e4_busca_arxius('.txt', self.base_dir)
        self.assertEqual(len(arxius_txt), 3)
        for arxiu in arxius_txt:
            self.assertTrue(arxiu.endswith('.txt'))

    def test_busca_md(self):
        arxius_md = self.module.e4_busca_arxius('.md', self.base_dir)
        self.assertEqual(len(arxius_md), 2)
        for arxiu in arxius_md:
            self.assertTrue(arxiu.endswith('.md'))

    @classmethod
    def tearDownClass(cls):
        # Netejar la estructura de directoris després del test
        shutil.rmtree(cls.base_dir)

# Executar les proves
if __name__ == '__main__':
    unittest.main(argv=[''], exit=False)

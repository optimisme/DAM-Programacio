import unittest
import importlib.util
import sys

class TestStudentCode(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        # Camí a l'arxiu dels estudiants
        module_path = '12b Recursivitat.py'

        # Carregar dinàmicament el mòdul
        spec = importlib.util.spec_from_file_location("m", module_path)
        module = importlib.util.module_from_spec(spec)
        sys.modules["m"] = module
        spec.loader.exec_module(module)

        cls.module = module

    def test_fraseLletraFinal(self):
        self.assertEqual(self.module.fraseLletraFinal("Hola món", "m"), "món")
        self.assertEqual(self.module.fraseLletraFinal("Test", "s"), "st")
        self.assertEqual(self.module.fraseLletraFinal("Test", "z"), "")

    def test_fraseLletraInicial(self):
        self.assertEqual(self.module.fraseLletraInicial("Hola món", "m"), "Hola m")
        self.assertEqual(self.module.fraseLletraInicial("Test", "e"), "Te")
        self.assertEqual(self.module.fraseLletraInicial("Test", "z"), "")

    def test_comptaVocals(self):
        self.assertEqual(self.module.comptaVocals("Hola mon", "o"), 2)
        self.assertEqual(self.module.comptaVocals("Test", "e"), 1)

    def test_ordenaVocals(self):
        self.assertEqual(self.module.ordenaVocals("Hola mon"), "oaonm lH")
        self.assertEqual(self.module.ordenaVocals("adeu Marianu"), "aeuaiaunrM d")

    def test_fraseVocalsMayusConsonantsMinus(self):
        self.assertEqual(self.module.fraseVocalsMayusConsonantsMinus("Hola mon"), "hOlA mOn")
        self.assertEqual(self.module.fraseVocalsMayusConsonantsMinus("adeu Marianu"), "AdEU mArIAnU")

    def test_sumaLlista(self):
        self.assertEqual(self.module.sumaLlista([1, 2, 3, 4]), 10)
        self.assertEqual(self.module.sumaLlista([]), 0)
        self.assertEqual(self.module.sumaLlista([-1, 1]), 0)

    def test_inverteixLlista(self):
        self.assertEqual(self.module.inverteixLlista([1, 2, 3, 4]), [4, 3, 2, 1])
        self.assertEqual(self.module.inverteixLlista([]), [])
        self.assertEqual(self.module.inverteixLlista(['a', 'b', 'c']), ['c', 'b', 'a'])

    def test_comptaElements(self):
        self.assertEqual(self.module.comptaElements([1, 2, 3, 2], 2), 2)
        self.assertEqual(self.module.comptaElements([], 5), 0)
        self.assertEqual(self.module.comptaElements(['a', 'b', 'a'], 'a'), 2)

    def test_filtraParelles(self):
        self.assertEqual(self.module.filtraParells([1, 2, 3, 4]), [2, 4])
        self.assertEqual(self.module.filtraParells([1, 3, 5]), [])
        self.assertEqual(self.module.filtraParells([22, 24, 26]), [22, 24, 26])
        self.assertEqual(self.module.filtraParells([]), [])

    def test_maximElement(self):
        self.assertEqual(self.module.maximElement([1, 2, 3, 4]), 4)
        self.assertEqual(self.module.maximElement([10]), 10)


    def test_trobaSubllista(self):
        self.assertTrue(self.module.trobaSubllista([1, 2, 3, 4], [2, 3]))
        self.assertFalse(self.module.trobaSubllista([1, 2, 4, 5], [2, 3]))
        self.assertTrue(self.module.trobaSubllista([1, 2, 3, 4], []))
        self.assertFalse(self.module.trobaSubllista([], [1, 2]))

    def test_eliminaDuplicats(self):
        self.assertEqual(self.module.eliminaDuplicats([1, 2, 2, 3, 3, 3, 4]), [1, 2, 3, 4])
        self.assertEqual(self.module.eliminaDuplicats([]), [])
        self.assertEqual(self.module.eliminaDuplicats([1, 1, 1, 1]), [1])

    def test_permutacionsLlista(self):
        result = self.module.permutacionsLlista([1, 2, 3])
        expected = [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
        for perm in expected:
            self.assertIn(perm, result)
        self.assertEqual(len(result), len(expected))
        self.assertEqual(self.module.permutacionsLlista([]), [[]])

    def test_comptaElementsDicc(self):
        self.assertEqual(self.module.comptaElementsDicc({"a": 1, "b": 2, "c": 3}), 3)
        self.assertEqual(self.module.comptaElementsDicc({"a": 1, "b": {"c": 2, "d": 3}}), 4)
        self.assertEqual(self.module.comptaElementsDicc({}), 0)

    def test_sumaValorsDicc(self):
        self.assertEqual(self.module.sumaValorsDicc({"a": 1, "b": 2, "c": 3}), 6)
        self.assertEqual(self.module.sumaValorsDicc({"a": 1, "b": {"c": 2, "d": 3}}), 6)
        self.assertEqual(self.module.sumaValorsDicc({}), 0)

    def test_buscarReemplaçar(self):
        dicc = {"a": 1, "b": {"c": 2, "d": 3}}
        self.module.buscarReemplaçar(dicc, "c", 10)
        self.assertEqual(dicc, {"a": 1, "b": {"c": 10, "d": 3}})

    def test_fusionaDiccionaris(self):
        dicc1 = {"a": 1, "b": 2}
        dicc2 = {"b": 3, "c": 4}
        result = self.module.fusionaDiccionaris(dicc1, dicc2)
        self.assertEqual(result, {"a": 1, "b": 3, "c": 4})

        dicc1 = {"a": {"b": 1}, "c": 3}
        dicc2 = {"a": {"d": 2}, "c": 4}
        result = self.module.fusionaDiccionaris(dicc1, dicc2)
        self.assertEqual(result, {"a": {"b": 1, "d": 2}, "c": 4})

    def test_invertirDiccionari(self):
        self.assertEqual(self.module.invertirDiccionari({"a": 1, "b": 2}), {1: "a", 2: "b"})
        self.assertEqual(self.module.invertirDiccionari({1: "a", 2: "b"}), {"a": 1, "b": 2})
        self.assertEqual(self.module.invertirDiccionari({}), {})

    def test_divisoPerRestesSuccessives(self):
        self.assertEqual(self.module.divisoPerRestesSuccessives(10, 3), 3)
        self.assertEqual(self.module.divisoPerRestesSuccessives(10, 2), 5)
        self.assertEqual(self.module.divisoPerRestesSuccessives(10, 0), 0)
        self.assertEqual(self.module.divisoPerRestesSuccessives(10, 11), 0)

    def test_sumaDigits(self):
        self.assertEqual(self.module.sumaDigits(123), 6)
        self.assertEqual(self.module.sumaDigits(1234), 10)
        self.assertEqual(self.module.sumaDigits(0), 0)

    def test_multiplicaLlista(self):
        self.assertEqual(self.module.multiplicaLlista([1, 2, 3]), 6)
        self.assertEqual(self.module.multiplicaLlista([1, 2, 3, 4]), 24)
        self.assertEqual(self.module.multiplicaLlista([1]), 1)
        self.assertEqual(self.module.multiplicaLlista([]), 1)

    def test_indexCoincideix(self):
        self.assertEqual(self.module.indexCoincideix([0, 1, 2, 3]), [0, 1, 2, 3])
        self.assertEqual(self.module.indexCoincideix([1, 0, 2, 3]), [2, 3])
        self.assertEqual(self.module.indexCoincideix([0, 2, 1, 3]), [0, 3])
        self.assertEqual(self.module.indexCoincideix([]), [])

    def test_dinsRang(self):
        self.assertTrue(self.module.dinsRang([1, 2, 3], 2))
        self.assertFalse(self.module.dinsRang([1, 2, 3], 4))
        self.assertFalse(self.module.dinsRang([], 1))

    def test_insereixAleatoris(self):
        llista_original = [1, 2, 3]
        llista_ampliada = self.module.insereixAleatoris(llista_original[:])
        self.assertTrue(all(0 <= elem <= 9 for elem in llista_ampliada))
        self.assertEqual(len(llista_ampliada), len(set(llista_ampliada)))  # No duplicats
        self.assertTrue(all(elem in llista_ampliada for elem in llista_original))

        # Comprovant si la llista s'amplia fins a tenir tots els elements de 0 a 9
        self.assertEqual(len(llista_ampliada), 10)

    def test_multiplicacioRusa(self):
        self.assertEqual(self.module.multiplicacioRusa(27, 82), 2214)
        self.assertEqual(self.module.multiplicacioRusa(6, 7), 42)
        self.assertEqual(self.module.multiplicacioRusa(0, 82), 0)
        self.assertEqual(self.module.multiplicacioRusa(27, 0), 0)

    def test_separaParaules(self):
        self.assertEqual(self.module.separaParaules("Hola món"), ["Hola", "món"])
        self.assertEqual(self.module.separaParaules(""), [])

    def test_generaArbre(self):
        self.assertEqual(self.module.generaArbre("Benvinguts"), ["Benvinguts", "Benvingut", "Benvingu", "Benving", "Benvin", "Benvi", "Benv", "Ben", "Be", "B"])
        self.assertEqual(self.module.generaArbre(""), [])

if __name__ == '__main__':
    unittest.main()

#!/usr/bin/env python3

import unittest
from Exercicis import infoJoc, llistaJocs

class TestInfoJoc(unittest.TestCase):
    def test_joc_existent(self):
        resultat = infoJoc("Super Mario Bros")
        esperat = ["  Super Mario Bros: 1985, Plataformes (5000 pessetes)"]
        self.assertEqual(resultat, esperat)

    def test_joc_inexistent(self):
        resultat = infoJoc("Joc Inexistent")
        esperat = ['  Error infoJoc: "Joc Inexistent" desconegut.']
        self.assertEqual(resultat, esperat)

    def test_tots_els_jocs(self):
        for joc in llistaJocs:
            resultat = infoJoc(joc["nom"])
            esperat = [f"  {joc['nom']}: {joc['any']}, {joc['tipus']} ({joc['preu']} pessetes)"]
            self.assertEqual(resultat, esperat)

if __name__ == '__main__':
    unittest.main()
#!/usr/bin/env python3

import unittest
import Exercicis  # Importa les funcions de l'arxiu 'Exercicis.py'

class TestExercici(unittest.TestCase):

    # Test per a la funció celsius_a_fahrenheit
    def test_celsius_a_fahrenheit(self):
        self.assertEqual(Exercicis.celsius_a_fahrenheit(0), 32)
        self.assertEqual(Exercicis.celsius_a_fahrenheit(100), 212)
    
    # Test per a la funció fahrenheit_a_celsius
    def test_fahrenheit_a_celsius(self):
        self.assertEqual(Exercicis.fahrenheit_a_celsius(32), 0)
        self.assertEqual(Exercicis.fahrenheit_a_celsius(212), 100)
    
    # Test per a la funció calcular_imc
    def test_calcular_imc(self):
        self.assertAlmostEqual(Exercicis.calcular_imc(70, 1.75), 22.86, places=2)
        
    def test_calcular_imc_altres_valors(self):
        self.assertAlmostEqual(Exercicis.calcular_imc(80, 1.80), 24.69, places=2)

    # Test per a la funció calcular_hipotenusa
    def test_calcular_hipotenusa(self):
        self.assertAlmostEqual(Exercicis.calcular_hipotenusa(3, 4), 5)

    # Test per a la funció es_parell
    def test_es_parell(self):
        self.assertTrue(Exercicis.es_parell(4))
        self.assertFalse(Exercicis.es_parell(7))
    
    # Test per a la funció area_cercle
    def test_area_cercle(self):
        self.assertAlmostEqual(Exercicis.area_cercle(1), 3.1416, places=4)

    def test_area_cercle_altre_radi(self):
        self.assertAlmostEqual(Exercicis.area_cercle(2), 12.5664, places=4)

    # Test per a la funció minuts_a_hores_minuts
    def test_minuts_a_hores_minuts(self):
        self.assertEqual(Exercicis.minuts_a_hores_minuts(130), (2, 10))
    
    # Test per a la funció perimetre_i_area_rectangle
    def test_perimetre_i_area_rectangle(self):
        self.assertEqual(Exercicis.perimetre_i_area_rectangle(5, 10), (30, 50))
    
    def test_perimetre_i_area_rectangle_altres_valors(self):
        self.assertEqual(Exercicis.perimetre_i_area_rectangle(3, 7), (20, 21))

    # Test per a la funció preu_final
    def test_preu_final(self):
        self.assertEqual(Exercicis.preu_final(100, 20), 80)

    # Test per a la funció interes_simple
    def test_interes_simple(self):
        self.assertEqual(Exercicis.interes_simple(1000, 5, 2), 100)
    
    # Test per a la funció kmh_a_ms
    def test_kmh_a_ms(self):
        self.assertAlmostEqual(Exercicis.kmh_a_ms(36), 10)
    
    # Test per a exercici1
    def test_exercici1(self):
        frase = "La programació és com l'art de resoldre problemes"
        # Llargada de la frase
        self.assertEqual(len(frase), 49)
        # Subcadena 'art' en majúscules
        self.assertEqual('art'.upper(), "ART")
        # Inicials de cada paraula
        inicials = ''.join([paraula[0] for paraula in frase.split()])
        self.assertEqual(inicials, 'Lpécldrp')
        # Frase en majúscules i minúscules
        self.assertEqual(frase.upper(), "LA PROGRAMACIÓ ÉS COM L'ART DE RESOLDRE PROBLEMES")
        self.assertEqual(frase.lower(), "la programació és com l'art de resoldre problemes")
        # Frase invertida
        frase_invertida = ' '.join(frase.split()[::-1])
        self.assertEqual(frase_invertida, "problemes resoldre de l'art com és programació La")
    
    # Test per a exercici2
    def test_exercici2(self):
        frase = "Python és un llenguatge de programació potent i versàtil"
        # Posició de la paraula 'programació'
        self.assertEqual(frase.find('programació'), 27)
        # Concatenació de 'Python' i 'potent'
        paraules = frase.split()
        python_potent = paraules[0] + paraules[6]
        self.assertEqual(python_potent, "Pythonpotent")
        # Subcadena de 'un' a 'potent'
        inici = frase.find('un')
        final = frase.find('potent') + len('potent')
        subcadena = frase[inici:final]
        self.assertEqual(subcadena, 'un llenguatge de programació potent')
        # Frase amb vocals reemplaçades per '*'
        vocals = 'aeiouàèéíòóúüAEIOUÀÈÉÍÒÓÚÜ'
        frase_sense_vocals = ''.join(['*' if c in vocals else c for c in frase])
        self.assertEqual(frase_sense_vocals, "Pyth*n *s *n ll*ng**tg* d* pr*gr*m*c** p*t*nt * v*rs*t*l")
        # Frase amb la primera lletra de cada paraula en majúscula
        self.assertEqual(frase.title(), "Python És Un Llenguatge De Programació Potent I Versàtil")
    
    # Aquí podries afegir més tests per a la resta d'exercicis si fos necessari.

if __name__ == '__main__':
    unittest.main()

#!/usr/bin/env python3

import unittest
import re
from unittest.mock import patch, MagicMock
from io import StringIO
from examen02 import createCode, createName, createAge, createType, createActivities, addPets, searchPets, modifyPets, deletePets, mainRun

class TestCreateCode(unittest.TestCase):
    
    def test_createCode_format(self):
        # Test the format of the generated code
        code = createCode()
        pattern = r'^\d{3}[A-Z]{3}-\d{1,2}$'
        self.assertTrue(re.match(pattern, code), f"Format of code {code} is incorrect")
    
    def test_createCode_year_range(self):
        # Test that the year part of the code is between 1 and 15
        for _ in range(100):
            code = createCode()
            year = int(code.split('-')[-1])
            self.assertTrue(1 <= year <= 15, f"Year {year} is out of range")

class TestCreateName(unittest.TestCase):
    
    def test_createName_validity(self):
        # Test that the generated name is in the predefined list of names
        valid_names = ["Max", "Bella", "Luna", "Charlie", "Lucy", "Cooper", "Bailey", "Daisy", "Sadie", "Oliver"]
        for _ in range(100):
            name = createName()
            self.assertIn(name, valid_names, f"Name {name} is not in the valid names list")

class TestCreateAge(unittest.TestCase):
    
    def test_createAge_range(self):
        # Test that the generated age is between 1 and 15
        for _ in range(100):
            age = createAge()
            self.assertTrue(1 <= age <= 15, f"Age {age} is out of valid range (1-15)")

class TestCreateType(unittest.TestCase):
    
    def test_createType_validity(self):
        # Test that the generated type is in the predefined list of animal types
        valid_types = ["gos", "gat", "conill", "hamster", "ocell"]
        for _ in range(100):
            animal_type = createType()
            self.assertIn(animal_type, valid_types, f"Animal type {animal_type} is not valid")

class TestCreateActivities(unittest.TestCase):
    
    def test_createActivities_validity(self):
        # Test that the generated activities are in the predefined list of activities
        valid_activities = ["Correr", "Saltar", "Nedar", "Caçar", "Jugar a la pilota", "Dormir"]
        for _ in range(100):
            activities = createActivities()
            for activity in activities:
                self.assertIn(activity, valid_activities, f"Activity {activity} is not valid")
    
    def test_createActivities_length(self):
        # Test that the generated activities list length is between 2 and 5
        for _ in range(100):
            activities = createActivities()
            self.assertTrue(2 <= len(activities) <= 5, f"Number of activities {len(activities)} is out of range (2-5)")

class TestAddPets(unittest.TestCase):

    @patch.dict('examen02.pets', {}, clear=True)  # Substitueix el diccionari global 'pets' amb un de buit
    @patch('examen02.createCode')
    @patch('examen02.createName')
    @patch('examen02.createAge')
    @patch('examen02.createType')
    @patch('examen02.createActivities')
    def test_addPets(self, mock_activities, mock_type, mock_age, mock_name, mock_code):
        # Setup mocks
        mock_code.side_effect = ['123ABC-5', '456DEF-7']
        mock_name.side_effect = ['Charlie', 'Max']
        mock_age.side_effect = [5, 7]
        mock_type.side_effect = ['gos', 'gat']
        mock_activities.side_effect = [['Correr', 'Jugar a la pilota'], ['Dormir', 'Nedar']]
        
        result = addPets(2)
        
        # Validem el contingut del diccionari 'pets'
        from examen02 import pets  # Fem referència a 'pets' dins del test
        self.assertEqual(len(result), 2)
        self.assertIn('123ABC-5', pets)  # Validem l'entrada en 'pets'
        self.assertIn('456DEF-7', pets)
        self.assertEqual(pets['123ABC-5']['name'], 'Charlie')
        self.assertEqual(pets['456DEF-7']['activities'], ['Dormir', 'Nedar'])

class TestSearchPets(unittest.TestCase):

    def setUp(self):
        from examen02 import pets  # Fem referència a 'pets' dins del test
        pets['123ABC-5'] = {
            'name': 'Charlie',
            'age': 5,
            'type': 'gos',
            'activities': ['Correr', 'Jugar a la pilota']
        }
        pets['456DEF-7'] = {
            'name': 'Max',
            'age': 7,
            'type': 'gat',
            'activities': ['Dormir', 'Nedar']
        }
    
    def test_searchPets_name(self):
        with patch('builtins.print') as mocked_print:
            searchPets('name', 'Charlie')
            mocked_print.assert_called_with("(searchPets) Found 1: ['123ABC-5']")
    
    def test_searchPets_type(self):
        with patch('builtins.print') as mocked_print:
            searchPets('type', 'gat')
            mocked_print.assert_called_with("(searchPets) Found 1: ['456DEF-7']")

    def test_searchPets_no_results(self):
        with patch('builtins.print') as mocked_print:
            searchPets('name', 'Luna')
            mocked_print.assert_called_with("(searchPets) No pets found")

class TestModifyPets(unittest.TestCase):

    def setUp(self):
        from examen02 import pets  # Fem referència a 'pets' dins del test
        pets['123ABC-5'] = {
            'name': 'Charlie',
            'age': 5,
            'type': 'gos',
            'activities': ['Correr', 'Jugar a la pilota']
        }
        pets['456DEF-7'] = {
            'name': 'Max',
            'age': 7,
            'type': 'gat',
            'activities': ['Dormir', 'Nedar']
        }

    def test_modifyPets_name(self):
        from examen02 import pets, modifyPets
        with patch('builtins.print') as mocked_print:
            modifyPets('123ABC-5', 'name', 'Rocky')
            mocked_print.assert_called_with("(modifyPets) Pet 123ABC-5 modified")
            self.assertEqual(pets['123ABC-5']['name'], 'Rocky')

    def test_modifyPets_activities(self):
        from examen02 import pets, modifyPets
        with patch('builtins.print') as mocked_print:
            modifyPets('456DEF-7', 'activities', 'Correr, Saltar')
            mocked_print.assert_called_with("(modifyPets) Pet 456DEF-7 modified")
            self.assertEqual(pets['456DEF-7']['activities'], ['Correr', 'Saltar'])

    def test_modifyPets_not_found(self):
        from examen02 import modifyPets
        with patch('builtins.print') as mocked_print:
            modifyPets('789GHI-10', 'name', 'Luna')
            mocked_print.assert_called_with("(modifyPets) Pet 789GHI-10 not found")

class TestDeletePets(unittest.TestCase):

    def setUp(self):
        from examen02 import pets  # Fem referència a 'pets' dins del test
        pets['123ABC-5'] = {
            'name': 'Charlie',
            'age': 5,
            'type': 'gos',
            'activities': ['Correr', 'Jugar a la pilota']
        }
        pets['456DEF-7'] = {
            'name': 'Max',
            'age': 7,
            'type': 'gat',
            'activities': ['Dormir', 'Nedar']
        }

    def test_deletePets_single(self):
        from examen02 import pets, deletePets
        with patch('builtins.print') as mocked_print:
            deletePets(['123ABC-5'])
            mocked_print.assert_called_with("(deletePets) Pets deleted: ['123ABC-5']")
            self.assertNotIn('123ABC-5', pets)

    def test_deletePets_multiple(self):
        from examen02 import pets, deletePets
        with patch('builtins.print') as mocked_print:
            deletePets(['123ABC-5', '456DEF-7'])
            mocked_print.assert_called_with("(deletePets) Pets deleted: ['123ABC-5', '456DEF-7']")
            self.assertNotIn('123ABC-5', pets)
            self.assertNotIn('456DEF-7', pets)

    def test_deletePets_not_found(self):
        from examen02 import pets, deletePets
        with patch('builtins.print') as mocked_print:
            deletePets(['789GHI-10'])  # Un codi que no existeix
            mocked_print.assert_called_with("(deletePets) Pets deleted: []")
            self.assertIn('123ABC-5', pets)
            self.assertIn('456DEF-7', pets)

class TestMainRun(unittest.TestCase):

    @patch('builtins.input', side_effect=['0'])  # Simula l'entrada per sortir del programa
    @patch('builtins.print')
    def test_mainRun_exit(self, mock_print, mock_input):
        # Simula l'execució del menú principal amb l'opció de sortir ('0')
        mainRun()
        mock_print.assert_any_call("Gestió de mascotes:\n1) Llista\n2) Afegir\n3) Modificar\n4) Esborrar\n5) Buscar\n0) Sortir")
        mock_input.assert_called_once_with("Escull una opció [0-5]: ")

    @patch('builtins.input', side_effect=['1', '0'])  # Simula l'entrada per llistar mascotes i després sortir
    @patch('builtins.print')
    @patch.dict('examen02.pets', {
        '123ABC-5': {
            'name': 'Charlie',
            'age': 5,
            'type': 'gos',
            'activities': ['Correr', 'Jugar a la pilota']
        }
    }, clear=True)
    def test_mainRun_list_pets(self, mock_print, mock_input):
        mainRun()
        mock_print.assert_any_call("Gestió de mascotes:\n1) Llista\n2) Afegir\n3) Modificar\n4) Esborrar\n5) Buscar\n0) Sortir")
        mock_print.assert_any_call("Llista de mascotes:")
        mock_print.assert_any_call("123ABC-5: {'name': 'Charlie', 'age': 5, 'type': 'gos', 'activities': ['Correr', 'Jugar a la pilota']}")
    
    @patch('builtins.input', side_effect=['5', 'name', 'Charlie', '0'])  # Simula cercar per nom i sortir
    @patch('builtins.print')
    @patch('examen02.searchPets')
    def test_mainRun_search_pet(self, mock_searchPets, mock_print, mock_input):
        mainRun()
        mock_searchPets.assert_called_once_with('name', 'Charlie')
    
    @patch('builtins.input', side_effect=['3', '123ABC-5', 'name', 'Rocky', '0'])  # Simula modificar una mascota i sortir
    @patch('builtins.print')
    @patch('examen02.modifyPets')
    def test_mainRun_modify_pet(self, mock_modifyPets, mock_print, mock_input):
        mainRun()
        mock_modifyPets.assert_called_once_with('123ABC-5', 'name', 'Rocky')
    
    @patch('builtins.input', side_effect=['4', '123ABC-5', '0'])  # Simula esborrar una mascota i sortir
    @patch('builtins.print')
    @patch('examen02.deletePets')
    def test_mainRun_delete_pet(self, mock_deletePets, mock_print, mock_input):
        mainRun()
        mock_deletePets.assert_called_once_with(['123ABC-5'])


if __name__ == '__main__':
    unittest.main()
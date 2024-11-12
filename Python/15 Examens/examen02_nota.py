#!/usr/bin/env python3

import unittest
import examen02_test

class CustomTestResult(unittest.TextTestResult):
    def __init__(self, *args, **kwargs):
        super(CustomTestResult, self).__init__(*args, **kwargs)
        self.passed_tests_per_class = {}
        self.total_tests_per_class = {}

    def startTest(self, test):
        super(CustomTestResult, self).startTest(test)
        test_class = test.__class__.__name__
        self.total_tests_per_class[test_class] = self.total_tests_per_class.get(test_class, 0) + 1

    def addSuccess(self, test):
        super(CustomTestResult, self).addSuccess(test)
        test_class = test.__class__.__name__
        self.passed_tests_per_class[test_class] = self.passed_tests_per_class.get(test_class, 0) + 1

if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromModule(examen02_test)
    runner = unittest.TextTestRunner(resultclass=CustomTestResult)
    result = runner.run(suite)

    # Després d'executar els tests, pots calcular la nota
    print("\n=== Resultats dels Tests ===")
    total_passed = 0
    total_tests = 0
    for test_class in result.total_tests_per_class:
        passed = result.passed_tests_per_class.get(test_class, 0)
        total = result.total_tests_per_class[test_class]
        total_passed += passed
        total_tests += total
        print(f"{test_class}: {passed}/{total} tests passats")

    puntuacio_final = (total_passed / total_tests) * 10 if total_tests > 0 else 0
    print(f"\nPuntuació Final: {puntuacio_final:.2f}/10")

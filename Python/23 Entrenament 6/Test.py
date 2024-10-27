import subprocess
import os

def run_test(test_file):
    result = subprocess.run(['python', test_file], capture_output=True, text=True)
    print(f"Running {test_file}:\n")
    print(result.stdout)  # Sortida estàndard (incloent resultats de test)
    print(result.stderr)  # Errors, si n'hi ha
    print('-' * 60)

# Directori on buscar els arxius de test
directori_tests = './'  # Canvia-ho a la ubicació dels teus tests

# Busca automàticament els arxius "Test X.py" dins del directori
for root, dirs, files in os.walk(directori_tests):
    for file in files:
        if file.startswith('Test_') and file.endswith('.py'):
            test_file = os.path.join(root, file)
            run_test(test_file)

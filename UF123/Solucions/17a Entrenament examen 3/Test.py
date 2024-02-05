import subprocess

def run_test(test_file):
    result = subprocess.run(['python', test_file], capture_output=True, text=True)
    print(f"Running {test_file}:\n")
    print(result.stdout)  # Sortida estàndard (incloent resultats de test)
    print(result.stderr)  # Errors, si n'hi ha
    print('-' * 60)
test_files = ['Test e0.py',
              'Test e1.py',
              'Test e2.py',
              'Test e3.py',
              'Test e4.py',
              'Test e5.py',
              'Test e6.py',
              'Test e7.py',
              'Test e8.py']

for file in test_files:
    run_test(file)

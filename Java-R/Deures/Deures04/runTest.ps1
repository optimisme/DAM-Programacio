# run.ps1

# Exemple de funcionament: .\runTest.ps1 com.project.TestMain
# on 'TestMain' és el test que volem executar

# Si hi ha múltiples tests i només en volem executar un:
# Exemple d'executar només un test: .\runTest.ps1 com.project.TestMain#testMainOutput
# on 'TestMain#testMainOutput' és el test i la funció de test que volem executar

# Set console output to UTF-8
[Console]::OutputEncoding = [System.Text.Encoding]::UTF8

# Change to the directory where the script is located
Set-Location $PSScriptRoot

# Set MAVEN_OPTS environment variable
$env:MAVEN_OPTS="--add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED -Dfile.encoding=UTF8"

# Check for the first argument and set it as the main class
$mainClass = $args[0]

# mvn -q clean test-compile exec:java -PrunMain $execArg
mvn clean
mvn test -Dtest="$mainClass"
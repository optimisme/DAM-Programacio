# run.ps1

# Exemple de funcionament: .\run.ps1 com.project.Main
# on 'Main' és la classe amb 'main' que volem executar

# Set console output to UTF-8
[Console]::OutputEncoding = [System.Text.Encoding]::UTF8

# Change to the directory where the script is located
Set-Location $PSScriptRoot

# Set MAVEN_OPTS environment variable
$env:MAVEN_OPTS="--add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED -Dfile.encoding=UTF8"

# Check for the first argument and set it as the main class
$mainClass = $args[0]

Write-Host "Setting MAVEN_OPTS to: $env:MAVEN_OPTS"
Write-Host "Main Class: $mainClass"

# Execute mvn command with the profile and main class as arguments
$execArg = "-Dexec.mainClass=" + $mainClass
Write-Host "Exec args: $execArg"

mvn -q clean test-compile exec:java -PrunMain $execArg

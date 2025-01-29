#!/bin/bash

# Exemple de funcionament: ./runTest.sh com.project.TestMain
# on 'TestMain' és el test que volem executar

# Si hi ha múltiples tests i només en volem executar un:
# Exemple d'executar només un test: ./runTest.sh com.project.TestMain#testMainOutput
# on 'TestMain#testMainOutput' és el test i la funció de test que volem executar

# run.sh

# Set MAVEN_OPTS environment variable
export MAVEN_OPTS="--add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED -Dfile.encoding=UTF8"

# Resta de l'script

# Check for the first argument and set it as the main class
mainClass=$1

# Execute mvn command
# mvn -q clean test-compile exec:java $execArg 
mvn clean
mvn test -Dtest=$mainClass
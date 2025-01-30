#!/bin/bash

get_latest_version() {
    local module_name=$1
    find ~/.m2/repository/org/openjfx -name "${module_name}-*.jar" | grep -vE "javadoc|sources" | sort -Vr | head -n1
}

case "$OSTYPE" in
  darwin*)  javafx_platform="mac" ;; 
  linux*)   javafx_platform="linux" ;;
  *)        javafx_platform="linux" ;;
esac

FX_BASE_PATH=$(get_latest_version "javafx-base")
FX_CONTROLS_PATH=$(get_latest_version "javafx-controls")
FX_FXML_PATH=$(get_latest_version "javafx-fxml")
FX_GRAPHICS_PATH=$(get_latest_version "javafx-graphics")

FX_PATH="${FX_BASE_PATH}:${FX_CONTROLS_PATH}:${FX_FXML_PATH}:${FX_GRAPHICS_PATH}"

if [[ -z "$FX_PATH" ]]; then
    echo "No es pot trobar el mòdul JavaFX al repositori Maven local."
    exit 1
fi

# Opcions comunes per a MAVEN_OPTS
export MAVEN_OPTS="--add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED -Dfile.encoding=UTF8 --module-path $FX_PATH --add-modules javafx.controls,javafx.fxml,javafx.graphics"

# Opcions específiques per a Darwin
if [[ "$OSTYPE" == "darwin"* ]]; then
    export MAVEN_OPTS="$MAVEN_OPTS -Xdock:icon=./target/classes/icons/iconOSX.png"
fi

# Check for the first argument and set it as the main class
mainClass=$1
action=$2 
verbose=0

# Check for "verbose" paramater -X
for arg in "$@"; do
    if [[ "$arg" == "-X" ]]; then
        verbose=1
    fi
done
if [[ "$verbose" -eq 1 ]]; then
    mavenLogLevel="-X" # Detailed mode
else
    mavenLogLevel="-q" # Silent mode
fi

# echo "Setting MAVEN_OPTS to: $MAVEN_OPTS"
# echo "Main Class: $mainClass"

if [[ "$action" == "build" ]]; then
    echo "Generating JAR file with all dependencies..."
    mvn clean package -Dmaven.test.skip=true
    echo "JAR generated in target directory."
    if [ -f target/server-package.jar ]; then
        echo "Successfully generated JAR: target/server-package.jar"
    else
        echo "Failed to generate JAR."
        exit 1
    fi
else
    # Execute mvn command with the profile and main class as arguments
    execArg="-PrunMain -Dexec.mainClass=$mainClass -Djavafx.platform=$javafx_platform $mavenLogLevel"
    # echo "Exec args: $execArg"

    # Execute mvn command
    mvn clean test-compile exec:java $execArg
fi

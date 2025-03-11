# run.ps1
function Get-LatestVersion {
    param (
        [string]$moduleName
    )

    # Find the JAR files and sort them by version while excluding javadoc and sources
    $jarFiles = Get-ChildItem -Path "$env:USERPROFILE\.m2\repository\org\openjfx" -Recurse -File |
                Where-Object { $_.Name -like "${moduleName}-*.jar" -and $_.Name -notmatch "(javadoc|sources)" } |
                Sort-Object Name -Descending

    # Return the latest version's path
    if ($jarFiles.Count -gt 0) {
        return $jarFiles[0].FullName
    } else {
        return $null
    }
}

# Set console output to UTF-8
[Console]::OutputEncoding = [System.Text.Encoding]::UTF8

$fxBasePath = Get-LatestVersion "javafx-base"
$fxControlsPath = Get-LatestVersion "javafx-controls"
$fxFxmlPath = Get-LatestVersion "javafx-fxml"
$fxGraphicsPath = Get-LatestVersion "javafx-graphics"

$fxPath = "$fxBasePath;$fxControlsPath;$fxFxmlPath;$fxGraphicsPath"

if (-not $fxPath) {
    Write-Host "No es pot trobar el mòdul JavaFX al repositori Maven local."
    exit 1
}

# Opcions comunes per a MAVEN_OPTS
$env:MAVEN_OPTS = "--add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED -Dfile.encoding=UTF8 --module-path $fxPath --add-modules javafx.controls,javafx.fxml,javafx.graphics"

# Resta de l'script

# Check for the first argument and set it as the main class
# Obtén los argumentos
$mainClass = $args[0]
$action = $args[1]
$verbose = $false

# Check for "verbose" paramater -X
if ($args -contains "-X") {
    $verbose = $true
}
if ($verbose) {
    $mavenLogLevel = "-X" # Detailed mode
} else {
    $mavenLogLevel = "-q" # Silent mode
}

# Define la plataforma JavaFX
$javafx_platform = "win"

# Configura MAVEN_OPTS
$MAVEN_OPTS = "--add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED --module-path $FX_PATH --add-modules javafx.controls,javafx.fxml,javafx.graphics"
# Opcions específiques per a Windows
$MAVEN_OPTS += " -Xdock:icon=./target/classes/icons/iconOSX.png" # Si necessites aquesta opció, la pots mantenir

# Write-Output "Setting MAVEN_OPTS to: $MAVEN_OPTS"
# Write-Output "Main Class: $mainClass"

if ($action -eq "build") {
    Write-Output "Generating JAR file with all dependencies..."
    mvn clean package -DskipTests=true
    Write-Output "JAR generation completed."
    
    # Comprova si el JAR ha estat creat correctament
    $jarPath = "target\server-package.jar"  # Substitueix per el nom que has definit
    if (Test-Path $jarPath) {
        Write-Output "Successfully generated JAR: $jarPath"
    } else {
        Write-Output "Failed to generate JAR."
        exit 1
    }
    
    exit 0
} else {
    # Executa la comanda mvn amb els arguments
    $execArgs = @("-PrunMain", "-Dexec.mainClass=$mainClass", "-Djavafx.platform=$javafx_platform", "$mavenLogLevel")
    # Write-Output "Exec args: $($execArgs -join ' ')"

    # Executa la comanda mvn
    mvn clean test-compile exec:java $execArgs
}


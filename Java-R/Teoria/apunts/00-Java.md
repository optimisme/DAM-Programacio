<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

# Introducció a JAVA

<center>
<img src="./assets/logoJAVA.png" height="128" alt="Logo de IETI" style="max-height: 128px;"/>
</center>

Java és una plataforma informàtica que inclou:

- Un llenguatge de programació,
- Un conjunt de llibreries i la definició d’una màquina virtual.

## Aquitectura

<center>
<img src="./assets/00arquitectura.png" height="200" alt="Logo de IETI" style="max-height: 200px;"/>
</center>

Als anys 90, Java va representar una revolució perquè el mateix llenguatge de programació permet programar aplicacions per diferents sistemes operatius.

La clau, estava en que el codi binari generat no és codi màquina pròpiament dit, sinó codi que s’executa en una Java Virtual Machine (JVM)

## Java Virtual Machine

<center>
<img src="./assets/00jvm.png" height="200" alt="Logo de IETI" style="max-height: 200px;">
</center>

La Java Virtual Machine, s’encarrega de fer que els programes executables (binaris) de Java funcionin a la màquina que l’ha d’executar.

La Java Virtual Machine al final és un programa que ha d’estar instal·lat al sistema on es volen executar aplicacions Java, i per tant, cal que Oracle desenvolupi JVM per molts sistemes diferents.

## Compilació tradicional (codi C)

<center>
<img src="./assets/00compilacioC.png" height="128" alt="Logo de IETI" style="max-height: 128px;">
</center>

Els llenguatges tradicionals, transformen el codi en llenguatge màquina. 

D’aquest pas se’n diu **"compilar"**, i es fa amb un **"compilador"**

El compilador genera arxius binaris (0s i 1ns). 

Els sistemes operatius poden executar aquests programes binaris, però **cada sistema operatiu requereix el seu propi format**

## Compilació amb JAVA (class)

<center>
<img src="./assets/00compilacioJ.png" height="128" alt="Logo de IETI" style="max-height: 128px;">
</center>

El compilador de java transforma el codi en un arxiu binari **".class"**

Però aquest arxiu no està pensat per executar-se en una màquina directament, sinó en una Java Virtual Machine (JVM)

Així el mateix codi binari funciona en diferents tipus de màquines, sempre que el sistema operatiu tingui una **JVM** instal·lada (especial per aquell sistema).

## JAVA i JAVA Development Kit

Hi ha dues versions de Java

<a href="https://www.java.com/en/" target="_blank">Java</a> només inclou la Java Virtual Machine per executar programes Java

<a href="https://www.oracle.com/java/technologies/downloads/" target="_blank">JDK</a>, Java Development Kit a part d’instal·lar la màquina virtual, inclou les eines de desenvolupament (entre elles el compilador)

Cal instal·lar **Java Development Kit (JDK)**, hi ha disponibles les eines de comandes de Java:

- A **Ubuntu Linux**: escolliu el paquet 'x64 Debian'

- A **Windows**: escolliu el paquet 'x64 MSI Installer'

- A **macOS**: escolliu el paquet 'ARM64 DMG Installer'

## Gestió de projectes i llibreries

<center>
<img src="./assets/logoMaven.png" height="64" alt="Maven" style="max-height: 48px;"/>
</center>

Maven és una eina que automatitza la compilació de projectes JAVA, i també facilita la gestió de llibreries dels projectes.

Per instal·lar Maven:

```bash
sudo apt install maven # Linux
brew install maven # macOS
```

A windows cal (adaptant el número de versió):
- [Descarregar el 'Binary zip archive' de Maven](https://maven.apache.org/download.cgi)
- Descomprimir l'arxiu tipus 'apache-maven-3.9.6-bin.zip' posar-lo a la carpeta "C:\Program Files\Maven\"
- Ha de quedar semblant a: "C:\Program Files\Maven\apache-maven-3.9.6\"
- Obrir el programa "Edit the system environment variables"
- Apretar el botó "Environment Variables"
- A les "System variables" afegir la variable: MAVEN_HOME amb el valor "C:\Program Files\Maven\apache-maven-3.9.6"
- A les "System variables" editar la variable "Path" per afegir-hi "C:\Program Files\Maven\apache-maven-3.9.6\bin"
- Reiniciar Windows
- Reafirmar els teus pensaments que Windows és més fàcil i millor

Caldrà que tingueu Maven al vostre sistema per fer anar els exemples i projectes de l'assignatura.

### Fer anar Maven

Maven instal·la la comanda 'mvn' amb la que podeu compilar els projectes.

Els projectes de l'assignatura tenen dos scripts:

```bash
# A Linux i macOS
run.sh com.exemple000.Main 

# A Windows
run.ps1 com.exemple000.Main 
```

Per **'netejar'** i **'compilar'** el projecte abans de compilar-lo:

```bash
mvn clean
mvn compile
```

**Important**: A Windows cal tenir la PowerShell en mode UTF-8, per configurar-la:

```bash
[Console]::OutputEncoding = [System.Text.Encoding]::UTF8
```

## Projectes JAVA/Maven

En JAVA tots els programes tenen un punt d'entrada que està a:

- Dins d'una classe principal, en aquest cas 'Main' (això ho veurem quan fem orientació a objectes)

- Dins de la funció 'main'

'main' és la funció que s'executa per defecte en una classe. 

En aquest cas, el nom de la classe podría ser diferent a 'Main' però el nom del a funció no podría ser diferent.

### Exemple00

Aquest exemple, escriu 'Hello World' per la consola.

```java
// Paquet al que pertany aquest codi
package com.exemple000;

// Classe principal del programa
public class Main {
    // Funció principal del programa
    public static void main(String[] args) {
        /* Escriure un missatge 
           al terminal */
        System.out.println("Hola món!");
    }
}
```

Per netejar el codi i compilar:
```bash
mvn clean
mvn compile
```

Per fer anar aquest exemple, cal anar amb el terminal i escriure:

```bash
# A la carpeta on hi ha './run.sh'
./run.sh com.exemple000.Main
```

Per veure la sortida detallada:
```bash
# A la carpeta on hi ha './run.sh'
./run.sh com.exemple000.Main -X
```

**Nota:** Els usuaris de Windows crideu a '.\run.ps1' enlloc de './run.sh'

## El projecte

Si observem el projecte, veurem que té diferents carpetes i arxius.

```text
.
├── apunts
│   (arxius d'apunts)
├── data
│   (arxius amb d'ades d'exercicis i exmples)
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       (codi de llibreries/paquets que programem)
│       └── resources
│           (arxius/recursos del projecte)
├── target
│   (arxius de compilació/sortida)
├── pom.xml (configuració de llibreries necessàries)
├── run.ps1
└── run.sh
```
Nosaltres treballarem principalment a la carpeta **'src/main'** que conté el codi i recursos del projecte.

Els projectes JAVA s'organitzen en paquets o llibreries, els paquets estàn dins de la carpeta **'com.'** i cada paquet representa un projecte (exemple000, exercici001 ...)

L'arxiu **'pom.xml'** conté la configuració necessaria per fer anar el nostre projecte, quan necessitem llibreries externes les haurem de definir aquest arxiu 'pom.xml' perquè Maven s'encarregui de descarregar-les i cridar-les quan fem anar el nostre programa.

Fixeu-vos que els arxius de codi JAVA tenen l'extensió **.java**

### Paquet i nom del projecte

A l'exemple hi ha diversos **'paquets'** un d'ells es diu **'exemple000'**

Tot el codi d'aquell paquet han d'estar a la carpeta del projecte/paquet, en aquest cas:

```bash
./src/main/java/com/exemple000/Main.java
```

Igualment, tots els arxius que formen part del paquet, han de d'indicar-ho a la primera línia de codi amb:

```java
package com.exemple000;
```

### Noms d'arxiu .java

En JAVA els noms d'arxiu han de coincidir amb el nom de la classe/objecte que en declara el codi.

El nostre exemple és molt senzill i només té un objecte anomenat 'Main', per aquest motiu el codi està dins l'arxiu 'Main.java'

### Comentaris

A Java hi ha dos maneres de posar comentaris al codi:

- **`//`**, per comentaris a la pròpia linia, després de les dues barres
- **`/*`comentari`*/`**, per comentaris que ocupen múltiples línies

```java
// Paquet al que pertany aquest codi
package com.exemple000;

// Classe principal del programa
public class Main {
    // Funció principal del programa
    public static void main(String[] args) {
        /* Escriure un missatge 
           al terminal */
        System.out.println("Hola món!");
    }
}
```

### Exercici 000

Modifica el codi de:

```bash
src/main/exercici000/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici000.Main
```

Escrigui a la sortida del terminal:

```text
Hola Java
```

## Comandes JDK

Al instal·lar Java Development Kit, hi ha disponibles les eines de comandes de Java:

```bash
java -version # Retorna la versió que s’està executant de java
javac MeuPrograma.java # Compila el codi ‘MeuPrograma.java’
java MeuPrograma # Executa el codi anterior de ‘MeuPrograma.class’
java MeuPrograma arg1 arg2 # Es poden passar arguments
```

Cal tenir en compte, que tan al compilar com a fer anar l'aplicació, si l’aplicació depèn de llibreries, cal incloure-les a les comandes:


```bash
javac -cp lib/lib1.jar:lib/lib2.jar MeuPrograma.java # Compila el codi
java -cp .:lib/lib1.jar:lib/lib2.jar MeuPrograma # Executa el programa
```

**Important:** La notació de les comandes anteriors pot dependre del sistema operatiu en què s’executa, no és igual per Windows que per Linux i OSX

## Arxius .jar

Normalment els programes Java estàn formats per múltiples arxius (.java i .class), Java permet agrupar-los tots en un sol arxiu amb un format que s’anomena paquets .jar

Per crear arxius .jar hi ha la comanda ‘jar’

La complicació és que els arxius ‘.jar’ han de tenir un arxiu de text anomenat ‘manifest.txt’, per això al empaquetar un programa cal crear també aquest arxiu:

```bash
javac *.java # Primer cal compilar el codi
echo “Main-Class: ElMeuPrograma” > manifest.txt # Crear l’arxiu de manifest
jar cfm ElMeuPrograma.jar manifest.txt *.class # Crear el paquet .jar
java -jar ElMeuPrograma.jar # Executar el programa
java -jc ElMeuPrograma.jar:lib/lib1.jar # Executar el programa amb lib1.jar
```

Els arxius .jar no han d’incloure les llibreries, aquestes s’han d’informar al moment de compilar i executar el programa:

```bash
javac -cp lib/lib1.jar:lib/lib2.jar *.java # Compila el codi
echo “Main-Class: ElMeuPrograma” > manifest.txt # Crear l’arxiu de manifest
jar cfm ElMeuPrograma.jar manifest.txt -C src . -C lib . # Crear el .jar
java -jc ElMeuPrograma.jar:lib/lib1.jar # Executar el programa
```
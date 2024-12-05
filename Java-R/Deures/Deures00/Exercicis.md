# Exercici 0000

Fes un programa que demani dos números (fent servir inputs) i calculi la resta entre ells.

Com a sortida ha de mostrar: "El resultat de calcular X - Y és Z", on:

X és el primer valor escrit
Y és el segon valor escrit
Z és el resultat de restar-los

Exemple de sortida:

```text
Escriu el primer número: -10
Escriu el segon número: 2
El resultat de calcular -10 - 2 és -12
```

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercicis/Exercici0000.java

# A la carpeta "Deures00" executar el programa
./run.sh com.exercicis.Exercici0000

# A la carpeta "Deures00" executar el test
./runTest.sh com.exercicis.TestExercici0000
```

# Exercici 0001

Fes un programa que a partir de demanar el pes i l'altura, calculi l'índex de massa corporal IMC

Aquest càlcul es fa així: imc = pes / (altura ^ 2)

Exemple de sortida:

```text
Escriu el pes (kg): 80
Escriu l'alçada (cm): 180
imc = 24,69
```

L'entrada ha d'acceptar números decimals amb `.`i també `,`. Però ha d'operar amb format 'localeUS' dels EUA. Per fer-ho, inicia el **"locale"** després de l'scanner:

```java
Scanner scanner = new Scanner(System.in);
Locale localeUS = Locale.US;
```

Indica el **"locale"** que ha de fer servir al escriure per consola:

```java
System.out.printf(localeUS, "imc = %.2f%n", imc);
```

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercicis/Exercici0001.java

# A la carpeta "Deures00" executar el programa
./run.sh com.exercicis.Exercici0001

# A la carpeta "Deures00" executar el test
./runTest.sh com.exercicis.TestExercici0001
```

# Exercici 0002

Fes un programa que converteixi un valor en Euros cap a Dollars, per fer-ho ha de demanar:

El valor en Euros que es vol convertir
La tasa de conversió que ha d'aplicar
Ha de mostrar la quantitat resultant com a: "El valor de X€ són Y$"

La operació és senzilla, simplement és multiplicar els euros pel valor de la tasa de conversió

Exemple de sortida:

```text
Escriu el valor en Euros: 70.2
Escriu la tasa de conversió (ex: 1.25): 1.42
El valor de 70.20€ són 99.68$
```

L'entrada ha d'acceptar números decimals amb `.`i també `,`. Però ha d'operar amb format 'localeUS' dels EUA. Per fer-ho, inicia el **"locale"** després de l'scanner:

```java
Scanner scanner = new Scanner(System.in);
Locale localeUS = Locale.US;
```

Indica el **"locale"** que ha de fer servir al escriure per consola:

```java
System.out.printf(localeUS, "El valor de %.2f€ són %.2f$%n", euros, dollars);
```

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercicis/Exercici0002.java

# A la carpeta "Deures00" executar el programa
./run.sh com.exercicis.Exercici0002

# A la carpeta "Deures00" executar el test
./runTest.sh com.exercicis.TestExercici0002
```

# Exercici 0003

Fes un programa que calculi el preu final d'un producte, a partir de:

- El preu base
- El percentatge de l'IVA
- El percentatge del descompte aplicat

Ha de fer el càlcul a la funció:

```java
public static double calcularPreuFinal(double preuBase, double iva, double descompte)
````

I el càlcul es fa així:

```text
double preuAmbIva = preuBase + (preuBase * iva / 100);
double preuFinal = preuAmbIva - (preuAmbIva * descompte / 100);
```

Exemple de sortida:

```text
Introdueix el preu base: 20
Introdueix l'IVA (%): 21
Introdueix el descompte (%): 5
El preu final és: 22.99
```

L'entrada ha d'acceptar números decimals amb `.`i també `,`. Però ha d'operar amb format 'localeUS' dels EUA. Per fer-ho, inicia el **"locale"** després de l'scanner:

```java
Scanner scanner = new Scanner(System.in);
Locale localeUS = Locale.US;
```

Indica el **"locale"** que ha de fer servir al escriure per consola:

```java
System.out.printf(localeUS, "El preu final és: %.2f\n", preuFinal);
```

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercicis/Exercici0003.java

# A la carpeta "Deures00" executar el programa
./run.sh com.exercicis.Exercici0003

# A la carpeta "Deures00" executar el test
./runTest.sh com.exercicis.TestExercici0003

# Testejar només "#testCalcularPreuFinal"
./runTest.sh "com.exercicis.TestExercici0003#testCalcularPreuFinal"
```

# Exercici 0004

Fes un programa que demana a l'usuari que escrigui una contrasenya.

Crea la funció 'validaContrasenya' que apartir d'un text de contrasenya dirà que és vàlida si:

- La contrasenya té almenys 8 caràcters

- La contrasenya té almenys 2 lletres majúscules i 2 lletres minúscules

La resposta de la funció serà el text:

- "La contrasenya és vàlida" si és vàlida

- "La contrasenya NO és vàlida" si no és vàlida

Et calen les funcions:

```java
// Retorna el número de majúscules
public static int contaMajuscules(String contrasenya)
// Retorna el número de minúscules
public static int contaMinuscules(String contrasenya)
// Retorna, segons cal:
// "La contrasenya és vàlida"
// "La contrasenya NO és vàlida"
public static String validaContrasenya(String contrasenya)
```

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercicis/Exercici0004.java

# A la carpeta "Deures00" executar el programa
./run.sh com.exercicis.Exercici0004

# A la carpeta "Deures00" executar el test
./runTest.sh com.exercicis.TestExercici0004

# Testos individuals
./runTest.sh "com.exercicis.TestExercici0004#testContaMajuscules"
./runTest.sh "com.exercicis.TestExercici0004#testContaMinuscules"
./runTest.sh "com.exercicis.TestExercici0004#testValidaContrasenya"
./runTest.sh "com.exercicis.TestExercici0004#testMainFunctionValidPwd"
./runTest.sh "com.exercicis.TestExercici0004#testMainFunctionInvalidPwd"
./runTest.sh "com.exercicis.TestExercici0004#testMainFunctionEdgeCase"
```

Exemples:
```text
Escriu una contrasenya: PassWord123
La contrasenya 'PassWord123': La contrasenya és vàlida
Escriu una contrasenya: password
La contrasenya 'password': La contrasenya NO és vàlida
Escriu una contrasenya: PassWord123
La contrasenya 'PassWord123': La contrasenya és vàlida
Escriu una contrasenya: Pass12
La contrasenya 'Pass12': La contrasenya NO és vàlida
Escriu una contrasenya: ValidPass123
La contrasenya 'ValidPass123': La contrasenya és vàlida
```

# Exercici 0005

Fes un programa que validi si una cadena de text és un plaíndrom. Un palíndrom és un text que es llegeix igual del dret que del revés, sense tenir en compte els caràcters especials (ni accents).

El programa ha de cridar la funció **"isPalindrom"** amb els textos de validació, i des del **main** mostrar el text amb *(Si)* o *(No)* segons el resultat.

Necessitaràs:

```java
// Retorna 'true' si és palíndrom
public static boolean isPalindrom(String text)

// Retorna el mateix text sense espais ni caràcters especials
public static String normalize(String text)
```

Comprova-ho amb els següents exemples:

```text
Anul·la la lluna (Si)
Atrapa la lluna (No)
Atrapa'l o l'aparta (Si)
Aparta'l o atrapa'l (No)
No sap pas on (Si)
On sap pas qui (No)
Tramaran anar a Mart (Si)
A Mart trobaràn art (No)
Un pop nu (Si)
Nu pop un (Si)
```

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercicis/Exercici0005.java

# A la carpeta "Deures00" executar el programa
./run.sh com.exercicis.Exercici0005

# A la carpeta "Deures00" executar el test
./runTest.sh com.exercicis.TestExercici0005

# Testos individuals
./runTest.sh "com.exercicis.TestExercici0005#testIsPalindrom"
./runTest.sh "com.exercicis.TestExercici0005#testNormalize"
./runTest.sh "com.exercicis.TestExercici0005#testMainOutput"
```

# Exercici 0006

Fes un programa que resolgui aquest problema:

Un cinema ofereix diferents tarifes segons l'edat del client i el dia de la setmana. 

Escriu una funció **"calculaEntrada"** que determini el preu de l'entrada d'una persona segons la seva edat i el dia que vol anar al cinema.

Els preus són:
```text
Preu estàndard: 10€
Nens (menors de 12 anys): 5€
Gent gran (65 anys o més): 6€
Dimarts (Dia del client): Totes les entrades tenen un descompte del 20%.
Dijous (Dia familiar): Si un adult compra una entrada, l'entrada del primer nen té un 50% de descompte els altres nens no paguen.
```

No feu inputs, valideu al main les diferents possibilitats.

Necessitaràs:

```java
public static double calculaEntrada(int numeroAdults, int numNens, int numGrans, String dia)
```

Fes que la sortida del programa sigui d'aquest estil:

- Que no s'escrigui el resultat fins almenys 25 caràcters. 
- Fes servir Locale.US

```text
Cas 1 (2 adults, 2 nens, 1 gran):   28.80€
Cas 2 (1 adult,  2 nens, 0 grans):  12.50€
Cas 3 (0 adults, 0 nens, 2 grans):  12.00€
Cas 4 (1 adult,  0 nens, 0 grans):  10.00€
Cas 5 (1 adult,  3 nens, 4 grans):  36.50€
Cas 6 (2 adults, 2 nens, 1 gran):   36.00€
```

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercicis/Exercici0006.java

# A la carpeta "Deures00" executar el programa
./run.sh com.exercicis.Exercici0006

# A la carpeta "Deures00" executar el test
./runTest.sh com.exercicis.TestExercici0006

# Testos individuals
./runTest.sh "com.exercicis.TestExercici0006#testCalculaEntrada"
```

# Exercici 0007

Estàs organitzant festes d'aniversari i oferixes diferents paquets segons les necessitats del client. 

Necessites una funció **"calculaFesta"** que determina el cost total d'una festa segons el nombre de convidats, el lloc on es realitzarà la festa, si es vol menjar inclòs i si volen entreteniment en directe.

Les tarifes són:

```text
Lloc:
  Sala estàndard: 100€.
  Jardí amb piscina: 200€.
  Saló gran amb escenari: 500€.

Menjar per convidat:
  Menú bàsic: 15€.
  Menú premium: 30€.

Entreteniment:
  Màgia: 250€.
  Música en directe: 500€.
```

A més, ofereixes les següents promocions:
```text
Si contracten música en directe per la sala gran amb escenari, tenen un descompte de 100€ en l'entreteniment.
Si més de 50 persones assisteixen a la festa, ofereixes un 5% de descompte en el menjar.
```

Només es pot contractar una sala, però es pot contractar diversos entreteniments.

Necessitaràs:

```java
public static double calculaCostLloc(String tipusLloc)
public static double calculaCostMenjar(String tipusMenjar, int numConvidats)
public static double calculaCostEntreteniment(String tipusEntreteniment)
public static double calculaFesta(String tipusLloc, String tipusMenjar, String tipusEntreteniment, int numConvidats)
```

Per exemple:
```text
* Sala estàndard, 20 convidats amb menú bàsic, sense entreteniment: 100€ + (15€ * 20) = 400€.
* Jardí amb piscina, 60 convidats amb menú premium, màgia com a entreteniment: 200€ + [(30€ * 60) - 5%] + 250€ = 2.150€.
* Si et cal, crea funcions auxiliars per a calcula_festa. Sigues organitzat/da!
```

Exemples per comprovar:
```text
* Jardí amb piscina, 40 convidats, menú bàsic, música en directe: 1.300€
* Saló gran amb escenari, 70 convidats, menú premium, música en directe (amb descompte): 2.895€
* Sala estàndard, 15 convidats, menú premium, màgia: 800€
```

Fes que la sortida del programa sigui d'aquest estil:

- Que no s'escrigui el resultat fins almenys 75 caràcters. 
- Fes servir Locale.US

```text
Cas 1 ("sala estàndard", "menú bàsic", "cap", 20):                         400.00€
Cas 2 ("jardí amb piscina", "menú premium", "màgia", 60):                  2160.00€
Cas 3 ("jardí amb piscina", "menú bàsic", "música en directe", 40):        1300.00€
Cas 4 ("saló gran amb escenari", "menú premium", "música en directe", 70): 2895.00€
Cas 5 ("sala estàndard", "menú premium", "màgia", 15):                     800.00€
```

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercicis/Exercici0007.java

# A la carpeta "Deures00" executar el programa
./run.sh com.exercicis.Exercici0007

# A la carpeta "Deures00" executar el test
./runTest.sh com.exercicis.TestExercici0007

# Testos individuals
./runTest.sh "com.exercicis.TestExercici0007#testCalculaCostLloc"
./runTest.sh "com.exercicis.TestExercici0007#testCalculaCostMenjar"
./runTest.sh "com.exercicis.TestExercici0007#testCalculaCostEntreteniment"
./runTest.sh "com.exercicis.TestExercici0007#testCalculaFesta"
```

# Exercici 0008

Fes un generador de nombres imparells entre 2 i un numero donat per l'usuari.

Necessitaràs:

```java
public static ArrayList<Integer> generaImparells(int numero)
```

Exemple de sortida

```text
Introdueix un número: 9
Nombres imparells entre 2 i 9: [3, 5, 7, 9]
Introdueix un número: 18
Nombres imparells entre 2 i 18: [3, 5, 7, 9, 11, 13, 15, 17]
```

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercicis/Exercici0008.java

# A la carpeta "Deures00" executar el programa
./run.sh com.exercicis.Exercici0008

# A la carpeta "Deures00" executar el test
./runTest.sh com.exercicis.TestExercici0008

# Testos individuals
./runTest.sh "com.exercicis.TestExercici0008#testGeneraImparells"
```

# Exercici 0009

Fes un programa que dibuixi un rectangle a partir d'asteriscos.

- L'usuari ha de definit un ample i un alt.
- La part interior del rectangle ha d'estar emplenada amb `o`

Necessitaràs:

```java
public static void dibuixarRectangle(int ample, int alt)
```

Exemples de sortida:

```text
Introdueix l'ample del rectangle: 3
Introdueix l'alt del rectangle: 2
Resultat:
***
***

Introdueix l'ample del rectangle: 10
Introdueix l'alt del rectangle: 4
Resultat:
**********
*oooooooo*
*oooooooo*
**********
```

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercicis/Exercici0009.java

# A la carpeta "Deures00" executar el programa
./run.sh com.exercicis.Exercici0009

# A la carpeta "Deures00" executar el test
./runTest.sh com.exercicis.TestExercici0009

# Testos individuals
./runTest.sh "com.exercicis.TestExercici0009#testDibuixarRectangle"
```

# Exercici 0010

Fes un programa que:

- Generi un ArrayList iniciat amb 10 enters aleatòris entre 0 i 99
- Generi un ArrayList amb els 10 números anteriors multiplicats per 2
- Generi un ArrayList amb els números imparells de la primera llista
- Generi un ArrayList amb la divisió per 2 dels números imparelles anteriors

Necessitaràs:

```java
// Genera un ArrayList amb "quantitat" numeros aleatòris entre "min" i "max"
public static ArrayList<Integer> generarNumerosAleatoris(int quantitat, int min, int max)

// Retorna un ArrayList amb cada valor de "llista" multiplicat per 2
public static ArrayList<Integer> multiplicarPerDos(ArrayList<Integer> llista)

// Retorna un ArrayList amb els valors imparells de "llista"
public static ArrayList<Integer> filtrarImparells(ArrayList<Integer> llista)

// Retorna un ArrayList amb cada valor de "llista" dividit per 2
public static ArrayList<Double> dividirPerDos(ArrayList<Integer> llista)
```

Exemple de sortida:

```text
Llista inicial: [49, 39, 11, 79, 33, 69, 42, 28, 30, 59]
Llista multiplicada per 2: [98, 78, 22, 158, 66, 138, 84, 56, 60, 118]
Llista només amb números imparells: [49, 39, 11, 79, 33, 69, 59]
Llista imparells dividits per 2: [24.5, 19.5, 5.5, 39.5, 16.5, 34.5, 29.5]
```

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercicis/Exercici0010.java

# A la carpeta "Deures00" executar el programa
./run.sh com.exercicis.Exercici0010

# A la carpeta "Deures00" executar el test
./runTest.sh com.exercicis.TestExercici0010

# Testos individuals
./runTest.sh "com.exercicis.TestExercici0010#testGenerarNumerosAleatoris"
./runTest.sh "com.exercicis.TestExercici0010#testMultiplicarPerDos"
./runTest.sh "com.exercicis.TestExercici0010#testFiltrarImparells"
./runTest.sh "com.exercicis.TestExercici0010#testDividirPerDos"
```

# Exercici 0011

Fes un programa que a partir de la següent llista de noms:

```java
ArrayList<String> noms = new ArrayList<>(Arrays.asList("Mario", "Princess Peach", "Wario", "Luigi", "Iggy Koopa", "Toad", "Yoshi", "Donkey Kong", "Birdo"));
```

- N'escull 5 a l'atzar i genera un nou ArrayList (no poden ser duplicats)
- Provoca una excepció demanant 25 noms (mostra la longitud de la llista)
- Genera un nou ArrayList amb els que acaben amb vocal
- Genera un nou ArrayList amb els que són compostos

Necessitaràs:

```java
// Escull "quantitat" noms a l'atzar
// Si "quantitat" és massa gran provoca una excepció:
// IllegalArgumentException("La quantitat no pot ser més gran que la mida de la llista.");
public static ArrayList<String> escullNomsAleatoris(ArrayList<String> noms, int quantitat)

// Retorna un ArrayList amb els noms que acaben amb vocal 'aeiou'
public static ArrayList<String> nomsAcabenVocal(ArrayList<String> noms)

// Retorna un ArrayList amb els noms compostos per més d'una paraula
public static ArrayList<String> nomsCompostos(ArrayList<String> noms)
```

Exemple de sortida:

```text
Noms escollits a l'atzar: [Birdo, Mario, Yoshi, Toad, Luigi]
Error: La quantitat no pot ser més gran que 9.
Noms que acaben amb vocal: [Mario, Wario, Luigi, Iggy Koopa, Yoshi, Birdo]
Noms compostos: [Princess Peach, Iggy Koopa, Donkey Kong]
```

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercicis/Exercici0011.java

# A la carpeta "Deures00" executar el programa
./run.sh com.exercicis.Exercici0011

# A la carpeta "Deures00" executar el test
./runTest.sh com.exercicis.TestExercici0011

# Testos individuals
./runTest.sh "com.exercicis.TestExercici0011#testEscullNomsAleatoris"
./runTest.sh "com.exercicis.TestExercici0011#testNomsAcabenVocal"
./runTest.sh "com.exercicis.TestExercici0011#testNomsCompostos"
```

# Exercici 0012

Fes un programa que a partir de la següent informació:

```java
ArrayList<HashMap<String, Object>> wonders = new ArrayList<>();
wonders.add(createWonder("Great Pyramid of Giza", "Egypt", 4500));
wonders.add(createWonder("Hanging Gardens of Babylon", "Babylon, Mesopotamia", 2500));
wonders.add(createWonder("Statue of Zeus at Olympia", "Olympia, Greece", 2500));
wonders.add(createWonder("Temple of Artemis at Ephesus", "Ephesus, Turkey", 2400));
wonders.add(createWonder("Mausoleum at Halicarnassus", "Halicarnassus, Turkey", 2300));
wonders.add(createWonder("Colossus of Rhodes", "Island of Rhodes, Greece", 2300));
wonders.add(createWonder("Lighthouse of Alexandria", "Alexandria, Egypt", 2200));
```

Necessitaràs:

```java
// Retorna un HashMap amb les claus "name", "location" i "age"
public static HashMap<String, Object> createWonder(String name, String location, int age)

// Mostra la informació del la llista segons el format de sortida
public static void showInformation(ArrayList<HashMap<String, Object>> wonders)

// Obté totes les meravelles ordenades per nom
public static ArrayList<HashMap<String, Object>> sortWondersByName(ArrayList<HashMap<String, Object>> wonders)

// Obté les "quantity" meravelles ordenades per nom (subllista)
// fa servir "sortWondersByName"
public static ArrayList<HashMap<String, Object>> getSortedWondersByName(ArrayList<HashMap<String, Object>> wonders, int quantity)

// Obté els noms de les marevelles ordenats alfabèticament
public static ArrayList<String> sortNames(ArrayList<HashMap<String, Object>> wonders)

// Obté les "quantity" meravelles ordenades per antiguitat (subllista)
public static ArrayList<HashMap<String, Object>> getOlder(ArrayList<HashMap<String, Object>> wonders, int quantity)

// Mostra les meravelles de la regió "region"
public static ArrayList<HashMap<String, Object>> getRegion(ArrayList<HashMap<String, Object>> wonders, String region)
```

Exemple de sortida:

```text
All Wonders:
* Name: Great Pyramid of Giza
  Location: Egypt
  Age: 4500 years
* Name: Hanging Gardens of Babylon
  Location: Babylon, Mesopotamia
  Age: 2500 years
* Name: Statue of Zeus at Olympia
  Location: Olympia, Greece
  Age: 2500 years
* Name: Temple of Artemis at Ephesus
  Location: Ephesus, Turkey
  Age: 2400 years
* Name: Mausoleum at Halicarnassus
  Location: Halicarnassus, Turkey
  Age: 2300 years
* Name: Colossus of Rhodes
  Location: Island of Rhodes, Greece
  Age: 2300 years
* Name: Lighthouse of Alexandria
  Location: Alexandria, Egypt
  Age: 2200 years
-------------------------
Sorted Names:
[Great Pyramid of Giza, Hanging Gardens of Babylon, Statue of Zeus at Olympia, Temple of Artemis at Ephesus, Mausoleum at Halicarnassus, Colossus of Rhodes, Lighthouse of Alexandria]
-------------------------
Top 3 Oldest Wonders:
* Name: Great Pyramid of Giza
  Location: Egypt
  Age: 4500 years
* Name: Hanging Gardens of Babylon
  Location: Babylon, Mesopotamia
  Age: 2500 years
* Name: Statue of Zeus at Olympia
  Location: Olympia, Greece
  Age: 2500 years
-------------------------
Wonders in Turkey:
* Name: Temple of Artemis at Ephesus
  Location: Ephesus, Turkey
  Age: 2400 years
* Name: Mausoleum at Halicarnassus
  Location: Halicarnassus, Turkey
  Age: 2300 years
```

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercicis/Exercici0012.java

# A la carpeta "Deures00" executar el programa
./run.sh com.exercicis.Exercici0012

# A la carpeta "Deures00" executar el test
./runTest.sh com.exercicis.TestExercici0012

# Testos individuals
./runTest.sh "com.exercicis.TestExercici0012#testCreateWonder"
./runTest.sh "com.exercicis.TestExercici0012#testSortWondersByName"
./runTest.sh "com.exercicis.TestExercici0012#testGetSortedWondersByName"
./runTest.sh "com.exercicis.TestExercici0012#testSortNames"
./runTest.sh "com.exercicis.TestExercici0012#testGetOlder"
./runTest.sh "com.exercicis.TestExercici0012#testGetRegion"
```

# Exercici 0013

Fes un programa que permeti afegir i treure informació de ciutats d'un **ArrayList** que conté **HashMaps** amb etiquetes: *population*, *heigth* o *sealand*

Necessites:
```java
// Diu si un "id" existeix al ArrayList "cities"
public static boolean idExists(ArrayList<HashMap<String, Object>> cities, int id)

// Crea un id entre 1000 i 9000, que no existeix a l'ArrayList "cities"
public static int generateId(ArrayList<HashMap<String, Object>> cities)

// Retorna l'id d'una ciutat a partir del seu nom
// (retorna -1 si no troba cap ciutat amb el nom "name")
public static int getIdByName(ArrayList<HashMap<String, Object>> cities, String name)

// Afegeix una ciutat a l'ArrayList "cities"
public static void addCity(ArrayList<HashMap<String, Object>> cities, 
    String name, int population, int height, boolean sealand)

// Esborra una ciutat de l'ArrayList "cities" a partir de "id"
public static void removeCity(ArrayList<HashMap<String, Object>> cities, int id)

// Actualitza el HashMap amb identificador "id" i clau "field" amb el nou valor "value"
public static void updateData(ArrayList<HashMap<String, Object>> cities, 
    int id, String field, Object value)
// Mostra la taula de les ciutats amb la informació de "citites"
// les columnes són d'amples: 5,10, 10, 7, 8
// l'alineació és: esquerra, esquerra, dreta, dreta, dreta
public static void showInformation(ArrayList<HashMap<String, Object>> cities)
```

Aquest **"main"** ha de donar la següent sortida:

```java
    public static void main(String[] args) {
        // Afegir les ciutats inicials
        addCity("Barcelona", 1620343, 12, true);
        addCity("Madrid", 3207247, 667, false);
        addCity("València", 791413, 15, true);
        addCity("Màlaga", 569130, 11, true);
        addCity("Sevilla", 688711, 7, false);
        addCity("Alicante", 330525, 12, true);
        addCity("Zaragoza", 664938, 220, false);
        addCity("Gijón", 275735, 3, true);
        addCity("Palma de M", 22610, 14, true);
        addCity("Bilbao", 345821, 30, false);
        
        // Eliminar Sevilla (haurem de buscar el seu ID)
        int sevillaId = getIdByName("Sevilla");
        if (sevillaId != -1) {
            removeCity(sevillaId);
        }
        
        // Actualitzar diverses dades
        int barcelonaId = getIdByName("Barcelona");
        updateData(barcelonaId, "population", 1621000);

        int valenciaId = getIdByName("València");
        updateData(valenciaId, "height", 16);

        int palmaId = getIdByName("Palma de M");
        updateData(palmaId, "name", "Palma");

        int zaragozaId = getIdByName("Zaragoza");
        updateData(zaragozaId, "sealand", false);
        
        // Afegir una nova ciutat
        addCity("Tarragona", 132299, 70, true);
        
        // Mostrar la informació final
        showInformation();
    }
}
```

Sortida esperada:

```text
----------------------------------------------
|ID   |Name      |Population| Height| Sealand|
----------------------------------------------
|7009 |Barcelona |   1621000|     12|    true|
|4109 |Madrid    |   3207247|    667|   false|
|1962 |València  |    791413|     16|    true|
|9607 |Màlaga    |    569130|     11|    true|
|9414 |Alicante  |    330525|     12|    true|
|2954 |Zaragoza  |    664938|    220|   false|
|5185 |Gijón     |    275735|      3|    true|
|6854 |Palma     |     22610|     14|    true|
|6163 |Bilbao    |    345821|     30|   false|
|1885 |Tarragona |    132299|     70|    true|
----------------------------------------------
```

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercicis/Exercici0013.java

# A la carpeta "Deures00" executar el programa
./run.sh com.exercicis.Exercici0013

# A la carpeta "Deures00" executar el test
./runTest.sh com.exercicis.TestExercici0013

# Testos individuals
./runTest.sh "com.exercicis.TestExercici0013#testGenerateId"
./runTest.sh "com.exercicis.TestExercici0013#testIdExists"
./runTest.sh "com.exercicis.TestExercici0013#testGetIdByName"
./runTest.sh "com.exercicis.TestExercici0013#testAddCity"
./runTest.sh "com.exercicis.TestExercici0013#testRemoveCity"
./runTest.sh "com.exercicis.TestExercici0013#testUpdateData"
./runTest.sh "com.exercicis.TestExercici0013#testShowInformation"
```

# Exercici 0014

Fes un programa que permeti jugar a "Pedra, Paper, Tisores" contra l'ordinador.
El programa ha de:

- Permetre jugar rondes fins que un jugador arribi a 3 victòries o l'usuari decideixi sortir
- Mantenir i mostrar el marcador després de cada ronda
- Guardar les estadístiques de cada jugada (quantes vegades s'ha fet servir cada opció i si ha guanyat)
- Mostrar un missatge descriptiu segons el resultat de cada ronda
- Mostrar un missatge final quan algú guanya la partida
- Permetre sortir del joc quan l'usuari vulgui escrivint "SORTIR"
- Mostrar les estadístiques finals en acabar la partida

Necessitaràs implementar els següents mètodes:
```java
// Retorna un moviment aleatori entre "PEDRA", "PAPER", "TISORES"
public static String getMovePC()

// Demana i valida el moviment del jugador, ha de ser "PEDRA", "PAPER" o "TISORES"
// Si s'introdueix "SORTIR" retorna null
// Rep un Scanner com a paràmetre per llegir l'entrada
public static String getPlayerMove(Scanner scanner)

// Determina qui guanya i retorna un String amb el resultat: "PC", "PLAYER" o "DRAW"
public static String getWinner(String playerMove, String pcMove)

// Retorna el missatge amb el marcador actual
public static String getScoreMessage(int playerScore, int pcScore)

// Retorna el missatge de victòria segons qui ha guanyat la partida
public static String getWinnerMessage(boolean playerWon)

// Actualitza les estadístiques al HashMap stats
// Format: {"PEDRA_COUNT": 0, "PAPER_COUNT": 0, "TISORES_COUNT": 0,
//          "PEDRA_WINS": 0, "PAPER_WINS": 0, "TISORES_WINS": 0}
public static void updateStats(HashMap<String, Integer> stats, String move, boolean win)

// Retorna un missatge segons el resultat de la ronda:
// - Si guanya PC: "Ho sento! [moviment] guanya a [moviment]!"
// - Si guanya PLAYER: "Molt bé! [moviment] guanya a [moviment]!"
// - Si és empat: "Empat! Els dos heu triat [moviment]!"
public static String getMessage(String winner, String playerMove, String pcMove)

// Mostra les estadístiques finals:
// - Número total de partides jugades
// - Percentatge de victòries del jugador (amb un decimal)
// - Moviment més utilitzat pel jugador (amb el número de vegades)
// - Moviment que més victòries ha donat al jugador (amb el percentatge arrodonit)
public static void showStats(HashMap<String, Integer> stats)
```

Exemple de sortida:
```text
Benvingut a Pedra, Paper, Tisores!
El primer en arribar a 3 victòries guanya!

Escriu PEDRA, PAPER, TISORES o SORTIR: pedra
PC tria: TISORES
Molt bé! PEDRA guanya a TISORES!
Marcador -> JUGADOR: 1 - PC: 0

Escriu PEDRA, PAPER, TISORES o SORTIR: paper
PC tria: PEDRA
Molt bé! PAPER guanya a PEDRA!
Marcador -> JUGADOR: 2 - PC: 0

Escriu PEDRA, PAPER, TISORES o SORTIR: tisores
PC tria: PAPER
Molt bé! TISORES guanya a PAPER!
Marcador -> JUGADOR: 3 - PC: 0

Felicitats! Has guanyat la partida!


Estadístiques finals:
------------------
Total partides: 3
Victòries: 100.0%
Moviment més utilitzat: PEDRA (1 vegades)
Moviment més victoriós: PEDRA (100% victòries)
```

Per executar i testejar el programa:
```bash
# Codi: src/main/java/com/exercicis/Exercici0014.java

# A la carpeta "Deures00" executar el programa
./run.sh com.exercicis.Exercici0014

# A la carpeta "Deures00" executar el test
./runTest.sh com.exercicis.TestExercici0014

# Testos individuals
./runTest.sh "com.exercicis.TestExercici0014#testGetPlayerMove"
./runTest.sh "com.exercicis.TestExercici0014#testGetMovePC"
./runTest.sh "com.exercicis.TestExercici0014#testGetWinner"
./runTest.sh "com.exercicis.TestExercici0014#testUpdateStats"
./runTest.sh "com.exercicis.TestExercici0014#testGetMessage"
./runTest.sh "com.exercicis.TestExercici0014#testShowStats"
```

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

Fes un programa que 
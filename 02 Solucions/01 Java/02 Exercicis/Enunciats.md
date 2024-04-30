<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 0

Fes un programa que amb tres variables numèriques:

* Una anomenada 'x' amb valor 1345 
* La segona anomenada 'y' amb valor 64
* La tercera s'ha de dir 'resultat' i serà el valor de calcular x dividit per y (simbol /)

Finalment, el programa ha de mostrar dos textos: 

'El resultat de la divisió és ?', on ? mostra el resultat de la operació anterior

'El resultat arrodonit de la divisió és ?', on ? mostra el resultat de la operació anterior amb 2 decimals

### Exercici 1

Fes un programa que demani "Quina edat tens?" (amb un input), i calculi l'edat que tindríes si fós un gos.

Per calcular l'edat de 'gos', multiplica l'edat humana per 7

Com a sortida mostra: "Si fossis un gos, tindries X anys", on X és el resultat del càlcul anterior

### Exercici 2

Fes un programa que demani dos números (fent servir inputs) i calculi la resta entre ells.

Com a sortida ha de mostrar: "El resultat de calcular X - Y és Z", on:

* X és el primer valor escrit
* Y és el segon valor escrit
* Z és el resultat de restar-los



### Exercici 3

Fes un programa que guardi:

* A la variable 'subjecte', el resultat de preguntar: "Digues un animal: "
* A la variable 'verb', el resultat de preguntar: "Digues què fa l'animal: "
* A la variable 'objecte', el resultat de preguntar: "Digues un objecte: "

Finalment es mostren els continguts de subjecte, verb i objecte separats per una ", "

### Exercici 4

Fes un programa que converteixi la temperatura de Celsius a Fahrenheit.

Primer ha de demanar a l'usuari: "En graus Celsius, quina temperatura fa?"

Després ha de fer el càlcul: fahrenheit = (graus * 1.8) + 32

Finalment ha de mostrar el resultat: "X graus Celsius són Y graus Fahrenheit"

On X són els graus introduits i Y són els graus resultants del càlcul.

### Exercici 5

Fes un programa que a partir de demanar el pes i l'altura, calculi l'índex de massa corporal IMC

Aquest càlcul es fa així: imc = pes / (altura ^ 2)

### Exercici 6

Fes un programa que converteixi un valor en Euros cap a Dollars, per fer-ho ha de demanar:

* El valor en Euros que es vol convertir
* La tasa de conversió que ha d'aplicar

Ha de mostrar la quantitat resultant com a: "El valor de X€ són Y$"

La operació és senzilla, simplement és multiplicar els euros pel valor de la tasa de conversió

On X són els euros introduits i Y el resultat de la conversió.

### Exercici 7

Fes un programa que demani a l'usuari 3 notes d'exàmens i en calculi la nota mitjana.

El resultat ha de ser: "La nota mitjana entre X, Y, Z és A"

On X, Y i Z són els valors introduits per l'usuari i A és el resultat del càlcul de la mitjana.

### Exercici 8

Demana a l'usuari que escrigui 3 valors per calcular l'àrea d'un trapèzi:

* Longitud de la primera base
* Longitud de la segona base
* Altura

El càlcul és area = (base1 + base2) / (2 * altura)

Mostra el resultat d'aquesta area: "L'àrea del trapèzi és: ?" on ? és el valor de l'area

Aleshores fes servir una variable temporal, per intercanviar el valor de les bases i calcular la nova àrea (però amb les bases intercanviades)

Finalment mostra: "L'àrea del trapèzi amb les bases intercanviades és: ?" on ? és el valor de la nova àera

### Exercici 9

Fes un programa amb una variable que tingui el següent text: "Monsters Are Victims Too"

Després manipula aquest text per aconseguir mostrar:
* La llargada de la frase
* La subcadena 'Are' fent servir [:]
* Repeteix la subcadena anterior 5 vegades
* La frase amb només la primera M majúscula

### Exercici 10

Fes un programa amb una variable que tingui el següent text: "Gotta Lose Something To Get Something"

Després manipula aquest text per aconseguir mostrar:
* La llargada de la frase
* La subcadena 'Something' en majúscules
* Les subcadenes "Lose" i "Get" repetides dos cops cada una "LoseLoseGetGet"
* La cadena intercanviant paraules en majúscules i minúscules: "GOTTA lose SOMETHING to GET something"
* La subcadena invertida, sense espais, de la part: "Lose Something To"

### Exercici 11

Fes un programa amb una variable que tingui el següent text: "The pain you feel today will be the strength you'll have tomorrow."

Després manipula aquest text per aconseguir mostrar:
* La llargada de la frase
* La subcadena "The strength you'll have tomorrow"
* Subcadenes concatenades per fer una nova frase: "Today you'll have the strength you'll feel tomorrow."
* La subcadena invertida, sense espais ni cometes simples, de la part: "you'll have the"

### Exercici 12

Crea un menú tal que la sortida sigui així:
```text
        ********Menú Principal********
        1.                Veure perfil                 
        2.         Canviar contrasenya         
        3.                      Sortir
```

### Exercici 13

Fes un programa JAVA amb la funció 'informacio_llibre'. 

Aquesta funció acceptarà 3 paràmetres:
```text
        titol, autor, any
```
Aleshores mostrarà la informació així:
```text
        Títol: El Gran Gatsby, Autor: F. Scott Fitzgerald, Any: 1925
```
Fes que automàticament mostri la informació de 3 llibres

### Exercici 14

Fes un programa amb dues funcions:

* transformar_km_a_milles, amb la operació (kilòmetres * 0.62)

* transformar_milles_a_km, amb la operació (milles / 0.62)

El programa haurà de demanar a l'usuari: "Entra una distància en kilòmetres: "

Després haurà de mostrar: "La distància de X kilòmetres en milles és Y" on X són els kilòmetres originals i Y les milles resultants

Després haurà de tornar a calcular els kilòmetres a partir del resultat anterior

Finalment, escriurà: "El resultat de tornar a calcular els kilòmetres és: Z" on Z és el resultat del càlcul anterior 

**Important:** Per millorar la lectura dels resultats, limita els prints a 3 decimals sense perdre informació

### Exercici 15

Fes un programa amb dues funcions: 

* 'operacions_aritmetiques': que accepta dos paràmetres: 'a' i 'b' i retorna el resultat de les operacions: suma, resta, multiplicació i divisió

* 'mostrar_resultats': que accepta 6 paràmetres: 'a', 'b', 'suma', 'resta', 'multiplicacio' i 'divisio' i mostra els resultats amb el format:
```python
        a + b = suma, a - b = resta, a * b = multiplicacio, a / b = divisio
```
On a i b són els valors originals i suma, resta, multiplicacio, divisio són els altres paràmetres rebuts

És a dir, la funció 'mostrar_resultats' si a = 2 i b = 4, ha de fer un print de:
```python
        4 + 2 = 6, 4 - 2 = 2, 4 * 2 = 8, 4 / 2 = 2     
```
**Nota**: Tingues en compte que les operacions es fan a la funció 'operacions_aritmetiques' i que la funció 'mostrar_resultats' només mostra informació

### Exercici 16

Fes un programa JAVA amb  dues funcions:

* "demana_info" que demana a l'usuari el títol, director i any i retorna tres valors

* "informacio_peli" que accepta 3 paràmetres: titol, director, any i mostra la informació així:
```text
        Títol: Gattacca, Director: Andrew Niccol, Any: 1997
```
El programa ha de demanar i mostrar la informació de 2 pel·lícules.

### Exercici 17

Un palíndrom és una frase que, es llegeix igual del dret que del revés (Tota en minúscula, i si no tens en compte els espais o caràcters especials)

Per exemple:
```text
Anul·la la lluna
Atrapa'l o l'aparta
No sap pas on
Tramaran anar a Mart
Un pop nu
```
Fes una funció anomenada "es_palindrom" que accepta un text d'entrada i retorna "True" o "False" segons si la frase és un palíndrom.

Per avaluar si és un palíndrom:
* Treu tots els espais en blanc de la frase, fes-ho amb replace
* Treu també els caràcters: · i '
* Passa la frase a minúsules
* Compara si el resultat anterior és igual al seu invertit (amb [::-1])

S'ha de mostrar per pantalla: 
```text
        "És la frase 'X' un palindrom? Y"
        On X és la frase d'entrada i Y és "True" o "False"
```
Validar els anagrames d'exemple anteriors, i un parell de textos que no són anagrames

### Exercici 18

Un anagrama és un text, que passat a minúscules i ordenant els seus caràcters, és igual a un altre.

Per exemple:
```text
Mare i Rema
Porta i Tropa
Triangle i Integral
Sopa i Posa
```
Fes una funció anomenada "son_anagrama" que accepta dues paraules d'entrada, i retorna "True" o "False" segons si són anagrames.

Per avaluar si són anagrames:
* Treu tots els espais en blanc de les paraules
* Passa les paraules a minúscules
* Ordena les lletres de les paraules
* Compara si els dos resultats anteriors són iguals

S'ha de mostrar per pantalla: 
```text
        "Són les paraules 'X' i 'Y' anagrames? Z"
        On X i Y són les paraules d'entrada i Z és "True" o "False"
```
Validar els anagrames d'exemple anteriors, i un parell de proves amb quatre paraules que no siguin anagrames.

### Exercici 19

Fes una funció anomenada 'esParell' que retorni si un número és parell o imparell.

La resposta ha de ser el text 'X és parell' si és imparell torna "X és imparell"

**Nota**: Quan es fa un 'return' ja es surt de la funció, no cal fer un 'else'.

Un número és parell quan dividida per 2 no té residu.

### Exercici 20

Fes una funció 'calculaOperacio' que a partir de dos números i una operació (suma, resta, multiplicació i divisió), retorna el resultat.

Per exemple: 

calculaOperacio(2, 3, "suma") ha de retornar 5

calculaOperacio(3, 4, "multiplicació") ha de retornar 12

### Exercici 21

Demana a l'usuari que escrigui una contrasenya.

Crea la funció 'validaContrasenya' que apartir d'un text de contrasenya dirà que és vàlida si:

- La contrasenya té almenys 8 caràcters

- La contrasenya té almenys 2 lletres majúscules i 2 lletres minúscules

La resposta de la funció serà el text:

- "La contrasenya és vàlida" si és vàlida

- "La contrasenya NO és vàlida" si no és vàlida

Et caldrà una funció 'conta_majuscules' i una funció 'conta_minuscules', per fer aquestes funcions:
```python
    def conta_majuscules(text):
        return len(list(filter(str.isupper, text)))
```

### Exercici 22

Fes un programa que generi un número aleatòri entre 0 i 100, primer escriu "El número escollit és: X" on X és el número.

Després:

- Si el número és menor o igual a 25 escriurà "El número és petit"

- Si el número està entre 26 o 74 inclòsos, escriurà "El número és mitjà"

- Si el número és major o igual a 75 escriurà "El número és gran"

### Exercici 23

Fes un programa que demani 3 edats, i aleshores les classifiqui de menor a major. 

Ha de mostrar el text: "Les edats ordenades són X, Y, Z" on X, Y i Z són tres números ordenats de més petit a més gran.

### Exercici 24

Fes un programa que demani una xifra a l'usuari entre 0 i 100.000

El programa ha de dir: "Per un import de X, els impostos que has de pagar són un Y% i el total és Z"

Aleshores:

- Si el valor és menor a 10.000 calcularà un 10% del valor. (Y serà 10% i Z el resultat del càlcul)

- Si el valor està entre 10.001 i 50.000 calcularà un 20% del valor. (Y serà 20% i Z el resultat del càlcul)

- Si el valor és superior a 50.000 calcularà un 30% del valor (Y serà 30% i Z el resultat del càlcul)

Recorda que Z ha de tornar el total a pagar, és a dir els impostos més el valor inicial.

### Exercici 25

Fes un programa que demani un dia de la setmana i digui si s'ha d'anar a l'escola (de dilluns a divendres) o no.

No facis servir "elif", fes-ho només amb un if-else.

### Exercici 26

Fes una funció (calcula_interessos) que calculi els interessos que es paga per una hipotèca, segons un capital inicial, un interès i un nombre de mesos.

Per exemple, si el capital inicial és de 1000€, l'interès del 5% i el nombre de mesos 10, el resultat hauria de ser 50€.

**Pista**: Els interessos es calculen com a `capital * interès * mesos / 100`.

Comprova que la funció 'calcula_interessos' funciona correctament amb els següents valors: 

* 1000, 5, 10 => 500
* 2500, 3, 12 => 900
* 7464, 4, 14 => 4179.84
* 10000, 2, 24 => 4800

### Exercici 27

Fes una funció (valida_targeta) que a partir d'un any, determina si la targeta és vigent o ha caducat.

Aleshores fes un programa que demani un any a l'usuari, el transformi a número i cridi a la funció 'valida_targeta' per saber si la targeta és vigent o ha caducat.

Per exemple:

* Introdueix l'any de vigència de la targeta: 2022 => La targeta ha caducat.
* Introdueix l'any de vigència de la targeta: 'any_actual' => La targeta és vigent.
* Introdueix l'any de vigència de la targeta: 2085 => La targeta és vigent.


Mireu com obtenir les dates amb JAVA a Google
```text
any_actual = ???
```
Valida la funció amb els anys 2020, 2021 i 2023, 2025.


### Exercici 28

Fes un programa per convertir mesures. Et caldrà definir funcions de suport, sigues organitzat/da!

El programa mostrarà aquest menú:
```text
Conversió de mesures:
1. Metres a Milles
2. Milles a Metres
3. Metres a Polzades
4. Polzades a Metres
5. Polzades a Milles
6. Milles a Polzades
Escull una opció de conversió: 
```

Un cop l'usuari premi la tecla corresponent es mostra un misatge:

"S'ha escollit conversió 'Metres a Milles', introdueix la quantitat de metres: "

Finalment es mostra el resultat de la conversió:

"La conversió 'Metres a Milles' de X metres és Z milles"

Els factors de conversió són:

* 1 metre = 0.000621371 milles, 1 milles = 1609.34 metres
* 1 metre = 39.3701 polzades, 1 polzada = 0.0254 metres
* 1 polzada = 0.0000157828 milles, 1 milles = 63360 polzades

### Exercici 29

Fes una funció (valida_contrasenya) que a partir d'una contrasenya comprovi que compleix els següents requisits:

* Tenir entre 5 i 10 caràcters (ambdós inclosos)
* Tenir almenys dues lletres majúscules
* Tenir almenys tres lletres minúscules
* Tenir almenys dos números

La funció ha de retornar `True` si la contrasenya és vàlida i `False` si no ho és.


Aleshores fes un programa que demani una contrasenya i comprovi si és vàlida o no.

* Si la contrasenya és vàlida el programa mostra: "Contrasenya vàlida"
* Si no ho és mostra: "Contrasenya no vàlida".

### Exercici 30

Fes una funció (calcula_irpf) que calculi l'IRPF que ha de pagar una persona segons els ingressos bruts que té.

Si et cal, fes altres funcions de suport a aquesta funció principal. Sigues organitzat/da!

Aquests són els trams que ha de tenir en compte:
```text
                | Trams IRPF            |Total|
                |-----------------------|-----|
                | De 0 a 12.450€        | 19% |
                | De 12.450€ a 20.200€  | 24% |
                | De 20.200€ a 35.200€  | 30% |
                | De 35.200€ a 60.000€  | 37% |
                | De 60.000€ a 300.000€ | 45% |
                | Més de 300.000€       | 47% |
```
Per exemple:

* Si una persona cobra 10.200€, hauria de pagar el 19% = 1.938€
```text
+   0,19 *   10.200€           = 1.938,0€
                               ----------
                         Total:  1.938,0€
```
* Si una persona cobra 15.000€, hauria de pagar:
```text
    0,24 * (15.000€ - 12.450€) =   606,0€
+   0,19 *  12.450€            = 2.365,5€
                               ----------
                         Total:  2.971,5€
```
* Si una persona cobra 22.000€, hauria de pagar:
```text
    0,3  * (22.000€ - 20.200€) =   540,0€
    0,24 * (20.200€ - 12.450€) = 1.860,0€
+   0,19 *  12.450€            = 2.365,5€
                               ----------
                         Total:  4.765,5€
```
Comprova:
```text
        * 7600 => 1444.0
        * 16000 => 3217.5
        * 26000 => 5965.5
        * 32000 => 7765.5
        * 54500 => 15866.5
        * 64832 => 20075.9
        * 275387 => 114825.65
        * 765915 => 349540.69
```

### Exercici 31

Fes una funció (calcula_tarifa) que determini el cost mensual d'una factura telefònica segons els minuts que una persona ha parlat i el número de missatges (SMS) enviats. 

Considera també el cost fix mensual que inclogui certa quantitat de minuts i SMS gratuïts.

Aquests són els detalls del pla:
```text
Cost fix mensual: 15€ (inclou 200 minuts gratuïts i 50 SMS gratuïts)
Cost per minut addicional: 0,10€
Cost per SMS addicional: 0,05€
```
Exemples:
```text
    * Parlar 150 minuts i enviar 40 SMS: Cost fix de 15€.
    * Parlar 250 minuts i enviar 30 SMS: Cost fix (15€) cost addicional de 50 minuts (5€). Total = 20€.
    * Parlar 220 minuts i enviar 80 SMS: Cost fix (15€), cost addicional de 20 minuts (2€) i 30 SMS (1,5€). Total = 18,5€.
```
Comprova que la funció calcula_tarifa funciona correctament amb els següents valors:
```text
* 148 minuts i 20 SMS => 15€
* 264 minuts i 40 SMS => 21.4€
* 420 minuts i 180 SMS => 43.5€
* 520 minuts i 240 SMS => 56.5€
```

### Exercici 32

Escriu una funció (calcula_consum) que determini la factura d'aigua d'un client segons el nombre de litres que ha consumit durant un mes.

Els costos són:
```text
Cost fix mensual: 10€ (inclou els primers 1.000 litres)
Fins a 5.000 litres (inclòs): 0,02€ per litre addicional.
Fins a 10.000 litres (inclòs): 0,03€ per litre addicional.
Més de 10.000 litres: 0,05€ per litre addicional.
```
Per exemple:
* Si un client ha consumit 800 litres, hauria de pagar només el cost fix de 10€.
* Si un client ha consumit 6.000 litres: 
```text
    10€ : Cost fix (1.000 litres)
+   80€ : 0,02€ per 4.000 litres
    30€ : 0,03€ per 1.000 litres
-------            ------
   120€ : Total     6.000 litres
```
* Si et cal, fes altres funcions de suport per a calcula_consum. Sigues organitzat/da!

Exemples per comprovar:
```text
* 800 litres => 10€
* 6.000 litres => 120€
* 9.000 litres => 210€
* 12.000 litres => 340€
```

### Exercici 33

Un cinema ofereix diferents tarifes segons l'edat del client i el dia de la setmana. 

Escriu una funció (calcula_entrada) que determini el preu de l'entrada d'una persona segons la seva edat i el dia que vol anar al cinema.

Els preus són:
```text
Preu estàndard: 10€
Nens (menors de 12 anys): 5€
Gent gran (65 anys o més): 6€
Dimarts (Dia del client): Totes les entrades tenen un descompte del 20%.
Dijous (Dia familiar): Si un adult compra una entrada, l'entrada del primer nen té un 50% de descompte els altres nens no paguen.
```

Els paràmetres de la funció són: 
```text
* Número d'adults
* Número de nens
* Número de persones grans
* Dia
```

No feu inputs, feu servir la funció amb els valors d'exemple i un print per cada cas.

Per exemple:
* Un nen que va al cinema un dimarts: 5€ - 20% = 4€.
* Un adult que va al cinema amb un nen un dijous: L'adult paga 10€ i el nen paga 2,50€ (50% de descompte sobre 5€).
* Un adult que va al cinema amb tres nens un dijous: L'adult paga 10€, el primer nen paga 2,50€, els altres res.
* Si et cal, fes altres funcions de suport per a calcula_entrada. Sigues organitzat/da!

Exemples per comprovar:
* Adult un dilluns: 10€
* Nen un dimarts: 4€
* Gent gran un dijous: 6€ (El descompte del dia familiar només s'aplica als nens)
* Adult i nen un dijous: 10€ + 2,50€ = 12,50€

### Exercici 34

Un petit hotel a la costa vol informatitzar el seu sistema de reserves. 

Necessiten una funció (calcula_reserva) que determini el preu total d'una reserva segons el nombre de nits, el tipus d'habitació i si el client vol esmorzar inclòs.

Les tarifes són:
```text
Habitació estàndard: 50€ per nit.
Habitació amb vistes al mar: 70€ per nit.
Suite amb jacuzzi: 120€ per nit.
Esmorzar: 10€ per dia i persona.
```
La funció hauria d'acceptar els següents paràmetres: 
```text
* nombre de nits
* tipus d'habitació (estàndard, amb vistes o suite)
* el nombre de persones que volen esmorzar.
```
A més, l'hotel ofereix les següents promocions:
* Si reserves més de 5 nits, t'ofereixen un descompte del 10% sobre el total de la reserva (sense comptar l'esmorzar).
* Si reserves una suite amb jacuzzi per més de 3 nits, l'esmorzar és gratuït.

Et pot anar bé definir primer les següents funcions:
* calcula_cost_habitacio(tipus_habitacio, nits)
* calcula_cost_esmorzar(nombre_persones, nombre_dies)

Per exemple:
* Reserva d'una habitació estàndard per 4 nits sense esmorzar: 50€ * 4 = 200€.
* Reserva d'una habitació amb vistes al mar per 6 nits amb esmorzar per a 2 persones: [(70€ * 6) - 10%] + (10€ * 6 * 2) = 444€.
* Si et cal, fes altres funcions de suport per a calcula_reserva. Sigues organitzat/da!

Exemples per comprovar:
* Habitació estàndard, 4 nits, 2 persones amb esmorzar: 280€
* Suite amb jacuzzi, 5 nits, 2 persones amb esmorzar (gratuït per la promoció): 640€
* Habitació amb vistes, 6 nits, 1 persona sense esmorzar: 438€

### Exercici 35

Estàs organitzant festes d'aniversari i oferixes diferents paquets segons les necessitats del client. 

Necessites una funció (calcula_festa) que determini el cost total d'una festa segons el nombre de convidats, el lloc on es realitzarà la festa, si es vol menjar inclòs i si volen entreteniment en directe.

Les tarifes són:

Lloc:
```text
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

La funció hauria d'acceptar els següents paràmetres: 
```text
* tipus de lloc
* nombre de convidats
* tipus de menjar
* tipus d'entreteniment
```

A més, ofereixes les següents promocions:
```text
Si contracten música en directe per la sala gran amb escenari, tenen un descompte de 100€ en l'entreteniment.
Si més de 50 persones assisteixen a la festa, ofereixes un 5% de descompte en el menjar.
```

Només es pot contractar una sala, però es pot contractar diversos entreteniments.

Et pot anar bé definir primer les següents funcions:
* calcula_cost_lloc(tipus_lloc)
* calcula_cost_menjar(tipus_menjar, num_convidats)
* calcula_cost_entreteniment(tipus_entreteniment)

Per exemple:
* Sala estàndard, 20 convidats amb menú bàsic, sense entreteniment: 100€ + (15€ * 20) = 400€.
* Jardí amb piscina, 60 convidats amb menú premium, màgia com a entreteniment: 200€ + [(30€ * 60) - 5%] + 250€ = 2.150€.
* Si et cal, crea funcions auxiliars per a calcula_festa. Sigues organitzat/da!

Exemples per comprovar:
* Jardí amb piscina, 40 convidats, menú bàsic, música en directe: 1.300€
* Saló gran amb escenari, 70 convidats, menú premium, música en directe (amb descompte): 2.895€
* Sala estàndard, 15 convidats, menú premium, màgia: 800€

### Exercici 36

Fes un programa que generi un número aleatori entre 0 i 9 (inclòssos)

Després demana a l'usuari que escrigui un número i comprova:

- Si l'ha encertat escriu: "Felicitats, has encertat amb X **intents**"

- Si no l'ha encertat i el número de l'usuari és més gran que el número secret escriu: "Has escrit X, el número secret és més petit"

- Si no l'ha encertat i el número de l'usuari és més petit que el número secret escriu: "Has escrit X, el número secret és més gran"

Aquest procés es repeteix fins que l'usuari encerta el número.

### Exercici 37

Fes un programa que demani un número entre 0 i 10 a l'usuari.

El programa comprova si el número està entre 0 i 10.

Gràcies a un bucle 'while' podràs fer que aquesta pregunta es repeteixi, mentre l'usuari no entri un número vàlid

Exemple d'execució:
```text
Escriu un número entre 0 i 10: 11
El número 11 és incorrecte. Torna-ho a provar.
Escriu un número entre 0 i 10: 15
El número 15 és incorrecte. Torna-ho a provar.
Escriu un número entre 0 i 10: 5
El número 5 és correcte. Gràcies.
```

### Exercici 38

Fes un programa que fent ús d'un bucle 'while' mostri el següent menú:
```text
Menú:
1. Saluda
2. Parla
3. Sortir
```
Aleshores:

- Quan s'escull la opció 1 es mostra "Hola!"
- Quan s'escull la opció 2 es mostra una de les següents frases a l'atzar:

    * Tinc un gos que es diu Pelut
    * M'agrada menjar xocolata
    * Vull vitajar al Japó

- Quan s'escull la opcio 3 el programa acaba

### Exercici 39

Fes un programa per jugar a "Roca, Paper, Tisores"

El programa demanarà a cada iteració quina és la opció de l'usuari i generarà una opció automàtica per part de l'ordinador.

Es sortirà del bucle 'while' quan un dels dos participants hagi guanyat tres cops o bé quan l'usuari escrigui "sortir".

Si l'usuari escriu sortir, s'escriu "L'usuari ha sortit"

Exemple d'execució:
```text
Escriu la teva opció [Roca, Paper, Tisores, Sortir]: Roca
 - Jugador Roca vs. Ordinador Paper - Puntuació: Jugador 0 - Ordinador 1
Escriu la teva opció [Roca, Paper, Tisores, Sortir]: Paper
 - Jugador Tisora vs. Ordinador Roca - Puntuació: Jugador 0 - Ordinador 2
Escriu la teva opció [Roca, Paper, Tisores, Sortir]: Tisores
 - Jugador Tisora vs. Ordinador Tisora - Puntuació: Jugador 0 - Ordinador 2
Escriu la teva opció [Roca, Paper, Tisores, Sortir]: Roca
 - Jugador Paper vs. Ordinador Roca - Puntuació: Jugador 1 - Ordinador 2
Escriu la teva opció [Roca, Paper, Tisores, Sortir]: Paper
 - Jugador Paper vs. Ordinador Tisora - Puntuació: Jugador 1 - Ordinador 3
Ha guanyat l'ordinador.
```

### Exercici 40

Fes un programa que sumi els números dins d'un rang.

Primer s'ha de demanar els números del rang.

El dos números escrits, s'han d'ordenar de petit a gran.

Per exemple:

- Entre 2 i 5: 2 + 3 + 4 + 5 = 14

- Entre 10 i 15: 10 + 11 + 12 + 13 + 14 + 15 = 75

S'ha de retornar el resultat:

- La suma entre 2 i 5 és 14 

- La suma entre 10 i 15 és 75 

### Exercici 41

Fes un programa que demani un número i mostri la seva taula de multiplicar de 0 a 10.

Per exemple, per 4:
```text
0 x 4 = 0
1 x 4 = 4
...
10 x 4 = 40
``````

### Exercici 42

Fes un programa que lletra a lletra, compti les 'a' que hi ha en un text.

Per exemple:

- "Hola, com estàs?" -> 2

- "Aquesta frase no té cap 'a'." -> 5

### Exercici 43

Fes un programa que donat un rang determinat, mostri els números imparells.

Hauràs de fer la funció 'esImparell' que retorna 'True' si el número és imparell i 'False' si és parell.

Per exemple:

- Entre 2 i 5: 3, 5

- Entre 10 i 15: 11, 13, 15

### Exercici 44

Genera un triangle de X astericos.

Demana un número entre 1 i 10 a l'usuari.

Si l'usuari escrigui un número fora del rang, escriu: "El número ha d'estar entre 1 i 10".

Si el número és correcte mostra el seu triangle d'astericos.

Fes que surti centrat amb la funció de posicionament center a 10 asteriscos d'ample.

Per exemple, per 4

```text
         *
         **
        ***
        ****
```

### Exercici 45

Fes un programa que calculi el factorial d'un número.

El factorial d'un número és el producte de tots els números des d'1 fins al número.

Exemple:

- 5! = 1 x 2 x 3 x 4 x 5 = 120

- 10! = 1 x 2 x 3 x 4 x 5 x 6 x 7 x 8 x 9 x 10 = 3628800

### Exercici 46

Fes un programa que faci 5 bucles per mostrar la següent taula:
```text
1     2     3     4     5     6     7     8     9     10
2     4     6     8     10    12    14    16    18    20
20    22    24    26    28    30    32    34    36    38
10    14    18    22    26    30    34    38    42    46
40    35    30    25    20    15    10    5     0     -5
```

### Exercici 47

Fes una funció (escriu_imparells) que tingui com a paràmetre un número enter, i escrigui tots els valors imparells entre 0 i el número escrit.

### Exercici 48

Fes un programa que demani a l'usuari el seu nom, i fent ús d'un bucle 'for' escrigui cada lletra en una línia diferent perquè quedi en format vertical.

Exemple:
```python
Escriu el teu nom: Tom
T
o
m
```

**Nota**: Per obtenir un caràcter d'una cadena de text, pots fer servir [X], on X és la posició que vols obtenir.

### Exercici 49

Fes un programa que demani a l'usuari que escrigui una paraula.

Segueixi demanant paraules fins que l'usuari escrigui "fi". 

Finalment, es mostra una cadena de text amb totes les paraules escrites separades per espai

### Exerici 50

Fes un programa que demani a l'usuari una direcció de correu electrònic i validi que:

- Conté un símbol @
- Conté un punt
- El símbol @ no està al principi
- El símbol @ no està al final
- El punt no està al principi
- El punt no està al final
- El símbol @ i el punt no estan junts

El programa tornarà a demanar el correu electrònic, fins que se n'escrigui un de vàlid.


### Exerici 51

Fes un programa que doni només 3 intents a l'usuari per escriure una contrasenya correcta.

Si l'usuari escriu la contrasenya correcta, el programa escriu "Accés permès" i s'acaba.

Si l'usuari escriu una contrasenya incorrecta, el programa escriu "Contrasenya incorrecta" i torna a demanar la contrasenya.

La contrasenya correcta és "1234".

### Exerici 52

Fes una funció (compta_vendes), que demani a l'usuari el valor en € d'unes quantes vendes. La funció ha de retornar:

- El nombre de vendes entrades
- La suma total
- La mitjana

Per deixar d'escriure vendes, l'usuari escriu 'fi'.

Al final, el programa ha de mostrar:

```
S'han apuntat X vendes, amb un total de Y € i una mitjana de Z €.
```

### Exerici 53

Fes una funció (calcula_comisió), que demana a un empleat que escrigui les vendes que ha realitzat.

Demanarà vendes fins que l'empleat escrigui 'fi'.

Per cada venda, es calcula la comissió següent:

* Si la venda és inferior a 1000 €, la comissió és del 5%
* Si la venda és igual o superior a 1000 € i inferior a 5000 €, la comissió és del 7%
* Si la venda és igual o superior a 5000 €, la comissió és del 10%

La funció ha de retornar:

* El nombre de vendes entrades
* La suma total
* La suma sense la comissió
* La mitjana
* La comissió total

Al final, el programa ha de mostrar:
```text
S'han entrat X vendes, amb un total de Y € i una mitjana de Z €. 
S'ha aconseguit una comissió de W €.
```

### Exerici 54

**Compta el preu de la frase.**

Fes una funció que rep una frase com a paràmetre, i torna el preu de la frase.

El preu de la frase és:

* 0.05 per cada lletra
* 0.10 per cada número
* 0.05 per cada 'a', o 'A'
* 0.15 per cada 'b', 'f', 'h', 'l', 'p', 't', 'v'
* 0.30 per cada 'G', 'J', 'K', 'M', 'N', 'Q', 'Z'

Comprova:
```text
El preu de la frase 'Hello World 123 AaBbZz' és: 2.4
El preu de la frase 'En Gabriel ha comprat 3 kg de taronges' és: 2.9
El preu de la frase 'Jo tinc 2 germans, un es diu Quim i l\'altre Zahir' és: 3.69
```


### Exerici 55

Fes una funció que rebi un número llarg com a paràmetre, el transformi a cadena text i retorni dos paràmetres:

* El nombre de números parells
* El nombre de números senars

### Exerici 56

Fes una funció (porcio_taula) que rebi tres paràmetres:

* Número
* Valor inici
* Valor final

La funció ha d'escriure la porció de la taula de multiplicar entre 'inici' i 'final'

Exemples:

```python
porcio_taula(2, 4, 7)
4 x 2 = 8
5 x 2 = 10
6 x 2 = 12
7 x 2 = 14

porcio_taula(5, 3, 5)
3 x 5 = 15
4 x 5 = 20
5 x 5 = 25
```

### Exerici 57

Fes una funció (taules_sumar) que rebi dos paràmetres:

* Taula inicial
* Taula final

I escrigui per pantalla les taules de sumar des de la taula inicial fins a la taula final, per valors entre 0 i 4.

Ha de separar les taules amb cinc guions "-----".

Exemples:

```python
taules_sumar(3, 4)
3 + 0 = 3
3 + 1 = 4
3 + 2 = 5
3 + 3 = 6
3 + 4 = 7
-----
4 + 0 = 4
4 + 1 = 5
4 + 2 = 6
4 + 3 = 7
4 + 4 = 8
-----

taules_sumar(5, 7)
5 + 0 = 5
5 + 1 = 6
5 + 2 = 7
5 + 3 = 8
5 + 4 = 9
-----
6 + 0 = 6
6 + 1 = 7
6 + 2 = 8
6 + 3 = 9
6 + 4 = 10
-----
7 + 0 = 7
7 + 1 = 8
7 + 2 = 9
7 + 3 = 10
7 + 4 = 11
-----
```

### Exerici 58

Fes un programa que a partir de dos bucles anidats (un bucle dins d'un altre), mostri la següent taula:

```text
x,y
0,0 1,0 2,0 3,0 4,0 5,0
0,1 1,1 2,1 3,1 4,1 5,1
0,2 1,2 2,2 3,2 4,2 5,2
0,3 1,3 2,3 3,3 4,3 5,3
0,4 1,4 2,4 3,4 4,4 5,4
0,5 1,5 2,5 3,5 4,5 5,5

```

### Exercici 59

Fes un programa que mostri el següent menú:
```text
    CALCULADORA
    Menú Principal

    1 - Sumar
    2 - Restar
    3 - Multiplicar
    4 - Dividir
    0 - Sortir
    Opció: 
```
L'usuari escriu el número d'opció, si s'escull una opció no coneguda 
es mostra el menú de nou amb el text "Opció incorrecta" a sobre de la línia "Opció: "

Un cop escollida una

* Si és la 0 s'acaba el programa.
* Si és una altra, demana dos números i mostra el resultat de l'operació.

### Exercici 60

Fes un programa que mostri i compti els múltiples de 7 entre 1 i 1000

Nota, els múltiples de 7 dónen 0 com a residu quan es divideixen entre 7.

Per exemple:
```text
7 / 7 = 1 i residu 0, és múltiple de 7
14 / 7 = 2 i residu 0, és múltiple de 7
15 / 7 = 2 i residu 1, no és múltiple de 7
21 / 7 = 3 i residu 0, és múltiple de 7
27 / 7 = 3 i residu 6, no és múltiple de 7
```
Per exemple, per 149:
22: 0, 7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91, 98, 105, 112, 119, 126, 133, 140, 147, 

### Exercici 61

Fes una funció (escriu_llista), que rebi una llista i escrigui a cada línia:

L'element a la posició X de la llista és 'Y'

Prova-la amb arrays:

* String[] partsDelDia = {"Matí", "Tarda", "Vespre", "Nit"};
* String[] diesDeLaSetmana = {"Dilluns", "Dimarts", "Dimecres", * "Dijous", "Divendres", "Dissabte", "Diumenge"};
* String[] mesosDeLAny = {"Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre"};


### Exercici 62

Fes una funció (escriu_llista), que rebi una llista i escrigui a cada línia:

L'element a la posició X de la llista és 'Y'

Prova-la amb ArrayLists:

* ArrayList<String> partsDelDia = new ArrayList<>(Arrays.asList("Matí", "Tarda", "Vespre", "Nit"));
* ArrayList<String> diesDeLaSetmana = new ArrayList<>(Arrays.asList("Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenge"));
* ArrayList<String> mesosDeLAny = new ArrayList<>(Arrays.asList("Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre"));



### Exercici 63

Fes una funció que rebi una llista de cadenes de text que representen números, i retorni una llista de números.

Fes-ho primer amb arrays:

String[] numeros = {"4", "5", "6", "7"};

I després amb llistes:

ArrayList<String> numeros = new ArrayList<>();
numeros.add("4");
numeros.add("5");
numeros.add("6");
numeros.add("7");

### Exercici 64

Fes una funció que rebi una llista de cadenes de text que representen números, i retorni una llista de números.

Fes-ho amb llistes:

ArrayList<String> numeros = new ArrayList<>();
numeros.add("4");
numeros.add("5");
numeros.add("6");
numeros.add("7");

### Exercici 65

Fes un programa que demana a l'usuari una llista de números enters separats per comes.

A continuació fes una funció (calcula_valors) que retorni aquests valors:

* La suma de tots els elements de la llista
* El valor més gran de la llista
* El valor més petit de la llista
* La mitjana de tots els elements de la llista

Comprova:

* "4,8,7,2,5,3,9" > Suma = 38, Màxim = 9, Mínim = 2, Mitjana = 5.43
* "7,2,4,8,4,2" > Suma = 27, Màxim = 8, Mínim = 2, Mitjana = 4.5

### Exercici 66

Defineix una funció (separa_vocals) que a partir d'una llista de paraules, retorna dos arrays:

* La primera conté totes les paraules que comencen per vocal
* La segona conté totes les paraules que comencen per consonant

Després defineix la funció (vocals_al_final) que a partir de una llista de paraules, retorna una llista on les paraules que començen per vocal estàn al final de la llista

L'entrada ha de ser un **input** de l'usuari.

Prova-ho amb:

* "Hola, ara mateix estem aprenent Java" > ["Hola,", "mateix", "JAVA", "ara", "estem", "aprenent"]
* "Demà és festa i anem a la platja" > ["Demà", "festa", "la", "platja", "és", "i", "anem", "a"]

### Exercici 67

Defineix una funció (separa_vocals) que a partir d'una llista de paraules, retorna dues array lists:

* La primera conté totes les paraules que comencen per vocal
* La segona conté totes les paraules que comencen per consonant

Després defineix la funció (vocals_al_final) que a partir de una llista de paraules, retorna una llista on les paraules que començen per vocal estàn al final de la llista

L'entrada ha de ser un **input** de l'usuari.

Prova-ho amb:

* "Hola, ara mateix estem aprenent Java" > ["Hola,", "mateix", "JAVA", "ara", "estem", "aprenent"]
* "Demà és festa i anem a la platja" > ["Demà", "festa", "la", "platja", "és", "i", "anem", "a"]

### Exercici 68

Fes una funció, que escrigui la informació de la matriu  d'arrays 'inventari_neteja' separada per categories.

Potser necessites funcions auxiliars per:
- Obtenir una llista amb totes les categories
- Esriure la informació dels elements d'una determinada categoria

Exemple:
```python
Categoria 'Casa':
- Detergent, 5.99
- Esprai netejador, 3.49
...
Categoria 'Personal':
- Xampú, 4.99
...
```

Prova-ho amb:

```java
Object[][] inventariNetja = {
    {"Detergent", "Casa", 5.99},
    {"Netejador d'interiors", "Automoció", 7.99},
    {"Tovalloles de paper", "Casa", 2.99},
    {"Paper higiènic de luxe", "Personal", 7.99},
    {"Netejador de vidres", "Casa", 4.79},
    {"Aspiradora", "Casa", 29.69},
    {"Cera de cotxes", "Automoció", 8.49},
    {"Tovalloletes netejadores", "Personal", 6.29},
    {"Xampú per al cos", "Personal", 4.99},
    {"Sabó de mans líquid", "Personal", 2.49},
    {"Esprai netejador", "Casa", 3.49},
    {"Estopa de cotxes", "Automoció", 1.99},
};
```

**Nota**: Fixa't que 'Object' ens permet guardar dades genèriques en un array (en aquest cas un array d'arrays)

### Exercici 69

Fes una funció (mes_llarg) que rebi un array on cada element té diferent longitud, i retorni:

* La longitud de l'element més llarg
* L'element més llarg

```java
    double[][] arrayExtrany = {
        {153.74, 149.08, 129.79, 171.06, 116.25, 131.41, 194.33},
        {181.87, 167.69, 149.67, 108.23, 103.14, 160.41, 182.72, 139.0},
        {171.8, 185.45, 134.96, 188.69, 130.93, 171.57, 113.02, 117.68, 163.42, 115.94},
        {169.12, 142.05, 159.83, 111.91, 113.3, 124.93},
        {167.24, 172.77, 172.17, 173.33, 155.55},
        {122.62, 159.59, 137.42, 163.53},
        {198.59, 110.02, 140.0, 173.99, 177.57, 198.21, 112.09, 182.33, 185.05},
        {197.01, 176.23, 119.21, 129.65, 184.99, 194.32, 186.76, 131.82},
        {196.99, 130.01, 137.59, 145.12, 131.61, 138.01, 117.73, 148.02, 112.45},
        {172.67, 189.0, 150.42, 106.44, 152.11, 122.04, 163.53, 157.69, 178.01, 124.56}
    };
```

## Exercici 70

Fes una funció (sumes_array) que rebi un array on cada element té diferent longitud, i retorni:

* Un array amb la suma de tots els valors de cada array interior
* La suma total de tots els elements de tots els arrays

```java
    double[][] arrayExtrany = {
        {153.74, 149.08, 129.79, 171.06, 116.25, 131.41, 194.33},
        {181.87, 167.69, 149.67, 108.23, 103.14, 160.41, 182.72, 139.0},
        {171.8, 185.45, 134.96, 188.69, 130.93, 171.57, 113.02, 117.68, 163.42, 115.94},
        {169.12, 142.05, 159.83, 111.91, 113.3, 124.93},
        {167.24, 172.77, 172.17, 173.33, 155.55},
        {122.62, 159.59, 137.42, 163.53},
        {198.59, 110.02, 140.0, 173.99, 177.57, 198.21, 112.09, 182.33, 185.05},
        {197.01, 176.23, 119.21, 129.65, 184.99, 194.32, 186.76, 131.82},
        {196.99, 130.01, 137.59, 145.12, 131.61, 138.01, 117.73, 148.02, 112.45},
        {172.67, 189.0, 150.42, 106.44, 152.11, 122.04, 163.53, 157.69, 178.01, 124.56}
    };
```

### Exercici 71

Fes una funció (mitjanes_array) que rebi un array on cada element té diferent longitud, i retorni:

* Un array amb la mitjana de tots els valors de cada array interior
* La mitjana total de tots els elements de tots els arrays

```java
    double[][] arrayExtrany = {
        {153.74, 149.08, 129.79, 171.06, 116.25, 131.41, 194.33},
        {181.87, 167.69, 149.67, 108.23, 103.14, 160.41, 182.72, 139.0},
        {171.8, 185.45, 134.96, 188.69, 130.93, 171.57, 113.02, 117.68, 163.42, 115.94},
        {169.12, 142.05, 159.83, 111.91, 113.3, 124.93},
        {167.24, 172.77, 172.17, 173.33, 155.55},
        {122.62, 159.59, 137.42, 163.53},
        {198.59, 110.02, 140.0, 173.99, 177.57, 198.21, 112.09, 182.33, 185.05},
        {197.01, 176.23, 119.21, 129.65, 184.99, 194.32, 186.76, 131.82},
        {196.99, 130.01, 137.59, 145.12, 131.61, 138.01, 117.73, 148.02, 112.45},
        {172.67, 189.0, 150.42, 106.44, 152.11, 122.04, 163.53, 157.69, 178.01, 124.56}
    };
```

### Exercici 72

Fes dues funcions 'calculaMajuscules' i 'calculaMinuscules' que retornin el número de majúscules i minúscules d'un text respectivament.

El càlcul es fa així:
```python
        numero_majuscules = longitud_del_text - longitud_del_text_sense_majuscules
        numero_minuscules = longitud_del_text - longitud_del_text_sense_minuscules
```

### Exercici 73

Fes una funció (escriu_taula) que rebi els següents paràmetres:

* **dades** una taula de dades homogènies (tots els elements tenen igual longitud)
* **columnes** amb tants elements com columnes tingui la taula de dades
* **alineacions** amb la mateixa longitud que les columnes, format pels caràcters "<, ^, >"
* **amplades** amb la mateixa longitud que les columnes indicant l'amplada en caràcters de cada una

L'array ha de tornar una taula formatada correctament, el separador vertical és | i l'horitzontal -

* Si la cadena de text és més ample que la columna, l'ha de retallar
* Si alguna de les llistes no té la mateixa longitud que la resta, ha de retornar un missatge d'error.

Per exemple:
```java
    Object[][] ciutats = {
        {0, "Barcelona", 1620343, 12, true},
        {1, "Madrid", 3207247, 667, false},
        {2, "València", 791413, 15, true},
        {3, "Màlaga", 569130, 11, true},
        {4, "Sevilla", 688711, 7, false},
        {5, "Alicante", 330525, 12, true},
        {6, "Zaragoza", 664938, 220, false},
        {7, "Gijón", 275735, 3, true},
        {8, "Palma de Mallorca", 22610, 14, true},
        {9, "Bilbao", 345821, 30, false}
    };

    // Aquests arrays podrien ser utilitzats per a controlar la presentació si fos necessari.
    String[] columnes = {"id", "ciutat", "poblacio", "altitud", "costera"};
    String[] alineacions = {"left", "left", "center", "center", "right"};
    int[] amplades = {3, 10, 10, 8, 6};
```
```text
------------------------------------------------
|id  |ciutat     | poblacio  |altitud  |costera|
------------------------------------------------
|0   |Barcelona  | 1620343   |   12    |  True |
|1   |Madrid     | 3207247   |  667    | False |
|2   |València   |  791413   |   15    |  True |
|3   |Màlaga     |  569130   |   11    |  True |
|4   |Sevilla    |  688711   |   7     | False |
|5   |Alicante   |  330525   |   12    |  True |
|6   |Zaragoza   |  664938   |  220    | False |
|7   |Gijón      |  275735   |   3     |  True |
|8   |Palma de M |   22610   |   14    |  True |
|9   |Bilbao     |  345821   |   30    | False |
------------------------------------------------
```


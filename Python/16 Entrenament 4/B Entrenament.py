
dict_clients =  {"34343434H": {"nom": "Jason Statham", "telefon": "666994455"},
 "78787878K": {"nom": "Dwayne Johnson", "telefon": "666765432"},
 "39292939S": {"nom": "Federico Luppi", "telefon": "666232211"},
 "53423454C": {"nom": "Lorenzo Lamas", "telefon": "666987578"},
 "87654334T": {"nom": "Charlize Theron", "telefon": "555443322"},
 "92837467Z": {"nom": "Linda Hamilton", "telefon": "555443322"},
 "26548734H": {"nom": "Scarlett Johansson", "telefon": "555443322"},
 "99837653N": {"nom": "Uma Thurman", "telefon": "555443322"}
 }

dict_articles = { 4: {"nom": "ASUS TUF GeForce RTX", "stock": 6, "preu": 1400},
 2: {"nom": "ASUS DUAL Radeon RX6600", "stock": 12, "preu": 294},
 3: {"nom": "Intel Core i7-13700K", "stock": 9, "preu": 530},
 1: {"nom": "Kingston Fury Beast 32GB", "stock": 10, "preu": 180},
 10: {"nom": "Corsair DC Cable Pro Kit", "stock": 20, "preu": 110},
 11: {"nom": "Gigabyte GC-TITAN RIDGE 2.0", "stock": 15, "preu": 81},
}

dict_compres = {"AA32E": {"data": 20201101, "articles":{3:1,4:1} },
 "AB37Z": {"data": 20201101, "articles":{1:1,4:1} },
 "CF13U": {"data": 20201101, "articles":{1:1,3:1} },
 "KL11T": {"data": 20201101, "articles":{1:3,3:2,4:2} },
 "ST234": {"data": 20191207, "articles":{1:1,3:1,4:1} },
 "NL345": {"data": 20181207, "articles":{ 1:1,2:1,3:1} },
 "SG345": {"data": 20190407, "articles":{1:1,2:1,3:1,4:3} },
 "SU798": {"data": 20210107, "articles":{2:2,10:3,11:1} }
}

client_compra = {"34343434H": ["AA32E", "AB37Z","SG345"], "78787878K": ["CF13U", "KL11T"], "39292939S": ["ST234"],
 "53423454C": ["NL345"], "87654334T":["SU798"] }

compra_client = {"AA32E": "34343434H", "AB37Z": "34343434H", "CF13U": "78787878K", "KL11T": "78787878K",
 "ST234": "39292939S", "NL345": "53423454C","SG345" : "34343434H","SU798":"87654334T"}


"""
Exercici 0

Crea una funció que anomenarem 'new_tfn()'.

Aquesta funció no rebrà cap paràmetre, demanarà un telèfon per consola i en 
cas de ser un telèfon correcte ( 9 números), ens tornarà un string amb 
el telèfon introduït per consola.

Aquesta funció llançarà excepcions del tipus ValueError en el cas que:

• El telèfon no té un format adequat (9 números).

I ens mostrarà un missatge descriptiu de lerror corresponent, tornant a 
demanar un telèfon a l'usuari.

"""

"""
Exercici 1

Fes una funció amb el nom new_nif(). Que rebrà un paràmetre opcional 
amb valor per defecte, new=”yes”. D'aquesta manera podrem distingir 
si el nif ens servirà per crear un client nou o per buscar un nif ja creat.

En cridar a aquesta funció, ens demanarà un NIF per consola i en 
cas que el NIF sigui correcte, ens tornarà aquest NIF amb la 
lletra en majúscula.

Aquesta funció llançarà excepcions del tipus ValueError en el cas que:

• El NIF no tingui un format adequat (8 números i una lletra).
• La lletra del NIF no sigui correcta
• El NIF ja existeix al diccionari dict_clients i el valor 
del paràmetre new sigui “yes”.

I ens mostrarà un missatge descriptiu de l’error corresponent, 
tornant a demanar un NIF a l'usuari. Hi haurà d'haver dos 
missatges d'error diferents, no val un de genèric.
"""

"""
Exercici 2

Crearem una funció amb el nom 'new_item_id()'. Que no rebrà cap paràmetre.

En cridar a aquesta funció, ens demanarà un ID darticle. Aquest id ha de ser numèric.

I en cas de ser un id correcte, ens tornarà aquest ID.

Aquesta funció llançarà excepcions del tipus 'raise' en cas que:

• L'ID que introduïu l'usuari no sigui numèric.
• L'ID que introduïu l'usuari sigui negatiu.
• L'ID ja existeix al diccionari dict_articles.

I ens mostrarà un missatge descriptiu de lerror corresponent, 
tornant a demanar un ID a lusuari.

"""

"""
Exercici 3

Crearem una funció amb el nom 'new_item_stock()'. Que no rebrà cap paràmetre.

En cridar a aquesta funció, ens demanarà per consola un enter positiu, i en cas de ser
correcte, ens ho tornarà.

Aquesta funció llançarà excepcions del tipus 'raise' en cas que:

• El stock que introduïu l'usuari no sigui numèric o negatiu.

I ens mostrarà un missatge descriptiu de lerror corresponent, 
tornant a demanar un stock a lusuari.
"""

"""
Exercici 4

Crearem una funció amb el nom 'new_item_price()'. Que no rebrà cap paràmetre.

En cridar a aquesta funció, ens demanarà un preu que ha de ser un enter positiu, 
i en cas de ser correcte, ens ho retornarà.

Aquesta funció llançarà excepcions del tipus 'raise' en cas que:

• El preu que introduïu l'usuari no sigui numèric o sigui negatiu.

I ens mostrarà un missatge descriptiu de lerror corresponent, 
tornant a demanar un preu a l'usuari.
"""

"""
Exercici 5

Crearem una funció amb el nom 'new_item_name()'. Que no rebrà cap paràmetre.

En cridar a aquesta funció, ens demanarà el nom d'un article, 
i en cas de no existir, ens ho tornarà.

Aquesta funció llançarà excepcions del tipus ValueError en cas que:

• El nom que introduïu l'usuari ja existeixi al diccionari dict_articles, 
Sense distingir majúscules de minúscules.

• El nom que s'introdueixi estigui buit o només tingui espais

I ens mostrarà un missatge descriptiu de lerror corresponent, 
tornant a demanar un nom a l'usuari.
"""

"""
Exercici 6

Crearem una funció amb el nom 'find_item_id()'. Que no rebrà cap paràmetre.

En cridar a aquesta funció, ens demanarà un ID darticle. Aquest id ha 
de ser numèric i ha d'existir al diccionari d'articles.

I en cas de ser un id correcte, ens tornarà aquest ID.

Aquesta funció llançarà excepcions del tipus ValueError en cas que:

• L'ID que introduïu l'usuari no sigui numèric.

• L'ID que introduïu l'usuari sigui negatiu.

• L'ID no existeixi al diccionari dict_articles.

I ens mostrarà un missatge descriptiu de lerror corresponent, 
tornant a demanar un ID a l'usuari.
"""

"""
Exercici 7

Crearem una funció amb el nom 'print_item(id,**values)'. Que rebrà un id 
d’article i opcionalment una sèrie de paràmetres del tipus clau=valor.

En cridar a aquesta funció, ens imprimirà les propietats 
de l'article amb l'ID passat.

Si no passem cap parella del tipus clau=valor, ens imprimirà l'article 
tal com està al diccionari dict_articles amb el format següent:

ID                           2
Name   ASUD DUAL Radeon RX6600
Stock                       12
Price                      294

En cas de passar alguna parella clau=valor, ens imprimirà les propietats 
de l'article, tal com estan al diccionari d'articles, excepte el camp 
passat com a clau=valor, que ens ho imprimirà tal i com s'ho passem.
Per exemple, si anomenem la funció com a print_item(2,name=”New Name”) ens imprimirà:

ID                           2
Name                  New Name
Stock                       12
Price                      294

Aquesta funció llançarà excepcions del tipus ValueError en cas que:

• L'ID que passem no estigui al diccionari d'articles.

• Una de les parelles clau=valor no existeixi al diccionari d'articles

I ens mostrarà un missatge descriptiu de lerror corresponent.

Aquesta funció la farem servir en els casos que vulguem modificar un article.
"""

"""
Exercici 8

Crearem una funció 'order_list(llista, ordre)' que rebrà dos 
paràmetres, “llista” i “ordre”.

El segon parámetre serà opcional i tindrà el valor per defecte “des”.

El nom de la funció i dels paràmetres serà exactament igual al de l'enunciat.

Aquesta funció ens retornarà la llista que us passem per paràmetre ordenada 
ascendentment si el paràmetre “ordre” és igual a “asc”, o 
descendentment si el paràmetre “ordre” és igual a “des”.

Aquesta funció llançarà excepcions del tipus ValueError en els casos:

• Que el paràmetre llista no sigui una llista.

I TypeError en els casos:

• Que els valors a comparar a la llista no siguin del mateix tipus.

• Que donem un valor al paràmetre ordre i no sigui ni “des” ni “asc”.

I en cadascun daquests casos es recollirà lexcepció i es 
mostrarà un missatge descriptiu
de l’error.
"""

"""
Exercici 9

Crea la funció 'order_dict_by_key(diccionario, orden, key= "")' que 
rebrà 3 paràmetres, “diccionari”, “ordre” i “key”.

El nom de la funció i dels paràmetres serà exactament igual al de l'enunciat.

El primer paràmetre serà un diccionari, que serà del tipus:

{clau-1: valor-1, clau-2: valor-2, …., clau-n: valor-n}

on els valors valor-1, valor-2, …, valor-n són tipus simples ( int, string, float )

o del tipus:

{
clau-0: diccionari-1={key-0:value-0, key-1:value-1,…,key-m:value-m},
clau-1: diccionari-2={key-0:value-0, key-1:value-1,…,key-m:value-m},
.
.
clau-n: diccionari-n={key-1:value-1, key-2:value-2,…,key-m:value-m}
}
on els diccionaris diccionari-1, diccionari-2,…,diccionari-n, 
tenen les mateixes claus.

Com a exemple daquest segon diccionari tenim el diccionari 
dict_articles de lexercici negoci.

El segon paràmetre només podrà prendre els valors “asc” o “des”

El tercer paràmetre serà opcional amb valor per defecte a “” i només 
podrà prendre com a valor una de les claus dels diccionaris diccionari-1, 
diccionari-2,…diccionari-n, és a dir, key-0, key-1 . ..key-n.

Si passem un diccionari del segon tipus, és a dir, diccionari de diccionaris, 
cal especificar el paràmetre key com un dels valors key-0, key-1 ...key-n.

És aquest cas la funció retornarà una llista amb les claus del diccionari 
que passem com a paràmetre [clau-1, clau-2, …,clau-n] ordenades segons el 
valor de la clau que hàgim especificat com a key, de forma ascendent 
si ordre =”asc” o de forma descendent si ordre=”des”

És a dir si passem com a paràmetres dict_artículos,”des”,”stock”.

dict_articles = {4: {"nom": "article4", "stock": 6, "preu": 52},
 2: {"nom": "article2", "stock": 12, "preu": 32},
 3: {"nom": "article3", "stock": 9, "preu": 42},}
La funció, ens tornarà la llista [2,3,4] ja que el stock 12 és el més 
gran i correspon a l'id 2 l'stock 9 és el segon més gran i correspon a l'id 2, 
i el stock 6 és el més petit i correspon a l'id 4.

Si el diccionari que passem com a paràmetre és del primer tipus, no cal 
especificar el paràmetre key, només el paràmetre ordre.

En aquest cas la funció ens retornarà una llista amb els id's del 
diccionari ordenats pels valors del diccionari, en ordre ascendent si 
el paràmetre ordre és “asc”, o en ordre descendent si el paràmetre ordre és “des”.

És a dir si passem com a paràmetres “dict”,”des”.

dict = {3: 5, 4: 4, 1: 5, 2: 2} ens tornarà la llista: [3, 1, 4, 2]

Aquesta funció llançarà excepcions del tipus TypeError en cas de:

- Que donem un valor al paràmetre key, però els valors del diccionari no siguin
diccionaris.

- Que no donem un valor al paràmetre key i els valors del diccionari siguin
diccionaris.

- Que donem un valor al paràmetre key però no existeixi aquesta key als
diccionaris que aplica.

- En qualsevol cas que els valors que comparem no siguin del mateix tipus.

- Que donem un valor al paràmetre ordre i no sigui ni “des” ni “asc”.

I en cadascun daquests casos es recollirà lexcepció i es 
mostrarà un missatge descriptiu de lerror
"""

"""
Exercici 10

- Crea un paquet amb el nom les_meves_funcions. En cas que el paquet 
tingui un nom diferent, es restarà 5 punts de la pràctica. En aquest 
paquet hi haurà un fitxer funcions.py que serà on definirem les 
çfuncions i un fitxer dades.py, que serà on definirem tots els 
diccionaris de la pràctica.

- L'executable no contindrà cap de les funcions de l'exercici ni les definicions dels
diccionaris.

- Totes les funcions estaran comentades, per cada funció sense comentar es
restaran 2 punts de la pràctica.

- Tots els noms de funcions i paràmetres seran exactament iguals als de l'enunciat, i
no serà vàlid l'exercici sencer en cas de no respectar els noms.

- Es modificarà l'exercici sencer fent ús de les funcions definides 
sempre que sigui possible
"""
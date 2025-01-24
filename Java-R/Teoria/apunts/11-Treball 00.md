<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

# Treball 00, gestió de biblioteca

## Enunciat

Desenvolupeu una aplicació en Java per línia de comandes que permeti gestionar una biblioteca senzilla. 

L'objectiu és implementar una gestió d'inventari de llibres, un arxiu d'usuaris i un sistema de préstecs de llibres, respectant les limitacions especificades.

## Requeriments

### Dades

**LLibres**

- Id: identificador únic del llibre
- Titol: nom del llibre
- Autor: autor o autors del llibre (una llista)

**Usuaris**

- Id: identificador únic de l'usuari
- Nom: nom de l'usuari
- Cognoms: cognoms de l'usuari
- Telèfon: telèfon de l'usuari

**Préstecs**

- Id: identificador únic del préstec
- IdLlibre: identificador del llibre prestat
- IdUsuari: identificador de l'usuari que ha presat el llibre
- DataPrestec: data en la que es va fer el préstec
- DataDevolucio: data en la que es va fer la devolució

### Llistats

Cal poder obtenir els següents llistats:

- Llistat de llibres
- Llistat de llibres en prestec
- Llistat de llibres d'un autor
- Llistat de llibres a partir de paraules al títol
- Llistat d'usuaris
- Llistat d'usuaris amb préstecs actius
- Llistat d'usuaris amb préstecs fora de termini
- Llistat de préstecs
- Llistat de préstecs d'un usuari
- Llistat de préstecs actius
- Llistat de préstecs fora de termini

### Menús

Els menús es poden navegar a partir del número d'opició i a partir de paraules clau (per exemple 1 i "llibres")

**Menú pricipal**

```text
Gestió de biblioteca
1. Llibres
2. Usuaris
3. Préstecs
0. Sortir
Escull una opció:
```

**Menú de llibres**

```text
Gestió de llibres
1. Afegir
2. Modificar
3. Eliminar
4. Llistar
0. Tornar al menú principal
Escull una opció:
```

**Menú de llistar llibres**

```text
Llistar llibres
1. Tots
2. En préstec
3. Per autor
4. Cercar títol
0. Tornar al menú de llibres
Escull una opció:
```

i així per les altres opcions (usuaris, préstecs, etc.)

- Als submenús l'opció **"0 / tornar"** sempre és per tornar al menú anterior
- Al menú principal, la opció **"0 / sortir"** és per sortir de l'aplicació

## Requeriments tècnics

**Persistència de Dades**: Les dades dels llibres, usuaris i préstecs s'han de guardar en arxius *".json"* 

* llibres.json
* usuaris.json
* prestecs.json.

Els arxius *".json"* han d'estar actualitzats a cada acció de l'usuari, és a dir s'han d'autoguardar.

Al iniciar el programa s'han de llegir els arxius *".json"* per carregar les dades a memòria.

**Formats**: Tingues en compte que:
    
* Les opcions del menú han de ser insensibles a majúscules/minúscules (per exemple, "llibres", "Llibres", "LLIBRES").
* Els llistats han de mostrar les dades en format tabulat per facilitar la lectura, és a dir columnes amb les dades de cada taula.

**Gestió d'Errors**: L'aplicació ha de gestionar situacions errònies amb *try/catch*:

* Intentar prestar un llibre ja prestat.
* Intentar assignar més de 4 préstecs a un usuari (no permès)
* Dates no vàlides (en format YYYY-MM-DD)
* Que els identificadors siguin únics
* Els camps com Id, Titol, Nom, Cognoms, i Telèfon no poden estar buits.
* El camp Telèfon ha de ser numèric i tenir un format vàlid.
    
Quan es produeix una excepció s'ha d'informar a l'usuari de l'apicació i gestionar-la sense que falli l'aplicació, permetent continuar treballant normalment.

## Requeriments de codi

Cal que feu un projecte a *GitHub* i treballeu els dos companys de manera paral·lela:

- Cal una branca principal *"main"* que serà la d'entrega
- Calen branques per cada funcionalitat (tasca) per anar treballant de manera paral·lela
- Cal fer *pull request* per integrar els canvis de les branques a la principal, i que un dels dos revisi i accepti els canvis.

Escriviu missatges de commit descriptius:

```text
feat: Afegir funcionalitat de validació de dades
feat: Implementar cerca de llibres per paraula clau al títol
fix: Corregir error en la validació de dates de préstecs
fix: Solucionar error en el càlcul de llibres fora de termini
refactor: Reestructurar el mètode d'escriptura de fitxers JSON
refactor: Simplificar les condicions del menú principal
style: Canviar el nom de variables per seguir la convenció camelCase
style: Canviar estil de format de switch-case
...
```

Documenteu les funcions amb el format de Java:

```java
/**
 * Explicació del què fa la funció.
 * 
 * @param nomParametre0 perquè serveix el paràmetre
 * @param nomParametre1 perquè serveix el paràmetre
 * @return tipusRetorn explicació del valor de retorn.
 */
```

**Nota**: Recordeu que en Java els noms dels mètodes i variables començen per minúscula i són tipus *camelCase*.

## Treball en equip

El projecte s'ha de fer segons els següents equips, teniu en compte que:

- No val fer mig projecte i dir que l'altre company no ha fet res
- No val fer tot el projecte i esperar que els companys l'acceptin
- Cal que els tots companys treballeu en el projecte 
- Cal que els tots companys feu commits regularment
- Cal que tots pogueu respondre a les preguntes de l'avaluació de qualsevol part del projecte

### GitHub projects

Feu servir **GitHub projects** per gestionar les tasques que va fent cada membre de l'equip.

- Fer un llistat de totes les tasques que heu de fer
- Ordenar les tasques segons dependències entre tasques (quines s'han de fer primer)
- Definir una data estimada de quan estarà feta cada tasca
- No repartir quines tasques fa cada company, sinó anar resolent segons la llista anterior a mida que es van tancant tasques resoltes
- Fer un seguiment de les tasques resoltes segons l'estimació inicial 

<br/>
<br/>

| Equips | Alumne 0 | Alumne 1 | Alumne 2 |
|-------|----------|----------|----------|
| 0     | Prieto, Víctor | El Meftah, Sabrina |
| 1     | Cardizales, Hector | Pozo, Asier | Santana, Valeria |
| 2     | Asensio, Víctor | Martínez, Samantha | Clemente, Gracia |
| 3     | Bermudez, Alex | Lopez, Javier | Fernandez, Denís |
| 4     | Maestre, Dennis | Navarrete, Byron | Paz, Paula |
| 5     | Marin, Biel | Hirsch, Daniel | Romero, Ruth
| 6     | Carrillo, Christopher | Maqueda, Jordi | Bargados, David
| 7     | Perez, Albert | Garcia, Steephen |
| 8     | Martínez, Alex


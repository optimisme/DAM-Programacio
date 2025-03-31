# Exercici 0600

Fes un programa JavaFX amb dues vistes:

**Vista Fitxa**: Ha de mostrar la fitxa amb les dades d'un personatge reconegut. Carregat a partir d'un arxiu *.json*. Ha de contenir:

- Nom
- Activitat
- Data de naixament
- Text explicatiu
- Foto

**Vista Formulari**: Ha de mostar un formulari per modificar els camps anteriors i guardar les noves dades a l'arxiu *.json*

Prepara almenys tres arxius *.json* que es poden llegir/escriure amb l'aplicació anterior:

- **./data/music.json** amb la informació d'un músic
- **./data/cientific.json** amb la informació d'un científic
- **./data/esportista.json** amb la informació d'un esportista

Comprova que els tres arxius *.json* es poden obrir i modificar amb l'aplicació.

Guarda les imatges a la carpeta: **"src/main/resources/assets/images0600/"**

# Exercici 0601

Modifica el codi de la carpeta **'exercici0601'** i afegeix els arxius necessaris a la carpeta **'assets'**, per tal de fer una aplicació *JavaFX* semblant (no igual) a la següent demo:

<center>
<video width="275" height="480" controls>
  <source src="./assets/viewPreview.mov" type="video/mp4">
  El teu navegador no suporta la reproducció de vídeo.
</video>
</center>

Cal fer servir la informació de **'assets/data'** i les imatges de **'assets/images'**

# Exercici 0602

Modifica el codi de l'exercici 0602 per tal de tenir una aplicació que permet gestionar una base de dades de pokémons.

Fes servir la següent comanda per construir la base de dades '.sqlite' a partir de l'arxiu '.json':

```java
./run.sh com.exercici0602.BuildDatabase
```

Fes servir la següent comanda per executar l'aplicació:
```java
./run.sh com.exercici0602.Main
```

L'aplicació ha de tenir tres vistes:

- **viewPokeList**: mostra la llista de Pokémons a partir d'una 'subview' per cada Pokémon. 

  - Quan es fa click a un element de llista es navega a la fitxa d'aquell Pokémon. 
  
  - Té el botó 'Add' per afegir un nou Pokémon a la llista.

- **viewPokeCard**: mostra la fitxa d'un Pokémon (i la seva imatge). 

  - Té el botó 'Delete' per esborrar el Pokémon de la llista, 
  
  - Té el botó 'Edit' per modificar-ne la informació, anant a la vista 'viewPokeForm'.
  
  - I té fletxes 'Previous' i 'Next' per recórrer les fitxes de tots els Pokémons sense tornar a la vista 'viewPokeList'.

  - Té un botó 'Back' per tornar a la vista 'viewPokeList'.

- **viewPokeForm**: permet afegir un nou Pokémon o editar les dades d'un existent.

  - Si s'afegeix, no mostra l'identificador. I mostra un botó 'Add'

  - Si s'edita la informació d'un Pokémon que ja existeix, mostra el botó 'Update'.

  - Té un botó 'Back' per tornar a la vista 'viewPokeCard'.

  - Permet escollir una imatge ".png" del sistema operatiu, i la copia a la carpeta 'data/pokeImages' renombrant-la amb el nom del Pokémon sense espais.
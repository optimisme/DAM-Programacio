
# Fer anar els testos amb:
# python "17b Test entrenament examen 3.py"


"""

Exercici 0

Escriu una funció genera_info_canco que faci el següent:

Paràmetres:

titols (opcional): Una llista de cadenes de text, cada una representant el títol d'una cançó. Si no es proporciona, es considera que no hi ha títols disponibles.
artistes: Una llista de cadenes de text, cada una representant l'artista d'una cançó.
duracio (opcional): Una llista d'enters, cada un representant la duració de la cançó en minuts. Si no es proporciona, es considera que no hi ha informació de duració disponible.
Validacions:

Si titols no és None i tampoc una llista, llença una TypeError amb el missatge 'titols ha de ser una llista o None'.
Si artistes no és una llista, llença una TypeError amb el missatge 'artistes ha de ser una llista'.
Si duracio no és None i tampoc una llista, llença una TypeError amb el missatge 'duracio ha de ser una llista o None'.
Si titols, artistes i duracio són proporcionades, totes han de tenir la mateixa longitud. Si no, llença una ValueError amb el missatge 'Totes les llistes proporcionades han de tenir la mateixa longitud'.

Funcionalitat:

La funció ha de retornar una llista de cadenes de text. Cada cadena ha d'incloure l'artista, i si estan disponibles, el títol de la cançó i la duració.
Per exemple, si una cançó té un títol i una duració, la cadena podria ser: "Artista 1 - Cançó 1 - 3 minuts". Si no hi ha informació de títol o duració, aquests elements s'ometran.

Exemple de Sortida:

Si titols = ['Cançó 1', 'Cançó 2'], artistes = ['Artista 1', 'Artista 2'], i duracio = [3, 4], la funció hauria de retornar ["Artista 1 - Cançó 1 - 3 minuts", "Artista 2 - Cançó 2 - 4 minuts"].
Si només es proporciona artistes = ['Artista 1', 'Artista 2'], la sortida seria ["Artista 1", "Artista 2"].

"""

# Resol aquí el codi de l'exercici 0


"""

Exercici 1

Escriu una funció suma_llistes que compleixi les següents especificacions:

Paràmetres:

La funció accepta un nombre indeterminat de llistes de números enters, però com a mínim se n'han de passar 2.
Funcionalitat:

La funció ha de retornar una llista on cada element és la suma dels elements corresponents de totes les llistes passades com a paràmetres.
Si les llistes no tenen la mateixa longitud, omplir amb zeros els valors mancants de les llistes més curtes.

Excepcions:

Si la longitud dels paràmetres és menor que 2, la funció ha de llançar una excepció de tipus ValueError amb el missatge 'suma_llistes necessita almenys 2 llistes'.
Si algun dels paràmetres no és una llista de números enters, la funció ha de llançar una excepció de tipus TypeError amb el missatge 'tot els paràmetres han de ser llistes de números enters'.

Exemple:

Si la funció rep ([1, 2, 3], [4, 5, 6], [7, 8]), hauria de retornar [12, 15, 9] (ja que la tercera llista es consideraria [7, 8, 0]).

"""

# Resol aquí el codi de l'exercici 1


"""

Exercici 2

Crea la funció 'mostra_info_params' que haurà de rebre un nombre indeterminat de paràmetres amb nom i tornar un string amb la informació avançada de cada paràmetre:

Paràmetres:

La funció ha de rebre un nombre indeterminat de paràmetres amb nom.

Funcionalitat:

La funció ha de generar una cadena de text que llisti, per a cada paràmetre, el seu nom, si el seu valor és numèric o no, i el seu valor.
El format ha de ser "nom: és numèric? - valor". Per a determinar si el valor és numèric, considera els tipus int, float i complex.
Utilitza "sí" si el valor és numèric i "no" si no ho és.

Exemple:

Si la funció rep a=1, b="text", c=[1, 2, 3], d=3.14, hauria de tornar:

a: sí - 1
b: no - text
c: no - [1, 2, 3]
d: sí - 3.14

"""

# Resol aquí el codi de l'exercici 2


"""

Exercici 3

Escriu una funció recursiva 'combina_unics_recursiu' que rep dues llistes com a paràmetres i retorna una llista amb els elements que són únics a cada llista.

Paràmetres:

La funció accepta dues llistes com a paràmetres.

Funcionalitat:

La funció ha de retornar una llista amb els elements que només apareixen en una de les dues llistes, és a dir, elements que no estan repetits entre ambdues llistes.
La funció ha de ser recursiva.

Exemple:

Si la funció rep ([1, 2, 3, 4, 5], [2, 4, 6, 8, 10]), hauria de retornar [1, 3, 5, 6, 8, 10], ja que aquests són els elements que no es repeteixen entre les dues llistes.

"""

# Resol aquí el codi de l'exercici 3

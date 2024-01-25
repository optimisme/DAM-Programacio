
# Fer anar els testos amb:
# python "17b Test entrenament examen 3.py"
# python "17b Test entrenament examen 3 - e5.py"

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

def genera_info_canco(titols=None, artistes=None, duracio=None):
    # Validacions
    if titols is not None and not isinstance(titols, list):
        raise TypeError('titols ha de ser una llista o None')
    if artistes is not None and not isinstance(artistes, list):
        raise TypeError('artistes ha de ser una llista')
    if duracio is not None and not isinstance(duracio, list):
        raise TypeError('duracio ha de ser una llista o None')

    # Comprova que totes les llistes (si estan proporcionades) tinguin la mateixa longitud
    if titols is not None and duracio is not None and len(titols) != len(duracio):
        raise ValueError('Totes les llistes proporcionades han de tenir la mateixa longitud')
    if artistes is not None and duracio is not None and len(artistes) != len(duracio):
        raise ValueError('Totes les llistes proporcionades han de tenir la mateixa longitud')
    if artistes is not None and titols is not None and len(artistes) != len(titols):
        raise ValueError('Totes les llistes proporcionades han de tenir la mateixa longitud')

    # Genera la llista de informació de les cançons
    info_canco = []
    if artistes is not None:
        for i in range(len(artistes)):
            info = artistes[i]
            if titols is not None and i < len(titols):
                info += f" - {titols[i]}"
            if duracio is not None and i < len(duracio):
                info += f" - {duracio[i]} minuts"
            info_canco.append(info)

    return info_canco

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

def suma_llistes(*llistes):
    # Comprova si hi ha almenys 2 llistes
    if len(llistes) < 2:
        raise ValueError('suma_llistes necessita almenys 2 llistes')

    # Comprova si tots els paràmetres són llistes de números enters
    for llista in llistes:
        if not all(isinstance(elem, int) for elem in llista):
            raise TypeError('tot els paràmetres han de ser llistes de números enters')

    # Troba la longitud màxima de les llistes
    max_length = max(len(llista) for llista in llistes)

    # Inicialitza la llista de resultats
    suma = [0] * max_length

    # Suma els elements de totes les llistes
    for llista in llistes:
        for i in range(len(llista)):
            suma[i] += llista[i]

        # Omplir amb zeros si la llista és més curta que la màxima longitud
        for i in range(len(llista), max_length):
            suma[i] += 0

    return suma

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

def mostra_info_params(**kwargs):
    result = []
    for param_name, value in kwargs.items():
        # Determina si el valor és numèric (int, float, complex)
        es_numeric = isinstance(value, (int, float, complex))

        # Afegeix la informació al resultat
        result.append(f"{param_name}: {'sí' if es_numeric else 'no'} - {value}")

    # Uneix tots els elements en un string, separats per salts de línia
    return '\n'.join(result)

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

def combina_unics_recursiu(llista1, llista2):
    # Cas base: si una de les llistes està buida, retorna l'altra llista completa
    if not llista1:
        return [x for x in llista2 if x not in llista1]
    if not llista2:
        return [x for x in llista1 if x not in llista2]

    # Prendre el primer element de la primera llista
    cap = llista1[0]

    # Si el cap no està en la segona llista, l'afegim a la llista resultant
    if cap not in llista2:
        return [cap] + combina_unics_recursiu(llista1[1:], llista2)
    else:
        # Si el cap està en la segona llista, l'ometem i seguim amb la resta de la llista
        return combina_unics_recursiu(llista1[1:], [x for x in llista2 if x != cap])


"""

Exercici 4

Fes una funció auto_menu que opera de la següent manera:

Entrada:

La funció ha de rebre un nombre indeterminat de paràmetres.
Els paràmetres han de ser de tipus numèric (per exemple, int, float).

Funcionament:

La funció ha de generar un menú a partir dels paràmetres rebuts. Cada paràmetre representa una opció en el menú.
Exemple de menú generat:

Options:
1. Option amb valor 5
2. Option amb valor 8
3. Option amb valor 14
4. Option amb valor 19
0. Sortir
Choose an option or a value:

Condicions i Excepcions:

Si es rep un paràmetre que no és de tipus numèric, la funció ha de llançar una excepció TypeError amb el missatge: 'auto_menu requires numeric parameters only'.
Si es reben més de 4 paràmetres, la funció ha de llançar una excepció genèrica amb el missatge: 'auto_menu supports a maximum of 4 options'.
Si l'usuari escull un número que no correspon a una opció vàlida (incloent opcions fora del rang definit pels paràmetres), la funció ha de llançar una excepció IndexError amb el missatge: 'auto_menu invalid option'.
Si l'usuari escull una opció vàlida (excepte 0), la funció ha de retornar el valor numèric associat a aquesta opció.
Si l'usuari escull 0, la funció finalitza normalment sense llançar cap excepció.

"""

# Resol aquí el codi de l'exercici 4

def auto_menu(*args):
    # Comprova si tots els arguments són numèrics
    if not all(isinstance(arg, (int, float)) for arg in args):
        raise TypeError('auto_menu requires numeric parameters only')

    # Comprova si hi ha més de 4 arguments
    if len(args) > 4:
        raise Exception('auto_menu supports a maximum of 4 options')

    # Mostra les opcions del menú
    print("Options:")
    for i, value in enumerate(args, start=1):
        print(f"{i}. Option amb valor {value}")
    print("0. Sortir")
    
    # Llegeix l'opció de l'usuari
    user_choice = int(input("Choose an option or a value:"))

    if user_choice == 0:
        return "Sortida"
    elif 1 <= user_choice <= len(args):
        return args[user_choice - 1]
    else:
        raise IndexError('auto_menu invalid option')

"""

Exercici 5

Escriu una funció calculadora_basica que accepta tres paràmetres:

Un enter x.
Un enter y.

Una cadena de text que representa una operació matemàtica: suma, resta

La funció ha de retornar el resultat de l'operació especificada amb els dos enters. Si s'intenta una divisió per zero, la funció ha de retornar None.

A més, la funció ha de complir amb els següents requisits de maneig d'errors:

Si el primer o el segon paràmetre no són enters, llença una excepció TypeError amb el missatge 'calculadora_basica: els paràmetres 1 i 2 han de ser enters'.
Si el tercer paràmetre no és una cadena de text, llença una excepció TypeError amb el missatge 'calculadora_basica: el paràmetre 3 no és una cadena de text'.
Si l'operació especificada no és suma, resta, llença una excepció ValueError amb el missatge 'calculadora_basica: operació no vàlida'.

Exemples d'ús:

calculadora_basica(5, 3, 'suma') retorna 8
calculadora_basica(5, 3, 'resta') retorna 2
calculadora_basica(3, 3, 'suma') retorna 6
calculadora_basica(2, 3, 'resta') retorna -1

"""

def calculadora_basica(x, y, operacio):
    # Comprovar si els paràmetres x i y són enters
    if not isinstance(x, int) or not isinstance(y, int):
        raise TypeError('calculadora_basica: els paràmetres 1 i 2 han de ser enters')

    # Comprovar si el paràmetre operacio és una cadena de text
    if not isinstance(operacio, str):
        raise TypeError('calculadora_basica: el paràmetre 3 no és una cadena de text')

    # Realitzar la operació especificada
    if operacio == 'suma':
        return x + y
    elif operacio == 'resta':
        return x - y
    else:
        # Llençar una excepció si l'operació no és ni suma ni resta
        raise ValueError('calculadora_basica: operació no vàlida')



"""

Exercici 6 

Escriu una funció recursiva recursive_difference que rep dues llistes com a paràmetres i retorna una llista amb els elements que estan a la primera llista però no a la segona.

La funció ha de seguir aquests passos:

Si la primera llista està buida, retorna una llista buida.
Si el primer element de la primera llista no es troba a la segona llista, inclou aquest element a la llista que retornaràs.
Fes una crida recursiva a la funció amb la resta de la primera llista (és a dir, tots els elements menys el primer) i la segona llista completa.
Afegeix els elements retornats per la crida recursiva a la llista que estàs construint.

Per exemple:

recursive_difference([1, 2, 3, 4, 5], [2, 4, 6, 8, 10])
Retorna: [1, 3, 5]

"""

def recursive_difference(list1, list2):
    # Cas base: si la primera llista està buida, retorna una llista buida
    if not list1:
        return []

    # Prendre el primer element de la primera llista
    first_element = list1[0]

    # Comprovar si el primer element no està a la segona llista
    if first_element not in list2:
        # Incloure l'element a la llista resultant i fer una crida recursiva amb la resta de la llista
        return [first_element] + recursive_difference(list1[1:], list2)
    else:
        # Fer una crida recursiva sense incloure l'element actual
        return recursive_difference(list1[1:], list2)


"""
Exercici 7

Fes la funció "suma_profunditat" que a partir d'un arbre d'aquest estil:
        avl = {
            "node": "5",
            "esquerra": {
                "node": "2",
                "esquerra": None,
                "dreta": None
            },
            "dreta": {
                "node": "4",
                "esquerra": None,
                "dreta": None
            }
        }

Suma al valor de cada node, la profunditat dés d'aquell node.

Per exemple, en aquest cas, el resultat seria:

        avl = {
            "node": "7",
            "esquerra": {
                "node": "3",
                "esquerra": None,
                "dreta": None
            },
            "dreta": {
                "node": "5",
                "esquerra": None,
                "dreta": None
            }
        }

"""

def suma_profunditat(arbre, profunditat_actual=0):
    # Si l'arbre està buit, retorna 0
    if arbre is None:
        return 0

    # Sumar la profunditat actual al node actual
    suma_actual = profunditat_actual

    # Sumar recursivament la profunditat dels subarbres esquerra i dret
    suma_esquerra = suma_profunditat(arbre["esquerra"], profunditat_actual + 1)
    suma_dreta = suma_profunditat(arbre["dreta"], profunditat_actual + 1)

    # Retornar la suma total
    return suma_actual + suma_esquerra + suma_dreta

"""

Exercici 8:

Crea dues funcions error_log i error_process que generin i gestionin errors específics:

Funció error_log: Aquesta funció ha de generar diferents tipus d'excepcions basades en l'entrada:

Si l'entrada és un string 'a', genera una TypeError amb el missatge 'error_log TypeError'.
Si l'entrada és un string 'b', genera una KeyError amb el missatge 'error_log KeyError'.

Funció error_process: Aquesta funció ha de rebre una funció com a paràmetre i cridar-la dues vegades: una amb l'entrada 'a' i una altra amb 'b'.

Si es captura una excepció TypeError, imprimeix el missatge 'error_process TypeError'.
Si es captura una excepció KeyError, imprimeix el missatge 'error_process KeyError'.

"""

def error_log(input_value):
    """Genera excepcions basades en l'entrada."""
    if input_value == 'a':
        raise TypeError('error_log TypeError')
    elif input_value == 'b':
        raise KeyError('error_log KeyError')

def error_process(func):
    """Crida la funció func amb diferents valors i gestiona les excepcions."""
    try:
        func('a')
    except TypeError:
        print('error_process TypeError')

    try:
        func('b')
    except KeyError:
        print('error_process KeyError')


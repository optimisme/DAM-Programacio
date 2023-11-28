
# Executa el test amb
# python "12d TestArbres.py"

animals = {
    "node": "gat",
    "esquerra": {
        "node": "gossos",
        "esquerra": {
            "node": "conill",
            "esquerra": {
                "node": "hamster",
                "esquerra": None,
                "dreta": {
                    "node": "porquet d'Índia",
                    "esquerra": None,
                    "dreta": None
                }
            },
            "dreta": {
                "node": "cobai",
                "esquerra": None,
                "dreta": None
            }
        },
        "dreta": {
            "node": "tortuga",
            "esquerra": {
                "node": "iguana",
                "esquerra": None,
                "dreta": None
            },
            "dreta": {
                "node": "dragó barbut",
                "esquerra": None,
                "dreta": None
            }
        }
    },
    "dreta": {
        "node": "ocell",
        "esquerra": {
            "node": "papagai",
            "esquerra": None,
            "dreta": None
        },
        "dreta": {
            "node": "canari",
            "esquerra": None,
            "dreta": None
        }
    }
}

plats = {
    "node": "paella",
    "esquerra": {
        "node": "pasta",
        "esquerra": None,
        "dreta": {
            "node": "risotto",
            "esquerra": None,
            "dreta": None
        }
    },
    "dreta": {
        "node": "hamburguesa",
        "esquerra": {
            "node": "pizza",
            "esquerra": None,
            "dreta": None
        },
        "dreta": None
    }
}

planetes = {
    "node": "Terra",
    "esquerra": {
        "node": "Marte",
        "esquerra": {
            "node": "Fobos",
            "esquerra": None,
            "dreta": None
        },
        "dreta": {
            "node": "Deimos",
            "esquerra": None,
            "dreta": None
        }
    },
    "dreta": {
        "node": "Júpiter",
        "esquerra": {
            "node": "Io",
            "esquerra": None,
            "dreta": {
                "node": "Europa",
                "esquerra": None,
                "dreta": None
            }
        },
        "dreta": {
            "node": "Ganimedes",
            "esquerra": None,
            "dreta": None
        }
    }
}

numeros = {
    "node": 15,
    "esquerra": {
        "node": 10,
        "esquerra": {
            "node": 7,
            "esquerra": None,
            "dreta": None
        },
        "dreta": {
            "node": 12,
            "esquerra": {
                "node": 11,
                "esquerra": None,
                "dreta": None
            },
            "dreta": None
        }
    },
    "dreta": {
        "node": 20,
        "esquerra": {
            "node": 17,
            "esquerra": None,
            "dreta": None
        },
        "dreta": {
            "node": 25,
            "esquerra": None,
            "dreta": None
        }
    }
}


"""
Pregunta 0
Fes una funció recursiva compta_nodes(arbre) que compti el nombre total de nodes en un arbre binari.
"""
def compta_nodes(arbre):
    if not arbre:
        return 0
    return 1 + compta_nodes(arbre['esquerra']) + compta_nodes(arbre['dreta'])


"""
Pregunta 2
Fes una funció recursiva troba_max_min(arbre) que retorni el valor màxim i mínim node en un arbre binari. 
Assumeix que tots els nodes tenen valors numèrics.
"""
def troba_max_min(arbre):
    if not arbre:
        return float('-inf'), float('inf')

    esquerra_max, esquerra_min = troba_max_min(arbre['esquerra'])
    dreta_max, dreta_min = troba_max_min(arbre['dreta'])
    maxim = max(arbre['node'], esquerra_max, dreta_max)
    minim = min(arbre['node'], esquerra_min, dreta_min)

    return maxim, minim


"""
Pregunta 3
Fes una funció recursiva camí_a_node(arbre, valor) que retorni el camí des de l'arrel 
fins a un node específic (donat per un valor). El camí pot ser representat 
com una llista de valors des de l'arrel fins al node.
"""
def cami_a_node(arbre, valor, cami=[]):
    if not arbre:
        return None
    if arbre['node'] == valor:
        return cami + [arbre['node']]

    esquerra = cami_a_node(arbre['esquerra'], valor, cami + [arbre['node']])
    dreta = cami_a_node(arbre['dreta'], valor, cami + [arbre['node']])

    return esquerra or dreta

"""
Pregunta 4
Fes una funció recursiva suma_nivell(arbre, nivell) que sumi els valors 
de tots els nodes que es troben a un cert nivell en un arbre binari.
"""
def suma_nivell(arbre, nivell):
    if not arbre or nivell < 0:
        return 0
    if nivell == 0:
        return arbre['node']
    return suma_nivell(arbre['esquerra'], nivell - 1) + suma_nivell(arbre['dreta'], nivell - 1)

"""
Pregunta 5
Fes una funció recursiva espelma_arbre(arbre) que inverteixi l'arbre, 
de manera que tots els nodes d'esquerra esdevinguin nodes de dreta i viceversa.
"""
def espelma_arbre(arbre):
    if not arbre:
        return None

    # Espelma els subarbres
    tmp = arbre['esquerra']
    arbre['esquerra'] = arbre['dreta']
    arbre['dreta'] = tmp

    espelma_arbre(arbre['esquerra'])
    espelma_arbre(arbre['dreta'])

    return arbre


"""
Pregunta 6
Fes una funció recursiva nivell_node(arbre, valor) que trobi el nivell (profunditat) 
d'un node específic (donat per un valor) en l'arbre. La profunditat de l'arrel és 0, 
els fills de l'arrel són nivell 1, etc. Si el node no es troba a l'arbre, retorna -1.
"""
def nivell_node(arbre, valor, nivell_actual=0):
    if not arbre:
        return -1
    if arbre['node'] == valor:
        return nivell_actual

    nivell_esquerra = nivell_node(arbre['esquerra'], valor, nivell_actual + 1)
    if nivell_esquerra != -1:
        return nivell_esquerra

    return nivell_node(arbre['dreta'], valor, nivell_actual + 1)


"""
Pregunta 7
Fes una funció recursiva es_arbre_cerca(arbre) que comprovi si un arbre binari és un 
arbre de cerca binari. En un arbre de cerca binari, tots els nodes a l'esquerra d'un 
node són menors que el node, i tots els nodes a la dreta són majors.
"""
def es_arbre_cerca(arbre, minim=float('-inf'), maxim=float('inf')):
    if not arbre:
        return True
    if arbre['node'] < minim or arbre['node'] > maxim:
        return False
    return (es_arbre_cerca(arbre['esquerra'], minim, arbre['node']) and
            es_arbre_cerca(arbre['dreta'], arbre['node'], maxim))


"""
Pregunta 8
Fes una funció recursiva mirall_arbre(arbre) que retorni el "mirall" o "reflex" d'un arbre binari. 
Aquesta funció ha d'invertir l'arbre de manera que tots els nodes d'esquerra siguin 
intercanviats amb els seus corresponents de dreta a tots els nivells.
"""
def mirall_arbre(arbre):
    if not arbre:
        return None

    # Assignar els subarbres a variables temporals
    subarbre_esquerra = None
    subarbre_dreta = None

    if 'esquerra' in arbre:
        subarbre_esquerra = arbre['esquerra']
    if 'dreta' in arbre:
        subarbre_dreta = arbre['dreta']

    # Intercanviar els subarbres
    arbre['esquerra'] = subarbre_dreta
    arbre['dreta'] = subarbre_esquerra

    # Mirall dels subarbres
    if arbre['esquerra']:
        mirall_arbre(arbre['esquerra'])
    if arbre['dreta']:
        mirall_arbre(arbre['dreta'])

    return arbre


"""
Pregunta 9
Fes una funció recursiva suma_cami_fulles(arbre) que calculi la suma de tots els valors 
des de l'arrel fins a cada fulla. La funció ha de retornar la llista de totes 
les sumes de camins de l'arrel a les fulles.
"""
def suma_cami_fulles(arbre, suma_actual=0):
    if not arbre:
        return []
    suma_actual += arbre['node']
    if not arbre['esquerra'] and not arbre['dreta']:
        return [suma_actual]
    return (suma_cami_fulles(arbre['esquerra'], suma_actual) +
            suma_cami_fulles(arbre['dreta'], suma_actual))

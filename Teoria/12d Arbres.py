
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

"""
Pregunta 2
Fes una funció recursiva troba_max_min(arbre) que retorni el valor màxim i mínim node en un arbre binari. 
Assumeix que tots els nodes tenen valors numèrics.
"""

"""
Pregunta 3
Fes una funció recursiva camí_a_node(arbre, valor) que retorni el camí des de l'arrel 
fins a un node específic (donat per un valor). El camí pot ser representat 
com una llista de valors des de l'arrel fins al node.
"""


"""
Pregunta 4
Fes una funció recursiva suma_nivell(arbre, nivell) que sumi els valors 
de tots els nodes que es troben a un cert nivell en un arbre binari.
"""

"""
Pregunta 5
Fes una funció recursiva espelma_arbre(arbre) que inverteixi l'arbre, 
de manera que tots els nodes d'esquerra esdevinguin nodes de dreta i viceversa.
"""

"""
Pregunta 6
Fes una funció recursiva nivell_node(arbre, valor) que trobi el nivell (profunditat) 
d'un node específic (donat per un valor) en l'arbre. La profunditat de l'arrel és 0, 
els fills de l'arrel són nivell 1, etc. Si el node no es troba a l'arbre, retorna -1.
"""

"""
Pregunta 7
Fes una funció recursiva es_arbre_cerca(arbre) que comprovi si un arbre binari és un 
arbre de cerca binari. En un arbre de cerca binari, tots els nodes a l'esquerra d'un 
node són menors que el node, i tots els nodes a la dreta són majors.
"""

"""
Pregunta 8
Fes una funció recursiva mirall_arbre(arbre) que retorni el "mirall" o "reflex" d'un arbre binari. 
Aquesta funció ha d'invertir l'arbre de manera que tots els nodes d'esquerra siguin 
intercanviats amb els seus corresponents de dreta a tots els nivells.
"""


"""
Pregunta 9
Fes una funció recursiva suma_cami_fulles(arbre) que calculi la suma de tots els valors 
des de l'arrel fins a cada fulla. La funció ha de retornar la llista de totes 
les sumes de camins de l'arrel a les fulles.
"""


# Exercici 0400

En aquest exercici cal fer una llibreria que permeti mostrar textos, taules i menús en una consola de text.

Calen les següents interfícies:

- **Renderable**: amb un mètode **ArrayList<String> render()** que retorna les cadenes de text que formen el component.
- **Alignable**: amb els mètodes **getAlign()** i **setAlign()** que gestionen l'alignació.

Tindrà les següents classes:

- **Component**: tots els components de la interfície deriven d'aquesta classe. Té:

    * Atributs **x** i **y**, **width** i **height** que indiquen la posició i mida del component
    * Atribut **title** que és el títol que es mostra a la part superior del marc
    * Un metode 'abstracte' **render()** que mostra el component per pantalla, i han d'implementar totes les classes que heredin d'aquesta.

    El component ha de quedar emarcat en un quadre format pels caràcters ascii: 

```text 
┌titol─┐                     
│      │                     
│      │            
└──────┘
```

    * *Component* Implementa *Renderable*

- **Text**: mostra un text per pantalla. Té:

    * Atribut **text** que és el text a mostrar
    * Atribut privat **align** que indica l'alignació del text ("left", "right", "center")

    * *Text* Implementa *Alignable*
    * *Text* deriva de *Component*

- **MenuItem**: conté informació d'un ítem de menu. Té:

    * Atribut **title** el text que es mostra per pantalla
    * Atribut **keyWords** les paraules claus que activen aquella opció.

    * Mètode **isInKeyWords** que rep com a paràmetre un text i retorna true si està dins del keyWords.

    * **Atenció!** No deriva de cap altre objecte!

- **Menu**: mostra un menú per pantalla. Té:

    * Atribut **title** que és el títol del menú
    * Atribut **items** que és un HashMap amb els **MenuItem** del menú organitzats per un enter que és la clau. 
    * Atribut **lastZero** booleà que indica si la opció 0 és la última a mostrar-se.

    * Mètode **getSelection** que rep com a paràmetre un text i retorna un enter amb la opció seleccionada. El text pot contenir un número o una paraula clau que ajuda a escollir la opció. Si retorna -1 és que no s'ha identificat cap opció.

    * *Menu* deriva de *Component*

- **Table**: mostra una taula per pantalla. Té:

    * Atribut **headers** que és una llista amb els noms de les columnes
    * Atribut **widths** que és una llista amb l'amplada de les columnes
    * Atribut **aligns** que és una llista amb l'alignació de les columnes
    * Atribut **rows** que és una llista de llistes amb les dades de les files

    * *Table* deriva de *Component*

```text 
headers: "col0", "col1", "col2"
widths: 5, 6, 7
aligns: "left", "right" i "center"
rows: [["1a", "hola", "si"], ["2a", "hi", "out"], ["3b", "hej", "amws"]]

La taula esperada és:
┌titol──────────────┐                     
│col0 |  col1| col2 │  
│─────┼──────┼──────│                 
│1a   |  hola|  si  │ 
│2a   |    hi|  out │  
│3b   |   hej| amws │            
└───────────────────┘
```

- **Container**: conté una llista de components. Té:

    * Atribut **components** que és una llista de components.
    * Metode **draw** que dibuixa el *buffer* a la terminal, primer fa un *clearScreen* i després dibuixa cada linia del *buffer*.

    * *Container* deriva de *Component*, el seu constructor inicia x,y a (0,0) amb titol a "". 
    * El seu mètode **render()** posiciona els *render* de tots els components en un buffer. 

- **Input**: mostra un quadre on es pot entrar text. Té:

    * Atribut **label** amb un text descriptiu previ a l'entrada de text (en una sola línia)
    * Mètode **getInput** que rept un *Scanner* i retorna el text entrat amb *nextLine()*

    * **Atenció!** No deriva de cap altre objecte!

**Aleshores**:

Fes una aplicació que divideixi un espai de 60x20 en dos, a la part esquerra hi ha un menú amb tres opcions:

1. Mostrar text
2. Mostrar taula
3. Sortir

A la part dreta es mostra el text "Escull una opció".

A la part inferior, de tots dos espais, hi ha un *Input* amb el text "Escull una opció: "

Un cop escollida una opció:

A la part dreta es mostra, segons la opció escollida:

1. Un text amb el text "Hola món!"
2. Una taula amb tres columnes i tres files amb dades de prova

Dins d'una opció escollida, a la part esquerra el menú mostra:

1. Aliniat a l'esquerra
2. Aliniat al centre
3. Aliniat a la dreta
0. Tornar

I modifica el text o textos de la taula segons l'opció escollida.
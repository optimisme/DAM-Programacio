
# Exercici 0400

En aquest exercici cal fer una llibreria que permeti mostrar textos, taules i menús en una consola de text.

Calen les següents interfícies:

- **Renderable**: amb un mètode **render()** que mostra el component per pantalla.
- **Alignable**: amb els mètodes **getAlign()** i **setAlign()** que gestionen l'alignació.

Tindrà les següents classes:

- **Component**: tots els components de la interfície deriven d'aquesta classe. Té:

    * Atributs **x** i **y**, **width** i **height** que indiquen la posició i mida del component
    * Un metode 'abstracte' **render()** que mostra el component per pantalla, i han d'implementar totes les classes que heredin d'aquesta.
    Es dibuixen '*' al voltant del component, i es retallen els seus continguts si no hi caben.

    * *Component* Implementa *Renderable*

- **Text**: mostra un text per pantalla. Té:

    * Atribut **text** que és el text a mostrar
    * Atribut **truncate** enter les linies màximes del text
    * Atribut **ellipsis** booleà que afegeix ... si el text no hi cap sencer
    * Atribut privat **align** que indica l'alignació del text (esquerra, dreta, centre)

    * *Text* Implementa *Alignable*
    * *Text* deriva de *Component*

- **Menu**: mostra un menú per pantalla. Té:

    * Atribut **title** que és el títol del menú
    * Atribut **items** que és un HashMap amb els items del menú organitzats per un enter que és la clau. Els ítems del menú han de contenir el text a mostrar i una llista de paraules claues que poden ser seleccionades.
    * Atribut **lastZero** booleà que indica si la opció 0 és la última a mostrar-se.

    * Mètode **getSelection** que rep com a paràmetre un text i retorna un enter amb la opció seleccionada. El text pot contenir un número o una paraula clau que ajuda a escollir la opció. Si retorna -1 és que no s'ha identificat cap opció.

    * *Menu* deriva de *Component*

- **Table**: mostra una taula per pantalla. Té:

    * Atribut **headers** que és una llista amb els noms de les columnes
    * Atribut **widths** que és una llista amb l'amplada de les columnes
    * Atribut **aligns** que és una llista amb l'alignació de les columnes
    * Atribut **rows** que és una llista de llistes amb les dades de les files

    * *Table* deriva de *Component*

- **Input**: mostra un quadre on es pot entrar text. Té:

    * Atribut **label** amb un text descriptiu previ a l'entrada de text (en una sola línia)
    * Mètode **getInput** que rept un *Scanner* i retorna el text entrat amb *nextLine()*

- **Container**: conté una llista de components. Té:

    * Atribut **components** que és una llista de components.

    * *Container* deriva de *Component*, el seu mètode **render()** ha de mostrar tots els components que conté, del primer fins a l'últim, retallant segons l'espai del propi container.

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
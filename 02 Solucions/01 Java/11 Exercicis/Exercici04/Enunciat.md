<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 4

Fent servir SWING bàsic i el model MVC, fes una aplicació per llistar i mostrar receptes d'una base de dades SQLite:

* La primera vista 'ViewList' mostrarà un "Carregant ..."  mentre obté la informació de la base de dades (ha de trigar almenys 1,5 segons). I després mostrarà la llista de receptes, on les favorites han de tenir un '♥'

* La segona vista 'ViewItem' mostrarà la informació de la recepta en un *JEditorPane* configurat per mostrar contingut HTML.

Cal que facis servir dos models i un sol DAO: 'ReceptaModel', 'IngredientModel', 'ReceptaDAO'

<center><img src="./captura.gif" height="250" alt="Calculadora" style="max-height: 250px;"></center>

**Nota:** Aquest exerci no té test.
<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Enunciat

Crea un sistema per gestionar estudiants, professors, i cursos en una escola de dansa.

Descripció:

Classe Base: Desenvolupa una classe abstracta **Persona** amb propietats com nom, cognom, i DNI. Afegeix un mètode abstracte descripcio() per a descriure la funció de la persona dins de l'escola.

Classes Derivades: Crea classes **Estudiant** i **Professor** que heretin de Persona. 

* **Estudiant** ha d'incloure propietats addicionals com ara nivell (principiant, intermedi, avançat) i cursosMatriculats. 

* **Professor** ha d'incloure especialitat i una llista dels cursos que imparteix.

Gestió de Cursos: Implementa una classe **Curs** amb propietats com nom, descripcio, professor, i una llista d'estudiants matriculats.

Sistema de Gestió: Crea una classe **EscolaDeDansa** que gestioni professors, estudiants, i cursos. Aquesta ha d'incloure mètodes per a afegir, eliminar, i assignar estudiants i professors a cursos.

Desenvolupa una classe Main que ofereixi un menú per gestionar l'escola de dansa, incloent opcions per matricular estudiants, assignar professors a cursos, i llistar tots els participants en un curs. 

Les opcions que ha de tenir el menú són:

1. **Afegir Persona** (Estudiant/Professor): Permet introduir dades per crear una nova instància d'estudiant o professor i afegir-la a l'escola.

2. **Eliminar Persona** (Estudiant/Professor): Permet eliminar una persona registrada a l'escola mitjançant el seu DNI.

3. **Crear Curs**: Permet crear un nou curs, introduint dades com el nom del curs, la descripció, i assignant un professor.

4. **Modificar Curs**: Permet modificar les dades d'un curs existent, com canviar el professor assignat o modificar la descripció del curs.

5. **Matricular/Desmatricular** Estudiant en un Curs: Selecciona un estudiant i un curs i matricula o desmatricula d'un curs.

6. **Llistar Cursos**: Mostra un llistat de tots els cursos disponibles, incloent la informació del professor assignat i els estudiants matriculats.

7. **Buscar Persona** (Estudiant/Professor): Permet buscar estudiants o professors per nom, cognom, o DNI i mostra la seva informació detallada.

8. **Guardar/Carregar** Estat de l'Escola: Guarda o Carrega tota la informació de l'escola en un fitxer. (Ha de ser .csv o .json)

0. **Sortir** Surt del programa sense guardar canvis.


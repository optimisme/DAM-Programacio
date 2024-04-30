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

Crea dues classes 'Estudiant' i 'Curs'

*Classe Estudiant*

**Atributs** privats:

- nom (String): El nom de l'estudiant.
- edat (int): L'edat de l'estudiant.
- notaMitjana (double): La nota mitjana de l'estudiant.

**Constructor**:

Un constructor que inicialitzi el nom i l'edat de l'estudiant.

**Mètodes**:

Setters i getters per a cada atribut.

Una funció pública **actualitzaNotaMitjana(double novaNota)** que actualitzi la nota mitjana de l'estudiant basant-se en una nova nota aportada. 

Aquest mètode haurà de cridar una funció privada **calculaNotaMitjana(double novaNota)** que realment realitzi el càlcul de la nova nota mitjana.

*Classe Curs*

**Atributs privats**:

- nomCurs (String): El nom del curs.
- professor (String): El nom del professor del curs.
- llistaEstudiants (ArrayList<Estudiant>): Una llista dels estudiants inscrits al curs.

**Constructor**:

Un constructor que inicialitzi el nomCurs i el professor.

**Mètodes**:

Setters i getters per al nomCurs i professor.

afegeixEstudiant(Estudiant estudiant): Afegeix un estudiant a la llista d'estudiants.

eliminaEstudiant(String nom): Elimina un estudiant de la llista pel seu nom.

mostraEstudiants(): Mostra la llista d'estudiants inscrits al curs. Aquesta funció ha d'ésser pública. El format serà "Nom - Nota Mitjana: 0.0"

Comprova que per aquest codi:

```java
package com.project;

public class Main {
    public static void main(String[] args) {
        // Creació d'estudiants
        Estudiant estudiant1 = new Estudiant("Joan", 20);
        Estudiant estudiant2 = new Estudiant("Maria", 19);

        // Actualització de la nota mitjana
        estudiant1.actualitzaNotaMitjana(9.5);
        estudiant2.actualitzaNotaMitjana(8.0);

        // Creació del curs i afegiment d'estudiants
        Curs curs = new Curs("Matemàtiques", "Sr. Albert");
        curs.afegeixEstudiant(estudiant1);
        curs.afegeixEstudiant(estudiant2);

        // Mostrar estudiants del curs
        curs.mostraEstudiants();
    }
}
```

La sortida és

```text
Joan - Nota Mitjana: 4.75
Maria - Nota Mitjana: 4.0
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainSettersGetters
./runTest.sh com.project.TestMain#testMainPrivateAttributes


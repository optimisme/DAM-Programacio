<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 2

Crea la classe 'Estudiant', que és un sistema que permet registrar estudiants en un curs. El sistema ha de ser capaç de comptar el total d'estudiants registrats i limitar el nombre de registres segons la capacitat del curs.

**Atributs Privats d'Instància:**

String nom: El nom de l'estudiant.

String id: L'ID únic de l'estudiant.

**Atributs Privats Estàtics:**

int comptadorEstudiants: Un comptador que porta la compte del total d'estudiants registrats.

final int CAPACITAT_MAXIMA = 5: La capacitat màxima d'estudiants en el curs.

**Constructor:**

Un constructor que accepta nom i id com a paràmetres. Aquest constructor ha de verificar si encara hi ha capacitat en el curs abans de registrar a l'estudiant. Si la capacitat està plena, no ha de permetre la creació d'una nova instància i ha de mostrar un missatge d'error.
Mètodes Públics d'Instància:

**Getters i Setters**

Fes els Getters i Setters de 'nom' i 'id'

**Mètodes Públics Estàtics:**

getComptadorEstudiants(): Retorna el nombre total d'estudiants registrats.

hiHaCapacitat(): Retorna true si encara hi ha capacitat per a registrar més estudiants, false en cas contrari.

Valida que pel següent main:

```java
public class Main {
    public static void main(String[] args) {

        // Intenta superar la capacitat màxima
        for (int i = 1; i <= 6; i++) {
            String nom = "Estudiant" + i;
            String id = "ID" + i;
            new Estudiant(nom, id);
            System.out.println("Intent registrant: " + nom + ". Total registrats: " + Estudiant.getComptadorEstudiants());
        }

        // Comprova si encara hi ha capacitat després dels intents de registre
        if (Estudiant.hiHaCapacitat()) {
            System.out.println("Encara hi ha capacitat per a més estudiants.");
        } else {
            System.out.println("No hi ha més capacitat per a registrar estudiants.");
        }
    }
}
````

La sortia és:

```text
Intent registrant: Estudiant1. Total registrats: 1
Intent registrant: Estudiant2. Total registrats: 2
Intent registrant: Estudiant3. Total registrats: 3
Intent registrant: Estudiant4. Total registrats: 4
Intent registrant: Estudiant5. Total registrats: 5
No es pot registrar l'estudiant. La capacitat màxima ha estat assolida.
Intent registrant: Estudiant6. Total registrats: 5
No hi ha més capacitat per a registrar estudiants.
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainSettersGetters
./runTest.sh com.project.TestMain#testMainPrivateAttributes


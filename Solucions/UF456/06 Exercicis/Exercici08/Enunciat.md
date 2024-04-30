<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 8

Crea un sistema que permeti gestionar diferents tipus d'empleats en una empresa, practicant el casting ascendent i descendent d'objectes.

Imagina una empresa que té diversos tipus d'empleats, incloent Desenvolupadors i Gestors, que són especialitzacions de la classe Empleat. 

Cada tipus d'empleat té atributs i mètodes específics.


Classe Base **Empleat**:

Atributs: nom (String), identificador (String).

Constructor que inicialitza els atributs.

Sobreescriure el mètode 'toString' per mostrar una descripció bàsica de l'empleat, en aquest format:

"Empleat{nom='" + nom + "', identificador='" + identificador + "'}";


Subclasse **Desenvolupador**:

Atributs específics: llenguatge (String) que indica el llenguatge de programació principal del desenvolupador.

Constructor que inicialitza els atributs (incloent els de la classe base).

Sobreescriure el mètode 'toString' per mostrar una descripció bàsica del desenvolupador, en aquest format:

(El toString d'Empleat) + ", llenguatge='" + llenguatge + "'"


Subclasse **Gestor**:

Atributs específics: departament (String) que indica el departament que gestiona.

Constructor que inicialitza els atributs (incloent els de la classe base).

Sobreescriure el mètode 'toString' per mostrar una descripció bàsica del desenvolupador, en aquest format:

(El toString d'Empleat) + ", departament='" + departament + "'"

Requisits:

Utilitza el casting descendent per a convertir objectes de Empleat de nou a Desenvolupador o Gestor quan necessitis accedir a propietats o mètodes específics d'aquestes subclasses.

La crida d'aquesta funció 'main':

```java
public class Main {
    public static void main(String[] args) {
        List<Empleat> empleats = new ArrayList<>();
        empleats.add(new Desenvolupador("Anna", "DEV001", "Java"));
        empleats.add(new Gestor("Carlos", "MAN001", "TI"));
        empleats.add(new Desenvolupador("Berta", "DEV002", "C#"));

        for (Empleat empleat : empleats) {
            System.out.println(empleat.toString());
        }
    }
}
```

Ha de donar:

```text
Empleat{nom='Anna', identificador='DEV001'}, llenguatge='Java'
Empleat{nom='Carlos', identificador='MAN001'}, departament='TI'
Empleat{nom='Berta', identificador='DEV002'}, llenguatge='C#'
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainValidation
./runTest.sh com.project.TestMain#testMainPrivateAttributes
```


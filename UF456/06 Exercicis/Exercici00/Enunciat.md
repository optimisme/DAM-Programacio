<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 0

Crea un sistema simple de gestió d'empleats per a una empresa.

Classe Base (Superclasse): **Empleat**

Atributs privats: nom (String), cognom (String), i salariAnual (double).

Constructor: Que accepti nom, cognom, i salariAnual com a paràmetres.

Mètodes:

getNomComplet(): Retorna el nom complet de l'empleat (nom + cognom).

incrementarSalari(double percentatge): Incrementa el salari de l'empleat segons un percentatge donat.

getSalariAnual(): Retorna el salari anual de l'empleat.

Subclasse: **Gerent**

Atributs privats: departament (String).

Constructor: Que accepti nom, cognom, salariAnual, i departament.

Sobreescriu el mètode getNomComplet() per a que també inclogui el departament del gerent al final.

Prova-ho amb aquest main:

```java
public class Main {
    public static void main(String[] args) {
        Empleat empleat = new Empleat("Maria", "Lopez", 30000);
        Gerent gerent = new Gerent("Carlos", "Garcia", 50000, "TI");
        
        System.out.println(empleat.getNomComplet() + " - Salari Anual: " + empleat.getSalariAnual());
        empleat.incrementarSalari(10);
        System.out.println("Després de l'increment: " + empleat.getSalariAnual());
        
        System.out.println(gerent.getNomComplet() + " - Salari Anual: " + gerent.getSalariAnual());
        gerent.incrementarSalari(10);
        System.out.println("Després de l'increment: " + gerent.getSalariAnual());
    }
}
```

Ha de donar aquesta sortida:

```text
Maria Lopez - Salari Anual: 30000.0
Després de l'increment: 33000.0
Carlos Garcia [TI] - Salari Anual: 50000.0
Després de l'increment: 55000.0
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainValidation
./runTest.sh com.project.TestMain#testMainPrivateAttributes
```


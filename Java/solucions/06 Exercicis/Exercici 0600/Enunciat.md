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

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainValidation
./runTest.sh com.project.TestMain#testMainPrivateAttributes
```


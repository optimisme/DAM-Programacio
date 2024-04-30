<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 5

Una empresa de transport disposa de diversos tipus de vehicles, incloent cotxes, furgonetes, i bicicletes. 

Cada vehicle té característiques úniques, però comparteixen algunes propietats bàsiques. 

Utilitzarem una classe abstracta per definir les propietats i comportaments comuns, i interfícies per característiques específiques com la capacitat de càrrega.

Requisits:

Classe Abstracta **Vehicle**:

Atributs protegits: marca (String), model (String).

Constructor: inicialitza marca i model.

Mètode abstracte descripcioVehicle(): retorna una descripció del vehicle.

Mètode 'iniciarVehicle' que escriu 'El vehicle s'està iniciant."

Mètode 'aturarVehicle' que escriu 'El vehicle s'ha aturat."

Mètode toString(): retorna informació bàsica del vehicle.

Interfície **Carregable**:

Mètode carregar(int quilograms): determina com s'ha de carregar el vehicle.

Classe **Cotxe**, que hereta de *Vehicle* i implementa *Carregable*. Afegeix l'atribut privat capacitatCarrega.

Defineix el mètode 'descripcioVehicle' amb el text: "Cotxe{marca='" + marca + "', model='" + model + "', capacitatCarrega=" + capacitatCarrega + '}'

Sobreescriu el mètode 'iniciarVehicle' amb el text: "El cotxe " + marca + " " + model + " s'està iniciant."

Sobreescriu el mètode 'aturarVehicle' amb el text: "El cotxe " + marca + " " + model + " s'ha aturat."

Classe **Furgoneta**, que hereta de *Vehicle* i implementa *Carregable*. Afegeix l'atribut privat 'volumCarrega'.

Classe **Bicicleta**, que hereta de *Vehicle* però no implementa *Carregable*.

La crida d'aquesta funció 'main':

```java
public static void main(String[] args) {
        Cotxe cotxe = new Cotxe("Toyota", "Corolla", 500);
        System.out.println(cotxe.descripcioVehicle());
        cotxe.iniciarVehicle();
        cotxe.carregar(300);
        cotxe.aturarVehicle();
        System.out.println(cotxe);

        Furgoneta furgoneta = new Furgoneta("Ford", "Transit", 15); // 15m³ de volum de càrrega
        System.out.println(furgoneta.descripcioVehicle());
        furgoneta.iniciarVehicle();
        furgoneta.carregar(1000); 
        furgoneta.aturarVehicle();
        System.out.println(furgoneta);

        Bicicleta bicicleta = new Bicicleta("BH", "Speedrom");
        System.out.println(bicicleta.descripcioVehicle());
        bicicleta.iniciarVehicle();
        bicicleta.aturarVehicle();
        System.out.println(bicicleta);
}
```

Ha de donar:

```text
Cotxe{marca='Toyota', model='Corolla', capacitatCarrega=500}
El cotxe Toyota Corolla s'està iniciant.
Carregant 300kg en el cotxe.
El cotxe Toyota Corolla s'ha aturat.
Vehicle{marca='Toyota', model='Corolla'}
Furgoneta{marca='Ford', model='Transit', volumCarrega=15m³}
La furgoneta Ford Transit s'està iniciant.
Carregant 1000kg a la furgoneta.
La furgoneta Ford Transit s'ha aturat.
Vehicle{marca='Ford', model='Transit'}, volumCarrega=15m³
Bicicleta{marca='BH', model='Speedrom'}
La bicicleta BH Speedrom està preparada per a ser utilitzada.
La bicicleta BH Speedrom s'ha aturat.
Vehicle{marca='BH', model='Speedrom'}
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainValidation
./runTest.sh com.project.TestMain#testMainPrivateAttributes
```


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

Crea un sistema que permeti representar i gestionar les diferents persones relacionades amb una empresa d'aviació. 

La jerarquia de classes inclourà una classe base Persona i dues subclasses: Client i Pilot. 

Cada tipus tindrà atributs específics i implementarà el mètode toString() per mostrar de manera amigable la informació rellevant de l'objecte.

Classe Base **Persona**:

Atributs: nom (String), dni (String).

Constructor: inicialitza el nom i el dni.

Mètode checkIn(): aquest mètode imprimirà un missatge genèric de facturació. Per exemple: "Facturació completada. Benvingut a bord!"

Mètode toString(): retorna una cadena de text que inclou el nom i el dni de la persona.

Subclasse **Client**:

Atribut adicional: número de vol (String) que indica el vol en el qual el client està reservat.

Constructor: inicialitza el nom, el dni i el número de vol.

Sobreescriu el mètode checkIn() per personalitzar el missatge de facturació del client. Per exemple: "Facturació de client completada. Preparat per embarcar al vol [número de vol]. Benvingut a bord!".

Sobreescriu el mètode toString() per incloure també la informació sobre el vol del client.

Subclasse **Pilot**:

Atribut adicional: llicència (String) que indica el número de llicència del pilot.

Constructor: inicialitza el nom, el dni i la llicència.

Sobreescriu el mètode checkIn() per reflectir el procés de facturació d'un pilot. Per exemple: "Pilot [nom] amb llicència [llicència] ha realitzat el check-in. Preparat per al vol."

Sobreescriu el mètode toString() per incloure també la informació sobre la llicència del pilot.

La crida d'aquesta funció 'main':

```java
public static void main(String[] args) {
    // Creació d'un pilot
    Pilot pilot = new Pilot("Maria García", "12345678P", "LIC1234");
    
    // Creació de dos clients
    Client client1 = new Client("Joan Martí", "87654321J", "VOL001");
    Client client2 = new Client("Anna Lopez", "23456789A", "VOL002");
    
    // Mostra la informació i realitza el check-in del pilot
    System.out.println(pilot);
    pilot.checkIn();
    
    // Espai per millorar la legibilitat en la sortida
    System.out.println();

    // Mostra la informació i realitza el check-in dels clients
    System.out.println(client1);
    client1.checkIn();
    
    System.out.println();
    
    System.out.println(client2);
    client2.checkIn();
}
```

Ha de donar:

```text
Persona{nom='Maria García', dni='12345678P'}, llicència='LIC1234'
Pilot Maria García amb llicència LIC1234 ha realitzat el check-in. Preparat per al vol.

Persona{nom='Joan Martí', dni='87654321J'}, vol='VOL001'
Facturació de client completada. Preparat per embarcar al vol VOL001. Benvingut a bord!

Persona{nom='Anna Lopez', dni='23456789A'}, vol='VOL002'
Facturació de client completada. Preparat per embarcar al vol VOL002. Benvingut a bord!
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainValidation
./runTest.sh com.project.TestMain#testMainPrivateAttributes
```


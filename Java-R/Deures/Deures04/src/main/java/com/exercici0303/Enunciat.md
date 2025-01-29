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

Fent servir el Singleton 'AppData' i una base de dades *MySQL* anomenada **natura**, desenvolupa una aplicació que gestioni informació de Flora, Fauna i Països.

**Nota**: Si ja hi ha un contenedor MySQL a docker, anomenat 'mysqlServer', es pot carregar iniciar la base de dades 'school.sql' amb:

A Linux i macOS:
```bash
docker exec -i mysqlServer mysql -uroot -ppwd < dbNatura.sql
```

A Windows:
```bash
type dbNatura.sql | docker exec -i mysqlServer mysql -uroot -ppwd
```

**Important**: Al corregir, els testos han de funcionar amb base de dades 'natura', port 3308, usuari 'root' i codi 'pwd'

**Taula paisos:**
```sql
id (INTEGER) : Un identificador únic per a cada país.
nom (TEXT) : El nom del país.
```

**Taula flora:**
```sql
id (INTEGER) : Un identificador únic per a cada espècie de planta.
nom_comu (TEXT) : El nom comú de la planta.
nom_cientific (TEXT) : El nom científic de la planta.
id_pais (INTEGER) : La clau forana que enllaça amb l id_pais de la taula Paisos.
descripcio (TEXT) : Una descripció breu de la planta.
habitat (TEXT) : L habitat on típicament es troba aquesta planta.
```

**Taula fauna:**
```sql
id (INTEGER) : Un identificador únic per a cada espècie animal.
nom_comu (TEXT) : El nom comú de l'animal.
nom_cientific (TEXT) : El nom científic de l'animal.
id_pais (INTEGER) : La clau forana que enllaça amb l'id_pais de la taula Paisos.
descripcio (TEXT) : Una descripció breu de l'animal.
habitat (TEXT) : L'habitat on típicament es troba aquest animal.
```

**Taula ecosistemes:**
```sql
id (INTEGER) : Un identificador únic per a cada ecosistema.
nom (TEXT) : El nom de l'ecosistema.
id_pais (INTEGER) : La clau forana que enllaça amb l'id_pais de la taula Paisos.
caracteristiques (TEXT) : Les característiques principals de l'ecosistema.
```

**Taula floraEcosistema:**
```sql
id_flora (INTEGER) : La clau forana que enllaça amb l'id_flora de la taula Flora.
id_ecosistema (INTEGER) : La clau forana que enllaça amb l'id_ecosistema de la taula Ecosistemes.
```

**Taula faunaEcosistema:**
```sql
id_fauna (INTEGER) : La clau forana que enllaça amb l'id_fauna de la taula Fauna.
id_ecosistema (INTEGER) : La clau forana que enllaça amb l'id_ecosistema de la taula Ecosistemes.
```

Utilitza el singleton AppData per a realitzar totes les operacions de base de dades (insercions, actualitzacions, consultes)

**Important:** Et caldrà una interfície anomenada **Identifiable**, que obliga als objectes que la implementen a definir el mètode **'getId'**. I que és necessària per obtenir un objecte d'una llista genèrica, a partir del seu identificador.

Implementa objectes per contenir la informació de cada taula de la base de dades anterior. Tingues en compte que tots els atributs són privats, i calen Getters i Setters.

**Classe Pais:**

*Atributs:*

* **idPais** (int): Un identificador únic per a cada país. Quan és 0, encara no s'ha afegit l'element a la base de dades.
* **nom** (String): El nom del país.

*Constructor:* Inicialitza idPais i nomPais.

*Mètodes:*

* **getters/setters** dels atributs.
* **save()**: Guarda o actualitza el país a la base de dades fent ús del singleton AppData.
* **toString()**: Retorna una cadena de text que inclou l'id i el nom del país.


**Classe Flora:**

*Atributs:*

* **idFlora** (int): Un identificador únic per a cada espècie de planta. Quan és 0, encara no s'ha afegit l'element a la base de dades.
* **nomComu** (String): El nom comú de la planta.
* **nomCientific** (String): El nom científic de la planta.
* **idPais** (int): La clau forana que enllaça amb l'idPais de la taula Paisos.
* **descripcio** (String): Una descripció breu de la planta.
* **habitat** (String): L'habitat on típicament es troba aquesta planta.

*Constructor:* Inicialitza tots els atributs de l'objecte Flora.

*Mètodes:*

* **getters/setters** dels atributs.
* **save()**: Guarda o actualitza l'espècie de planta a la base de dades utilitzant AppData.
* **toString()**: Retorna una cadena de text amb la informació de l'espècie. 


**Classe Fauna:**

*Atributs:*

* **idFauna** (int): Un identificador únic per a cada espècie animal. Quan és 0, encara no s'ha afegit l'element a la base de dades.
* **nomComu** (String): El nom comú de l'animal.
* **nomCientific** (String): El nom científic de l'animal.
* **idPais** (int): La clau forana que enllaça amb l'idPais de la taula Paisos.
* **descripcio** (String): Una descripció breu de l'animal.
* **habitat** (String): L'habitat on típicament es troba aquest animal.

*Constructor:* Inicialitza tots els atributs de l'objecte Fauna.

*Mètodes:*

* **getters/setters** dels atributs.
* **save()**: Guarda o actualitza l'espècie animal a la base de dades utilitzant AppData.
* **toString()**: Retorna una cadena de text amb la informació de l'espècie. 

**Classe Ecosistema:**

*Atributs:*

* **idEcosistema** (int): Un identificador únic per a cada ecosistema. Quan és 0, indica que encara no s'ha afegit l'element a la base de dades.
* **nom** (String): El nom de l'ecosistema.
* **caracteristiques** (String): Les característiques principals de l'ecosistema.
* **idPais** (int): La clau forana que enllaça amb l'id_pais de la taula Paisos.

*Constructor:* Inicialitza idEcosistema, nom, caracteristiques, i idPais.

*Mètodes:*

* **getters/setters** dels atributs.
* **save**(): Guarda o actualitza l'ecosistema a la base de dades fent ús del singleton AppData. Si idEcosistema és 0, es realitza una inserció. En cas contrari, es realitza una actualització.
* **toString**(): Retorna una cadena de text que inclou l'ID, el nom, les característiques, i l'ID del país de l'ecosistema. Això facilita la visualització de la informació de l'ecosistema.

**Nota:** Per implementar el mètode save() en cada una de les classes, hauràs d'escriure codi que construeixi una consulta SQL basada en els atributs de l'objecte. Aquesta consulta pot ser una inserció (INSERT) si l'objecte és nou, o una actualització (UPDATE) si l'objecte ja existeix a la base de dades. Recorda gestionar les transaccions de manera apropiada amb el *Singleton* de *AppData*. Pots fer servir la següent base:

```java
public void save() {
    String sql;
    if (this.idFauna == 0) { 
        // Suposem que 0 indica un nou objecte
        sql = "INSERT INTO Fauna (nomComu, ...";
    } else {
        sql = "UPDATE Fauna SET nomComu = ...";
    }
    AppData.getInstance().update(sql);
}
```

Aquest és l'esquelet del Main que també heu de programar:

- La informació no només està a la base de dades, també a cada una de les llistes i mapes locals
- La informació local i la de la base de dades han d'estar sincronitzades (coincidir)

```java
public class Main {

    private static List<Pais> paisos = new ArrayList<>();
    private static List<Flora> flora = new ArrayList<>();
    private static List<Fauna> fauna = new ArrayList<>();
    private static List<Ecosistema> ecosistemes = new ArrayList<>();
    private static Map<Integer, Integer> floraEcosistema = new HashMap<>();
    private static Map<Integer, Integer> faunaEcosistema = new HashMap<>();

    public static void main(String[] args) {
        AppData db = AppData.getInstance();

        // Crear les taules necessàries
        crearTaules();

        // Afegir dades
        int idEspanya = afegirPais("xEspanya"); 
        int idCanada = afegirPais("Canadà"); 
        int idBrasil = afegirPais("Brasil"); 
        int idAustralia = afegirPais("Austràlia"); 
        int idSudAfrica = afegirPais("Sud-àfrica"); 
        int idXina = afegirPais("Xina"); 
        int idEUA = afegirPais("Estats Units"); 
        int idAntartida = afegirPais("Antàrtida"); 

        int idSelva = afegirEcosistema("xSelva", idBrasil, "La selva tropical rica en biodiversitat.");
        int idDesert = afegirEcosistema("Desert", idAustralia, "El desert càlid més caracteritzat per extensions de dunes de sorra.");
        int idBosc = afegirEcosistema("Bosc", idCanada, "Extensos boscos de coníferes amb hiverns llargs i freds.");
        int idOcea = afegirEcosistema("Oceà Antàrtic", idAntartida, "Habitat de milers d'espècies marines.");

        int idDalia = afegirFlora("xDàlia", "Dahlia pinnata", idEUA, "Jardins i zones cultivades", "Planta amb flors colorides que varien en forma i mida.", idDesert);
        afegirFlora("Eucaliptus", "Eucalyptus globulus", idAustralia, "Boscos oberts i zones costaneres", "Àrbre alt amb fulles aromàtiques utilitzades en medicina.", idBosc);
        afegirFlora("Orquídia", "Orchidaceae", idEspanya, "Selva tropical, terres baixes humides i muntanyes", "Família extensa de plantes florals amb flors simètriques i variades.", idSelva);
        int idBaobab = afegirFlora("Baobab", "Adansonia", idSudAfrica, "Savanes àrides i terres semiàrides", "Àrbre gros i robust conegut per la seva capacitat de conservar aigua dins del seu tronc.", idDesert);
        afegirFlora("Sequoia", "Sequoiadendron giganteum", idEUA, "Boscos humits temperats", "Un dels arbres més alts i longeus del món", idBosc);
        afegirFlora("Lavanda", "Lavandula", idCanada, "Terrenys assolellats, secs i calcaris", "Arbust conegut per les seves flors aromàtiques i propietats relaxants", idDesert);
        afegirFlora("Safrà", "Crocus sativus", idXina, "Terres semiàrides cultivades", "Conreat per les seves flors de les quals s'extreu l'espècia de safrà", idDesert);
        int idMaple = afegirFlora("Maple", "Acer", idCanada, "Zones humides i planes", "Arbres caducifolis coneguts pel seu sirop dolç", idDesert);

        int idKoala = afegirFauna("xKoala", "Phascolarctos cinereus", idAustralia, "Boscos d'eucaliptus", "Marsupial arborícola conegut per la seva dieta basada en fulles d'eucaliptus.", idBosc);
        int idPanda = afegirFauna("Panda", "Ailuropoda melanoleuca", idXina, "Boscos de muntanya rics en bambú", "Gran mamífer conegut per la seva dieta principalment de bambú i el seu pelatge distintiu blanc i negre", idBosc);
        afegirFauna("Àguila calva", "Haliaeetus leucocephalus", idEUA, "Zones amb llacs i rius", "Gran au de presa, símbol nacional dels Estats Units, reconeguda pel seu cap blanc", idBosc);
        afegirFauna("Lleopard de les neus", "Panthera uncia", idXina, "Terreny rocos muntanyenc", "Felí de muntanya adaptat a viure en l'altitud elevada de les muntanyes de l'Himàlaia", idDesert);
        afegirFauna("Tucà", "Ramphastos", idBrasil, "Selves tropicals i boscos humits", "Ocell tropical conegut pel seu gran bec colorit", idSelva);
        int idPingui = afegirFauna("Pingüí emperador", "Aptenodytes forsteri", idAntartida, "Zones d'aigües fredes", "El més gran i pesat de tots els pingüins vius, conegut per la seva capacitat de reproduir-se durant l'hivern antàrtic més dur", idBosc);

        // Comprovar funcions 'obtenir'
        int idObtenirCanada = obtenirIdPaisPerNom("Canadà");
        int idObtenirDesert = obtenirIdEcosistemaPerNom("Desert");
        int idObtenirBaobab = obtenirIdFloraPerNomComu("Baobab");
        int idObtenirPanda = obtenirIdFaunaPerNomComu("Panda");
        System.out.println("id Canada: " + idCanada + ":" + idObtenirCanada + " > " + (idCanada == idObtenirCanada));
        System.out.println("id Desert: " + idDesert + ":" + idObtenirDesert + " > " + (idDesert == idObtenirDesert));
        System.out.println("id Baobab: " + idBaobab + ":" + idObtenirBaobab + " > " + (idBaobab == idObtenirBaobab));
        System.out.println("id Panda: " + idPanda + ":" + idObtenirPanda + " > " + (idPanda == idObtenirPanda));

        // Modificar dades
        Pais refEspanya = (Pais) obtenirReferencia(idEspanya, paisos);
        refEspanya.setNom("Espanya");
        refEspanya.save();

        Ecosistema refSelva = (Ecosistema) obtenirReferencia(idSelva, ecosistemes);
        refSelva.setNom("Selva");
        refSelva.save();

        Flora refDalia = (Flora) obtenirReferencia(idDalia, flora);
        refDalia.setNomComu("Dàlia");
        refDalia.save();

        Fauna refKoala = (Fauna) obtenirReferencia(idKoala, fauna);
        refKoala.setNomComu("Koala");
        refKoala.save();
        
        // Modificar associacions
        associarFloraAEcosistema(idMaple, idBosc);
        associarFaunaAEcosistema(idPingui, idOcea);
       
        // Mostrar dades dels objectes
        llistarPaisos();
        llistarEcosistemes();
        llistarFlora();
        llistarFauna();
        llistarFloraEcosistema(idSelva);
        llistarFaunaEcosistema(idBosc);

        // Tancar la connexió amb la base de dades
        db.close();

        // Forçar la sortida del programa per no esperar a tancar la connexió amb 'MySQL'
        // Assegura't que en aquest punt totes les dades s'han guardat correctament
        if (!"test".equals(System.getProperty("enviroment"))) {
            System.exit(0);
        }
    }

    private static void crearTaules() {
        // Fa servir el singleton AppData per crear les taules segons l'explicació de l'enunciat
        // Si les taules ja existeixen, les esborra prèviament
    }

    private static int afegirPais(String nomPais) {
        // Crea un nou objecte 'pais'
        // Guarda la informació a la base de dades amb el mètode 'save' del nou objecte
        // Afegeix el nou objecte a la llista de 'paisos' local
        // Retorna l'identificador que la base de dades ha assigntat al nou objecte fent servir la funció 'obtenirIdPaisPerNom'
        return -1;
    }

    private static int afegirFlora(String nom, String nomCientific, int idPais, String habitat, String descripcio, int idEcosistema) {
        // Crea un nou objecte 'flora'
        // Guarda la informació a la base de dades amb el mètode 'save' del nou objecte
        // Afegeix el nou objecte a la llista de 'flora' local
        // Retorna l'identificador que la base de dades ha assigntat al nou objecte fent servir la funció 'obtenirIdFloraPerNomComu'
        return -1;
    }
    
    private static int afegirFauna(String nom, String nomCientific, int idPais, String habitat, String descripcio, int idEcosistema) {
        // Crea un nou objecte 'fauna'
        // Guarda la informació a la base de dades amb el mètode 'save' del nou objecte
        // Afegeix el nou objecte a la llista de 'fauna' local
        // Retorna l'identificador que la base de dades ha assigntat al nou objecte fent servir la funció 'obtenirIdFaunaPerNomComu'
        return -1;
    }
    
    private static int afegirEcosistema(String nom, int idPais, String caracteristiques) {
        // Crea un nou objecte 'ecosistema'
        // Guarda la informació a la base de dades amb el mètode 'save' del nou objecte
        // Afegeix el nou objecte a la llista de 'ecosistemes' local
        // Retorna l'identificador que la base de dades ha assigntat al nou objecte fent servir la funció 'obtenirIdEcosistemaPerNom'
        return -1;
    }

    private static void associarFloraAEcosistema(int idFlora, int idEcosistema) {
        // Afegeix la nova relació a la taula 'floraEcosistema' i al mapa 'floraEcosistema'
    }
    
    private static void associarFaunaAEcosistema(int idFauna, int idEcosistema) {
        // Afegeix la nova relació a la taula 'faunaEcosistema' i al mapa  'faunaEcosistema'
    }
    
    public static int obtenirIdPaisPerNom(String nomPais) {
        // Fa servir AppData per obtenir l'id a partir del nom, retorna -1 si no existeix aquest nom a la base de dades
        return -1;
    }

    public static int obtenirIdFloraPerNomComu(String nomComu) {
        // Fa servir AppData per obtenir l'id a partir del nom, retorna -1 si no existeix aquest nom a la base de dades
        return -1;
    }

    public static int obtenirIdFaunaPerNomComu(String nomComu) {
        // Fa servir AppData per obtenir l'id a partir del nom, retorna -1 si no existeix aquest nom a la base de dades
        return -1;
    }

    public static int obtenirIdEcosistemaPerNom(String nom) {
        // Fa servir AppData per obtenir l'id a partir del nom, retorna -1 si no existeix aquest nom a la base de dades
        return -1;
    }

    private static void llistarPaisos() {
        System.out.println("Llista de Paisos:");
        // Fa servir el mètode 'toString' de cada Pais per mostrar la informació

        System.out.println("Llista de Paisos de la base de dades:");
        // Obté les dades de paisos amb AppData i mostra la informació amb aquest format:
        // System.out.println("Pais { Id: " + id + ", Nom: \"" + nom + "\" }");
    }
    
    private static void llistarFlora() {
        System.out.println("Llista de Flora:");
        // Fa servir el mètode 'toString' de cada Pais per mostrar la informació
    
        System.out.println("Llista de Flora de la base de dades:");
        // Obté les dades de paisos amb AppData i mostra la informació amb aquest format:
        // System.out.println("Flora { Id: " + id + ", Nom Comú: \"" + nomComu + "\", Nom Científic: \"" + nomCientific + "\", Pais: " + idPais + ", Habitat: \"" + habitat + "\" }");
    }
    
    private static void llistarFauna() {
        System.out.println("Llista de Fauna:");
        // Fa servir el mètode 'toString' de cada Pais per mostrar la informació
    
        System.out.println("Llista de Fauna de la base de dades:");
        // Obté les dades de paisos amb AppData i mostra la informació amb aquest format:
        // System.out.println("Fauna { Id: " + id + ", Nom Comú: \"" + nomComu + "\", Nom Científic: \"" + nomCientific + "\", Pais: " + idPais + ", Habitat: \"" + habitat + "\" }");
    }
    
    private static void llistarEcosistemes() {
        System.out.println("Llista d'Ecosistemes:");
        // Fa servir el mètode 'toString' de cada Pais per mostrar la informació
    
        System.out.println("Llista d'Ecosistemes de la base de dades:");
        // Obté les dades de paisos amb AppData i mostra la informació amb aquest format:
        // System.out.println("Ecosistema { Id: " + id + ", Nom: \"" + nom + "\", Id Pais: " + idPais + " }");
    }
    
    private static void llistarFloraEcosistema(int idEcosistema) {
        System.out.println("Llista de Flora de l'Ecosistema " + idEcosistema + ":");
        // Mostra la informació del mapa 'floraEcosistema'
    }
    
    private static void llistarFaunaEcosistema(int idEcosistema) {
        System.out.println("Llista de Fauna de l'Ecosistema " + idEcosistema + ":");
        // Mostra la informació del mapa 'faunaEcosistema'
    }

    private static Identifiable obtenirReferencia(int id, List<? extends Identifiable> llista) {
        // Retorna l'objecte de la llista que té aquest identificador
        for (Identifiable item : llista) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }   
}
```


Ha de donar aquesta sortida:

```text
id Canada: 2:2 > true
id Desert: 2:2 > true
id Baobab: 4:4 > true
id Panda: 2:2 > true
Llista de Paisos:
Pais { Id: 1, Nom: "Espanya" }
Pais { Id: 2, Nom: "Canadà" }
Pais { Id: 3, Nom: "Brasil" }
Pais { Id: 4, Nom: "Austràlia" }
Pais { Id: 5, Nom: "Sud-àfrica" }
Pais { Id: 6, Nom: "Xina" }
Pais { Id: 7, Nom: "Estats Units" }
Pais { Id: 8, Nom: "Antàrtida" }
Llista de Paisos de la base de dades:
Pais { Id: 1, Nom: "Espanya" }
Pais { Id: 2, Nom: "Canadà" }
Pais { Id: 3, Nom: "Brasil" }
Pais { Id: 4, Nom: "Austràlia" }
Pais { Id: 5, Nom: "Sud-àfrica" }
Pais { Id: 6, Nom: "Xina" }
Pais { Id: 7, Nom: "Estats Units" }
Pais { Id: 8, Nom: "Antàrtida" }
Llista d'Ecosistemes:
Ecosistema { Id: 1, Nom: "Selva", Id Pais: 3 }
Ecosistema { Id: 2, Nom: "Desert", Id Pais: 4 }
Ecosistema { Id: 3, Nom: "Bosc", Id Pais: 2 }
Ecosistema { Id: 4, Nom: "Oceà Antàrtic", Id Pais: 8 }
Llista d'Ecosistemes de la base de dades:
Ecosistema { Id: 1, Nom: "Selva", Id Pais: 3 }
Ecosistema { Id: 2, Nom: "Desert", Id Pais: 4 }
Ecosistema { Id: 3, Nom: "Bosc", Id Pais: 2 }
Ecosistema { Id: 4, Nom: "Oceà Antàrtic", Id Pais: 8 }
Llista de Flora:
Flora { Id: 1, Nom Comú: "Dàlia", Nom Científic: "Dahlia pinnata", Pais: 7, Habitat: "Jardins i zones cultivades" }
Flora { Id: 2, Nom Comú: "Eucaliptus", Nom Científic: "Eucalyptus globulus", Pais: 4, Habitat: "Boscos oberts i zones costaneres" }
Flora { Id: 3, Nom Comú: "Orquídia", Nom Científic: "Orchidaceae", Pais: 1, Habitat: "Selva tropical, terres baixes humides i muntanyes" }
Flora { Id: 4, Nom Comú: "Baobab", Nom Científic: "Adansonia", Pais: 5, Habitat: "Savanes àrides i terres semiàrides" }
Flora { Id: 5, Nom Comú: "Sequoia", Nom Científic: "Sequoiadendron giganteum", Pais: 7, Habitat: "Boscos humits temperats" }
Flora { Id: 6, Nom Comú: "Lavanda", Nom Científic: "Lavandula", Pais: 2, Habitat: "Terrenys assolellats, secs i calcaris" }
Flora { Id: 7, Nom Comú: "Safrà", Nom Científic: "Crocus sativus", Pais: 6, Habitat: "Terres semiàrides cultivades" }
Flora { Id: 8, Nom Comú: "Maple", Nom Científic: "Acer", Pais: 2, Habitat: "Zones humides i planes" }
Llista de Flora de la base de dades:
Flora { Id: 1, Nom Comú: "Dàlia", Nom Científic: "Dahlia pinnata", Pais: 7, Habitat: "Jardins i zones cultivades" }
Flora { Id: 2, Nom Comú: "Eucaliptus", Nom Científic: "Eucalyptus globulus", Pais: 4, Habitat: "Boscos oberts i zones costaneres" }
Flora { Id: 3, Nom Comú: "Orquídia", Nom Científic: "Orchidaceae", Pais: 1, Habitat: "Selva tropical, terres baixes humides i muntanyes" }
Flora { Id: 4, Nom Comú: "Baobab", Nom Científic: "Adansonia", Pais: 5, Habitat: "Savanes àrides i terres semiàrides" }
Flora { Id: 5, Nom Comú: "Sequoia", Nom Científic: "Sequoiadendron giganteum", Pais: 7, Habitat: "Boscos humits temperats" }
Flora { Id: 6, Nom Comú: "Lavanda", Nom Científic: "Lavandula", Pais: 2, Habitat: "Terrenys assolellats, secs i calcaris" }
Flora { Id: 7, Nom Comú: "Safrà", Nom Científic: "Crocus sativus", Pais: 6, Habitat: "Terres semiàrides cultivades" }
Flora { Id: 8, Nom Comú: "Maple", Nom Científic: "Acer", Pais: 2, Habitat: "Zones humides i planes" }
Llista de Fauna:
Fauna { Id: 1, Nom Comú: "Koala", Nom Científic: "Phascolarctos cinereus", Pais: 4, Habitat: "Boscos d'eucaliptus" }
Fauna { Id: 2, Nom Comú: "Panda", Nom Científic: "Ailuropoda melanoleuca", Pais: 6, Habitat: "Boscos de muntanya rics en bambú" }
Fauna { Id: 3, Nom Comú: "Àguila calva", Nom Científic: "Haliaeetus leucocephalus", Pais: 7, Habitat: "Zones amb llacs i rius" }
Fauna { Id: 4, Nom Comú: "Lleopard de les neus", Nom Científic: "Panthera uncia", Pais: 6, Habitat: "Terreny rocos muntanyenc" }
Fauna { Id: 5, Nom Comú: "Tucà", Nom Científic: "Ramphastos", Pais: 3, Habitat: "Selves tropicals i boscos humits" }
Fauna { Id: 6, Nom Comú: "Pingüí emperador", Nom Científic: "Aptenodytes forsteri", Pais: 8, Habitat: "Zones d'aigües fredes" }
Llista de Fauna de la base de dades:
Fauna { Id: 1, Nom Comú: "Koala", Nom Científic: "Phascolarctos cinereus", Pais: 4, Habitat: "Boscos d'eucaliptus" }
Fauna { Id: 2, Nom Comú: "Panda", Nom Científic: "Ailuropoda melanoleuca", Pais: 6, Habitat: "Boscos de muntanya rics en bambú" }
Fauna { Id: 3, Nom Comú: "Àguila calva", Nom Científic: "Haliaeetus leucocephalus", Pais: 7, Habitat: "Zones amb llacs i rius" }
Fauna { Id: 4, Nom Comú: "Lleopard de les neus", Nom Científic: "Panthera uncia", Pais: 6, Habitat: "Terreny rocos muntanyenc" }
Fauna { Id: 5, Nom Comú: "Tucà", Nom Científic: "Ramphastos", Pais: 3, Habitat: "Selves tropicals i boscos humits" }
Fauna { Id: 6, Nom Comú: "Pingüí emperador", Nom Científic: "Aptenodytes forsteri", Pais: 8, Habitat: "Zones d'aigües fredes" }
Llista de Flora de l'Ecosistema 1:
Flora { Id: 3, Nom Comú: "Orquídia", Nom Científic: "Orchidaceae", Pais: 1, Habitat: "Selva tropical, terres baixes humides i muntanyes" }
Llista de Fauna de l'Ecosistema 3:
Fauna { Id: 1, Nom Comú: "Koala", Nom Científic: "Phascolarctos cinereus", Pais: 4, Habitat: "Boscos d'eucaliptus" }
Fauna { Id: 2, Nom Comú: "Panda", Nom Científic: "Ailuropoda melanoleuca", Pais: 6, Habitat: "Boscos de muntanya rics en bambú" }
Fauna { Id: 3, Nom Comú: "Àguila calva", Nom Científic: "Haliaeetus leucocephalus", Pais: 7, Habitat: "Zones amb llacs i rius" }
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainPrivateAttributes
./runTest.sh com.project.TestMain#testMainTables
./runTest.sh com.project.TestMain#testMainCalls
```


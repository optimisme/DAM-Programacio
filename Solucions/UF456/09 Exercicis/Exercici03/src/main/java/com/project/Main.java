package com.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        AppData db = AppData.getInstance();
        db.update("SET FOREIGN_KEY_CHECKS=0;");
    
        // Crear taula paisos
        db.update("DROP TABLE IF EXISTS paisos");
        db.update("CREATE TABLE paisos (" +
                  "id INTEGER AUTO_INCREMENT," +
                  "nom TEXT," +
                  "PRIMARY KEY (id))");
    
        // Crear taula flora
        db.update("DROP TABLE IF EXISTS flora");
        db.update("CREATE TABLE flora (" +
                  "id INTEGER AUTO_INCREMENT," +
                  "nom_comu TEXT," +
                  "nom_cientific TEXT," +
                  "id_pais INTEGER," +
                  "descripcio TEXT," +
                  "habitat TEXT," +
                  "PRIMARY KEY (id)," +
                  "FOREIGN KEY (id_pais) REFERENCES paisos(id))");
    
        // Crear taula fauna
        db.update("DROP TABLE IF EXISTS fauna");
        db.update("CREATE TABLE fauna (" +
                  "id INTEGER AUTO_INCREMENT," +
                  "nom_comu TEXT," +
                  "nom_cientific TEXT," +
                  "id_pais INTEGER," +
                  "descripcio TEXT," +
                  "habitat TEXT," +
                  "PRIMARY KEY (id)," +
                  "FOREIGN KEY (id_pais) REFERENCES paisos(id))");
    
        // Crear taula ecosistemes
        db.update("DROP TABLE IF EXISTS ecosistemes");
        db.update("CREATE TABLE ecosistemes (" +
                  "id INTEGER AUTO_INCREMENT," +
                  "nom TEXT," +
                  "caracteristiques TEXT," +
                  "id_pais INTEGER," +
                  "PRIMARY KEY (id)," +
                  "FOREIGN KEY (id_pais) REFERENCES paisos(id))");
    
        // Crear taula floraEcosistema
        db.update("DROP TABLE IF EXISTS floraEcosistema");
        db.update("CREATE TABLE floraEcosistema (" +
                  "id_flora INTEGER," +
                  "id_ecosistema INTEGER," +
                  "FOREIGN KEY (id_flora) REFERENCES flora(id)," +
                  "FOREIGN KEY (id_ecosistema) REFERENCES ecosistemes(id))");
    
        // Crear taula faunaEcosistema
        db.update("DROP TABLE IF EXISTS faunaEcosistema");
        db.update("CREATE TABLE faunaEcosistema (" +
                  "id_fauna INTEGER," +
                  "id_ecosistema INTEGER," +
                  "FOREIGN KEY (id_fauna) REFERENCES fauna(id)," +
                  "FOREIGN KEY (id_ecosistema) REFERENCES ecosistemes(id))");
    
        db.update("SET FOREIGN_KEY_CHECKS=1;");
    }

    private static int afegirPais(String nomPais) {
        Pais nouPais = new Pais(0, nomPais); // Assumim que el constructor accepta un ID de 0 per a nous països
        nouPais.save();
        int idPais = obtenirIdPaisPerNom(nomPais);
        if (idPais != -1) {
            nouPais.setId(idPais); // Actualitzar l'ID amb el valor obtingut de la BD
            paisos.add(nouPais);
        }
        return idPais;
    }

    private static int afegirFlora(String nom, String nomCientific, int idPais, String habitat, String descripcio, int idEcosistema) {
        Flora novaFlora = new Flora(0, nom, nomCientific, idPais, descripcio, habitat);
        novaFlora.save();
        int idFlora = obtenirIdFloraPerNomComu(nom);
        if (idFlora != -1) {
            flora.add(novaFlora);
            floraEcosistema.put(idFlora, idEcosistema);
        }
        return idFlora;
    }
    
    private static int afegirFauna(String nom, String nomCientific, int idPais, String habitat, String descripcio, int idEcosistema) {
        Fauna novaFauna = new Fauna(0, nom, nomCientific, idPais, descripcio, habitat);
        novaFauna.save();
        int idFauna = obtenirIdFaunaPerNomComu(nom);
        if (idFauna != -1) {
            fauna.add(novaFauna);
            faunaEcosistema.put(idFauna, idEcosistema);
        }
        return idFauna;
    }
    
    private static int afegirEcosistema(String nom, int idPais, String caracteristiques) {
        Ecosistema nouEcosistema = new Ecosistema(0, nom, idPais, caracteristiques);
        nouEcosistema.save();
        int idEcosistema = obtenirIdEcosistemaPerNom(nom);
        if (idEcosistema != -1) {
            ecosistemes.add(nouEcosistema);
        }
        return idEcosistema;
    }

    private static void associarFloraAEcosistema(int idFlora, int idEcosistema) {
        // Suposant que existeix una manera de comprovar si ja hi ha una entrada
        // Aquest exemple simplement fa l'actualització sense comprovació prèvia
        String sql = "INSERT INTO floraEcosistema (id_flora, id_ecosistema) VALUES (" + idFlora + ", " + idEcosistema + ")";
        AppData.getInstance().update(sql);
        floraEcosistema.put(idFlora, idEcosistema); // Assegura l'actualització del mapa
    }
    
    private static void associarFaunaAEcosistema(int idFauna, int idEcosistema) {
        // Igual que amb flora, s'actualitza sense comprovació prèvia
        String sql = "INSERT INTO faunaEcosistema (id_fauna, id_ecosistema) VALUES (" + idFauna + ", " + idEcosistema + ")";
        AppData.getInstance().update(sql);
        faunaEcosistema.put(idFauna, idEcosistema); // Assegura l'actualització del mapa
    }
    
    public static int obtenirIdPaisPerNom(String nomPais) {
        String sql = "SELECT id FROM paisos WHERE nom = '" + nomPais + "'";
        List<Map<String, Object>> resultats = AppData.getInstance().query(sql);
        if (!resultats.isEmpty()) {
            return (int) resultats.get(0).get("id");
        }
        return -1;
    }

    public static int obtenirIdFloraPerNomComu(String nomComu) {
        String sql = "SELECT id FROM flora WHERE nom_comu = \"" + nomComu + "\"";
        List<Map<String, Object>> resultats = AppData.getInstance().query(sql);
        if (!resultats.isEmpty()) {
            return (int) resultats.get(0).get("id");
        }
        return -1; // Retorna -1 si no es troba la flora
    }

    public static int obtenirIdFaunaPerNomComu(String nomComu) {
        String sql = "SELECT id FROM fauna WHERE nom_comu = \"" + nomComu + "\"";
        List<Map<String, Object>> resultats = AppData.getInstance().query(sql);
        if (!resultats.isEmpty()) {
            return (int) resultats.get(0).get("id");
        }
        return -1; // Retorna -1 si no es troba la fauna
    }

    public static int obtenirIdEcosistemaPerNom(String nom) {
        String sql = "SELECT id FROM ecosistemes WHERE nom = \"" + nom + "\"";
        List<Map<String, Object>> resultats = AppData.getInstance().query(sql);
        if (!resultats.isEmpty()) {
            return (int) resultats.get(0).get("id");
        }
        return -1; // Retorna -1 si no es troba l'ecosistema
    }

    private static void llistarPaisos() {
        System.out.println("Llista de Paisos:");
        for (Pais pais : paisos) {
            System.out.println(pais.toString());
        }

        System.out.println("Llista de Paisos de la base de dades:");
        AppData db = AppData.getInstance();
        String sql = "SELECT * FROM paisos";
        List<Map<String, Object>> result = db.query(sql);
        for (Map<String, Object> row : result) {
            int id = (int) row.get("id");
            String nom = (String) row.get("nom");
            System.out.println("Pais { Id: " + id + ", Nom: \"" + nom + "\" }");
        }
    }
    
    private static void llistarFlora() {
        System.out.println("Llista de Flora:");
        for (Flora planta : flora) {
            System.out.println(planta.toString());
        }
    
        System.out.println("Llista de Flora de la base de dades:");
        AppData db = AppData.getInstance();
        String sql = "SELECT * FROM flora";
        List<Map<String, Object>> result = db.query(sql);
        for (Map<String, Object> row : result) {
            int id = (int) row.get("id");
            String nomComu = (String) row.get("nom_comu");
            String nomCientific = (String) row.get("nom_cientific");
            int idPais = (int) row.get("id_pais");
            String habitat = (String) row.get("habitat");
            System.out.println("Flora { Id: " + id + ", Nom Comú: \"" + nomComu + "\", Nom Científic: \"" + nomCientific +
                               "\", Pais: " + idPais + ", Habitat: \"" + habitat + "\" }");
        }
    }
    
    private static void llistarFauna() {
        System.out.println("Llista de Fauna:");
        for (Fauna animal : fauna) {
            System.out.println(animal.toString());
        }
    
        System.out.println("Llista de Fauna de la base de dades:");
        AppData db = AppData.getInstance();
        String sql = "SELECT * FROM fauna";
        List<Map<String, Object>> result = db.query(sql);
        for (Map<String, Object> row : result) {
            int id = (int) row.get("id");
            String nomComu = (String) row.get("nom_comu");
            String nomCientific = (String) row.get("nom_cientific");
            int idPais = (int) row.get("id_pais");
            String habitat = (String) row.get("habitat");
            System.out.println("Fauna { Id: " + id + ", Nom Comú: \"" + nomComu + "\", Nom Científic: \"" + nomCientific +
                               "\", Pais: " + idPais + ", Habitat: \"" + habitat + "\" }");
        }
    }
    
    private static void llistarEcosistemes() {
        System.out.println("Llista d'Ecosistemes:");
        for (Ecosistema ecosistema : ecosistemes) {
            System.out.println(ecosistema.toString());
        }
    
        System.out.println("Llista d'Ecosistemes de la base de dades:");
        AppData db = AppData.getInstance();
        String sql = "SELECT * FROM ecosistemes";
        List<Map<String, Object>> result = db.query(sql);
        for (Map<String, Object> row : result) {
            int id = (int) row.get("id");
            String nom = (String) row.get("nom");
            int idPais = (int) row.get("id_pais");
            System.out.println("Ecosistema { Id: " + id + ", Nom: \"" + nom + "\", Id Pais: " + idPais + " }");
        }
    }
    
    private static void llistarFloraEcosistema(int idEcosistema) {
        System.out.println("Llista de Flora de l'Ecosistema " + idEcosistema + ":");
        for (Map.Entry<Integer, Integer> entrada : floraEcosistema.entrySet()) {
            if (entrada.getValue().equals(idEcosistema)) {
                Flora planta = flora.stream().filter(f -> f.getId() == entrada.getKey()).findFirst().orElse(null);
                if (planta != null) {
                    System.out.println(planta.toString());
                }
            }
        }
    }
    
    private static void llistarFaunaEcosistema(int idEcosistema) {
        System.out.println("Llista de Fauna de l'Ecosistema " + idEcosistema + ":");
        for (Map.Entry<Integer, Integer> entrada : faunaEcosistema.entrySet()) {
            if (entrada.getValue().equals(idEcosistema)) {
                Fauna animal = fauna.stream().filter(f -> f.getId() == entrada.getKey()).findFirst().orElse(null);
                if (animal != null) {
                    System.out.println(animal.toString());
                }
            }
        }
    }

    private static Identifiable obtenirReferencia(int id, List<? extends Identifiable> llista) {
        for (Identifiable item : llista) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }   
}

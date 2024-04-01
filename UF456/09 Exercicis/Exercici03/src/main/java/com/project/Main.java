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

package com.exercicis;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Random;

/**
    Introducció
    -----------

    En aquests exàmen es farà un gestor de dades per una notaria.

    Hi haurà diferents tipus de dades, 'clients' i 'operacions'.

    Exemples de com han de ser les dades:

    clients = {
        "client_100": {
            "nom": "Joan Garcia", 
            "edat": 45, 
            "factors": ["autònom", "risc mitjà"], 
            "descompte": 15
        },
        "client_401": {"nom": "Marta Pérez", "edat": 38, "factors": ["empresa", "risc baix"], "descompte": 10},
        "client_202": {"nom": "Pere López",  "edat": 52, "factors": ["autònom", "risc alt"],  "descompte": 5}
    }

    operacions = [
        {
            "id": "operacio_100", 
            "tipus": "Declaració d'impostos", 
            "clients": ["client_100", "client_202"], 
            "data": "2024-10-05", 
            "observacions": "Presentació conjunta", 
            "preu": 150.0
        },
        {"id": "operacio_304", "tipus": "Gestió laboral",    "clients": ["client_202"], "data": "2024-10-04", "observacions": "Contractació de personal",   "preu": 200.0},
        {"id": "operacio_406", "tipus": "Assessoria fiscal", "clients": ["client_401"], "data": "2024-10-03", "observacions": "Revisió d'informes", "preu": 120.0}
    ]
*/

public class Resolt0 {

    // Variables globals (es poden fer servir a totes les funcions)
    public static HashMap<String, HashMap<String, Object>> clients = new HashMap<>();
    public static ArrayList<HashMap<String, Object>> operacions = new ArrayList<>();

    // Neteja la consola tenint en compte el sistema operatiu
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Valida si un nom és vàlid.
     * Un nom és vàlid si no està buit i només conté lletres o espais
     * com a mínim a de tenir dues lletres
     *
     * @param nom El nom a validar.
     * @return True si el nom és vàlid, false altrament.
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testValidarNom"
     */
    public static boolean validarNom(String nom) {
        nom = nom.trim().toLowerCase(); 
    
        if (nom.isEmpty()) {
            return false;
        }
    
        String caractersAcceptats = " abcdefghijklmnopqrstuvwxyzàáèéìíòóùúäëïöüç";
    
        for (char car : nom.toCharArray()) {
            if (caractersAcceptats.indexOf(car) == -1) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Valida que l'edat sigui un valor vàlid.
     * Comprova que l'edat sigui un enter i que estigui dins del rang acceptable 
     * (entre 18 i 100, ambdós inclosos).
     *
     * @param edat L'edat que s'ha de validar.
     * @return True si l'edat es troba entre 18 i 100 (inclosos), false altrament.
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testValidarEdat"
     */
    public static boolean validarEdat(int edat) {

        return (edat >= 18 && edat <= 100);
    }

    /**
     * Valida que els factors proporcionats siguin vàlids.
     * Comprova que:
     * - Els factors siguin una llista amb exactament dos elements.
     * - El primer element sigui "autònom" o "empresa".
     * - El segon element sigui "risc alt", "risc mitjà" o "risc baix".
     * - Un "autònom" no pot ser de "risc baix".
     * 
     * Exemples:
     * validarFactors(new String[]{"autònom", "risc alt"})      // retorna true
     * validarFactors(new String[]{"empresa", "risc moderat"})  // retorna false
     *
     * @param factors Llista d'elements a validar.
     * @return True si els factors compleixen les condicions, false altrament.
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testValidarFactors"
     */
    public static boolean validarFactors(String[] factors) {
        if (factors != null && factors.length == 2) {
            String tipus = factors[0];
            String risc = factors[1];

            if ("autònom".equals(tipus) && "risc baix".equals(risc)) {
                return false;
            }

            return ("autònom".equals(tipus) || "empresa".equals(tipus)) &&
                ("risc alt".equals(risc) || "risc mitjà".equals(risc) || "risc baix".equals(risc));
        }
        return false;
    }

    /**
     * Valida que el descompte sigui un valor vàlid.
     * Comprova que:
     * - El descompte sigui un número vàlid (enter o decimal).
     * - El descompte es trobi dins del rang acceptable (entre 0 i 20, ambdós inclosos).
     *
     * Exemples:
     *  validarDescompte(15) retorna true
     *  validarDescompte(25) retorna false
     * 
     * @param descompte El valor del descompte a validar.
     * @return True si el descompte és vàlid, false altrament.
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testValidarDescompte"
     */
    public static boolean validarDescompte(double descompte) {
        return (descompte >= 0 && descompte <= 20);
    }

    /**
     * Valida que el tipus d'operació sigui vàlid.
     * Comprova que:
     * - El tipus d'operació proporcionat coincideixi amb algun dels tipus vàlids.
     * 
     * Els tipus vàlids inclouen:
     * "Declaració d'impostos", "Gestió laboral", "Assessoria fiscal",
     * "Constitució de societat", "Modificació d'escriptures",
     * "Testament", "Gestió d'herències", "Acta notarial",
     * "Contracte de compravenda", "Contracte de lloguer".
     *
     * Exemples:
     *  validarTipusOperacio("Declaració d'impostos") retorna true
     *  validarTipusOperacio("Operació desconeguda") retorna false
     * 
     * @param tipus El tipus d'operació a validar.
     * @return True si el tipus d'operació és vàlid, false altrament.
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testValidarTipusOperacio"
     */
    public static boolean validarTipusOperacio(String tipus) {
        String[] tipusValids = {
            "Declaració d'impostos", "Gestió laboral", "Assessoria fiscal",
            "Constitució de societat", "Modificació d'escriptures", 
            "Testament", "Gestió d'herències", "Acta notarial",
            "Contracte de compravenda", "Contracte de lloguer"
        };
        for (String tipusValid : tipusValids) {
            if (tipusValid.equals(tipus)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Valida que la llista de clients sigui vàlida.
     * Comprova que:
     * - La llista de clients sigui efectivament una llista.
     * - Una llista buida és vàlida.
     * - Tots els elements de la llista de clients siguin únics.
     * - Tots els clients de la llista es trobin dins de la llista global de clients vàlids.
     *
     * Exemples:
     *  validarClients(new ArrayList<>(List.of("client1", "client2")), 
     *                 new ArrayList<>(List.of("client1", "client2", "client3"))) retorna true
     *  validarClients(new ArrayList<>(List.of("client1", "client1")), 
     *                 new ArrayList<>(List.of("client1", "client2", "client3"))) retorna false
     *  validarClients(new ArrayList<>(), 
     *                 new ArrayList<>(List.of("client1", "client2", "client3"))) retorna true
     * 
     * @param clientsLlista La llista de clients a validar.
     * @param clientsGlobals La llista global de clients vàlids.
     * @return True si la llista de clients compleix totes les condicions, false altrament.
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testValidarClients"
     */
    public static boolean validarClients(ArrayList<String> clientsLlista, ArrayList<String> clientsGlobals) {
        if (clientsLlista == null || clientsGlobals == null) {
            return false;
        }

        HashMap<String, Integer> clientCount = new HashMap<>();

        // Compta la freqüència dels clients
        for (String client : clientsLlista) {
            if (clientCount.containsKey(client)) {
                clientCount.put(client, clientCount.get(client) + 1);
            } else {
                clientCount.put(client, 1);
            }
        }

        // Verifica si algun client és duplicat o no està a la llista global
        for (String client : clientsLlista) {
            if (clientCount.get(client) > 1 || !clientsGlobals.contains(client)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Comprova si una cadena conté només dígits.
     * 
     * @param str La cadena a comprovar.
     * @return True si la cadena conté només dígits, false altrament.
     *
     * @test ./runTest.sh "com.exercicis.TestExercici0#testIsAllDigits"
     */
    public static boolean isAllDigits(String str) {
        if (str.length() == 0) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Valida que la data sigui en un format vàlid (AAAA-MM-DD) i que representi una data possible.
     * Comprova que:
     * - La longitud de la cadena sigui exactament 10 caràcters.
     * - La cadena es pugui dividir en tres parts: any, mes i dia.
     * - Any, mes i dia estiguin formats per dígits.
     * - Any estigui en el rang [1000, 9999].
     * - Mes estigui en el rang [1, 12].
     * - Dia estigui en el rang [1, 31].
     * - Es compleixin les limitacions de dies segons el mes.
     *
     * Exemples:
     *  validarData("2023-04-15") retorna true
     *  validarData("2023-02-30") retorna false
     *  validarData("2023-13-01") retorna false
     * 
     *
     * @param data La cadena que representa una data en format 'AAAA-MM-DD'.
     * @return True si la data és vàlida, false altrament.
     *
     * @test ./runTest.sh "com.exercicis.TestExercici0#testValidarData"
     */
    public static boolean validarData(String data) {
        if (data == null || data.length() != 10) {
            return false;
        }
    
        // Verifica si els guions es troben a les posicions correctes
        if (data.charAt(4) != '-' || data.charAt(7) != '-') {
            return false;
        }
    
        String anyStr = data.substring(0, 4);
        String mesStr = data.substring(5, 7);
        String diaStr = data.substring(8, 10);
    
        // Verifica que cada part contingui només dígits
        if (!isAllDigits(anyStr) || !isAllDigits(mesStr) || !isAllDigits(diaStr)) {
            return false;
        }
    
        int any = Integer.parseInt(anyStr);
        int mes = Integer.parseInt(mesStr);
        int dia = Integer.parseInt(diaStr);
    
        if (any < 1000 || any > 9999) {
            return false;
        }
        if (mes < 1 || mes > 12) {
            return false;
        }
        if (dia < 1 || dia > 31) {
            return false;
        }
    
        // Mesos amb 30 dies
        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
            return false;
        }
    
        // Mes de febrer
        if (mes == 2) {
            boolean esAnyDeTraspas = (any % 4 == 0 && any % 100 != 0) || (any % 400 == 0);
            if (esAnyDeTraspas) {
                if (dia > 29) {
                    return false;
                }
            } else {
                if (dia > 28) {
                    return false;
                }
            }
        }
    
        return true;
    }

    /**
     * Valida que el preu sigui un número vàlid i superior a 100.
     * Comprova que:
     * - El preu sigui un número vàlid (decimal o enter).
     * - El valor del preu sigui estrictament superior a 100.
     *
     * Exemples:
     *  validarPreu(150.0) retorna true
     *  validarPreu(99.99) retorna false
     *  validarPreu(100.0) retorna false
     * 
     * @param preu El valor del preu a validar.
     * @return True si el preu és un número i és superior a 100, false altrament.
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testValidarPreu"
     */
    public static boolean validarPreu(double preu) {
        return preu > 100;
    }

    /**
     * Genera una clau única per a un client.
     * La clau és en el format "client_XYZ", on XYZ és un número aleatori entre 100 i 999.
     * Comprova que la clau generada no existeixi ja en el diccionari de clients.
     *
     * @return Una clau única per al client.
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testGeneraClauClient"
     */
    public static String generaClauClient() {
        Random random = new Random();
        String clau;

        do {
            int numeroAleatori = 100 + random.nextInt(900);
            clau = "client_" + numeroAleatori;
        } while (clients.containsKey(clau));

        return clau;
    }

    /**
     * Afegeix un nou client al diccionari de clients.
     * - Genera una nova clau amb "generaClauClient"
     * - Afegeix una entrada al diccionari de clients, 
     *   on la clau és la nova clau generada i el valor és un HashMap 
     *   amb el nom, edat, factors i descompte del nou client.
     *
     * Exemples:
     *  afegirClient(clients, "Maria", 30, new ArrayList<>(List.of("empresa", "risc baix")), 10) retorna "client_0"
     *
     * @param nom El nom del nou client.
     * @param edat L'edat del nou client.
     * @param factors La llista de factors associats al client.
     * @param descompte El descompte associat al nou client.
     * @return La clau del nou client afegit.
     *
     * @test ./runTest.sh "com.exercicis.TestExercici0#testAfegirClient"
     */
    public static String afegirClient(String nom, int edat, ArrayList<String> factors, double descompte) {

        String novaClau = generaClauClient();
    
        HashMap<String, Object> clientInfo = new HashMap<>();
        clientInfo.put("nom", nom);
        clientInfo.put("edat", edat);
        clientInfo.put("factors", factors);
        clientInfo.put("descompte", descompte);
    
        clients.put(novaClau, clientInfo);
    
        return novaClau;
    }

    /**
     * Modifica un camp específic d'un client al diccionari de clients.
     * - Comprova si la clau del client existeix al diccionari de clients.
     * - Si existeix, comprova si el camp que es vol modificar és vàlid (existeix dins del diccionari del client).
     * - Si el camp existeix, actualitza el valor del camp amb el nou valor.
     * - Si el camp no existeix, retorna un missatge d'error indicant que el camp no existeix.
     * - Si la clau del client no existeix, retorna un missatge d'error indicant que el client no es troba.
     * 
     * Retorn:
     * - Retorna "Client 'client_XYZ' no existeix." si el client no existeix
     * - Retorna "El camp 'campErroni' si el camp no existeix en aquest client
     * - "OK" si s'ha modificat el camp per aquest client
     * 
     * @param clauClient La clau del client que s'ha de modificar.
     * @param camp El camp que s'ha de modificar.
     * @param nouValor El nou valor que s'ha d'assignar al camp.
     * @return Un missatge d'error si el client o el camp no existeixen; "OK" altrament.
     *
     * @test ./runTest.sh "com.exercicis.TestExercici0#testModificarClient"
     */
    public static String modificarClient(String clauClient, String camp, Object nouValor) {
        if (!clients.containsKey(clauClient)) {
            return "Client '" + clauClient + "' no existeix.";
        }

        HashMap<String, Object> client = (HashMap<String, Object>) clients.get(clauClient);
        if (!client.containsKey(camp)) {
            return "El camp " + camp + " no existeix.";
        }

        client.put(camp, nouValor);

        return "OK";
    }

    /**
     * Esborra un client del diccionari de clients.
     * Comprova:
     * - Si la clau del client existeix dins del diccionari de clients.
     * - Si la clau del client existeix, elimina el client del diccionari.
     * - Si la clau del client no existeix, retorna un missatge d'error.
     *
     * Retorn:
     * - Si el client no existeix, retorna un missatge d'error: "Client amb clau {clauClient} no existeix."
     * - Si el client existeix, l'elimina i retorna "OK".
     *
     * @param clauClient La clau del client que s'ha d'esborrar.
     * @return Un missatge d'error si el client no existeix o "OK" si s'ha esborrat correctament.
     * @test ./runTest.sh "com.exercicis.TestExercici0#testEsborrarClient"
     */
    public static String esborrarClient(String clauClient) {
        if (!clients.containsKey(clauClient)) {
            return "Client amb clau " + clauClient + " no existeix.";
        }

        clients.remove(clauClient);
        return "OK";
    }

    /**
     * Llista clients que compleixen determinades condicions.
     * Comprova si els clients que coincideixen amb les claus 
     * especificades compleixen les condicions proporcionades.
     * 
     * @param claus La llista de claus de clients a considerar per la cerca.
     * @param condicions Les condicions que els clients han de complir.
     * @return Una llista de diccionaris, on cada diccionari conté 
     *         la clau del client i les dades del client.
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testLlistarClients"
     */
    public static ArrayList<HashMap<String, HashMap<String, Object>>> llistarClients(
            ArrayList<String> claus,
            HashMap<String, Object> condicions) {
        
        ArrayList<HashMap<String, HashMap<String, Object>>> resultat = new ArrayList<>();

        for (String clau : clients.keySet()) {
            if (!claus.contains(clau)) {
                continue;
            }

            HashMap<String, Object> dades = clients.get(clau);
            boolean coincideix = true;

            for (String key : condicions.keySet()) {
                Object valorEsperat = condicions.get(key);

                if (!dades.containsKey(key) || !dades.get(key).equals(valorEsperat)) {
                    coincideix = false;
                    break;
                }
            }

            if (coincideix) {
                HashMap<String, HashMap<String, Object>> clientValid = new HashMap<>();
                clientValid.put(clau, dades);
                resultat.add(clientValid);
            }
        }

        return resultat;
    }

    /**
     * Genera una clau única per a una operació.
     * La clau és en el format "operacio_XYZ", on XYZ és un número aleatori entre 100 i 999.
     * Comprova que la clau generada no existeixi ja en la llista d'operacions.
     *
     * @return Una clau única per a l'operació.
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testGeneraClauOperacio"
     */
    public static String generaClauOperacio() {
        Random random = new Random();
        String clau;
    
        boolean existeix;
        do {
            int numeroAleatori = 100 + random.nextInt(900); // Genera un número entre 100 i 999
            clau = "operacio_" + numeroAleatori;
    
            // Comprova si la clau ja existeix a la llista d'operacions
            existeix = false;
            for (HashMap<String, Object> operacio : operacions) {
                if (clau.equals(operacio.get("id"))) {
                    existeix = true;
                    break;
                }
            }
        } while (existeix);
    
        return clau;
    }

    /**
     * Afegeix una nova operació a la llista d'operacions.
     * - Genera un nova clau amb "generaClauOperacio"
     * - Crea un HashMap que representa la nova operació amb els camps següents:
     *   - "id": clau de l'operació.
     *   - "tipus": el tipus d'operació.
     *   - "clients": llista de clients implicats.
     *   - "data": la data de l'operació.
     *   - "observacions": observacions de l'operació.
     *   - "preu": preu de l'operació.
     * - Afegeix aquest HashMap a la llista d'operacions.
     * 
     * @param tipus El tipus d'operació.
     * @param clientsImplicats La llista de clients implicats.
     * @param data La data de l'operació.
     * @param observacions Observacions addicionals sobre l'operació.
     * @param preu El preu associat a l'operació.
     * @return L'identificador de la nova operació.
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testAfegirOperacio"
     */
    public static String afegirOperacio(
            String tipus,
            ArrayList<String> clientsImplicats,
            String data,
            String observacions,
            double preu) {

        String nouId = generaClauOperacio();

        HashMap<String, Object> operacio = new HashMap<>();
        operacio.put("id", nouId);
        operacio.put("tipus", tipus);
        operacio.put("clients", clientsImplicats);
        operacio.put("data", data);
        operacio.put("observacions", observacions);
        operacio.put("preu", preu);

        operacions.add(operacio); 
        return nouId;
    }

    /**
     * Modifica un camp específic d'una operació dins de la llista d'operacions.
     * 
     * @param idOperacio L'identificador de l'operació que s'ha de modificar.
     * @param camp El camp específic dins del HashMap de l'operació que s'ha de modificar.
     * @param nouValor El nou valor que es vol assignar al camp especificat.
     * @return Un missatge d'error si l'operació o el camp no existeix, "OK" 
     *         si la modificació s'ha realitzat correctament.
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testModificarOperacio"
     */
    public static String modificarOperacio(String idOperacio, String camp, Object nouValor) {
        for (HashMap<String, Object> operacio : operacions) {
            if (operacio.get("id").equals(idOperacio)) {
                if (operacio.containsKey(camp)) {
                    operacio.put(camp, nouValor);
                    return "OK";
                } else {
                    return "El camp " + camp + " no existeix en l'operació.";
                }
            }
        }
        return "Operació amb id " + idOperacio + " no existeix.";
    }

    /**
     * Esborra una operació de la llista d'operacions basada en l'identificador de l'operació.
     * 
     * @param idOperacio L'identificador de l'operació que es vol esborrar.
     * @return Un missatge d'error si l'operació amb 'idOperacio' no existeix, "OK" si s'esborra correctament.
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testEsborrarOperacio"
     */
    public static String esborrarOperacio(String idOperacio) {
        for (int i = 0; i < operacions.size(); i++) {
            HashMap<String, Object> operacio = operacions.get(i);
            if (operacio.get("id").equals(idOperacio)) {
                operacions.remove(i);
                return "OK";
            }
        }
        return "Operació amb id " + idOperacio + " no existeix.";
    }

    /**
     * Llista les operacions que compleixen determinats criteris basats 
     * en identificadors i condicions específiques.
     * 
     * @param ids Una llista d'identificadors d'operacions que es volen considerar. 
     *            Si està buida, es consideren totes les operacions.
     * @param condicions Un HashMap amb les condicions que les operacions han de complir.
     * @return Una llista amb les operacions que compleixen les condicions.
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testLlistarOperacions"
     */
    public static ArrayList<HashMap<String, Object>> llistarOperacions(
            ArrayList<String> ids,
            HashMap<String, Object> condicions) {

        ArrayList<HashMap<String, Object>> resultat = new ArrayList<>();

        for (HashMap<String, Object> operacio : operacions) {
            // Si hi ha una llista d'ids i l'operació no està a la llista, passa a la següent
            if (ids != null && !ids.isEmpty() && !ids.contains(operacio.get("id"))) {
                continue;
            }

            boolean coincideix = true;

            // Comprova si totes les condicions es compleixen
            if (condicions != null && !condicions.isEmpty()) {
                for (String key : condicions.keySet()) {
                    if (!operacio.containsKey(key) || !operacio.get(key).equals(condicions.get(key))) {
                        coincideix = false;
                        break;
                    }
                }
            }

            // Si l'operació compleix les condicions, afegeix-la al resultat
            if (coincideix) {
                resultat.add(operacio);
            }
        }

        return resultat;
    }

    /**
     * Llista les operacions associades a un client específic basant-se en la seva clau.
     * 
     * @param clauClient La clau única del client que es vol filtrar.
     * @return Una llista amb les operacions associades al client especificat.
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testLlistarOperacionsClient"
     */
    public static ArrayList<HashMap<String, Object>> llistarOperacionsClient(String clauClient) {
        ArrayList<HashMap<String, Object>> resultat = new ArrayList<>();

        for (HashMap<String, Object> operacio : operacions) {
            ArrayList<String> clients = (ArrayList<String>) operacio.get("clients");
            if (clients != null && clients.contains(clauClient)) {
                resultat.add(operacio);
            }
        }

        return resultat;
    }

    /**
     * Mètode que formata i alinea columnes de text 
     * segons les especificacions donades.
     * 
     * El mètode processa cada columna:
     * - Si el text és més llarg que l'amplada especificada, el trunca
     * - Afegeix els espais necessaris segons el tipus d'alineació:
     *   * "left": alinea el text a l'esquerra i omple amb espais a la dreta
     *   * "right": omple amb espais a l'esquerra i alinea el text a la dreta
     *   * "center": distribueix els espais entre esquerra i dreta per centrar el text
     * 
     * @param columnes ArrayList que conté arrays d'Objects, on cada array representa una columna amb:
     *                 - posició 0: String amb el text a mostrar
     *                 - posició 1: String amb el tipus d'alineació ("left", "right", "center")
     *                 - posició 2: int amb l'amplada total de la columna
     * 
     * @return String amb totes les columnes formatades concatenades
     * 
     * Per exemple:
     * Si input és: {{"Hola", "left", 6}, {"Mon", "right", 5}}
     * Output seria: "Hola    Mon"
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testAlineaColumnes"
     */
    public static String alineaColumnes(ArrayList<Object[]> columnes) {
        StringBuilder result = new StringBuilder();
        
        for (Object[] columna : columnes) {
            String text = (String) columna[0];
            String alineacio = (String) columna[1];
            int ample = (int) columna[2];
            
            // Assegurem que el text no és més llarg que l'ample
            if (text.length() > ample) {
                text = text.substring(0, ample);
            }
            
            // Calculem els espais necessaris
            int espais = ample - text.length();
            
            switch (alineacio) {
                case "left":
                    result.append(text);
                    result.append(" ".repeat(espais));
                    break;
                case "right":
                    result.append(" ".repeat(espais));
                    result.append(text);
                    break;
                case "center":
                    int espaisEsquerra = espais / 2;
                    int espaisDreta = espais - espaisEsquerra;
                    result.append(" ".repeat(espaisEsquerra));
                    result.append(text);
                    result.append(" ".repeat(espaisDreta));
                    break;
            }
        }
        
        return result.toString();
    }

    /**
     * Genera una representació en forma de taula de les operacions 
     * associades a un client específic.
     * 
     * Cada linia del resultat es guarda en un String de l'ArrayList.
     * 
     * Fes servir: Locale.setDefault(Locale.US)
     * 
     * Format esperat de sortida:
     * ```
Marta Puig i Puig, 45               [empresa, risc alt]
-------------------------------------------------------
Tipus                         Data                 Preu
Constitució de societat       2024-01-15        1250.50
Testament                     2024-02-28         750.75
Acta notarial                 2024-03-10         500.25
-------------------------------------------------------
                                          Suma: 2501.50
Descompte: 10%                            Preu: 2126.28
Impostos:  21% (85.05)                   Total: 2572.80

*******************************************************

Pere Vila, 25                    [estudiant, risc baix]
-------------------------------------------------------
Tipus                         Data                 Preu
Certificat                    2024-01-10          25.50
Fotocòpia                     2024-01-15          15.25
Segell                        2024-01-20          35.50
-------------------------------------------------------
                                            Suma: 76.25
Descompte: 10%                              Preu: 68.63
Impostos:  21% (14.41)                     Total: 83.04
     * ```
     * On:
     * - La primera línia mostra el nom, edat i factors del client
     * - Els tipus d'operació s'alineen a l'esquerra
     * - Les dates tenen format YYYY-MM-DD
     * - Els preus mostren sempre 2 decimals
     * - El descompte és un percentatge enter
     * - Els impostos són sempre el 21% del preu amb descompte
     *
     * @param clauClient La clau única del client per generar la taula d'operacions.
     * @param ordre El camp pel qual s'ordenaran les operacions (exemple: "data", "preu").
     * @return Una llista de cadenes de text que representen les línies de la taula.
     *
     * @test ./runTest.sh "com.exercicis.TestExercici0#testTaulaOperacionsClient0"
     * @test ./runTest.sh "com.exercicis.TestExercici0#testTaulaOperacionsClient1"
     * @test ./runTest.sh "com.exercicis.TestExercici0#testTaulaOperacionsClient2"
     */
    public static ArrayList<String> taulaOperacionsClient(String clauClient, String ordre) {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            HashMap<String, Object> client = clients.get(clauClient);
            if (client == null) {
                ArrayList<String> error = new ArrayList<>();
                error.add("Client amb clau " + clauClient + " no existeix.");
                return error;
            }
    
            ArrayList<HashMap<String, Object>> operacionsClient = llistarOperacionsClient(clauClient);
            operacionsClient.sort((o1, o2) -> {
                Object val1 = o1.get(ordre);
                Object val2 = o2.get(ordre);
                return val1.toString().compareTo(val2.toString());
            });
    
            ArrayList<String> linies = new ArrayList<>();
            
            // Format del camp factors
            String nomEdat = client.get("nom") + ", " + client.get("edat");
            String factors = "[" + String.join(", ", (ArrayList<String>) client.get("factors")) + "]";
            
            // Primera línia amb nom, edat i factors
            ArrayList<Object[]> columnesCapcalera = new ArrayList<>();
            columnesCapcalera.add(new Object[]{nomEdat, "left", 25});
            columnesCapcalera.add(new Object[]{factors, "right", 30});
            linies.add(alineaColumnes(columnesCapcalera));
            
            // Línia separadora
            linies.add("-".repeat(55));
            
            // Capçalera de la taula
            ArrayList<Object[]> columnesTitols = new ArrayList<>();
            columnesTitols.add(new Object[]{"Tipus", "left", 30});
            columnesTitols.add(new Object[]{"Data", "left", 10});
            columnesTitols.add(new Object[]{"Preu", "right", 15});
            linies.add(alineaColumnes(columnesTitols));
            
            double sumaPreus = 0.0;
            // Afegir les operacions
            for (HashMap<String, Object> operacio : operacionsClient) {
                ArrayList<Object[]> columnesOperacio = new ArrayList<>();
                columnesOperacio.add(new Object[]{operacio.get("tipus").toString(), "left", 30});
                columnesOperacio.add(new Object[]{operacio.get("data").toString(), "left", 10});
                
                double preu = ((Number) operacio.get("preu")).doubleValue();
                columnesOperacio.add(new Object[]{String.format("%.2f", preu), "right", 15});
                
                linies.add(alineaColumnes(columnesOperacio));
                sumaPreus += preu;
            }
            
            // Línia separadora
            linies.add("-".repeat(55));
            
            // Càlculs finals
            int descomptePercentatge = 10;
            double percentatge = (100 - descomptePercentatge);
            double preuDescomptat = sumaPreus * (percentatge / 100.0); 
            double impostos = preuDescomptat * 0.21;
            double total = preuDescomptat + impostos;
    
            // Línia de suma
            ArrayList<Object[]> columnesTotals = new ArrayList<>();
            columnesTotals.add(new Object[]{String.format("Suma: %.2f", sumaPreus), "right", 55});
            linies.add(alineaColumnes(columnesTotals));
    
            // Línia de descompte
            ArrayList<Object[]> columnesDescompte = new ArrayList<>();
            columnesDescompte.add(new Object[]{String.format("Descompte: %d%%", descomptePercentatge), "left", 30});
            columnesDescompte.add(new Object[]{String.format("Preu: %.2f", preuDescomptat), "right", 25});
            linies.add(alineaColumnes(columnesDescompte));
    
            // Línia d'impostos
            ArrayList<Object[]> columnesImpostos = new ArrayList<>();
            columnesImpostos.add(new Object[]{String.format("Impostos:  21%% (%.2f)", impostos), "left", 30});
            columnesImpostos.add(new Object[]{String.format("Total: %.2f", total), "right", 25});
            linies.add(alineaColumnes(columnesImpostos));
            
            return linies;
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    /**
     * Genera el menú principal de l'aplicació de Gestió de Notaria.
     * 
     * Retorna una llista de cadenes de text que representen 
     * les opcions disponibles en el menú principal de l'aplicació.
     *
     * @return Una llista de cadenes de text amb les opcions del menú principal.
     *
     * @test ./runTest.sh "com.exercicis.TestExercici0#testGetCadenesMenu"
     */
    public static ArrayList<String> getCadenesMenu() {
        String menuText = """
=== Menú de Gestió de Notaria ===
1. Afegir client
2. Modificar client
3. Esborrar client
4. Llistar clients
5. Afegir operació
6. Modificar operació
7. Esborrar operació
8. Llistar operacions
0. Sortir
            """;
        String[] lines = menuText.split("\\R");
        return new ArrayList<>(Arrays.asList(lines));
    }

    /**
     * Genera el menú amb la llista de clients.
     * 
     * Retorna una llista de cadenes de text que representen 
     * cada un dels clients de la llista.
     * - El primer text de la llista és així: "=== Llistar Clients ==="
     * - En cas de no haver-hi cap client afegeix a la llista de retorn "No hi ha clients per mostrar."
     *
     * @return Una llista de cadenes de text amb els clients.
     *
     * @test ./runTest.sh "com.exercicis.TestExercici0#testLlistarClientsMenu"
     */
    public static ArrayList<String> getLlistarClientsMenu() {
        ArrayList<String> linies = new ArrayList<>();
        linies.add("=== Llistar Clients ===");
    
        if (clients.isEmpty()) {
            linies.add("No hi ha clients per mostrar.");
            return linies;
        }
    
        for (String clau : clients.keySet()) {
            linies.add(clau + ": " + clients.get(clau).toString());
        }
    
        return linies;
    }

    /**
     * Escriu per consola cada element d'una llista en una línia nova.
     * 
     * @param llista La llista de linies a mostrar
     *
     * @test ./runTest.sh "com.exercicis.TestExercici0#testDibuixarLlista"
     */
    public static void dibuixarLlista(ArrayList<String> llista) {
        for (String linia : llista) {
            System.out.println(linia);
        }
    }
    

    /**
     * Demana a l'usuari que seleccioni una opció i retorna l'opció transformada a una paraula clau si és un número.
     * 
     * Mostra el text: "Selecciona una opció (número o paraula clau): ".
     * - Si l'opció introduïda és un número vàlid, es transforma a les paraules clau corresponents segons el menú.
     * - Si l'opció són paraules clau vàlides, es retornen directament.
     *   Les paraules clau han d'ignorar les majúscules, minúscules i accents
     * - Si l'opció no és vàlida, mostra un missatge d'error i torna a preguntar fins que l'entrada sigui vàlida.
     *   "Opció no vàlida. Torna a intentar-ho."
     * 
     * Relació de números i paraules clau:
     *  1. "Afegir client"
     *  2. "Modificar client"
     *  3. "Esborrar client"
     *  4. "Llistar clients"
     *  5. "Afegir operació"
     *  6. "Modificar operació"
     *  7. "Esborrar operació"
     *  8. "Llistar operacions"
     *  0. "Sortir"
     * 
     * @return La cadena introduïda per l'usuari (número convertit a paraula clau o paraula clau validada).
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testObtenirOpcio"
     */
    public static String obtenirOpcio(Scanner scanner) {
        ArrayList<String> menu = getCadenesMenu();
        
        while (true) {
            System.out.print("Selecciona una opció (número o paraula clau): ");

            String opcio = scanner.nextLine();
            
            // Comprova si és un número
            try {
                int index = Integer.parseInt(opcio);
                if (index == 0) {
                    return "Sortir";
                } else if (index > 0 && index < menu.size() - 1) {
                    return menu.get(index).substring(3).trim();
                }
            } catch (NumberFormatException e) {
                // Si no és un número, continuem amb la comprovació de paraula clau
            }
            
            // Comprova si és una paraula clau
            String opcioNormalized = opcio.trim().toLowerCase().replace("ó", "o");
            
            for (int i = 0; i < menu.size(); i++) {
                String paraulaClau = menu.get(i).substring(3).trim();
                String paraulaClauNormalized = paraulaClau.toLowerCase().replace("ó", "o");
                
                if (paraulaClauNormalized.equals(opcioNormalized)) {
                    return paraulaClau;
                }
            }
            
            // Si arribem aquí, l'opció no és vàlida
            System.out.println("Opció no vàlida. Torna a intentar-ho.");
        }
    }

    /**
     * Demana i valida el nom d'un client.
     * Mostra el missatge "Introdueix el nom del client: " i valida que el nom sigui correcte.
     * Si el nom no és vàlid, afegeix el missatge d'error a la llista i torna a demanar el nom.
     * Fes servir la funció "validarNom"
     *
     * @param scanner Scanner per llegir l'entrada de l'usuari
     * @return El nom validat del client
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testLlegirNom"
     */
    public static String llegirNom(Scanner scanner) {
        System.out.print("Introdueix el nom del client: ");
        String nom = scanner.nextLine().trim();
        
        while (!validarNom(nom)) {
            System.out.println("Nom no vàlid. Només s'accepten lletres i espais.");
            System.out.print("Introdueix el nom del client: ");
            nom = scanner.nextLine().trim();
        }
        return nom;
    }

    /**
     * Demana i valida l'edat d'un client.
     * Mostra el missatge "Introdueix l'edat del client (18-100): " i valida que l'edat sigui correcta.
     * Si l'edat no és vàlida, afegeix el missatge d'error a la llista i torna a demanar l'edat.
     * Fes servir les funcions "isAllDigits" i "validarEdat"
     *
     * @param scanner Scanner per llegir l'entrada de l'usuari
     * @return L'edat validada del client
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testLlegirEdat"
     */
    public static int llegirEdat(Scanner scanner) {
        System.out.print("Introdueix l'edat del client (18-100): ");
        String edatInput = scanner.nextLine().trim();
        
        while (!isAllDigits(edatInput) || !validarEdat(Integer.parseInt(edatInput))) {
            System.out.println("Edat no vàlida. Introdueix un número entre 18 i 100.");
            System.out.print("Introdueix l'edat del client (18-100): ");
            edatInput = scanner.nextLine().trim();
        }
        return Integer.parseInt(edatInput);
    }
    
    /**
     * Demana i valida els factors d'un client.
     * Primer demana el tipus de client (autònom/empresa) i després el nivell de risc.
     * Per autònoms, només permet 'risc alt' o 'risc mitjà'.
     * Per empreses, permet 'risc alt', 'risc mitjà' o 'risc baix'.
     * 
     * Mostra els següents missatges:
     * - "Introdueix el primer factor ('autònom' o 'empresa'): "
     * - Per autònoms: "Introdueix el segon factor ('risc alt' o 'risc mitjà'): "
     * - Per empreses: "Introdueix el segon factor ('risc alt', 'risc baix' o 'risc mitjà'): "
     *
     * @param scanner Scanner per llegir l'entrada de l'usuari
     * @return ArrayList amb els dos factors validats
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testLlegirFactors"
     */
    public static ArrayList<String> llegirFactors(Scanner scanner) {
        ArrayList<String> factors = new ArrayList<>();
        
        // Llegir primer factor
        System.out.print("Introdueix el primer factor ('autònom' o 'empresa'): ");
        String factor1 = scanner.nextLine().trim();
        while (!factor1.equals("autònom") && !factor1.equals("empresa")) {
            System.out.println("Factor no vàlid. Ha de ser 'autònom' o 'empresa'.");
            System.out.print("Introdueix el primer factor ('autònom' o 'empresa'): ");
            factor1 = scanner.nextLine().trim();
        }
        factors.add(factor1);
        
        // Llegir segon factor
        String promptFactor2 = factor1.equals("autònom")
                ? "Introdueix el segon factor ('risc alt' o 'risc mitjà'): "
                : "Introdueix el segon factor ('risc alt', 'risc baix' o 'risc mitjà'): ";
        
        System.out.print(promptFactor2);
        String factor2 = scanner.nextLine().trim();
        while (true) {
            if (factor1.equals("autònom")) {
                if (factor2.equals("risc alt") || factor2.equals("risc mitjà")) break;
                System.out.println("Factor no vàlid. Per a autònoms només pot ser 'risc alt' o 'risc mitjà'.");
            } else {
                if (factor2.equals("risc alt") || factor2.equals("risc baix") || factor2.equals("risc mitjà")) break;
                System.out.println("Factor no vàlid. Ha de ser 'risc alt', 'risc baix' o 'risc mitjà'.");
            }
            System.out.print(promptFactor2);
            factor2 = scanner.nextLine().trim();
        }
        factors.add(factor2);
        
        return factors;
    }
    
    /**
     * Demana i valida un descompe
     * Primer demana el descompte amb: 
     * "Introdueix el descompte (0-20): "
     * 
     * Mostra el següent missatge en cas d'error: 
     * "Descompte no vàlid. Ha de ser un número entre 0 i 20."
     *
     * @param scanner Scanner per llegir l'entrada de l'usuari
     * @return ArrayList amb els dos factors validats
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testLlegirDescompte"
     */
    public static double llegirDescompte(Scanner scanner) {
        System.out.print("Introdueix el descompte (0-20): ");
        String descompteInput = scanner.nextLine().trim();
        
        while (!descompteInput.matches("\\d+(\\.\\d+)?") || !validarDescompte(Double.parseDouble(descompteInput))) {
            System.out.println("Descompte no vàlid. Ha de ser un número entre 0 i 20.");
            System.out.print("Introdueix el descompte (0-20): ");
            descompteInput = scanner.nextLine().trim();
        }
        
        return Double.parseDouble(descompteInput);
    }

    /**
     * Gestiona el procés d'afegir un nou client mitjançant interacció amb l'usuari.
     * Utilitza les següents funcions auxiliars per obtenir i validar les dades:
     * - llegirNom: per obtenir el nom del client
     * - llegirEdat: per obtenir l'edat (entre 18 i 100)
     * - llegirFactors: per obtenir el tipus (autònom/empresa) i nivell de risc
     * - llegirDescompte: per obtenir el descompte (entre 0 i 20)
     * 
     * La primera línia del retorn sempre és "=== Afegir Client ==="
     * 
     * Missatges d'error que s'afegeixen a la llista de retorn per les funcions auxiliars:
     * - "Nom no vàlid. Només s'accepten lletres i espais."
     * - "Edat no vàlida. Introdueix un número entre 18 i 100."
     * - "Factor no vàlid. Ha de ser 'autònom' o 'empresa'."
     * - "Factor no vàlid. Per a autònoms només pot ser 'risc alt' o 'risc mitjà'."
     * - "Factor no vàlid. Ha de ser 'risc alt', 'risc baix' o 'risc mitjà'."
     * - "Els factors no són vàlids."
     * - "Descompte no vàlid. Ha de ser un número entre 0 i 20."
     * 
     * En cas d'èxit, s'afegeix a la llista:
     * - "S'ha afegit el client amb clau " + novaClau + "."
     * 
     * @param scanner L'objecte Scanner per rebre l'entrada de l'usuari
     * @return Una llista de cadenes de text que contenen els missatges d'estat del procés
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testAfegirClientMenu"
     */
    public static ArrayList<String> afegirClientMenu(Scanner scanner) {
        ArrayList<String> linies = new ArrayList<>();
        linies.add("=== Afegir Client ===");
    
        String nom = llegirNom(scanner);
        int edat = llegirEdat(scanner);
        ArrayList<String> factors = llegirFactors(scanner);
        
        if (!validarFactors(factors.toArray(new String[0]))) {
            linies.add("Els factors no són vàlids.");
            return linies;
        }
        
        double descompte = llegirDescompte(scanner);
        
        String novaClau = afegirClient(nom, edat, factors, descompte);
        linies.add("S'ha afegit el client amb clau " + novaClau + ".");
        return linies;
    }
    
    /**
     * Gestiona el procés de modificació d'un client existent.
     * 
     * Primer demana i valida la clau del client:
     * - "Introdueix la clau del client a modificar (per exemple, 'client_100'): "
     * 
     * Si el client existeix:
     * - Mostra "Camps disponibles per modificar: nom, edat, factors, descompte"
     * - Demana "Introdueix el camp que vols modificar: "
     * 
     * Segons el camp escollit, utilitza les funcions auxiliars:
     * - llegirNom: si es modifica el nom
     * - llegirEdat: si es modifica l'edat
     * - llegirFactors: si es modifiquen els factors
     * - llegirDescompte: si es modifica el descompte
     * 
     * La primera línia del retorn sempre és "=== Modificar Client ==="
     * 
     * Missatges d'error que s'afegeixen a la llista de retorn:
     * - "Client amb clau " + clauClient + " no existeix."
     * - "El camp " + camp + " no és vàlid."
     * 
     * Més els missatges d'error de les funcions auxiliars:
     * - "Nom no vàlid. Només s'accepten lletres i espais."
     * - "Edat no vàlida. Introdueix un número entre 18 i 100."
     * - "Factor no vàlid. Ha de ser 'autònom' o 'empresa'."
     * - "Factor no vàlid. Per a autònoms només pot ser 'risc alt' o 'risc mitjà'."
     * - "Factor no vàlid. Ha de ser 'risc alt', 'risc baix' o 'risc mitjà'."
     * - "Els factors no són vàlids."
     * - "Descompte no vàlid. Ha de ser un número entre 0 i 20."
     * 
     * En cas d'èxit, s'afegeix a la llista:
     * - "S'ha modificat el client " + clauClient + "."
     * 
     * @param scanner L'objecte Scanner per rebre l'entrada de l'usuari
     * @return Una llista de cadenes de text que contenen els missatges d'estat del procés
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testModificarClientMenu"
     */
    public static ArrayList<String> modificarClientMenu(Scanner scanner) {
        ArrayList<String> linies = new ArrayList<>();
        linies.add("=== Modificar Client ===");
    
        // Llegir clau client
        System.out.print("Introdueix la clau del client a modificar (per exemple, 'client_100'): ");
        String clauClient = scanner.nextLine().trim();
        if (!clients.containsKey(clauClient)) {
            linies.add("Client amb clau " + clauClient + " no existeix.");
            return linies;
        }
    
        // Llegir camp a modificar
        linies.add("Camps disponibles per modificar: nom, edat, factors, descompte");
        System.out.print("Introdueix el camp que vols modificar: ");
        String camp = scanner.nextLine().trim();
        if (!Arrays.asList("nom", "edat", "factors", "descompte").contains(camp)) {
            linies.add("El camp " + camp + " no és vàlid.");
            return linies;
        }
    
        // Llegir nou valor segons el camp
        Object nouValor = switch (camp) {
            case "nom" -> llegirNom(scanner);
            case "edat" -> llegirEdat(scanner);
            case "factors" -> {
                ArrayList<String> factors = llegirFactors(scanner);
                if (!validarFactors(factors.toArray(new String[0]))) {
                    linies.add("Els factors no són vàlids.");
                    yield null;
                }
                yield factors;
            }
            case "descompte" -> llegirDescompte(scanner);
            default -> null;
        };
    
        if (nouValor == null) return linies;
    
        String resultat = modificarClient(clauClient, camp, nouValor);
        if (!resultat.equals("OK")) {
            linies.add(resultat);
        } else {
            linies.add("S'ha modificat el client " + clauClient + ".");
        }
    
        return linies;
    }

    /**
     * Gestiona el procés d'esborrar un client existent mitjançant interacció amb l'usuari.
     * 
     * Mostra per pantalla el següent missatge per demanar dades:
     * - "Introdueix la clau del client a esborrar (per exemple, 'client_100'): "
     * 
     * La primera línia del retorn sempre és "=== Esborrar Client ==="
     * 
     * Missatges d'error que s'afegeixen a la llista de retorn:
     * - "Client amb clau " + clauClient + " no existeix."
     * 
     * En cas d'èxit, s'afegeix a la llista:
     * - "S'ha esborrat el client " + clauClient + "."
     * 
     * @param scanner L'objecte Scanner per rebre l'entrada de l'usuari.
     * @return Una llista de cadenes de text que contenen els missatges d'estat del procés.
     * 
     * @test ./runTest.sh "com.exercicis.TestExercici0#testEsborrarClientMenu"
     */
    public static ArrayList<String> esborrarClientMenu(Scanner scanner) {
        ArrayList<String> linies = new ArrayList<>();
        linies.add("=== Esborrar Client ===");

        System.out.print("Introdueix la clau del client a esborrar (per exemple, 'client_100'): ");
        String clauClient = scanner.nextLine().trim();

        if (!clients.containsKey(clauClient)) {
            linies.add("Client amb clau " + clauClient + " no existeix.");
            return linies;
        }

        String resultat = esborrarClient(clauClient);
        if (!resultat.equals("OK")) {
            linies.add(resultat);
        } else {
            linies.add("S'ha esborrat el client " + clauClient + ".");
        }

        return linies;
    }

    /**
     * Gestiona el menú principal de l'aplicació i l'execució de les operacions.
     *
     * Aquesta funció implementa un bucle que:
     * 1. Mostra el menú principal.
     * 2. Mostra els missatges d'error o avís
     * 3. Obté l'opció seleccionada per l'usuari.
     * 4. Executa l'acció corresponent utilitzant les funcions existents.
     * 5. Finalitza quan l'usuari selecciona "Sortir".
     *
     * Els textos mostrats són:
     * - "=== Menú de Gestió de Notaria ==="
     * - "Selecciona una opció (número o paraula clau): "
     * - "Opció no vàlida. Torna a intentar-ho."
     * - "Fins aviat!"
     *
     * @param scanner L'objecte Scanner per llegir l'entrada de l'usuari.
     */
    public static void gestionaClientsOperacions(Scanner scanner) {

        ArrayList<String> menu = getCadenesMenu();
        ArrayList<String> resultat = new ArrayList<>();
        while (true) {
            
            clearScreen();
            dibuixarLlista(menu);
            dibuixarLlista(resultat);

            String opcio = obtenirOpcio(scanner);

            switch (opcio.toLowerCase(Locale.ROOT)) {
                case "sortir":
                    dibuixarLlista(new ArrayList<>(List.of("Fins aviat!")));
                    return;

                case "afegir client":
                    resultat = afegirClientMenu(scanner);
                    break;

                case "modificar client":
                    resultat = modificarClientMenu(scanner);
                    break;

                case "esborrar client":
                    resultat = esborrarClientMenu(scanner);
                    break;

                case "llistar clients":
                    resultat = getLlistarClientsMenu();
                    break;

                default:
                    resultat = new ArrayList<>(List.of("Opció no vàlida. Torna a intentar-ho."));
            }
        }
    }


    /**
     * 
     * @run ./run.sh "com.exercicis.Exercici0"
     * @test ./runTest.sh "com.exercicis.TestExercici0"
     * @test ./runTest.sh "com.exercicis.TestExercici0#testMain"
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        gestionaClientsOperacions(scanner);

        scanner.close();
    }
}

package com.exercicis;

import com.testStringUtils.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class TestExercici0 {

    @Test
    public void testValidarNom() {
        ArrayList<Object[]> tests = new ArrayList<>();
        // Afegir els casos de test al format {nom, ésVàlid}
        tests.add(new Object[]{"Toni Camacho", true});
        tests.add(new Object[]{"", false});
        tests.add(new Object[]{"Marta123", false});
        tests.add(new Object[]{"Samantha Fox!", false});
        tests.add(new Object[]{"   ", false});
        tests.add(new Object[]{"Pépìtó", true});

        for (Object[] test : tests) {
            String nom = (String) test[0];
            boolean expected = (boolean) test[1];
            assertEquals(expected, Exercici0.validarNom(nom),
                    "El nom '" + nom + "' hauria de ser " + (expected ? "vàlid" : "invàlid"));
        }
    }

    @Test
    public void testValidarEdat() {
        ArrayList<Object[]> tests = new ArrayList<>();
        // Afegir els casos de test al format {edat, ésVàlid}
        tests.add(new Object[]{25, true});
        tests.add(new Object[]{17, false});
        tests.add(new Object[]{18, true});
        tests.add(new Object[]{100, true});
        tests.add(new Object[]{101, false});
        tests.add(new Object[]{-5, false});

        for (Object[] test : tests) {
            int edat = (int) test[0];
            boolean expected = (boolean) test[1];
            assertEquals(expected, Exercici0.validarEdat(edat),
                    "L'edat '" + edat + "' hauria de ser " + (expected ? "vàlida" : "invàlida"));
        }
    }

    @Test
    public void testValidarFactors() {
        ArrayList<Object[]> tests = new ArrayList<>();
        // Afegir els casos de test al format {factors, ésVàlid}
        tests.add(new Object[]{new String[]{"autònom", "risc alt"}, true});
        tests.add(new Object[]{new String[]{"empresa", "risc mitjà"}, true});
        tests.add(new Object[]{new String[]{"autònom", "risc baix"}, false});
        tests.add(new Object[]{new String[]{"empresa", "risc moderat"}, false});
        tests.add(new Object[]{new String[]{"autònom"}, false});
        tests.add(new Object[]{new String[]{null, "risc baix"}, false});
        tests.add(new Object[]{new String[]{"empresa", "risc alt"}, true});

        for (Object[] test : tests) {
            String[] factors = (String[]) test[0];
            boolean expected = (boolean) test[1];
            assertEquals(expected, Exercici0.validarFactors(factors),
                    "Els factors '" + String.join(", ", factors) + "' haurien de ser " +
                            (expected ? "vàlids" : "invàlids"));
        }
    }

    @Test
    public void testValidarDescompte() {
        ArrayList<Object[]> tests = new ArrayList<>();
        // Afegir els casos de test al format {descompte, ésVàlid}
        tests.add(new Object[]{15.0, true});     // Enter dins del rang
        tests.add(new Object[]{20.0, true});     // Límit superior del rang
        tests.add(new Object[]{0.0, true});      // Límit inferior del rang
        tests.add(new Object[]{25.0, false});    // Fora del rang superior
        tests.add(new Object[]{-5.0, false});    // Fora del rang inferior
        tests.add(new Object[]{15.5, true});     // Decimal dins del rang
        tests.add(new Object[]{21.5, false});    // Decimal fora del rang superior
    
        for (Object[] test : tests) {
            double descompte = (double) test[0];
            boolean expected = (boolean) test[1];
            assertEquals(expected, Exercici0.validarDescompte(descompte),
                    "El descompte '" + descompte + "' hauria de ser " + (expected ? "vàlid" : "invàlid"));
        }
    }

    @Test
    public void testValidarTipusOperacio() {
        ArrayList<Object[]> tests = new ArrayList<>();
        // Afegir els casos de test al format {tipus, ésVàlid}
        tests.add(new Object[]{"Declaració d'impostos", true});
        tests.add(new Object[]{"Gestió laboral", true});
        tests.add(new Object[]{"Assessoria fiscal", true});
        tests.add(new Object[]{"Operació desconeguda", false});
        tests.add(new Object[]{"Testament", true});
        tests.add(new Object[]{"Contracte de lloguer", true});
        tests.add(new Object[]{"Modificació d'escriptures", true});
        tests.add(new Object[]{"", false});
        tests.add(new Object[]{null, false});
    
        for (Object[] test : tests) {
            String tipus = (String) test[0];
            boolean expected = (boolean) test[1];
            assertEquals(expected, Exercici0.validarTipusOperacio(tipus),
                    "El tipus d'operació '" + tipus + "' hauria de ser " +
                            (expected ? "vàlid" : "invàlid"));
        }
    }
    
    @Test
    public void testValidarClients() {
        ArrayList<Object[]> tests = new ArrayList<>();
        // Afegir els casos de test al format {clientsLlista, clientsGlobals, ésVàlid}
        tests.add(new Object[]{new ArrayList<>(List.of("client1", "client2")), 
                            new ArrayList<>(List.of("client1", "client2", "client3")), true});
        tests.add(new Object[]{new ArrayList<>(List.of("client1", "client1")), 
                            new ArrayList<>(List.of("client1", "client2", "client3")), false});
        tests.add(new Object[]{new ArrayList<>(), 
                            new ArrayList<>(List.of("client1", "client2", "client3")), true});
        tests.add(new Object[]{new ArrayList<>(List.of("client1", "client4")), 
                            new ArrayList<>(List.of("client1", "client2", "client3")), false});
        tests.add(new Object[]{new ArrayList<>(List.of("client1")), 
                            new ArrayList<>(), false});
        tests.add(new Object[]{null, 
                            new ArrayList<>(List.of("client1", "client2", "client3")), false});
        tests.add(new Object[]{new ArrayList<>(List.of("client1", "client2")), 
                            null, false});

        for (Object[] test : tests) {
            ArrayList<String> clientsLlista = (ArrayList<String>) test[0];
            ArrayList<String> clientsGlobals = (ArrayList<String>) test[1];
            boolean expected = (boolean) test[2];
            assertEquals(expected, Exercici0.validarClients(clientsLlista, clientsGlobals),
                    "La llista de clients '" + clientsLlista + "' amb clients globals '" + clientsGlobals + "' hauria de ser " +
                            (expected ? "vàlida" : "invàlida"));
        }
    }

    @Test
    public void testIsAllDigits() {
        ArrayList<Object[]> tests = new ArrayList<>();
        // Afegir els casos de test al format {cadena, ésVàlid}
        tests.add(new Object[]{"12345", true});        // Només dígits
        tests.add(new Object[]{"00123", true});        // Dígits amb zeros a l'esquerra
        tests.add(new Object[]{"", false});           // Cadena buida
        tests.add(new Object[]{"123a5", false});      // Conté lletres
        tests.add(new Object[]{"12 45", false});      // Conté espais
        tests.add(new Object[]{"-12345", false});     // Conté símbols
        tests.add(new Object[]{"123.45", false});     // Conté un punt decimal
        tests.add(new Object[]{null, false});         // Null
    
        for (Object[] test : tests) {
            String str = (String) test[0];
            boolean expected = (boolean) test[1];
            boolean result;
            try {
                result = Exercici0.isAllDigits(str); // Crida a la funció
            } catch (NullPointerException e) {
                result = false; // Si és null, ha de retornar false
            }
    
            assertEquals(expected, result, 
                "La cadena '" + str + "' hauria de retornar " + expected);
        }
    }
   
    @Test
    public void testValidarData() {
        ArrayList<Object[]> tests = new ArrayList<>();
        // Afegir els casos de test al format {data, ésVàlid}
        tests.add(new Object[]{"2023-04-15", true});
        tests.add(new Object[]{"2023-02-30", false});
        tests.add(new Object[]{"2023-13-01", false});
        tests.add(new Object[]{"2023-06-31", false});
        tests.add(new Object[]{"2023-02-29", true});
        tests.add(new Object[]{"1000-01-01", true});
        tests.add(new Object[]{"9999-12-31", true});
        tests.add(new Object[]{"2023-00-10", false});
        tests.add(new Object[]{"2023-05-00", false});
        tests.add(new Object[]{"2023-05-32", false});
        tests.add(new Object[]{"abcd-ef-gh", false});
        tests.add(new Object[]{"2023-01-41", false});
        tests.add(new Object[]{"2023-1-1", false});
        tests.add(new Object[]{null, false});
        tests.add(new Object[]{"", false});

        for (Object[] test : tests) {
            String data = (String) test[0];
            boolean expected = (boolean) test[1];
            assertEquals(expected, Exercici0.validarData(data),
                    "La data '" + data + "' hauria de ser " + (expected ? "vàlida" : "invàlida"));
        }
    }

    @Test
    public void testValidarPreu() {
        ArrayList<Object[]> tests = new ArrayList<>();
        // Afegir els casos de test al format {preu, ésVàlid}
        tests.add(new Object[]{150.0, true}); 
        tests.add(new Object[]{99.99, false});
        tests.add(new Object[]{100.0, false});
        tests.add(new Object[]{200.5, true});
        tests.add(new Object[]{-150.0, false});
        tests.add(new Object[]{0.0, false});
        tests.add(new Object[]{500.0, true});

        for (Object[] test : tests) {
            double preu = (double) test[0];
            boolean expected = (boolean) test[1];
            assertEquals(expected, Exercici0.validarPreu(preu),
                    "El preu '" + preu + "' hauria de ser " + (expected ? "vàlid" : "invàlid"));
        }
    }

    @Test
    public void testGeneraClauClient() {
        // Neteja el HashMap global
        Exercici0.clients.clear();
    
        // Cas 1: Generar una clau única en un HashMap buit
        String clau1 = Exercici0.generaClauClient();
        assertTrue(clau1.matches("client_\\d{3}"));
        assertFalse(Exercici0.clients.containsKey(clau1));
    
        // Cas 2: Afegir la clau generada al HashMap i generar-ne una altra
        Exercici0.clients.put(clau1, new HashMap<>());
        String clau2 = Exercici0.generaClauClient();
        assertTrue(clau2.matches("client_\\d{3}"));
        assertFalse(Exercici0.clients.containsKey(clau2));
        assertNotEquals(clau1, clau2);
    
   
        for (int i = 0; i < 500; i++) {
            String novaClau = Exercici0.generaClauClient();
            assertTrue(novaClau.matches("client_\\d{3}"));
            Exercici0.clients.put(novaClau, new HashMap<>()); 
        }
    }
    
    @Test
    public void testAfegirClient() {
        // Esborra tots els clients globals per començar amb un estat net
        Exercici0.clients.clear();
    
        // Cas 1: Afegeix un client nou
        ArrayList<String> factors1 = new ArrayList<>(List.of("empresa", "risc baix"));
        String clau1 = Exercici0.afegirClient("Maria", 30, factors1, 10);
        assertTrue(clau1.matches("client_\\d{3}")); // La clau segueix el format "client_XYZ"
        assertEquals(1, Exercici0.clients.size());
        assertTrue(Exercici0.clients.containsKey(clau1));
        assertEquals("Maria", ((HashMap<String, Object>) Exercici0.clients.get(clau1)).get("nom"));
        assertEquals(30, ((HashMap<String, Object>) Exercici0.clients.get(clau1)).get("edat"));
        assertEquals(factors1, ((HashMap<String, Object>) Exercici0.clients.get(clau1)).get("factors"));
        assertEquals(10.0, ((HashMap<String, Object>) Exercici0.clients.get(clau1)).get("descompte"));
    
        // Cas 2: Afegeix un altre client
        ArrayList<String> factors2 = new ArrayList<>(List.of("autònom", "risc mitjà"));
        String clau2 = Exercici0.afegirClient("Joan", 45, factors2, 15);
        assertTrue(clau2.matches("client_\\d{3}")); // La clau segueix el format "client_XYZ"
        assertEquals(2, Exercici0.clients.size());
        assertTrue(Exercici0.clients.containsKey(clau2));
        assertNotEquals(clau1, clau2); // Les claus han de ser úniques
    
        // Cas 3: Comprova que les claus no es repeteixen després de diversos afegits
        ArrayList<String> factors3 = new ArrayList<>(List.of("autònom", "risc alt"));
        String clau3 = Exercici0.afegirClient("Pere", 50, factors3, 5);
        assertTrue(clau3.matches("client_\\d{3}"));
        assertNotEquals(clau1, clau3);
        assertNotEquals(clau2, clau3);
    }
    
    @Test
    public void testModificarClient() {
        // Neteja els clients globals i afegeix clients inicials
        Exercici0.clients.clear();
    
        // Crear client inicial
        HashMap<String, Object> client = new HashMap<>();
        client.put("nom", "Maria");
        client.put("edat", 30);
        client.put("factors", new ArrayList<>(List.of("empresa", "risc baix")));
        client.put("descompte", 10);
        Exercici0.clients.put("client_100", client);
    
        // Cas 1: Modificar un camp existent
        String resultat = Exercici0.modificarClient("client_100", "edat", 35);
        assertEquals("OK", resultat); // Ha de retornar "OK"
        assertEquals(35, ((HashMap<String, Object>) Exercici0.clients.get("client_100")).get("edat"));
    
        // Cas 2: Modificar un altre camp existent
        resultat = Exercici0.modificarClient("client_100", "nom", "Anna");
        assertEquals("OK", resultat); // Ha de retornar "OK"
        assertEquals("Anna", ((HashMap<String, Object>) Exercici0.clients.get("client_100")).get("nom"));
    
        // Cas 3: Intentar modificar un camp inexistent
        resultat = Exercici0.modificarClient("client_100", "adreça", "Carrer Nou");
        assertEquals("El camp adreça no existeix.", resultat); // Ha de retornar un error
    
        // Cas 4: Intentar modificar un client inexistent
        resultat = Exercici0.modificarClient("client_101", "edat", 40);
        assertEquals("Client 'client_101' no existeix.", resultat); // Ha de retornar un error
    }
    
    @Test
    public void testEsborrarClient() {
        // Neteja els clients globals i afegeix clients inicials
        Exercici0.clients.clear();
    
        // Afegir clients inicials
        HashMap<String, Object> client1 = new HashMap<>();
        client1.put("nom", "Maria");
        client1.put("edat", 30);
        client1.put("factors", new ArrayList<>(List.of("empresa", "risc baix")));
        client1.put("descompte", 10);
        Exercici0.clients.put("client_100", client1);
    
        HashMap<String, Object> client2 = new HashMap<>();
        client2.put("nom", "Joan");
        client2.put("edat", 45);
        client2.put("factors", new ArrayList<>(List.of("autònom", "risc mitjà")));
        client2.put("descompte", 15);
        Exercici0.clients.put("client_101", client2);
    
        // Cas 1: Esborrar un client existent
        String resultat = Exercici0.esborrarClient("client_100");
        assertEquals("OK", resultat); // Ha de retornar "OK"
        assertFalse(Exercici0.clients.containsKey("client_100")); // El client ja no ha d'existir
    
        // Cas 2: Esborrar un altre client existent
        resultat = Exercici0.esborrarClient("client_101");
        assertEquals("OK", resultat); // Ha de retornar "OK"
        assertFalse(Exercici0.clients.containsKey("client_101")); // El client ja no ha d'existir
    
        // Cas 3: Intentar esborrar un client que no existeix
        resultat = Exercici0.esborrarClient("client_102");
        assertEquals("Client amb clau client_102 no existeix.", resultat); // Ha de retornar un error
    
        // Cas 4: Comprovar que el diccionari de clients està buit
        assertTrue(Exercici0.clients.isEmpty()); // Tots els clients han de ser eliminats
    }

    @Test
    public void testLlistarClients() {
        // Inicialitza el diccionari de clients global
        Exercici0.clients.clear();

        // Afegeix clients al diccionari global
        HashMap<String, Object> client1 = new HashMap<>();
        client1.put("nom", "Maria");
        client1.put("edat", 30);
        client1.put("factors", new ArrayList<>(List.of("empresa", "risc baix")));
        client1.put("descompte", 10);
        Exercici0.clients.put("client_101", client1);

        HashMap<String, Object> client2 = new HashMap<>();
        client2.put("nom", "Joan");
        client2.put("edat", 45);
        client2.put("factors", new ArrayList<>(List.of("autònom", "risc mitjà")));
        client2.put("descompte", 15);
        Exercici0.clients.put("client_102", client2);

        // Inicialitza les claus per la cerca
        ArrayList<String> claus = new ArrayList<>();
        claus.add("client_101");
        claus.add("client_102");

        // Inicialitza les condicions
        HashMap<String, Object> condicions = new HashMap<>();
        condicions.put("edat", 30);

        // Executa la funció
        ArrayList<HashMap<String, HashMap<String, Object>>> resultat = Exercici0.llistarClients(claus, condicions);

        // Comprova el resultat
        assertEquals(1, resultat.size());
        assertTrue(resultat.get(0).containsKey("client_101"));
        assertEquals(client1, resultat.get(0).get("client_101"));

        // Cas 2: Cerca sense coincidències
        condicions.put("edat", 50);
        resultat = Exercici0.llistarClients(claus, condicions);
        assertEquals(0, resultat.size());

        // Cas 3: Cerca amb múltiples condicions
        condicions.put("edat", 30);
        condicions.put("nom", "Maria");
        resultat = Exercici0.llistarClients(claus, condicions);
        assertEquals(1, resultat.size());
        assertTrue(resultat.get(0).containsKey("client_101"));
        assertEquals(client1, resultat.get(0).get("client_101"));
    }

    @Test
    public void testGeneraClauOperacio() {
        // Neteja la llista global d'operacions
        Exercici0.operacions.clear();
    
        // Cas 1: Generar una clau en una llista buida
        String clau1 = Exercici0.generaClauOperacio();
        assertTrue(clau1.matches("operacio_\\d{3}")); // La clau segueix el format "operacio_XXX"
        assertTrue(Exercici0.operacions.stream().noneMatch(op -> clau1.equals(op.get("id")))); // La clau és única
    
        // Cas 2: Afegeix una operació amb la clau generada
        HashMap<String, Object> operacio1 = new HashMap<>();
        operacio1.put("id", clau1);
        Exercici0.operacions.add(operacio1);
    
        // Genera una altra clau
        String clau2 = Exercici0.generaClauOperacio();
        assertTrue(clau2.matches("operacio_\\d{3}")); // La clau segueix el format "operacio_XXX"
        assertNotEquals(clau1, clau2); // La clau ha de ser diferent de la primera
        assertTrue(Exercici0.operacions.stream().noneMatch(op -> clau2.equals(op.get("id")))); // La nova clau és única
    
        // Cas 3: Comprova que moltes claus són úniques
        for (int i = 0; i < 100; i++) {
            String novaClau = Exercici0.generaClauOperacio();
            assertTrue(novaClau.matches("operacio_\\d{3}")); // La clau segueix el format "operacio_XXX"
            assertTrue(Exercici0.operacions.stream().noneMatch(op -> novaClau.equals(op.get("id")))); // La clau és única
    
            // Afegeix l'operació amb la nova clau per evitar repeticions
            HashMap<String, Object> novaOperacio = new HashMap<>();
            novaOperacio.put("id", novaClau);
            Exercici0.operacions.add(novaOperacio);
        }
    }
    
    @Test
    public void testAfegirOperacio() {
        // Neteja la llista global d'operacions
        Exercici0.operacions.clear();

        // Cas 1: Afegeix la primera operació
        ArrayList<String> clients1 = new ArrayList<>();
        clients1.add("client_101");
        clients1.add("client_102");
        String id1 = Exercici0.afegirOperacio("Declaració d'impostos", clients1, "2023-10-05", "Operació urgent", 200.0);

        assertEquals(1, Exercici0.operacions.size()); // La llista d'operacions ha de tenir 1 element
        HashMap<String, Object> operacio1 = Exercici0.operacions.get(0);
        assertEquals(id1, operacio1.get("id"));
        assertEquals("Declaració d'impostos", operacio1.get("tipus"));
        assertEquals(clients1, operacio1.get("clients"));
        assertEquals("2023-10-05", operacio1.get("data"));
        assertEquals("Operació urgent", operacio1.get("observacions"));
        assertEquals(200.0, operacio1.get("preu"));

        // Cas 2: Afegeix una altra operació
        ArrayList<String> clients2 = new ArrayList<>();
        clients2.add("client_103");
        String id2 = Exercici0.afegirOperacio("Assessoria fiscal", clients2, "2023-11-01", "Revisió anual", 150.0);

        assertNotEquals(id1, id2); // Els identificadors han de ser únics
        assertEquals(2, Exercici0.operacions.size()); // La llista d'operacions ha de tenir 2 elements
        HashMap<String, Object> operacio2 = Exercici0.operacions.get(1);
        assertEquals(id2, operacio2.get("id"));
        assertEquals("Assessoria fiscal", operacio2.get("tipus"));
        assertEquals(clients2, operacio2.get("clients"));
        assertEquals("2023-11-01", operacio2.get("data"));
        assertEquals("Revisió anual", operacio2.get("observacions"));
        assertEquals(150.0, operacio2.get("preu"));

        // Cas 3: Afegeix una operació amb cap client
        ArrayList<String> clients3 = new ArrayList<>();
        String id3 = Exercici0.afegirOperacio("Testament", clients3, "2023-12-15", "Urgència baixa", 100.0);

        assertNotEquals(id1, id3); // Els identificadors han de ser únics
        assertNotEquals(id2, id3); // Els identificadors han de ser únics
        assertEquals(3, Exercici0.operacions.size()); // La llista d'operacions ha de tenir 3 elements
        HashMap<String, Object> operacio3 = Exercici0.operacions.get(2);
        assertEquals(id3, operacio3.get("id"));
        assertEquals("Testament", operacio3.get("tipus"));
        assertEquals(clients3, operacio3.get("clients"));
        assertEquals("2023-12-15", operacio3.get("data"));
        assertEquals("Urgència baixa", operacio3.get("observacions"));
        assertEquals(100.0, operacio3.get("preu"));

        // Cas 4: Comprova que les claus generades són úniques
        ArrayList<String> ids = new ArrayList<>();
        ids.add(id1);
        ids.add(id2);
        ids.add(id3);

        for (HashMap<String, Object> operacio : Exercici0.operacions) {
            String id = (String) operacio.get("id");
            assertTrue(ids.contains(id)); // Comprova que els identificadors existeixen
        }
    }

    @Test
    public void testModificarOperacio() {
        // Inicialitza la llista d'operacions
        Exercici0.operacions.clear();
    
        // Afegeix una operació inicial
        HashMap<String, Object> operacio1 = new HashMap<>();
        operacio1.put("id", "operacio_101");
        operacio1.put("tipus", "Declaració d'impostos");
        operacio1.put("clients", new ArrayList<>(List.of("client_101", "client_102")));
        operacio1.put("data", "2023-10-05");
        operacio1.put("observacions", "Urgent");
        operacio1.put("preu", 200.0);
        Exercici0.operacions.add(operacio1);
    
        // Cas 1: Modifica el preu d'una operació existent
        String resultat1 = Exercici0.modificarOperacio("operacio_101", "preu", 300.0);
        assertEquals("OK", resultat1);
        assertEquals(300.0, operacio1.get("preu"));
    
        // Cas 2: Modifica un camp que no existeix
        String resultat2 = Exercici0.modificarOperacio("operacio_101", "descompte", 10);
        assertEquals("El camp descompte no existeix en l'operació.", resultat2);
    
        // Cas 3: Modifica una operació que no existeix
        String resultat3 = Exercici0.modificarOperacio("operacio_999", "preu", 150.0);
        assertEquals("Operació amb id operacio_999 no existeix.", resultat3);
    
        // Cas 4: Modifica la data d'una operació existent
        String resultat4 = Exercici0.modificarOperacio("operacio_101", "data", "2023-11-01");
        assertEquals("OK", resultat4);
        assertEquals("2023-11-01", operacio1.get("data"));
    }

    @Test
    public void testEsborrarOperacio() {
        // Inicialitza la llista d'operacions
        Exercici0.operacions.clear();
    
        // Afegeix operacions inicials
        HashMap<String, Object> operacio1 = new HashMap<>();
        operacio1.put("id", "operacio_101");
        operacio1.put("tipus", "Declaració d'impostos");
        operacio1.put("clients", new ArrayList<>(List.of("client_101", "client_102")));
        operacio1.put("data", "2023-10-05");
        operacio1.put("observacions", "Urgent");
        operacio1.put("preu", 200.0);
        Exercici0.operacions.add(operacio1);
    
        HashMap<String, Object> operacio2 = new HashMap<>();
        operacio2.put("id", "operacio_102");
        operacio2.put("tipus", "Assessoria fiscal");
        operacio2.put("clients", new ArrayList<>(List.of("client_103")));
        operacio2.put("data", "2023-11-01");
        operacio2.put("observacions", "Revisió anual");
        operacio2.put("preu", 150.0);
        Exercici0.operacions.add(operacio2);
    
        // Cas 1: Esborra una operació existent
        String resultat1 = Exercici0.esborrarOperacio("operacio_101");
        assertEquals("OK", resultat1);
        assertEquals(1, Exercici0.operacions.size());
        assertEquals("operacio_102", Exercici0.operacions.get(0).get("id"));
    
        // Cas 2: Esborra una altra operació existent
        String resultat2 = Exercici0.esborrarOperacio("operacio_102");
        assertEquals("OK", resultat2);
        assertEquals(0, Exercici0.operacions.size());
    
        // Cas 3: Intenta esborrar una operació que no existeix
        String resultat3 = Exercici0.esborrarOperacio("operacio_999");
        assertEquals("Operació amb id operacio_999 no existeix.", resultat3);
    }

    @Test
    public void testLlistarOperacions() {
        // Neteja i inicialitza la llista global d'operacions
        Exercici0.operacions.clear();

        // Afegeix operacions inicials
        HashMap<String, Object> operacio1 = new HashMap<>();
        operacio1.put("id", "operacio_101");
        operacio1.put("tipus", "Declaració d'impostos");
        operacio1.put("data", "2023-10-05");
        operacio1.put("preu", 200.0);
        Exercici0.operacions.add(operacio1);

        HashMap<String, Object> operacio2 = new HashMap<>();
        operacio2.put("id", "operacio_102");
        operacio2.put("tipus", "Assessoria fiscal");
        operacio2.put("data", "2023-11-01");
        operacio2.put("preu", 150.0);
        Exercici0.operacions.add(operacio2);

        HashMap<String, Object> operacio3 = new HashMap<>();
        operacio3.put("id", "operacio_103");
        operacio3.put("tipus", "Declaració d'impostos");
        operacio3.put("data", "2023-12-01");
        operacio3.put("preu", 200.0);
        Exercici0.operacions.add(operacio3);

        // Cas 1: Filtrar operacions per identificadors
        ArrayList<String> ids = new ArrayList<>();
        ids.add("operacio_101");
        ids.add("operacio_103");
        ArrayList<HashMap<String, Object>> resultat = Exercici0.llistarOperacions(ids, null);
        assertEquals(2, resultat.size());
        assertTrue(resultat.stream().anyMatch(op -> "operacio_101".equals(op.get("id"))));
        assertTrue(resultat.stream().anyMatch(op -> "operacio_103".equals(op.get("id"))));

        // Cas 2: Filtrar operacions per condicions
        HashMap<String, Object> condicions = new HashMap<>();
        condicions.put("preu", 200.0);
        resultat = Exercici0.llistarOperacions(new ArrayList<>(), condicions);
        assertEquals(2, resultat.size());
        assertTrue(resultat.stream().anyMatch(op -> "operacio_101".equals(op.get("id"))));
        assertTrue(resultat.stream().anyMatch(op -> "operacio_103".equals(op.get("id"))));

        // Cas 3: Filtrar per identificadors i condicions
        resultat = Exercici0.llistarOperacions(ids, condicions);
        assertEquals(2, resultat.size());
        assertTrue(resultat.stream().anyMatch(op -> "operacio_101".equals(op.get("id"))));
        assertTrue(resultat.stream().anyMatch(op -> "operacio_103".equals(op.get("id"))));

        // Cas 4: Cap coincidència
        condicions.put("preu", 300.0);
        resultat = Exercici0.llistarOperacions(ids, condicions);
        assertEquals(0, resultat.size());
    }

    @Test
    public void testLlistarOperacionsClient() {
        // Neteja i inicialitza la llista global d'operacions
        Exercici0.operacions.clear();

        // Afegeix operacions inicials
        HashMap<String, Object> operacio1 = new HashMap<>();
        operacio1.put("id", "operacio_101");
        operacio1.put("tipus", "Declaració d'impostos");
        operacio1.put("data", "2023-10-05");
        operacio1.put("clients", new ArrayList<>(List.of("client_101", "client_102")));
        operacio1.put("preu", 200.0);
        Exercici0.operacions.add(operacio1);

        HashMap<String, Object> operacio2 = new HashMap<>();
        operacio2.put("id", "operacio_102");
        operacio2.put("tipus", "Assessoria fiscal");
        operacio2.put("data", "2023-11-01");
        operacio2.put("clients", new ArrayList<>(List.of("client_103")));
        operacio2.put("preu", 150.0);
        Exercici0.operacions.add(operacio2);

        HashMap<String, Object> operacio3 = new HashMap<>();
        operacio3.put("id", "operacio_103");
        operacio3.put("tipus", "Declaració d'impostos");
        operacio3.put("data", "2023-12-01");
        operacio3.put("clients", new ArrayList<>(List.of("client_101")));
        operacio3.put("preu", 200.0);
        Exercici0.operacions.add(operacio3);

        // Cas 1: Llistar operacions per client existent
        ArrayList<HashMap<String, Object>> resultat = Exercici0.llistarOperacionsClient("client_101");
        assertEquals(2, resultat.size());
        assertTrue(resultat.stream().anyMatch(op -> "operacio_101".equals(op.get("id"))));
        assertTrue(resultat.stream().anyMatch(op -> "operacio_103".equals(op.get("id"))));

        // Cas 2: Llistar operacions per client amb una sola operació
        resultat = Exercici0.llistarOperacionsClient("client_103");
        assertEquals(1, resultat.size());
        assertTrue(resultat.stream().anyMatch(op -> "operacio_102".equals(op.get("id"))));

        // Cas 3: Llistar operacions per client inexistent
        resultat = Exercici0.llistarOperacionsClient("client_999");
        assertEquals(0, resultat.size());
    }

    @Test
    public void testAlineaColumnes() {
        // Test case 1: Basic left alignment
        ArrayList<Object[]> test1 = new ArrayList<>();
        test1.add(new Object[]{"Hello", "left", 7});
        assertEquals("Hello  ", Exercici0.alineaColumnes(test1));
        
        // Test case 2: Basic right alignment
        ArrayList<Object[]> test2 = new ArrayList<>();
        test2.add(new Object[]{"Hello", "right", 7});
        assertEquals("  Hello", Exercici0.alineaColumnes(test2));
        
        // Test case 3: Basic center alignment
        ArrayList<Object[]> test3 = new ArrayList<>();
        test3.add(new Object[]{"Hello", "center", 7});
        assertEquals(" Hello ", Exercici0.alineaColumnes(test3));
        
        // Test case 4: Multiple columns with different alignments
        ArrayList<Object[]> test4 = new ArrayList<>();
        test4.add(new Object[]{"Name", "left", 10});
        test4.add(new Object[]{"Age", "center", 5});
        test4.add(new Object[]{"Rost", "center", 7});
        test4.add(new Object[]{"City", "right", 8});
        assertEquals("Name       Age  Rost      City", Exercici0.alineaColumnes(test4));
        
        // Test case 5: Text longer than specified width
        ArrayList<Object[]> test5 = new ArrayList<>();
        test5.add(new Object[]{"VeryLongText", "left", 5});
        assertEquals("VeryL", Exercici0.alineaColumnes(test5));
        
        // Test case 6: Empty string
        ArrayList<Object[]> test6 = new ArrayList<>();
        test6.add(new Object[]{"", "center", 4});
        assertEquals("    ", Exercici0.alineaColumnes(test6));
    }

    @Test
    public void testTaulaOperacionsClient0() {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            // Inicialitza els clients
            Exercici0.clients.clear();
            HashMap<String, Object> clientJoan = new HashMap<>();
            clientJoan.put("nom", "Joan");
            clientJoan.put("edat", 30);
            clientJoan.put("factors", new ArrayList<>(Arrays.asList("autònom", "risc mitjà")));
            clientJoan.put("descompte", 10);
            Exercici0.clients.put("client_745", clientJoan);

            // Inicialitza les operacions
            Exercici0.operacions.clear();
            HashMap<String, Object> operacio1 = new HashMap<>();
            operacio1.put("id", "1");
            operacio1.put("clients", new ArrayList<>(Arrays.asList("client_745")));
            operacio1.put("tipus", "Gestió laboral");
            operacio1.put("data", "2023-09-01");
            operacio1.put("preu", 300.00);
            Exercici0.operacions.add(operacio1);

            HashMap<String, Object> operacio2 = new HashMap<>();
            operacio2.put("id", "2");
            operacio2.put("clients", new ArrayList<>(Arrays.asList("client_745")));
            operacio2.put("tipus", "Declaració d'impostos");
            operacio2.put("data", "2023-10-06");
            operacio2.put("preu", 150.00);
            Exercici0.operacions.add(operacio2);

            // Genera la taula
            ArrayList<String> resultat = Exercici0.taulaOperacionsClient("client_745", "data");

            // Sortida esperada
            String esperat = """
Joan, 30                          [autònom, risc mitjà]
-------------------------------------------------------
Tipus                         Data                 Preu
Gestió laboral                2023-09-01         300.00
Declaració d'impostos         2023-10-06         150.00
-------------------------------------------------------
                                           Suma: 450.00
Descompte: 10%                             Preu: 405.00
Impostos:  21% (85.05)                    Total: 490.05
                """;

            // Compara el resultat amb l'esperat
            String diff = TestStringUtils.findFirstDifference(String.join("\n", resultat), esperat.trim());
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    @Test
    public void testTaulaOperacionsClient1() {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);
            // Inicialitza els clients
            Exercici0.clients.clear();
            HashMap<String, Object> clientMarta = new HashMap<>();
            clientMarta.put("nom", "Marta Puig i Puig");  // Nom més llarg
            clientMarta.put("edat", 45);
            clientMarta.put("factors", new ArrayList<>(Arrays.asList("empresa", "risc alt")));
            clientMarta.put("descompte", 15);  // Descompte diferent
            Exercici0.clients.put("client_842", clientMarta);
    
            // Inicialitza les operacions
            Exercici0.operacions.clear();
            HashMap<String, Object> operacio1 = new HashMap<>();
            operacio1.put("id", "1");
            operacio1.put("clients", new ArrayList<>(Arrays.asList("client_842")));
            operacio1.put("tipus", "Constitució de societat");  // Tipus més llarg
            operacio1.put("data", "2024-01-15");
            operacio1.put("preu", 1250.50);  // Preu amb decimals
            Exercici0.operacions.add(operacio1);
    
            HashMap<String, Object> operacio2 = new HashMap<>();
            operacio2.put("id", "2");
            operacio2.put("clients", new ArrayList<>(Arrays.asList("client_842")));
            operacio2.put("tipus", "Testament");  // Tipus més curt
            operacio2.put("data", "2024-02-28");
            operacio2.put("preu", 755.75);
            Exercici0.operacions.add(operacio2);
    
            HashMap<String, Object> operacio3 = new HashMap<>();
            operacio3.put("id", "3");
            operacio3.put("clients", new ArrayList<>(Arrays.asList("client_842")));
            operacio3.put("tipus", "Acta notarial");
            operacio3.put("data", "2024-03-10");
            operacio3.put("preu", 500.25);
            Exercici0.operacions.add(operacio3);
    
            // Genera la taula
            ArrayList<String> resultat = Exercici0.taulaOperacionsClient("client_842", "data");
    
            // Sortida esperada
            String esperat = """
Marta Puig i Puig, 45               [empresa, risc alt]
-------------------------------------------------------
Tipus                         Data                 Preu
Constitució de societat       2024-01-15        1250.50
Testament                     2024-02-28         755.75
Acta notarial                 2024-03-10         500.25
-------------------------------------------------------
                                          Suma: 2506.50
Descompte: 10%                            Preu: 2255.85
Impostos:  21% (473.73)                  Total: 2729.58
                """;
    
            // Compara el resultat amb l'esperat
            String diff = TestStringUtils.findFirstDifference(String.join("\n", resultat), esperat.trim());
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    @Test
    public void testTaulaOperacionsClient2() {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);
            // Inicialitza els clients
            Exercici0.clients.clear();
            HashMap<String, Object> clientPere = new HashMap<>();
            clientPere.put("nom", "Pere Vila");
            clientPere.put("edat", 25);
            clientPere.put("factors", new ArrayList<>(Arrays.asList("estudiant", "risc baix")));
            clientPere.put("descompte", 5);  // Descompte petit
            Exercici0.clients.put("client_123", clientPere);
    
            // Inicialitza les operacions
            Exercici0.operacions.clear();
            HashMap<String, Object> operacio1 = new HashMap<>();
            operacio1.put("id", "1");
            operacio1.put("clients", new ArrayList<>(Arrays.asList("client_123")));
            operacio1.put("tipus", "Certificat");
            operacio1.put("data", "2024-01-10");
            operacio1.put("preu", 25.50);  // Preus petits
            Exercici0.operacions.add(operacio1);
    
            HashMap<String, Object> operacio2 = new HashMap<>();
            operacio2.put("id", "2");
            operacio2.put("clients", new ArrayList<>(Arrays.asList("client_123")));
            operacio2.put("tipus", "Fotocòpia");
            operacio2.put("data", "2024-01-15");
            operacio2.put("preu", 15.25);
            Exercici0.operacions.add(operacio2);
    
            HashMap<String, Object> operacio3 = new HashMap<>();
            operacio3.put("id", "3");
            operacio3.put("clients", new ArrayList<>(Arrays.asList("client_123")));
            operacio3.put("tipus", "Segell");
            operacio3.put("data", "2024-01-20");
            operacio3.put("preu", 35.50);
            Exercici0.operacions.add(operacio3);
    
            // Genera la taula
            ArrayList<String> resultat = Exercici0.taulaOperacionsClient("client_123", "data");
    
            // Sortida esperada
            String esperat = """
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
                    """;
    
            // Compara el resultat amb l'esperat
            String diff = TestStringUtils.findFirstDifference(String.join("\n", resultat), esperat.trim());
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    @Test
    public void testGetCadenesMenu() {
        // Menú esperat
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
        ArrayList<String> menuEsperat = new ArrayList<>(List.of(menuText.split("\\R")));

        // Executa el mètode
        ArrayList<String> menuGenerat = Exercici0.getCadenesMenu();

        // Compara el resultat amb l'esperat
        String diff = TestStringUtils.findFirstDifference(menuGenerat.toString(), menuEsperat.toString());
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
    }

    @Test
    public void testObtenirOpcio() {
        Object[][] tests = {
            {"1\n", "Afegir client"},
            {"2\n", "Modificar client"},
            {"3\n", "Esborrar client"},
            {"4\n", "Llistar clients"},
            {"5\n", "Afegir operació"},
            {"6\n", "Modificar operació"},
            {"7\n", "Esborrar operació"},
            {"8\n", "Llistar operacions"},
            {"0\n", "Sortir"},
            {"afegir client\n", "Afegir client"},
            {"MODIFICAR CLIENT\n", "Modificar client"},
            {"modificar OPERACIO\n", "Modificar operació"},
            {"Llistar Operacions\n", "Llistar operacions"},
            {"sortir\n", "Sortir"}
        };
    
        for (Object[] test : tests) {
            String input = (String) test[0];
            String expected = (String) test[1];
    
            try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()))) {
                String result = Exercici0.obtenirOpcio(scanner);
                assertEquals(expected, result, 
                    "Per l'entrada '" + input.trim() + "' s'esperava '" + expected + 
                    "' però s'ha obtingut '" + result + "'");
            }
        }
    }
    
    
    @Test
    public void testLlistarClientsMenu() {
        // Configura els clients globals
        Exercici0.clients.clear();
    
        // Cas 1: Sense clients
        ArrayList<String> esperatSenseClients = new ArrayList<>();
        esperatSenseClients.add("=== Llistar Clients ===");
        esperatSenseClients.add("No hi ha clients per mostrar.");
    
        ArrayList<String> resultatSenseClients = Exercici0.getLlistarClientsMenu();
        assertEquals(esperatSenseClients, resultatSenseClients, "El resultat amb zero clients hauria de coincidir amb l'esperat.");
    
        // Cas 2: Amb clients
        HashMap<String, Object> client1 = new HashMap<>();
        client1.put("nom", "Joan");
        client1.put("edat", 30);
        client1.put("factors", Arrays.asList("autònom", "risc mitjà"));
        client1.put("descompte", 10);
    
        HashMap<String, Object> client2 = new HashMap<>();
        client2.put("nom", "Maria");
        client2.put("edat", 45);
        client2.put("factors", Arrays.asList("empresa", "risc baix"));
        client2.put("descompte", 15);
    
        Exercici0.clients.put("client_1", client1);
        Exercici0.clients.put("client_2", client2);
    
        ArrayList<String> esperatAmbClients = new ArrayList<>();
        esperatAmbClients.add("=== Llistar Clients ===");
        esperatAmbClients.add("client_1: " + client1.toString());
        esperatAmbClients.add("client_2: " + client2.toString());
    
        ArrayList<String> resultatAmbClients = Exercici0.getLlistarClientsMenu();
        assertEquals(esperatAmbClients, resultatAmbClients, "El resultat amb clients hauria de coincidir amb l'esperat.");
    }
    
    @Test
    public void testDibuixarLlista() {
        // Capturar la sortida del sistema
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    
        try {
            // Cas de prova
            ArrayList<String> llista = new ArrayList<>(List.of(
                "Primera línia",
                "Segona línia",
                "Tercera línia"
            ));
    
            // Executa el mètode
            Exercici0.dibuixarLlista(llista);
    
            // Generar la sortida esperada
            String sortidaEsperada = String.join(System.lineSeparator(), llista) + System.lineSeparator();
    
            // Compara utilitzant TestStringUtils
            String diff = TestStringUtils.findFirstDifference(outputStream.toString(), sortidaEsperada);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
        } finally {
            // Restaura la sortida original del sistema
            System.setOut(originalOut);
        }
    }
    
    @Test
    public void testLlegirNom() {
        Object[][] testCases = {
            {"Joan\n", "Joan"},
            {"123\nAnna\n", "Anna"},
            {"Ayoub Martorell\n", "Ayoub Martorell"},
            {"\nPep\n", "Pep"},
            {"!@#$\nMaria\n", "Maria"}
        };
        
        for (Object[] testCase : testCases) {
            String input = (String) testCase[0];
            String expectedOutput = (String) testCase[1];
            
            // Captura l'entrada simulada i la sortida del sistema
            InputStream originalIn = System.in;
            PrintStream originalOut = System.out;
            
            try {
                System.setIn(new ByteArrayInputStream(input.getBytes()));
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outputStream));
                Scanner scanner = new Scanner(System.in);
                
                String result = Exercici0.llegirNom(scanner);
                
                // Compara l'entrada amb el resultat esperat
                String diff = TestStringUtils.findFirstDifference(result, expectedOutput);
                assertTrue(diff.equals("identical"),
                    ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
                
                // Verifica que els missatges d'error apareguin quan calgui
                if (input.split("\n").length > 1) {  // Si hi ha més d'una línia, vol dir que hi ha hagut error
                    String expectedError = "Nom no vàlid. Només s'accepten lletres i espais.";
                    String capturedOutput = outputStream.toString();
                    assertTrue(capturedOutput.contains(expectedError),
                        "No s'ha trobat el missatge d'error esperat en la sortida:\n" + capturedOutput);
                }
            } finally {
                // Restaura l'entrada i sortida original
                System.setIn(originalIn);
                System.setOut(originalOut);
            }
        }
    }
    
    @Test
    public void testLlegirEdat() {
        Object[][] testCases = {
            {"25\n", 25},
            {"17\n30\n", 30}, // Fora de rang inicialment, després correcte
            {"abc\n50\n", 50}, // Entrada no vàlida, després correcte
            {"101\n99\n", 99}, // Fora de rang inicialment, després correcte
            {"18\n", 18} // Valor límit inferior
        };
        
        for (Object[] testCase : testCases) {
            String input = (String) testCase[0];
            int expectedOutput = (int) testCase[1];
            
            // Captura l'entrada simulada i la sortida del sistema
            InputStream originalIn = System.in;
            PrintStream originalOut = System.out;
            
            try {
                System.setIn(new ByteArrayInputStream(input.getBytes()));
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outputStream));
                Scanner scanner = new Scanner(System.in);
                
                int result = Exercici0.llegirEdat(scanner);
                
                // Compara el resultat amb el valor esperat
                assertEquals(expectedOutput, result, 
                    String.format("Per l'entrada '%s': Valor esperat: %d, Valor obtingut: %d", 
                        input.replace("\n", "\\n"), expectedOutput, result));
                
                // Verifica que els missatges d'error apareguin quan calgui
                if (input.split("\n").length > 1) {  // Si hi ha més d'una línia, hi ha hagut error
                    String expectedError = "Edat no vàlida. Introdueix un número entre 18 i 100.";
                    String capturedOutput = outputStream.toString();
                    assertTrue(capturedOutput.contains(expectedError),
                        String.format("Per l'entrada '%s': No s'ha trobat el missatge d'error esperat.\nSortida capturada:\n%s", 
                            input.replace("\n", "\\n"), capturedOutput));
                }
                
            } finally {
                // Restaura l'entrada i sortida original
                System.setIn(originalIn);
                System.setOut(originalOut);
            }
        }
    }

    @Test
    public void testLlegirFactors() {
        Object[][] testCases = {
            {"autònom\nrisc alt\n", List.of("autònom", "risc alt")},
            {"empresa\nrisc baix\n", List.of("empresa", "risc baix")},
            {"autònom\nrisc baix\nrisc mitjà\n", List.of("autònom", "risc mitjà")}, // Entrada invàlida seguida de vàlida
            {"empresa\nabc\nrisc alt\n", List.of("empresa", "risc alt")}, // Entrada no vàlida seguida de vàlida
            {"empresa\nrisc mitjà\n", List.of("empresa", "risc mitjà")}
        };
    
        for (Object[] testCase : testCases) {
            String input = (String) testCase[0];
            ArrayList<String> expectedOutput = new ArrayList<>((List<String>) testCase[1]);
    
            // Captura l'entrada simulada i la sortida del sistema
            InputStream originalIn = System.in;
            PrintStream originalOut = System.out;
    
            try {
                System.setIn(new ByteArrayInputStream(input.getBytes()));
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outputStream));
    
                Scanner scanner = new Scanner(System.in);
                ArrayList<String> result = Exercici0.llegirFactors(scanner);
    
                // Compara el resultat amb l'output esperat
                String expectedOutputString = expectedOutput.toString();
                String resultOutputString = result.toString();
    
                String diff = TestStringUtils.findFirstDifference(resultOutputString, expectedOutputString);
                assertTrue(diff.equals("identical"),
                    ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
    
                // Verifica que els missatges d'error apareguin en el flux de sortida si cal
                if (input.contains("\nabc\n") || input.contains("\nrisc baix\n") && input.contains("autònom")) {
                    assertTrue(outputStream.toString().contains("Factor no vàlid"),
                        "Missatge d'error esperat no trobat en la sortida:\n" + outputStream.toString());
                }
    
            } finally {
                // Restaura l'entrada i sortida original
                System.setIn(originalIn);
                System.setOut(originalOut);
            }
        }
    }
    
    @Test
    public void testLlegirDescompte() {
        Object[][] testCases = {
            {"10\n", 10.0},                         // Descompte vàlid
            {"15.5\n", 15.5},                       // Descompte vàlid amb decimal
            {"25\n15\n", 15.0},                     // Entrada no vàlida seguida d'una vàlida
            {"-5\n10\n", 10.0},                     // Entrada negativa seguida d'una vàlida
            {"abc\n20\n", 20.0},                    // Entrada no numèrica seguida d'una vàlida
            {"21\n20\n", 20.0}                      // Fora del rang seguit d'una entrada vàlida
        };
    
        for (Object[] testCase : testCases) {
            String input = (String) testCase[0];
            double expectedOutput = (double) testCase[1];
    
            // Captura l'entrada simulada i la sortida del sistema
            InputStream originalIn = System.in;
            PrintStream originalOut = System.out;
    
            try {
                System.setIn(new ByteArrayInputStream(input.getBytes()));
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outputStream));
    
                Scanner scanner = new Scanner(System.in);
                ArrayList<String> linies = new ArrayList<>();
                double result = Exercici0.llegirDescompte(scanner);
    
                // Comprova el resultat
                assertEquals(expectedOutput, result, 0.01, 
                    "El descompte esperat no coincideix amb el resultat obtingut.");
    
                // Comprova els missatges d'error esperats en cas d'entrada no vàlida
                if (input.contains("abc") || input.contains("-5") || input.contains("21") || input.contains("25")) {
                    String output = outputStream.toString();
                    assertTrue(output.contains("Descompte no vàlid"),
                        "Missatge d'error esperat 'Descompte no vàlid' no trobat en la sortida:\n" + output);
                }
    
            } finally {
                // Restaura l'entrada i sortida original
                System.setIn(originalIn);
                System.setOut(originalOut);
            }
        }
    }
    
    @Test
    public void testAfegirClientMenu() {
        // Neteja els clients globals per començar amb un estat net
        Exercici0.clients.clear();
        
        Object[][] testCases = {
            // Input correcte: nom, edat, factors i descompte vàlids
            {"Joan\n30\nautònom\nrisc alt\n10\n", Arrays.asList(
                "=== Afegir Client ===",
                "S'ha afegit el client amb clau client_")},
             
            // Input amb errors i correccions
            {"123\nMaria\n15\n25\nempresa\nrisc baix\n15\n", Arrays.asList(
                "=== Afegir Client ===",
                "S'ha afegit el client amb clau client_")},
             
            // Input amb factors incorrectes i correcció
            {"Pere\n35\nautònom\nrisc baix\nrisc alt\n20\n", Arrays.asList(
                "=== Afegir Client ===",
                "S'ha afegit el client amb clau client_")}
        };
        
        for (Object[] testCase : testCases) {
            String input = (String) testCase[0];
            List<String> expectedLines = (List<String>) testCase[1];
            
            // Captura l'entrada simulada i la sortida del sistema
            InputStream originalIn = System.in;
            PrintStream originalOut = System.out;
            
            try {
                System.setIn(new ByteArrayInputStream(input.getBytes()));
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outputStream));
                Scanner scanner = new Scanner(System.in);
                
                ArrayList<String> result = Exercici0.afegirClientMenu(scanner);
                               
                // Verifica cada línia excepte l'última (que conté la clau aleatòria)
                for (int i = 0; i < expectedLines.size() - 1; i++) {
                    String diff = TestStringUtils.findFirstDifference(result.get(i), expectedLines.get(i));
                    assertTrue(diff.equals("identical"),
                        String.format("Per l'entrada '%s' a la línia %d:\n>>>>>>>>>> Diff found >>>>>>>>>>\n%s\n<<<<<<<<<< Diff end <<<<<<<<<<\n",
                            input.replace("\n", "\\n"),
                            i,
                            diff));
                }
                
                // Verifica que l'última línia comença amb el text esperat
                assertTrue(result.get(result.size() - 1).startsWith(expectedLines.get(expectedLines.size() - 1)),
                    String.format("Per l'entrada '%s': L'última línia no comença amb el text esperat",
                        input.replace("\n", "\\n")));
                
                // Verifica que s'ha afegit un nou client
                assertTrue(Exercici0.clients.size() > 0, 
                    String.format("Per l'entrada '%s': No s'ha afegit cap client al HashMap després de l'operació",
                        input.replace("\n", "\\n")));
                
            } finally {
                // Restaura l'entrada i sortida original
                System.setIn(originalIn);
                System.setOut(originalOut);
            }
        }
    }

    @Test
    public void testModificarClientMenu() {
        // Configura els clients globals per tenir dades inicials
        Exercici0.clients.clear();
        HashMap<String, Object> client = new HashMap<>();
        client.put("nom", "Joan");
        client.put("edat", 30);
        client.put("factors", Arrays.asList("autònom", "risc alt"));
        client.put("descompte", 10.0);
        Exercici0.clients.put("client_100", client);
    
        Object[][] testCases = {
            // Modificació amb camp vàlid (nom)
            {"client_100\nnom\nMaria\n", Arrays.asList(
                "=== Modificar Client ===",
                "Camps disponibles per modificar: nom, edat, factors, descompte",
                "S'ha modificat el client client_100.")},
    
            // Modificació amb camp vàlid (edat)
            {"client_100\nedat\n35\n", Arrays.asList(
                "=== Modificar Client ===",
                "Camps disponibles per modificar: nom, edat, factors, descompte",
                "S'ha modificat el client client_100.")},
    
            // Modificació amb factors vàlids
            {"client_100\nfactors\nautònom\nrisc mitjà\n", Arrays.asList(
                "=== Modificar Client ===",
                "Camps disponibles per modificar: nom, edat, factors, descompte",
                "S'ha modificat el client client_100.")},
    
            // Clau de client no existent
            {"client_999\nnom\nMaria\n", Arrays.asList(
                "=== Modificar Client ===",
                "Client amb clau client_999 no existeix.")},
    
            // Camp no vàlid
            {"client_100\ninvalid_camp\nMaria\n", Arrays.asList(
                "=== Modificar Client ===",
                "Camps disponibles per modificar: nom, edat, factors, descompte",
                "El camp invalid_camp no és vàlid.")}
        };
    
        for (Object[] testCase : testCases) {
            String input = (String) testCase[0];
            List<String> expectedLines = (List<String>) testCase[1];
    
            // Captura l'entrada simulada i la sortida del sistema
            InputStream originalIn = System.in;
            PrintStream originalOut = System.out;
    
            try {
                System.setIn(new ByteArrayInputStream(input.getBytes()));
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outputStream));
                Scanner scanner = new Scanner(System.in);
    
                ArrayList<String> result = Exercici0.modificarClientMenu(scanner);
    
                // Verifica cada línia
                for (int i = 0; i < expectedLines.size(); i++) {
                    String diff = TestStringUtils.findFirstDifference(result.get(i), expectedLines.get(i));
                    assertTrue(diff.equals("identical"),
                        String.format("Per l'entrada '%s' a la línia %d:\n>>>>>>>>>> Diff found >>>>>>>>>>\n%s\n<<<<<<<<<< Diff end <<<<<<<<<<\n",
                            input.replace("\n", "\\n"),
                            i,
                            diff));
                }
    
                // Si la modificació és exitosa, verifica el canvi en el HashMap
                if (expectedLines.get(expectedLines.size() - 1).startsWith("S'ha modificat")) {
                    String clauClient = input.split("\n")[0];
                    String camp = input.split("\n")[1];
                    String nouValor = input.split("\n")[2];
    
                    if (camp.equals("factors")) {
                        List<String> expectedFactors = Arrays.asList(input.split("\n")[2], input.split("\n")[3]);
                        assertEquals(expectedFactors, Exercici0.clients.get(clauClient).get(camp),
                            String.format("El camp '%s' del client '%s' no s'ha actualitzat correctament.", camp, clauClient));
                    } else {
                        assertEquals(nouValor, Exercici0.clients.get(clauClient).get(camp).toString(),
                            String.format("El camp '%s' del client '%s' no s'ha actualitzat correctament.", camp, clauClient));
                    }
                }
    
            } finally {
                // Restaura l'entrada i sortida original
                System.setIn(originalIn);
                System.setOut(originalOut);
            }
        }
    }

    @Test
    public void testEsborrarClientMenu() {
        // Configura els clients globals per tenir dades inicials
        Exercici0.clients.clear();
        HashMap<String, Object> client1 = new HashMap<>();
        client1.put("nom", "Joan");
        client1.put("edat", 30);
        client1.put("factors", Arrays.asList("autònom", "risc alt"));
        client1.put("descompte", 10.0);
        Exercici0.clients.put("client_100", client1);
    
        HashMap<String, Object> client2 = new HashMap<>();
        client2.put("nom", "Maria");
        client2.put("edat", 40);
        client2.put("factors", Arrays.asList("empresa", "risc baix"));
        client2.put("descompte", 15.0);
        Exercici0.clients.put("client_200", client2);
    
        Object[][] testCases = {
            // Cas d'èxit: esborrar un client existent
            {"client_100\n", Arrays.asList(
                "=== Esborrar Client ===",
                "S'ha esborrat el client client_100.")},
    
            // Cas d'error: clau no existent
            {"client_999\n", Arrays.asList(
                "=== Esborrar Client ===",
                "Client amb clau client_999 no existeix.")},
    
            // Cas d'èxit: esborrar un altre client existent
            {"client_200\n", Arrays.asList(
                "=== Esborrar Client ===",
                "S'ha esborrat el client client_200.")}
        };
    
        for (Object[] testCase : testCases) {
            String input = (String) testCase[0];
            List<String> expectedLines = (List<String>) testCase[1];
    
            // Captura l'entrada simulada i la sortida del sistema
            InputStream originalIn = System.in;
            PrintStream originalOut = System.out;
    
            try {
                System.setIn(new ByteArrayInputStream(input.getBytes()));
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outputStream));
                Scanner scanner = new Scanner(System.in);
    
                ArrayList<String> result = Exercici0.esborrarClientMenu(scanner);
    
                // Verifica cada línia
                for (int i = 0; i < expectedLines.size(); i++) {
                    String diff = TestStringUtils.findFirstDifference(result.get(i), expectedLines.get(i));
                    assertTrue(diff.equals("identical"),
                        String.format("Per l'entrada '%s' a la línia %d:\n>>>>>>>>>> Diff found >>>>>>>>>>\n%s\n<<<<<<<<<< Diff end <<<<<<<<<<\n",
                            input.replace("\n", "\\n"),
                            i,
                            diff));
                }
    
                // Si l'operació és exitosa, comprova que el client ha estat eliminat
                if (expectedLines.get(expectedLines.size() - 1).startsWith("S'ha esborrat")) {
                    String clauClient = input.split("\n")[0];
                    assertFalse(Exercici0.clients.containsKey(clauClient),
                        String.format("El client amb clau '%s' no ha estat eliminat correctament.", clauClient));
                }
    
            } finally {
                // Restaura l'entrada i sortida original
                System.setIn(originalIn);
                System.setOut(originalOut);
            }
        }
    }
    
}

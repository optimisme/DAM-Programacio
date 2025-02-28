package com.exercicis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;
import com.github.stefanbirkner.systemlambda.SystemLambda;
import com.testStringUtils.TestStringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import org.json.JSONObject;
import org.json.JSONArray;

class TestExercici0203 {

    private Locale defaultLocale;
    private static final String PATH_MONUMENTS = "./data/monuments.json";

    @BeforeEach
    public void setUp() {
        defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);
    }

    @AfterEach
    public void tearDown() {
        Locale.setDefault(defaultLocale);
    }

    @Test
    void testValidarURL(TestInfo testInfo) {
        try {
            String[] valides = {
                "http://example.com", "https://www.google.com",
                "https://sub.domini.cat/pagina", "http://localhost:8080",
                "http://www.ieti.cat:8080/horaris"
            };
            
            String[] invalides = {
                "", "ftp://example.com", "http:/example",
                "http:/example.com", "https:// google.com",
                "https://.example.com", "https://example.", "example.com"
            };

            for (String url : valides) {
                assertTrue(Exercici0203.validarURL(url), "Error: URL vàlida detectada com a invàlida: " + url);
            }
            
            for (String url : invalides) {
                assertFalse(Exercici0203.validarURL(url), "Error: URL invàlida detectada com a vàlida: " + url);
            }

            System.out.println("Test passed, succeeded!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }

    @Test
    void testLoadMonuments(TestInfo testInfo) {
        try {
            ArrayList<HashMap<String, Object>> monuments = Exercici0203.loadMonuments("./data/monuments.json");
            assertEquals(4, monuments.size());

            // Primer monument: Gran Muralla Xinesa
            HashMap<String, Object> m1 = monuments.get(0);
            assertEquals("Gran Muralla Xinesa", m1.get("nom"));
            assertEquals("Xina", m1.get("pais"));
            assertEquals("Monumental", m1.get("categoria"));
            HashMap<String, Object> detalls1 = (HashMap<String, Object>) m1.get("detalls");
            assertEquals(1987, detalls1.get("any_declaracio"));
            HashMap<String, Object> coords1 = (HashMap<String, Object>) detalls1.get("coordenades");
            assertEquals(40.4319, (Double) coords1.get("latitud"), 0.0001);
            assertEquals(116.5704, (Double) coords1.get("longitud"), 0.0001);
            HashMap<String, Object> altres1 = (HashMap<String, Object>) detalls1.get("altres");
            HashMap<String, Object> extensioMap = (HashMap<String, Object>) altres1.get("extensio");
            assertEquals("extensio", extensioMap.get("clau"));
            assertEquals("21,196 km", extensioMap.get("valor"));

            // Segon monument: Machu Picchu
            HashMap<String, Object> m2 = monuments.get(1);
            assertEquals("Machu Picchu", m2.get("nom"));
            assertEquals("Perú", m2.get("pais"));
            assertEquals("Cultural", m2.get("categoria"));
            HashMap<String, Object> detalls2 = (HashMap<String, Object>) m2.get("detalls");
            assertEquals(1983, detalls2.get("any_declaracio"));
            HashMap<String, Object> coords2 = (HashMap<String, Object>) detalls2.get("coordenades");
            assertEquals(-13.1631, (Double) coords2.get("latitud"), 0.0001);
            assertEquals(-72.5450, (Double) coords2.get("longitud"), 0.0001);
            HashMap<String, Object> altres2 = (HashMap<String, Object>) detalls2.get("altres");
            HashMap<String, Object> alcadaMap = (HashMap<String, Object>) altres2.get("alçada");
            assertEquals("alçada", alcadaMap.get("clau"));
            assertEquals("2,430 m sobre el nivell del mar", alcadaMap.get("valor"));

            // Tercer monument: Catedral de Notre-Dame
            HashMap<String, Object> m3 = monuments.get(2);
            assertEquals("Catedral de Notre-Dame", m3.get("nom"));
            assertEquals("França", m3.get("pais"));
            assertEquals("Monumental", m3.get("categoria"));
            HashMap<String, Object> detalls3 = (HashMap<String, Object>) m3.get("detalls");
            assertEquals(1991, detalls3.get("any_declaracio"));
            HashMap<String, Object> coords3 = (HashMap<String, Object>) detalls3.get("coordenades");
            assertEquals(48.852968, (Double) coords3.get("latitud"), 0.0001);
            assertEquals(2.349902, (Double) coords3.get("longitud"), 0.0001);
            HashMap<String, Object> altres3 = (HashMap<String, Object>) detalls3.get("altres");
            HashMap<String, Object> estatMap = (HashMap<String, Object>) altres3.get("estat_actual");
            assertEquals("estat_actual", estatMap.get("clau"));
            assertEquals("En restauració després de l'incendi de 2019", estatMap.get("valor"));

            // Quart monument: Parc Nacional de Serengeti
            HashMap<String, Object> m4 = monuments.get(3);
            assertEquals("Parc Nacional de Serengeti", m4.get("nom"));
            assertEquals("Tanzània", m4.get("pais"));
            assertEquals("Natural", m4.get("categoria"));
            HashMap<String, Object> detalls4 = (HashMap<String, Object>) m4.get("detalls");
            assertEquals(1981, detalls4.get("any_declaracio"));
            HashMap<String, Object> coords4 = (HashMap<String, Object>) detalls4.get("coordenades");
            assertEquals(-2.333333, (Double) coords4.get("latitud"), 0.0001);
            assertEquals(34.833333, (Double) coords4.get("longitud"), 0.0001);
            HashMap<String, Object> altres4 = (HashMap<String, Object>) detalls4.get("altres");
            HashMap<String, Object> superficieMap = (HashMap<String, Object>) altres4.get("superficie");
            assertEquals("superficie", superficieMap.get("clau"));
            assertEquals("14,763 km²", superficieMap.get("valor"));

            System.out.println("Test passed, succeeded!");
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
            fail(e);
        }
    }


    @Test
    void testGetMonumentValue(TestInfo testInfo) {
        try {
            Class<?> clazz = Exercici0203.class;
            java.lang.reflect.Method method = clazz.getDeclaredMethod("getMonumentValue", HashMap.class, String.class);
            method.setAccessible(true);
            
            HashMap<String, Object> monument = new HashMap<>();
            monument.put("nom", "Test Monument");
            monument.put("pais", "Test Country");
            monument.put("categoria", "Test Category");
            
            HashMap<String, Object> detalls = new HashMap<>();
            detalls.put("any_declaracio", 2000);
            HashMap<String, Object> coordenades = new HashMap<>();
            coordenades.put("latitud", 10.123);
            coordenades.put("longitud", 20.456);
            detalls.put("coordenades", coordenades);
            monument.put("detalls", detalls);
            
            Object nom = method.invoke(null, monument, "nom");
            Object pais = method.invoke(null, monument, "pais");
            Object categoria = method.invoke(null, monument, "categoria");
            Object any = method.invoke(null, monument, "any");
            Object latitud = method.invoke(null, monument, "latitud");
            Object longitud = method.invoke(null, monument, "longitud");
            Object invalid = method.invoke(null, monument, "invalid");
            
            assertEquals("Test Monument", nom);
            assertEquals("Test Country", pais);
            assertEquals("Test Category", categoria);
            assertEquals(2000, any);
            assertEquals(10.123, (Double) latitud, 0.0001);
            assertEquals(20.456, (Double) longitud, 0.0001);
            assertNull(invalid);
            
            System.out.println("Test passed, succeeded!");
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
            fail(e);
        }
    }


    @Test
    void testIsValidValue(TestInfo testInfo) {
        try {
            Class<?> clazz = Exercici0203.class;
            java.lang.reflect.Method method = clazz.getDeclaredMethod("isValid", String.class, String[].class);
            method.setAccessible(true);
            String[] validValues = {"A", "B", "C"};
            assertTrue((Boolean) method.invoke(null, "A", validValues));
            assertTrue((Boolean) method.invoke(null, "B", validValues));
            assertFalse((Boolean) method.invoke(null, "D", validValues));
            assertFalse((Boolean) method.invoke(null, "", validValues));
            assertFalse((Boolean) method.invoke(null, null, validValues));
            System.out.println("Test passed, succeeded!");
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
            fail(e);
        }
    }

    @Test
    void testOrdenaMonuments(TestInfo testInfo) {
        try {
            ArrayList<HashMap<String, Object>> monuments = new ArrayList<>();
            
            HashMap<String, Object> m1 = new HashMap<>();
            m1.put("nom", "Alpha Monument");
            HashMap<String, Object> d1 = new HashMap<>();
            d1.put("any_declaracio", 2000);
            HashMap<String, Object> c1 = new HashMap<>();
            c1.put("latitud", 40.0);
            c1.put("longitud", 20.0);
            d1.put("coordenades", c1);
            m1.put("detalls", d1);
            monuments.add(m1);
            
            HashMap<String, Object> m2 = new HashMap<>();
            m2.put("nom", "Beta Monument");
            HashMap<String, Object> d2 = new HashMap<>();
            d2.put("any_declaracio", 1990);
            HashMap<String, Object> c2 = new HashMap<>();
            c2.put("latitud", 35.0);
            c2.put("longitud", 25.0);
            d2.put("coordenades", c2);
            m2.put("detalls", d2);
            monuments.add(m2);
            
            HashMap<String, Object> m3 = new HashMap<>();
            m3.put("nom", "Gamma Monument");
            HashMap<String, Object> d3 = new HashMap<>();
            d3.put("any_declaracio", 2010);
            HashMap<String, Object> c3 = new HashMap<>();
            c3.put("latitud", 45.0);
            c3.put("longitud", 15.0);
            d3.put("coordenades", c3);
            m3.put("detalls", d3);
            monuments.add(m3);
            
            HashMap<String, Object> m4 = new HashMap<>();
            m4.put("nom", "Delta Monument");
            HashMap<String, Object> d4 = new HashMap<>();
            d4.put("any_declaracio", 2005);
            HashMap<String, Object> c4 = new HashMap<>();
            c4.put("latitud", 38.0);
            c4.put("longitud", 22.0);
            d4.put("coordenades", c4);
            m4.put("detalls", d4);
            monuments.add(m4);
            
            ArrayList<HashMap<String, Object>> sortedNom = Exercici0203.ordenaMonuments(monuments, "nom");
            assertEquals("Alpha Monument", sortedNom.get(0).get("nom"));
            assertEquals("Beta Monument", sortedNom.get(1).get("nom"));
            assertEquals("Delta Monument", sortedNom.get(2).get("nom"));
            assertEquals("Gamma Monument", sortedNom.get(3).get("nom"));
            
            ArrayList<HashMap<String, Object>> sortedAny = Exercici0203.ordenaMonuments(monuments, "any");
            assertEquals(1990, Exercici0203.getMonumentValue(sortedAny.get(0), "any"));
            assertEquals(2000, Exercici0203.getMonumentValue(sortedAny.get(1), "any"));
            assertEquals(2005, Exercici0203.getMonumentValue(sortedAny.get(2), "any"));
            assertEquals(2010, Exercici0203.getMonumentValue(sortedAny.get(3), "any"));
            
            ArrayList<HashMap<String, Object>> sortedLat = Exercici0203.ordenaMonuments(monuments, "latitud");
            assertEquals(35.0, (Double) Exercici0203.getMonumentValue(sortedLat.get(0), "latitud"), 0.0001);
            assertEquals(38.0, (Double) Exercici0203.getMonumentValue(sortedLat.get(1), "latitud"), 0.0001);
            assertEquals(40.0, (Double) Exercici0203.getMonumentValue(sortedLat.get(2), "latitud"), 0.0001);
            assertEquals(45.0, (Double) Exercici0203.getMonumentValue(sortedLat.get(3), "latitud"), 0.0001);
            
            ArrayList<HashMap<String, Object>> sortedLong = Exercici0203.ordenaMonuments(monuments, "longitud");
            assertEquals(15.0, (Double) Exercici0203.getMonumentValue(sortedLong.get(0), "longitud"), 0.0001);
            assertEquals(20.0, (Double) Exercici0203.getMonumentValue(sortedLong.get(1), "longitud"), 0.0001);
            assertEquals(22.0, (Double) Exercici0203.getMonumentValue(sortedLong.get(2), "longitud"), 0.0001);
            assertEquals(25.0, (Double) Exercici0203.getMonumentValue(sortedLong.get(3), "longitud"), 0.0001);
            
            try {
                Exercici0203.ordenaMonuments(monuments, "invalid");
                fail("Expected IllegalArgumentException for invalid sort key");
            } catch (IllegalArgumentException e) {}
            
            System.out.println("Test passed, succeeded!");
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
            fail(e);
        }
    }

    @Test
    void testFiltraMonuments(TestInfo testInfo) {
        try {
            ArrayList<HashMap<String, Object>> monuments = new ArrayList<>();
            
            HashMap<String, Object> m1 = new HashMap<>();
            m1.put("nom", "Monument A");
            m1.put("pais", "Country A");
            m1.put("categoria", "Category A");
            monuments.add(m1);
            
            HashMap<String, Object> m2 = new HashMap<>();
            m2.put("nom", "Monument B");
            m2.put("pais", "Country B");
            m2.put("categoria", "Category B");
            monuments.add(m2);
            
            HashMap<String, Object> m3 = new HashMap<>();
            m3.put("nom", "Monument C");
            m3.put("pais", "Country A");
            m3.put("categoria", "Category A");
            monuments.add(m3);
            
            ArrayList<HashMap<String, Object>> filteredNom = Exercici0203.filtraMonuments(monuments, "nom", "Monument B");
            assertEquals(1, filteredNom.size());
            assertEquals("Monument B", filteredNom.get(0).get("nom"));
            
            ArrayList<HashMap<String, Object>> filteredPais = Exercici0203.filtraMonuments(monuments, "pais", "Country A");
            assertEquals(2, filteredPais.size());
            for (HashMap<String, Object> m : filteredPais) {
                assertEquals("Country A", m.get("pais"));
            }
            
            ArrayList<HashMap<String, Object>> filteredCategoria = Exercici0203.filtraMonuments(monuments, "categoria", "category a");
            assertEquals(2, filteredCategoria.size());
            for (HashMap<String, Object> m : filteredCategoria) {
                assertEquals("Category A", m.get("categoria"));
            }
            
            try {
                Exercici0203.filtraMonuments(monuments, "invalid", "value");
                fail("Expected IllegalArgumentException for invalid filter key");
            } catch (IllegalArgumentException e) {}
            
            System.out.println("Test passed, succeeded!");
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
            fail(e);
        }
    }

    @Test
    void testGeneraMarcTaula(TestInfo testInfo) {
        try {
            String result1 = Exercici0203.generaMarcTaula(new int[]{2, 5, 3}, new char[]{'┌', '┬', '┐'});
            assertEquals("┌──┬─────┬───┐", result1);
            
            String result2 = Exercici0203.generaMarcTaula(new int[]{4, 3, 6}, new char[]{'├', '┼', '┤'});
            assertEquals("├────┼───┼──────┤", result2);
            
            String result3 = Exercici0203.generaMarcTaula(new int[]{2, 4}, new char[]{'└', '┴', '┘'});
            assertEquals("└──┴────┘", result3);
            
            System.out.println("Test passed, succeeded!");
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
            fail(e);
        }
    }

    @Test
    void testFormatRow(TestInfo testInfo) {
        try {
            Class<?> clazz = Exercici0203.class;
            java.lang.reflect.Method method = clazz.getDeclaredMethod("formatRow", String[].class, int[].class);
            method.setAccessible(true);
            
            String[] values1 = {"Nom", "País", "Any"};
            int[] widths1 = {10, 6, 4};
            String expected1 = "│Nom       │País  │Any │";
            String result1 = (String) method.invoke(null, values1, widths1);
            assertEquals(expected1, result1);
            
            String[] values2 = {"Machu Picchu", "Perú", "1983"};
            int[] widths2 = {10, 6, 4};
            String expected2 = "│Machu Picc│Perú  │1983│";
            String result2 = (String) method.invoke(null, values2, widths2);
            assertEquals(expected2, result2);
            
            System.out.println("Test passed, succeeded!");
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
            fail(e);
        }
    }

    @Test
    void testGetCoordsString(TestInfo testInfo) {
        try {
            ArrayList<HashMap<String, Object>> monuments = Exercici0203.loadMonuments("./data/monuments.json");
            assertEquals(4, monuments.size());

            Class<?> clazz = Exercici0203.class;
            java.lang.reflect.Method getCoordsStringMethod = clazz.getDeclaredMethod("getCoordsString", HashMap.class);
            getCoordsStringMethod.setAccessible(true);

            String coords1 = (String) getCoordsStringMethod.invoke(null, monuments.get(0));
            assertEquals("40.4,116.6", coords1);

            String coords2 = (String) getCoordsStringMethod.invoke(null, monuments.get(1));
            assertEquals("-13.2,-72.5", coords2);

            String coords3 = (String) getCoordsStringMethod.invoke(null, monuments.get(2));
            assertEquals("48.9,2.3", coords3);

            String coords4 = (String) getCoordsStringMethod.invoke(null, monuments.get(3));
            assertEquals("-2.3,34.8", coords4);

            System.out.println("Test passed, succeeded!");
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
            fail(e);
        }
    }

    @Test
    void testTaulaMonuments(TestInfo testInfo) {
        try {
            ArrayList<HashMap<String, Object>> monuments = Exercici0203.loadMonuments("./data/monuments.json");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(baos));
            
            Exercici0203.taulaMonuments(monuments);
            
            System.setOut(originalOut);
            String output = baos.toString().replace("\r\n", "\n");
            String nl = "\n";
            String expected = "┌──────────────┬─────┬────┬────────────┐" + nl +
                              "│Nom           │Pais │Any │Coords      │" + nl +
                              "├──────────────┼─────┼────┼────────────┤" + nl +
                              "│Gran Muralla X│Xina │1987│40.4,116.6  │" + nl +
                              "│Machu Picchu  │Perú │1983│-13.2,-72.5 │" + nl +
                              "│Catedral de No│Franç│1991│48.9,2.3    │" + nl +
                              "│Parc Nacional │Tanzà│1981│-2.3,34.8   │" + nl +
                              "└──────────────┴─────┴────┴────────────┘";
            expected = expected.replace("\r\n", "\n");
            assertEquals(expected.trim(), output.trim(), "La taula generada no coincideix amb l'esperada");
            System.out.println("Test passed, succeeded!");
        } catch (Exception e) {
            e.printStackTrace();
            fail(e);
        }
    }

    @Test
    void testGeneraBaralla(TestInfo testInfo) {
        try {
            ArrayList<HashMap<String, Object>> baralla = Exercici0203.generaBaralla();
            // La baralla ha de tenir 48 cartes (4 pals x 12 números)
            assertEquals(48, baralla.size(), "La baralla ha de tenir 48 cartes");
            
            String[] pals = {"oros", "copes", "espases", "bastos"};
            int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
            
            // Verificar que cada combinació de pal i número apareix exactament una vegada
            for (String pal : pals) {
                for (int num : numeros) {
                    int count = 0;
                    for (HashMap<String, Object> carta : baralla) {
                        if (pal.equals(carta.get("pal")) && Integer.valueOf(num).equals(carta.get("número"))) {
                            count++;
                        }
                    }
                    assertEquals(1, count, "La carta {" + pal + ", " + num + "} ha d'aparèixer exactament una vegada");
                }
            }
            System.out.println("Test passed, succeeded!");
        } catch (Exception e) {
            e.printStackTrace();
            fail(e);
        }
    }

}

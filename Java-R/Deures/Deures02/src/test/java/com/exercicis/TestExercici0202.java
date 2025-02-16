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
import java.util.Locale;

class TestExercici0202 {

    private Locale defaultLocale;

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
    void testShowJSONAstronautes(TestInfo testInfo) {
        try {
            String output = SystemLambda.tapSystemOut(() -> 
                Exercici0202.showJSONAstronautes("./data/astronautes.json")
            ).trim().replace("\r\n", "\n");

            String expected = """
                > Astronauta 0:
                  Nom: Yuri Gagarin
                  Naixement: 1934
                > Astronauta 1:
                  Nom: Neil Armstrong
                  Naixement: 1930
                > Astronauta 2:
                  Nom: Buzz Aldrin
                  Naixement: 1930
                > Astronauta 3:
                  Nom: Sally Ride
                  Naixement: 1951
                > Astronauta 4:
                  Nom: Chris Hadfield
                  Naixement: 1959
                > Astronauta 5:
                  Nom: Valentina Tereshkova
                  Naixement: 1937
                > Astronauta 6:
                  Nom: John Glenn
                  Naixement: 1921
                > Astronauta 7:
                  Nom: Alan Shepard
                  Naixement: 1923
                > Astronauta 8:
                  Nom: Mae Jemison
                  Naixement: 1956
                > Astronauta 9:
                  Nom: Peggy Whitson
                  Naixement: 1960
                """.trim().replace("\r\n", "\n");

            // Comparació amb TestStringUtils.findFirstDifference()
            String diff = TestStringUtils.findFirstDifference(output, expected);
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

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
    void testJSONAstronautesToArrayList(TestInfo testInfo) {
        try {
            String filePath = "./data/astronautes.json";
            ArrayList<HashMap<String, Object>> result = Exercici0202.JSONAstronautesToArrayList(filePath);

            assertNotNull(result, "La llista retornada no hauria de ser null.");
            assertEquals(10, result.size(), "El nombre d'astronautes no coincideix amb l'esperat.");

            // Validació dels primers 3 astronautes com a exemple
            assertEquals("Yuri Gagarin", result.get(0).get("nom"));
            assertEquals(1934, result.get(0).get("any_naixement"));

            assertEquals("Neil Armstrong", result.get(1).get("nom"));
            assertEquals(1930, result.get(1).get("any_naixement"));

            assertEquals("Buzz Aldrin", result.get(2).get("nom"));
            assertEquals(1930, result.get(2).get("any_naixement"));

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
    void testJSONEsportistesToArrayList(TestInfo testInfo) {
        try {
            String filePath = "./data/esportistes.json";
            ArrayList<HashMap<String, Object>> result = Exercici0202.JSONEsportistesToArrayList(filePath);

            assertNotNull(result, "La llista retornada no hauria de ser null.");
            assertFalse(result.isEmpty(), "La llista retornada no hauria d'estar buida.");
            assertEquals(10, result.size(), "El nombre d'esportistes no coincideix amb l'esperat.");

            // Validació de valors esperats
            String[] nomsEsperats = {
                "Usain Bolt", "Michael Phelps", "Simone Biles", "Carl Lewis", "Nadia Comaneci",
                "Mark Spitz", "Larisa Latynina", "Paavo Nurmi", "Serena Williams", "Jackie Joyner-Kersee"
            };
            int[] anysEsperats = {1986, 1985, 1997, 1961, 1961, 1950, 1934, 1897, 1981, 1962};
            String[] paisosEsperats = {
                "Jamaica", "Estats Units", "Estats Units", "Estats Units", "Romania",
                "Estats Units", "Unió Soviètica", "Finlàndia", "Estats Units", "Estats Units"
            };
            int[][] medallesEsperades = {
                {8, 0, 0}, {23, 3, 2}, {4, 1, 2}, {9, 1, 0}, {5, 3, 1},
                {9, 1, 1}, {9, 5, 4}, {9, 3, 0}, {4, 0, 0}, {3, 1, 2}
            };

            for (int i = 0; i < result.size(); i++) {
                HashMap<String, Object> esportista = result.get(i);
                assertEquals(nomsEsperats[i], esportista.get("nom"), "Error al validar el nom de l'esportista a l'índex " + i);
                assertEquals(anysEsperats[i], esportista.get("any_naixement"), "Error al validar l'any de naixement a l'índex " + i);
                assertEquals(paisosEsperats[i], esportista.get("pais"), "Error al validar el país a l'índex " + i);

                // Validació de medalles
                @SuppressWarnings("unchecked")
                HashMap<String, Integer> medalles = (HashMap<String, Integer>) esportista.get("medalles");
                assertNotNull(medalles, "L'objecte de medalles no hauria de ser null a l'índex " + i);
                assertEquals(medallesEsperades[i][0], medalles.get("or"), "Error en les medalles d'or a l'índex " + i);
                assertEquals(medallesEsperades[i][1], medalles.get("plata"), "Error en les medalles de plata a l'índex " + i);
                assertEquals(medallesEsperades[i][2], medalles.get("bronze"), "Error en les medalles de bronze a l'índex " + i);
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

    private void validarOrdreMedalles(ArrayList<HashMap<String, Object>> esportistes, String tipusMedalla) {
        int medallaAnterior = Integer.MAX_VALUE; // Comencem amb un valor alt perquè la primera medalla sigui més petita o igual

        for (HashMap<String, Object> esportista : esportistes) {
            @SuppressWarnings("unchecked")
            HashMap<String, Integer> medalles = (HashMap<String, Integer>) esportista.get("medalles");
            int medallaActual = medalles.get(tipusMedalla);

            assertTrue(medallaActual <= medallaAnterior, "La llista no està ordenada correctament per medalles de tipus: " + tipusMedalla);
            medallaAnterior = medallaActual;
        }
    }

    @Test
    void testOrdenarEsportistesPerMedalla(TestInfo testInfo) {
        try {
            String filePath = "./data/esportistes.json";

            // Test d'ordenació per medalles d'or
            ArrayList<HashMap<String, Object>> ordenatsOr = Exercici0202.ordenarEsportistesPerMedalla(filePath, "or");
            assertNotNull(ordenatsOr, "La llista no hauria de ser null.");
            assertFalse(ordenatsOr.isEmpty(), "La llista no hauria d'estar buida.");
            assertEquals(10, ordenatsOr.size(), "El nombre d'esportistes no coincideix amb l'esperat.");
            validarOrdreMedalles(ordenatsOr, "or");

            // Test d'ordenació per medalles de plata
            ArrayList<HashMap<String, Object>> ordenatsPlata = Exercici0202.ordenarEsportistesPerMedalla(filePath, "plata");
            assertNotNull(ordenatsPlata, "La llista no hauria de ser null.");
            assertFalse(ordenatsPlata.isEmpty(), "La llista no hauria d'estar buida.");
            assertEquals(10, ordenatsPlata.size(), "El nombre d'esportistes no coincideix amb l'esperat.");
            validarOrdreMedalles(ordenatsPlata, "plata");

            // Test d'ordenació per medalles de bronze
            ArrayList<HashMap<String, Object>> ordenatsBronze = Exercici0202.ordenarEsportistesPerMedalla(filePath, "bronze");
            assertNotNull(ordenatsBronze, "La llista no hauria de ser null.");
            assertFalse(ordenatsBronze.isEmpty(), "La llista no hauria d'estar buida.");
            assertEquals(10, ordenatsBronze.size(), "El nombre d'esportistes no coincideix amb l'esperat.");
            validarOrdreMedalles(ordenatsBronze, "bronze");

            // Test amb tipus de medalla invàlid
            Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Exercici0202.ordenarEsportistesPerMedalla(filePath, "diamant")
            );
            assertTrue(exception.getMessage().contains("Tipus de medalla invàlid"), "L'excepció esperada no s'ha llençat correctament.");

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
    void testMostrarEsportistesOrdenatsPerOr(TestInfo testInfo) {
        try {
            String filePath = "./data/esportistes.json";

            String outputOr = SystemLambda.tapSystemOut(() ->
                Exercici0202.mostrarEsportistesOrdenatsPerMedalla(filePath, "or")
            ).trim().replace("\r\n", "\n").replaceAll("\\s{2,}", " ");

            String expectedOr = """
                ┌──────────────────────┬─────────────────┬────────────┬────────┐
                │ Nom                  │ País            │ Naixement  │ Or     │
                ├──────────────────────┼─────────────────┼────────────┼────────┤
                │ Michael Phelps       │ Estats Units    │ 1985       │ 23     │
                │ Carl Lewis           │ Estats Units    │ 1961       │ 9      │
                │ Mark Spitz           │ Estats Units    │ 1950       │ 9      │
                │ Larisa Latynina      │ Unió Soviètica  │ 1934       │ 9      │
                │ Paavo Nurmi          │ Finlàndia       │ 1897       │ 9      │
                │ Usain Bolt           │ Jamaica         │ 1986       │ 8      │
                │ Nadia Comaneci       │ Romania         │ 1961       │ 5      │
                │ Simone Biles         │ Estats Units    │ 1997       │ 4      │
                │ Serena Williams      │ Estats Units    │ 1981       │ 4      │
                │ Jackie Joyner-Kersee │ Estats Units    │ 1962       │ 3      │
                └──────────────────────┴─────────────────┴────────────┴────────┘
                """.trim().replace("\r\n", "\n").replaceAll("\\s{2,}", " ");

            assertTrue(TestStringUtils.findFirstDifference(outputOr, expectedOr).equals("identical"));

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }

    @Test
    void testMostrarEsportistesOrdenatsPerPlata(TestInfo testInfo) {
        try {
            String filePath = "./data/esportistes.json";

            String outputPlata = SystemLambda.tapSystemOut(() ->
                Exercici0202.mostrarEsportistesOrdenatsPerMedalla(filePath, "plata")
            ).trim().replace("\r\n", "\n").replaceAll("\\s{2,}", " ");

            String expectedPlata = """
                ┌──────────────────────┬─────────────────┬────────────┬────────┐
                │ Nom                  │ País            │ Naixement  │ Plata  │
                ├──────────────────────┼─────────────────┼────────────┼────────┤
                │ Larisa Latynina      │ Unió Soviètica  │ 1934       │ 5      │
                │ Michael Phelps       │ Estats Units    │ 1985       │ 3      │
                │ Nadia Comaneci       │ Romania         │ 1961       │ 3      │
                │ Paavo Nurmi          │ Finlàndia       │ 1897       │ 3      │
                │ Simone Biles         │ Estats Units    │ 1997       │ 1      │
                │ Carl Lewis           │ Estats Units    │ 1961       │ 1      │
                │ Mark Spitz           │ Estats Units    │ 1950       │ 1      │
                │ Jackie Joyner-Kersee │ Estats Units    │ 1962       │ 1      │
                │ Usain Bolt           │ Jamaica         │ 1986       │ 0      │
                │ Serena Williams      │ Estats Units    │ 1981       │ 0      │
                └──────────────────────┴─────────────────┴────────────┴────────┘
                """.trim().replace("\r\n", "\n").replaceAll("\\s{2,}", " ");

            assertTrue(TestStringUtils.findFirstDifference(outputPlata, expectedPlata).equals("identical"));

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }

    @Test
    void testMostrarEsportistesOrdenatsPerBronze(TestInfo testInfo) {
        try {
            String filePath = "./data/esportistes.json";

            String outputBronze = SystemLambda.tapSystemOut(() ->
                Exercici0202.mostrarEsportistesOrdenatsPerMedalla(filePath, "bronze")
            ).trim().replace("\r\n", "\n").replaceAll("\\s{2,}", " ");

            String expectedBronze = """
                ┌──────────────────────┬─────────────────┬────────────┬────────┐
                │ Nom                  │ País            │ Naixement  │ Bronze │
                ├──────────────────────┼─────────────────┼────────────┼────────┤
                │ Larisa Latynina      │ Unió Soviètica  │ 1934       │ 4      │
                │ Michael Phelps       │ Estats Units    │ 1985       │ 2      │
                │ Simone Biles         │ Estats Units    │ 1997       │ 2      │
                │ Jackie Joyner-Kersee │ Estats Units    │ 1962       │ 2      │
                │ Nadia Comaneci       │ Romania         │ 1961       │ 1      │
                │ Mark Spitz           │ Estats Units    │ 1950       │ 1      │
                │ Carl Lewis           │ Estats Units    │ 1961       │ 0      │
                │ Paavo Nurmi          │ Finlàndia       │ 1897       │ 0      │
                │ Usain Bolt           │ Jamaica         │ 1986       │ 0      │
                │ Serena Williams      │ Estats Units    │ 1981       │ 0      │
                └──────────────────────┴─────────────────┴────────────┴────────┘
                """.trim().replace("\r\n", "\n").replaceAll("\\s{2,}", " ");

            assertTrue(TestStringUtils.findFirstDifference(outputBronze, expectedBronze).equals("identical"));

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }
}

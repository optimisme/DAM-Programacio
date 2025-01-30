package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.*;

class TestExercici0013 {

    @Test
    public void testGenerateId(TestInfo testInfo) throws Exception {
        try {
            ArrayList<HashMap<String, Object>> cities = new ArrayList<>();
            int id1 = Exercici0013.generateId(cities);
            int id2 = Exercici0013.generateId(cities);
            
            assertTrue(id1 >= 1000 && id1 <= 9999);
            assertTrue(id2 >= 1000 && id2 <= 9999);
            assertNotEquals(id1, id2);
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
    public void testIdExists(TestInfo testInfo) throws Exception {
        try {
            ArrayList<HashMap<String, Object>> cities = new ArrayList<>();
            HashMap<String, Object> city = new HashMap<>();
            city.put("id", 1234);
            city.put("name", "Test City");
            cities.add(city);

            assertTrue(Exercici0013.idExists(cities, 1234));
            assertFalse(Exercici0013.idExists(cities, 5678));
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
    public void testGetIdByName(TestInfo testInfo) throws Exception {
        try {
            ArrayList<HashMap<String, Object>> cities = new ArrayList<>();
            Exercici0013.addCity(cities, "TestCity", 100000, 10, true);
            int id = Exercici0013.getIdByName(cities, "TestCity");
            assertTrue(id >= 1000 && id <= 9999);
            assertEquals(-1, Exercici0013.getIdByName(cities, "NonExistentCity"));
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
    public void testAddCity(TestInfo testInfo) throws Exception {
        try {
            ArrayList<HashMap<String, Object>> cities = new ArrayList<>();
            Exercici0013.addCity(cities, "TestCity", 100000, 10, true);
            
            assertEquals(1, cities.size());
            HashMap<String, Object> city = cities.get(0);
            
            assertTrue((int)city.get("id") >= 1000 && (int)city.get("id") <= 9999);
            assertEquals("TestCity", city.get("name"));
            assertEquals(100000, city.get("population"));
            assertEquals(10, city.get("height"));
            assertEquals(true, city.get("sealand"));
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
    public void testRemoveCity(TestInfo testInfo) throws Exception {
        try {
            ArrayList<HashMap<String, Object>> cities = new ArrayList<>();
            Exercici0013.addCity(cities, "City1", 100000, 10, true);
            Exercici0013.addCity(cities, "City2", 200000, 20, false);
            
            int id = Exercici0013.getIdByName(cities, "City1");
            Exercici0013.removeCity(cities, id);
            
            assertEquals(1, cities.size());
            assertEquals("City2", cities.get(0).get("name"));
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
    public void testUpdateData(TestInfo testInfo) throws Exception {
        try {
            ArrayList<HashMap<String, Object>> cities = new ArrayList<>();
            Exercici0013.addCity(cities, "TestCity", 100000, 10, true);
            int id = Exercici0013.getIdByName(cities, "TestCity");
            
            Exercici0013.updateData(cities, id, "population", 200000);
            Exercici0013.updateData(cities, id, "name", "NewName");
            Exercici0013.updateData(cities, id, "height", 20);
            Exercici0013.updateData(cities, id, "sealand", false);
            
            HashMap<String, Object> city = cities.get(0);
            assertEquals(200000, city.get("population"));
            assertEquals("NewName", city.get("name"));
            assertEquals(20, city.get("height"));
            assertEquals(false, city.get("sealand"));
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
    public void testShowInformation(TestInfo testInfo) throws Exception {
        try {
            ArrayList<HashMap<String, Object>> cities = new ArrayList<>();
            Exercici0013.addCity(cities, "Barcelona", 1620343, 12, true);
            Exercici0013.addCity(cities, "Madrid", 3207247, 667, false);

            String text = SystemLambda.tapSystemOut(() -> {
                Exercici0013.showInformation(cities);
            });

            assertTrue(text.contains("ID"));
            assertTrue(text.contains("Name"));
            assertTrue(text.contains("Population"));
            assertTrue(text.contains("Height"));
            assertTrue(text.contains("Sealand"));
            assertTrue(text.contains("Barcelona"));
            assertTrue(text.contains("Madrid"));
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
    public void testMainFunction(TestInfo testInfo) throws Exception {
        try {
            String text = SystemLambda.tapSystemOut(() -> {
                Exercici0013.main(new String[]{});
            });

            String expectedOutput = """
                    ----------------------------------------------
                    |ID   |Name      |Population| Height| Sealand|
                    ----------------------------------------------
                    |7009 |Barcelona |   1621000|     12|    true|
                    |4109 |Madrid    |   3207247|    667|   false|
                    |1962 |València  |    791413|     16|    true|
                    |9607 |Màlaga    |    569130|     11|    true|
                    |9414 |Alicante  |    330525|     12|    true|
                    |2954 |Zaragoza  |    664938|    220|   false|
                    |5185 |Gijón     |    275735|      3|    true|
                    |6854 |Palma     |     22610|     14|    true|
                    |6163 |Bilbao    |    345821|     30|   false|
                    |1885 |Tarragona |    132299|     70|    true|
                    ----------------------------------------------
                    """.replace("                ", "");

            text = text.replace("\r\n", "\n");
            
            String[] lines = text.split("\n");
            for (int i = 0; i < lines.length; i++) {
                if (lines[i].startsWith("|") && !lines[i].startsWith("|ID")) {
                    lines[i] = lines[i].replaceFirst("\\|\\d{4}", "|XXXX");
                }
            }
            String normalizedText = String.join("\n", lines) + "\n";
            String normalizedExpected = expectedOutput.replaceAll("\\|\\d{4}", "|XXXX");

            String diff = TestStringUtils.findFirstDifference(normalizedText, normalizedExpected);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");

            assertFalse(text.contains("Sevilla"), "Sevilla no s'hauria d'haver eliminat");
            assertTrue(text.contains("1621000"), "Nova població de Barcelona incorrecta");
            assertTrue(text.contains("16"), "Nova altura de València incorrecta");
            assertTrue(text.contains("Palma"), "Nou nom de Palma incorrecte");
            assertFalse(text.contains("Palma de M"), "El nom antic de Palma encara existeix");
            System.out.println("Test passed, succeeded!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + testInfo.getDisplayName());
            e.printStackTrace();
        }
    }
}
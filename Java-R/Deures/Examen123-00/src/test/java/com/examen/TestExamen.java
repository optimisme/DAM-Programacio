package com.examen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.github.stefanbirkner.systemlambda.SystemLambda;
import com.testStringUtils.TestStringUtils;

class TestExamen {

    private Locale originalLocale;

    static int obtainedPoints = 0;

    private static final HashMap<String, Integer> testPointsMap = new HashMap<>();
    static {
        testPointsMap.put("testGetHashMapSimpleObject", 5);
        testPointsMap.put("testGetHashMapEmptyObject", 5);
        testPointsMap.put("testGetArrayListSimpleArray", 5);
        testPointsMap.put("testGetArrayListEmptyArray", 5);
        testPointsMap.put("testLoadMortgages", 10);
        testPointsMap.put("testValidClientNameSimple", 1);
        testPointsMap.put("testValidClientNameWithAccents", 1);
        testPointsMap.put("testInvalidClientNameWithNumbers", 1);
        testPointsMap.put("testInvalidClientNameWithSpecialChars", 1);
        testPointsMap.put("testEmptyClientName", 1);
        testPointsMap.put("testValidBankNameSimple", 1);
        testPointsMap.put("testValidBankNameWithAccentsAndNumbers", 1);
        testPointsMap.put("testValidBankNameWithDash", 1);
        testPointsMap.put("testInvalidBankNameWithSpecialChars", 1);
        testPointsMap.put("testEmptyBankName", 1);
        testPointsMap.put("testValidPaymentsEqualToFive", 2);
        testPointsMap.put("testValidPaymentsGreaterThanFive", 2);
        testPointsMap.put("testInvalidPaymentsLessThanFive", 1);
        testPointsMap.put("testValidValueGreaterThan50000", 2);
        testPointsMap.put("testInvalidValueEqualTo50000", 1);
        testPointsMap.put("testInvalidValueLessThan50000", 1);
        testPointsMap.put("testIsAllDigitsWithOnlyDigits", 2);
        testPointsMap.put("testIsAllDigitsWithLetters", 2);
        testPointsMap.put("testIsAllDigitsWithEmptyString", 1);
        testPointsMap.put("testValidTimeBoundaries", 4);
        testPointsMap.put("testInvalidHourTooHigh", 2);
        testPointsMap.put("testInvalidMinuteTooHigh", 2);
        testPointsMap.put("testInvalidSecondTooHigh", 2);
        testPointsMap.put("testAlignTextLeft", 2);
        testPointsMap.put("testAlignTextRight", 2);
        testPointsMap.put("testAlignTextCenter", 2);
        testPointsMap.put("testAlignTextTextLongerThanWidth", 2);
        testPointsMap.put("testAlignTextExactWidth", 2);
        testPointsMap.put("testListMortgagesEmpty", 2);
        testPointsMap.put("testListMortgagesSortedByBank", 3);
        testPointsMap.put("testMainOutput", 5);
    }

    @BeforeEach
    void setUp() {
        originalLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);

        Main.isTestEnvironment = true;
        Main.mortgages = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        Locale.setDefault(originalLocale);
        Main.isTestEnvironment = false;
    }

    @AfterAll
    static void showFinalGrade() {
    int total = testPointsMap.values().stream().mapToInt(Integer::intValue).sum();

    double rawScore = (double) obtainedPoints / total * 10;
    double truncated = Math.floor(rawScore);
    double fraction = rawScore - truncated;
    fraction = fraction < 0.5 ? 0.0 : 0.5;
    double finalScore = truncated + fraction;

    String formulaDecimal = String.format("(%d / %d) * 10 = %.2f", obtainedPoints, total, rawScore);
    String formulaReal = String.format("(%d / %d) * 10 = %.1f", obtainedPoints, total, finalScore);
    System.out.println("""
        **************************************************
        Nota decimal: %s
        Nota real:    %s
        **************************************************
        """.formatted(formulaDecimal, formulaReal));
    }

    @Test
    void testGetHashMapSimpleObject(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                String json = "{\"key1\":\"value1\",\"key2\":2,\"key3\":true}";
                HashMap<String, Object> result = Main.getHashMap(json);

                if (result == null) {
                    System.out.println("Hashmap is null.");
                } else {
                    HashMap<String, Object> expected = new HashMap<>();
                    expected.put("key1", "value1");
                    expected.put("key2", 2);
                    expected.put("key3", true);
                    System.out.println(result.equals(expected) ? "Parsed correctly." : "Parsing failed.");
                }
            });
            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Parsed correctly.
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testGetHashMapEmptyObject(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                String json = "{}";
                HashMap<String, Object> result = Main.getHashMap(json);

                if (result == null) {
                    System.out.println("Hashmap is null.");
                } else {
                    System.out.println(result.isEmpty() ? "Empty HashMap parsed correctly." : "Parsing failed for empty HashMap.");
                }
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Empty HashMap parsed correctly.
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testGetArrayListSimpleArray(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                String json = "[{\"key1\":\"value1\"},{\"key2\":2},{\"key3\":true}]";
                ArrayList<HashMap<String, Object>> result = Main.getArrayList(json);

                if (result == null) {
                    System.out.println("Arraylist is null");
                } else {
                    ArrayList<HashMap<String, Object>> expected = new ArrayList<>();
                    HashMap<String, Object> obj1 = new HashMap<>();
                    obj1.put("key1", "value1");
                    HashMap<String, Object> obj2 = new HashMap<>();
                    obj2.put("key2", 2);
                    HashMap<String, Object> obj3 = new HashMap<>();
                    obj3.put("key3", true);
    
                    expected.add(obj1);
                    expected.add(obj2);
                    expected.add(obj3);
    
                    System.out.println(result.equals(expected) ? "Parsed correctly." : "Parsing failed.");                }
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Parsed correctly.
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");
            
            obtainedPoints += testPoints;
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
    void testGetArrayListEmptyArray(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                String json = "[]";
                ArrayList<HashMap<String, Object>> result = Main.getArrayList(json);

                if (result == null) {
                    System.out.println("Arraylist is null");
                } else {
                    System.out.println(result.isEmpty() ? "Empty ArrayList parsed correctly." : "Parsing failed for empty ArrayList.");
                }
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Empty ArrayList parsed correctly.
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testLoadMortgages(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String filePath = "./data/mortgages.json";

            // Carregar les hipoteques
            Main.loadMortgages(filePath);

            // Validar la mida de la llista
            assertEquals(10, Main.mortgages.size(), "La llista de hipoteques hauria de contenir 10 elements.");

            // Validar la primera hipoteca
            HashMap<String, Object> first = Main.mortgages.get(0);
            assertEquals("Banc Sabadell", first.get("bank"), "El banc de la primera hipoteca no coincideix.");
            assertEquals("Pau García", first.get("name"), "El nom del client de la primera hipoteca no coincideix.");
            assertEquals(300, first.get("payments"), "El nombre de pagaments de la primera hipoteca no coincideix.");
            assertEquals(100000.00, ((Number) first.get("value")).doubleValue(), 0.01, "El valor de la primera hipoteca no coincideix.");
            assertEquals(2.1, ((Number) first.get("interest")).doubleValue(), 0.01, "L'interès de la primera hipoteca no coincideix.");
            assertEquals(126000.00, ((Number) first.get("total")).doubleValue(), 0.01, "El total de la primera hipoteca no coincideix.");
            assertEquals(420.00, ((Number) first.get("payment")).doubleValue(), 0.01, "El pagament de la primera hipoteca no coincideix.");
            assertEquals("2022-10-10T10:00:00", first.get("date"), "La data de la primera hipoteca no coincideix.");
            assertEquals("2024-02-29T10:00:00", first.get("modified"), "La data modificada de la primera hipoteca no coincideix.");

            // Validar l'última hipoteca
            HashMap<String, Object> last = Main.mortgages.get(9);
            assertEquals("Ayamatta Bank 3", last.get("bank"), "El banc de l'última hipoteca no coincideix.");
            assertEquals("Eirik Karlsson", last.get("name"), "El nom del client de l'última hipoteca no coincideix.");
            assertEquals(360, last.get("payments"), "El nombre de pagaments de l'última hipoteca no coincideix.");
            assertEquals(55000.00, ((Number) last.get("value")).doubleValue(), 0.01, "El valor de l'última hipoteca no coincideix.");
            assertEquals(2.9, ((Number) last.get("interest")).doubleValue(), 0.01, "L'interès de l'última hipoteca no coincideix.");
            assertEquals(290000.00, ((Number) last.get("total")).doubleValue(), 0.01, "El total de l'última hipoteca no coincideix.");
            assertEquals(805.56, ((Number) last.get("payment")).doubleValue(), 0.01, "El pagament de l'última hipoteca no coincideix.");
            assertEquals("2020-08-01T12:00:00", last.get("date"), "La data de l'última hipoteca no coincideix.");
            assertEquals("2025-02-29T12:00:00", last.get("modified"), "La data modificada de l'última hipoteca no coincideix.");

            obtainedPoints += testPoints;
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
    void testValidClientNameSimple(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                boolean result = Main.isValidClientName("John Doe");
                System.out.println(result ? "Valid client name." : "Invalid client name.");
            });
        
            text = text.replace("\r\n", "\n");
        
            String expectedOutput = """
                Valid client name.
                """.replace("\r\n", "\n").replace("        ", "");
        
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testValidClientNameWithAccents(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                System.out.println(Main.isValidClientName("Pau García") ? "Valid client name with accents." : "Invalid client name.");
                System.out.println(Main.isValidClientName("Àlex Àlvarez") ? "Valid client name with accents." : "Invalid client name.");
            });
        
            text = text.replace("\r\n", "\n");
        
            String expectedOutput = """
                Valid client name with accents.
                Valid client name with accents.
                """.replace("\r\n", "\n").replace("        ", "");
        
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testInvalidClientNameWithNumbers(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                boolean result = Main.isValidClientName("John Doe2");
                System.out.println(result ? "Valid client name with numbers." : "Invalid client name with numbers.");
            });
        
            text = text.replace("\r\n", "\n");
        
            String expectedOutput = """
                Invalid client name with numbers.
                """.replace("\r\n", "\n").replace("        ", "");
        
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testInvalidClientNameWithSpecialChars(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                System.out.println(Main.isValidClientName("John_Doe") ? "Valid client name with special characters." : "Invalid client name with special characters.");
                System.out.println(Main.isValidClientName("M@ry") ? "Valid client name with special characters." : "Invalid client name with special characters.");
            });
        
            text = text.replace("\r\n", "\n");
        
            String expectedOutput = """
                Invalid client name with special characters.
                Invalid client name with special characters.
                """.replace("\r\n", "\n").replace("        ", "");
        
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testEmptyClientName(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                boolean result = Main.isValidClientName("");
                System.out.println(result ? "Valid empty client name." : "Invalid empty client name.");
            });
        
            text = text.replace("\r\n", "\n");
        
            String expectedOutput = """
                Valid empty client name.
                """.replace("\r\n", "\n").replace("        ", "");
        
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testValidBankNameSimple(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                boolean result = Main.isValidBankName("Citibank");
                System.out.println(result ? "Valid bank name." : "Invalid bank name.");
            });
        
            text = text.replace("\r\n", "\n");
        
            String expectedOutput = """
                Valid bank name.
                """.replace("\r\n", "\n").replace("        ", "");
        
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testValidBankNameWithAccentsAndNumbers(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                boolean result = Main.isValidBankName("Banc Sabadell 123");
                System.out.println(result ? "Valid bank name with accents and numbers." : "Invalid bank name.");
            });
        
            text = text.replace("\r\n", "\n");
        
            String expectedOutput = """
                Valid bank name with accents and numbers.
                """.replace("\r\n", "\n").replace("        ", "");
        
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testValidBankNameWithDash(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                boolean result = Main.isValidBankName("Bank-XYZ");
                System.out.println(result ? "Valid bank name with dash." : "Invalid bank name.");
            });
        
            text = text.replace("\r\n", "\n");
        
            String expectedOutput = """
                Valid bank name with dash.
                """.replace("\r\n", "\n").replace("        ", "");
        
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testInvalidBankNameWithSpecialChars(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                System.out.println(Main.isValidBankName("Bank@123") ? "Valid bank name with special characters." : "Invalid bank name with special characters.");
                System.out.println(Main.isValidBankName("Bank#Name") ? "Valid bank name with special characters." : "Invalid bank name with special characters.");
            });
        
            text = text.replace("\r\n", "\n");
        
            String expectedOutput = """
                Invalid bank name with special characters.
                Invalid bank name with special characters.
                """.replace("\r\n", "\n").replace("        ", "");
        
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testEmptyBankName(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                boolean result = Main.isValidBankName("");
                System.out.println(result ? "Valid empty bank name." : "Invalid empty bank name.");
            });
        
            text = text.replace("\r\n", "\n");
        
            String expectedOutput = """
                Valid empty bank name.
                """.replace("\r\n", "\n").replace("        ", "");
        
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testValidPaymentsEqualToFive(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                boolean result = Main.isValidPayments(5);
                System.out.println(result ? "Valid payments: 5." : "Invalid payments: 5.");
            });
        
            text = text.replace("\r\n", "\n");
        
            String expectedOutput = """
                Valid payments: 5.
                """.replace("\r\n", "\n").replace("        ", "");
        
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testValidPaymentsGreaterThanFive(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                boolean result = Main.isValidPayments(10);
                System.out.println(result ? "Valid payments: 10." : "Invalid payments: 10.");
            });
        
            text = text.replace("\r\n", "\n");
        
            String expectedOutput = """
                Valid payments: 10.
                """.replace("\r\n", "\n").replace("        ", "");
        
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testInvalidPaymentsLessThanFive(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                boolean result = Main.isValidPayments(4);
                System.out.println(result ? "Valid payments: 4." : "Invalid payments: 4.");
            });
        
            text = text.replace("\r\n", "\n");
        
            String expectedOutput = """
                Invalid payments: 4.
                """.replace("\r\n", "\n").replace("        ", "");
        
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testValidValueGreaterThan50000(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                boolean result = Main.isValidValue(50000.01);
                System.out.println(result ? "Valid value: 50000.01." : "Invalid value: 50000.01.");
            });
        
            text = text.replace("\r\n", "\n");
        
            String expectedOutput = """
                Valid value: 50000.01.
                """.replace("\r\n", "\n").replace("        ", "");
        
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testInvalidValueEqualTo50000(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                boolean result = Main.isValidValue(50000.00);
                System.out.println(result ? "Valid value: 50000.00." : "Invalid value: 50000.00.");
            });
        
            text = text.replace("\r\n", "\n");
        
            String expectedOutput = """
                Invalid value: 50000.00.
                """.replace("\r\n", "\n").replace("        ", "");
        
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testInvalidValueLessThan50000(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                boolean result = Main.isValidValue(30000.00);
                System.out.println(result ? "Valid value: 30000.00." : "Invalid value: 30000.00.");
            });
        
            text = text.replace("\r\n", "\n");
        
            String expectedOutput = """
                Invalid value: 30000.00.
                """.replace("\r\n", "\n").replace("        ", "");
        
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testIsAllDigitsWithOnlyDigits(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                java.lang.reflect.Method method = Main.class.getDeclaredMethod("isAllDigits", String.class);
                method.setAccessible(true);
                boolean result = (Boolean) method.invoke(null, "123456");
                System.out.println(result ? "All digits." : "Contains non-digit characters.");
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                All digits.
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testIsAllDigitsWithLetters(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                java.lang.reflect.Method method = Main.class.getDeclaredMethod("isAllDigits", String.class);
                method.setAccessible(true);
                boolean result = (Boolean) method.invoke(null, "123a456");
                System.out.println(result ? "All digits." : "Contains non-digit characters.");
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Contains non-digit characters.
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testIsAllDigitsWithEmptyString(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                java.lang.reflect.Method method = Main.class.getDeclaredMethod("isAllDigits", String.class);
                method.setAccessible(true);
                boolean result = (Boolean) method.invoke(null, "");
                System.out.println(result ? "Empty string is valid." : "Empty string is invalid.");
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Empty string is valid.
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testValidTimeBoundaries(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                System.out.println(Main.isValidDate("2023-01-01T00:00:00") ? "Valid time boundary: 00:00:00." : "Invalid time boundary: 00:00:00.");
                System.out.println(Main.isValidDate("2023-01-01T23:59:59") ? "Valid time boundary: 23:59:59." : "Invalid time boundary: 23:59:59.");
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Valid time boundary: 00:00:00.
                Valid time boundary: 23:59:59.
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testInvalidHourTooHigh(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                System.out.println(Main.isValidDate("2023-01-01T24:00:00") ? "Valid time with hour 24." : "Invalid time with hour 24.");
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Invalid time with hour 24.
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testInvalidMinuteTooHigh(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                System.out.println(Main.isValidDate("2023-01-01T12:60:00") ? "Valid time with minute 60." : "Invalid time with minute 60.");
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Invalid time with minute 60.
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testInvalidSecondTooHigh(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                System.out.println(Main.isValidDate("2023-01-01T12:00:60") ? "Valid time with second 60." : "Invalid time with second 60.");
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Invalid time with second 60.
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testAlignTextLeft(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                String result = Main.alignText("Hello", 10, "left");
                System.out.println("Aligned text (left): \"" + result + "\"");
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Aligned text (left): "Hello     "
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testAlignTextRight(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                String result = Main.alignText("Hello", 10, "right");
                System.out.println("Aligned text (right): \"" + result + "\"");
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Aligned text (right): "     Hello"
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testAlignTextCenter(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                String result = Main.alignText("Hello", 11, "center");
                System.out.println("Aligned text (center): \"" + result + "\"");
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Aligned text (center): "   Hello   "
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testAlignTextTextLongerThanWidth(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                String result = Main.alignText("HelloWorldTest", 10, "left");
                System.out.println("Aligned text (truncate): \"" + result + "\"");
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Aligned text (truncate): "HelloWorl."
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testAlignTextExactWidth(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                String result = Main.alignText("Hello", 5, "center");
                System.out.println("Aligned text (exact width): \"" + result + "\"");
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Aligned text (exact width): "Hello"
                """.replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testListMortgagesEmpty(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                Main.mortgages.clear();
                Main.listMortgages("bank");
            });

            text = text.replace("\r\n", "\n").trim();

            String expectedOutput = """
                No mortgages available.
                """.replace("\r\n", "\n").trim();

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testListMortgagesSortedByBank(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try { 
            String text = SystemLambda.tapSystemOut(() -> {
                Main.mortgages.clear();

                HashMap<String, Object> m1 = new HashMap<>();
                m1.put("bank", "Banc B");
                m1.put("name", "ClientB");
                m1.put("payments", 20);
                m1.put("value", 70000.00);
                m1.put("interest", 2.50);
                m1.put("total", 72000.00);
                m1.put("payment", 600.00);
                m1.put("modified", "2023-02-01T12:00:00");

                HashMap<String, Object> m2 = new HashMap<>();
                m2.put("bank", "Banc A");
                m2.put("name", "ClientA");
                m2.put("payments", 10);
                m2.put("value", 60000.00);
                m2.put("interest", 3.50);
                m2.put("total", 62000.00);
                m2.put("payment", 500.00);
                m2.put("modified", "2023-01-01T12:00:00");

                Main.mortgages.add(m1);
                Main.mortgages.add(m2);

                Main.listMortgages("bank");
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Mortgages list sorted by: "bank"
                |      Bank      |   Client   |Payments|  Value   | Interest |  Total   | Payment  |      Modified       |
                +----------------+------------+--------+----------+----------+----------+----------+---------------------+
                |Banc A          |ClientA     |   10   |  60000.00|      3.50|  62000.00|    500.00| 2023-01-01T12:00:00 |
                |Banc B          |ClientB     |   20   |  70000.00|      2.50|  72000.00|    600.00| 2023-02-01T12:00:00 |
                """.replace("\r\n", "\n");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>\n" + diff + "<<<<<<<<< Diff end <<<<<<<<<<<\n");

            obtainedPoints += testPoints;
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
    void testMainOutput(TestInfo testInfo) throws Exception {
        int testPoints = testPointsMap.getOrDefault(testInfo.getTestMethod().get().getName(), 1);

        try {
            String text = SystemLambda.tapSystemOut(() -> {
                String[] args = {};
                Main.main(args);
            });
            text = text.replace("\r\n", "\n");

            String expectedOutput = """
                Invalid client name: Eirik Felaktig2
                Invalid bank: Ayamatta!
                Invalid payments: 2
                Invalid value: 45000.00
                Invalid date: 2020-08-01T45:00:00
                Invalid modified date: 2025-02-29T12:00:00

                Mortgages list sorted by: "bank"
                |      Bank      |   Client   |Payments|  Value   | Interest |  Total   | Payment  |      Modified       |
                +----------------+------------+--------+----------+----------+----------+----------+---------------------+
                |Banc Sabadell   |Pau García  |  300   | 100000.00|      2.10| 126000.00|    420.00| 2024-02-29T10:00:00 |
                |Barclays        |Mohammed Kh.|  360   | 210000.00|      2.90| 290000.00|    805.56| 2021-08-01T12:00:00 |
                |Citibank        |John Smith  |  180   | 250000.00|      2.70| 297000.00|   1650.00| 2022-03-20T09:30:00 |
                |Deutsche Bank   |Amit Kumar  |  240   | 150000.00|      3.20| 180000.00|    750.00| 2022-12-01T00:00:00 |

                Mortgages list sorted by: "payments"
                |      Bank      |   Client   |Payments|  Value   | Interest |  Total   | Payment  |      Modified       |
                +----------------+------------+--------+----------+----------+----------+----------+---------------------+
                |Citibank        |John Smith  |  180   | 250000.00|      2.70| 297000.00|   1650.00| 2022-03-20T09:30:00 |
                |Deutsche Bank   |Amit Kumar  |  240   | 150000.00|      3.20| 180000.00|    750.00| 2022-12-01T00:00:00 |
                |Banc Sabadell   |Pau García  |  300   | 100000.00|      2.10| 126000.00|    420.00| 2024-02-29T10:00:00 |
                |Barclays        |Mohammed Kh.|  360   | 210000.00|      2.90| 290000.00|    805.56| 2021-08-01T12:00:00 |
                """.replace("\r\n", "\n");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
            assertTrue(diff.compareTo("identical") == 0, "Diff found:\n" + diff);

            obtainedPoints += testPoints;
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
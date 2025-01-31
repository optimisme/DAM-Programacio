package com.exercicis;

import com.exercici0305.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.Locale;

import com.github.stefanbirkner.systemlambda.SystemLambda;
import com.testStringUtils.TestStringUtils;

class TestExercici0305 {

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
    void testJugadorConstructorAndGetters(TestInfo testInfo) {
        try {
            Jugador jugador = new Jugador("Leo Messi", 35, "PSG");

            assertEquals("Leo Messi", jugador.getNom(), "El nom no és correcte");
            assertEquals(35, jugador.getEdat(), "L'edat no és correcta");
            assertEquals("PSG", jugador.getEquip(), "L'equip no és correcte");
        
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
    void testJugadorSetters(TestInfo testInfo) {
        try {
            Jugador jugador = new Jugador("Leo Messi", 35, "PSG");

            jugador.setNom("Cristiano Ronaldo");
            jugador.setEdat(38);
            jugador.setEquip("Al-Nassr");

            assertEquals("Cristiano Ronaldo", jugador.getNom(), "Error en setter de nom");
            assertEquals(38, jugador.getEdat(), "Error en setter d'edat");
            assertEquals("Al-Nassr", jugador.getEquip(), "Error en setter d'equip");
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
    void testJugadorToString(TestInfo testInfo) {
        try {
            Jugador jugador = new Jugador("Leo Messi", 35, "PSG");

            String expected = "Jugador[nom=Leo Messi, edat=35, equip=PSG]";
            assertEquals(expected, jugador.toString(), "Error en toString()");
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
    void testJugadorEntrenar(TestInfo testInfo) throws Exception {
        try {
            String text = SystemLambda.tapSystemOut(() -> {
                Jugador jugador = new Jugador("Leo Messi", 35, "PSG");
                jugador.entrenar();
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = "Entrenant com a jugador\n".replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
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
    void testJugadorCompetir(TestInfo testInfo) throws Exception {
        try {
            String text = SystemLambda.tapSystemOut(() -> {
                Jugador jugador = new Jugador("Leo Messi", 35, "PSG");
                jugador.competir();
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = "Competint com a jugador\n".replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
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
    void testArbitreConstructorAndGetters(TestInfo testInfo) {
        try {
            Arbitre arbitre = new Arbitre("Mateu Lahoz", 45, "FIFA");

            assertEquals("Mateu Lahoz", arbitre.getNom(), "El nom no és correcte");
            assertEquals(45, arbitre.getEdat(), "L'edat no és correcta");
            assertEquals("FIFA", arbitre.getNivell(), "El nivell no és correcte");

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
    void testArbitreSetters(TestInfo testInfo) {
        try {
            Arbitre arbitre = new Arbitre("Mateu Lahoz", 45, "FIFA");

            arbitre.setNom("Antonio Mateu");
            arbitre.setEdat(50);
            arbitre.setNivell("UEFA");

            assertEquals("Antonio Mateu", arbitre.getNom(), "Error en setter de nom");
            assertEquals(50, arbitre.getEdat(), "Error en setter d'edat");
            assertEquals("UEFA", arbitre.getNivell(), "Error en setter de nivell");

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
    void testArbitreToString(TestInfo testInfo) {
        try {
            Arbitre arbitre = new Arbitre("Mateu Lahoz", 45, "FIFA");

            String expected = "Arbitre[nom=Mateu Lahoz, edat=45, nivell=FIFA]";
            assertEquals(expected, arbitre.toString(), "Error en toString()");
            
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
    void testArbitreCompetir(TestInfo testInfo) throws Exception {
        try {
            String text = SystemLambda.tapSystemOut(() -> {
                Arbitre arbitre = new Arbitre("Mateu Lahoz", 45, "FIFA");
                arbitre.competir();
            });

            text = text.replace("\r\n", "\n");

            String expectedOutput = "Supervisant competició\n".replace("\r\n", "\n").replace("        ", "");

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            if (diff.compareTo("identical") != 0) {
                System.out.println("Received text: " + text);
            }
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
}

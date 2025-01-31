package com.exercicis;

import com.exercici0306.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.Locale;

import com.github.stefanbirkner.systemlambda.SystemLambda;
import com.testStringUtils.TestStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

class TestExercici0306 {

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
    void testCarregaGetters(TestInfo testInfo) {
        try {
            Carrega carrega = new Carrega("Fusta", 2500.5);

            assertEquals("Fusta", carrega.getDescripcio(), "La descripció no és correcta");
            assertEquals(2500.5, carrega.getPes(), "El pes no és correcte");

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
    void testCarregaSetters(TestInfo testInfo) {
        try {
            Carrega carrega = new Carrega("Fusta", 2500.5);

            carrega.setDescripcio("Metall");
            carrega.setPes(3200.75);

            assertEquals("Metall", carrega.getDescripcio(), "Error en setter de descripció");
            assertEquals(3200.75, carrega.getPes(), "Error en setter de pes");

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
    void testCarregaToString(TestInfo testInfo) {
        try {
            Carrega carrega = new Carrega("Fusta", 2500.5);

            String expected = "Carrega[descripcio=Fusta, pes=2500.5]";
            assertEquals(expected, carrega.toString(), "Error en toString()");

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
    void testCarregaPerillosaGetters(TestInfo testInfo) {
        try {
            CarregaPerillosa carrega = new CarregaPerillosa("Explosius", 500.0, 3);

            assertEquals("Explosius", carrega.getDescripcio(), "La descripció no és correcta");
            assertEquals(500.0, carrega.getPes(), "El pes no és correcte");
            assertEquals(3, carrega.getNivellPerillositat(), "El nivell de perillositat no és correcte");

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
    void testCarregaPerillosaSetters(TestInfo testInfo) {
        try {
            CarregaPerillosa carrega = new CarregaPerillosa("Explosius", 500.0, 3);

            carrega.setDescripcio("Materials radioactius");
            carrega.setPes(1200.5);
            carrega.setNivellPerillositat(5);

            assertEquals("Materials radioactius", carrega.getDescripcio(), "Error en setter de descripció");
            assertEquals(1200.5, carrega.getPes(), "Error en setter de pes");
            assertEquals(5, carrega.getNivellPerillositat(), "Error en setter de nivell de perillositat");

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
    void testCarregaPerillosaToString(TestInfo testInfo) {
        try {
            CarregaPerillosa carrega = new CarregaPerillosa("Explosius", 500.0, 3);

            String expected = "CarregaPerillosa[descripcio=Explosius, pes=500.0, nivellPerillositat=3]";
            assertEquals(expected, carrega.toString(), "Error en toString()");

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
    void testCarregaPerillosaInvalid(TestInfo testInfo) {
        try {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new CarregaPerillosa("Químics perillosos", 600.0, 6);
            });

            assertEquals("El nivell de perillositat ha de ser entre 0 i 5", exception.getMessage());

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
    void testVaixellConstructorAndGetters(TestInfo testInfo) {
        try {
            Vaixell vaixell = new Vaixell("Titanic", 50000.0);

            assertEquals("Titanic", vaixell.getNom(), "El nom no és correcte");
            assertEquals(50000.0, vaixell.getCapacitat(), "La capacitat no és correcta");
            assertTrue(vaixell.getCarregues().isEmpty(), "El vaixell hauria de començar sense càrregues");

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
    void testVaixellSetters(TestInfo testInfo) {
        try {
            Vaixell vaixell = new Vaixell("Titanic", 50000.0);

            vaixell.setNom("Queen Mary 2");
            vaixell.setCapacitat(60000.0);

            assertEquals("Queen Mary 2", vaixell.getNom(), "Error en setter de nom");
            assertEquals(60000.0, vaixell.getCapacitat(), "Error en setter de capacitat");

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
    void testVaixellAfegirCarrega(TestInfo testInfo) {
        try {
            Vaixell vaixell = new Vaixell("Titanic", 50000.0);
            Carrega carrega1 = new Carrega("Fusta", 2000.0);
            Carrega carrega2 = new Carrega("Metall", 5000.0);

            vaixell.afegirCarrega(carrega1);
            vaixell.afegirCarrega(carrega2);

            ArrayList<Carrega> carregues = vaixell.getCarregues();
            assertEquals(2, carregues.size(), "El nombre de càrregues no és correcte");
            assertEquals("Fusta", carregues.get(0).getDescripcio(), "La primera càrrega no és correcta");
            assertEquals("Metall", carregues.get(1).getDescripcio(), "La segona càrrega no és correcta");

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
    void testVaixellGetPesTotal(TestInfo testInfo) {
        try {
            Vaixell vaixell = new Vaixell("Titanic", 50000.0);
            vaixell.afegirCarrega(new Carrega("Fusta", 2000.0));
            vaixell.afegirCarrega(new Carrega("Metall", 5000.0));

            double expectedPesTotal = 2000.0 + 5000.0;
            assertEquals(expectedPesTotal, vaixell.getPesTotal(), "El pes total de les càrregues no és correcte");

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
    void testVaixellToString(TestInfo testInfo) {
        try {
            Vaixell vaixell = new Vaixell("Titanic", 50000.0);
            vaixell.afegirCarrega(new Carrega("Fusta", 2000.0));
            vaixell.afegirCarrega(new Carrega("Metall", 5000.0));

            String expected = "Vaixell[nom=Titanic, capacitat=50000.0, pesActual=7000.0]";
            assertEquals(expected, vaixell.toString(), "Error en toString()");

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
    void testVaixellMercaderiesGetters(TestInfo testInfo) {
        try {
            VaixellMercaderies vaixell = new VaixellMercaderies("Mercaderies1", 30000.0, "Espanya");

            assertEquals("Mercaderies1", vaixell.getNom(), "El nom no és correcte");
            assertEquals(30000.0, vaixell.getCapacitat(), "La capacitat no és correcta");
            assertEquals("Espanya", vaixell.getPaisRegistre(), "El país de registre no és correcte");

            System.out.println("Test passed, succeeded!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testVaixellMercaderiesNormatiu(TestInfo testInfo) {
        try {
            VaixellMercaderies vaixell = new VaixellMercaderies("Mercaderies1", 30000.0, "Espanya");
            vaixell.afegirCarrega(new Carrega("Fusta", 15000.0));

            assertTrue(vaixell.compleixNormativa(), "El vaixell hauria de complir la normativa");

            vaixell.afegirCarrega(new Carrega("Metall", 20000.0));
            assertFalse(vaixell.compleixNormativa(), "El vaixell no hauria de complir la normativa");

            System.out.println("Test passed, succeeded!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testVaixellPassatgersGetters(TestInfo testInfo) {
        try {
            VaixellPassatgers vaixell = new VaixellPassatgers("Passatgers1", 20000.0, 500);

            assertEquals("Passatgers1", vaixell.getNom(), "El nom no és correcte");
            assertEquals(20000.0, vaixell.getCapacitat(), "La capacitat no és correcta");
            assertEquals(500, vaixell.getMaxPassatgers(), "El màxim de passatgers no és correcte");

            System.out.println("Test passed, succeeded!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testVaixellPassatgersAfegir(TestInfo testInfo) {
        try {
            VaixellPassatgers vaixell = new VaixellPassatgers("Passatgers1", 20000.0, 3);

            vaixell.afegirPassatger();
            vaixell.afegirPassatger();

            assertEquals(2, vaixell.getNumPassatgers(), "El nombre de passatgers no és correcte");

            System.out.println("Test passed, succeeded!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testVaixellPassatgersNormatiu(TestInfo testInfo) {
        try {
            VaixellPassatgers vaixell = new VaixellPassatgers("Passatgers1", 20000.0, 3);
            vaixell.afegirPassatger();
            vaixell.afegirPassatger();

            assertTrue(vaixell.compleixNormativa(), "El vaixell hauria de complir la normativa");

            vaixell.afegirPassatger(); // Arriba al límit màxim
            assertTrue(vaixell.compleixNormativa(), "El vaixell hauria de complir la normativa exacta");

            // Ara intentem afegir un altre passatger i esperem una excepció
            Exception exception = assertThrows(IllegalStateException.class, () -> {
                vaixell.afegirPassatger();
            });

            assertEquals("No es poden afegir més passatgers", exception.getMessage(), "El missatge d'excepció no és correcte");

            System.out.println("Test passed, succeeded!");

        } catch (AssertionError e) {
            System.out.println("Test failed: " + testInfo.getDisplayName());
            System.out.println(e.getMessage());
        }
    }
}

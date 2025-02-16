package com.exercicis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;
import com.github.stefanbirkner.systemlambda.SystemLambda;
import com.testStringUtils.TestStringUtils;

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
}

package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.io.ByteArrayInputStream;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {
        String input = "15\n8\n"; // Simula l'entrada de l'usuari (15 i 8)
        String expectedOutput = "Escriu el primer número: Escriu el segon número: El resultat de calcular 15 - 8 és 7\n";

        String actualOutput = SystemLambda.tapSystemOut(() -> {
            System.setIn(new ByteArrayInputStream(input.getBytes())); // Simula l'entrada de l'usuari
            Main.main(new String[]{});
        });

        actualOutput = actualOutput.replace("\r\n", "\n"); // Normalitza les noves línies
        String diff = TestStringUtils.findFirstDifference(actualOutput, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }
}

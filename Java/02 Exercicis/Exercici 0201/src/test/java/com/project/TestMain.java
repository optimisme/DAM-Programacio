package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.io.ByteArrayInputStream;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {
        String input = "10\n"; // Simula l'entrada de l'usuari (10 anys)
        String expectedOutput = "Quina edat tens? Si fossis un gos, tindries 70 anys\n";

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

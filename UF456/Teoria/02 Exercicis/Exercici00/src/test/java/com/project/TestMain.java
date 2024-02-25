package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {
        String text = SystemLambda.tapSystemOut(() -> {
            // Executa el main per a provar la seva sortida
            String[] args = {}; // Passa els arguments necessaris si n'hi ha
            Main.main(args);
        });

        // Comprova que la sortida conté el text esperat
        String expectedOutput = "El resultat de la divisió és 21.015625\nEl resultat arrodonit de la divisió és 21,02";
        assertTrue(text.contains(expectedOutput));
    }
}

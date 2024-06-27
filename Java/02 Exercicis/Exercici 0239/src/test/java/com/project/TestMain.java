package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain {

    @Test
    public void testJocRocaPaperTisores() {
        Locale defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);

        try {
            StringBuilder inputBuilder = new StringBuilder();
            StringBuilder actualOutput = new StringBuilder();
            String[] userInputs = {"Roca", "Paper", "Tisores", "Roca", "Paper", "Roca", "Paper", "Tisores", "Roca", "Paper", "Roca", "Paper", "Tisores", "Roca", "Paper", "Sortir"};

            for (String userInput : userInputs) {
                inputBuilder.append(userInput).append("\n");
                String result = Main.processGame(userInput);
                actualOutput.append(result).append("\n");

                if (result.contains("Ha guanyat el jugador.") || result.contains("Ha guanyat l'ordinador.") || result.contains("L'usuari ha sortit")) {
                    break;
                }
            }

            String finalOutput = actualOutput.toString().replace("\r\n", "\n");
            assertTrue(finalOutput.contains("L'usuari ha sortit") || finalOutput.contains("Ha guanyat el jugador.") || finalOutput.contains("Ha guanyat l'ordinador."),
                "El programa ha de contenir un missatge de finalització adequat.");
            System.out.println(finalOutput);

            Pattern pattern = Pattern.compile("Puntuació: Jugador (\\d+) - Ordinador (\\d+)");
            Matcher matcher = pattern.matcher(finalOutput);
            while (matcher.find()) {
                int puntuacioJugador = Integer.parseInt(matcher.group(1));
                int puntuacioOrdinador = Integer.parseInt(matcher.group(2));
                assertTrue(puntuacioJugador <= 3 && puntuacioOrdinador <= 3, "Les puntuacions han de ser menors o iguals a 3.");
            }

        } finally {
            Locale.setDefault(defaultLocale);
        }
    }
}

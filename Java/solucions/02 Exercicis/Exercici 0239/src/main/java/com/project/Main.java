package com.project;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Random random = new Random();
    private static int puntuacioJugador = 0;
    private static int puntuacioOrdinador = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (puntuacioJugador < 3 && puntuacioOrdinador < 3) {
            System.out.print("Escriu la teva opció [Roca, Paper, Tisores, Sortir]: ");
            input = scanner.nextLine().trim();
            String result = processGame(input);
            System.out.println(result);
            if (input.equalsIgnoreCase("Sortir")) {
                break;
            }
        }
    }

    public static String processGame(String input) {
        if (input.equalsIgnoreCase("Sortir")) {
            return "L'usuari ha sortit";
        }

        String opcioOrdinador = getRandomOption();
        String result = handleGameLogic(input, opcioOrdinador);

        if (puntuacioJugador == 3) {
            result += " Ha guanyat el jugador.";
        } else if (puntuacioOrdinador == 3) {
            result += " Ha guanyat l'ordinador.";
        }
        return result;
    }

    private static String getRandomOption() {
        String[] opcions = {"Roca", "Paper", "Tisores"};
        return opcions[random.nextInt(opcions.length)];
    }

    private static String handleGameLogic(String opcioJugador, String opcioOrdinador) {
        if (opcioJugador.equalsIgnoreCase("Roca") ||
            opcioJugador.equalsIgnoreCase("Paper") ||
            opcioJugador.equalsIgnoreCase("Tisores")) {

            if (opcioJugador.equalsIgnoreCase(opcioOrdinador)) {
                return String.format(" - Jugador %s vs. Ordinador %s - Puntuació: Jugador %d - Ordinador %d",
                    opcioJugador, opcioOrdinador, puntuacioJugador, puntuacioOrdinador);
            } else if ((opcioJugador.equalsIgnoreCase("Roca") && opcioOrdinador.equals("Tisores")) ||
                       (opcioJugador.equalsIgnoreCase("Paper") && opcioOrdinador.equals("Roca")) ||
                       (opcioJugador.equalsIgnoreCase("Tisores") && opcioOrdinador.equals("Paper"))) {
                puntuacioJugador++;
            } else {
                puntuacioOrdinador++;
            }
            return String.format(" - Jugador %s vs. Ordinador %s - Puntuació: Jugador %d - Ordinador %d",
                opcioJugador, opcioOrdinador, puntuacioJugador, puntuacioOrdinador);
        } else {
            return "Opció no vàlida. Si us plau, tria entre Roca, Paper, Tisores o Sortir.";
        }
    }
}

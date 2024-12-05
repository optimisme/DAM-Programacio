package com.exercicis;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Locale;

public class Resolt0014 {

    public static String getMovePC() {
        String[] moves = {"PEDRA", "PAPER", "TISORES"};
        return moves[new Random().nextInt(moves.length)];
    }

    public static String getPlayerMove(Scanner scanner) {
        while (true) {
            System.out.print("Escriu PEDRA, PAPER, TISORES o SORTIR: ");
            String move = scanner.nextLine().toUpperCase();
            
            if (move.equals("SORTIR")) return null;
            if (move.equals("PEDRA") || move.equals("PAPER") || move.equals("TISORES")) {
                return move;
            }
        }
    }

    public static String getWinner(String playerMove, String pcMove) {
        if (playerMove.equals(pcMove)) return "DRAW";
        
        switch (playerMove) {
            case "PEDRA":
                return pcMove.equals("TISORES") ? "PLAYER" : "PC";
            case "PAPER":
                return pcMove.equals("PEDRA") ? "PLAYER" : "PC";
            case "TISORES":
                return pcMove.equals("PAPER") ? "PLAYER" : "PC";
            default:
                return "ERROR";
        }
    }

    public static String getScoreMessage(int playerScore, int pcScore) {
        return String.format("Marcador -> JUGADOR: %d - PC: %d", playerScore, pcScore);
    }

    public static String getWinnerMessage(boolean playerWon) {
        return playerWon ? "Felicitats! Has guanyat la partida!" : "Ho sento! Ha guanyat el PC!";
    }

    public static void updateStats(HashMap<String, Integer> stats, String move, boolean win) {
        // Incrementar comptador de moviment
        String countKey = move + "_COUNT";
        stats.put(countKey, stats.get(countKey) + 1);
        
        // Incrementar comptador de victòries si ha guanyat
        if (win) {
            String winKey = move + "_WINS";
            stats.put(winKey, stats.get(winKey) + 1);
        }
    }

    public static String getMessage(String winner, String playerMove, String pcMove) {
        if (winner.equals("DRAW")) {
            return "Empat! Els dos heu triat " + playerMove + "!";
        } else if (winner.equals("PLAYER")) {
            return "Molt bé! " + playerMove + " guanya a " + pcMove + "!";
        } else {
            return "Ho sento! " + pcMove + " guanya a " + playerMove + "!";
        }
    }

    public static void showStats(HashMap<String, Integer> stats) {
        // Calcular totals
        int totalGames = stats.get("PEDRA_COUNT") + stats.get("PAPER_COUNT") + stats.get("TISORES_COUNT");
        int totalWins = stats.get("PEDRA_WINS") + stats.get("PAPER_WINS") + stats.get("TISORES_WINS");
        
        // Trobar moviment més utilitzat
        String mostUsedMove = "PEDRA";
        int maxCount = stats.get("PEDRA_COUNT");
        
        if (stats.get("PAPER_COUNT") > maxCount) {
            mostUsedMove = "PAPER";
            maxCount = stats.get("PAPER_COUNT");
        }
        if (stats.get("TISORES_COUNT") > maxCount) {
            mostUsedMove = "TISORES";
            maxCount = stats.get("TISORES_COUNT");
        }
    
        // Trobar moviment més victoriós
        String bestMove = "PEDRA";
        double bestWinRate = stats.get("PEDRA_COUNT") > 0 ? 
            (double)stats.get("PEDRA_WINS") / stats.get("PEDRA_COUNT") * 100 : 0;
    
        double paperWinRate = stats.get("PAPER_COUNT") > 0 ? 
            (double)stats.get("PAPER_WINS") / stats.get("PAPER_COUNT") * 100 : 0;
        if (paperWinRate > bestWinRate) {
            bestMove = "PAPER";
            bestWinRate = paperWinRate;
        }
    
        double tisoresWinRate = stats.get("TISORES_COUNT") > 0 ? 
            (double)stats.get("TISORES_WINS") / stats.get("TISORES_COUNT") * 100 : 0;
        if (tisoresWinRate > bestWinRate) {
            bestMove = "TISORES";
            bestWinRate = tisoresWinRate;
        }
    
        // Mostrar estadístiques
        System.out.println("Estadístiques finals:");
        System.out.println("------------------");
        System.out.println("Total partides: " + totalGames);
        System.out.printf(Locale.US, "Victòries: %.1f%%\n", 
            totalGames > 0 ? (double)totalWins / totalGames * 100 : 0);
        System.out.println("Moviment més utilitzat: " + mostUsedMove + " (" + maxCount + " vegades)");
        System.out.printf(Locale.US, "Moviment més victoriós: %s (%d%% victòries)\n", 
            bestMove, Math.round(bestWinRate));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Definim l'scanner al principi
        try {
            // Inicialitzar estadístiques i marcador
            HashMap<String, Integer> stats = new HashMap<>();
            stats.put("PEDRA_COUNT", 0);
            stats.put("PAPER_COUNT", 0);
            stats.put("TISORES_COUNT", 0);
            stats.put("PEDRA_WINS", 0);
            stats.put("PAPER_WINS", 0);
            stats.put("TISORES_WINS", 0);

            int playerScore = 0;
            int pcScore = 0;

            System.out.println("Benvingut a Pedra, Paper, Tisores!");
            System.out.println("El primer en arribar a 3 victòries guanya!\n");

            while (playerScore < 3 && pcScore < 3) {
                String playerMove = getPlayerMove(scanner);  // Passem l'scanner com a paràmetre
                if (playerMove == null) break;  // L'usuari vol sortir

                String pcMove = getMovePC();
                System.out.println("PC tria: " + pcMove);

                String winner = getWinner(playerMove, pcMove);
                System.out.println(getMessage(winner, playerMove, pcMove));
                
                // Actualitzar marcador
                if (winner.equals("PLAYER")) playerScore++;
                else if (winner.equals("PC")) pcScore++;
                
                System.out.println(getScoreMessage(playerScore, pcScore));
                System.out.println();

                // Actualitzar estadístiques
                updateStats(stats, playerMove, winner.equals("PLAYER"));
            }

            // Mostrar missatge de victòria si no s'ha sortit abans
            if (playerScore >= 3 || pcScore >= 3) {
                System.out.println(getWinnerMessage(playerScore >= 3));
                System.out.println();
            }

            showStats(stats);
        } finally {
            scanner.close();  // Tanquem l'scanner al final
        }
    }
}
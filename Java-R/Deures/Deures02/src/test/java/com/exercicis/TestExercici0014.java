package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.exercicis.Exercici0014;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

class TestExercici0014 {

    @Test
    public void testGetPlayerMove() {
        // Test amb entrada vàlida
        Scanner scannerValid = new Scanner("PEDRA\n");
        assertEquals("PEDRA", Exercici0014.getPlayerMove(scannerValid));
        scannerValid.close();

        // Test amb sortida
        Scanner scannerExit = new Scanner("SORTIR\n");
        assertNull(Exercici0014.getPlayerMove(scannerExit));
        scannerExit.close();

        // Test amb entrada invàlida seguida de vàlida
        Scanner scannerInvalid = new Scanner("INVALID\nPAPER\n");
        assertEquals("PAPER", Exercici0014.getPlayerMove(scannerInvalid));
        scannerInvalid.close();
    }

    @Test
    public void testGetMovePC() {
        String move = Exercici0014.getMovePC();
        assertTrue(move.equals("PEDRA") || move.equals("PAPER") || move.equals("TISORES"),
            "El moviment ha de ser PEDRA, PAPER o TISORES, però és: " + move);
    }

    @Test
    public void testGetWinner() {
        assertEquals("PLAYER", Exercici0014.getWinner("PEDRA", "TISORES"), "PEDRA guanya a TISORES");
        assertEquals("PLAYER", Exercici0014.getWinner("PAPER", "PEDRA"), "PAPER guanya a PEDRA");
        assertEquals("PLAYER", Exercici0014.getWinner("TISORES", "PAPER"), "TISORES guanya a PAPER");
        
        assertEquals("PC", Exercici0014.getWinner("TISORES", "PEDRA"), "PEDRA guanya a TISORES");
        assertEquals("PC", Exercici0014.getWinner("PEDRA", "PAPER"), "PAPER guanya a PEDRA");
        assertEquals("PC", Exercici0014.getWinner("PAPER", "TISORES"), "TISORES guanya a PAPER");
        
        assertEquals("DRAW", Exercici0014.getWinner("PEDRA", "PEDRA"), "PEDRA contra PEDRA és empat");
        assertEquals("DRAW", Exercici0014.getWinner("PAPER", "PAPER"), "PAPER contra PAPER és empat");
        assertEquals("DRAW", Exercici0014.getWinner("TISORES", "TISORES"), "TISORES contra TISORES és empat");
    }

    @Test
    public void testUpdateStats() {
        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("PEDRA_COUNT", 0);
        stats.put("PAPER_COUNT", 0);
        stats.put("TISORES_COUNT", 0);
        stats.put("PEDRA_WINS", 0);
        stats.put("PAPER_WINS", 0);
        stats.put("TISORES_WINS", 0);

        Exercici0014.updateStats(stats, "PEDRA", true);
        assertEquals(1, (int)stats.get("PEDRA_COUNT"), "PEDRA_COUNT hauria de ser 1");
        assertEquals(1, (int)stats.get("PEDRA_WINS"), "PEDRA_WINS hauria de ser 1");

        Exercici0014.updateStats(stats, "PAPER", false);
        assertEquals(1, (int)stats.get("PAPER_COUNT"), "PAPER_COUNT hauria de ser 1");
        assertEquals(0, (int)stats.get("PAPER_WINS"), "PAPER_WINS hauria de ser 0");
    }

    @Test
    public void testGetMessage() {
        String msgWinPC = Exercici0014.getMessage("PC", "PEDRA", "PAPER");
        String expectedPC = "Ho sento! PAPER guanya a PEDRA!";
        
        String diff = TestStringUtils.findFirstDifference(msgWinPC, expectedPC);
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");

        String msgWinPlayer = Exercici0014.getMessage("PLAYER", "TISORES", "PAPER");
        String expectedPlayer = "Molt bé! TISORES guanya a PAPER!";
        
        diff = TestStringUtils.findFirstDifference(msgWinPlayer, expectedPlayer);
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");

        String msgDraw = Exercici0014.getMessage("DRAW", "PAPER", "PAPER");
        String expectedDraw = "Empat! Els dos heu triat PAPER!";
        
        diff = TestStringUtils.findFirstDifference(msgDraw, expectedDraw);
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
    }

    @Test
    public void testShowStats() throws Exception {
        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("PEDRA_COUNT", 2);
        stats.put("PAPER_COUNT", 1);
        stats.put("TISORES_COUNT", 1);
        stats.put("PEDRA_WINS", 1);
        stats.put("PAPER_WINS", 0);
        stats.put("TISORES_WINS", 1);

        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);
            
            String output = SystemLambda.tapSystemOut(() -> {
                Exercici0014.showStats(stats);
            });

            String expected = "Estadístiques finals:\n" +
                            "------------------\n" +
                            "Total partides: 4\n" +
                            "Victòries: 50.0%\n" +
                            "Moviment més utilitzat: PEDRA (2 vegades)\n" +
                            "Moviment més victoriós: TISORES (100% victòries)\n";

            String diff = TestStringUtils.findFirstDifference(output, expected);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");

        } finally {
            Locale.setDefault(defaultLocale);
        }
    }
}
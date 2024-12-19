package com.exercicis;

import com.testStringUtils.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

class TestExercici1 {

    @Test
    void testPrintEmptyBoard() throws Exception {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Capturem la sortida
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        // Executem el mètode
        Exercici1.printBoard();
        
        // Restaurem la sortida original
        System.setOut(originalOut);
        
        // Definim la sortida esperada
        String expectedOutput = 
            "+----+----+----+----+\n" +
            "|    |    |    |    |\n" +
            "+----+----+----+----+\n" +
            "|    |    |    |    |\n" +
            "+----+----+----+----+\n" +
            "|    |    |    |    |\n" +
            "+----+----+----+----+\n" +
            "|    |    |    |    |\n" +
            "+----+----+----+----+\n";
        
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testPrintBoardWithSingleNumber() throws Exception {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        Exercici1.board[0][0] = 2;
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        Exercici1.printBoard();
        
        System.setOut(originalOut);
        
        String expectedOutput = 
            "+----+----+----+----+\n" +
            "|   2|    |    |    |\n" +
            "+----+----+----+----+\n" +
            "|    |    |    |    |\n" +
            "+----+----+----+----+\n" +
            "|    |    |    |    |\n" +
            "+----+----+----+----+\n" +
            "|    |    |    |    |\n" +
            "+----+----+----+----+\n";
        
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testPrintBoardWithMultipleNumbers() throws Exception {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        Exercici1.board[0][0] = 2;
        Exercici1.board[0][1] = 4;
        Exercici1.board[1][1] = 8;
        Exercici1.board[2][2] = 16;
        Exercici1.board[3][3] = 32;
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        Exercici1.printBoard();
        
        System.setOut(originalOut);
        
        String expectedOutput = 
            "+----+----+----+----+\n" +
            "|   2|   4|    |    |\n" +
            "+----+----+----+----+\n" +
            "|    |   8|    |    |\n" +
            "+----+----+----+----+\n" +
            "|    |    |  16|    |\n" +
            "+----+----+----+----+\n" +
            "|    |    |    |  32|\n" +
            "+----+----+----+----+\n";
        
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testPrintBoardWithFullRow() throws Exception {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        Exercici1.board[0][0] = 2;
        Exercici1.board[0][1] = 4;
        Exercici1.board[0][2] = 8;
        Exercici1.board[0][3] = 16;
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        Exercici1.printBoard();
        
        System.setOut(originalOut);
        
        String expectedOutput = 
            "+----+----+----+----+\n" +
            "|   2|   4|   8|  16|\n" +
            "+----+----+----+----+\n" +
            "|    |    |    |    |\n" +
            "+----+----+----+----+\n" +
            "|    |    |    |    |\n" +
            "+----+----+----+----+\n" +
            "|    |    |    |    |\n" +
            "+----+----+----+----+\n";
        
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testPrintBoardWithLargeNumbers() throws Exception {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        Exercici1.board[0][0] = 128;
        Exercici1.board[0][1] = 256;
        Exercici1.board[0][2] = 512;
        Exercici1.board[0][3] = 1024;
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        Exercici1.printBoard();
        
        System.setOut(originalOut);
        
        String expectedOutput = 
            "+----+----+----+----+\n" +
            "| 128| 256| 512|1024|\n" +
            "+----+----+----+----+\n" +
            "|    |    |    |    |\n" +
            "+----+----+----+----+\n" +
            "|    |    |    |    |\n" +
            "+----+----+----+----+\n" +
            "|    |    |    |    |\n" +
            "+----+----+----+----+\n";
        
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testSpawnAddToEmptyBoard() {

        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];

        // Executem la funció per afegir una fitxa
        Exercici1.spawnTile();

        // Comprovar que només hi ha un element no zero
        int nonZeroCount = 0;
        int tileValue = 0;

        for (int[] row : Exercici1.board) {
            for (int cell : row) {
                if (cell != 0) {
                    nonZeroCount++;
                    tileValue = cell;
                }
            }
        }

        assertEquals(1, nonZeroCount, "Hi ha d'haver exactament una fitxa al taulell");
        assertTrue(tileValue == 2 || tileValue == 4, "La fitxa ha de tenir valor 2 o 4");
    }

    @Test
    void testSpawnOnPartiallyFilled() {

        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];

        // Afegim una fitxa manualment
        Exercici1.board[0][0] = 2;

        // Executem la funció
        Exercici1.spawnTile();

        // Comprovar que ara hi ha exactament dues fitxes al taulell
        int nonZeroCount = 0;

        for (int[] row : Exercici1.board) {
            for (int cell : row) {
                if (cell != 0) {
                    nonZeroCount++;
                }
            }
        }

        assertEquals(2, nonZeroCount, "Hi ha d'haver exactament dues fitxes al taulell");
    }

    @Test
    void testSpawnDoNotOverwriteExisting() {

        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];

        // Omplim manualment part del taulell
        Exercici1.board[0][0] = 2;
        Exercici1.board[1][1] = 4;

        // Guardem les posicions no buides abans d'executar la funció
        Set<String> occupiedPositions = new HashSet<>();
        for (int i = 0; i < Exercici1.SIZE; i++) {
            for (int j = 0; j < Exercici1.SIZE; j++) {
                if (Exercici1.board[i][j] != 0) {
                    occupiedPositions.add(i + "," + j);
                }
            }
        }

        // Executem la funció
        Exercici1.spawnTile();

        // Comprovem que les posicions no buides no han canviat
        for (String pos : occupiedPositions) {
            String[] parts = pos.split(",");
            int i = Integer.parseInt(parts[0]);
            int j = Integer.parseInt(parts[1]);
            assertTrue(Exercici1.board[i][j] != 0, "Una posició ja ocupada ha estat sobreescrita");
        }
    }

    @Test
    void testMoveLeftSimpleMove() {

        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];

        // Configurem una fila amb espais buits entre números
        Exercici1.board[0] = new int[]{0, 2, 0, 4};
        Exercici1.moveLeft();
        // Comprovem que els números s'han mogut correctament cap a l'esquerra
        assertArrayEquals(new int[]{2, 4, 0, 0}, Exercici1.board[0]);
    }

    @Test
    void testMoveLeftWithMerge() {

        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];

        // Configurem una fila amb números iguals adjacents
        Exercici1.board[0] = new int[]{2, 2, 4, 4};
        Exercici1.moveLeft();
        // Comprovem que els números iguals s'han combinat correctament
        assertArrayEquals(new int[]{4, 8, 0, 0}, Exercici1.board[0]);
    }

    @Test
    void testMoveLeftNoMergeWithEmptySpaces() {

        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];

        // Configurem una fila amb números iguals separats per espais buits
        Exercici1.board[0] = new int[]{2, 0, 2, 4};
        Exercici1.moveLeft();
        // Comprovem que els números no es combinen si no són adjacents
        assertArrayEquals(new int[]{4, 4, 0, 0}, Exercici1.board[0]);
    }

    @Test
    void testMoveLeftEmptyRow() {

        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];

        // Configurem una fila buida
        Exercici1.board[0] = new int[]{0, 0, 0, 0};
        Exercici1.moveLeft();
        // Comprovem que la fila roman buida
        assertArrayEquals(new int[]{0, 0, 0, 0}, Exercici1.board[0]);
    }

    @Test
    void testMoveLeftFullRowWithoutMerge() {

        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];

        // Configurem una fila plena amb números que no es poden combinar
        Exercici1.board[0] = new int[]{2, 4, 8, 16};
        Exercici1.moveLeft();
        // Comprovem que els números romanen a la mateixa posició
        assertArrayEquals(new int[]{2, 4, 8, 16}, Exercici1.board[0]);
    }

    @Test
    void testMoveRightSimpleMove() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem una fila amb espais buits entre números
        Exercici1.board[0] = new int[]{2, 0, 4, 0};
        
        Exercici1.moveRight();
        
        // Comprovem que els números s'han mogut correctament cap a la dreta
        assertArrayEquals(new int[]{0, 0, 2, 4}, Exercici1.board[0]);
    }

    @Test
    void testMoveRightWithMerge() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem una fila amb números iguals adjacents
        Exercici1.board[0] = new int[]{2, 2, 4, 4};
        
        Exercici1.moveRight();
        
        // Comprovem que els números iguals s'han combinat correctament
        assertArrayEquals(new int[]{0, 0, 4, 8}, Exercici1.board[0]);
    }

    @Test
    void testMoveRightNoMergeWithEmptySpaces() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem una fila amb números iguals separats per espais buits
        Exercici1.board[0] = new int[]{2, 0, 2, 4};
        
        Exercici1.moveRight();
        
        // Comprovem que els números s'han combinat correctament després de moure's
        assertArrayEquals(new int[]{0, 0, 4, 4}, Exercici1.board[0]);
    }

    @Test
    void testMoveRightEmptyRow() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem una fila buida
        Exercici1.board[0] = new int[]{0, 0, 0, 0};
        
        Exercici1.moveRight();
        
        // Comprovem que la fila roman buida
        assertArrayEquals(new int[]{0, 0, 0, 0}, Exercici1.board[0]);
    }

    @Test
    void testMoveRightFullRowWithoutMerge() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem una fila plena amb números que no es poden combinar
        Exercici1.board[0] = new int[]{2, 4, 8, 16};
        
        Exercici1.moveRight();
        
        // Comprovem que els números romanen a la mateixa posició
        assertArrayEquals(new int[]{2, 4, 8, 16}, Exercici1.board[0]);
    }

    @Test
    void testMoveRightMultipleRows() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem múltiples files amb diferents patrons
        // Fila 0: merge simple
        Exercici1.board[0] = new int[]{0, 2, 2, 0};
        
        // Fila 1: sense canvis
        Exercici1.board[1] = new int[]{0, 4, 8, 2};
        
        // Fila 2: moviment simple
        Exercici1.board[2] = new int[]{4, 0, 0, 0};
        
        // Fila 3: doble merge
        Exercici1.board[3] = new int[]{2, 2, 2, 2};
        
        Exercici1.moveRight();
        
        // Verificar totes les files
        assertArrayEquals(new int[]{0, 0, 0, 4}, Exercici1.board[0]); // Merge 2+2
        assertArrayEquals(new int[]{0, 4, 8, 2}, Exercici1.board[1]); // Sense canvis
        assertArrayEquals(new int[]{0, 0, 0, 4}, Exercici1.board[2]); // Moviment simple
        assertArrayEquals(new int[]{0, 0, 4, 4}, Exercici1.board[3]); // Doble merge 2+2
    }

    @Test
    void testMoveRightConsecutiveMerges() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Test per verificar que els merges es fan correctament d'esquerra a dreta
        // i que no es fan múltiples merges en cadena
        Exercici1.board[0] = new int[]{2, 2, 4, 4};
        Exercici1.board[1] = new int[]{4, 4, 4, 4};
        
        Exercici1.moveRight();
        
        // La primera fila hauria de mergear 2+2=4 i 4+4=8
        assertArrayEquals(new int[]{0, 0, 4, 8}, Exercici1.board[0]);
        
        // La segona fila hauria de mergear 4+4=8 i 4+4=8
        assertArrayEquals(new int[]{0, 0, 8, 8}, Exercici1.board[1]);
    }

    @Test
    void testMoveUpSimpleMove() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem una columna amb espais buits entre números
        Exercici1.board[1][0] = 2;
        Exercici1.board[3][0] = 4;
        
        Exercici1.moveUp();
        
        // Comprovem que els números s'han mogut correctament cap amunt
        assertEquals(2, Exercici1.board[0][0]);
        assertEquals(4, Exercici1.board[1][0]);
        assertEquals(0, Exercici1.board[2][0]);
        assertEquals(0, Exercici1.board[3][0]);
    }

    @Test
    void testMoveUpWithMerge() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem una columna amb números iguals adjacents
        Exercici1.board[0][0] = 2;
        Exercici1.board[1][0] = 2;
        Exercici1.board[2][0] = 4;
        Exercici1.board[3][0] = 4;
        
        Exercici1.moveUp();
        
        // Comprovem que els números iguals s'han combinat correctament
        assertEquals(4, Exercici1.board[0][0]);
        assertEquals(8, Exercici1.board[1][0]);
        assertEquals(0, Exercici1.board[2][0]);
        assertEquals(0, Exercici1.board[3][0]);
    }

    @Test
    void testMoveUpNoMergeWithEmptySpaces() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem una columna amb números iguals separats per espais buits
        Exercici1.board[0][0] = 2;
        Exercici1.board[2][0] = 2;
        Exercici1.board[3][0] = 4;
        
        Exercici1.moveUp();
        
        // Comprovem que els números s'han combinat correctament després de moure's
        assertEquals(4, Exercici1.board[0][0]);
        assertEquals(4, Exercici1.board[1][0]);
        assertEquals(0, Exercici1.board[2][0]);
        assertEquals(0, Exercici1.board[3][0]);
    }

    @Test
    void testMoveUpEmptyColumn() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem una columna buida (ja està inicialitzada a 0)
        Exercici1.moveUp();
        
        // Comprovem que la columna roman buida
        for (int row = 0; row < Exercici1.SIZE; row++) {
            assertEquals(0, Exercici1.board[row][0]);
        }
    }

    @Test
    void testMoveUpFullColumnWithoutMerge() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem una columna plena amb números que no es poden combinar
        Exercici1.board[0][0] = 2;
        Exercici1.board[1][0] = 4;
        Exercici1.board[2][0] = 8;
        Exercici1.board[3][0] = 16;
        
        Exercici1.moveUp();
        
        // Comprovem que els números romanen a la mateixa posició
        assertEquals(2, Exercici1.board[0][0]);
        assertEquals(4, Exercici1.board[1][0]);
        assertEquals(8, Exercici1.board[2][0]);
        assertEquals(16, Exercici1.board[3][0]);
    }

    @Test
    void testMoveUpMultipleColumns() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem múltiples columnes amb diferents patrons
        // Columna 0: merge simple
        Exercici1.board[1][0] = 2;
        Exercici1.board[2][0] = 2;
        
        // Columna 1: sense canvis
        Exercici1.board[0][1] = 4;
        Exercici1.board[1][1] = 8;
        
        // Columna 2: moviment simple
        Exercici1.board[2][2] = 4;
        
        // Columna 3: doble merge
        Exercici1.board[0][3] = 2;
        Exercici1.board[1][3] = 2;
        Exercici1.board[2][3] = 2;
        Exercici1.board[3][3] = 2;
        
        Exercici1.moveUp();
        
        // Verificar columna 0
        assertEquals(4, Exercici1.board[0][0]);
        assertEquals(0, Exercici1.board[1][0]);
        assertEquals(0, Exercici1.board[2][0]);
        assertEquals(0, Exercici1.board[3][0]);
        
        // Verificar columna 1
        assertEquals(4, Exercici1.board[0][1]);
        assertEquals(8, Exercici1.board[1][1]);
        assertEquals(0, Exercici1.board[2][1]);
        assertEquals(0, Exercici1.board[3][1]);
        
        // Verificar columna 2
        assertEquals(4, Exercici1.board[0][2]);
        assertEquals(0, Exercici1.board[1][2]);
        assertEquals(0, Exercici1.board[2][2]);
        assertEquals(0, Exercici1.board[3][2]);
        
        // Verificar columna 3
        assertEquals(4, Exercici1.board[0][3]);
        assertEquals(4, Exercici1.board[1][3]);
        assertEquals(0, Exercici1.board[2][3]);
        assertEquals(0, Exercici1.board[3][3]);
    }

    @Test
    void testMoveDownSimpleMove() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem una columna amb espais buits entre números
        Exercici1.board[0][0] = 2;
        Exercici1.board[2][0] = 4;
        
        Exercici1.moveDown();
        
        // Comprovem que els números s'han mogut correctament cap avall
        assertEquals(0, Exercici1.board[0][0]);
        assertEquals(0, Exercici1.board[1][0]);
        assertEquals(2, Exercici1.board[2][0]);
        assertEquals(4, Exercici1.board[3][0]);
    }

    @Test
    void testMoveDownWithMerge() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem una columna amb números iguals adjacents
        Exercici1.board[0][0] = 2;
        Exercici1.board[1][0] = 2;
        Exercici1.board[2][0] = 4;
        Exercici1.board[3][0] = 4;
        
        Exercici1.moveDown();
        
        // Comprovem que els números iguals s'han combinat correctament
        assertEquals(0, Exercici1.board[0][0]);
        assertEquals(0, Exercici1.board[1][0]);
        assertEquals(4, Exercici1.board[2][0]);
        assertEquals(8, Exercici1.board[3][0]);
    }

    @Test
    void testMoveDownNoMergeWithEmptySpaces() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem una columna amb números iguals separats per espais buits
        Exercici1.board[0][0] = 2;
        Exercici1.board[2][0] = 2;
        Exercici1.board[3][0] = 4;
        
        Exercici1.moveDown();
        
        // Comprovem que els números s'han combinat correctament després de moure's
        assertEquals(0, Exercici1.board[0][0]);
        assertEquals(0, Exercici1.board[1][0]);
        assertEquals(4, Exercici1.board[2][0]);
        assertEquals(4, Exercici1.board[3][0]);
    }

    @Test
    void testMoveDownEmptyColumn() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem una columna buida (ja està inicialitzada a 0)
        Exercici1.moveDown();
        
        // Comprovem que la columna roman buida
        for (int row = 0; row < Exercici1.SIZE; row++) {
            assertEquals(0, Exercici1.board[row][0]);
        }
    }

    @Test
    void testMoveDownFullColumnWithoutMerge() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem una columna plena amb números que no es poden combinar
        Exercici1.board[0][0] = 2;
        Exercici1.board[1][0] = 4;
        Exercici1.board[2][0] = 8;
        Exercici1.board[3][0] = 16;
        
        Exercici1.moveDown();
        
        // Comprovem que els números romanen a la mateixa posició
        assertEquals(2, Exercici1.board[0][0]);
        assertEquals(4, Exercici1.board[1][0]);
        assertEquals(8, Exercici1.board[2][0]);
        assertEquals(16, Exercici1.board[3][0]);
    }

    @Test
    void testMoveDownMultipleColumns() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Configurem múltiples columnes amb diferents patrons
        // Columna 0: merge simple
        Exercici1.board[0][0] = 2;
        Exercici1.board[1][0] = 2;
        
        // Columna 1: sense canvis
        Exercici1.board[2][1] = 4;
        Exercici1.board[3][1] = 8;
        
        // Columna 2: moviment simple
        Exercici1.board[0][2] = 4;
        
        // Columna 3: doble merge
        Exercici1.board[0][3] = 2;
        Exercici1.board[1][3] = 2;
        Exercici1.board[2][3] = 2;
        Exercici1.board[3][3] = 2;
        
        Exercici1.moveDown();
        
        // Verificar columna 0
        assertEquals(0, Exercici1.board[0][0]);
        assertEquals(0, Exercici1.board[1][0]);
        assertEquals(0, Exercici1.board[2][0]);
        assertEquals(4, Exercici1.board[3][0]);
        
        // Verificar columna 1
        assertEquals(0, Exercici1.board[0][1]);
        assertEquals(0, Exercici1.board[1][1]);
        assertEquals(4, Exercici1.board[2][1]);
        assertEquals(8, Exercici1.board[3][1]);
        
        // Verificar columna 2
        assertEquals(0, Exercici1.board[0][2]);
        assertEquals(0, Exercici1.board[1][2]);
        assertEquals(0, Exercici1.board[2][2]);
        assertEquals(4, Exercici1.board[3][2]);
        
        // Verificar columna 3
        assertEquals(0, Exercici1.board[0][3]);
        assertEquals(0, Exercici1.board[1][3]);
        assertEquals(4, Exercici1.board[2][3]);
        assertEquals(4, Exercici1.board[3][3]);
    }

    @Test
    void testMoveDownConsecutiveMerges() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Test per verificar que els merges es fan correctament de dalt a baix
        // i que no es fan múltiples merges en cadena
        // Columna 0: 2,2,4,4 hauria de resultar en 0,0,4,8
        Exercici1.board[0][0] = 2;
        Exercici1.board[1][0] = 2;
        Exercici1.board[2][0] = 4;
        Exercici1.board[3][0] = 4;
        
        // Columna 1: 4,4,4,4 hauria de resultar en 0,0,8,8
        Exercici1.board[0][1] = 4;
        Exercici1.board[1][1] = 4;
        Exercici1.board[2][1] = 4;
        Exercici1.board[3][1] = 4;
        
        Exercici1.moveDown();
        
        // Verificar columna 0
        assertEquals(0, Exercici1.board[0][0]);
        assertEquals(0, Exercici1.board[1][0]);
        assertEquals(4, Exercici1.board[2][0]);
        assertEquals(8, Exercici1.board[3][0]);
        
        // Verificar columna 1
        assertEquals(0, Exercici1.board[0][1]);
        assertEquals(0, Exercici1.board[1][1]);
        assertEquals(8, Exercici1.board[2][1]);
        assertEquals(8, Exercici1.board[3][1]);
    }

    @Test
    void testGameWin() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Col·loquem un 128 en una posició qualsevol
        Exercici1.board[2][1] = 128;
        
        assertEquals("win", Exercici1.isGameFinished());
    }

    @Test
    void testGameContinueWithEmptyCell() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Omplim el taulell amb números petits diferents deixant una casella buida
        int[] values = {2, 4, 8, 16, 32, 64};
        int valueIndex = 0;
        for (int i = 0; i < Exercici1.SIZE; i++) {
            for (int j = 0; j < Exercici1.SIZE; j++) {
                if (i != 2 || j != 2) { // Deixem una casella buida a (2,2)
                    Exercici1.board[i][j] = values[valueIndex % values.length];
                    valueIndex++;
                }
            }
        }
        
        assertEquals("continue", Exercici1.isGameFinished());
    }

    @Test
    void testGameContinueWithAdjacentHoriz() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Omplim el taulell amb números diferents
        int value = 2;
        for (int i = 0; i < Exercici1.SIZE; i++) {
            for (int j = 0; j < Exercici1.SIZE; j++) {
                Exercici1.board[i][j] = value;
                value *= 2;
            }
        }
        
        // Col·loquem dos números iguals adjacents horitzontalment
        Exercici1.board[1][1] = 4;
        Exercici1.board[1][2] = 4;
        
        assertEquals("continue", Exercici1.isGameFinished());
    }

    @Test
    void testGameContinueWithAdjacentVert() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
    
        // Omplim el taulell amb números petits alternats
        for (int i = 0; i < Exercici1.SIZE; i++) {
            for (int j = 0; j < Exercici1.SIZE; j++) {
                Exercici1.board[i][j] = ((i + j) % 2 == 0) ? 2 : 8;
            }
        }
        
        // Col·loquem dos números iguals adjacents verticalment
        Exercici1.board[1][1] = 4;
        Exercici1.board[2][1] = 4;
        
        assertEquals("continue", Exercici1.isGameFinished());
    }

    @Test
    void testGameLost() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Omplim el taulell amb números alternats que no es poden combinar
        for (int i = 0; i < Exercici1.SIZE; i++) {
            for (int j = 0; j < Exercici1.SIZE; j++) {
                if ((i + j) % 2 == 0) {
                    Exercici1.board[i][j] = 2;
                } else {
                    Exercici1.board[i][j] = 4;
                }
            }
        }
        
        assertEquals("lost", Exercici1.isGameFinished());
    }

    @Test
    void testGameContinueWithMultipleConditions() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Creem un taulell amb múltiples condicions per continuar:
        // - Una casella buida
        // - Parells de números iguals
        // - Un número proper a guanyar
        
        Exercici1.board[0][0] = 64;
        Exercici1.board[0][1] = 64;  // Parella horitzontal
        Exercici1.board[0][2] = 32;
        Exercici1.board[0][3] = 16;
        
        Exercici1.board[1][0] = 8;
        Exercici1.board[1][1] = 8;   // Parella horitzontal
        Exercici1.board[1][2] = 4;
        Exercici1.board[1][3] = 4;   // Parella horitzontal
        
        Exercici1.board[2][0] = 2;
        Exercici1.board[2][1] = 0;   // Casella buida
        Exercici1.board[2][2] = 2;
        Exercici1.board[2][3] = 2;   // Parella horitzontal
        
        Exercici1.board[3][0] = 4;
        Exercici1.board[3][1] = 4;   // Parella horitzontal
        Exercici1.board[3][2] = 8;
        Exercici1.board[3][3] = 8;   // Parella horitzontal
        
        assertEquals("continue", Exercici1.isGameFinished());
    }

    @Test
    void testGameWinWithMultipleConditions() {
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        
        // Creem un taulell que té tant una condició de victòria (128)
        // com condicions per continuar (caselles buides i números iguals)
        
        Exercici1.board[0][0] = 128; // Condició de victòria
        Exercici1.board[0][1] = 2;
        Exercici1.board[0][2] = 2;   // Parella que es pot combinar
        Exercici1.board[0][3] = 0;   // Casella buida
        
        assertEquals("win", Exercici1.isGameFinished());
    }

    @Test
    void testPlayExitGame() throws Exception {
        // Preparar l'entrada simulada
        String input = "exit\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        
        // Capturar la sortida
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        // Executar el joc
        Exercici1.play(scanner);
        
        // Restaurar la sortida original
        System.setOut(originalOut);
        
        // Verificar que el missatge de sortida apareix
        String output = outputStream.toString();
        assertTrue(output.contains("Exit game ..."));
    }

    @Test
    void testPlayInvalidMove() throws Exception {
        // Simular una entrada invàlida seguida de sortida
        String input = "invalid\nexit\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        Exercici1.play(scanner);
        
        System.setOut(originalOut);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Invalid move!"));
    }

    @Test
    void testPlayValidMoves() throws Exception {
        // Simular una seqüència de moviments vàlids
        String input = "left\nright\nup\ndown\nexit\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        Exercici1.play(scanner);
        
        System.setOut(originalOut);
        
        String output = outputStream.toString();
        // Verificar que es mostra el prompt després de cada moviment
        assertTrue(output.contains("Enter move (left, up, right, down, exit):"));
    }

    @Test
    void testPlayShortCommands() throws Exception {
        // Provar les versions curtes dels comandaments
        String input = "l\nr\nu\nd\nexit\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        Exercici1.play(scanner);
        
        System.setOut(originalOut);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Enter move"));
        assertFalse(output.contains("Invalid move!"));
    }

    @Test
    void testPlayWinCondition() throws Exception {
        // Preparar un taulell proper a la victòria
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        Exercici1.board[0][0] = 64;
        Exercici1.board[0][1] = 64;
        
        // Un moviment que provocarà la victòria
        String input = "left\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        Exercici1.play(scanner);
        
        System.setOut(originalOut);
        
        String output = outputStream.toString();
        assertTrue(output.contains("You win, congrats!"));
    }

    @Test
    void testPlayLoseCondition() throws Exception {
        // Preparar un taulell sense moviments possibles
        Exercici1.board = new int[Exercici1.SIZE][Exercici1.SIZE];
        for(int i = 0; i < Exercici1.SIZE; i++) {
            for(int j = 0; j < Exercici1.SIZE; j++) {
                if((i + j) % 2 == 0) {
                    Exercici1.board[i][j] = 2;
                } else {
                    Exercici1.board[i][j] = 4;
                }
            }
        }
        
        String input = "left\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        Exercici1.play(scanner);
        
        System.setOut(originalOut);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Game Over, you are a loser!"));
    }

    @Test
    void testPlayMixedCaseCommands() throws Exception {
        // Provar comandaments amb majúscules i minúscules barrejades
        String input = "LEFT\nRiGhT\nUp\nDoWn\nexit\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        Exercici1.play(scanner);
        
        System.setOut(originalOut);
        
        String output = outputStream.toString();
        assertFalse(output.contains("Invalid move!"));
    }
}

package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testGenerateTable() throws Exception {
        Locale defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);

        try {
            String expectedOutput = 
                "1    2    3    4    5    6    7    8    9    10\n" +
                "2    4    6    8    10   12   14   16   18   20\n" +
                "20   22   24   26   28   30   32   34   36   38\n" +
                "10   14   18   22   26   30   34   38   42   46\n" +
                "40   35   30   25   20   15   10   5    0    -5\n";

            String actualOutput = tapSystemOut(() -> Main.main(new String[]{}));
            actualOutput = actualOutput.replace("\r\n", "\n");

            assertEquals(expectedOutput, actualOutput, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                TestStringUtils.findFirstDifference(expectedOutput, actualOutput) +
                "<<<<<<<<<< <<<<<<<<<<\n");

        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    private interface ThrowingRunnable {
        void run() throws Exception;
    }

    private String tapSystemOut(ThrowingRunnable runnable) throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        try {
            runnable.run();
        } finally {
            System.setOut(originalOut);
        }
        return outContent.toString();
    }
}

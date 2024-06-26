package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.swing.SwingUtilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMain {

    private MainWindow mainWindow;

    @BeforeEach
    public void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        });
        // Espera perquè la interfície gràfica es mostri completament
        Thread.sleep(500);
    }

    @AfterEach
    public void tearDown() throws Exception {
        SwingUtilities.invokeAndWait(mainWindow::dispose);
    }

    @Test
    public void testAddition() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow.view.b2.doClick();
            mainWindow.view.bAdd.doClick();
            mainWindow.view.b3.doClick();
            mainWindow.view.bEqual.doClick();
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            assertEquals("5.0", mainWindow.view.result.getText());
        });
    }

    @Test
    public void testSubtraction() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow.view.b5.doClick();
            mainWindow.view.bSub.doClick();
            mainWindow.view.b3.doClick();
            mainWindow.view.bEqual.doClick();
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            assertEquals("2.0", mainWindow.view.result.getText());
        });
    }

    @Test
    public void testMultiplication() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow.view.b4.doClick();
            mainWindow.view.bMul.doClick();
            mainWindow.view.b3.doClick();
            mainWindow.view.bEqual.doClick();
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            assertEquals("12.0", mainWindow.view.result.getText());
        });
    }

    @Test
    public void testDivision() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow.view.b9.doClick();
            mainWindow.view.bDiv.doClick();
            mainWindow.view.b3.doClick();
            mainWindow.view.bEqual.doClick();
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            assertEquals("3.0", mainWindow.view.result.getText());
        });
    }

    @Test
    public void testClear() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow.view.b9.doClick();
            mainWindow.view.bC.doClick();
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            assertEquals("", mainWindow.view.result.getText());
        });
    }
}

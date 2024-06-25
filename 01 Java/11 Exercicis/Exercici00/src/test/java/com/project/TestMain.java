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
    public void testRadioButtonSelection() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow.view.option1.setSelected(true);
            mainWindow.controller.updateConfigDisplay();
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            assertEquals("Opció: Opció 1, Volum: 50, Text: ", mainWindow.view.configDisplay.getText());

            mainWindow.view.option3.setSelected(true);
            mainWindow.controller.updateConfigDisplay();
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            assertEquals("Opció: Opció 3, Volum: 50, Text: ", mainWindow.view.configDisplay.getText());
        });
    }

    @Test
    public void testTextFieldInput() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow.view.textField.setText("Test input");
            mainWindow.controller.updateConfigDisplay();
            mainWindow.view.configDisplay.revalidate();
            mainWindow.view.configDisplay.repaint();
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            assertEquals("Opció: Opció 1, Volum: 50, Text: Test input", mainWindow.view.configDisplay.getText());
        });
    }

    @Test
    public void testVolumeSliderChange() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow.view.volumeSlider.setValue(75);
            mainWindow.controller.updateConfigDisplay();
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            assertEquals("Opció: Opció 1, Volum: 75, Text: ", mainWindow.view.configDisplay.getText());
        });
    }

    @Test
    public void testResetButton() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow.view.textField.setText("Test");
            mainWindow.view.volumeSlider.setValue(20);
            mainWindow.view.option2.setSelected(true);
            mainWindow.view.resetButton.doClick();
            mainWindow.controller.updateConfigDisplay();
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            assertEquals("Opció: Opció 1, Volum: 50, Text: ", mainWindow.view.configDisplay.getText());
        });
    }

    void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

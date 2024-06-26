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
    public void testFormSubmission() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow.vForm.nameField.setText("John Doe");
            mainWindow.vForm.phoneNumberField.setText("123456789");
            mainWindow.vForm.ageField.setText("30");
            mainWindow.vForm.emailField.setText("john.doe@example.com");
            mainWindow.vForm.sendButton.doClick();
        });

        // Espera perquè la barra de càrrega processi
        Thread.sleep(3000);

        SwingUtilities.invokeAndWait(() -> {
            assertEquals("Name: John Doe\nPhone Number: 123456789\nAge: 30\nEmail: john.doe@example.com", mainWindow.vInfo.dataArea.getText());
        });
    }

    @Test
    public void testLoadingProgress() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow.vForm.nameField.setText("Jane Doe");
            mainWindow.vForm.phoneNumberField.setText("987654321");
            mainWindow.vForm.ageField.setText("25");
            mainWindow.vForm.emailField.setText("jane.doe@example.com");
            mainWindow.vForm.sendButton.doClick();
        });

        // Espera un temps per verificar el progrés
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            int progressValue = mainWindow.vLoading.progressBar.getValue();
            assertEquals(true, progressValue > 0 && progressValue <= 100, "Progress value should be between 0 and 100");
        });
    }
}

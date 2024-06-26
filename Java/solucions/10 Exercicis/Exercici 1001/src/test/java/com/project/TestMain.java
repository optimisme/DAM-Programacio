package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;

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
    public void testAddTask() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow.view.taskInput.setText("Task 1");
            mainWindow.view.addButton.doClick();
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            assertEquals(1, mainWindow.view.taskList.getModel().getSize());
            assertEquals("Task 1", mainWindow.view.taskList.getModel().getElementAt(0));
        });
    }

    @Test
    public void testAddTaskWithEnterKey() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow.view.taskInput.setText("Task 2");

            // Crear un esdeveniment de tecla ENTER i enviar-lo al taskInput
            KeyEvent enterEvent = new KeyEvent(mainWindow.view.taskInput, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, '\n');
            mainWindow.view.taskInput.dispatchEvent(enterEvent);
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            assertEquals(1, mainWindow.view.taskList.getModel().getSize());
            assertEquals("Task 2", mainWindow.view.taskList.getModel().getElementAt(0));
        });
    }

    @Test
    public void testDeleteTask() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow.view.taskInput.setText("Task 3");
            mainWindow.view.addButton.doClick();
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            mainWindow.view.taskList.setSelectedIndex(0);
            mainWindow.view.deleteButton.doClick();
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            assertEquals(0, mainWindow.view.taskList.getModel().getSize());
        });
    }

    @Test
    public void testEmptyTaskInput() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow.view.taskInput.setText("");
            mainWindow.view.addButton.doClick();
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            assertEquals(0, mainWindow.view.taskList.getModel().getSize());
        });
    }

    @Test
    public void testDeleteButtonWithoutSelection() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            mainWindow.view.taskInput.setText("Task 4");
            mainWindow.view.addButton.doClick();
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            mainWindow.view.deleteButton.doClick();
        });

        // Espera que l'acció es processi
        Thread.sleep(500);

        SwingUtilities.invokeAndWait(() -> {
            assertEquals(1, mainWindow.view.taskList.getModel().getSize());
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

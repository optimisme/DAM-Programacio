package com.project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MainWindow extends JFrame {
    
    private JButton openButton;
    private JLabel imageLabel;
    private JLabel fileNameLabel; 
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public MainWindow() {
        // Títol i mida de la finestra
        super("SWING Exemple 04");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Definir els elements del panel
        initComponents();
    }

    private void initComponents() {
        openButton = new JButton("Obre Arxiu");
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooseFile();
            }
        });
        add(openButton);

        // Inicialitzar i afegir la nova etiqueta
        fileNameLabel = new JLabel("Cap arxiu seleccionat.");
        fileNameLabel.setForeground(Color.BLUE); 
        add(fileNameLabel);

        imageLabel = new JLabel();
        add(imageLabel);

        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVisible(false);
        add(scrollPane);
    }

    private void chooseFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            fileNameLabel.setText("Arxiu seleccionat: " + selectedFile.getName());
            displayFile(selectedFile);
        }
    }

    private void displayFile(File file) {
        try {
            if (isImageFile(file)) {
                BufferedImage image = ImageIO.read(file);
                ImageIcon icon = new ImageIcon(image.getScaledInstance(-1, 300, Image.SCALE_SMOOTH));
                imageLabel.setIcon(icon);
                scrollPane.setVisible(false);
                imageLabel.setVisible(true);
            } else if (isTextFile(file)) { 
                BufferedReader reader = new BufferedReader(new FileReader(file));
                textArea.setText("");
                textArea.read(reader, null);
                reader.close();
                imageLabel.setIcon(null);
                imageLabel.setVisible(false);
                scrollPane.setVisible(true);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean isTextFile(File file) {
        String[] textExtensions = new String[]{"txt", "xml", "java", "py", "yaml", "json", "sh", "csv"};
        for (String extension : textExtensions) {
            if (file.getName().toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

    private boolean isImageFile(File file) {
        String[] imageExtensions = new String[]{"png", "jpg", "jpeg", "gif", "bmp"};
        for (String extension : imageExtensions) {
            if (file.getName().toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
}

package com.project;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingUtilities;

public class Main {

    private static AppData db = AppData.getInstance();

    public static void main(String[] args) {
        
        System.out.println("\nIniciant les dades de la base de dades:");
        initData();

        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
            
            mainWindow.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    closeApp();
                }
            });
        });
    }

    private static void closeApp() {
        db.close();
        System.out.println("Connexió amb la base de dades tancada.");
        System.exit(0);
    }
   
    private static void initData() {
        // Aquesta part s'haurà d'ajustar segons la teva estructura de base de dades real
        db.update("DROP TABLE IF EXISTS receptes");
        db.update("DROP TABLE IF EXISTS ingredients");

        db.update("CREATE TABLE IF NOT EXISTS receptes (" +
                          "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                          "nom TEXT NOT NULL," +
                          "temps TEXT," +
                          "procediment TEXT," +
                          "esFavorita BOOLEAN DEFAULT 0)");

        db.update("CREATE TABLE IF NOT EXISTS ingredients (" +
                          "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                          "nom TEXT NOT NULL," +
                          "quantitat TEXT," +
                          "receptaId INTEGER," +
                          "FOREIGN KEY (receptaId) REFERENCES receptes(id))");

        // Inserció de receptes
        db.update("INSERT INTO receptes (nom, temps, procediment, esFavorita) VALUES ('Paella', '45 minuts', 'Començar sofregint la ceba i l'allet, afegir l'arròs, després el caldo i el safrà. Cuinar durant 18 minuts.', 0);");
        db.update("INSERT INTO receptes (nom, temps, procediment, esFavorita) VALUES ('Pizza Margarita', '30 minuts', 'Estendre la massa, afegir salsa de tomàquet, mozzarella i fulles de basilic. Coure a 220ºC durant 10-12 minuts.', 0);");
        db.update("INSERT INTO receptes (nom, temps, procediment, esFavorita) VALUES ('Amanida Cèsar', '20 minuts', 'Barrejar lletugues, afegir pollastre a la graella, crostons, parmesà i amanir amb salsa Cèsar.', 0);");
        db.update("INSERT INTO receptes (nom, temps, procediment, esFavorita) VALUES ('Pastís de xocolata', '1 hora', 'Barrejar ingredients secs, afegir els líquids, coure al forn a 180ºC durant 35 minuts. Decorar amb glacejat de xocolata.', 0);");
                                
        // Inserció d'ingredients per a la Paella (ID de recepta 1)
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Ceba', '1 unitat', 1);");
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Allet', '2 dents', 1);");
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Arròs', '2 tasses', 1);");
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Caldo de pollastre', '4 tasses', 1);");
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Safrà', '1 pessic', 1);");
                                
        // Inserció d'ingredients per a la Pizza Margarita (ID de recepta 2)
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Massa de pizza', '1 base', 2);");
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Salsa de tomàquet', '3 cullerades', 2);");
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Mozzarella', '100g', 2);");
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Fulles de basilic', 'A gust', 2);");
                                
        // Inserció d'ingredients per a l'Amanida Cèsar (ID de recepta 3)
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Lletugues variades', '200g', 3);");
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Pollastre a la graella', '100g', 3);");
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Crostons', '50g', 3);");
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Parmesà', '30g', 3);");
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Salsa Cèsar', 'A gust', 3);");
                                
        // Inserció d'ingredients per al Pastís de xocolata (ID de recepta 4)
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Farina', '1 i 1/2 tasses', 4);");
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Sucre', '1 tassa', 4);");
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Cacau en pols', '3/4 tassa', 4);");
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Bicarbonat de sodi', '1 i 1/2 culleradetes', 4);");
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Llet', '1 tassa', 4);");
        db.update("INSERT INTO ingredients (nom, quantitat, receptaId) VALUES ('Oli vegetal', '1/2 tassa', 4);");
    }
}
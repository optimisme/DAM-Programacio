package com.project;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingUtilities;

public class Main {

    // Crear el singleton (això es connecta a la base de dades)
    private static AppData db = AppData.getInstance();

    public static void main(String[] args) {
        
        System.out.println("\nIniciar les dades de la base de dades:");
        initData();

        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
            
            // Afegir un WindowListener per tancar la base de dades quan la finestra es tanca
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
   
    public static void initData() {
        // Obtenir un apuntador al singleton de la base de dades
        AppData db = AppData.getInstance();
    
        // Esborrar les taules 'productes' i 'categories' si existeixen
        db.update("DROP TABLE IF EXISTS productes");
        db.update("DROP TABLE IF EXISTS categories");
    
        // Crear la taula 'categories'
        db.update("CREATE TABLE IF NOT EXISTS categories (" +
                          "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                          "nom TEXT NOT NULL)");
    
        // Crear la taula 'productes'
        db.update("CREATE TABLE IF NOT EXISTS productes (" +
                          "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                          "nom TEXT NOT NULL," +
                          "descripcio TEXT," +
                          "preu DOUBLE," +
                          "categoriaId INTEGER," +
                          "FOREIGN KEY (categoriaId) REFERENCES categories(id))");
    
        // Inserir dades a la taula 'categories'
        db.update("INSERT INTO categories (nom) VALUES ('Guitarres')");
        db.update("INSERT INTO categories (nom) VALUES ('Bateries')");
        db.update("INSERT INTO categories (nom) VALUES ('Teclats')");
        db.update("INSERT INTO categories (nom) VALUES ('Equips de so')");
        db.update("INSERT INTO categories (nom) VALUES ('Accessoris')");
    
        // Inserir dades a la taula 'productes'
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Guitarra Elèctrica Fender', 'Una guitarra elèctrica de qualitat per a professionals i aficionats.', 679.99, 1)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Bateria Acústica Yamaha', 'Completa bateria acústica per a concerts en directe.', 899.99, 2)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Teclat MIDI Akai', 'Ideal per a productors musicals amb control total.', 199.99, 3)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Amplificador Marshall', 'Potència i claredat de so per als teus concerts.', 299.99, 4)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Cordes per Guitarra', 'Cordes de reemplaçament per a guitarra acústica i elèctrica.', 9.99, 5)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Guitarra Acústica Yamaha', 'Guitarra acústica ideal per a principiants i professionals.', 299.99, 1)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Guitarra Clàssica Alhambra', 'Perfecta per a estudiants de guitarra clàssica amb un so càlid.', 449.99, 1)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Ukelele Kala', 'Un instrument divertit i fàcil de tocar per a músics de tots els nivells.', 99.99, 1)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Bateria Electrònica Roland', 'Una bateria electrònica compacta amb una gran varietat de sons.', 599.99, 2)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Percussió Llatina LP', 'Conjunt de congas i bongos per a ritmes llatins autèntics.', 459.99, 2)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Cajón Flamenc Meinl', 'Instrument de percussió versàtil amb un so profund.', 149.99, 2)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Piano Digital Casio', 'Un piano digital amb un teclat ponderat sensible al tacte.', 449.99, 3)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Sintetitzador Moog', 'Sintetitzador analògic icònic amb un so inconfusible.', 899.99, 3)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Controlador MIDI Novation', 'Controlador MIDI compacte i portàtil per a productors musicals.', 199.99, 3)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Micròfon Shure SM58', 'El micròfon estàndard de la indústria per a vocals en directe.', 99.99, 4)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Mesa de Mescles Yamaha', 'Mesa de mescles de 12 canals per a actuacions en directe i gravacions.', 299.99, 4)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Interfície d\'Àudio Focusrite', 'Interfície d’àudio USB per a gravacions d’alta qualitat a casa.', 109.99, 4)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Afinador de Clip Korg', 'Afinador compacte i fàcil d\'usar per a qualsevol instrument.', 14.99, 5)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Pedal d\'Efectes Boss', 'Pedal d\'efectes de guitarra per a distorsió, delay, i més.', 89.99, 5)");
        db.update("INSERT INTO productes (nom, descripcio, preu, categoriaId) VALUES ('Suport de Guitarra Hercules', 'Suport robust i fiable per a qualsevol tipus de guitarra.', 29.99, 5)");
    }
}

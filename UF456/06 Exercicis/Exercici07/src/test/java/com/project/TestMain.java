package com.project;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.github.stefanbirkner.systemlambda.SystemLambda;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {
        String text = SystemLambda.tapSystemOut(() -> {
            // Executa el main per a provar la seva sortida
            String[] args = {}; // Passa els arguments necessaris si n'hi ha
            Main.main(args);
        });
        text = text.replace("\r\n", "\n");

        // Comprova que la sortida conté el text esperat
        String expectedOutput = "Totes les publicacions:\n" +
            "Publicacio{titol='El Senyor dels Anells', anyPublicacio=1954}\n" +
            "Publicacio{titol='National Geographic', anyPublicacio=2020}\n" +
            "Publicacio{titol='Dune', anyPublicacio=1965}\n\n" +
            "Llibres:\n" +
            "Publicacio{titol='El Senyor dels Anells', anyPublicacio=1954}\n" +
            "Publicacio{titol='Dune', anyPublicacio=1965}\n\n" +
            "Revistes:\n" +
            "Publicacio{titol='National Geographic', anyPublicacio=2020}";
        assertTrue(text.contains(expectedOutput), 
            ">>>>>>>>>> >>>>>>>>>>\n" +
            "El missatge de sortida no coincideix amb l'esperat. \n" +
            "Esperat: \n" + expectedOutput + "\n" + 
            "Obtingut: \n" + text + 
            "<<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainValidation() throws Exception {
        Biblioteca biblioteca = new Biblioteca();

        // Afegir 3 llibres
        biblioteca.afegirPublicacio(new Llibre("El Senyor dels Anells", 1954, "J.R.R. Tolkien"));
        biblioteca.afegirPublicacio(new Llibre("Dune", 1965, "Frank Herbert"));
        biblioteca.afegirPublicacio(new Llibre("1984", 1949, "George Orwell"));
    
        // Afegir 4 revistes
        biblioteca.afegirPublicacio(new Revista("National Geographic", 2020, 1024));
        biblioteca.afegirPublicacio(new Revista("Science News", 2021, 1050));
        biblioteca.afegirPublicacio(new Revista("The Economist", 2021, 1051));
        biblioteca.afegirPublicacio(new Revista("Time", 2020, 1025));
    
        // Verificar que la llista de llibres té 3 elements
        assertEquals(3, biblioteca.getLlibres().size(), "Hauria d'haver 3 llibres a la biblioteca.");
    
        // Verificar que la llista de revistes té 4 elements
        assertEquals(4, biblioteca.getRevistes().size(), "Hauria d'haver 4 revistes a la biblioteca.");
    
        String text = SystemLambda.tapSystemOut(() -> {
            Biblioteca bib = new Biblioteca();

            // Afegir 3 llibres
            bib.afegirPublicacio(new Llibre("El Senyor dels Anells", 1954, "J.R.R. Tolkien"));
            bib.afegirPublicacio(new Llibre("Dune", 1965, "Frank Herbert"));
            bib.afegirPublicacio(new Llibre("1984", 1949, "George Orwell"));

            // Afegir 4 revistes
            bib.afegirPublicacio(new Revista("National Geographic", 2020, 1024));
            bib.afegirPublicacio(new Revista("Science News", 2021, 1050));
            bib.afegirPublicacio(new Revista("The Economist", 2021, 1051));
            bib.afegirPublicacio(new Revista("Time", 2020, 1025));

            System.out.println("Totes les publicacions:");
            for (Publicacio publicacio : biblioteca.getPublicacions()) {
                System.out.println(publicacio);
            }

            System.out.println("\nLlibres:");
            for (Llibre llibre : biblioteca.getLlibres()) {
                System.out.println(llibre);
            }

            System.out.println("\nRevistes:");
            for (Revista revista : biblioteca.getRevistes()) {
                System.out.println(revista);
            }
        });
    
        // Reemplaça els salts de línia de Windows per fer el test més genèric
        text = text.replace("\r\n", "\n");

        // Comprova que la sortida conté el text esperat
        String expectedOutput = "Totes les publicacions:\n" +
            "Publicacio{titol='El Senyor dels Anells', anyPublicacio=1954}\n" +
            "Publicacio{titol='Dune', anyPublicacio=1965}\n" +
            "Publicacio{titol='1984', anyPublicacio=1949}\n" +
            "Publicacio{titol='National Geographic', anyPublicacio=2020}\n" +
            "Publicacio{titol='Science News', anyPublicacio=2021}\n" +
            "Publicacio{titol='The Economist', anyPublicacio=2021}\n" +
            "Publicacio{titol='Time', anyPublicacio=2020}\n\n" +
            "Llibres:\n" +
            "Publicacio{titol='El Senyor dels Anells', anyPublicacio=1954}\n" +
            "Publicacio{titol='Dune', anyPublicacio=1965}\n" +
            "Publicacio{titol='1984', anyPublicacio=1949}\n\n" +
            "Revistes:\n" +
            "Publicacio{titol='National Geographic', anyPublicacio=2020}\n" +
            "Publicacio{titol='Science News', anyPublicacio=2021}\n" +
            "Publicacio{titol='The Economist', anyPublicacio=2021}\n" +
            "Publicacio{titol='Time', anyPublicacio=2020}";
        assertTrue(text.contains(expectedOutput), 
            ">>>>>>>>>> >>>>>>>>>>\n" +
            "El missatge de sortida no coincideix amb l'esperat. \n" +
            "Esperat: \n" + expectedOutput + "\n" + 
            "Obtingut: \n" + text + 
            "<<<<<<<<<<< <<<<<<<<<<\n");
    }
    
    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Cotxe
        Field[] fields = Publicacio.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isProtected(field.getModifiers()), "El camp " + field.getName() + " (Publicacio) hauria de ser protected");
        }

        fields = Llibre.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Llibre) hauria de ser privat");
        }

        fields = Revista.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Revista) hauria de ser privat");
        }

        fields = Biblioteca.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Biblioteca) hauria de ser privat");
        }
    }
}

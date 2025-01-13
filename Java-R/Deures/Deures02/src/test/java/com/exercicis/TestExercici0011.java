package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

class TestExercici0011 {

    @Test
    public void testEscullNomsAleatoris() {
        ArrayList<String> noms = new ArrayList<>(Arrays.asList(
            "Mario", "Princess Peach", "Wario", "Luigi", "Iggy Koopa", "Toad"
        ));

        ArrayList<String> seleccionats = Exercici0011.escullNomsAleatoris(noms, 5);
        assertEquals(5, seleccionats.size(), "El nombre d'elements seleccionats hauria de ser 5.");

        for (String nom : seleccionats) {
            assertTrue(noms.contains(nom), "El nom seleccionat no es troba a la llista original: " + nom);
        }

        // Cas d'error
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Exercici0011.escullNomsAleatoris(noms, 25);
        });

        assertEquals("La quantitat no pot ser més gran que " + noms.size() + ".", exception.getMessage());
    }

    @Test
    public void testNomsAcabenVocal() {
        ArrayList<String> noms = new ArrayList<>(Arrays.asList(
            "Mario", "Princess Peach", "Wario", "Luigi", "Iggy Koopa", "Toad", "Yoshi", "Donkey Kong", "Birdo"
        ));

        ArrayList<String> resultat = Exercici0011.nomsAcabenVocal(noms);
        List<String> esperat = Arrays.asList("Mario", "Wario", "Luigi", "Iggy Koopa", "Yoshi", "Birdo");

        String diff = TestStringUtils.findFirstDifference(resultat.toString(), esperat.toString());
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
    }

    @Test
    public void testNomsCompostos() {
        ArrayList<String> noms = new ArrayList<>(Arrays.asList(
            "Mario", "Princess Peach", "Wario", "Luigi", "Iggy Koopa", "Toad", "Yoshi", "Donkey Kong", "Birdo"
        ));

        ArrayList<String> resultat = Exercici0011.nomsCompostos(noms);
        List<String> esperat = Arrays.asList("Princess Peach", "Iggy Koopa", "Donkey Kong");

        String diff = TestStringUtils.findFirstDifference(resultat.toString(), esperat.toString());
        assertTrue(diff.compareTo("identical") == 0,
            ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
    }

    @Test
    public void testMainFunction() throws Exception {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            String text = SystemLambda.tapSystemOut(() -> {
                String[] args = {};
                Exercici0011.main(args);
            });

            // Separem les línies i processem el text
            String[] lines = text.replace("\r\n", "\n").split("\n");
            
            // Extraiem les llistes de cada línia
            ArrayList<String> nomsAleatoris = extraureLlista(lines[0], "Noms escollits a l'atzar: ");
            ArrayList<String> acabenVocal = extraureLlista(lines[2], "Noms que acaben amb vocal: ");
            ArrayList<String> compostos = extraureLlista(lines[3], "Noms compostos: ");

            // Validem la segona línia (error)
            assertEquals("Error: La quantitat no pot ser més gran que 9.", lines[1]);
            
            // Validem que els noms que acaben en vocal són correctes
            for (String nom : acabenVocal) {
                char ultimaLletra = nom.toLowerCase().charAt(nom.length() - 1);
                assertTrue("aeiou".indexOf(ultimaLletra) != -1, 
                    "El nom '" + nom + "' no acaba en vocal");
            }

            // Validem que els noms compostos són correctes
            for (String nom : compostos) {
                assertTrue(nom.contains(" "), 
                    "El nom '" + nom + "' no és compost");
            }

            // Reconstruïm l'output esperat amb les llistes extretes
            String expectedOutput = String.format("Noms escollits a l'atzar: %s\n", nomsAleatoris) +
                "Error: La quantitat no pot ser més gran que 9.\n" +
                String.format("Noms que acaben amb vocal: %s\n", acabenVocal) +
                String.format("Noms compostos: %s\n", compostos);

            String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");

        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    // Mètode auxiliar per extreure una llista d'una línia de text
    private ArrayList<String> extraureLlista(String linia, String prefix) {
        ArrayList<String> resultat = new ArrayList<>();
        String llista = linia.substring(linia.indexOf("["), linia.indexOf("]") + 1);
        // Eliminem els claudàtors i dividim per comes
        String contingut = llista.substring(1, llista.length() - 1).trim();
        if (!contingut.isEmpty()) {
            for (String element : contingut.split(",")) {
                resultat.add(element.trim());
            }
        }
        return resultat;
    }
}

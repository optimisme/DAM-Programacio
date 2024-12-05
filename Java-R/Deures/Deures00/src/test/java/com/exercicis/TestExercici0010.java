package com.exercicis;

import com.testStringUtils.TestStringUtils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

class TestExercici0010 {

    @Test
    public void testGenerarNumerosAleatoris() {
        ArrayList<Integer> resultat = Exercici0010.generarNumerosAleatoris(5, 0, 99);

        // Comprovar que conté 5 elements
        assertEquals(5, resultat.size());

        // Comprovar que tots els nombres estan dins del rang
        for (int num : resultat) {
            assertTrue(num >= 0 && num <= 99, "Número fora del rang: " + num);
        }
    }

    @Test
    public void testMultiplicarPerDos() {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            ArrayList<Integer> llista = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
            ArrayList<Integer> resultat = Exercici0010.multiplicarPerDos(llista);
            List<Integer> esperat = Arrays.asList(2, 4, 6, 8, 10);

            String diff = TestStringUtils.findFirstDifference(resultat.toString(), esperat.toString());
            assertTrue(diff.compareTo("identical") == 0, 
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    @Test
    public void testFiltrarImparells() {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            ArrayList<Integer> llista = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
            ArrayList<Integer> resultat = Exercici0010.filtrarImparells(llista);
            List<Integer> esperat = Arrays.asList(1, 3, 5);

            String diff = TestStringUtils.findFirstDifference(resultat.toString(), esperat.toString());
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    @Test
    public void testDividirPerDos() {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            ArrayList<Integer> llista = new ArrayList<>(Arrays.asList(1, 3, 5));
            ArrayList<Double> resultat = Exercici0010.dividirPerDos(llista);
            List<Double> esperat = Arrays.asList(0.5, 1.5, 2.5);

            String diff = TestStringUtils.findFirstDifference(resultat.toString(), esperat.toString());
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");
        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    @Test
    public void testMainFunction() throws Exception {
        Locale defaultLocale = Locale.getDefault();
        try {
            Locale.setDefault(Locale.US);

            String text = SystemLambda.tapSystemOut(() -> {
                Exercici0010.main(new String[]{});
            });
            
            // Convertim el text de sortida en línies i eliminem els espais en blanc extra
            String[] lines = text.trim().split("\n");
            
            // Extraiem els números de cada línia
            ArrayList<Integer> llistaInicial = extreureLlistaIntegers(lines[0]);
            ArrayList<Integer> llistaMultiplicada = extreureLlistaIntegers(lines[1]);
            ArrayList<Integer> llistaImparells = extreureLlistaIntegers(lines[2]);
            ArrayList<Double> llistaDividida = extreureLlistaDoubles(lines[3]);

            // Construïm la sortida esperada basada en els càlculs
            StringBuilder expectedOutput = new StringBuilder();
            expectedOutput.append("Llista inicial: ").append(llistaInicial).append("\n");
            expectedOutput.append("Llista multiplicada per 2: ").append(multiplicarLlista(llistaInicial)).append("\n");
            expectedOutput.append("Llista només amb números imparells: ").append(filtrarImparells(llistaInicial)).append("\n");
            expectedOutput.append("Llista imparells dividits per 2: ").append(dividirImparells(filtrarImparells(llistaInicial))).append("\n");

            // Normalitzem els salts de línia i comparem amb TestStringUtils
            text = text.replace("\r\n", "\n");
            String diff = TestStringUtils.findFirstDifference(text, expectedOutput.toString());
            assertTrue(diff.compareTo("identical") == 0,
                ">>>>>>>>>> Diff found >>>>>>>>>>\n" + diff + "<<<<<<<<<< Diff end <<<<<<<<<<\n");

        } finally {
            Locale.setDefault(defaultLocale);
        }
    }

    // Mètodes auxiliars per extreure i manipular les llistes

    private ArrayList<Integer> extreureLlistaIntegers(String linia) {
        ArrayList<Integer> resultat = new ArrayList<>();
        String contingut = linia.substring(linia.indexOf("[") + 1, linia.indexOf("]"));
        if (!contingut.trim().isEmpty()) {
            String[] nums = contingut.split(",");
            for (String num : nums) {
                resultat.add(Integer.parseInt(num.trim()));
            }
        }
        return resultat;
    }

    private ArrayList<Double> extreureLlistaDoubles(String linia) {
        ArrayList<Double> resultat = new ArrayList<>();
        String contingut = linia.substring(linia.indexOf("[") + 1, linia.indexOf("]"));
        if (!contingut.trim().isEmpty()) {
            String[] nums = contingut.split(",");
            for (String num : nums) {
                resultat.add(Double.parseDouble(num.trim()));
            }
        }
        return resultat;
    }

    private ArrayList<Integer> multiplicarLlista(ArrayList<Integer> llista) {
        ArrayList<Integer> resultat = new ArrayList<>();
        for (int num : llista) {
            resultat.add(num * 2);
        }
        return resultat;
    }

    private ArrayList<Integer> filtrarImparells(ArrayList<Integer> llista) {
        ArrayList<Integer> resultat = new ArrayList<>();
        for (int num : llista) {
            if (num % 2 != 0) {
                resultat.add(num);
            }
        }
        return resultat;
    }

    private ArrayList<Double> dividirImparells(ArrayList<Integer> llista) {
        ArrayList<Double> resultat = new ArrayList<>();
        for (int num : llista) {
            resultat.add(num / 2.0);
        }
        return resultat;
    }
}

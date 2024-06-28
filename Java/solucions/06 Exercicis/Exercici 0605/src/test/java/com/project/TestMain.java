package com.project;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {
        // Redirigeix la sortida estàndard a un flux de sortida
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Executa el main per a provar la seva sortida
        String[] args = {}; // Passa els arguments necessaris si n'hi ha
        Main.main(args);

        // Restaura els fluxos originals
        System.setOut(originalOut);

        // Comprova que la sortida conté el text esperat
        String text = outContent.toString().replace("\r\n", "\n"); // Normalitza les noves línies
        String expectedOutput = "Cotxe{marca='Toyota', model='Corolla', capacitatCarrega=500}\n" +
            "El cotxe Toyota Corolla s'està iniciant.\n" +
            "Carregant 300kg en el cotxe.\n" +
            "El cotxe Toyota Corolla s'ha aturat.\n" +
            "Vehicle{marca='Toyota', model='Corolla'}\n" +
            "Furgoneta{marca='Ford', model='Transit', volumCarrega=15m³}\n" +
            "La furgoneta Ford Transit s'està iniciant.\n" +
            "Carregant 1000kg a la furgoneta.\n" +
            "La furgoneta Ford Transit s'ha aturat.\n" +
            "Vehicle{marca='Ford', model='Transit'}, volumCarrega=15m³\n" +
            "Bicicleta{marca='BH', model='Speedrom'}\n" +
            "La bicicleta BH Speedrom està preparada per a ser utilitzada.\n" +
            "La bicicleta BH Speedrom s'ha aturat.\n" +
            "Vehicle{marca='BH', model='Speedrom'}\n";
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainValidation() throws Exception {
        // Redirigeix la sortida estàndard a un flux de sortida
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Crear noves instàncies de vehicles amb diferents atributs
        Cotxe cotxe2 = new Cotxe("Peugeot", "308", 450);
        Furgoneta furgoneta2 = new Furgoneta("Mercedes", "Sprinter", 20); // 20m³ de volum de càrrega
        Bicicleta bicicleta2 = new Bicicleta("Trek", "Marlin 5");

        // Capturar i validar les sortides esperades per les operacions de cotxe2
        cotxe2.iniciarVehicle();
        cotxe2.carregar(200);
        cotxe2.aturarVehicle();
        String cotxeOutput = outContent.toString().replace("\r\n", "\n");
        String expectedCotxeOutput = "El cotxe Peugeot 308 s'està iniciant.\n" +
            "Carregant 200kg en el cotxe.\n" +
            "El cotxe Peugeot 308 s'ha aturat.\n";
        assertEquals(expectedCotxeOutput, cotxeOutput, "La sortida per a cotxe2 no és l'esperada.");

        // Reset output stream
        outContent.reset();

        // Capturar i validar les sortides esperades per les operacions de furgoneta2
        furgoneta2.iniciarVehicle();
        furgoneta2.carregar(1500);
        furgoneta2.aturarVehicle();
        String furgonetaOutput = outContent.toString().replace("\r\n", "\n");
        String expectedFurgonetaOutput = "La furgoneta Mercedes Sprinter s'està iniciant.\n" +
            "Carregant 1500kg a la furgoneta.\n" +
            "La furgoneta Mercedes Sprinter s'ha aturat.\n";
        assertEquals(expectedFurgonetaOutput, furgonetaOutput, "La sortida per a furgoneta2 no és l'esperada.");

        // Reset output stream
        outContent.reset();

        // Capturar i validar les sortides esperades per les operacions de bicicleta2
        bicicleta2.iniciarVehicle();
        bicicleta2.aturarVehicle();
        String bicicletaOutput = outContent.toString().replace("\r\n", "\n");
        String expectedBicicletaOutput = "La bicicleta Trek Marlin 5 està preparada per a ser utilitzada.\n" +
            "La bicicleta Trek Marlin 5 s'ha aturat.\n";
        assertEquals(expectedBicicletaOutput, bicicletaOutput, "La sortida per a bicicleta2 no és l'esperada.");

        // Restaura els fluxos originals
        System.setOut(originalOut);
    }
    
    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Vehicle
        Field[] fields = Vehicle.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui protegit
        for (Field field : fields) {
            assertTrue(Modifier.isProtected(field.getModifiers()), "El camp " + field.getName() + " (Vehicle) hauria de ser protected");
        }

        fields = Cotxe.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Cotxe) hauria de ser privat");
        }

        fields = Furgoneta.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Furgoneta) hauria de ser privat");
        }

        fields = Bicicleta.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Bicicleta) hauria de ser privat");
        }
    }
}

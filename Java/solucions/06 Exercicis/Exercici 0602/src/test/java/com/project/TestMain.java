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
        String expectedOutput = "Persona{nom='Maria García', dni='12345678P'}, llicència='LIC1234'\n" +
            "Pilot Maria García amb llicència LIC1234 ha realitzat el check-in. Preparat per al vol.\n\n" +
            "Persona{nom='Joan Martí', dni='87654321J'}, vol='VOL001'\n" +
            "Facturació de client completada. Preparat per embarcar al vol VOL001. Benvingut a bord!\n\n" +
            "Persona{nom='Anna Lopez', dni='23456789A'}, vol='VOL002'\n" +
            "Facturació de client completada. Preparat per embarcar al vol VOL002. Benvingut a bord!\n";
        assertStringEqualsWithDetail(expectedOutput, text);
    }

    private void assertStringEqualsWithDetail(String expected, String actual) {
        String diff = TestStringUtils.findFirstDifference(expected, actual);
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

        // Crea un nou pilot amb dades diferents
        Pilot pilot = new Pilot("Laura Núñez", "98765432L", "PILOT999");
        String expectedPilotOutput = "Persona{nom='Laura Núñez', dni='98765432L'}, llicència='PILOT999'\n" +
                "Pilot Laura Núñez amb llicència PILOT999 ha realitzat el check-in. Preparat per al vol.\n";

        // Crea dos nous clients amb dades diferents
        Client client1 = new Client("Carlos Ruiz", "43215678C", "VOL005");
        String expectedClient1Output = "Persona{nom='Carlos Ruiz', dni='43215678C'}, vol='VOL005'\n" +
                "Facturació de client completada. Preparat per embarcar al vol VOL005. Benvingut a bord!\n";

        Client client2 = new Client("Sofía Martín", "56784321S", "VOL006");
        String expectedClient2Output = "Persona{nom='Sofía Martín', dni='56784321S'}, vol='VOL006'\n" +
                "Facturació de client completada. Preparat per embarcar al vol VOL006. Benvingut a bord!\n";

        // Captura i compara la sortida de toString i checkIn per a cada objecte
        System.out.println(pilot);
        pilot.checkIn();
        String outputPilot = outContent.toString();
        outContent.reset();

        System.out.println(client1);
        client1.checkIn();
        String outputClient1 = outContent.toString();
        outContent.reset();

        System.out.println(client2);
        client2.checkIn();
        String outputClient2 = outContent.toString();

        // Restaura els fluxos originals
        System.setOut(originalOut);

        assertStringEqualsWithDetail(expectedPilotOutput, outputPilot);
        assertStringEqualsWithDetail(expectedClient1Output, outputClient1);
        assertStringEqualsWithDetail(expectedClient2Output, outputClient2);
    }

    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Persona
        Field[] fields = Persona.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui protected
        for (Field field : fields) {
            assertTrue(Modifier.isProtected(field.getModifiers()), "El camp " + field.getName() + " (Persona) hauria de ser protected");
        }

        // Obtenim tots els camps de la classe Client
        fields = Client.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Client) hauria de ser privat");
        }

        // Obtenim tots els camps de la classe Pilot
        fields = Pilot.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Pilot) hauria de ser privat");
        }
    }
}

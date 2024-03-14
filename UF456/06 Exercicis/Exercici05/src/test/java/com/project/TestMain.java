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
        String expectedOutput = "Cotxe{marca='Toyota', model='Corolla', capacitatCarrega=500}\n" +
            "El cotxe Toyota Corolla s'està iniciant.\n" +
            "Carregant 300kg en el cotxe.\n" +
            "El cotxe Toyota Corolla s'ha aturat.\n" +
            "Vehicle{marca='Toyota', model='Corolla'}\n" +
            "La furgoneta Ford Transit s'està iniciant.\n" +
            "Carregant 1000kg a la furgoneta.\n" +
            "La furgoneta Ford Transit s'ha aturat.\n" +
            "Bicicleta{marca='BH', model='Speedrom'}\n" +
            "La bicicleta BH Speedrom està preparada per a ser utilitzada.\n" +
            "La bicicleta BH Speedrom s'ha aturat.\n" +
            "Vehicle{marca='BH', model='Speedrom'}";
        assertTrue(text.contains(expectedOutput), 
            ">>>>>>>>>> >>>>>>>>>>\n" +
            "El missatge de sortida no coincideix amb l'esperat. \n" +
            "Esperat: \n" + expectedOutput + "\n" + 
            "Obtingut: \n" + text + 
            "<<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainValidation() throws Exception {
        // Crear noves instàncies de vehicles amb diferents atributs
        Cotxe cotxe2 = new Cotxe("Peugeot", "308", 450);
        Furgoneta furgoneta2 = new Furgoneta("Mercedes", "Sprinter", 20); // 20m³ de volum de càrrega
        Bicicleta bicicleta2 = new Bicicleta("Trek", "Marlin 5");
    
        // Capturar i validar les sortides esperades per les operacions de cotxe2
        String expectedCotxeOutput = "El cotxe Peugeot 308 s'està iniciant.\n" +
            "Carregant 200kg en el cotxe.\n" +
            "El cotxe Peugeot 308 s'ha aturat.\n";
        String cotxeOutput = SystemLambda.tapSystemOut(() -> {
            cotxe2.iniciarVehicle();
            cotxe2.carregar(200);
            cotxe2.aturarVehicle();
        });
        assertEquals(expectedCotxeOutput, cotxeOutput.replace("\r\n", "\n"), "La sortida per a cotxe2 no és l'esperada.");
    
        // Capturar i validar les sortides esperades per les operacions de furgoneta2
        String expectedFurgonetaOutput = "La furgoneta Mercedes Sprinter s'està iniciant.\n" +
            "Carregant 1500kg a la furgoneta.\n" +
            "La furgoneta Mercedes Sprinter s'ha aturat.\n";
        String furgonetaOutput = SystemLambda.tapSystemOut(() -> {
            furgoneta2.iniciarVehicle();
            furgoneta2.carregar(1500);
            furgoneta2.aturarVehicle();
        });
        assertEquals(expectedFurgonetaOutput, furgonetaOutput.replace("\r\n", "\n"), "La sortida per a furgoneta2 no és l'esperada.");
    
        // Capturar i validar les sortides esperades per les operacions de bicicleta2
        String expectedBicicletaOutput = "La bicicleta Trek Marlin 5 està preparada per a ser utilitzada.\n" +
            "La bicicleta Trek Marlin 5 s'ha aturat.\n";
        String bicicletaOutput = SystemLambda.tapSystemOut(() -> {
            bicicleta2.iniciarVehicle();
            bicicleta2.aturarVehicle();
        });
        assertEquals(expectedBicicletaOutput, bicicletaOutput.replace("\r\n", "\n"), "La sortida per a bicicleta2 no és l'esperada.");
    }
    
    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Cotxe
        Field[] fields = Vehicle.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
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

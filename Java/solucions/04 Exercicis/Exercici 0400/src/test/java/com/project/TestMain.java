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
        String expectedOutput = "Model: SEAT 127; Color: Verd; Cilindrada: 1438cc; Any: 1972\nModel: CITROEN DS; Color: Gris; Cilindrada: 2175cc; Any: 1959" +
            "\n";
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
            assertTrue(diff.compareTo("identical") == 0, 
                "\n>>>>>>>>>> >>>>>>>>>>\n" +
                diff +
                "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainSettersGetters() {
        // Creació del primer objecte Cotxe
        Cotxe audi = new Cotxe("Blau", "AUDI", "A4", 1984, 2020);
        // Modificació dels valors utilitzant els setters
        audi.setColor("Negre");
        audi.setMarca("AUDI");
        audi.setModel("Q5");
        audi.setCilindrada(2995);
        audi.setAny(2021);

        // Verificació que els valors obtinguts amb els getters siguin els esperats
        assertEquals("Negre", audi.getColor(), "El color de l'Audi no és correcte");
        assertEquals("AUDI", audi.getMarca(), "La marca de l'Audi no és correcte");
        assertEquals("Q5", audi.getModel(), "El model de l'Audi no és correcte");
        assertEquals(2995, audi.getCilindrada(), "La cilindrada de l'Audi no és correcta");
        assertEquals(2021, audi.getAny(), "L'any de l'Audi no és correcte");

        // Creació del segon objecte Cotxe
        Cotxe bmw = new Cotxe("Vermell", "BMW", "M3", 2993, 2019);
        // Modificació dels valors utilitzant els setters
        bmw.setColor("Blanc");
        bmw.setMarca("BMW");
        bmw.setModel("M4");
        bmw.setCilindrada(2993);
        bmw.setAny(2020);

        // Verificació que els valors obtinguts amb els getters siguin els esperats
        assertEquals("Blanc", bmw.getColor(), "El color del BMW no és correcte");
        assertEquals("BMW", bmw.getMarca(), "La marca del BMW no és correcte");
        assertEquals("M4", bmw.getModel(), "El model del BMW no és correcte");
        assertEquals(2993, bmw.getCilindrada(), "La cilindrada del BMW no és correcta");
        assertEquals(2020, bmw.getAny(), "L'any del BMW no és correcte");
    }

    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Cotxe
        Field[] fields = Cotxe.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " hauria de ser privat");
        }
    }
}

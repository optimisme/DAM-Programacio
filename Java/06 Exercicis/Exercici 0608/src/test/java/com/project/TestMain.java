package com.project;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
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
        String expectedOutput = "Empleat{nom='Anna', identificador='DEV001'}, llenguatge='Java'\n" +
            "Empleat{nom='Carlos', identificador='MAN001'}, departament='TI'\n" +
            "Empleat{nom='Berta', identificador='DEV002'}, llenguatge='C#'\n";
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainValidation() {
        List<Empleat> empleats = new ArrayList<>();
        empleats.add(new Desenvolupador("Anna", "DEV001", "Java"));
        empleats.add(new Desenvolupador("Berta", "DEV002", "C#"));
        empleats.add(new Desenvolupador("Clara", "DEV003", "Python"));
        empleats.add(new Gestor("David", "MAN001", "TI"));
        empleats.add(new Gestor("Elena", "MAN002", "Recursos Humans"));
        empleats.add(new Gestor("Fernando", "MAN003", "Màrqueting"));

        // Comprova que la llista té almenys 6 empleats
        assertEquals(6, empleats.size(), "La llista hauria de tenir 6 empleats.");

        // Verificar les descripcions esperades per a cada empleat
        String[] descripcionsEsperades = {
            "Empleat{nom='Anna', identificador='DEV001'}, llenguatge='Java'",
            "Empleat{nom='Berta', identificador='DEV002'}, llenguatge='C#'",
            "Empleat{nom='Clara', identificador='DEV003'}, llenguatge='Python'",
            "Empleat{nom='David', identificador='MAN001'}, departament='TI'",
            "Empleat{nom='Elena', identificador='MAN002'}, departament='Recursos Humans'",
            "Empleat{nom='Fernando', identificador='MAN003'}, departament='Màrqueting'"
        };

        for (int i = 0; i < empleats.size(); i++) {
            assertEquals(descripcionsEsperades[i], empleats.get(i).toString(), "La descripció de l'empleat no coincideix amb l'esperada.");
        }
    }

    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Empleat
        Field[] fields = Empleat.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isProtected(field.getModifiers()), "El camp " + field.getName() + " (Empleat) hauria de ser protected");
        }

        fields = Desenvolupador.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Desenvolupador) hauria de ser privat");
        }

        fields = Gestor.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Gestor) hauria de ser privat");
        }
    }
}

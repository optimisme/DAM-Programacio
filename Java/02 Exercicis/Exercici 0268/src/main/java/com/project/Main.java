// Main.java
package com.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Object[][] inventariNetja = {
            {"Detergent", "Casa", 5.99},
            {"Netejador d'interiors", "Automoció", 7.99},
            {"Tovalloles de paper", "Casa", 2.99},
            {"Paper higiènic de luxe", "Personal", 7.99},
            {"Netejador de vidres", "Casa", 4.79},
            {"Aspiradora", "Casa", 29.69},
            {"Cera de cotxes", "Automoció", 8.49},
            {"Tovalloletes netejadores", "Personal", 6.29},
            {"Xampú per al cos", "Personal", 4.99},
            {"Sabó de mans líquid", "Personal", 2.49},
            {"Esprai netejador", "Casa", 3.49},
            {"Estopa de cotxes", "Automoció", 1.99},
        };

        escriuInformacioPerCategories(inventariNetja);
    }

    public static void escriuInformacioPerCategories(Object[][] inventari) {
        
    }

    public static Map<String, List<Object[]>> obtenirCategories(Object[][] inventari) {
        return null;
    }

    public static void escriuElementsCategoria(List<Object[]> elements) {
        
    }
}

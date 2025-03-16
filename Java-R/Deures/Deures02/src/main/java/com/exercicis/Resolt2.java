package com.exercicis;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Resolt2 {

    static ArrayList<HashMap<String, Object>> mortgages = new ArrayList<>();
    
    public static boolean isTestEnvironment = false;

    /**
     * Quan tinguis totes les funcions llestes, 
     * executa el 'main' amb:
     * 
     * @run ./run.sh com.examen.Main
     * @test ./runTest.sh com.examen.TestExamen#testMainOutput
     * 
     * Per passar tots els tests i saber la nota:
     * 
     * @test ./runTest.sh com.examen.TestExamen
     */
    public static void main(String[] args) {

        Locale originalLocale = Locale.getDefault();
        Locale localeUS = Locale.US;
        Locale.setDefault(localeUS);

        try {
            loadMortgages("./data/mortgages.json");

            clearScreen();

            mortgages.removeIf(m -> {
                boolean invalid = false;
                if (m.get("bank") == null || !isValidBankName(m.get("bank").toString())) {
                    System.out.println("Invalid bank: " + m.get("bank"));
                    invalid = true;
                }
                if (m.get("name") == null || !isValidClientName(m.get("name").toString())) {
                    System.out.println("Invalid client name: " + m.get("name"));
                    invalid = true;
                }
                if (m.get("payments") == null || !isValidPayments(Integer.parseInt(m.get("payments").toString()))) {
                    System.out.println("Invalid payments: " + m.get("payments"));
                    invalid = true;
                }
                if (m.get("value") == null || !isValidValue(Double.parseDouble(m.get("value").toString()))) {
                    System.out.println("Invalid value: " + m.get("value"));
                    invalid = true;
                }
                if (m.get("date") == null || !isValidDate(m.get("date").toString())) {
                    System.out.println("Invalid date: " + m.get("date"));
                    invalid = true;
                }
                if (m.get("modified") == null || !isValidDate(m.get("modified").toString())) {
                    System.out.println("Invalid modified date: " + m.get("modified"));
                    invalid = true;
                }
                return invalid;
            });

            System.out.println();
            listMortgages("bank");

            System.out.println();
            listMortgages("payments");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Locale.setDefault(originalLocale);
    }
   
    /**
     * Esborra la pantalla de la consola.
     *
     * Aquesta funció neteja la pantalla depenent del sistema operatiu. 
     * Per a Windows, executa el comandament `cls` mitjançant `cmd`. 
     * Per a altres sistemes operatius, utilitza seqüències d'escape ANSI.
     * Si es produeix un error durant l'execució, aquest s'imprimeix a la consola.
     */
    public static void clearScreen() {
        if (isTestEnvironment) {
            return;
        }
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Converteix un JSON String en un HashMap.
     *
     * Aquesta funció transforma una cadena JSON en un HashMap utilitzant `JSONObject`.
     * mantenint les dates com a "Strings" amb el format original
     *
     * @param jsonstr Cadena JSON que conté els atributs.
     * @return Un HashMap amb les dades deserialitzades.
     * 
     * @test ./runTest.sh com.examen.TestExamen#testGetHashMapSimpleObject
     * @test ./runTest.sh com.examen.TestExamen#testGetHashMapEmptyObject
     */
    public static HashMap<String, Object> getHashMap(String jsonstr) {
        JSONObject obj = new JSONObject(jsonstr);
        HashMap<String, Object> map = new HashMap<>();
        for (String key : obj.keySet()) {
            map.put(key, obj.get(key));
        }
        return map;
    }
    
    /**
     * Converteix un JSON Array String en una ArrayList de HashMaps.
     *
     * Aquesta funció processa una cadena que representa un JSON Array, convertint cada 
     * element en un HashMap utilitzant la funció `getHashMap`.
     *
     * @param jsonstr Cadena JSON Array que conté els objectes.
     * @return Una ArrayList amb els HashMaps deserialitzats.
     * 
     * @test ./runTest.sh com.examen.TestExamen#testGetArrayListSimpleArray
     * @test ./runTest.sh com.examen.TestExamen#testGetArrayListEmptyArray
     */
    public static ArrayList<HashMap<String, Object>> getArrayList(String jsonstr) {
        JSONArray arr = new JSONArray(jsonstr);
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            list.add(new HashMap<>(arr.getJSONObject(i).toMap()));
        }
        return list;
    }

    /**
     * Carrega les hipoteques d'un fitxer JSON.
     *
     * Aquesta funció llegeix un fitxer JSON, converteix el contingut en una ArrayList 
     * de HashMaps mitjançant `getArrayList` i l'emmagatzema a la variable global `mortgages`.
     *
     * @param fileName Ruta del fitxer JSON que conté les hipoteques.
     * @throws IOException Si es produeix un error durant la lectura del fitxer.
     * 
     * @test ./runTest.sh com.examen.TestExamen#testLoadMortgages
     */
    public static void loadMortgages(String fileName) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        mortgages = getArrayList(content);
    }

    /**
     * Verifica si el nom d'un client és vàlid.
     *
     * El nom només pot contenir lletres de l'alfabet (amb accents inclosos) i espais.
     *
     * @param name Nom del client a verificar.
     * @return `true` si el nom és vàlid; `false` en cas contrari.
     * 
     * @test ./runTest.sh com.examen.TestExamen#testValidClientNameSimple
     * @test ./runTest.sh com.examen.TestExamen#testValidClientNameWithAccents
     * @test ./runTest.sh com.examen.TestExamen#testInvalidClientNameWithNumbers
     * @test ./runTest.sh com.examen.TestExamen#testInvalidClientNameWithSpecialChars
     * @test ./runTest.sh com.examen.TestExamen#testEmptyClientName
     */
    static boolean isValidClientName(String name) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZàèéíòóúÀÈÉÍÒÓÚïÏüÜ ";
        for (char c : name.toCharArray()) {
            if (allowedChars.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si el nom d'un banc és vàlid.
     *
     * El nom només pot contenir lletres de l'alfabet (amb accents inclosos), nombres, 
     * espais i el caràcter guionet (`-`).
     *
     * @param name Nom del banc a verificar.
     * @return `true` si el nom és vàlid; `false` en cas contrari.
     * 
     * @test ./runTest.sh com.examen.TestExamen#testValidBankNameSimple
     * @test ./runTest.sh com.examen.TestExamen#testValidBankNameWithAccentsAndNumbers
     * @test ./runTest.sh com.examen.TestExamen#testValidBankNameWithDash
     * @test ./runTest.sh com.examen.TestExamen#testInvalidBankNameWithSpecialChars
     * @test ./runTest.sh com.examen.TestExamen#testEmptyBankName
     */
    static boolean isValidBankName(String name) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZàèéíòóúÀÈÉÍÒÓÚïÏüÜ0123456789- ";
        for (char c : name.toCharArray()) {
            if (allowedChars.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si el nombre de pagaments és vàlid.
     *
     * El nombre de pagaments ha de ser superior o igual a 5.
     *
     * @param payments Nombre de pagaments.
     * @return `true` si el nombre és vàlid; `false` en cas contrari.
     * 
     * @test ./runTest.sh com.examen.TestExamen#testValidPaymentsEqualToFive
     * @test ./runTest.sh com.examen.TestExamen#testValidPaymentsGreaterThanFive
     * @test ./runTest.sh com.examen.TestExamen#testInvalidPaymentsLessThanFive
     */
    public static boolean isValidPayments(int payments) {
        return (payments >= 5);
    }
    
    /**
     * Verifica si el valor d'una hipoteca és vàlid.
     *
     * El valor ha de ser superior a 50.000.
     *
     * @param value Valor de la hipoteca.
     * @return `true` si el valor és vàlid; `false` en cas contrari.
     * 
     * @test ./runTest.sh com.examen.TestExamen#testValidValueGreaterThan50000
     * @test ./runTest.sh com.examen.TestExamen#testInvalidValueEqualTo50000
     * @test ./runTest.sh com.examen.TestExamen#testInvalidValueLessThan50000
     */
    public static boolean isValidValue(double value) {
        return value > 50000;
    }

    /**
     * Determina si una cadena conté només dígits.
     *
     * Aquesta funció verifica si tots els caràcters d'una cadena són dígits numèrics.
     *
     * @param title Cadena a verificar.
     * @return `true` si només conté dígits; `false` en cas contrari.
     * 
     * @test ./runTest.sh com.examen.TestExamen#testIsAllDigitsWithOnlyDigits
     * @test ./runTest.sh com.examen.TestExamen#testIsAllDigitsWithLetters
     * @test ./runTest.sh com.examen.TestExamen#testIsAllDigitsWithEmptyString
     */
    private static boolean isAllDigits(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) return false;
        }
        return true;
    }

    /**
     * Valida una data en format `yyyy-MM-ddTHH:mm:ss`.
     *
     * La funció comprova si una cadena segueix el format especificat, incloent-hi l'any, mes, dia, hora, minut i segon. 
     * També verifica si els valors d'anys de traspàs són correctes i que les hores, minuts i segons estiguin dins dels rangs vàlids.
     *
     * @param dateTime Cadena que representa una data i hora en el format `yyyy-MM-ddTHH:mm:ss`.
     * @return `true` si la data i hora són vàlides; `false` en cas contrari.
     * 
     * @test ./runTest.sh com.examen.TestExamen#testValidDate
     * @test ./runTest.sh com.examen.TestExamen#testInvalidDateNull
     * @test ./runTest.sh com.examen.TestExamen#testInvalidDateWrongLength
     * @test ./runTest.sh com.examen.TestExamen#testInvalidDateWrongFormatChars
     * @test ./runTest.sh com.examen.TestExamen#testInvalidYearOutOfRange
     * @test ./runTest.sh com.examen.TestExamen#testInvalidMonth
     * @test ./runTest.sh com.examen.TestExamen#testInvalidDay
     * @test ./runTest.sh com.examen.TestExamen#testInvalidDayInFebruaryNonLeap
     * @test ./runTest.sh com.examen.TestExamen#testValidDateInFebruaryLeapYear
     * @test ./runTest.sh com.examen.TestExamen#testValidTimeBoundaries
     * @test ./runTest.sh com.examen.TestExamen#testInvalidHourTooHigh
     * @test ./runTest.sh com.examen.TestExamen#testInvalidMinuteTooHigh
     * @test ./runTest.sh com.examen.TestExamen#testInvalidSecondTooHigh
     */
    public static boolean isValidDate(String dateTime) {
        if (dateTime == null || dateTime.length() != 19) return false;
        if (dateTime.charAt(4) != '-' || dateTime.charAt(7) != '-' || dateTime.charAt(10) != 'T' 
            || dateTime.charAt(13) != ':' || dateTime.charAt(16) != ':') return false;

        String datePart = dateTime.substring(0, 10);
        String timePart = dateTime.substring(11);

        // Validate date
        String yearStr = datePart.substring(0, 4);
        String monthStr = datePart.substring(5, 7);
        String dayStr = datePart.substring(8, 10);
        if (!isAllDigits(yearStr) || !isAllDigits(monthStr) || !isAllDigits(dayStr)) return false;

        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(dayStr);
        if (year < 1000 || year > 9999) return false;
        if (month < 1 || month > 12) return false;
        if (day < 1 || day > 31) return false;
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) return false;
        if (month == 2) {
            boolean leap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if (leap) {
                if (day > 29) return false;
            } else {
                if (day > 28) return false;
            }
        }

        // Validate time
        String hourStr = timePart.substring(0, 2);
        String minuteStr = timePart.substring(3, 5);
        String secondStr = timePart.substring(6);
        if (!isAllDigits(hourStr) || !isAllDigits(minuteStr) || !isAllDigits(secondStr)) return false;

        int hour = Integer.parseInt(hourStr);
        int minute = Integer.parseInt(minuteStr);
        int second = Integer.parseInt(secondStr);
        if (hour < 0 || hour > 23) return false;
        if (minute < 0 || minute > 59) return false;
        if (second < 0 || second > 59) return false;

        return true;
    }
    
    /**
     * Ajusta un text segons l'amplada especificada i l'alineació indicada.
     *
     * Aquesta funció permet formatar un text per ajustar-lo a una amplada fixa. Si el text és més llarg que
     * l'amplada especificada, es retalla i s'hi afegeix un punt final (`.`) per indicar que ha estat truncat. 
     * Si el text és més curt, s'hi afegeixen espais segons l'alineació especificada: esquerra, dreta o centrat.
     *
     * Algorisme:
     * 1. Calcula el nombre d'espais necessaris (`padding`) per ajustar el text a l'amplada especificada.
     * 2. Si la longitud del text és superior a l'amplada:
     *    - Retalla el text a `width - 1` i hi afegeix un punt final (`.`).
     * 3. Si el text és més curt, ajusta l'espai segons l'alineació:
     *    - `"left"`: Afegeix espais a la dreta del text.
     *    - `"right"`: Afegeix espais a l'esquerra del text.
     *    - `"center"` (o qualsevol altre valor): Calcula els espais necessaris a banda i banda per centrar el text.
     * 4. Retorna el text ajustat amb espais.
     *
     * @param title El text que s'ha d'ajustar.
     * @param width L'amplada total a la qual s'ha d'ajustar el text.
     * @param alignment L'alineació desitjada (`"left"`, `"right"`, o `"center"`). 
     *                  Si es proporciona un valor desconegut, per defecte serà `"center"`.
     * @return El text ajustat segons l'amplada i l'alineació especificades. 
     *         Si el text supera l'amplada, retorna el text retallat amb un `.` al final.
     * 
     * @test ./runTest.sh com.examen.TestExamen#testAlignTextLeft
     * @test ./runTest.sh com.examen.TestExamen#testAlignTextRight
     * @test ./runTest.sh com.examen.TestExamen#testAlignTextCenter
     * @test ./runTest.sh com.examen.TestExamen#testAlignTextTextLongerThanWidth
     * @test ./runTest.sh com.examen.TestExamen#testAlignTextExactWidth
     */
    static String alignText(String text, int width, String alignment) {
        int padding = width - text.length();
        if (text.length() > width) {
            return text.substring(0, width - 1) + ".";
        }
        switch (alignment.toLowerCase()) {
            case "left":
                return text + " ".repeat(padding);
            case "right":
                return " ".repeat(padding) + text;
            case "center":
            default:
                int leftPadding = padding / 2;
                int rightPadding = padding - leftPadding;
                return " ".repeat(leftPadding) + text + " ".repeat(rightPadding);
        }
    }

    /**
     * Llista totes les hipoteques ordenades segons un criteri específic.
     *
     * Aquesta funció mostra en format tabular totes les hipoteques de la llista global `mortgages`.
     * Permet ordenar-les basant-se en una propietat especificada (com "bank", "name", "payments", etc.).
     * Utilitza diferents criteris d'ordenació depenent del tipus de dades: numèric, data o text.
     *
     * Algorisme:
     * 0. Si la llista `mortgages` està buida:
     *    - Mostra un missatge indicant que no hi ha hipoteques disponibles.
     *    - Retorna de la funció.
     * 1. Ordena les hipoteques:
     *    - Si la propietat és un número (`Number`), les ordena numèricament.
     *    - Si la propietat és una data (`LocalDateTime`), les ordena cronològicament.
     *    - Si la propietat és text, les ordena alfabèticament.
     * 2. Defineix els encapçalaments de la taula, les amplades de les columnes i les alineacions.
     * 3. Imprimeix els encapçalaments centrats amb separadors de columnes.
     * 4. Dibuixa una línia separadora sota els encapçalaments.
     * 5. Itera sobre cada hipoteca de la llista i imprimeix els valors de cada columna:
     *    - Alinea i ajusta cada valor segons l'amplada i l'alineació de la columna.
     *    - Per als valors numèrics i les dates, aplica un format específic.
     * 6. Mostra un missatge indicant el criteri d'ordenació utilitzat.
     *
     * Missatges de sortida esperats:
     * - Si no hi ha hipoteques disponibles:
     *   - `No mortgages available.`
     * - Quan es mostren les hipoteques:
     *   - Imprimeix una taula amb els encapçalaments:
     *     - `|       Bank       |    Client    | Payments |   Value   | Interest  |   Total   |  Payment  |       Modified       |`
     *   - Dibuixa línies separadores entre els encapçalaments i les dades:
     *     - Exemple: `+----------------+-------------+----------+-----------+-----------+-----------+-----------+----------------------+`
     *   - Per a cada hipoteca, imprimeix una fila amb els valors corresponents alineats segons les columnes:
     *     - Exemple d'una fila: `| Bank ABC       | John Doe      |      12  |    1000.00 |     50.00 |   1050.00 |     87.50 | 2023-01-01T12:00:00 |`
     * - Quan finalitza la llista, indica el criteri d'ordenació utilitzat:
     *   - `Mortgages list sorted by: "[criteri]"`.
     *
     * Dades de "titols", "amplades" i "alineacions" de les columnes:
     *  String[] headers = {"Bank", "Client", "Payments", "Value", "Interest", "Total", "Payment", "Modified"};
     *  int[] columnWidths = {16, 12, 8, 10, 10, 10, 10, 21};
     *  String[] columnAligns = {"left", "left", "center", "right", "right", "right", "right", "center"};
     * 
     * Nota: Les alineacions només són per les dades, perquè els titols van tots centrats.
     * 
     * @param sortBy La propietat de les hipoteques per la qual s'han d'ordenar (com "bank", "name", "total", etc.).
     * 
     * @test ./runTest.sh com.examen.TestExamen#testListMortgagesEmpty
     * @test ./runTest.sh com.examen.TestExamen#testListMortgagesSortedByBank
     */
    static void listMortgages(String sortBy) {
   
        if (mortgages.isEmpty()) {
            System.out.println("No mortgages available.");
            return;
        }
    
        mortgages.sort((m1, m2) -> {
            Object val1 = m1.get(sortBy);
            Object val2 = m2.get(sortBy);
    
            if (val1 instanceof Number && val2 instanceof Number) {
                return Double.compare(((Number) val1).doubleValue(), ((Number) val2).doubleValue());
            } else {
                return val1.toString().compareTo(val2.toString());
            }
        });
        System.out.println("Mortgages list sorted by: \"" + sortBy + "\"");

        String[] headers = {"Bank", "Client", "Payments", "Value", "Interest", "Total", "Payment", "Modified"};
        int[] columnWidths = {16, 12, 8, 10, 10, 10, 10, 21};
        String[] columnAligns = {"left", "left", "center", "right", "right", "right", "right", "center"};
    
        // Print centered headers with column separators
        System.out.print("|");
        for (int i = 0; i < headers.length; i++) {
            System.out.print(alignText(headers[i], columnWidths[i], "center") + "|");
        }
        System.out.println();
    
        // Print separator line
        System.out.print("+");
        for (int width : columnWidths) {
            System.out.print("-".repeat(width) + "+");
        }
        System.out.println();
    
        // Print each mortgage row with column separators
        for (HashMap<String, Object> mortgage : mortgages) {
            System.out.print("|");
            System.out.print(alignText(mortgage.get("bank").toString(), columnWidths[0], columnAligns[0]) + "|");
            System.out.print(alignText(mortgage.get("name").toString(), columnWidths[1], columnAligns[1]) + "|");
            System.out.print(alignText(String.valueOf(Integer.parseInt(mortgage.get("payments").toString())), columnWidths[2], columnAligns[2]) + "|");
            System.out.print(alignText(String.format("%.2f", Double.parseDouble(mortgage.get("value").toString())), columnWidths[3], columnAligns[3]) + "|");
            System.out.print(alignText(String.format("%.2f", Double.parseDouble(mortgage.get("interest").toString())), columnWidths[4], columnAligns[4]) + "|");
            System.out.print(alignText(String.format("%.2f", Double.parseDouble(mortgage.get("total").toString())), columnWidths[5], columnAligns[5]) + "|");
            System.out.print(alignText(String.format("%.2f", Double.parseDouble(mortgage.get("payment").toString())), columnWidths[6], columnAligns[6]) + "|");
            System.out.print(alignText(mortgage.get("modified").toString(), columnWidths[7], columnAligns[7]) + "|");
            System.out.println();
        }
    }
}
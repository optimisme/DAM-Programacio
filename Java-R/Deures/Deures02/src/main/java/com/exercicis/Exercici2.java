package com.exercicis;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Exercici2 {

    static ArrayList<HashMap<String, Object>> mortgages = new ArrayList<>();
    
    public static boolean isTestEnvironment = false;

    /**
     * Quan tinguis totes les funcions llestes, 
     * executa el 'main' amb:
     * 
     * @run ./run.sh com.examen.Main
     * @test ./runTest.sh com.exercicis.TestExercici2#testMainOutput
     * 
     * Per passar tots els tests i saber la nota:
     * 
     * @test ./runTest.sh com.exercicis.TestExercici2
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
     * @test ./runTest.sh com.exercicis.TestExercici2#testGetHashMapSimpleObject
     * @test ./runTest.sh com.exercicis.TestExercici2#testGetHashMapEmptyObject
     */
    public static HashMap<String, Object> getHashMap(String jsonstr) {
        HashMap<String, Object> rst = new HashMap<>();
        return rst;
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
     * @test ./runTest.sh com.exercicis.TestExercici2#testGetArrayListSimpleArray
     * @test ./runTest.sh com.exercicis.TestExercici2#testGetArrayListEmptyArray
     */
    public static ArrayList<HashMap<String, Object>> getArrayList(String jsonstr) {
        ArrayList<HashMap<String, Object>> rst = new ArrayList<>();
        return rst;
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
     * @test ./runTest.sh com.exercicis.TestExercici2#testLoadMortgages
     */
    public static void loadMortgages(String fileName) throws IOException {

    }

    /**
     * Verifica si el nom d'un client és vàlid.
     *
     * El nom només pot contenir lletres de l'alfabet (amb accents inclosos) i espais.
     *
     * @param name Nom del client a verificar.
     * @return `true` si el nom és vàlid; `false` en cas contrari.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici2#testValidClientNameSimple
     * @test ./runTest.sh com.exercicis.TestExercici2#testValidClientNameWithAccents
     * @test ./runTest.sh com.exercicis.TestExercici2#testInvalidClientNameWithNumbers
     * @test ./runTest.sh com.exercicis.TestExercici2#testInvalidClientNameWithSpecialChars
     * @test ./runTest.sh com.exercicis.TestExercici2#testEmptyClientName
     */
    static boolean isValidClientName(String name) {
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
     * @test ./runTest.sh com.exercicis.TestExercici2#testValidBankNameSimple
     * @test ./runTest.sh com.exercicis.TestExercici2#testValidBankNameWithAccentsAndNumbers
     * @test ./runTest.sh com.exercicis.TestExercici2#testValidBankNameWithDash
     * @test ./runTest.sh com.exercicis.TestExercici2#testInvalidBankNameWithSpecialChars
     * @test ./runTest.sh com.exercicis.TestExercici2#testEmptyBankName
     */
    static boolean isValidBankName(String name) {
        return false;
    }

    /**
     * Verifica si el nombre de pagaments és vàlid.
     *
     * El nombre de pagaments ha de ser superior o igual a 5.
     *
     * @param payments Nombre de pagaments.
     * @return `true` si el nombre és vàlid; `false` en cas contrari.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici2#testValidPaymentsEqualToFive
     * @test ./runTest.sh com.exercicis.TestExercici2#testValidPaymentsGreaterThanFive
     * @test ./runTest.sh com.exercicis.TestExercici2#testInvalidPaymentsLessThanFive
     */
    public static boolean isValidPayments(int payments) {
        return false;
    }
    
    /**
     * Verifica si el valor d'una hipoteca és vàlid.
     *
     * El valor ha de ser superior a 50.000.
     *
     * @param value Valor de la hipoteca.
     * @return `true` si el valor és vàlid; `false` en cas contrari.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici2#testValidValueGreaterThan50000
     * @test ./runTest.sh com.exercicis.TestExercici2#testInvalidValueEqualTo50000
     * @test ./runTest.sh com.exercicis.TestExercici2#testInvalidValueLessThan50000
     */
    public static boolean isValidValue(double value) {
        return false;
    }

    /**
     * Determina si una cadena conté només dígits.
     *
     * Aquesta funció verifica si tots els caràcters d'una cadena són dígits numèrics.
     *
     * @param text Cadena a verificar.
     * @return `true` si només conté dígits; `false` en cas contrari.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici2#testIsAllDigitsWithOnlyDigits
     * @test ./runTest.sh com.exercicis.TestExercici2#testIsAllDigitsWithLetters
     * @test ./runTest.sh com.exercicis.TestExercici2#testIsAllDigitsWithEmptyString
     */
    private static boolean isAllDigits(String text) {
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
     * @test ./runTest.sh com.exercicis.TestExercici2#testValidDate
     * @test ./runTest.sh com.exercicis.TestExercici2#testInvalidDateNull
     * @test ./runTest.sh com.exercicis.TestExercici2#testInvalidDateWrongLength
     * @test ./runTest.sh com.exercicis.TestExercici2#testInvalidDateWrongFormatChars
     * @test ./runTest.sh com.exercicis.TestExercici2#testInvalidYearOutOfRange
     * @test ./runTest.sh com.exercicis.TestExercici2#testInvalidMonth
     * @test ./runTest.sh com.exercicis.TestExercici2#testInvalidDay
     * @test ./runTest.sh com.exercicis.TestExercici2#testInvalidDayInFebruaryNonLeap
     * @test ./runTest.sh com.exercicis.TestExercici2#testValidDateInFebruaryLeapYear
     * 
     * @test ./runTest.sh com.exercicis.TestExercici2#testValidTimeBoundaries
     * @test ./runTest.sh com.exercicis.TestExercici2#testInvalidHourTooHigh
     * @test ./runTest.sh com.exercicis.TestExercici2#testInvalidMinuteTooHigh
     * @test ./runTest.sh com.exercicis.TestExercici2#testInvalidSecondTooHigh
     */
    public static boolean isValidDate(String dateTime) {
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
     * @param text El text que s'ha d'ajustar.
     * @param width L'amplada total a la qual s'ha d'ajustar el text.
     * @param alignment L'alineació desitjada (`"left"`, `"right"`, o `"center"`). 
     *                  Si es proporciona un valor desconegut, per defecte serà `"center"`.
     * @return El text ajustat segons l'amplada i l'alineació especificades. 
     *         Si el text supera l'amplada, retorna el text retallat amb un `.` al final.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici2#testAlignTextLeft
     * @test ./runTest.sh com.exercicis.TestExercici2#testAlignTextRight
     * @test ./runTest.sh com.exercicis.TestExercici2#testAlignTextCenter
     * @test ./runTest.sh com.exercicis.TestExercici2#testAlignTextTextLongerThanWidth
     * @test ./runTest.sh com.exercicis.TestExercici2#testAlignTextExactWidth
     */
    static String alignText(String text, int width, String alignment) {
        return "";
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
     * @test ./runTest.sh com.exercicis.TestExercici2#testListMortgagesEmpty
     * @test ./runTest.sh com.exercicis.TestExercici2#testListMortgagesSortedByBank
     */
    static void listMortgages(String sortBy) {
   
    }
}
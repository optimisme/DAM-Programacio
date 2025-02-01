package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercici0201 {

    private static Scanner scanner;
    private static Locale defaultLocale;

    public static void main(String[] args) {
        
        scanner = new Scanner(System.in);
        defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);
        
        int[] arrEnters = generaArrayEnters(10);
        mostraArrayEstadistiques(arrEnters);

        ArrayList<Integer> lstEnters = generaLlistaEnters(10);
        mostraLlistaEstadistiques(lstEnters);

        filtraArrayParaulesAmbA();
        filtraLlistaParaulesAmbA();

        double[] arrDecimals = generaArrayDecimals(15);
        filtraArrayDecimalsSuperiors50(arrDecimals);

        ArrayList<Double> lstDecimals = generaLlistaDecimals(15);
        filtraLlistaDecimalsSuperiors50(lstDecimals);

        HashMap<String, Integer> persones = new HashMap<>();
        persones.put("Anna", 25);
        persones.put("Joan", 30);
        persones.put("Marc", 20);
        mostrarLlistaOrdenadesPerEdat(persones);

        mostrarFrecuenciaParaules();
        invertirMapaClauValor();
        fusionarMapesSumantValors();
        ordenarMapaPerClaus();
        calcularEstadistiquesNotesEstudiants();

        Locale.setDefault(defaultLocale);
        scanner.close();
    }

    /**
     * Genera un array d'enters aleatoris.
     *
     * @param mida la mida de l'array a generar
     * @return un array d'enters amb valors entre 0 i 99
     */
    public static int[] generaArrayEnters(int mida) {
        int[] array = new int[mida];
        Random r = new Random();
        for (int i = 0; i < mida; i++) {
            array[i] = r.nextInt(100);
        }
        return array;
    }

    /**
     * Calcula i mostra estadístiques d'un array d'enters.
     * 
     * Imprimeix per pantalla l'array, el valor màxim, el mínim i la mitjana.
     * Format d'output:
     * "Array: [valors]"
     * "Màxim: X  Mínim: Y  Mitjana: Z"
     * 
     *
     * @param array l'array d'enters sobre el qual calcular les estadístiques
     */
    public static void mostraArrayEstadistiques(int[] array) {
        int max = array[0], min = array[0], suma = 0;
        for (int n : array) {
            if (n > max)
                max = n;
            if (n < min)
                min = n;
            suma += n;
        }
        double mitjana = suma / (double) array.length;
        System.out.print("Array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Màxim: " + max + "  Mínim: " + min + "  Mitjana: " + mitjana);
    }

    /**
     * Genera una llista d'enters aleatoris.
     *
     * @param mida la mida de la llista a generar
     * @return una ArrayList d'enters amb valors entre 0 i 99
     */
    public static ArrayList<Integer> generaLlistaEnters(int mida) {
        ArrayList<Integer> llista = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < mida; i++) {
            llista.add(r.nextInt(100));
        }
        return llista;
    }

    /**
     * Calcula i mostra estadístiques d'una llista d'enters.
     * 
     * Imprimeix per pantalla la llista, el valor màxim, el mínim i la mitjana.
     * Format d'output:
     * "Llista: [valors]"
     * "Màxim: X  Mínim: Y  Mitjana: Z"
     * 
     *
     * @param llista la llista d'enters sobre la qual calcular les estadístiques
     */
    public static void mostraLlistaEstadistiques(ArrayList<Integer> llista) {
        int max = llista.get(0), min = llista.get(0), suma = 0;
        for (int n : llista) {
            if (n > max)
                max = n;
            if (n < min)
                min = n;
            suma += n;
        }
        double mitjana = suma / (double) llista.size();
        System.out.println("Llista: " + llista);
        System.out.println("Màxim: " + max + "  Mínim: " + min + "  Mitjana: " + mitjana);
    }

    /**
     * Demana a l'usuari que escrigui 5 paraules separades per ',' o ', ' 
     * i mostra aquelles que comencen amb 'a'.
     * 
     * Guarda la llista en un "String[] paraules"
     * 
     * Es mostra per pantalla:
     * "Escriu 5 paraules separades per ',' o ', ':" per sol·licitar les entrades,
     * i després "Paraules que comencen amb 'a':" seguit de les paraules filtrades.
     */
    public static void filtraArrayParaulesAmbA() {
        System.out.println("Escriu 5 paraules separades per ',' o ', ':");
        String input = scanner.nextLine();
        String[] paraules = input.replace(", ", ",").split(",");
        int count = 0;
        for (String p : paraules) {
            if (p.toLowerCase().startsWith("a"))
                count++;
        }
        String[] filtrades = new String[count];
        int index = 0;
        for (String p : paraules) {
            if (p.toLowerCase().startsWith("a")) {
                filtrades[index++] = p;
            }
        }
        String rst = String.join(", ", filtrades);
        System.out.println("Paraules que comencen amb 'a': " + rst);
    }
       
    /**
     * Demana a l'usuari que escrigui 5 paraules separades per ',' o ', ' 
     * i mostra aquelles que comencen amb 'a' en una sola línia separades per ", ".
     * 
     * Guarda la llista en un "ArrayList<String> paraules".
     * 
     * Es mostra per pantalla:
     * "Escriu 5 paraules separades per ',' o ', ':" per sol·licitar les entrades,
     * i després "Paraules que comencen amb 'a':" seguit de les paraules filtrades.
     */
    public static void filtraLlistaParaulesAmbA() {
        System.out.println("Escriu 5 paraules separades per ',' o ', ':");
        String input = scanner.nextLine();
        String[] paraulesArray = input.replace(", ", ",").split(",");
        ArrayList<String> paraules = new ArrayList<>(Arrays.asList(paraulesArray));
        ArrayList<String> filtrades = new ArrayList<>();
        for (String p : paraules) {
            if (p.toLowerCase().startsWith("a"))
                filtrades.add(p);
        }
        String rst = String.join(", ", filtrades);
        System.out.println("Paraules que comencen amb 'a': " + rst);
    }

    /**
     * Genera un array de decimals aleatoris.
     *
     * @param mida la mida de l'array a generar
     * @return un array de decimals amb valors entre 0.0 i 100.0
     */
    public static double[] generaArrayDecimals(int mida) {
        double[] array = new double[mida];
        Random r = new Random();
        for (int i = 0; i < mida; i++) {
            array[i] = r.nextDouble() * 100;
        }
        return array;
    }

    /**
     * Genera una llista de decimals aleatoris.
     *
     * @param mida la mida de la llista a generar
     * @return una ArrayList de decimals amb valors entre 0.0 i 100.0
     */
    public static ArrayList<Double> generaLlistaDecimals(int mida) {
        ArrayList<Double> llista = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < mida; i++) {
            llista.add(r.nextDouble() * 100);
        }
        return llista;
    }

    /**
     * Filtra i mostra els decimals superiors a 50 d'un array.
     * 
     * Imprimeix per pantalla l'array original de decimals i, a continuació,
     * la llista dels decimals que són majors que 50.
     * Format d'output:
     * "Array original: [valors]"
     * "Valors majors que 50: [valors filtrats]"
     * 
     *
     * @param decimals l'array de decimals a filtrar
     */
    public static void filtraArrayDecimalsSuperiors50(double[] decimals) {
        System.out.print("Array original: [");
        for (int i = 0; i < decimals.length; i++) {
            System.out.printf("%.2f", decimals[i]);
            if (i < decimals.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    
        int count = 0;
        for (double d : decimals) {
            if (d > 50)
                count++;
        }
        double[] filtrats = new double[count];
        int index = 0;
        for (double d : decimals) {
            if (d > 50) {
                filtrats[index++] = d;
            }
        }
        System.out.print("Valors majors que 50: [");
        for (int i = 0; i < filtrats.length; i++) {
            System.out.printf("%.2f", filtrats[i]);
            if (i < filtrats.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }   

    /**
     * Filtra i mostra els decimals superiors a 50 d'una llista.
     * 
     * Imprimeix per pantalla la llista original de decimals i, a continuació,
     * la llista dels decimals que són majors que 50.
     * Format d'output:
     * "Llista original: [valors]"
     * "Valors majors que 50: [valors filtrats]"
     *
     * @param decimals la llista de decimals a filtrar
     */
    public static void filtraLlistaDecimalsSuperiors50(ArrayList<Double> decimals) {
        String original = "[";
        for (int i = 0; i < decimals.size(); i++) {
            original += String.format("%.2f", decimals.get(i));
            if (i < decimals.size() - 1)
                original += ", ";
        }
        original += "]";
        System.out.println("Llista original: " + original);
        
        ArrayList<Double> filtrats = new ArrayList<>();
        for (Double d : decimals) {
            if (d > 50)
                filtrats.add(d);
        }
        
        String filtratsStr = "[";
        for (int i = 0; i < filtrats.size(); i++) {
            filtratsStr += String.format("%.2f", filtrats.get(i));
            if (i < filtrats.size() - 1)
                filtratsStr += ", ";
        }
        filtratsStr += "]";
        System.out.println("Valors majors que 50: " + filtratsStr);
    }
    
    /**
     * Mostra per pantalla les persones ordenades per edat.
     * 
     * Recorre un HashMap de persones (nom i edat) i imprimeix cada persona en format "Nom (Edat)"
     * ordenat per edat de manera ascendent.
     *
     * @param persones un HashMap on la clau és el nom de la persona i el valor és la seva edat
     */
    public static void mostrarLlistaOrdenadesPerEdat(HashMap<String, Integer> persones) {
        ArrayList<String> keys = new ArrayList<>(persones.keySet());
        keys.sort((k1, k2) -> persones.get(k1).compareTo(persones.get(k2)));
        for (String key : keys) {
            System.out.println(key + " (" + persones.get(key) + ")");
        }
    }

    /**
     * Demana a l'usuari que introdueixi una frase i mostra la freqüència de cada paraula.
     * 
     * L'usuari escriu una frase per la consola i el mètode separa les paraules usant els espais.
     * A continuació, es calcula la freqüència de cada paraula i es mostra per pantalla en format de HashMap.
     * 
     * 
     * Es mostra per pantalla:
     * "Introdueix una frase:" i després "Freqüència de paraules: {paraula=frequencia, ...}".
     */
    public static void mostrarFrecuenciaParaules() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix una frase:");
        String frase = sc.nextLine();
        String[] paraules = frase.split("\\s+");
        HashMap<String, Integer> freq = new HashMap<>();
        for (String p : paraules) {
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }
        System.out.println("Freqüència de paraules: " + freq);
    }

    /**
     * Inverteix un HashMap intercanviant claus i valors.
     * 
     * Es crea un HashMap amb elements (A=1, B=2, C=3) i es construeix un nou HashMap on cada valor 
     * es converteix en clau i cada clau es converteix en valor.
     * 
     * 
     * Es mostra per pantalla:
     * "Mapa original: {A=1, B=2, C=3}" i "Mapa invertit: {1=A, 2=B, 3=C}".
     */
    public static void invertirMapaClauValor() {
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("A", 1);
        mapa.put("B", 2);
        mapa.put("C", 3);
        HashMap<Integer, String> invertit = new HashMap<>();
        for (Map.Entry<String, Integer> e : mapa.entrySet()) {
            invertit.put(e.getValue(), e.getKey());
        }
        System.out.println("Mapa original: " + mapa);
        System.out.println("Mapa invertit: " + invertit);
    }

    /**
     * Fusiona dos HashMap sumant els valors de les claus comuns.
     * 
     * Es defineixen dos mapes:
     * <ul>
     *   <li>Mapa 1: {X=10, Y=20}</li>
     *   <li>Mapa 2: {Y=5, Z=15}</li>
     * </ul>
     * El mètode crea un nou HashMap on, per cada clau existent en ambdós mapes, es suma el valor.
     * 
     * 
     * Es mostra per pantalla:
     * "Mapa fusionat: {X=10, Y=25, Z=15}".
     */
    public static void fusionarMapesSumantValors() {
        HashMap<String, Integer> mapa1 = new HashMap<>();
        mapa1.put("X", 10);
        mapa1.put("Y", 20);
        HashMap<String, Integer> mapa2 = new HashMap<>();
        mapa2.put("Y", 5);
        mapa2.put("Z", 15);
        HashMap<String, Integer> fusionat = new HashMap<>(mapa1);
        for (Map.Entry<String, Integer> e : mapa2.entrySet()) {
            fusionat.put(e.getKey(), fusionat.getOrDefault(e.getKey(), 0) + e.getValue());
        }
        System.out.println("Mapa fusionat: " + fusionat);
    }

    /**
     * Ordena un HashMap per les claus mitjançant un TreeMap i mostra el resultat.
     * 
     * Es crea un HashMap amb elements (Banana=3, Poma=5, Taronja=2) i es transfereix a un TreeMap
     * per obtenir un ordre natural de les claus (alfabètic).
     * 
     * 
     * Es mostra per pantalla:
     * "Mapa ordenat per claus: {Banana=3, Poma=5, Taronja=2}".
     */
    public static void ordenarMapaPerClaus() {
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("Banana", 3);
        mapa.put("Poma", 5);
        mapa.put("Taronja", 2);
        TreeMap<String, Integer> ordenat = new TreeMap<>(mapa);
        System.out.println("Mapa ordenat per claus: " + ordenat);
    }

    /**
     * Calcula i mostra les estadístiques (mitjana, màxim i mínim) de les notes dels estudiants.
     * 
     * Es defineix un HashMap on la clau és el nom de l'estudiant i el valor la seva nota.
     * El mètode calcula la mitjana, la nota màxima i la nota mínima i les mostra per pantalla.
     * 
     * 
     * Es mostra per pantalla:
     * "Mitjana: [valor], Màxim: [valor], Mínim: [valor]".
     */
    public static void calcularEstadistiquesNotesEstudiants() {
        HashMap<String, Double> estudiants = new HashMap<>();
        estudiants.put("Anna", 8.5);
        estudiants.put("Joan", 6.0);
        estudiants.put("Marc", 7.5);
        double suma = 0, max = Double.MIN_VALUE, min = Double.MAX_VALUE;
        for (double nota : estudiants.values()) {
            suma += nota;
            if (nota > max) max = nota;
            if (nota < min) min = nota;
        }
        double mitjana = suma / estudiants.size();
        System.out.println("Mitjana: " + mitjana + ", Màxim: " + max + ", Mínim: " + min);
    }
}

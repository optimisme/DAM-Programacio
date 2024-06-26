package com.project;

public class Main {

    public static int conta_majuscules(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }

    public static int conta_minuscules(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLowerCase(c)) {
                count++;
            }
        }
        return count;
    }

    public static String validaContrasenya(String contrasenya) {
        if (contrasenya.length() >= 8 && conta_majuscules(contrasenya) >= 2 && conta_minuscules(contrasenya) >= 2) {
            return "La contrasenya és vàlida";
        }
        return "La contrasenya NO és vàlida";
    }

    public static void main(String[] args) {
        String[] contrasenyes = {
            "PassWord123",
            "password",
            "PASSWORD",
            "Pass12",
            "PassWord",
            "ValidPass123",
            "AnotherValid1"
        };

        for (String contrasenya : contrasenyes) {
            String resultat = validaContrasenya(contrasenya);
            System.out.println("La contrasenya '" + contrasenya + "': " + resultat);
        }
    }
}

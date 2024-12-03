package com.exemple0801;

public class Main {

    public static void main(String[] args) {
        try {
            int[] nums = {1, 2, 3};

            System.out.println(nums[5]);

            int result = 10 / 0;

        } catch (ArithmeticException e) {
            // Bloc per divisions per 0
            System.out.println("Error: Divisió per zero.");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Bloc per crides fora de rang
            System.out.println("Error: Índex fora de rang.");
        } catch (Exception e) {
            // Bloc per excepcions desconegudes
            System.out.println("Error desconegut: " + e.getMessage());
        } finally {
            System.out.println("Bloc finally executat. Aquí pots alliberar recursos.");
        }
    }
}
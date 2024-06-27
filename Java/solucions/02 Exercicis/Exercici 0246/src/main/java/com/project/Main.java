package com.project;

public class Main {

    public static void main(String[] args) {
        StringBuilder table = new StringBuilder();
        table.append(generateRow(1, 1, 10)).append("\n");
        table.append(generateRow(2, 2, 10)).append("\n");
        table.append(generateRow(20, 2, 10)).append("\n");
        table.append(generateRow(10, 4, 10)).append("\n");
        table.append(generateRow(40, -5, 10));

        System.out.println(table.toString());
    }

    public static String generateRow(int start, int step, int count) {
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < count; i++) {
            row.append(String.format("%-5d", start + (i * step)));
        }
        return row.toString().stripTrailing();
    }
}

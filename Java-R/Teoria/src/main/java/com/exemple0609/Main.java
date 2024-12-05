package com.exemple0609;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static HashMap<String, Object> createStudent(String name, int age) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        return map;
    }

    public static void showInformation(ArrayList<HashMap<String, Object>> students) {
        for (HashMap<String, Object> student : students) {
            System.out.println("Name: " + student.get("name") + ", " + student.get("age") + " years");
        }
    }

    public static void main(String[] args) {
        ArrayList<HashMap<String, Object>> students = new ArrayList<>();

        students.add(createStudent("Anna", 18));
        students.add(createStudent("Marcos", 19));
        students.add(createStudent("Eva", 17));
        students.add(createStudent("Zahir", 18));

        // Fer la còpia per no modificar l'original
        ArrayList<HashMap<String, Object>> studentsByName = new ArrayList<>(students);
        studentsByName.sort((student1, student2) -> {
            String a = (String) student1.get("name");
            String b = (String) student2.get("name");
            return a.compareTo(b);
        });

        // Fer la còpia per no modificar l'original
        ArrayList<HashMap<String, Object>> studentsByAge = new ArrayList<>(students);
        studentsByAge.sort((student1, student2) -> {
            Integer a = (Integer) student1.get("age");
            Integer b = (Integer) student2.get("age");
            return a.compareTo(b);
        });

        System.out.println("Original List:");
        showInformation(students);

        System.out.println("-".repeat(25));
        System.out.println("Sorted by Name:");
        showInformation(studentsByName);

        System.out.println("-".repeat(25));
        System.out.println("Sorted by Age:");
        showInformation(studentsByAge);
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author busrasahin
 */

import model.Student;
import util.InputValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Management System:");
            System.out.println("1. Add a new student");
            System.out.println("2. Display all students");
            System.out.println("3. Search for a student by ID");
            System.out.println("4. Update a student's GPA");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent(scanner);
                case 2 -> displayStudents();
                case 3 -> searchStudent(scanner);
                case 4 -> updateGPA(scanner);
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID (S-XXXX): ");
        String id = scanner.next();
        if (!InputValidator.isValidId(id)) {
            System.out.println("Invalid ID format. Try again.");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.next();
        if (InputValidator.isBlank(name)) {
            System.out.println("Name cannot be blank. Try again.");
            return;
        }

        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Student GPA (0.0 - 4.0): ");
        double gpa = scanner.nextDouble();
        if (!InputValidator.isValidGPA(gpa)) {
            System.out.println("Invalid GPA. Try again.");
            return;
        }

        students.add(new Student(id, name, age, gpa));
        System.out.println("Student added successfully!");
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String id = scanner.next();

        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void updateGPA(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String id = scanner.next();

        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.print("Enter new GPA (0.0 - 4.0): ");
                double gpa = scanner.nextDouble();
                if (!InputValidator.isValidGPA(gpa)) {
                    System.out.println("Invalid GPA. Try again.");
                    return;
                }
                student.setGpa(gpa);
                System.out.println("GPA updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}

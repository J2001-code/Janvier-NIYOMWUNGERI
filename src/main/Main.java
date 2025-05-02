package main;

import java.util.Scanner;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Merged three projects =====");
            System.out.println("1. Mission Management System");
            System.out.println("2. Land Management System");
            System.out.println("3. Nursery Management System");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    try {
                        mission.Main.main(null); // Call mission system
                    } catch (ParseException e) {
                        System.out.println("Mission system failed: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        land.Main.main(null); // Call land system
                    } catch (Exception e) {
                        System.out.println("Land system failed: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        nursery.Main.main(null); // Call nursery system
                    } catch (Exception e) {
                        System.out.println("Nursery system failed: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        } while (choice != 0);
    }
}

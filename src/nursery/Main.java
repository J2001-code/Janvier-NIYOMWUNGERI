package nursery;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize classes
        BabyClass babyClass = new BabyClass("BC001");
        MiddleClass middleClass = new MiddleClass("MC001");
        TopClass topClass = new TopClass("TC001");

        Map<String, Teacher> teacherMap = new HashMap<>();
        Map<String, Student> studentMap = new HashMap<>();

        while (true) {
            System.out.println("\n--- Nursery School Management ---");
            System.out.println("1. Add Teacher");
            System.out.println("2. Assign Teacher to Class");
            System.out.println("3. Add Student");
            System.out.println("4. Enroll Student to Class");
            System.out.println("5. Conduct Activity");
            System.out.println("6. Generate Class Report");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Teacher ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Role: ");
                        String role = scanner.nextLine();
                        Teacher t = new Teacher(id, name, role);
                        teacherMap.put(id, t);
                        System.out.println("Teacher added.");
                    }

                    case 2 -> {
                        System.out.print("Enter Teacher ID: ");
                        String id = scanner.nextLine();
                        Teacher t = teacherMap.get(id);
                        if (t == null) throw new Exception("Teacher not found.");
                        System.out.print("Assign to (baby/middle/top): ");
                        String classType = scanner.nextLine();
                        switch (classType.toLowerCase()) {
                            case "baby" -> babyClass.assignTeacher(t);
                            case "middle" -> middleClass.assignTeacher(t);
                            case "top" -> topClass.assignTeacher(t);
                            default -> throw new Exception("Invalid class type.");
                        }
                        System.out.println("Teacher assigned.");
                    }

                    case 3 -> {
                        System.out.print("Student ID: ");
                        String id = scanner.nextLine();
                        if (studentMap.containsKey(id)) throw new Exception("Duplicate student ID.");
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Age: ");
                        int age = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Guardian Name: ");
                        String guardian = scanner.nextLine();
                        Student s = new Student(id, name, age, guardian);
                        studentMap.put(id, s);
                        System.out.println("Student added.");
                    }

                    case 4 -> {
                        System.out.print("Enter Student ID: ");
                        String id = scanner.nextLine();
                        Student s = studentMap.get(id);
                        if (s == null) throw new Exception("Student not found.");
                        System.out.print("Enroll to (baby/middle/top): ");
                        String classType = scanner.nextLine();
                        switch (classType.toLowerCase()) {
                            case "baby" -> babyClass.enrollStudent(s);
                            case "middle" -> middleClass.enrollStudent(s);
                            case "top" -> topClass.enrollStudent(s);
                            default -> throw new Exception("Invalid class type.");
                        }
                        System.out.println("Student enrolled.");
                    }

                    case 5 -> {
                        System.out.print("Which class (baby/middle/top): ");
                        String classType = scanner.nextLine();
                        System.out.print("Activity name: ");
                        String activity = scanner.nextLine();
                        switch (classType.toLowerCase()) {
                            case "baby" -> babyClass.conductActivity(activity);
                            case "middle" -> middleClass.conductActivity(activity);
                            case "top" -> topClass.conductActivity(activity);
                            default -> throw new Exception("Invalid class type.");
                        }
                    }

                    case 6 -> {
                        System.out.print("Which class report (baby/middle/top): ");
                        String classType = scanner.nextLine();
                        switch (classType.toLowerCase()) {
                            case "baby" -> babyClass.generateClassReport();
                            case "middle" -> middleClass.generateClassReport();
                            case "top" -> topClass.generateClassReport();
                            default -> throw new Exception("Invalid class type.");
                        }
                    }

                    case 0 -> {
                        System.out.println("Exiting system. Goodbye!");
                        scanner.close();
                        return;
                    }

                    default -> System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

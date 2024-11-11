package Array;

// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("--- Student Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Students");
            System.out.println("5. Sort Students by Age (Bubble Sort)");
            System.out.println("6. Sort Students by Marks (Insertion Sort)");
            System.out.println("7. Search Students by Name (Linear Search)");
            System.out.println("8. Search Students by Age (Binary Search)");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student marks: ");
                    double marks = scanner.nextDouble();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    manager.addStudent(new Student(id, name, marks, age));
                    System.out.println("Student added.");
                    break;
                case 2:
                    System.out.print("Enter student ID to update: ");
                    id = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new marks: ");
                    marks = scanner.nextDouble();
                    System.out.print("Enter new age: ");
                    age = scanner.nextInt();
                    manager.editStudent(id, name, marks, age);
                    System.out.println("Student updated.");
                    break;
                case 3:
                    System.out.print("Enter student ID to delete: ");
                    id = scanner.nextLine();
                    manager.deleteStudent(id);
                    System.out.println("Student deleted.");
                    break;
                case 4:
                    System.out.println("Student List:");
                    manager.displayStudents();
                    break;
                case 5:
                    manager.bubbleSortByAge();
                    System.out.println("Students sorted by age.");
                    break;
                case 6:
                    manager.insertionSortByMarks();
                    System.out.println("Students sorted by marks.");
                    break;
                case 7:
                    System.out.print("Enter student name to search: ");
                    name = scanner.nextLine();
                    Student student = manager.linearSearchByName(name);
                    if (student != null) {
                        System.out.println("Found: " + student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 8:
                    System.out.print("Enter student age to search: ");
                    age = scanner.nextInt();
                    student = manager.binarySearchByAge(age);
                    if (student != null) {
                        System.out.println("Found: " + student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println();
        }
        scanner.close();
    }
}

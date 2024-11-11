package Array;

// StudentManager.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // thêm sinh viên
    public void addStudent(Student student) {
        students.add(student);
    }


    // sửa sinh viên 
    public void editStudent(String id, String newName, double newMarks, int newAge) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                student.setAge(newAge);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    //delete sinh viên
    public void deleteStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    // show sinh viên 
    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }


    //so sánh bằng bubbleSort cho age
    public void bubbleSortByAge() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getAge() > students.get(j + 1).getAge()) {
                    Collections.swap(students, j, j + 1);
                }
            }
        }
    }

    // so sánh bằng insertionSort cho mark
    public void insertionSortByMarks() {
        for (int i = 1; i < students.size(); i++) {
            Student key = students.get(i);
            int j = i - 1;
            while (j >= 0 && students.get(j).getMarks() > key.getMarks()) {
                students.set(j + 1, students.get(j));
                j = j - 1;
            }
            students.set(j + 1, key);
        }
    }

    public Student linearSearchByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    public Student binarySearchByAge(int age) {
        bubbleSortByAge(); // Ensure sorted order before binary search
        int left = 0, right = students.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (students.get(mid).getAge() == age) {
                return students.get(mid);
            }
            if (students.get(mid).getAge() < age) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

import java.util.*;
//import java.util.stream.*;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + marks;
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(1, "Riya", 85.5),
                new Student(2, "Aman", 72.3),
                new Student(3, "Priya", 90.2),
                new Student(4, "Raj", 60.0));

        System.out.println("=== Students with marks > 75 ===");
        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparing(Student::getMarks).reversed())
                .forEach(System.out::println);
    }
}

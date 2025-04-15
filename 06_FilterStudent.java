import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class StudentFilterSorter {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85.5));
        students.add(new Student("Bob", 72.0));
        students.add(new Student("Charlie", 90.0));
        students.add(new Student("David", 65.0));
        students.add(new Student("Eve", 78.0));

        System.out.println("Students scoring above 75% sorted by marks:");

        List<String> filteredSortedStudentNames = students.stream()
                .filter(student -> student.getMarks() > 75) // Filter students with marks > 75
                .sorted(Comparator.comparingDouble(Student::getMarks)) // Sort by marks
                .map(Student::getName) // Get names of the filtered students
                .collect(Collectors.toList()); // Collect results into a list

        // Display the names of the filtered and sorted students
        filteredSortedStudentNames.forEach(System.out::println);
    }
}
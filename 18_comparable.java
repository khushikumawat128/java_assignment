import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SortingExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "khushi", 85.2));
        students.add(new Student(2, "disha", 92.5));
        students.add(new Student(3, "Chetan", 78.9));

        Collections.sort(students);

        // Printing sorted students
        System.out.println("Students sorted by percentage:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
